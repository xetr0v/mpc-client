package mudclient;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings("serial")
public class Loader extends Applet implements Runnable {

    private Applet applet;
    private boolean running;
    private String files[];
    
    public void init() {
        running = false;
        files = new String[] {
                "config.jag", "entity.jag", "entity.mem", "filter.jag", "fonts.jag",
                "land.jag", "land.mem", "maps.jag", "maps.mem", "media.jag", "models.jag",
                "sonuds.mem", "textures.jag"
        };
        new Thread(this).start();
        while(!running)
            try {
                Thread.sleep(100);
            } catch(Exception e) { }
        new Thread(this).start();
    }

    public void run() {
        if(running) {
            runGame();
            return;
        }
        running = true;
        try {
            link.gameApplet = this;
            link.currentFile = 0;
            for(int i = 0; i < files.length; i++) {
                byte bytes[] = load(files[i]);
                link.addFile(files[i], bytes);
            }
            applet = new mudclient();
            applet.init();
            applet.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private byte[] load(String file) {
        try {
            System.out.println("load: " + file);
            File f = new File(Config.CONF_DIR, file);
            DataInputStream in = new DataInputStream(new FileInputStream(f));
            byte bytes[] = new byte[(int)f.length()];
            in.readFully(bytes);
            in.close();
            return bytes;
        } catch(Exception e) {
            return null;
        }
    }
    
    private void runGame() {
        while(true) {
            if(link.port != 0) {
                try {
                    Socket socket = new Socket(InetAddress.getByName(Config.SERVER_IP), link.port);
                    socket.setSoTimeout(30000);
                    socket.setTcpNoDelay(true);
                    link.socket = socket;
                } catch(Exception e) {
                    e.printStackTrace();
                    link.socket = null;
                }
                link.port = 0;
            }
            if(link.thread != null) {
                Thread thread = new Thread(link.thread);
                thread.setDaemon(true);
                thread.start();
                link.thread = null;
            }
            if(link.iplookup != null) {
                String s = "unknown";
                try {
                    s = InetAddress.getByName(link.iplookup).getHostName();
                } catch(Exception e) { }
                link.address = s;
                link.iplookup = null;
            }
            try {
                Thread.sleep(100);
            } catch(Exception e) { }
        }
    }
    
    public void update(Graphics g) {
        paint(g);
    }
    
    public void paint(Graphics g) {
        if(applet != null)
            applet.paint(g);
    }
    
    public void start() {
        if(applet != null)
            applet.start();
    }
    
    public void stop() {
        if(applet != null)
            applet.stop();
    }
    
    public void destroy() {
        if(applet != null)
            applet.destroy();
    }
    
    public boolean mouseDown(Event evt, int x, int y) {
        if(applet != null)
            return applet.mouseDown(evt, x, y);
        return true;
    }
    
    public boolean mouseDrag(Event evt, int x, int y) {
        if(applet != null)
            return applet.mouseDrag(evt, x, y);
        return true;
    }
    
    public boolean mouseUp(Event evt, int x, int y) {
        if(applet != null)
            return applet.mouseUp(evt, x, y);
        return true;
    }
    
    public boolean mouseMove(Event evt, int x, int y) {
        if(applet != null)
            return applet.mouseMove(evt, x, y);
        return true;
    }
    
    public boolean keyDown(Event evt, int key) {
        if(applet != null)
            return applet.keyDown(evt, key);
        return true;
    }
    
    public boolean keyUp(Event evt, int key) {
        if(applet != null)
            return applet.keyDown(evt, key);
        return true;
    }
}
