package client;

public class Menu {

    public Menu(GameImage j1, int i) {
        selectedComponent = -1;
        gdg = true;
        gaj = j1;
        gal = i;
        componentAcceptsInput = new boolean[i];
        gan = new boolean[i];
        componentIsPasswordField = new boolean[i];
        componentSkip = new boolean[i];
        componentWhiteText = new boolean[i];
        gbc = new int[i];
        listLength = new int[i];
        gbe = new int[i];
        gbf = new int[i];
        componentX = new int[i];
        componentY = new int[i];
        componentType = new int[i];
        componentWidth = new int[i];
        componentHeight = new int[i];
        copmonentInputMaxLength = new int[i];
        componentTextSize = new int[i];
        componentText = new String[i];
        componentTextList = new String[i][];
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

    public int gdn(int i, int k, int l) {
        return GameImage.rgbToInt((gdj * i) / 114, (gdk * k) / 114, (gdl * l) / 176);
    }

    public void mouseClick(int arg0, int arg1, int arg2, int arg3) {
        gcc = arg0;
        gcd = arg1;
        gcf = arg3;
        if(arg2 != 0)
            gce = arg2;
        if(arg2 == 1) {
            for(int i = 0; i < gak; i++) {
                if(componentAcceptsInput[i] && componentType[i] == 10 && gcc >= componentX[i] && gcd >= componentY[i] && gcc <= componentX[i] + componentWidth[i] && gcd <= componentY[i] + componentHeight[i])
                    componentSkip[i] = true;
                if(componentAcceptsInput[i] && componentType[i] == 14 && gcc >= componentX[i] && gcd >= componentY[i] && gcc <= componentX[i] + componentWidth[i] && gcd <= componentY[i] + componentHeight[i])
                    gbe[i] = 1 - gbe[i];
            }

        }
        if(arg3 == 1)
            gch++;
        else
            gch = 0;
        if(arg2 == 1 || gch > 20) {
            for(int k = 0; k < gak; k++)
                if(componentAcceptsInput[k] && componentType[k] == 15 && gcc >= componentX[k] && gcd >= componentY[k] && gcc <= componentX[k] + componentWidth[k] && gcd <= componentY[k] + componentHeight[k])
                    componentSkip[k] = true;

            gch -= 5;
        }
    }

    public boolean isClicked(int i) {
        if(componentAcceptsInput[i] && componentSkip[i]) {
            componentSkip[i] = false;
            return true;
        } else {
            return false;
        }
    }

    public void keyPress(int arg0) {
        if(arg0 == 0)
            return;
        if(selectedComponent != -1 && componentText[selectedComponent] != null && componentAcceptsInput[selectedComponent]) {
            int i = componentText[selectedComponent].length();
            if(arg0 == 8 && i > 0)
                componentText[selectedComponent] = componentText[selectedComponent].substring(0, i - 1);
            if((arg0 == 10 || arg0 == 13) && i > 0)
                componentSkip[selectedComponent] = true;
            String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
            if(i < copmonentInputMaxLength[selectedComponent]) {
                for(int k = 0; k < s.length(); k++)
                    if(arg0 == s.charAt(k))
                        componentText[selectedComponent] += (char)arg0;

            }
            if(arg0 == 9) {
                do
                    selectedComponent = (selectedComponent + 1) % gak;
                while(componentType[selectedComponent] != 5 && componentType[selectedComponent] != 6);
                return;
            }
        }
    }

    public void drawMenu() {
        for(int i = 0; i < gak; i++)
            if(componentAcceptsInput[i])
                if(componentType[i] == 0)
                    gef(i, componentX[i], componentY[i], componentText[i], componentTextSize[i]);
                else
                if(componentType[i] == 1)
                    gef(i, componentX[i] - gaj.textWidth(componentText[i], componentTextSize[i]) / 2, componentY[i], componentText[i], componentTextSize[i]);
                else
                if(componentType[i] == 2)
                    gei(componentX[i], componentY[i], componentWidth[i], componentHeight[i]);
                else
                if(componentType[i] == 3)
                    gel(componentX[i], componentY[i], componentWidth[i]);
                else
                if(componentType[i] == 4)
                    gem(i, componentX[i], componentY[i], componentWidth[i], componentHeight[i], componentTextSize[i], componentTextList[i], listLength[i], gbc[i]);
                else
                if(componentType[i] == 5 || componentType[i] == 6)
                    geh(i, componentX[i], componentY[i], componentWidth[i], componentHeight[i], componentText[i], componentTextSize[i]);
                else
                if(componentType[i] == 7)
                    gfa(i, componentX[i], componentY[i], componentTextSize[i], componentTextList[i]);
                else
                if(componentType[i] == 8)
                    gfb(i, componentX[i], componentY[i], componentTextSize[i], componentTextList[i]);
                else
                if(componentType[i] == 9)
                    gfc(i, componentX[i], componentY[i], componentWidth[i], componentHeight[i], componentTextSize[i], componentTextList[i], listLength[i], gbc[i]);
                else
                if(componentType[i] == 11)
                    gej(componentX[i], componentY[i], componentWidth[i], componentHeight[i]);
                else
                if(componentType[i] == 12)
                    gek(componentX[i], componentY[i], componentTextSize[i]);
                else
                if(componentType[i] == 14)
                    gee(i, componentX[i], componentY[i], componentWidth[i], componentHeight[i]);

        gce = 0;
    }

    protected void gee(int arg0, int arg1, int arg2, int arg3, int arg4) {
        gaj.drawBox(arg1, arg2, arg3, arg4, 0xffffff);
        gaj.drawLineX(arg1, arg2, arg3, gdc);
        gaj.drawLineY(arg1, arg2, arg4, gdc);
        gaj.drawLineX(arg1, (arg2 + arg4) - 1, arg3, gdf);
        gaj.drawLineY((arg1 + arg3) - 1, arg2, arg4, gdf);
        if(gbe[arg0] == 1) {
            for(int i = 0; i < arg4; i++) {
                gaj.drawLineX(arg1 + i, arg2 + i, 1, 0);
                gaj.drawLineX((arg1 + arg3) - 1 - i, arg2 + i, 1, 0);
            }

        }
    }

    protected void gef(int i, int k, int l, String s, int i1) {
        int j1 = l + gaj.textHeightNumber(i1) / 3;
        geg(i, k, j1, s, i1);
    }

    protected void geg(int arg0, int arg1, int arg2, String arg3, int arg4) {
        int i;
        if(componentWhiteText[arg0])
            i = 0xffffff;
        else
            i = 0;
        gaj.drawString(arg3, arg1, arg2, arg4, i);
    }

    protected void geh(int arg0, int arg1, int arg2, int arg3, int arg4, String arg5, int arg6) {
        if(componentIsPasswordField[arg0]) {
            int i = arg5.length();
            arg5 = "";
            for(int l = 0; l < i; l++)
                arg5 = arg5 + "X";

        }
        if(componentType[arg0] == 5) {
            if(gce == 1 && gcc >= arg1 && gcd >= arg2 - arg4 / 2 && gcc <= arg1 + arg3 && gcd <= arg2 + arg4 / 2)
                selectedComponent = arg0;
        } else
        if(componentType[arg0] == 6) {
            if(gce == 1 && gcc >= arg1 - arg3 / 2 && gcd >= arg2 - arg4 / 2 && gcc <= arg1 + arg3 / 2 && gcd <= arg2 + arg4 / 2)
                selectedComponent = arg0;
            arg1 -= gaj.textWidth(arg5, arg6) / 2;
        }
        if(selectedComponent == arg0)
            arg5 = arg5 + "*";
        int k = arg2 + gaj.textHeightNumber(arg6) / 3;
        geg(arg0, arg1, k, arg5, arg6);
    }

    public void gei(int arg0, int arg1, int arg2, int arg3) {
        gaj.setGameBoundaries(arg0, arg1, arg0 + arg2, arg1 + arg3);
        gaj.can(arg0, arg1, arg2, arg3, gdf, gdc);
        if(gdh) {
            for(int i = arg0 - (arg1 & 0x3f); i < arg0 + arg2; i += 128) {
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

    public void gej(int i, int k, int l, int i1) {
        gaj.drawBox(i, k, l, i1, 0);
        gaj.drawBoxEdge(i, k, l, i1, gcn);
        gaj.drawBoxEdge(i + 1, k + 1, l - 2, i1 - 2, gda);
        gaj.drawBoxEdge(i + 2, k + 2, l - 4, i1 - 4, gdb);
        gaj.drawPicture(i, k, 2 + gdi);
        gaj.drawPicture((i + l) - 7, k, 3 + gdi);
        gaj.drawPicture(i, (k + i1) - 7, 4 + gdi);
        gaj.drawPicture((i + l) - 7, (k + i1) - 7, 5 + gdi);
    }

    protected void gek(int i, int k, int l) {
        gaj.drawPicture(i, k, l);
    }

    protected void gel(int i, int k, int l) {
        gaj.drawLineX(i, k, l, 0);
    }

    protected void gem(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, String arg6[], 
            int arg7, int arg8) {
        int i = arg4 / gaj.textHeightNumber(arg5);
        if(arg8 > arg7 - i)
            arg8 = arg7 - i;
        if(arg8 < 0)
            arg8 = 0;
        gbc[arg0] = arg8;
        if(i < arg7) {
            int k = (arg1 + arg3) - 12;
            int i1 = ((arg4 - 27) * i) / arg7;
            if(i1 < 6)
                i1 = 6;
            int k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            if(gcf == 1 && gcc >= k && gcc <= k + 12) {
                if(gcd > arg2 && gcd < arg2 + 12 && arg8 > 0)
                    arg8--;
                if(gcd > (arg2 + arg4) - 12 && gcd < arg2 + arg4 && arg8 < arg7 - i)
                    arg8++;
                gbc[arg0] = arg8;
            }
            if(gcf == 1 && (gcc >= k && gcc <= k + 12 || gcc >= k - 12 && gcc <= k + 24 && gan[arg0])) {
                if(gcd > arg2 + 12 && gcd < (arg2 + arg4) - 12) {
                    gan[arg0] = true;
                    int i2 = gcd - arg2 - 12 - i1 / 2;
                    arg8 = (i2 * arg7) / (arg4 - 24);
                    if(arg8 > arg7 - i)
                        arg8 = arg7 - i;
                    if(arg8 < 0)
                        arg8 = 0;
                    gbc[arg0] = arg8;
                }
            } else {
                gan[arg0] = false;
            }
            k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            gen(arg1, arg2, arg3, arg4, k1, i1);
        }
        int l = arg4 - i * gaj.textHeightNumber(arg5);
        int j1 = arg2 + (gaj.textHeightNumber(arg5) * 5) / 6 + l / 2;
        for(int l1 = arg8; l1 < arg7; l1++) {
            geg(arg0, arg1 + 2, j1, arg6[l1], arg5);
            j1 += gaj.textHeightNumber(arg5) - chatMenuTextHeightMod;
            if(j1 >= arg2 + arg4)
                return;
        }

    }

    protected void gen(int i, int k, int l, int i1, int j1, int k1) {
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

    protected void gfa(int arg0, int arg1, int arg2, int arg3, String arg4[]) {
        int i = 0;
        int k = arg4.length;
        for(int l = 0; l < k; l++) {
            i += gaj.textWidth(arg4[l], arg3);
            if(l < k - 1)
                i += gaj.textWidth("  ", arg3);
        }

        int i1 = arg1 - i / 2;
        int j1 = arg2 + gaj.textHeightNumber(arg3) / 3;
        for(int k1 = 0; k1 < k; k1++) {
            int l1;
            if(componentWhiteText[arg0])
                l1 = 0xffffff;
            else
                l1 = 0;
            if(gcc >= i1 && gcc <= i1 + gaj.textWidth(arg4[k1], arg3) && gcd <= j1 && gcd > j1 - gaj.textHeightNumber(arg3)) {
                if(componentWhiteText[arg0])
                    l1 = 0x808080;
                else
                    l1 = 0xffffff;
                if(gce == 1) {
                    gbe[arg0] = k1;
                    componentSkip[arg0] = true;
                }
            }
            if(gbe[arg0] == k1)
                if(componentWhiteText[arg0])
                    l1 = 0xff0000;
                else
                    l1 = 0xc00000;
            gaj.drawString(arg4[k1], i1, j1, arg3, l1);
            i1 += gaj.textWidth(arg4[k1] + "  ", arg3);
        }

    }

    protected void gfb(int arg0, int arg1, int arg2, int arg3, String arg4[]) {
        int i = arg4.length;
        int k = arg2 - (gaj.textHeightNumber(arg3) * (i - 1)) / 2;
        for(int l = 0; l < i; l++) {
            int i1;
            if(componentWhiteText[arg0])
                i1 = 0xffffff;
            else
                i1 = 0;
            int j1 = gaj.textWidth(arg4[l], arg3);
            if(gcc >= arg1 - j1 / 2 && gcc <= arg1 + j1 / 2 && gcd - 2 <= k && gcd - 2 > k - gaj.textHeightNumber(arg3)) {
                if(componentWhiteText[arg0])
                    i1 = 0x808080;
                else
                    i1 = 0xffffff;
                if(gce == 1) {
                    gbe[arg0] = l;
                    componentSkip[arg0] = true;
                }
            }
            if(gbe[arg0] == l)
                if(componentWhiteText[arg0])
                    i1 = 0xff0000;
                else
                    i1 = 0xc00000;
            gaj.drawString(arg4[l], arg1 - j1 / 2, k, arg3, i1);
            k += gaj.textHeightNumber(arg3);
        }

    }

    protected void gfc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, String arg6[], 
            int arg7, int arg8) {
        int i = arg4 / gaj.textHeightNumber(arg5);
        if(i < arg7) {
            int k = (arg1 + arg3) - 12;
            int i1 = ((arg4 - 27) * i) / arg7;
            if(i1 < 6)
                i1 = 6;
            int k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            if(gcf == 1 && gcc >= k && gcc <= k + 12) {
                if(gcd > arg2 && gcd < arg2 + 12 && arg8 > 0)
                    arg8--;
                if(gcd > (arg2 + arg4) - 12 && gcd < arg2 + arg4 && arg8 < arg7 - i)
                    arg8++;
                gbc[arg0] = arg8;
            }
            if(gcf == 1 && (gcc >= k && gcc <= k + 12 || gcc >= k - 12 && gcc <= k + 24 && gan[arg0])) {
                if(gcd > arg2 + 12 && gcd < (arg2 + arg4) - 12) {
                    gan[arg0] = true;
                    int i2 = gcd - arg2 - 12 - i1 / 2;
                    arg8 = (i2 * arg7) / (arg4 - 24);
                    if(arg8 < 0)
                        arg8 = 0;
                    if(arg8 > arg7 - i)
                        arg8 = arg7 - i;
                    gbc[arg0] = arg8;
                }
            } else {
                gan[arg0] = false;
            }
            k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            gen(arg1, arg2, arg3, arg4, k1, i1);
        } else {
            arg8 = 0;
            gbc[arg0] = 0;
        }
        gbf[arg0] = -1;
        int l = arg4 - i * gaj.textHeightNumber(arg5);
        int j1 = arg2 + (gaj.textHeightNumber(arg5) * 5) / 6 + l / 2;
        for(int l1 = arg8; l1 < arg7; l1++) {
            int j2;
            if(componentWhiteText[arg0])
                j2 = 0xffffff;
            else
                j2 = 0;
            if(gcc >= arg1 + 2 && gcc <= arg1 + 2 + gaj.textWidth(arg6[l1], arg5) && gcd - 2 <= j1 && gcd - 2 > j1 - gaj.textHeightNumber(arg5)) {
                if(componentWhiteText[arg0])
                    j2 = 0x808080;
                else
                    j2 = 0xffffff;
                gbf[arg0] = l1;
                if(gce == 1) {
                    gbe[arg0] = l1;
                    componentSkip[arg0] = true;
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

    public int drawText(int i, int k, String s, int l, boolean flag) {
        componentType[gak] = 1;
        componentAcceptsInput[gak] = true;
        componentSkip[gak] = false;
        componentTextSize[gak] = l;
        componentWhiteText[gak] = flag;
        componentX[gak] = i;
        componentY[gak] = k;
        componentText[gak] = s;
        return gak++;
    }

    public int drawButton(int i, int k, int l, int i1) {
        componentType[gak] = 2;
        componentAcceptsInput[gak] = true;
        componentSkip[gak] = false;
        componentX[gak] = i - l / 2;
        componentY[gak] = k - i1 / 2;
        componentWidth[gak] = l;
        componentHeight[gak] = i1;
        return gak++;
    }

    public int drawCurvedBox(int i, int k, int l, int i1) {
        componentType[gak] = 11;
        componentAcceptsInput[gak] = true;
        componentSkip[gak] = false;
        componentX[gak] = i - l / 2;
        componentY[gak] = k - i1 / 2;
        componentWidth[gak] = l;
        componentHeight[gak] = i1;
        return gak++;
    }

    public int drawArrow(int i, int k, int l) {
        int i1 = gaj.pictureWidth[l];
        int j1 = gaj.pictureHeight[l];
        componentType[gak] = 12;
        componentAcceptsInput[gak] = true;
        componentSkip[gak] = false;
        componentX[gak] = i - i1 / 2;
        componentY[gak] = k - j1 / 2;
        componentWidth[gak] = i1;
        componentHeight[gak] = j1;
        componentTextSize[gak] = l;
        return gak++;
    }

    public int gfh(int i, int k, int l, int i1, int j1, int k1, boolean flag) {
        componentType[gak] = 4;
        componentAcceptsInput[gak] = true;
        componentSkip[gak] = false;
        componentX[gak] = i;
        componentY[gak] = k;
        componentWidth[gak] = l;
        componentHeight[gak] = i1;
        componentWhiteText[gak] = flag;
        componentTextSize[gak] = j1;
        copmonentInputMaxLength[gak] = k1;
        listLength[gak] = 0;
        gbc[gak] = 0;
        componentTextList[gak] = new String[k1];
        return gak++;
    }

    public int gfi(int i, int k, int l, int i1, int j1, int k1, boolean flag, 
            boolean flag1) {
        componentType[gak] = 5;
        componentAcceptsInput[gak] = true;
        componentIsPasswordField[gak] = flag;
        componentSkip[gak] = false;
        componentTextSize[gak] = j1;
        componentWhiteText[gak] = flag1;
        componentX[gak] = i;
        componentY[gak] = k;
        componentWidth[gak] = l;
        componentHeight[gak] = i1;
        copmonentInputMaxLength[gak] = k1;
        componentText[gak] = "";
        return gak++;
    }

    public int createInput(int i, int k, int l, int i1, int j1, int k1, boolean flag, 
            boolean flag1) {
        componentType[gak] = 6;
        componentAcceptsInput[gak] = true;
        componentIsPasswordField[gak] = flag;
        componentSkip[gak] = false;
        componentTextSize[gak] = j1;
        componentWhiteText[gak] = flag1;
        componentX[gak] = i;
        componentY[gak] = k;
        componentWidth[gak] = l;
        componentHeight[gak] = i1;
        copmonentInputMaxLength[gak] = k1;
        componentText[gak] = "";
        return gak++;
    }

    public int createList(int i, int k, int l, int i1, int j1, int k1, boolean flag) {
        componentType[gak] = 9;
        componentAcceptsInput[gak] = true;
        componentSkip[gak] = false;
        componentTextSize[gak] = j1;
        componentWhiteText[gak] = flag;
        componentX[gak] = i;
        componentY[gak] = k;
        componentWidth[gak] = l;
        componentHeight[gak] = i1;
        copmonentInputMaxLength[gak] = k1;
        componentTextList[gak] = new String[k1];
        listLength[gak] = 0;
        gbc[gak] = 0;
        gbe[gak] = -1;
        gbf[gak] = -1;
        return gak++;
    }

    public int createButton(int i, int k, int l, int i1) {
        componentType[gak] = 10;
        componentAcceptsInput[gak] = true;
        componentSkip[gak] = false;
        componentX[gak] = i - l / 2;
        componentY[gak] = k - i1 / 2;
        componentWidth[gak] = l;
        componentHeight[gak] = i1;
        return gak++;
    }

    public void clearList(int i) {
        listLength[i] = 0;
    }

    public void switchList(int i) {
        gbc[i] = 0;
        gbf[i] = -1;
    }

    public void addListItem(int i, int k, String s) {
        componentTextList[i][k] = s;
        if(k + 1 > listLength[i])
            listLength[i] = k + 1;
    }

    public void addMessage(int arg0, String arg1, boolean arg2) {
        int i = listLength[arg0]++;
        if(i >= copmonentInputMaxLength[arg0]) {
            i--;
            listLength[arg0]--;
            for(int k = 0; k < i; k++)
                componentTextList[arg0][k] = componentTextList[arg0][k + 1];

        }
        componentTextList[arg0][i] = arg1;
        if(arg2)
            gbc[arg0] = 0xf423f;
    }

    public void updateText(int i, String s) {
        componentText[i] = s;
    }

    public String getText(int i) {
        if(componentText[i] == null)
            return "null";
        else
            return componentText[i];
    }

    public void gge(int i) {
        componentAcceptsInput[i] = true;
    }

    public void ggf(int i) {
        componentAcceptsInput[i] = false;
    }

    public void setFocus(int i) {
        selectedComponent = i;
    }

    public int getEntryHighlighted(int i) {
        int k = gbf[i];
        return k;
    }

    protected GameImage gaj;
    int gak;
    int gal;
    public boolean componentAcceptsInput[];
    public boolean gan[];
    public boolean componentIsPasswordField[];
    public boolean componentSkip[];
    public int gbc[];
    public int listLength[];
    public int gbe[];
    public int gbf[];
    boolean componentWhiteText[];
    int componentX[];
    int componentY[];
    int componentType[];
    int componentWidth[];
    int componentHeight[];
    int copmonentInputMaxLength[];
    int componentTextSize[];
    String componentText[];
    String componentTextList[][];
    int gcc;
    int gcd;
    int gce;
    int gcf;
    int selectedComponent;
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
