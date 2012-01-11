package client;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.io.IOException;

public class PacketConstruction
{

    public void hcm(int ai[])
    {
        hcc = new p(ai);
        hcd = new p(ai);
    }

    public void closeStream()
    {
    }

    public void createPacket(int i)
    {
        if(han > (hcg * 4) / 5)
            try
            {
                writePacket(0);
            }
            catch(IOException ioexception)
            {
                hck = true;
                hcj = ioexception.getMessage();
            }
        if(packetData == null)
            packetData = new byte[hcg];
        packetData[han + 2] = (byte)i;
        packetData[han + 3] = 0;
        packetOffset = han + 3;
        hbb = 8;
    }

    public void writePacket(int i)
        throws IOException
    {
        if(hck)
        {
            han = 0;
            packetOffset = 3;
            hck = false;
            throw new IOException(hcj);
        }
        hci++;
        if(hci < i)
            return;
        if(han > 0)
        {
            hci = 0;
            ban(packetData, 0, han);
        }
        han = 0;
        packetOffset = 3;
    }

    public void addByte(int i)
    {
        packetData[packetOffset++] = (byte)i;
    }

    public void addString(String s)
    {
        s.getBytes(0, s.length(), packetData, packetOffset);
        packetOffset += s.length();
    }

    public void addLong(long l)
    {
        addInt((int)(l >> 32));
        addInt((int)(l & -1L));
    }

    public void ban(byte abyte0[], int i, int j)
        throws IOException
    {
    }

    public void bam(int i, int j, byte abyte0[])
        throws IOException
    {
    }

    public int hde()
        throws IOException
    {
        int i = heb();
        int j = heb();
        return i * 256 + j;
    }

    public int readInputStream()
        throws IOException
    {
        return 0;
    }

    public void hdf(int i, byte abyte0[])
        throws IOException
    {
        bam(i, 0, abyte0);
    }

    public int hdg(int i)
    {
        return i - hcc.daf() & 0xff;
    }

    public void addInt(int i)
    {
        packetData[packetOffset++] = (byte)(i >> 24);
        packetData[packetOffset++] = (byte)(i >> 16);
        packetData[packetOffset++] = (byte)(i >> 8);
        packetData[packetOffset++] = (byte)i;
    }

    public void flush()
        throws IOException
    {
        formatPacket();
        writePacket(0);
    }

    public int bal()
        throws IOException
    {
        return 0;
    }

    public void addShort(int i)
    {
        packetData[packetOffset++] = (byte)(i >> 8);
        packetData[packetOffset++] = (byte)i;
    }

    public long readLong()
        throws IOException
    {
        long l = hde();
        long l1 = hde();
        long l2 = hde();
        long l3 = hde();
        return (l << 48) + (l1 << 32) + (l2 << 16) + l3;
    }

    public void formatPacket()
    {
        if(hcd != null)
        {
            int i = packetData[han + 2] & 0xff;
            packetData[han + 2] = (byte)(i + hcd.daf());
        }
        if(hbb != 8)
            packetOffset++;
        int j = packetOffset - han - 2;
        if(j >= 160)
        {
            packetData[han] = (byte)(160 + j / 256);
            packetData[han + 1] = (byte)(j & 0xff);
        } else
        {
            packetData[han] = (byte)j;
            packetOffset--;
            packetData[han + 1] = packetData[packetOffset];
        }
        if(hcg <= 10000)
        {
            int k = packetData[han + 2] & 0xff;
            hcf[k]++;
            hch[k] += packetOffset - han;
        }
        han = packetOffset;
    }

    public void addBytes(byte data[], int off, int len)
    {
        for(int i = 0; i < len; i++)
            packetData[packetOffset++] = data[off + i];

    }

    public boolean hasData()
    {
        return han > 0;
    }

    public int readPacket(byte arg0[])
    {
        try
        {
            hal++;
            if(maxPacketReadCount > 0 && hal > maxPacketReadCount)
            {
                hck = true;
                hcj = "time-out";
                maxPacketReadCount += maxPacketReadCount;
                return 0;
            }
            if(hak == 0 && bal() >= 2)
            {
                hak = readInputStream();
                if(hak >= 160)
                    hak = (hak - 160) * 256 + readInputStream();
            }
            if(hak > 0 && bal() >= hak)
            {
                if(hak >= 160)
                {
                    hdf(hak, arg0);
                } else
                {
                    arg0[hak - 1] = (byte)readInputStream();
                    if(hak > 1)
                        hdf(hak - 1, arg0);
                }
                int i = hak;
                hak = 0;
                hal = 0;
                return i;
            }
        }
        catch(IOException ioexception)
        {
            hck = true;
            hcj = ioexception.getMessage();
        }
        return 0;
    }

    public int heb()
        throws IOException
    {
        return readInputStream();
    }

    public PacketConstruction()
    {
        packetOffset = 3;
        hbb = 8;
        hcg = 5000;
        hcj = "";
        hck = false;
    }

    protected int hak;
    public int hal;
    public int maxPacketReadCount;
    public int han;
    private int packetOffset;
    private int hbb;
    public byte packetData[];
    private static int hbd[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    final int hbe = 61;
    final int hbf = 59;
    final int hbg = 42;
    final int hbh = 43;
    final int hbi = 44;
    final int hbj = 45;
    final int hbk = 46;
    final int hbl = 47;
    final int hbm = 92;
    final int hbn = 32;
    final int hca = 124;
    final int hcb = 34;
    public p hcc;
    public p hcd;
    static char hce[];
    public static int hcf[] = new int[256];
    protected int hcg;
    public static int hch[] = new int[256];
    protected int hci;
    protected String hcj;
    protected boolean hck;
    public static int hcl;

    static 
    {
        hce = new char[256];
        for(int i = 0; i < 256; i++)
            hce[i] = (char)i;

        hce[61] = '=';
        hce[59] = ';';
        hce[42] = '*';
        hce[43] = '+';
        hce[44] = ',';
        hce[45] = '-';
        hce[46] = '.';
        hce[47] = '/';
        hce[92] = '\\';
        hce[124] = '|';
        hce[33] = '!';
        hce[34] = '"';
    }
}
