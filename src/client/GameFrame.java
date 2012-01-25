package client;

import java.awt.*;

@SuppressWarnings({ "deprecation", "serial" })
public class GameFrame extends Frame {

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

    public boolean handleEvent(Event evt) {
        if(evt.id == Event.KEY_PRESS)
            gameApplet.keyDown(evt.key);
        else
        if(evt.id == Event.KEY_RELEASE)
            gameApplet.keyUp(evt.key);
        else
        if(evt.id == Event.MOUSE_DOWN)
            gameApplet.mouseDown(evt.x, evt.y - 24, evt.metaDown());
        else
        if(evt.id == Event.MOUSE_DRAG)
            gameApplet.mouseDrag(evt.x, evt.y - 24, evt.metaDown());
        else
        if(evt.id == Event.MOUSE_UP)
            gameApplet.mouseUp(evt.x, evt.y - 24);
        else
        if(evt.id == Event.MOUSE_MOVE)
            gameApplet.mouseMove(evt.x, evt.y - 24);
        else
        if(evt.id == Event.WINDOW_DESTROY)
            gameApplet.destroy();
        else
        if(evt.id == Event.END)
            gameApplet.action(evt, evt.target);
        else
        if(evt.id == Event.KEY_ACTION)
            gameApplet.keyDown(evt.key);
        else
        if(evt.id == Event.KEY_ACTION_RELEASE)
            gameApplet.keyUp(evt.key);
        else
        if(evt.id == Event.SCROLL_BEGIN)
            gameApplet.mouseScroll(true, evt.key);
        else
        if(evt.id == Event.SCROLL_END)
            gameApplet.mouseScroll(false, evt.key);
        return true;
    }

    public final void paint(Graphics g) {
        gameApplet.paint(g);
    }

    int frameWidth;
    int frameHeight;
    int fej;
    int yOffset;
    GameApplet gameApplet;
}
