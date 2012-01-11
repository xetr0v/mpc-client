package client;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 


public final class p
{

    public p(int arg0[])
    {
        dab = new int[256];
        daa = new int[256];
        for(int i = 0; i < arg0.length; i++)
            daa[i] = arg0[i];

        dah();
    }

    public final int daf()
    {
        if(cnn-- == 0)
        {
            dag();
            cnn = 255;
        }
        return daa[cnn];
    }

    private final void dag()
    {
        dad += ++dae;
        for(int i = 0; i < 256; i++)
        {
            int j = dab[i];
            switch(i & 3)
            {
            case 0: // '\0'
                dac ^= dac << 13;
                break;

            case 1: // '\001'
                dac ^= dac >>> 6;
                break;

            case 2: // '\002'
                dac ^= dac << 2;
                break;

            case 3: // '\003'
                dac ^= dac >>> 16;
                break;
            }
            dac += dab[i + 128 & 0xff];
            int k;
            dab[i] = k = dab[(j & 0x3fc) >> 2] + dac + dad;
            daa[i] = dad = dab[(k >> 8 & 0x3fc) >> 2] + j;
        }

    }

    private final void dah()
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l = i1 = j1 = k1 = l1 = i2 = j2 = k2 = 0x9e3779b9;
        for(int i = 0; i < 4; i++)
        {
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
        }

        for(int j = 0; j < 256; j += 8)
        {
            l += daa[j];
            i1 += daa[j + 1];
            j1 += daa[j + 2];
            k1 += daa[j + 3];
            l1 += daa[j + 4];
            i2 += daa[j + 5];
            j2 += daa[j + 6];
            k2 += daa[j + 7];
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
            dab[j] = l;
            dab[j + 1] = i1;
            dab[j + 2] = j1;
            dab[j + 3] = k1;
            dab[j + 4] = l1;
            dab[j + 5] = i2;
            dab[j + 6] = j2;
            dab[j + 7] = k2;
        }

        for(int k = 0; k < 256; k += 8)
        {
            l += dab[k];
            i1 += dab[k + 1];
            j1 += dab[k + 2];
            k1 += dab[k + 3];
            l1 += dab[k + 4];
            i2 += dab[k + 5];
            j2 += dab[k + 6];
            k2 += dab[k + 7];
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
            dab[k] = l;
            dab[k + 1] = i1;
            dab[k + 2] = j1;
            dab[k + 3] = k1;
            dab[k + 4] = l1;
            dab[k + 5] = i2;
            dab[k + 6] = j2;
            dab[k + 7] = k2;
        }

        dag();
        cnn = 256;
    }

    private int cnn;
    private int daa[];
    private int dab[];
    private int dac;
    private int dad;
    private int dae;
}
