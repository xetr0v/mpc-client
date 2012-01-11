package client;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;

@SuppressWarnings("all")
public class GameFrame extends Frame
{

    public GameFrame(GameApplet arg0, int width, int height, String title, boolean resizable, boolean translate)
    {
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

    public Graphics getGraphics()
    {
        System.out.println("GameFrame.fej = " + fej);
        Graphics g = super.getGraphics();
        if(fej == 0)
            g.translate(0, 24);
        else
            g.translate(-5, 0);
        return g;
    }

    public void resize(int i, int j)
    {
        super.resize(i, j + yOffset);
    }

    public boolean handleEvent(Event evt)
    {
        if(evt.id == 401)
            gameApplet.keyDown(evt, evt.key);
        else
        if(evt.id == 402)
            gameApplet.keyUp(evt, evt.key);
        else
        if(evt.id == 501)
            gameApplet.mouseDown(evt, evt.x, evt.y - 24);
        else
        if(evt.id == 506)
            gameApplet.mouseDrag(evt, evt.x, evt.y - 24);
        else
        if(evt.id == 502)
            gameApplet.mouseUp(evt, evt.x, evt.y - 24);
        else
        if(evt.id == 503)
            gameApplet.mouseMove(evt, evt.x, evt.y - 24);
        else
        if(evt.id == 201)
            gameApplet.destroy();
        else
        if(evt.id == 1001)
            gameApplet.action(evt, evt.target);
        else
        if(evt.id == 403)
            gameApplet.keyDown(evt, evt.key);
        else
        if(evt.id == 404)
            gameApplet.keyUp(evt, evt.key);
        return true;
    }

    public final void paint(Graphics g)
    {
        gameApplet.paint(g);
    }

    int frameWidth;
    int frameHeight;
    int fej;
    int yOffset;
    GameApplet gameApplet;
}
