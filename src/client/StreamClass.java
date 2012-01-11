package client;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.io.*;
import java.net.Socket;

public class StreamClass extends PacketConstruction
    implements Runnable
{

    public StreamClass(Socket socket, GameApplet a1)
        throws IOException
    {
        bae = false;
        bai = true;
        bad = socket;
        bab = socket.getInputStream();
        bac = socket.getOutputStream();
        bai = false;
        a1.startThread(this);
    }

    public void closeStream()
    {
        super.closeStream();
        bae = true;
        try
        {
            if(bab != null)
                bab.close();
            if(bac != null)
                bac.close();
            if(bad != null)
                bad.close();
        }
        catch(IOException _ex)
        {
            System.out.println("Error closing stream");
        }
        bai = true;
        synchronized(this)
        {
            notify();
        }
        baf = null;
    }

    public int readInputStream()
        throws IOException
    {
        if(bae)
            return 0;
        else
            return bab.read();
    }

    public int bal()
        throws IOException
    {
        if(bae)
            return 0;
        else
            return bab.available();
    }

    public void bam(int arg0, int arg1, byte arg2[])
        throws IOException
    {
        if(bae)
            return;
        int i = 0;
        boolean flag = false;
        int j;
        for(; i < arg0; i += j)
            if((j = bab.read(arg2, i + arg1, arg0 - i)) <= 0)
                throw new IOException("EOF");

    }

    public void ban(byte arg0[], int arg1, int arg2)
        throws IOException
    {
        if(bae)
            return;
        if(baf == null)
            baf = new byte[5000];
        synchronized(this)
        {
            for(int i = 0; i < arg2; i++)
            {
                baf[bah] = arg0[i + arg1];
                bah = (bah + 1) % 5000;
                if(bah == (bag + 4900) % 5000)
                    throw new IOException("buffer overflow");
            }

            notify();
        }
    }

    public void run()
    {
        while(!bai) 
        {
            int i;
            int j;
            synchronized(this)
            {
                if(bah == bag)
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException _ex) { }
                if(bai)
                    return;
                j = bag;
                if(bah >= bag)
                    i = bah - bag;
                else
                    i = 5000 - bag;
            }
            if(i > 0)
            {
                try
                {
                    bac.write(baf, j, i);
                }
                catch(IOException ioexception)
                {
                    super.hck = true;
                    super.hcj = "Twriter:" + ioexception;
                }
                bag = (bag + i) % 5000;
                try
                {
                    if(bah == bag)
                        bac.flush();
                }
                catch(IOException ioexception1)
                {
                    super.hck = true;
                    super.hcj = "Twriter:" + ioexception1;
                }
            }
        }
    }

    private InputStream bab;
    private OutputStream bac;
    private Socket bad;
    private boolean bae;
    private byte baf[];
    private int bag;
    private int bah;
    private boolean bai;
}
