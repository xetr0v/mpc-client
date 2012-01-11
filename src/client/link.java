package client;
/*
This file was hosted at rscheatnet.com for educational purposes only.
Rscheatnet is a community of likeminded people striving to learn and 
develop their skills and thus should not use this code for anything 
other than that, it is not to be used to break any rules in any game

Props to saevion for the deober. (seeing as he isnt online I will just 
paste in the msg from the deober for you lot)

*****************************************************************
        deobfuscator created by saevion
        props to:
                the jakarta-apache people,
                Sean, cause he owns,
                and others.
*****************************************************************

Also we request that no one rehosts this file without permission to rscheatnet,
doing so will only result in us hoarding our code and knowledge which damages
not only the people doing so but the whole of the cheating community.


Thank you, SeanWT
 */

import java.applet.Applet;
import java.net.Socket;

public class link
{

    public static final void gae(String s, byte abyte0[])
    {
        gac[gab] = s;
        gad[gab] = abyte0;
        gab++;
    }

    public static final byte[] getFile(String arg0)
    {
        for(int i = 0; i < gab; i++)
            if(gac[i].equals(arg0))
                return gad[i];

        return null;
    }

    public static final Socket getSocket(int arg0)
    {
        for(fnk = arg0; fnk != 0;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return fnl;
    }

    public static final void thread(Runnable arg0)
    {
        for(fnm = arg0; fnm != null;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

    }

    public static final String getAddress(String arg0)
    {
        for(fnn = arg0; fnn != null;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return gaa;
    }

    public link()
    {
    }

    public static Applet gameApplet;
    public static int fnj;
    static int fnk;
    static Socket fnl;
    static Runnable fnm = null;
    static String fnn = null;
    static String gaa;
    static int gab;
    private static String gac[] = new String[50];
    private static byte gad[][] = new byte[50][];

}
