package client;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 


public class Menu
{

    public Menu(GameImage j1, int i)
    {
        gcg = -1;
        gdg = true;
        gaj = j1;
        gal = i;
        gam = new boolean[i];
        gan = new boolean[i];
        gba = new boolean[i];
        gbb = new boolean[i];
        gbg = new boolean[i];
        gbc = new int[i];
        listLength = new int[i];
        gbe = new int[i];
        gbf = new int[i];
        gbh = new int[i];
        gbi = new int[i];
        gbj = new int[i];
        gbk = new int[i];
        gbl = new int[i];
        gbm = new int[i];
        gbn = new int[i];
        gca = new String[i];
        gcb = new String[i][];
        gci = gdn(114, 114, 176);
        gcj = gdn(14, 14, 62);
        gck = gdn(200, 208, 232);
        gcl = gdn(96, 129, 184);
        gcm = gdn(53, 95, 115);
        gcn = gdn(117, 142, 171);
        gda = gdn(98, 122, 158);
        gdb = gdn(86, 100, 136);
        gdc = gdn(135, 146, 179);
        gdd = gdn(97, 112, 151);
        gde = gdn(88, 102, 136);
        gdf = gdn(84, 93, 120);
    }

    public int gdn(int i, int k, int l)
    {
        return GameImage.rgbToInt((gdj * i) / 114, (gdk * k) / 114, (gdl * l) / 176);
    }

    public void mouseClick(int arg0, int arg1, int arg2, int arg3)
    {
        gcc = arg0;
        gcd = arg1;
        gcf = arg3;
        if(arg2 != 0)
            gce = arg2;
        if(arg2 == 1)
        {
            for(int i = 0; i < gak; i++)
            {
                if(gam[i] && gbj[i] == 10 && gcc >= gbh[i] && gcd >= gbi[i] && gcc <= gbh[i] + gbk[i] && gcd <= gbi[i] + gbl[i])
                    gbb[i] = true;
                if(gam[i] && gbj[i] == 14 && gcc >= gbh[i] && gcd >= gbi[i] && gcc <= gbh[i] + gbk[i] && gcd <= gbi[i] + gbl[i])
                    gbe[i] = 1 - gbe[i];
            }

        }
        if(arg3 == 1)
            gch++;
        else
            gch = 0;
        if(arg2 == 1 || gch > 20)
        {
            for(int k = 0; k < gak; k++)
                if(gam[k] && gbj[k] == 15 && gcc >= gbh[k] && gcd >= gbi[k] && gcc <= gbh[k] + gbk[k] && gcd <= gbi[k] + gbl[k])
                    gbb[k] = true;

            gch -= 5;
        }
    }

    public boolean isClicked(int i)
    {
        if(gam[i] && gbb[i])
        {
            gbb[i] = false;
            return true;
        } else
        {
            return false;
        }
    }

    public void keyPress(int arg0)
    {
        if(arg0 == 0)
            return;
        if(gcg != -1 && gca[gcg] != null && gam[gcg])
        {
            int i = gca[gcg].length();
            if(arg0 == 8 && i > 0)
                gca[gcg] = gca[gcg].substring(0, i - 1);
            if((arg0 == 10 || arg0 == 13) && i > 0)
                gbb[gcg] = true;
            String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
            if(i < gbm[gcg])
            {
                for(int k = 0; k < s.length(); k++)
                    if(arg0 == s.charAt(k))
                        gca[gcg] += (char)arg0;

            }
            if(arg0 == 9)
            {
                do
                    gcg = (gcg + 1) % gak;
                while(gbj[gcg] != 5 && gbj[gcg] != 6);
                return;
            }
        }
    }

    public void drawMenu()
    {
        for(int i = 0; i < gak; i++)
            if(gam[i])
                if(gbj[i] == 0)
                    gef(i, gbh[i], gbi[i], gca[i], gbn[i]);
                else
                if(gbj[i] == 1)
                    gef(i, gbh[i] - gaj.textWidth(gca[i], gbn[i]) / 2, gbi[i], gca[i], gbn[i]);
                else
                if(gbj[i] == 2)
                    gei(gbh[i], gbi[i], gbk[i], gbl[i]);
                else
                if(gbj[i] == 3)
                    gel(gbh[i], gbi[i], gbk[i]);
                else
                if(gbj[i] == 4)
                    gem(i, gbh[i], gbi[i], gbk[i], gbl[i], gbn[i], gcb[i], listLength[i], gbc[i]);
                else
                if(gbj[i] == 5 || gbj[i] == 6)
                    geh(i, gbh[i], gbi[i], gbk[i], gbl[i], gca[i], gbn[i]);
                else
                if(gbj[i] == 7)
                    gfa(i, gbh[i], gbi[i], gbn[i], gcb[i]);
                else
                if(gbj[i] == 8)
                    gfb(i, gbh[i], gbi[i], gbn[i], gcb[i]);
                else
                if(gbj[i] == 9)
                    gfc(i, gbh[i], gbi[i], gbk[i], gbl[i], gbn[i], gcb[i], listLength[i], gbc[i]);
                else
                if(gbj[i] == 11)
                    gej(gbh[i], gbi[i], gbk[i], gbl[i]);
                else
                if(gbj[i] == 12)
                    gek(gbh[i], gbi[i], gbn[i]);
                else
                if(gbj[i] == 14)
                    gee(i, gbh[i], gbi[i], gbk[i], gbl[i]);

        gce = 0;
    }

    protected void gee(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        gaj.drawBox(arg1, arg2, arg3, arg4, 0xffffff);
        gaj.drawLineX(arg1, arg2, arg3, gdc);
        gaj.drawLineY(arg1, arg2, arg4, gdc);
        gaj.drawLineX(arg1, (arg2 + arg4) - 1, arg3, gdf);
        gaj.drawLineY((arg1 + arg3) - 1, arg2, arg4, gdf);
        if(gbe[arg0] == 1)
        {
            for(int i = 0; i < arg4; i++)
            {
                gaj.drawLineX(arg1 + i, arg2 + i, 1, 0);
                gaj.drawLineX((arg1 + arg3) - 1 - i, arg2 + i, 1, 0);
            }

        }
    }

    protected void gef(int i, int k, int l, String s, int i1)
    {
        int j1 = l + gaj.textHeightNumber(i1) / 3;
        geg(i, k, j1, s, i1);
    }

    protected void geg(int arg0, int arg1, int arg2, String arg3, int arg4)
    {
        int i;
        if(gbg[arg0])
            i = 0xffffff;
        else
            i = 0;
        gaj.drawString(arg3, arg1, arg2, arg4, i);
    }

    protected void geh(int arg0, int arg1, int arg2, int arg3, int arg4, String arg5, int arg6)
    {
        if(gba[arg0])
        {
            int i = arg5.length();
            arg5 = "";
            for(int l = 0; l < i; l++)
                arg5 = arg5 + "X";

        }
        if(gbj[arg0] == 5)
        {
            if(gce == 1 && gcc >= arg1 && gcd >= arg2 - arg4 / 2 && gcc <= arg1 + arg3 && gcd <= arg2 + arg4 / 2)
                gcg = arg0;
        } else
        if(gbj[arg0] == 6)
        {
            if(gce == 1 && gcc >= arg1 - arg3 / 2 && gcd >= arg2 - arg4 / 2 && gcc <= arg1 + arg3 / 2 && gcd <= arg2 + arg4 / 2)
                gcg = arg0;
            arg1 -= gaj.textWidth(arg5, arg6) / 2;
        }
        if(gcg == arg0)
            arg5 = arg5 + "*";
        int k = arg2 + gaj.textHeightNumber(arg6) / 3;
        geg(arg0, arg1, k, arg5, arg6);
    }

    public void gei(int arg0, int arg1, int arg2, int arg3)
    {
        gaj.setGameBoundaries(arg0, arg1, arg0 + arg2, arg1 + arg3);
        gaj.can(arg0, arg1, arg2, arg3, gdf, gdc);
        if(gdh)
        {
            for(int i = arg0 - (arg1 & 0x3f); i < arg0 + arg2; i += 128)
            {
                for(int k = arg1 - (arg1 & 0x1f); k < arg1 + arg3; k += 128)
                    gaj.ccd(i, k, 6 + gdi, 128);

            }

        }
        gaj.drawLineX(arg0, arg1, arg2, gdc);
        gaj.drawLineX(arg0 + 1, arg1 + 1, arg2 - 2, gdc);
        gaj.drawLineX(arg0 + 2, arg1 + 2, arg2 - 4, gdd);
        gaj.drawLineY(arg0, arg1, arg3, gdc);
        gaj.drawLineY(arg0 + 1, arg1 + 1, arg3 - 2, gdc);
        gaj.drawLineY(arg0 + 2, arg1 + 2, arg3 - 4, gdd);
        gaj.drawLineX(arg0, (arg1 + arg3) - 1, arg2, gdf);
        gaj.drawLineX(arg0 + 1, (arg1 + arg3) - 2, arg2 - 2, gdf);
        gaj.drawLineX(arg0 + 2, (arg1 + arg3) - 3, arg2 - 4, gde);
        gaj.drawLineY((arg0 + arg2) - 1, arg1, arg3, gdf);
        gaj.drawLineY((arg0 + arg2) - 2, arg1 + 1, arg3 - 2, gdf);
        gaj.drawLineY((arg0 + arg2) - 3, arg1 + 2, arg3 - 4, gde);
        gaj.cai();
    }

    public void gej(int i, int k, int l, int i1)
    {
        gaj.drawBox(i, k, l, i1, 0);
        gaj.drawBoxEdge(i, k, l, i1, gcn);
        gaj.drawBoxEdge(i + 1, k + 1, l - 2, i1 - 2, gda);
        gaj.drawBoxEdge(i + 2, k + 2, l - 4, i1 - 4, gdb);
        gaj.drawPicture(i, k, 2 + gdi);
        gaj.drawPicture((i + l) - 7, k, 3 + gdi);
        gaj.drawPicture(i, (k + i1) - 7, 4 + gdi);
        gaj.drawPicture((i + l) - 7, (k + i1) - 7, 5 + gdi);
    }

    protected void gek(int i, int k, int l)
    {
        gaj.drawPicture(i, k, l);
    }

    protected void gel(int i, int k, int l)
    {
        gaj.drawLineX(i, k, l, 0);
    }

    protected void gem(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, String arg6[], 
            int arg7, int arg8)
    {
        int i = arg4 / gaj.textHeightNumber(arg5);
        if(arg8 > arg7 - i)
            arg8 = arg7 - i;
        if(arg8 < 0)
            arg8 = 0;
        gbc[arg0] = arg8;
        if(i < arg7)
        {
            int k = (arg1 + arg3) - 12;
            int i1 = ((arg4 - 27) * i) / arg7;
            if(i1 < 6)
                i1 = 6;
            int k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            if(gcf == 1 && gcc >= k && gcc <= k + 12)
            {
                if(gcd > arg2 && gcd < arg2 + 12 && arg8 > 0)
                    arg8--;
                if(gcd > (arg2 + arg4) - 12 && gcd < arg2 + arg4 && arg8 < arg7 - i)
                    arg8++;
                gbc[arg0] = arg8;
            }
            if(gcf == 1 && (gcc >= k && gcc <= k + 12 || gcc >= k - 12 && gcc <= k + 24 && gan[arg0]))
            {
                if(gcd > arg2 + 12 && gcd < (arg2 + arg4) - 12)
                {
                    gan[arg0] = true;
                    int i2 = gcd - arg2 - 12 - i1 / 2;
                    arg8 = (i2 * arg7) / (arg4 - 24);
                    if(arg8 > arg7 - i)
                        arg8 = arg7 - i;
                    if(arg8 < 0)
                        arg8 = 0;
                    gbc[arg0] = arg8;
                }
            } else
            {
                gan[arg0] = false;
            }
            k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            gen(arg1, arg2, arg3, arg4, k1, i1);
        }
        int l = arg4 - i * gaj.textHeightNumber(arg5);
        int j1 = arg2 + (gaj.textHeightNumber(arg5) * 5) / 6 + l / 2;
        for(int l1 = arg8; l1 < arg7; l1++)
        {
            geg(arg0, arg1 + 2, j1, arg6[l1], arg5);
            j1 += gaj.textHeightNumber(arg5) - chatMenuTextHeightMod;
            if(j1 >= arg2 + arg4)
                return;
        }

    }

    protected void gen(int i, int k, int l, int i1, int j1, int k1)
    {
        int l1 = (i + l) - 12;
        gaj.drawBoxEdge(l1, k, 12, i1, 0);
        gaj.drawPicture(l1 + 1, k + 1, gdi);
        gaj.drawPicture(l1 + 1, (k + i1) - 12, 1 + gdi);
        gaj.drawLineX(l1, k + 13, 12, 0);
        gaj.drawLineX(l1, (k + i1) - 13, 12, 0);
        gaj.can(l1 + 1, k + 14, 11, i1 - 27, gci, gcj);
        gaj.drawBox(l1 + 3, j1 + k + 14, 7, k1, gcl);
        gaj.drawLineY(l1 + 2, j1 + k + 14, k1, gck);
        gaj.drawLineY(l1 + 2 + 8, j1 + k + 14, k1, gcm);
    }

    protected void gfa(int arg0, int arg1, int arg2, int arg3, String arg4[])
    {
        int i = 0;
        int k = arg4.length;
        for(int l = 0; l < k; l++)
        {
            i += gaj.textWidth(arg4[l], arg3);
            if(l < k - 1)
                i += gaj.textWidth("  ", arg3);
        }

        int i1 = arg1 - i / 2;
        int j1 = arg2 + gaj.textHeightNumber(arg3) / 3;
        for(int k1 = 0; k1 < k; k1++)
        {
            int l1;
            if(gbg[arg0])
                l1 = 0xffffff;
            else
                l1 = 0;
            if(gcc >= i1 && gcc <= i1 + gaj.textWidth(arg4[k1], arg3) && gcd <= j1 && gcd > j1 - gaj.textHeightNumber(arg3))
            {
                if(gbg[arg0])
                    l1 = 0x808080;
                else
                    l1 = 0xffffff;
                if(gce == 1)
                {
                    gbe[arg0] = k1;
                    gbb[arg0] = true;
                }
            }
            if(gbe[arg0] == k1)
                if(gbg[arg0])
                    l1 = 0xff0000;
                else
                    l1 = 0xc00000;
            gaj.drawString(arg4[k1], i1, j1, arg3, l1);
            i1 += gaj.textWidth(arg4[k1] + "  ", arg3);
        }

    }

    protected void gfb(int arg0, int arg1, int arg2, int arg3, String arg4[])
    {
        int i = arg4.length;
        int k = arg2 - (gaj.textHeightNumber(arg3) * (i - 1)) / 2;
        for(int l = 0; l < i; l++)
        {
            int i1;
            if(gbg[arg0])
                i1 = 0xffffff;
            else
                i1 = 0;
            int j1 = gaj.textWidth(arg4[l], arg3);
            if(gcc >= arg1 - j1 / 2 && gcc <= arg1 + j1 / 2 && gcd - 2 <= k && gcd - 2 > k - gaj.textHeightNumber(arg3))
            {
                if(gbg[arg0])
                    i1 = 0x808080;
                else
                    i1 = 0xffffff;
                if(gce == 1)
                {
                    gbe[arg0] = l;
                    gbb[arg0] = true;
                }
            }
            if(gbe[arg0] == l)
                if(gbg[arg0])
                    i1 = 0xff0000;
                else
                    i1 = 0xc00000;
            gaj.drawString(arg4[l], arg1 - j1 / 2, k, arg3, i1);
            k += gaj.textHeightNumber(arg3);
        }

    }

    protected void gfc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, String arg6[], 
            int arg7, int arg8)
    {
        int i = arg4 / gaj.textHeightNumber(arg5);
        if(i < arg7)
        {
            int k = (arg1 + arg3) - 12;
            int i1 = ((arg4 - 27) * i) / arg7;
            if(i1 < 6)
                i1 = 6;
            int k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            if(gcf == 1 && gcc >= k && gcc <= k + 12)
            {
                if(gcd > arg2 && gcd < arg2 + 12 && arg8 > 0)
                    arg8--;
                if(gcd > (arg2 + arg4) - 12 && gcd < arg2 + arg4 && arg8 < arg7 - i)
                    arg8++;
                gbc[arg0] = arg8;
            }
            if(gcf == 1 && (gcc >= k && gcc <= k + 12 || gcc >= k - 12 && gcc <= k + 24 && gan[arg0]))
            {
                if(gcd > arg2 + 12 && gcd < (arg2 + arg4) - 12)
                {
                    gan[arg0] = true;
                    int i2 = gcd - arg2 - 12 - i1 / 2;
                    arg8 = (i2 * arg7) / (arg4 - 24);
                    if(arg8 < 0)
                        arg8 = 0;
                    if(arg8 > arg7 - i)
                        arg8 = arg7 - i;
                    gbc[arg0] = arg8;
                }
            } else
            {
                gan[arg0] = false;
            }
            k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            gen(arg1, arg2, arg3, arg4, k1, i1);
        } else
        {
            arg8 = 0;
            gbc[arg0] = 0;
        }
        gbf[arg0] = -1;
        int l = arg4 - i * gaj.textHeightNumber(arg5);
        int j1 = arg2 + (gaj.textHeightNumber(arg5) * 5) / 6 + l / 2;
        for(int l1 = arg8; l1 < arg7; l1++)
        {
            int j2;
            if(gbg[arg0])
                j2 = 0xffffff;
            else
                j2 = 0;
            if(gcc >= arg1 + 2 && gcc <= arg1 + 2 + gaj.textWidth(arg6[l1], arg5) && gcd - 2 <= j1 && gcd - 2 > j1 - gaj.textHeightNumber(arg5))
            {
                if(gbg[arg0])
                    j2 = 0x808080;
                else
                    j2 = 0xffffff;
                gbf[arg0] = l1;
                if(gce == 1)
                {
                    gbe[arg0] = l1;
                    gbb[arg0] = true;
                }
            }
            if(gbe[arg0] == l1 && gdg)
                j2 = 0xff0000;
            gaj.drawString(arg6[l1], arg1 + 2, j1, arg5, j2);
            j1 += gaj.textHeightNumber(arg5);
            if(j1 >= arg2 + arg4)
                return;
        }

    }

    public int drawText(int i, int k, String s, int l, boolean flag)
    {
        gbj[gak] = 1;
        gam[gak] = true;
        gbb[gak] = false;
        gbn[gak] = l;
        gbg[gak] = flag;
        gbh[gak] = i;
        gbi[gak] = k;
        gca[gak] = s;
        return gak++;
    }

    public int drawButton(int i, int k, int l, int i1)
    {
        gbj[gak] = 2;
        gam[gak] = true;
        gbb[gak] = false;
        gbh[gak] = i - l / 2;
        gbi[gak] = k - i1 / 2;
        gbk[gak] = l;
        gbl[gak] = i1;
        return gak++;
    }

    public int drawCurvedBox(int i, int k, int l, int i1)
    {
        gbj[gak] = 11;
        gam[gak] = true;
        gbb[gak] = false;
        gbh[gak] = i - l / 2;
        gbi[gak] = k - i1 / 2;
        gbk[gak] = l;
        gbl[gak] = i1;
        return gak++;
    }

    public int drawArrow(int i, int k, int l)
    {
        int i1 = gaj.bmf[l];
        int j1 = gaj.bmg[l];
        gbj[gak] = 12;
        gam[gak] = true;
        gbb[gak] = false;
        gbh[gak] = i - i1 / 2;
        gbi[gak] = k - j1 / 2;
        gbk[gak] = i1;
        gbl[gak] = j1;
        gbn[gak] = l;
        return gak++;
    }

    public int gfh(int i, int k, int l, int i1, int j1, int k1, boolean flag)
    {
        gbj[gak] = 4;
        gam[gak] = true;
        gbb[gak] = false;
        gbh[gak] = i;
        gbi[gak] = k;
        gbk[gak] = l;
        gbl[gak] = i1;
        gbg[gak] = flag;
        gbn[gak] = j1;
        gbm[gak] = k1;
        listLength[gak] = 0;
        gbc[gak] = 0;
        gcb[gak] = new String[k1];
        return gak++;
    }

    public int gfi(int i, int k, int l, int i1, int j1, int k1, boolean flag, 
            boolean flag1)
    {
        gbj[gak] = 5;
        gam[gak] = true;
        gba[gak] = flag;
        gbb[gak] = false;
        gbn[gak] = j1;
        gbg[gak] = flag1;
        gbh[gak] = i;
        gbi[gak] = k;
        gbk[gak] = l;
        gbl[gak] = i1;
        gbm[gak] = k1;
        gca[gak] = "";
        return gak++;
    }

    public int createInput(int i, int k, int l, int i1, int j1, int k1, boolean flag, 
            boolean flag1)
    {
        gbj[gak] = 6;
        gam[gak] = true;
        gba[gak] = flag;
        gbb[gak] = false;
        gbn[gak] = j1;
        gbg[gak] = flag1;
        gbh[gak] = i;
        gbi[gak] = k;
        gbk[gak] = l;
        gbl[gak] = i1;
        gbm[gak] = k1;
        gca[gak] = "";
        return gak++;
    }

    public int createList(int i, int k, int l, int i1, int j1, int k1, boolean flag)
    {
        gbj[gak] = 9;
        gam[gak] = true;
        gbb[gak] = false;
        gbn[gak] = j1;
        gbg[gak] = flag;
        gbh[gak] = i;
        gbi[gak] = k;
        gbk[gak] = l;
        gbl[gak] = i1;
        gbm[gak] = k1;
        gcb[gak] = new String[k1];
        listLength[gak] = 0;
        gbc[gak] = 0;
        gbe[gak] = -1;
        gbf[gak] = -1;
        return gak++;
    }

    public int createButton(int i, int k, int l, int i1)
    {
        gbj[gak] = 10;
        gam[gak] = true;
        gbb[gak] = false;
        gbh[gak] = i - l / 2;
        gbi[gak] = k - i1 / 2;
        gbk[gak] = l;
        gbl[gak] = i1;
        return gak++;
    }

    public void clearList(int i)
    {
        listLength[i] = 0;
    }

    public void switchList(int i)
    {
        gbc[i] = 0;
        gbf[i] = -1;
    }

    public void addListItem(int i, int k, String s)
    {
        gcb[i][k] = s;
        if(k + 1 > listLength[i])
            listLength[i] = k + 1;
    }

    public void addMessage(int arg0, String arg1, boolean arg2)
    {
        int i = listLength[arg0]++;
        if(i >= gbm[arg0])
        {
            i--;
            listLength[arg0]--;
            for(int k = 0; k < i; k++)
                gcb[arg0][k] = gcb[arg0][k + 1];

        }
        gcb[arg0][i] = arg1;
        if(arg2)
            gbc[arg0] = 0xf423f;
    }

    public void updateText(int i, String s)
    {
        gca[i] = s;
    }

    public String getText(int i)
    {
        if(gca[i] == null)
            return "null";
        else
            return gca[i];
    }

    public void gge(int i)
    {
        gam[i] = true;
    }

    public void ggf(int i)
    {
        gam[i] = false;
    }

    public void setFocus(int i)
    {
        gcg = i;
    }

    public int getEntryHighlighted(int i)
    {
        int k = gbf[i];
        return k;
    }

    protected GameImage gaj;
    int gak;
    int gal;
    public boolean gam[];
    public boolean gan[];
    public boolean gba[];
    public boolean gbb[];
    public int gbc[];
    public int listLength[];
    public int gbe[];
    public int gbf[];
    boolean gbg[];
    int gbh[];
    int gbi[];
    int gbj[];
    int gbk[];
    int gbl[];
    int gbm[];
    int gbn[];
    String gca[];
    String gcb[][];
    int gcc;
    int gcd;
    int gce;
    int gcf;
    int gcg;
    int gch;
    int gci;
    int gcj;
    int gck;
    int gcl;
    int gcm;
    int gcn;
    int gda;
    int gdb;
    int gdc;
    int gdd;
    int gde;
    int gdf;
    public boolean gdg;
    public static boolean gdh = true;
    public static int gdi;
    public static int gdj = 114;
    public static int gdk = 114;
    public static int gdl = 176;
    public static int chatMenuTextHeightMod;

}
