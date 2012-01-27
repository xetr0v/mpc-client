package mudclient;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.event.MouseInputListener;

@SuppressWarnings({ "deprecation", "serial" })
public class GameFrame extends Frame implements KeyListener, MouseInputListener, MouseMotionListener, WindowListener {

    public GameFrame(GameApplet arg0, int width, int height, String title, boolean resizable, boolean translate) {
        yOffset = 28;
        frameWidth = width;
        frameHeight = height;
        gameApplet = arg0;
        if(translate)
            yOffset = 48;
        else
            yOffset = 28;
        setTitle(title);
        setResizable(resizable);
        show();
        toFront();
        resize(frameWidth, frameHeight);
        
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(this);
    }

    public Graphics getGraphics() {
        Graphics g = super.getGraphics();
        if(fej == 0)
            g.translate(0, 24);
        else
            g.translate(-5, 0);
        return g;
    }

    public void resize(int i, int j) {
        super.resize(i, j + yOffset);
    }

    public final void paint(Graphics g) {
        gameApplet.paint(g);
    }
    
    public void keyPressed(KeyEvent evt) {
        gameApplet.keyDown(evt.getKeyCode(), evt.getKeyChar());
    }

    public void keyReleased(KeyEvent evt) {
        gameApplet.keyUp(evt.getKeyCode(), evt.getKeyChar());
    }

    public void mouseEntered(MouseEvent evt) {
        gameApplet.mouseMove(evt.getX(), evt.getY() - 24);
    }

    public void mouseExited(MouseEvent evt) {
        gameApplet.mouseMove(evt.getX(), evt.getY() - 24);
    }

    public void mousePressed(MouseEvent evt) {
        gameApplet.mouseDown(evt.getX(), evt.getY() - 24, evt.isMetaDown());
    }

    public void mouseReleased(MouseEvent evt) {
        gameApplet.mouseUp(evt.getX(), evt.getY() - 24);
    }

    public void mouseDragged(MouseEvent evt) {
        gameApplet.mouseDrag(evt.getX(), evt.getY() - 24, evt.isMetaDown());
    }

    public void mouseMoved(MouseEvent evt) {
        gameApplet.mouseMove(evt.getX(), evt.getY() - 24);
    }

    public void windowClosed(WindowEvent evt) {
        if(gameApplet.runStatus != -1)
            gameApplet.destroy();
    }

    public void windowClosing(WindowEvent evt) {
        if(gameApplet.runStatus != -1)
            gameApplet.destroy();
    }

    public void windowActivated(WindowEvent evt) {
    }

    public void windowDeactivated(WindowEvent evt) {
    }

    public void windowDeiconified(WindowEvent evt) {
    }

    public void windowIconified(WindowEvent evt) {
    }

    public void windowOpened(WindowEvent evt) {
    }
    
    public void keyTyped(KeyEvent evt) {
    }

    public void mouseClicked(MouseEvent evt) {
    }

    int frameWidth;
    int frameHeight;
    int fej;
    int yOffset;
    GameApplet gameApplet;
}
