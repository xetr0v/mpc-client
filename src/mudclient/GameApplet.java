package mudclient;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

@SuppressWarnings("serial")
public class GameApplet extends Applet
    implements Runnable {

    protected void loadGame() {
    }

    protected synchronized void checkInputs() {
    }

    protected void close() {
    }

    protected synchronized void drawWindow() {
    }

    protected final void flc(int width, int height, String title, boolean resizable) {
        inBrowser = false;
        System.out.println("Started application");
        appletWidth = width;
        appletHeight = height;
        gameFrame = new GameFrame(this, width, height, title, resizable, false);
        gameLoadingScreen = 1;
        gameWindowThread = new Thread(this);
        gameWindowThread.start();
        gameWindowThread.setPriority(1);
    }

    protected final boolean inBrowser() {
        return inBrowser;
    }

    protected final void setRefreshRate(int i) {
        refreshRate = 1000 / i;
    }

    protected final void resetTimings() {
        for(int i = 0; i < 10; i++)
            timeArray[i] = 0L;

    }

    public final synchronized boolean keyDown(Event evt, int key) {
        handleKeyDown(key);
        //lastActionTimeout = 0;
        if(key == 1006)
            keyLeftDown = true;
        if(key == 1007)
            keyRightDown = true;
        if(key == 1004)
            keyUpDown = true;
        if(key == 1005)
            keyDownDown = true;
        if((char)key == ' ')
            keySpaceDown = true;
        if((char)key == 'n' || (char)key == 'm')
            keyNMDown = true;
        if((char)key == 'N' || (char)key == 'M')
            keyNMDown = true;
        if((char)key == '{')
            keyLeftBraceDown = true;
        if((char)key == '}')
            keyRightBraceDown = true;
        if((char)key == '\u03F0')
            keyF1Toggle = !keyF1Toggle;
        boolean flag = false;
        for(int i = 0; i < allowedChars.length(); i++) {
            if(key != allowedChars.charAt(i))
                continue;
            flag = true;
            break;
        }

        if(flag && inputText.length() < 20)
            inputText += (char)key;
        if(flag && pmText.length() < 80)
            pmText += (char)key;
        if(key == 8 && inputText.length() > 0)
            inputText = inputText.substring(0, inputText.length() - 1);
        if(key == 8 && pmText.length() > 0)
            pmText = pmText.substring(0, pmText.length() - 1);
        if(key == 10 || key == 13) {
            enteredInputText = inputText;
            enteredPMText = pmText;
        }
        return true;
    }

    protected void handleKeyDown(int i) {
    }

    public final synchronized boolean keyUp(Event evt, int key) {
        if(key == 1006)
            keyLeftDown = false;
        if(key == 1007)
            keyRightDown = false;
        if(key == 1004)
            keyUpDown = false;
        if(key == 1005)
            keyDownDown = false;
        if((char)key == ' ')
            keySpaceDown = false;
        if((char)key == 'n' || (char)key == 'm')
            keyNMDown = false;
        if((char)key == 'N' || (char)key == 'M')
            keyNMDown = false;
        if((char)key == '{')
            keyLeftBraceDown = false;
        if((char)key == '}')
            keyRightBraceDown = false;
        return true;
    }

    public final synchronized boolean mouseMove(Event evt, int i, int k) {
        mouseX = i;
        mouseY = k + mouseYOffset;
        mouseButton = 0;
        return true;
    }

    public final synchronized boolean mouseUp(Event evt, int i, int k) {
        mouseX = i;
        mouseY = k + mouseYOffset;
        mouseButton = 0;
        return true;
    }

    public final synchronized boolean mouseDown(Event evt, int x, int y) {
        mouseX = x;
        mouseY = y + mouseYOffset;
        mouseButton = evt.metaDown() ? 2 : 1;
        lastMouseButton = mouseButton;
        handleMouseDown(mouseButton, x, y);
        return true;
    }

    protected void handleMouseDown(int i, int k, int l) {
    }

    public final synchronized boolean mouseDrag(Event evt, int x, int y) {
        mouseX = x;
        mouseY = y + mouseYOffset;
        mouseButton = evt.metaDown() ? 2 : 1;
        return true;
    }

    public final void init() {
        inBrowser = true;
        System.out.println("Started applet");
        appletWidth = 512;
        appletHeight = 344;
        gameLoadingScreen = 1;
        DataOperations.codeBase = getCodeBase();
        startThread(this);
    }

    public final void start() {
        if(runStatus >= 0)
            runStatus = 0;
    }

    public final void stop() {
        if(runStatus >= 0)
            runStatus = 4000 / refreshRate;
    }

    @SuppressWarnings("deprecation")
    public final void destroy() {
        runStatus = -1;
        try {
            Thread.sleep(1000L);
        }
        catch(Exception _ex) { }
        if(runStatus == -1) {
            System.out.println("2 seconds expired, forcing kill");
            closeProgram();
            if(gameWindowThread != null) {
                gameWindowThread.stop();
                gameWindowThread = null;
            }
        }
    }

    private final void closeProgram() {
        runStatus = -2;
        System.out.println("Closing program");
        close();
        try {
            Thread.sleep(1000L);
        }
        catch(Exception _ex) { }
        if(gameFrame != null)
            gameFrame.dispose();
        if(!inBrowser)
            System.exit(0);
    }

    public final void run() {
        if(gameLoadingScreen == 1) {
            gameLoadingScreen = 2;
            graphics = getGraphics();
            loadLoadingScreen();
            drawLoadingScreen(0, "Loading...");
            loadGame();
            gameLoadingScreen = 0;
        }
        int i = 0;
        int k = 256;
        int sleepTime = 1;
        int j1 = 0;
        for(int k1 = 0; k1 < 10; k1++)
            timeArray[k1] = System.currentTimeMillis();

        while(runStatus >= 0)  {
            if(runStatus > 0) {
                runStatus--;
                if(runStatus == 0) {
                    closeProgram();
                    gameWindowThread = null;
                    return;
                }
            }
            int i2 = k;
            int j2 = sleepTime;
            k = 300;
            sleepTime = 1;
            long l1 = System.currentTimeMillis();
            if(timeArray[i] == 0L) {
                k = i2;
                sleepTime = j2;
            } else
            if(l1 > timeArray[i])
                k = (int)((long)(2560 * refreshRate) / (l1 - timeArray[i]));
            if(k < 25)
                k = 25;
            if(k > 256) {
                k = 256;
                sleepTime = (int)((long)refreshRate - (l1 - timeArray[i]) / 10L);
                if(sleepTime < gameMinThreadSleepTime)
                    sleepTime = gameMinThreadSleepTime;
            }
            try {
                Thread.sleep(sleepTime);
            }
            catch(InterruptedException _ex) { }
            timeArray[i] = l1;
            i = (i + 1) % 10;
            if(sleepTime > 1) {
                for(int k2 = 0; k2 < 10; k2++)
                    if(timeArray[k2] != 0L)
                        timeArray[k2] += sleepTime;

            }
            int l2 = 0;
            while(j1 < 256)  {
                checkInputs();
                j1 += k;
                if(++l2 > fie) {
                    j1 = 0;
                    fij += 6;
                    if(fij > 25) {
                        fij = 0;
                        keyF1Toggle = true;
                    }
                    break;
                }
            }
            fij--;
            j1 &= 0xff;
            drawWindow();
        }
        if(runStatus == -1)
            closeProgram();
        gameWindowThread = null;
    }

    public final void update(Graphics g1) {
        paint(g1);
    }

    public final void paint(Graphics g1) {
        if(gameLoadingScreen == 2) {
            drawLoadingScreen(gameLoadingPercentage, gameLoadingFileTitle);
            return;
        }
    }

    private final void loadLoadingScreen() {
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, appletWidth, appletHeight);
        byte bytes[] = unpackData("fonts.jag", "Game fonts", 0);
        GameImage.addFont(DataOperations.loadData("h11p.jf", 0, bytes));
        GameImage.addFont(DataOperations.loadData("h12b.jf", 0, bytes));
        GameImage.addFont(DataOperations.loadData("h12p.jf", 0, bytes));
        GameImage.addFont(DataOperations.loadData("h13b.jf", 0, bytes));
        GameImage.addFont(DataOperations.loadData("h14b.jf", 0, bytes));
        GameImage.addFont(DataOperations.loadData("h16b.jf", 0, bytes));
        GameImage.addFont(DataOperations.loadData("h20b.jf", 0, bytes));
        GameImage.addFont(DataOperations.loadData("h24b.jf", 0, bytes));
    }

    private final void drawLoadingScreen(int percentage, String fileTitle) {
        if(bgImage != null)
            graphics.drawImage(bgImage, 0, 0, null);
        try {
            int i = (appletWidth - 281) / 2;
            int k = (appletHeight - 148) / 2;
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, appletWidth, appletHeight);
            i += 2;
            k += 90;
            gameLoadingPercentage = percentage;
            gameLoadingFileTitle = fileTitle;
            graphics.setColor(new Color(132, 132, 132));
            graphics.drawRect(i - 2, k - 2, 280, 23);
            graphics.fillRect(i, k, (277 * percentage) / 100, 20);
            graphics.setColor(new Color(198, 198, 198));
            drawString(graphics, fileTitle, gameLoadingFont, i + 138, k + 10);
        }
        catch(Exception _ex) { }
    }

    protected final void drawLoadingBarText(int i, String s) {
        try {
            int k = (appletWidth - 281) / 2;
            int l = (appletHeight - 148) / 2;
            k += 2;
            l += 90;
            gameLoadingPercentage = i;
            gameLoadingFileTitle = s;
            int i1 = (277 * i) / 100;
            graphics.setColor(new Color(132, 132, 132));
            graphics.fillRect(k, l, i1, 20);
            graphics.setColor(Color.black);
            graphics.fillRect(k + i1, l, 277 - i1, 20);
            graphics.setColor(new Color(198, 198, 198));
            drawString(graphics, s, gameLoadingFont, k + 138, l + 10);
            return;
        }
        catch(Exception _ex) {
            return;
        }
    }

    protected final void drawString(Graphics arg0, String arg1, Font arg2, int arg3, int arg4) {
        Object obj;
        if(gameFrame == null)
            obj = this;
        else
            obj = gameFrame;
        FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(arg2);
        fontmetrics.stringWidth(arg1);
        arg0.setFont(arg2);
        arg0.drawString(arg1, arg3 - fontmetrics.stringWidth(arg1) / 2, arg4 + fontmetrics.getHeight() / 4);
    }

    protected byte[] unpackData(String filename, String fileTitle, int startPercentage) {
        System.out.println("Using default load");
        int i = 0;
        int k = 0;
        byte abyte0[] = null;
        try {
            drawLoadingBarText(startPercentage, "Loading " + fileTitle + " - 0%");
            java.io.InputStream inputstream = DataOperations.openInputStream(filename);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte abyte2[] = new byte[6];
            datainputstream.readFully(abyte2, 0, 6);
            i = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
            k = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
            drawLoadingBarText(startPercentage, "Loading " + fileTitle + " - 5%");
            int l = 0;
            abyte0 = new byte[k];
            while(l < k)  {
                int i1 = k - l;
                if(i1 > 1000)
                    i1 = 1000;
                datainputstream.readFully(abyte0, l, i1);
                l += i1;
                drawLoadingBarText(startPercentage, "Loading " + fileTitle + " - " + (5 + (l * 95) / k) + "%");
            }
            datainputstream.close();
        }
        catch(IOException _ex) { }
        drawLoadingBarText(startPercentage, "Unpacking " + fileTitle);
        if(k != i) {
            byte abyte1[] = new byte[i];
            DataFileDecrypter.unpackData(abyte1, i, abyte0, k, 0);
            return abyte1;
        } else {
            return abyte0;
        }
    }

    public Graphics getGraphics() {
        if(gameFrame != null)
            return gameFrame.getGraphics();
        else
            return super.getGraphics();
    }

    public Image createImage(int i, int k) {
        if(gameFrame != null)
            return gameFrame.createImage(i, k);
        else
            return super.createImage(i, k);
    }

    public URL getCodeBase() {
        return super.getCodeBase();
    }

    public URL getDocumentBase() {
        return super.getDocumentBase();
    }

    public String getParameter(String s) {
        return super.getParameter(s);
    }

    protected Socket makeSocket(String arg0, int arg1)
        throws IOException {
        Socket socket;
        if(inBrowser())
            socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), arg1);
        else
            socket = new Socket(InetAddress.getByName(arg0), arg1);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    protected void startThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }
    
    public void mouseScroll(boolean begin, int arg) {
        System.out.println("mouseWheel(" + begin + ", " + arg + ")");
    }

    public GameApplet() {
        appletWidth = 512;
        appletHeight = 384;
        refreshRate = 20;
        fie = 1000;
        timeArray = new long[10];
        gameLoadingScreen = 1;
        gameLoadingFileTitle = "Loading";
        gameLoadingFont = new Font("TimesRoman", 0, 15);
        keyLeftBraceDown = false;
        keyRightBraceDown = false;
        keyLeftDown = false;
        keyRightDown = false;
        keyUpDown = false;
        keyDownDown = false;
        keySpaceDown = false;
        keyNMDown = false;
        gameMinThreadSleepTime = 1;
        keyF1Toggle = false;
        inputText = "";
        enteredInputText = "";
        pmText = "";
        enteredPMText = "";
    }

    private int appletWidth;
    private int appletHeight;
    private Thread gameWindowThread;
    private int refreshRate;
    private int fie;
    private long timeArray[];
    public static GameFrame gameFrame = null;
    private boolean inBrowser;
    private int runStatus;
    private int fij;
    public int mouseYOffset;
    //public int lastActionTimeout;
    public int gameLoadingScreen;
    private int gameLoadingPercentage;
    private String gameLoadingFileTitle;
    private Font gameLoadingFont;
    private Graphics graphics;
    private static String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public boolean keyLeftBraceDown;
    public boolean keyRightBraceDown;
    public boolean keyLeftDown;
    public boolean keyRightDown;
    public boolean keyUpDown;
    public boolean keyDownDown;
    public boolean keySpaceDown;
    public boolean keyNMDown;
    public int gameMinThreadSleepTime;
    public int mouseX;
    public int mouseY;
    public int mouseButton;
    public int lastMouseButton;
    public int fki;
    public int fkj;
    public boolean keyF1Toggle;
    public String inputText;
    public String enteredInputText;
    public String pmText;
    public String enteredPMText;
    
    protected static int bgPixels[][] = null;
    protected static BufferedImage bgImage = null;

}
