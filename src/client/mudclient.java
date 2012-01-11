package client;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

public final class mudclient extends GameAppletMiddleMan
{

    public static final void main(String args[])
    {
        mudclient mud = new mudclient();
        mud.appletMode = false;
        mud.members = true;
        mud.server = "216.24.201.81";
        mud.port = 43595;
        mud.flc(mud.windowWidth, mud.windowHeight + 11, "Runescape by Andrew Gower", false);
        mud.gameMinThreadSleepTime = 10;
    }

    private final void menuClick(int l)
    {
        int actionX = menuActionX[l];
        int actionY = menuActionY[l];
        int actionType = menuActionType[l];
        int actionVar1 = menuActionVar1[l];
        int actionVar2 = menuActionVar2[l];
        int actionID = menuActionID[l];
        if(actionID == 200)
        {
            walkToGroundItem(sectionX, sectionY, actionX, actionY, true);
            super.streamClass.createPacket(104);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addShort(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedSpell = -1;
        }
        if(actionID == 210)
        {
            walkToGroundItem(sectionX, sectionY, actionX, actionY, true);
            super.streamClass.createPacket(34);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addShort(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedItem = -1;
        }
        if(actionID == 220)
        {
            walkToGroundItem(sectionX, sectionY, actionX, actionY, true);
            super.streamClass.createPacket(245);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addShort(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
        }
        if(actionID == 3200)
            displayMessage(Data.itemDescription[actionType], 3);
        if(actionID == 300)
        {
            walkToWallObject(actionX, actionY, actionType);
            super.streamClass.createPacket(67);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addByte(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedSpell = -1;
        }
        if(actionID == 310)
        {
            walkToWallObject(actionX, actionY, actionType);
            super.streamClass.createPacket(36);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addByte(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedItem = -1;
        }
        if(actionID == 320)
        {
            walkToWallObject(actionX, actionY, actionType);
            super.streamClass.createPacket(126);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addByte(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 2300)
        {
            walkToWallObject(actionX, actionY, actionType);
            super.streamClass.createPacket(235);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addByte(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 3300)
            displayMessage(Data.wallObjectDescription[actionType], 3);
        if(actionID == 400)
        {
            walkToObject(actionX, actionY, actionType, actionVar1);
            super.streamClass.createPacket(17);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addShort(actionVar2);
            super.streamClass.formatPacket();
            selectedSpell = -1;
        }
        if(actionID == 410)
        {
            walkToObject(actionX, actionY, actionType, actionVar1);
            super.streamClass.createPacket(94);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addShort(actionVar2);
            super.streamClass.formatPacket();
            selectedItem = -1;
        }
        if(actionID == 420)
        {
            walkToObject(actionX, actionY, actionType, actionVar1);
            super.streamClass.createPacket(51);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.formatPacket();
        }
        if(actionID == 2400)
        {
            walkToObject(actionX, actionY, actionType, actionVar1);
            super.streamClass.createPacket(40);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.formatPacket();
        }
        if(actionID == 3400)
            displayMessage(Data.objectDescription[actionType], 3);
        if(actionID == 600)
        {
            super.streamClass.createPacket(49);
            super.streamClass.addShort(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedSpell = -1;
        }
        if(actionID == 610)
        {
            super.streamClass.createPacket(27);
            super.streamClass.addShort(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedItem = -1;
        }
        if(actionID == 620)
        {
            super.streamClass.createPacket(92);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 630)
        {
            super.streamClass.createPacket(181);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 640)
        {
            super.streamClass.createPacket(89);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 650)
        {
            selectedItem = actionType;
            drawMenuTab = 0;
            selectedItemName = Data.itemName[inventoryItems[selectedItem]];
        }
        if(actionID == 660)
        {
            super.streamClass.createPacket(147);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
            selectedItem = -1;
            drawMenuTab = 0;
            displayMessage("Dropping " + Data.itemName[inventoryItems[actionType]], 4);
        }
        if(actionID == 3600)
            displayMessage(Data.itemDescription[actionType], 3);
        if(actionID == 700)
        {
            int k2 = (actionX - 64) / magicLoc;
            int k4 = (actionY - 64) / magicLoc;
            walkTo1Tile(sectionX, sectionY, k2, k4, true);
            super.streamClass.createPacket(71);
            super.streamClass.addShort(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedSpell = -1;
        }
        if(actionID == 710)
        {
            int l2 = (actionX - 64) / magicLoc;
            int l4 = (actionY - 64) / magicLoc;
            walkTo1Tile(sectionX, sectionY, l2, l4, true);
            super.streamClass.createPacket(142);
            super.streamClass.addShort(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedItem = -1;
        }
        if(actionID == 720)
        {
            int i3 = (actionX - 64) / magicLoc;
            int i5 = (actionY - 64) / magicLoc;
            walkTo1Tile(sectionX, sectionY, i3, i5, true);
            super.streamClass.createPacket(177);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 725)
        {
            int j3 = (actionX - 64) / magicLoc;
            int j5 = (actionY - 64) / magicLoc;
            walkTo1Tile(sectionX, sectionY, j3, j5, true);
            super.streamClass.createPacket(74);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 715 || actionID == 2715)
        {
            int k3 = (actionX - 64) / magicLoc;
            int k5 = (actionY - 64) / magicLoc;
            walkTo1Tile(sectionX, sectionY, k3, k5, true);
            super.streamClass.createPacket(73);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 3700)
            displayMessage(Data.npcDescription[actionType], 3);
        if(actionID == 800)
        {
            int l3 = (actionX - 64) / magicLoc;
            int l5 = (actionY - 64) / magicLoc;
            walkTo1Tile(sectionX, sectionY, l3, l5, true);
            super.streamClass.createPacket(55);
            super.streamClass.addShort(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedSpell = -1;
        }
        if(actionID == 810)
        {
            int i4 = (actionX - 64) / magicLoc;
            int i6 = (actionY - 64) / magicLoc;
            walkTo1Tile(sectionX, sectionY, i4, i6, true);
            super.streamClass.createPacket(16);
            super.streamClass.addShort(actionType);
            super.streamClass.addShort(actionVar1);
            super.streamClass.formatPacket();
            selectedItem = -1;
        }
        if(actionID == 805 || actionID == 2805)
        {
            int j4 = (actionX - 64) / magicLoc;
            int j6 = (actionY - 64) / magicLoc;
            walkTo1Tile(sectionX, sectionY, j4, j6, true);
            super.streamClass.createPacket(57);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 2806)
        {
            super.streamClass.createPacket(222);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 2810)
        {
            super.streamClass.createPacket(166);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 2820)
        {
            super.streamClass.createPacket(68);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
        }
        if(actionID == 900)
        {
            walkTo1Tile(sectionX, sectionY, actionX, actionY, true);
            super.streamClass.createPacket(232);
            super.streamClass.addShort(actionX + areaX);
            super.streamClass.addShort(actionY + areaY);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
            selectedSpell = -1;
        }
        if(actionID == 920)
        {
            walkTo1Tile(sectionX, sectionY, actionX, actionY, false);
            if(actionPictureType == -24)
                actionPictureType = 24;
        }
        if(actionID == 1000)
        {
            super.streamClass.createPacket(206);
            super.streamClass.addShort(actionType);
            super.streamClass.formatPacket();
            selectedSpell = -1;
        }
        if(actionID == 4000)
        {
            selectedItem = -1;
            selectedSpell = -1;
        }
    }

    protected final void resetIntVars()
    {
        systemUpdate = 0;
        loginScreen = 0;
        loggedIn = 0;
        logoutTimer = 0;
    }

    private final void drawReportAbuseBox1()
    {
        reportAbuseOptionSelected = 0;
        int yOffset = 135;
        for(int option = 0; option < 12; option++)
        {
            if(super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= yOffset - 12 && super.mouseY < yOffset + 3)
                reportAbuseOptionSelected = option + 1;
            yOffset += 14;
        }

        if(mouseButtonClick != 0 && reportAbuseOptionSelected != 0)
        {
            mouseButtonClick = 0;
            showAbuseBox = 2;
            super.inputText = "";
            super.enteredInputText = "";
            return;
        }
        yOffset += 15;
        if(mouseButtonClick != 0)
        {
            mouseButtonClick = 0;
            if(super.mouseX < 56 || super.mouseY < 35 || super.mouseX > 456 || super.mouseY > 325)
            {
                showAbuseBox = 0;
                return;
            }
            if(super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= yOffset - 15 && super.mouseY < yOffset + 5)
            {
                showAbuseBox = 0;
                return;
            }
        }
        gameGraphics.drawBox(56, 35, 400, 290, 0);
        gameGraphics.drawBoxEdge(56, 35, 400, 290, 0xffffff);
        yOffset = 50;
        gameGraphics.drawText("This form is for reporting players who are breaking our rules", 256, yOffset, 1, 0xffffff);
        yOffset += 15;
        gameGraphics.drawText("Using it sends a snapshot of the last 60 secs of activity to us", 256, yOffset, 1, 0xffffff);
        yOffset += 15;
        gameGraphics.drawText("If you misuse this form, you will be banned.", 256, yOffset, 1, 0xff8000);
        yOffset += 15;
        yOffset += 10;
        gameGraphics.drawText("First indicate which of our 12 rules is being broken. For a detailed", 256, yOffset, 1, 0xffff00);
        yOffset += 15;
        gameGraphics.drawText("explanation of each rule please read the manual on our website.", 256, yOffset, 1, 0xffff00);
        yOffset += 15;
        int j1;
        if(reportAbuseOptionSelected == 1)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("1: Offensive language", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 2)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("2: Item scamming", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 3)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("3: Password scamming", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 4)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("4: Bug abuse", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 5)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("5: Jagex Staff impersonation", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 6)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("6: Account sharing/trading", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 7)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("7: Macroing", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 8)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("8: Mutiple logging in", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 9)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("9: Encouraging others to break rules", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 10)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("10: Misuse of customer support", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 11)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("11: Advertising / website", 256, yOffset, 1, j1);
        yOffset += 14;
        if(reportAbuseOptionSelected == 12)
        {
            gameGraphics.drawBoxEdge(66, yOffset - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gameGraphics.drawText("12: Real world item trading", 256, yOffset, 1, j1);
        yOffset += 14;
        yOffset += 15;
        j1 = 0xffffff;
        if(super.mouseX > 196 && super.mouseX < 316 && super.mouseY > yOffset - 15 && super.mouseY < yOffset + 5)
            j1 = 0xffff00;
        gameGraphics.drawText("Click here to cancel", 256, yOffset, 1, j1);
    }

    private final void loadMap()
    {
        engineHandle.mapsFree = unpackData("maps" + Version.VERSION_MAP + ".jag", "map", 70);
        if(members)
            engineHandle.mapsMembers = unpackData("maps" + Version.VERSION_MAP + ".mem", "members map", 75);
        engineHandle.landscapeFree = unpackData("land" + Version.VERSION_MAP + ".jag", "landscape", 80);
        if(members)
            engineHandle.landscapeMembers = unpackData("land" + Version.VERSION_MAP + ".mem", "members landscape", 85);
    }

    private final void emj(int l, String s1)
    {
        int i1 = objectX[l];
        int j1 = objectY[l];
        int k1 = i1 - ourPlayer.currentX / 128;
        int l1 = j1 - ourPlayer.currentY / 128;
        byte byte0 = 7;
        if(i1 >= 0 && j1 >= 0 && i1 < 96 && j1 < 96 && k1 > -byte0 && k1 < byte0 && l1 > -byte0 && l1 < byte0)
        {
            gameCamera.removeModel(objectArray[l]);
            int i2 = Data.anj(s1);
            i j2 = gameDataObjects[i2].cnj();
            gameCamera.bgm(j2);
            j2.cme(true, 48, 48, -50, -10, -50);
            j2.cnl(objectArray[l]);
            j2.chk = l;
            objectArray[l] = j2;
        }
    }

    final void emk(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        Mob f1 = playerArray[arg4];
        if(f1.hab == 255)
            return;
        int l = f1.currentSprite + (cameraRotation + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;
        if(i1 == 5)
        {
            i1 = 3;
            flag = true;
        } else
        if(i1 == 6)
        {
            i1 = 2;
            flag = true;
        } else
        if(i1 == 7)
        {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + dhn[(f1.stepCount / 6) % 4];
        if(f1.currentSprite == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (5 * arg6) / 100;
            j1 = i1 * 3 + eme[(tick / 5) % 8];
        } else
        if(f1.currentSprite == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (5 * arg6) / 100;
            j1 = i1 * 3 + eab[(tick / 6) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = dgl[l][k1];
            int l2 = f1.gnd[l1] - 1;
            if(l2 >= 0)
            {
                int k3 = 0;
                int i4 = 0;
                int j4 = j1;
                if(flag && i1 >= 1 && i1 <= 3)
                    if(Data.animationHasF[l2] == 1)
                        j4 += 15;
                    else
                    if(l1 == 4 && i1 == 1)
                    {
                        k3 = -22;
                        i4 = -3;
                        j4 = i1 * 3 + dhn[(2 + f1.stepCount / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = -8;
                        j4 = i1 * 3 + dhn[(2 + f1.stepCount / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 3)
                    {
                        k3 = 26;
                        i4 = -5;
                        j4 = i1 * 3 + dhn[(2 + f1.stepCount / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 1)
                    {
                        k3 = 22;
                        i4 = 3;
                        j4 = i1 * 3 + dhn[(2 + f1.stepCount / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = 8;
                        j4 = i1 * 3 + dhn[(2 + f1.stepCount / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 3)
                    {
                        k3 = -26;
                        i4 = 5;
                        j4 = i1 * 3 + dhn[(2 + f1.stepCount / 6) % 4];
                    }
                if(i1 != 5 || Data.animationHasA[l2] == 1)
                {
                    int k4 = j4 + Data.animationNumber[l2];
                    k3 = (k3 * arg2) / ((GameImage) (gameGraphics)).bmj[k4];
                    i4 = (i4 * arg3) / ((GameImage) (gameGraphics)).bmk[k4];
                    int l4 = (arg2 * ((GameImage) (gameGraphics)).bmj[k4]) / ((GameImage) (gameGraphics)).bmj[Data.animationNumber[l2]];
                    k3 -= (l4 - arg2) / 2;
                    int i5 = Data.alh[l2];
                    int j5 = dki[f1.hac];
                    if(i5 == 1)
                        i5 = appearanceHairColours[f1.gnn];
                    else
                    if(i5 == 2)
                        i5 = appearanceTopBottomColours[f1.haa];
                    else
                    if(i5 == 3)
                        i5 = appearanceTopBottomColours[f1.hab];
                    gameGraphics.drawImage(arg0 + k3, arg1 + i4, l4, arg3, k4, i5, j5, arg5, flag);
                }
            }
        }

        if(f1.lastMessageTimeout > 0)
        {
            eaf[egg] = gameGraphics.textWidth(f1.gne, 1) / 2;
            if(eaf[egg] > 150)
                eaf[egg] = 150;
            eag[egg] = (gameGraphics.textWidth(f1.gne, 1) / 300) * gameGraphics.ced(1);
            ead[egg] = arg0 + arg2 / 2;
            eae[egg] = arg1;
            egh[egg++] = f1.gne;
        }
        if(f1.itemAboveHeadTimeout > 0)
        {
            ebk[dib] = arg0 + arg2 / 2;
            ebl[dib] = arg1;
            dfi[dib] = arg6;
            dfj[dib++] = f1.gng;
        }
        if(f1.currentSprite == 8 || f1.currentSprite == 9 || f1.combatTimer != 0)
        {
            if(f1.combatTimer > 0)
            {
                int i2 = arg0;
                if(f1.currentSprite == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.currentSprite == 9)
                    i2 += (20 * arg6) / 100;
                int i3 = (f1.gnj * 30) / f1.gnk;
                ekj[ejl] = i2 + arg2 / 2;
                ekk[ejl] = arg1;
                ekl[ejl++] = i3;
            }
            if(f1.combatTimer > 150)
            {
                int j2 = arg0;
                if(f1.currentSprite == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.currentSprite == 9)
                    j2 += (10 * arg6) / 100;
                gameGraphics.drawPicture((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, baseInventoryPic + 11);
                gameGraphics.drawText(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
        if(f1.haj == 1 && f1.itemAboveHeadTimeout == 0)
        {
            int k2 = arg5 + arg0 + arg2 / 2;
            if(f1.currentSprite == 8)
                k2 -= (20 * arg6) / 100;
            else
            if(f1.currentSprite == 9)
                k2 += (20 * arg6) / 100;
            int j3 = (16 * arg6) / 100;
            int l3 = (16 * arg6) / 100;
            gameGraphics.ccc(k2 - j3 / 2, arg1 - l3 / 2 - (10 * arg6) / 100, j3, l3, baseInventoryPic + 13);
        }
    }

    private final void walkToWallObject(int x, int y, int direction)
    {
        if(direction == 0)
        {
            walkTo(sectionX, sectionY, x, y - 1, x, y, false, true);
            return;
        }
        if(direction == 1)
        {
            walkTo(sectionX, sectionY, x - 1, y, x, y, false, true);
            return;
        } else
        {
            walkTo(sectionX, sectionY, x, y, x, y, true, true);
            return;
        }
    }

    private final void drawDuelConfirmBox()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        gameGraphics.drawBox(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        gameGraphics.drawBoxAlpha(byte0, byte1 + 16, 468, 246, l, 160);
        gameGraphics.drawText("Please confirm your duel with @yel@" + DataOperations.hashToName(duelOpponentHash), byte0 + 234, byte1 + 12, 1, 0xffffff);
        gameGraphics.drawText("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < duelOurStakeCount; i1++)
        {
            String s1 = Data.itemName[duelOurStakeItem[i1]];
            if(Data.itemStackable[duelOurStakeItem[i1]] == 0)
                s1 = s1 + " x " + formatItemCount(duelOurStakeItemCount[i1]);
            gameGraphics.drawText(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(duelOurStakeCount == 0)
            gameGraphics.drawText("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        gameGraphics.drawText("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < duelOpponentStakeCount; j1++)
        {
            String s2 = Data.itemName[eff[j1]];
            if(Data.itemStackable[eff[j1]] == 0)
                s2 = s2 + " x " + formatItemCount(duelOutStakeItemCount[j1]);
            gameGraphics.drawText(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(duelOpponentStakeCount == 0)
            gameGraphics.drawText("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(duelRetreat == 0)
            gameGraphics.drawText("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            gameGraphics.drawText("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(duelMagic == 0)
            gameGraphics.drawText("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            gameGraphics.drawText("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(duelPrayer == 0)
            gameGraphics.drawText("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            gameGraphics.drawText("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(duelWeapons == 0)
            gameGraphics.drawText("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            gameGraphics.drawText("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        gameGraphics.drawText("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!duelConfirmOurAccepted)
        {
            gameGraphics.drawPicture((byte0 + 118) - 35, byte1 + 238, baseInventoryPic + 25);
            gameGraphics.drawPicture((byte0 + 352) - 35, byte1 + 238, baseInventoryPic + 26);
        } else
        {
            gameGraphics.drawText("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(mouseButtonClick == 1)
        {
            if(super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262)
            {
                showDuelConfirmBox = false;
                super.streamClass.createPacket(35);
                super.streamClass.formatPacket();
            }
            if(super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                duelConfirmOurAccepted = true;
                super.streamClass.createPacket(87);
                super.streamClass.formatPacket();
            }
            if(super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                showDuelConfirmBox = false;
                super.streamClass.createPacket(35);
                super.streamClass.formatPacket();
            }
            mouseButtonClick = 0;
        }
    }

    private final void setLoginVars()
    {
        loggedIn = 0;
        loginScreen = 0;
        loginUsername = "";
        loginPassword = "";
        /*dja = "Please enter a username:";
        djb = "*" + loginUsername + "*";*/
        playerCount = 0;
        npcCount = 0;
    }

    protected final void close()
    {
        requestLogout();
        cleanUp();
        if(audioPlayer != null)
            audioPlayer.stop();
    }

    protected final Socket makeSocket(String arg0, int arg1)
        throws IOException
    {
        if(link.gameApplet != null)
        {
            Socket socket = link.getSocket(arg1);
            if(socket == null)
                throw new IOException();
            else
                return socket;
        }
        Socket socket1;
        if(inBrowser())
            socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), arg1);
        else
            socket1 = new Socket(InetAddress.getByName(arg0), arg1);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    private final void drawInventoryMenu(boolean canRightClick)
    {
        int l = ((GameImage) (gameGraphics)).gameWidth - 248;
        gameGraphics.drawPicture(l, 3, baseInventoryPic + 1);
        for(int i1 = 0; i1 < maxInventoryItems; i1++)
        {
            int j1 = l + (i1 % 5) * 49;
            int l1 = 36 + (i1 / 5) * 34;
            if(i1 < inventoryItemsCount && inventoryItemEquipped[i1] == 1)
                gameGraphics.drawBoxAlpha(j1, l1, 49, 34, 0xff0000, 128);
            else
                gameGraphics.drawBoxAlpha(j1, l1, 49, 34, GameImage.rgbToInt(181, 181, 181), 128);
            if(i1 < inventoryItemsCount)
            {
                gameGraphics.drawImage(j1, l1, 48, 32, baseItemPicture + Data.itemInventoryPicture[inventoryItems[i1]], Data.itemPictureMask[inventoryItems[i1]], 0, 0, false);
                if(Data.itemStackable[inventoryItems[i1]] == 0)
                    gameGraphics.drawString(String.valueOf(inventoryItemCount[i1]), j1 + 1, l1 + 10, 1, 0xffff00);
            }
        }

        for(int k1 = 1; k1 <= 4; k1++)
            gameGraphics.drawLineY(l + k1 * 49, 36, (maxInventoryItems / 5) * 34, 0);

        for(int i2 = 1; i2 <= maxInventoryItems / 5 - 1; i2++)
            gameGraphics.drawLineX(l, 36 + i2 * 34, 245, 0);

        if(!canRightClick)
            return;
        l = super.mouseX - (((GameImage) (gameGraphics)).gameWidth - 248);
        int j2 = super.mouseY - 36;
        if(l >= 0 && j2 >= 0 && l < 248 && j2 < (maxInventoryItems / 5) * 34)
        {
            int k2 = l / 49 + (j2 / 34) * 5;
            if(k2 < inventoryItemsCount)
            {
                int l2 = inventoryItems[k2];
                if(selectedSpell >= 0)
                {
                    if(Data.amd[selectedSpell] == 3)
                    {
                        menuText1[menuOptionsCount] = "Cast " + Data.spellName[selectedSpell] + " on";
                        menuText2[menuOptionsCount] = "@lre@" + Data.itemName[l2];
                        menuActionID[menuOptionsCount] = 600;
                        menuActionType[menuOptionsCount] = k2;
                        menuActionVar1[menuOptionsCount] = selectedSpell;
                        menuOptionsCount++;
                        return;
                    }
                } else
                {
                    if(selectedItem >= 0)
                    {
                        menuText1[menuOptionsCount] = "Use " + selectedItemName + " with";
                        menuText2[menuOptionsCount] = "@lre@" + Data.itemName[l2];
                        menuActionID[menuOptionsCount] = 610;
                        menuActionType[menuOptionsCount] = k2;
                        menuActionVar1[menuOptionsCount] = selectedItem;
                        menuOptionsCount++;
                        return;
                    }
                    if(inventoryItemEquipped[k2] == 1)
                    {
                        menuText1[menuOptionsCount] = "Remove";
                        menuText2[menuOptionsCount] = "@lre@" + Data.itemName[l2];
                        menuActionID[menuOptionsCount] = 620;
                        menuActionType[menuOptionsCount] = k2;
                        menuOptionsCount++;
                    } else
                    if(Data.itemIsEquippable[l2] != 0)
                    {
                        if((Data.itemIsEquippable[l2] & 0x18) != 0)
                            menuText1[menuOptionsCount] = "Wield";
                        else
                            menuText1[menuOptionsCount] = "Wear";
                        menuText2[menuOptionsCount] = "@lre@" + Data.itemName[l2];
                        menuActionID[menuOptionsCount] = 630;
                        menuActionType[menuOptionsCount] = k2;
                        menuOptionsCount++;
                    }
                    if(!Data.itemCommand[l2].equals(""))
                    {
                        menuText1[menuOptionsCount] = Data.itemCommand[l2];
                        menuText2[menuOptionsCount] = "@lre@" + Data.itemName[l2];
                        menuActionID[menuOptionsCount] = 640;
                        menuActionType[menuOptionsCount] = k2;
                        menuOptionsCount++;
                    }
                    menuText1[menuOptionsCount] = "Use";
                    menuText2[menuOptionsCount] = "@lre@" + Data.itemName[l2];
                    menuActionID[menuOptionsCount] = 650;
                    menuActionType[menuOptionsCount] = k2;
                    menuOptionsCount++;
                    menuText1[menuOptionsCount] = "Drop";
                    menuText2[menuOptionsCount] = "@lre@" + Data.itemName[l2];
                    menuActionID[menuOptionsCount] = 660;
                    menuActionType[menuOptionsCount] = k2;
                    menuOptionsCount++;
                    menuText1[menuOptionsCount] = "Examine";
                    menuText2[menuOptionsCount] = "@lre@" + Data.itemName[l2];
                    menuActionID[menuOptionsCount] = 3600;
                    menuActionType[menuOptionsCount] = l2;
                    menuOptionsCount++;
                }
            }
        }
    }

    private final void creatLoginScreenBackgrounds()
    {
        int l = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        engineHandle.gjj(byte0 * 48 + 23, byte1 * 48 + 23, l);
        engineHandle.glg(gameDataObjects);
        char c1 = '\u2600';
        char c2 = '\u1900';
        char c3 = '\u044C';
        char c4 = '\u0378';
        gameCamera.zoom1 = 4100;
        gameCamera.zoom2 = 4100;
        gameCamera.zoom3 = 1;
        gameCamera.zoom4 = 4000;
        gameCamera.setCamera(c1, -engineHandle.gjf(c1, c2), c2, 912, c4, 0, c3 * 2);
        gameCamera.finishCamera();
        gameGraphics.screenFadeToBlack();
        gameGraphics.screenFadeToBlack();
        gameGraphics.drawBox(0, 0, 512, 6, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            gameGraphics.cbg(0, i1, 0, i1, 512, 8);

        gameGraphics.drawBox(0, 194, 512, 20, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            gameGraphics.cbg(0, j1, 0, 194 - j1, 512, 8);

        gameGraphics.drawPicture(15, 15, baseInventoryPic + 10);
        gameGraphics.cca(baseLoginScreenBackgroundPic, 0, 0, 512, 200);
        gameGraphics.cbl(baseLoginScreenBackgroundPic);
        c1 = '\u2400';
        c2 = '\u2400';
        c3 = '\u044C';
        c4 = '\u0378';
        gameCamera.zoom1 = 4100;
        gameCamera.zoom2 = 4100;
        gameCamera.zoom3 = 1;
        gameCamera.zoom4 = 4000;
        gameCamera.setCamera(c1, -engineHandle.gjf(c1, c2), c2, 912, c4, 0, c3 * 2);
        gameCamera.finishCamera();
        gameGraphics.screenFadeToBlack();
        gameGraphics.screenFadeToBlack();
        gameGraphics.drawBox(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            gameGraphics.cbg(0, k1, 0, k1, 512, 8);

        gameGraphics.drawBox(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            gameGraphics.cbg(0, l1, 0, 194 - l1, 512, 8);

        gameGraphics.drawPicture(15, 15, baseInventoryPic + 10);
        gameGraphics.cca(baseLoginScreenBackgroundPic + 1, 0, 0, 512, 200);
        gameGraphics.cbl(baseLoginScreenBackgroundPic + 1);
        for(int i2 = 0; i2 < 64; i2++)
        {
            gameCamera.removeModel(engineHandle.gih[0][i2]);
            gameCamera.removeModel(engineHandle.gim[1][i2]);
            gameCamera.removeModel(engineHandle.gih[1][i2]);
            gameCamera.removeModel(engineHandle.gim[2][i2]);
            gameCamera.removeModel(engineHandle.gih[2][i2]);
        }

        c1 = '\u2B80';
        c2 = '\u2880';
        c3 = '\u01F4';
        c4 = '\u0178';
        gameCamera.zoom1 = 4100;
        gameCamera.zoom2 = 4100;
        gameCamera.zoom3 = 1;
        gameCamera.zoom4 = 4000;
        gameCamera.setCamera(c1, -engineHandle.gjf(c1, c2), c2, 912, c4, 0, c3 * 2);
        gameCamera.finishCamera();
        gameGraphics.screenFadeToBlack();
        gameGraphics.screenFadeToBlack();
        gameGraphics.drawBox(0, 0, 512, 6, 0);
        for(int j2 = 6; j2 >= 1; j2--)
            gameGraphics.cbg(0, j2, 0, j2, 512, 8);

        gameGraphics.drawBox(0, 194, 512, 20, 0);
        for(int k2 = 6; k2 >= 1; k2--)
            gameGraphics.cbg(0, k2, 0, 194, 512, 8);

        gameGraphics.drawPicture(15, 15, baseInventoryPic + 10);
        gameGraphics.cca(baseInventoryPic + 10, 0, 0, 512, 200);
        gameGraphics.cbl(baseInventoryPic + 10);
    }

    protected final void adf(int arg0, int arg1, byte arg2[])
    {
        try
        {
            if(arg0 == 141)
            {
                lastPlayerCount = playerCount;
                for(int l = 0; l < lastPlayerCount; l++)
                    lastPlayerArray[l] = playerArray[l];

                int l7 = 8;
                sectionX = DataOperations.fmn(arg2, l7, 11);
                l7 += 11;
                sectionY = DataOperations.fmn(arg2, l7, 13);
                l7 += 13;
                int i14 = DataOperations.fmn(arg2, l7, 4);
                l7 += 4;
                boolean flag1 = fdg(sectionX, sectionY);
                sectionX -= areaX;
                sectionY -= areaY;
                int i23 = sectionX * magicLoc + 64;
                int i26 = sectionY * magicLoc + 64;
                if(flag1)
                {
                    ourPlayer.waypointCurrent = 0;
                    ourPlayer.waypointsEndSprite = 0;
                    ourPlayer.currentX = ourPlayer.waypointsX[0] = i23;
                    ourPlayer.currentY = ourPlayer.waypointsY[0] = i26;
                }
                playerCount = 0;
                ourPlayer = makePlayer(djf, i23, i26, i14);
                int j29 = DataOperations.fmn(arg2, l7, 8);
                l7 += 8;
                for(int i34 = 0; i34 < j29; i34++)
                {
                    Mob f4 = lastPlayerArray[i34 + 1];
                    int i40 = DataOperations.fmn(arg2, l7, 1);
                    l7++;
                    if(i40 != 0)
                    {
                        int i42 = DataOperations.fmn(arg2, l7, 1);
                        l7++;
                        if(i42 == 0)
                        {
                            int j43 = DataOperations.fmn(arg2, l7, 3);
                            l7 += 3;
                            int j44 = f4.waypointCurrent;
                            int i45 = f4.waypointsX[j44];
                            int j45 = f4.waypointsY[j44];
                            if(j43 == 2 || j43 == 1 || j43 == 3)
                                i45 += magicLoc;
                            if(j43 == 6 || j43 == 5 || j43 == 7)
                                i45 -= magicLoc;
                            if(j43 == 4 || j43 == 3 || j43 == 5)
                                j45 += magicLoc;
                            if(j43 == 0 || j43 == 1 || j43 == 7)
                                j45 -= magicLoc;
                            f4.nextSprite = j43;
                            f4.waypointCurrent = j44 = (j44 + 1) % 10;
                            f4.waypointsX[j44] = i45;
                            f4.waypointsY[j44] = j45;
                        } else
                        {
                            int k43 = DataOperations.fmn(arg2, l7, 4);
                            if((k43 & 0xc) == 12)
                            {
                                l7 += 2;
                                continue;
                            }
                            f4.nextSprite = DataOperations.fmn(arg2, l7, 4);
                            l7 += 4;
                        }
                    }
                    playerArray[playerCount++] = f4;
                }

                int k37 = 0;
                while(l7 + 24 < arg1 * 8) 
                {
                    int j40 = DataOperations.fmn(arg2, l7, 11);
                    l7 += 11;
                    int j42 = DataOperations.fmn(arg2, l7, 5);
                    l7 += 5;
                    if(j42 > 15)
                        j42 -= 32;
                    int l43 = DataOperations.fmn(arg2, l7, 5);
                    l7 += 5;
                    if(l43 > 15)
                        l43 -= 32;
                    int j14 = DataOperations.fmn(arg2, l7, 4);
                    l7 += 4;
                    int k44 = DataOperations.fmn(arg2, l7, 1);
                    l7++;
                    int j23 = (sectionX + j42) * magicLoc + 64;
                    int j26 = (sectionY + l43) * magicLoc + 64;
                    makePlayer(j40, j23, j26, j14);
                    if(k44 == 0)
                        ece[k37++] = j40;
                }
                if(k37 > 0)
                {
                    super.streamClass.createPacket(241);
                    super.streamClass.addShort(k37);
                    for(int k40 = 0; k40 < k37; k40++)
                    {
                        Mob f5 = playerBufferArray[ece[k40]];
                        super.streamClass.addShort(f5.serverIndex);
                        super.streamClass.addShort(f5.serverID);
                    }

                    super.streamClass.formatPacket();
                    k37 = 0;
                }
                return;
            }
            if(arg0 == 172)
            {
                for(int i1 = 1; i1 < arg1;)
                    if(DataOperations.getUnsignedByte(arg2[i1]) == 255)
                    {
                        int i8 = 0;
                        int k14 = sectionX + arg2[i1 + 1] >> 3;
                        int j19 = sectionY + arg2[i1 + 2] >> 3;
                        i1 += 3;
                        for(int k23 = 0; k23 < groundItemCount; k23++)
                        {
                            int k26 = (dml[k23] >> 3) - k14;
                            int k29 = (dmm[k23] >> 3) - j19;
                            if(k26 != 0 || k29 != 0)
                            {
                                if(k23 != i8)
                                {
                                    dml[i8] = dml[k23];
                                    dmm[i8] = dmm[k23];
                                    dmn[i8] = dmn[k23];
                                    dna[i8] = dna[k23];
                                }
                                i8++;
                            }
                        }

                        groundItemCount = i8;
                    } else
                    {
                        int j8 = DataOperations.fmi(arg2, i1);
                        i1 += 2;
                        int l14 = sectionX + arg2[i1++];
                        int k19 = sectionY + arg2[i1++];
                        if((j8 & 0x8000) == 0)
                        {
                            dml[groundItemCount] = l14;
                            dmm[groundItemCount] = k19;
                            dmn[groundItemCount] = j8;
                            dna[groundItemCount] = 0;
                            for(int l23 = 0; l23 < objectCount; l23++)
                            {
                                if(objectX[l23] != l14 || objectY[l23] != k19)
                                    continue;
                                dna[groundItemCount] = Data.amk[objectID[l23]];
                                break;
                            }

                            groundItemCount++;
                        } else
                        {
                            j8 &= 0x7fff;
                            int i24 = 0;
                            for(int l26 = 0; l26 < groundItemCount; l26++)
                                if(dml[l26] != l14 || dmm[l26] != k19 || dmn[l26] != j8)
                                {
                                    if(l26 != i24)
                                    {
                                        dml[i24] = dml[l26];
                                        dmm[i24] = dmm[l26];
                                        dmn[i24] = dmn[l26];
                                        dna[i24] = dna[l26];
                                    }
                                    i24++;
                                } else
                                {
                                    j8 = -123;
                                }

                            groundItemCount = i24;
                        }
                    }

                return;
            }
            if(arg0 == 158)
            {
                for(int j1 = 1; j1 < arg1;)
                    if(DataOperations.getUnsignedByte(arg2[j1]) == 255)
                    {
                        int k8 = 0;
                        int i15 = sectionX + arg2[j1 + 1] >> 3;
                        int l19 = sectionY + arg2[j1 + 2] >> 3;
                        j1 += 3;
                        for(int j24 = 0; j24 < objectCount; j24++)
                        {
                            int i27 = (objectX[j24] >> 3) - i15;
                            int l29 = (objectY[j24] >> 3) - l19;
                            if(i27 != 0 || l29 != 0)
                            {
                                if(j24 != k8)
                                {
                                    objectArray[k8] = objectArray[j24];
                                    objectArray[k8].chk = k8;
                                    objectX[k8] = objectX[j24];
                                    objectY[k8] = objectY[j24];
                                    objectID[k8] = objectID[j24];
                                    elb[k8] = elb[j24];
                                }
                                k8++;
                            } else
                            {
                                gameCamera.removeModel(objectArray[j24]);
                                engineHandle.removeObject(objectX[j24], objectY[j24], objectID[j24]);
                            }
                        }

                        objectCount = k8;
                    } else
                    {
                        int l8 = DataOperations.fmi(arg2, j1);
                        j1 += 2;
                        int j15 = sectionX + arg2[j1++];
                        int i20 = sectionY + arg2[j1++];
                        int k24 = 0;
                        for(int j27 = 0; j27 < objectCount; j27++)
                            if(objectX[j27] != j15 || objectY[j27] != i20)
                            {
                                if(j27 != k24)
                                {
                                    objectArray[k24] = objectArray[j27];
                                    objectArray[k24].chk = k24;
                                    objectX[k24] = objectX[j27];
                                    objectY[k24] = objectY[j27];
                                    objectID[k24] = objectID[j27];
                                    elb[k24] = elb[j27];
                                }
                                k24++;
                            } else
                            {
                                gameCamera.removeModel(objectArray[j27]);
                                engineHandle.removeObject(objectX[j27], objectY[j27], objectID[j27]);
                            }

                        objectCount = k24;
                        if(l8 != 60000)
                        {
                            int i30 = engineHandle.gke(j15, i20);
                            int j34;
                            int l37;
                            if(i30 == 0 || i30 == 4)
                            {
                                j34 = Data.objectWidth[l8];
                                l37 = Data.objectHeight[l8];
                            } else
                            {
                                l37 = Data.objectWidth[l8];
                                j34 = Data.objectHeight[l8];
                            }
                            int l40 = ((j15 + j15 + j34) * magicLoc) / 2;
                            int k42 = ((i20 + i20 + l37) * magicLoc) / 2;
                            int i44 = Data.amg[l8];
                            i l44 = gameDataObjects[i44].cnj();
                            gameCamera.bgm(l44);
                            l44.chk = objectCount;
                            l44.cmi(0, i30 * 32, 0);
                            l44.cmk(l40, -engineHandle.gjf(l40, k42), k42);
                            l44.cme(true, 48, 48, -50, -10, -50);
                            engineHandle.gla(j15, i20, l8);
                            if(l8 == 74)
                                l44.cmk(0, -480, 0);
                            objectX[objectCount] = j15;
                            objectY[objectCount] = i20;
                            objectID[objectCount] = l8;
                            elb[objectCount] = i30;
                            objectArray[objectCount++] = l44;
                        }
                    }

                return;
            }
            if(arg0 == 37)
            {
                int k1 = 1;
                inventoryItemsCount = arg2[k1++] & 0xff;
                for(int i9 = 0; i9 < inventoryItemsCount; i9++)
                {
                    int k15 = DataOperations.fmi(arg2, k1);
                    k1 += 2;
                    inventoryItems[i9] = k15 & 0x7fff;
                    inventoryItemEquipped[i9] = k15 / 32768;
                    if(Data.itemStackable[k15 & 0x7fff] == 0)
                    {
                        inventoryItemCount[i9] = DataOperations.fmm(arg2, k1);
                        if(inventoryItemCount[i9] >= 128)
                            k1 += 4;
                        else
                            k1++;
                    } else
                    {
                        inventoryItemCount[i9] = 1;
                    }
                }

                return;
            }
            if(arg0 == 183)
            {
                int l1 = DataOperations.fmi(arg2, 1);
                int j9 = 3;
                for(int l15 = 0; l15 < l1; l15++)
                {
                    int j20 = DataOperations.fmi(arg2, j9);
                    j9 += 2;
                    Mob f1 = playerBufferArray[j20];
                    byte byte6 = arg2[j9];
                    j9++;
                    if(byte6 == 0)
                    {
                        int j30 = DataOperations.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.itemAboveHeadTimeout = 150;
                            f1.gng = j30;
                        }
                    } else
                    if(byte6 == 1)
                    {
                        byte byte7 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s3 = ChatFilter.fgd(v.bytesToString(arg2, j9, byte7));
                            boolean flag3 = false;
                            for(int i41 = 0; i41 < super.ignoresCount; i41++)
                                if(super.ignoresList[i41] == f1.gmd)
                                    flag3 = true;

                            if(!flag3)
                            {
                                f1.lastMessageTimeout = 150;
                                f1.gne = s3;
                                displayMessage(f1.gme + ": " + f1.gne, 2);
                            }
                        }
                        j9 += byte7;
                    } else
                    if(byte6 == 2)
                    {
                        int k30 = DataOperations.getUnsignedByte(arg2[j9]);
                        j9++;
                        int k34 = DataOperations.getUnsignedByte(arg2[j9]);
                        j9++;
                        int i38 = DataOperations.getUnsignedByte(arg2[j9]);
                        j9++;
                        if(f1 != null)
                        {
                            f1.gni = k30;
                            f1.gnj = k34;
                            f1.gnk = i38;
                            f1.combatTimer = 200;
                            if(f1 == ourPlayer)
                            {
                                playerStatCurrent[3] = k34;
                                playerStatBase[3] = i38;
                                showWelcomeBox = false;
                                ecc = false;
                            }
                        }
                    } else
                    if(byte6 == 3)
                    {
                        int l30 = DataOperations.fmi(arg2, j9);
                        j9 += 2;
                        int l34 = DataOperations.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.had = l30;
                            f1.haf = l34;
                            f1.hae = -1;
                            f1.projectileDistance = eic;
                        }
                    } else
                    if(byte6 == 4)
                    {
                        int i31 = DataOperations.fmi(arg2, j9);
                        j9 += 2;
                        int i35 = DataOperations.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.had = i31;
                            f1.hae = i35;
                            f1.haf = -1;
                            f1.projectileDistance = eic;
                        }
                    } else
                    if(byte6 == 5)
                    {
                        if(f1 != null)
                        {
                            f1.serverID = DataOperations.fmi(arg2, j9);
                            j9 += 2;
                            f1.gmd = DataOperations.getLong(arg2, j9);
                            j9 += 8;
                            f1.gme = DataOperations.hashToName(f1.gmd);
                            int j31 = DataOperations.getUnsignedByte(arg2[j9]);
                            j9++;
                            for(int j35 = 0; j35 < j31; j35++)
                            {
                                f1.gnd[j35] = DataOperations.getUnsignedByte(arg2[j9]);
                                j9++;
                            }

                            for(int j38 = j31; j38 < 12; j38++)
                                f1.gnd[j38] = 0;

                            f1.gnn = arg2[j9++] & 0xff;
                            f1.haa = arg2[j9++] & 0xff;
                            f1.hab = arg2[j9++] & 0xff;
                            f1.hac = arg2[j9++] & 0xff;
                            f1.gnm = arg2[j9++] & 0xff;
                            f1.haj = arg2[j9++] & 0xff;
                        } else
                        {
                            j9 += 14;
                            int k31 = DataOperations.getUnsignedByte(arg2[j9]);
                            j9 += k31 + 1;
                        }
                    } else
                    if(byte6 == 6)
                    {
                        byte byte8 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s4 = v.bytesToString(arg2, j9, byte8);
                            f1.lastMessageTimeout = 150;
                            f1.gne = s4;
                            if(f1 == ourPlayer)
                                displayMessage(f1.gme + ": " + f1.gne, 5);
                        }
                        j9 += byte8;
                    }
                }

                return;
            }
            if(arg0 == 29)
            {
                for(int i2 = 1; i2 < arg1;)
                    if(DataOperations.getUnsignedByte(arg2[i2]) == 255)
                    {
                        int k9 = 0;
                        int i16 = sectionX + arg2[i2 + 1] >> 3;
                        int k20 = sectionY + arg2[i2 + 2] >> 3;
                        i2 += 3;
                        for(int l24 = 0; l24 < wallObjectCount; l24++)
                        {
                            int k27 = (wallObjectX[l24] >> 3) - i16;
                            int l31 = (wallObjectY[l24] >> 3) - k20;
                            if(k27 != 0 || l31 != 0)
                            {
                                if(l24 != k9)
                                {
                                    wallObjectArray[k9] = wallObjectArray[l24];
                                    wallObjectArray[k9].chk = k9 + 10000;
                                    wallObjectX[k9] = wallObjectX[l24];
                                    wallObjectY[k9] = wallObjectY[l24];
                                    wallObjectDirection[k9] = wallObjectDirection[l24];
                                    wallObjectID[k9] = wallObjectID[l24];
                                }
                                k9++;
                            } else
                            {
                                gameCamera.removeModel(wallObjectArray[l24]);
                                engineHandle.removeWallObject(wallObjectX[l24], wallObjectY[l24], wallObjectDirection[l24], wallObjectID[l24]);
                            }
                        }

                        wallObjectCount = k9;
                    } else
                    {
                        int l9 = DataOperations.fmi(arg2, i2);
                        i2 += 2;
                        int j16 = sectionX + arg2[i2++];
                        int l20 = sectionY + arg2[i2++];
                        byte byte5 = arg2[i2++];
                        int l27 = 0;
                        for(int i32 = 0; i32 < wallObjectCount; i32++)
                            if(wallObjectX[i32] != j16 || wallObjectY[i32] != l20 || wallObjectDirection[i32] != byte5)
                            {
                                if(i32 != l27)
                                {
                                    wallObjectArray[l27] = wallObjectArray[i32];
                                    wallObjectArray[l27].chk = l27 + 10000;
                                    wallObjectX[l27] = wallObjectX[i32];
                                    wallObjectY[l27] = wallObjectY[i32];
                                    wallObjectDirection[l27] = wallObjectDirection[i32];
                                    wallObjectID[l27] = wallObjectID[i32];
                                }
                                l27++;
                            } else
                            {
                                gameCamera.removeModel(wallObjectArray[i32]);
                                engineHandle.removeWallObject(wallObjectX[i32], wallObjectY[i32], wallObjectDirection[i32], wallObjectID[i32]);
                            }

                        wallObjectCount = l27;
                        if(l9 != 65535)
                        {
                            engineHandle.gkc(j16, l20, byte5, l9);
                            i k35 = fdm(j16, l20, byte5, l9, wallObjectCount);
                            wallObjectArray[wallObjectCount] = k35;
                            wallObjectX[wallObjectCount] = j16;
                            wallObjectY[wallObjectCount] = l20;
                            wallObjectID[wallObjectCount] = l9;
                            wallObjectDirection[wallObjectCount++] = byte5;
                        }
                    }

                return;
            }
            if(arg0 == 41)
            {
                ebc = npcCount;
                npcCount = 0;
                for(int j2 = 0; j2 < ebc; j2++)
                    edc[j2] = npcArray[j2];

                int i10 = 8;
                int k16 = DataOperations.fmn(arg2, i10, 8);
                i10 += 8;
                for(int i21 = 0; i21 < k16; i21++)
                {
                    Mob f2 = edc[i21];
                    int i28 = DataOperations.fmn(arg2, i10, 1);
                    i10++;
                    if(i28 != 0)
                    {
                        int j32 = DataOperations.fmn(arg2, i10, 1);
                        i10++;
                        if(j32 == 0)
                        {
                            int l35 = DataOperations.fmn(arg2, i10, 3);
                            i10 += 3;
                            int k38 = f2.waypointCurrent;
                            int j41 = f2.waypointsX[k38];
                            int l42 = f2.waypointsY[k38];
                            if(l35 == 2 || l35 == 1 || l35 == 3)
                                j41 += magicLoc;
                            if(l35 == 6 || l35 == 5 || l35 == 7)
                                j41 -= magicLoc;
                            if(l35 == 4 || l35 == 3 || l35 == 5)
                                l42 += magicLoc;
                            if(l35 == 0 || l35 == 1 || l35 == 7)
                                l42 -= magicLoc;
                            f2.nextSprite = l35;
                            f2.waypointCurrent = k38 = (k38 + 1) % 10;
                            f2.waypointsX[k38] = j41;
                            f2.waypointsY[k38] = l42;
                        } else
                        {
                            int i36 = DataOperations.fmn(arg2, i10, 4);
                            if((i36 & 0xc) == 12)
                            {
                                i10 += 2;
                                continue;
                            }
                            f2.nextSprite = DataOperations.fmn(arg2, i10, 4);
                            i10 += 4;
                        }
                    }
                    npcArray[npcCount++] = f2;
                }

                while(i10 + 34 < arg1 * 8) 
                {
                    int i25 = DataOperations.fmn(arg2, i10, 12);
                    i10 += 12;
                    int j28 = DataOperations.fmn(arg2, i10, 5);
                    i10 += 5;
                    if(j28 > 15)
                        j28 -= 32;
                    int k32 = DataOperations.fmn(arg2, i10, 5);
                    i10 += 5;
                    if(k32 > 15)
                        k32 -= 32;
                    int j36 = DataOperations.fmn(arg2, i10, 4);
                    i10 += 4;
                    int l38 = (sectionX + j28) * magicLoc + 64;
                    int k41 = (sectionY + k32) * magicLoc + 64;
                    int i43 = DataOperations.fmn(arg2, i10, 10);
                    i10 += 10;
                    if(i43 >= Data.alg)
                        i43 = 24;
                    fea(i25, l38, k41, j36, i43);
                }
                return;
            }
            if(arg0 == 47)
            {
                int k2 = DataOperations.fmi(arg2, 1);
                int j10 = 3;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = DataOperations.fmi(arg2, j10);
                    j10 += 2;
                    Mob f3 = npcAttackingArray[j21];
                    int k28 = DataOperations.getUnsignedByte(arg2[j10]);
                    j10++;
                    if(k28 == 1)
                    {
                        int l32 = DataOperations.fmi(arg2, j10);
                        j10 += 2;
                        byte byte9 = arg2[j10];
                        j10++;
                        if(f3 != null)
                        {
                            String s5 = v.bytesToString(arg2, j10, byte9);
                            f3.lastMessageTimeout = 150;
                            f3.gne = s5;
                            if(l32 == ourPlayer.serverIndex)
                                displayMessage("@yel@" + Data.ahd[f3.gmj] + ": " + f3.gne, 5);
                        }
                        j10 += byte9;
                    } else
                    if(k28 == 2)
                    {
                        int i33 = DataOperations.getUnsignedByte(arg2[j10]);
                        j10++;
                        int k36 = DataOperations.getUnsignedByte(arg2[j10]);
                        j10++;
                        int i39 = DataOperations.getUnsignedByte(arg2[j10]);
                        j10++;
                        if(f3 != null)
                        {
                            f3.gni = i33;
                            f3.gnj = k36;
                            f3.gnk = i39;
                            f3.combatTimer = 200;
                        }
                    }
                }

                return;
            }
            if(arg0 == 117)
            {
                showQuestionMenu = true;
                int l2 = DataOperations.getUnsignedByte(arg2[1]);
                questionMenuCount = l2;
                int k10 = 2;
                for(int i17 = 0; i17 < l2; i17++)
                {
                    int k21 = DataOperations.getUnsignedByte(arg2[k10]);
                    k10++;
                    questionMenuAnswer[i17] = new String(arg2, k10, k21);
                    k10 += k21;
                }

                return;
            }
            if(arg0 == 208)
            {
                showQuestionMenu = false;
                return;
            }
            if(arg0 == 249)
            {
                elk = true;
                djf = DataOperations.fmi(arg2, 1);
                eai = DataOperations.fmi(arg2, 3);
                eaj = DataOperations.fmi(arg2, 5);
                dnk = DataOperations.fmi(arg2, 7);
                eak = DataOperations.fmi(arg2, 9);
                eaj -= dnk * eak;
                return;
            }
            if(arg0 == 16)
            {
                int i3 = 1;
                for(int l10 = 0; l10 < 18; l10++)
                    playerStatCurrent[l10] = DataOperations.getUnsignedByte(arg2[i3++]);

                for(int j17 = 0; j17 < 18; j17++)
                    playerStatBase[j17] = DataOperations.getUnsignedByte(arg2[i3++]);

                for(int l21 = 0; l21 < 18; l21++)
                {
                    edn[l21] = DataOperations.getInt(arg2, i3);
                    i3 += 4;
                }

                ema = DataOperations.getUnsignedByte(arg2[i3++]);
                return;
            }
            if(arg0 == 33)
            {
                for(int j3 = 0; j3 < 5; j3++)
                    ege[j3] = DataOperations.getUnsignedByte(arg2[1 + j3]);

                return;
            }
            if(arg0 == 109)
            {
                playerAliveTimeout = 250;
                return;
            }
            if(arg0 == 76)
            {
                int k3 = (arg1 - 1) / 4;
                for(int i11 = 0; i11 < k3; i11++)
                {
                    int k17 = sectionX + DataOperations.fml(arg2, 1 + i11 * 4) >> 3;
                    int i22 = sectionY + DataOperations.fml(arg2, 3 + i11 * 4) >> 3;
                    int j25 = 0;
                    for(int l28 = 0; l28 < groundItemCount; l28++)
                    {
                        int j33 = (dml[l28] >> 3) - k17;
                        int l36 = (dmm[l28] >> 3) - i22;
                        if(j33 != 0 || l36 != 0)
                        {
                            if(l28 != j25)
                            {
                                dml[j25] = dml[l28];
                                dmm[j25] = dmm[l28];
                                dmn[j25] = dmn[l28];
                                dna[j25] = dna[l28];
                            }
                            j25++;
                        }
                    }

                    groundItemCount = j25;
                    j25 = 0;
                    for(int k33 = 0; k33 < objectCount; k33++)
                    {
                        int i37 = (objectX[k33] >> 3) - k17;
                        int j39 = (objectY[k33] >> 3) - i22;
                        if(i37 != 0 || j39 != 0)
                        {
                            if(k33 != j25)
                            {
                                objectArray[j25] = objectArray[k33];
                                objectArray[j25].chk = j25;
                                objectX[j25] = objectX[k33];
                                objectY[j25] = objectY[k33];
                                objectID[j25] = objectID[k33];
                                elb[j25] = elb[k33];
                            }
                            j25++;
                        } else
                        {
                            gameCamera.removeModel(objectArray[k33]);
                            engineHandle.removeObject(objectX[k33], objectY[k33], objectID[k33]);
                        }
                    }

                    objectCount = j25;
                    j25 = 0;
                    for(int j37 = 0; j37 < wallObjectCount; j37++)
                    {
                        int k39 = (wallObjectX[j37] >> 3) - k17;
                        int l41 = (wallObjectY[j37] >> 3) - i22;
                        if(k39 != 0 || l41 != 0)
                        {
                            if(j37 != j25)
                            {
                                wallObjectArray[j25] = wallObjectArray[j37];
                                wallObjectArray[j25].chk = j25 + 10000;
                                wallObjectX[j25] = wallObjectX[j37];
                                wallObjectY[j25] = wallObjectY[j37];
                                wallObjectDirection[j25] = wallObjectDirection[j37];
                                wallObjectID[j25] = wallObjectID[j37];
                            }
                            j25++;
                        } else
                        {
                            gameCamera.removeModel(wallObjectArray[j37]);
                            engineHandle.removeWallObject(wallObjectX[j37], wallObjectY[j37], wallObjectDirection[j37], wallObjectID[j37]);
                        }
                    }

                    wallObjectCount = j25;
                }

                return;
            }
            if(arg0 == 7)
            {
                showAppearanceWindow = true;
                return;
            }
            if(arg0 == 108)
            {
                int l3 = DataOperations.fmi(arg2, 1);
                if(playerBufferArray[l3] != null)
                    tradeOtherName = playerBufferArray[l3].gme;
                showTradeBox = true;
                tradeOtherAccepted = false;
                tradeWeAccepted = false;
                tradeItemsOurCount = 0;
                tradeItemsOtherCount = 0;
                return;
            }
            if(arg0 == 113)
            {
                showTradeBox = false;
                showTradeConfirmBox = false;
                return;
            }
            if(arg0 == 155)
            {
                tradeItemsOtherCount = arg2[1] & 0xff;
                int i4 = 2;
                for(int j11 = 0; j11 < tradeItemsOtherCount; j11++)
                {
                    tradeItemsOther[j11] = DataOperations.fmi(arg2, i4);
                    i4 += 2;
                    dff[j11] = DataOperations.getInt(arg2, i4);
                    i4 += 4;
                }

                tradeOtherAccepted = false;
                tradeWeAccepted = false;
                return;
            }
            if(arg0 == 185)
            {
                byte byte0 = arg2[1];
                if(byte0 == 1)
                {
                    tradeOtherAccepted = true;
                    return;
                } else
                {
                    tradeOtherAccepted = false;
                    return;
                }
            }
            if(arg0 == 24)
            {
                showShopBox = true;
                int j4 = 1;
                int k11 = arg2[j4++] & 0xff;
                byte byte4 = arg2[j4++];
                dmc = arg2[j4++] & 0xff;
                dmd = arg2[j4++] & 0xff;
                for(int j22 = 0; j22 < 40; j22++)
                    efa[j22] = -1;

                for(int k25 = 0; k25 < k11; k25++)
                {
                    efa[k25] = DataOperations.fmi(arg2, j4);
                    j4 += 2;
                    efb[k25] = DataOperations.fmi(arg2, j4);
                    j4 += 2;
                    efc[k25] = arg2[j4++];
                }

                if(byte4 == 1)
                {
                    int i29 = 39;
                    for(int l33 = 0; l33 < inventoryItemsCount; l33++)
                    {
                        if(i29 < k11)
                            break;
                        boolean flag2 = false;
                        for(int l39 = 0; l39 < 40; l39++)
                        {
                            if(efa[l39] != inventoryItems[l33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(inventoryItems[l33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            efa[i29] = inventoryItems[l33] & 0x7fff;
                            efb[i29] = 0;
                            efc[i29] = 0;
                            i29--;
                        }
                    }

                }
                if(dej >= 0 && dej < 40 && efa[dej] != dek)
                {
                    dej = -1;
                    dek = -2;
                }
                return;
            }
            if(arg0 == 42)
            {
                showShopBox = false;
                return;
            }
            if(arg0 == 170)
            {
                byte byte1 = arg2[1];
                if(byte1 == 1)
                {
                    tradeWeAccepted = true;
                    return;
                } else
                {
                    tradeWeAccepted = false;
                    return;
                }
            }
            if(arg0 == 161)
            {
                configCmeraAutoAngle = DataOperations.getUnsignedByte(arg2[1]) == 1;
                configOneMouseButton = DataOperations.getUnsignedByte(arg2[2]) == 1;
                configSoundOff = DataOperations.getUnsignedByte(arg2[3]) == 1;
                return;
            }
            if(arg0 == 222)
            {
                for(int k4 = 0; k4 < arg1 - 1; k4++)
                {
                    boolean flag = arg2[k4 + 1] == 1;
                    if(!prayerOn[k4] && flag)
                        playSound("prayeron");
                    if(prayerOn[k4] && !flag)
                        playSound("prayeroff");
                    prayerOn[k4] = flag;
                }

                return;
            }
            if(arg0 == 26)
            {
                for(int l4 = 0; l4 < 50; l4++)
                    ehf[l4] = arg2[l4 + 1] == 1;

                return;
            }
            if(arg0 == 188)
            {
                showBankBox = true;
                int i5 = 1;
                elg = arg2[i5++] & 0xff;
                dnc = arg2[i5++] & 0xff;
                for(int l11 = 0; l11 < elg; l11++)
                {
                    dmi[l11] = DataOperations.fmi(arg2, i5);
                    i5 += 2;
                    dmj[l11] = DataOperations.fmm(arg2, i5);
                    if(dmj[l11] >= 128)
                        i5 += 4;
                    else
                        i5++;
                }

                feb();
                return;
            }
            if(arg0 == 130)
            {
                showBankBox = false;
                return;
            }
            if(arg0 == 69)
            {
                int j5 = arg2[1] & 0xff;
                edn[j5] = DataOperations.getInt(arg2, 2);
                return;
            }
            if(arg0 == 240)
            {
                int k5 = DataOperations.fmi(arg2, 1);
                if(playerBufferArray[k5] != null)
                    eke = playerBufferArray[k5].gme;
                eld = true;
                ded = 0;
                dkl = 0;
                dhe = false;
                dhf = false;
                dgg = false;
                dgh = false;
                dgi = false;
                dgj = false;
                return;
            }
            if(arg0 == 198)
            {
                eld = false;
                showDuelConfirmBox = false;
                return;
            }
            if(arg0 == 128)
            {
                showTradeConfirmBox = true;
                tradeConfirmAccepted = false;
                showTradeBox = false;
                int l5 = 1;
                tradeConfirmOtherNameLong = DataOperations.getLong(arg2, l5);
                l5 += 8;
                tradeConfirmOtherItemCount = arg2[l5++] & 0xff;
                for(int i12 = 0; i12 < tradeConfirmOtherItemCount; i12++)
                {
                    tradeConfirmOtherItems[i12] = DataOperations.fmi(arg2, l5);
                    l5 += 2;
                    tradeConfirmOtherItemsCount[i12] = DataOperations.getInt(arg2, l5);
                    l5 += 4;
                }

                tradeConfigItemCount = arg2[l5++] & 0xff;
                for(int l17 = 0; l17 < tradeConfigItemCount; l17++)
                {
                    tradeConfirmItems[l17] = DataOperations.fmi(arg2, l5);
                    l5 += 2;
                    tradeConfigItemsCount[l17] = DataOperations.getInt(arg2, l5);
                    l5 += 4;
                }

                return;
            }
            if(arg0 == 229)
            {
                dkl = arg2[1] & 0xff;
                int i6 = 2;
                for(int j12 = 0; j12 < dkl; j12++)
                {
                    dkm[j12] = DataOperations.fmi(arg2, i6);
                    i6 += 2;
                    dkn[j12] = DataOperations.getInt(arg2, i6);
                    i6 += 4;
                }

                dhe = false;
                dhf = false;
                return;
            }
            if(arg0 == 211)
            {
                if(arg2[1] == 1)
                    dgg = true;
                else
                    dgg = false;
                if(arg2[2] == 1)
                    dgh = true;
                else
                    dgh = false;
                if(arg2[3] == 1)
                    dgi = true;
                else
                    dgi = false;
                if(arg2[4] == 1)
                    dgj = true;
                else
                    dgj = false;
                dhe = false;
                dhf = false;
                return;
            }
            if(arg0 == 81)
            {
                int j6 = 1;
                int k12 = arg2[j6++] & 0xff;
                int i18 = DataOperations.fmi(arg2, j6);
                j6 += 2;
                int k22 = DataOperations.fmm(arg2, j6);
                if(k22 >= 128)
                    j6 += 4;
                else
                    j6++;
                if(k22 == 0)
                {
                    elg--;
                    for(int l25 = k12; l25 < elg; l25++)
                    {
                        dmi[l25] = dmi[l25 + 1];
                        dmj[l25] = dmj[l25 + 1];
                    }

                } else
                {
                    dmi[k12] = i18;
                    dmj[k12] = k22;
                    if(k12 >= elg)
                        elg = k12 + 1;
                }
                feb();
                return;
            }
            if(arg0 == 210)
            {
                int k6 = 1;
                int l12 = 1;
                int j18 = arg2[k6++] & 0xff;
                int l22 = DataOperations.fmi(arg2, k6);
                k6 += 2;
                if(Data.itemStackable[l22 & 0x7fff] == 0)
                {
                    l12 = DataOperations.fmm(arg2, k6);
                    if(l12 >= 128)
                        k6 += 4;
                    else
                        k6++;
                }
                inventoryItems[j18] = l22 & 0x7fff;
                inventoryItemEquipped[j18] = l22 / 32768;
                inventoryItemCount[j18] = l12;
                if(j18 >= inventoryItemsCount)
                    inventoryItemsCount = j18 + 1;
                return;
            }
            if(arg0 == 44)
            {
                int l6 = arg2[1] & 0xff;
                inventoryItemsCount--;
                for(int i13 = l6; i13 < inventoryItemsCount; i13++)
                {
                    inventoryItems[i13] = inventoryItems[i13 + 1];
                    inventoryItemCount[i13] = inventoryItemCount[i13 + 1];
                    inventoryItemEquipped[i13] = inventoryItemEquipped[i13 + 1];
                }

                return;
            }
            if(arg0 == 23)
            {
                int i7 = 1;
                int j13 = arg2[i7++] & 0xff;
                playerStatCurrent[j13] = DataOperations.getUnsignedByte(arg2[i7++]);
                playerStatBase[j13] = DataOperations.getUnsignedByte(arg2[i7++]);
                edn[j13] = DataOperations.getInt(arg2, i7);
                i7 += 4;
                return;
            }
            if(arg0 == 73)
            {
                byte byte2 = arg2[1];
                if(byte2 == 1)
                {
                    dhe = true;
                    return;
                } else
                {
                    dhe = false;
                    return;
                }
            }
            if(arg0 == 131)
            {
                byte byte3 = arg2[1];
                if(byte3 == 1)
                {
                    dhf = true;
                    return;
                } else
                {
                    dhf = false;
                    return;
                }
            }
            if(arg0 == 10)
            {
                showDuelConfirmBox = true;
                duelConfirmOurAccepted = false;
                eld = false;
                int j7 = 1;
                duelOpponentHash = DataOperations.getLong(arg2, j7);
                j7 += 8;
                duelOpponentStakeCount = arg2[j7++] & 0xff;
                for(int k13 = 0; k13 < duelOpponentStakeCount; k13++)
                {
                    eff[k13] = DataOperations.fmi(arg2, j7);
                    j7 += 2;
                    duelOutStakeItemCount[k13] = DataOperations.getInt(arg2, j7);
                    j7 += 4;
                }

                duelOurStakeCount = arg2[j7++] & 0xff;
                for(int k18 = 0; k18 < duelOurStakeCount; k18++)
                {
                    duelOurStakeItem[k18] = DataOperations.fmi(arg2, j7);
                    j7 += 2;
                    duelOurStakeItemCount[k18] = DataOperations.getInt(arg2, j7);
                    j7 += 4;
                }

                duelRetreat = arg2[j7++] & 0xff;
                duelMagic = arg2[j7++] & 0xff;
                duelPrayer = arg2[j7++] & 0xff;
                duelWeapons = arg2[j7++] & 0xff;
                return;
            }
            if(arg0 == 238)
            {
                String s1 = new String(arg2, 1, arg1 - 1);
                playSound(s1);
                return;
            }
            if(arg0 == 253)
            {
                if(eig < 50)
                {
                    int k7 = arg2[1] & 0xff;
                    int l13 = arg2[2] + sectionX;
                    int l18 = arg2[3] + sectionY;
                    teleBubbleType[eig] = k7;
                    teleBubbleTime[eig] = 0;
                    ell[eig] = l13;
                    elh[eig] = l18;
                    eig++;
                }
                return;
            }
            if(arg0 == 126)
            {
                if(!loginScreenShown)
                {
                    lastLoginIPInt = DataOperations.getInt(arg2, 1);
                    lastLoginDays = DataOperations.fmi(arg2, 5);
                    lastChangedRecoveryDays = arg2[7] & 0xff;
                    unreadMessages = DataOperations.fmi(arg2, 8);
                    showWelcomeBox = true;
                    loginScreenShown = true;
                    lastLoginAddress = null;
                }
                return;
            }
            if(arg0 == 112)
            {
                dhc = new String(arg2, 1, arg1 - 1);
                ecc = true;
                dhi = false;
                return;
            }
            if(arg0 == 49)
            {
                dhc = new String(arg2, 1, arg1 - 1);
                ecc = true;
                dhi = true;
                return;
            }
            if(arg0 == 60)
            {
                dhj = DataOperations.fmi(arg2, 1);
                return;
            }
            if(arg0 == 15)
            {
                if(!isSleeping)
                    dhk = dhj;
                isSleeping = true;
                super.inputText = "";
                super.enteredInputText = "";
                gameGraphics.cbk(baseTexturePic + 1, arg2);
                del = null;
                return;
            }
            if(arg0 == 174)
            {
                dhk = DataOperations.fmi(arg2, 1);
                return;
            }
            if(arg0 == 206)
            {
                isSleeping = false;
                return;
            }
            if(arg0 == 20)
            {
                del = "Incorrect - Please wait...";
                return;
            }
            if(arg0 == 28)
            {
                systemUpdate = DataOperations.fmi(arg2, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(deb < 3)
            {
                super.streamClass.createPacket(7);
                super.streamClass.addString(runtimeexception.toString());
                super.streamClass.formatPacket();
                super.streamClass.createPacket(7);
                super.streamClass.addString("p-type:" + arg0 + " p-size:" + arg1);
                super.streamClass.formatPacket();
                super.streamClass.createPacket(7);
                super.streamClass.addString("rx:" + sectionX + " ry:" + sectionY + " num3l:" + objectCount);
                super.streamClass.formatPacket();
                String s2 = "";
                for(int i19 = 0; i19 < 80 && i19 < arg1; i19++)
                    s2 = s2 + arg2[i19] + " ";

                super.streamClass.createPacket(7);
                super.streamClass.addString(s2);
                super.streamClass.formatPacket();
                deb++;
            }
        }
    }

    protected final void startThread(Runnable runnable)
    {
        if(link.gameApplet != null)
        {
            link.thread(runnable);
            return;
        } else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    protected final void initVars()
    {
        systemUpdate = 0;
        combatStyle = 0;
        logoutTimer = 0;
        loginScreen = 0;
        loggedIn = 1;
        resetPrivateMessages();
        gameGraphics.clearScreen();
        gameGraphics.drawImage(graphics, 0, 0);
        for(int l = 0; l < objectCount; l++)
        {
            gameCamera.removeModel(objectArray[l]);
            engineHandle.removeObject(objectX[l], objectY[l], objectID[l]);
        }

        for(int i1 = 0; i1 < wallObjectCount; i1++)
        {
            gameCamera.removeModel(wallObjectArray[i1]);
            engineHandle.removeWallObject(wallObjectX[i1], wallObjectY[i1], wallObjectDirection[i1], wallObjectID[i1]);
        }

        objectCount = 0;
        wallObjectCount = 0;
        groundItemCount = 0;
        playerCount = 0;
        for(int j1 = 0; j1 < 4000; j1++)
            playerBufferArray[j1] = null;

        for(int k1 = 0; k1 < 500; k1++)
            playerArray[k1] = null;

        npcCount = 0;
        for(int l1 = 0; l1 < 5000; l1++)
            npcAttackingArray[l1] = null;

        for(int i2 = 0; i2 < 500; i2++)
            npcArray[i2] = null;

        for(int j2 = 0; j2 < 50; j2++)
            prayerOn[j2] = false;

        mouseButtonClick = 0;
        super.lastMouseButton = 0;
        super.mouseButton = 0;
        showShopBox = false;
        showBankBox = false;
        isSleeping = false;
        super.friendsCount = 0;
    }

    private final void drawMinimapMenu(boolean canClick)
    {
        int l = ((GameImage) (gameGraphics)).gameWidth - 199;
        char c1 = '\234';
        char c3 = '\230';
        gameGraphics.drawPicture(l - 49, 3, baseInventoryPic + 2);// TODO "does the heighlted map deal"
        l += 40;
        // TODO "clips the minimap to size, turning it off shows the whole loaded map area"
        gameGraphics.drawBox(l, 36, c1, c3, 0);
        gameGraphics.setGameBoundaries(l, 36, l + c1, 36 + c3);
        int j1 = 192 + minimapRandomRotationY;
        int l1 = cameraRotation + minimapRandomRotationX & 0xff;
        int j2 = ((ourPlayer.currentX - 6040) * 3 * j1) / 2048;
        int l3 = ((ourPlayer.currentY - 6040) * 3 * j1) / 2048;
        int j5 = Camera.bbk[1024 - l1 * 4 & 0x3ff];
        int l5 = Camera.bbk[(1024 - l1 * 4 & 0x3ff) + 1024];
        int j6 = l3 * j5 + j2 * l5 >> 18;
        l3 = l3 * l5 - j2 * j5 >> 18;
        j2 = j6;
        gameGraphics.drawMinimapPic((l + c1 / 2) - j2, 36 + c3 / 2 + l3, baseInventoryPic - 1, l1 + 64 & 0xff, j1);
        for(int l7 = 0; l7 < objectCount; l7++)
        {
            int k2 = (((objectX[l7] * magicLoc + 64) - ourPlayer.currentX) * 3 * j1) / 2048;
            int i4 = (((objectY[l7] * magicLoc + 64) - ourPlayer.currentY) * 3 * j1) / 2048;
            int k6 = i4 * j5 + k2 * l5 >> 18;
            i4 = i4 * l5 - k2 * j5 >> 18;
            k2 = k6;
            drawMinimapObject(l + c1 / 2 + k2, (36 + c3 / 2) - i4, 65535);
        }

        for(int i8 = 0; i8 < groundItemCount; i8++)
        {
            int l2 = (((dml[i8] * magicLoc + 64) - ourPlayer.currentX) * 3 * j1) / 2048;
            int j4 = (((dmm[i8] * magicLoc + 64) - ourPlayer.currentY) * 3 * j1) / 2048;
            int l6 = j4 * j5 + l2 * l5 >> 18;
            j4 = j4 * l5 - l2 * j5 >> 18;
            l2 = l6;
            drawMinimapObject(l + c1 / 2 + l2, (36 + c3 / 2) - j4, 0xff0000);
        }

        for(int j8 = 0; j8 < npcCount; j8++)
        {
            Mob f1 = npcArray[j8];
            int i3 = ((f1.currentX - ourPlayer.currentX) * 3 * j1) / 2048;
            int k4 = ((f1.currentY - ourPlayer.currentY) * 3 * j1) / 2048;
            int i7 = k4 * j5 + i3 * l5 >> 18;
            k4 = k4 * l5 - i3 * j5 >> 18;
            i3 = i7;
            drawMinimapObject(l + c1 / 2 + i3, (36 + c3 / 2) - k4, 0xffff00);
        }

        for(int k8 = 0; k8 < playerCount; k8++)
        {
            Mob f2 = playerArray[k8];
            int j3 = ((f2.currentX - ourPlayer.currentX) * 3 * j1) / 2048;
            int l4 = ((f2.currentY - ourPlayer.currentY) * 3 * j1) / 2048;
            int j7 = l4 * j5 + j3 * l5 >> 18;
            l4 = l4 * l5 - j3 * j5 >> 18;
            j3 = j7;
            int i9 = 0xffffff;
            for(int j9 = 0; j9 < super.friendsCount; j9++)
            {
                if(f2.gmd != super.friendsList[j9] || super.friendsWorld[j9] != 99)
                    continue;
                i9 = 65280;
                break;
            }

            drawMinimapObject(l + c1 / 2 + j3, (36 + c3 / 2) - l4, i9);
        }
        
        // compass
        gameGraphics.drawCircle(l + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        gameGraphics.drawMinimapPic(l + 19, 55, baseInventoryPic + 24, cameraRotation + 128 & 0xff, 128);
        gameGraphics.setGameBoundaries(0, 0, windowWidth, windowHeight + 12);
        if(!canClick)
            return;
        l = super.mouseX - (((GameImage) (gameGraphics)).gameWidth - 199);
        int l8 = super.mouseY - 36;
        if(l >= 40 && l8 >= 0 && l < 196 && l8 < 152)
        {
            char c2 = '\234';
            char c4 = '\230';
            int k1 = 192 + minimapRandomRotationY;
            int i2 = cameraRotation + minimapRandomRotationX & 0xff;
            int i1 = ((GameImage) (gameGraphics)).gameWidth - 199;
            i1 += 40;
            int k3 = ((super.mouseX - (i1 + c2 / 2)) * 16384) / (3 * k1);
            int i5 = ((super.mouseY - (36 + c4 / 2)) * 16384) / (3 * k1);
            int k5 = Camera.bbk[1024 - i2 * 4 & 0x3ff];
            int i6 = Camera.bbk[(1024 - i2 * 4 & 0x3ff) + 1024];
            int k7 = i5 * k5 + k3 * i6 >> 15;
            i5 = i5 * i6 - k3 * k5 >> 15;
            k3 = k7;
            k3 += ourPlayer.currentX;
            i5 = ourPlayer.currentY - i5;
            if(mouseButtonClick == 1)
                walkTo1Tile(sectionX, sectionY, k3 / 128, i5 / 128, false);
            mouseButtonClick = 0;
        }
    }

    private final boolean validCameraAngle(int arg0)
    {
        int l = ourPlayer.currentX / 128;
        int i1 = ourPlayer.currentY / 128;
        for(int j1 = 2; j1 >= 1; j1--)
        {
            if(arg0 == 1 && ((engineHandle.tiles[l][i1 - j1] & 0x80) == 128 || (engineHandle.tiles[l - j1][i1] & 0x80) == 128 || (engineHandle.tiles[l - j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 3 && ((engineHandle.tiles[l][i1 + j1] & 0x80) == 128 || (engineHandle.tiles[l - j1][i1] & 0x80) == 128 || (engineHandle.tiles[l - j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 5 && ((engineHandle.tiles[l][i1 + j1] & 0x80) == 128 || (engineHandle.tiles[l + j1][i1] & 0x80) == 128 || (engineHandle.tiles[l + j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 7 && ((engineHandle.tiles[l][i1 - j1] & 0x80) == 128 || (engineHandle.tiles[l + j1][i1] & 0x80) == 128 || (engineHandle.tiles[l + j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 0 && (engineHandle.tiles[l][i1 - j1] & 0x80) == 128)
                return false;
            if(arg0 == 2 && (engineHandle.tiles[l - j1][i1] & 0x80) == 128)
                return false;
            if(arg0 == 4 && (engineHandle.tiles[l][i1 + j1] & 0x80) == 128)
                return false;
            if(arg0 == 6 && (engineHandle.tiles[l + j1][i1] & 0x80) == 128)
                return false;
        }

        return true;
    }

    private final String resolveIP(int l)
    {
        if(link.gameApplet != null)
            return link.getAddress(DataOperations.ipToString(l));
        else
            return DataOperations.ipToString(l);
    }

    private final void loadSounds()
    {
        try
        {
            soundData = unpackData("sounds" + Version.VERSION_SOUNDS + ".mem", "Sound effects", 90);
            audioPlayer = new AudioReader();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    protected final void loadGame()
    {
        if(appletMode)
        {
            String s1 = getDocumentBase().getHost().toLowerCase();
            if(!s1.endsWith("jagex.com") && !s1.endsWith("jagex.co.uk") && !s1.endsWith("runescape.com") && !s1.endsWith("runescape.co.uk") && !s1.endsWith("runescape.net") && !s1.endsWith("runescape.org") && !s1.endsWith("penguin") && !s1.endsWith("puffin"))
            {
                codebaseError = true;
                return;
            }
        }
        int l = 0;
        for(int i1 = 0; i1 < 99; i1++)
        {
            int j1 = i1 + 1;
            int l1 = (int)((double)j1 + 300D * Math.pow(2D, (double)j1 / 7D));
            l += l1;
            experienceList[i1] = l & 0xffffffc;
        }

        try
        {
            String s2 = getParameter("referid");
            referId = Integer.parseInt(s2);
        }
        catch(Exception _ex) { }
        try
        {
            String s3 = getParameter("member");
            int i2 = Integer.parseInt(s3);
            if(i2 == 1)
                members = true;
        }
        catch(Exception _ex) { }
        if(appletMode)
            super.port = 43594;
        super.mouseYOffset = 0;
        GameAppletMiddleMan.maxPacketReadCount = 1000;
        GameAppletMiddleMan.VERSION_CLIENT = Version.VERSION_CLIENT;
        try
        {
            String s4 = getParameter("poff");
            int j2 = Integer.parseInt(s4);
            super.port += j2;
            System.out.println("Offset: " + j2);
        }
        catch(Exception _ex) { }
        loadChatFilter();
        if(errorLoading)
            return;
        baseInventoryPic = 2000;
        baseScrollPic = baseInventoryPic + 100;
        baseItemPicture = baseScrollPic + 50;
        baseLoginScreenBackgroundPic = baseItemPicture + 1000;
        baseProjectilePic = baseLoginScreenBackgroundPic + 10;
        baseTexturePic = baseProjectilePic + 50;
        subTexturePic = baseTexturePic + 10;
        graphics = getGraphics();
        setRefreshRate(50);
        gameGraphics = new GameImageMiddleMan(windowWidth, windowHeight + 12, 4000, this);
        gameGraphics.gameReference = this;
        gameGraphics.setGameBoundaries(0, 0, windowWidth, windowHeight + 12);
        Menu.gdh = false;
        Menu.gdi = baseScrollPic;
        spellMenu = new Menu(gameGraphics, 5);
        int k1 = ((GameImage) (gameGraphics)).gameWidth - 199;
        byte byte0 = 36;
        spellMenuHandle = spellMenu.createList(k1, byte0 + 24, 196, 90, 1, 500, true);
        friendsMenu = new Menu(gameGraphics, 5);
        friendsMenuHandle = friendsMenu.createList(k1, byte0 + 40, 196, 126, 1, 500, true);
        questMenu = new Menu(gameGraphics, 5);
        questMenuHandle = questMenu.createList(k1, byte0 + 24, 196, 251, 1, 500, true);
        loadMedia();
        if(errorLoading)
            return;
        loadAnimations();
        if(errorLoading)
            return;
        gameCamera = new Camera(gameGraphics, 15000, 15000, 1000);
        gameCamera.setCameraSize(windowWidth / 2, windowHeight / 2, windowWidth / 2, windowHeight / 2, windowWidth, dcj);
        gameCamera.zoom1 = 2400;
        gameCamera.zoom2 = 2400;
        gameCamera.zoom3 = 1;
        gameCamera.zoom4 = 2300;
        gameCamera.bjk(-50, -10, -50);
        engineHandle = new EngineHandle(gameCamera, gameGraphics);
        engineHandle.gjc = baseInventoryPic;
        loadTextures();
        if(errorLoading)
            return;
        loadModels();
        if(errorLoading)
            return;
        loadMap();
        if(errorLoading)
            return;
        if(members)
            loadSounds();
        if(!errorLoading) {
            drawLoadingBarText(100, "Starting game...");
            createChatInputMenu();
            createLoginMenus();
            createAppearanceWindow();
            setLoginVars();
            creatLoginScreenBackgrounds();
            return;
        }
    }

    private final void createLoginMenus()
    {
        loginMenuFirst = new Menu(gameGraphics, 50);
        int l = 40;
        if(!members)
        {
            loginMenuFirst.drawText(256, 200 + l, "Click on an option", 5, true);
            loginMenuFirst.drawButton(156, 240 + l, 120, 35);
            loginMenuFirst.drawButton(356, 240 + l, 120, 35);
            loginMenuFirst.drawText(156, 240 + l, "New User", 5, false);
            loginMenuFirst.drawText(356, 240 + l, "Existing User", 5, false);
            loginButtonNewUser = loginMenuFirst.createButton(156, 240 + l, 120, 35);
            loginMenuLoginButton = loginMenuFirst.createButton(356, 240 + l, 120, 35);
        } else
        {
            loginMenuFirst.drawText(256, 200 + l, "Welcome to RuneScape", 4, true);
            loginMenuFirst.drawText(256, 215 + l, "You need a member account to use this server", 4, true);
            loginMenuFirst.drawButton(256, 250 + l, 200, 35);
            loginMenuFirst.drawText(256, 250 + l, "Click here to login", 5, false);
            loginMenuLoginButton = loginMenuFirst.createButton(256, 250 + l, 200, 35);
        }
        loginNewUser = new Menu(gameGraphics, 50);
        l = 230;
        if(referId == 0)
        {
            loginNewUser.drawText(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            loginNewUser.drawText(256, l + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(referId == 1)
        {
            loginNewUser.drawText(256, l + 8, "To create an account please click on the", 4, true);
            l += 20;
            loginNewUser.drawText(256, l + 8, "'create account' link below the game window", 4, true);
        } else
        {
            loginNewUser.drawText(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            loginNewUser.drawText(256, l + 8, "runescape front webpage and choose 'create account'", 4, true);
        }
        l += 30;
        loginNewUser.drawButton(256, l + 17, 150, 34);
        loginNewUser.drawText(256, l + 17, "Ok", 5, false);
        loginMenuOkButton = loginNewUser.createButton(256, l + 17, 150, 34);
        loginMenuLogin = new Menu(gameGraphics, 50);
        l = 230;
        loginMenuStatusText = loginMenuLogin.drawText(256, l - 10, "Please enter your username and password", 4, true);
        l += 28;
        loginMenuLogin.drawButton(140, l, 200, 40);
        loginMenuLogin.drawText(140, l - 10, "Username:", 4, false);
        loginMenuUserText = loginMenuLogin.createInput(140, l + 10, 200, 40, 4, 12, false, false);
        l += 47;
        loginMenuLogin.drawButton(190, l, 200, 40);
        loginMenuLogin.drawText(190, l - 10, "Password:", 4, false);
        loginMenuPasswordText = loginMenuLogin.createInput(190, l + 10, 200, 40, 4, 20, true, false);
        l -= 55;
        loginMenuLogin.drawButton(410, l, 120, 25);
        loginMenuLogin.drawText(410, l, "Ok", 4, false);
        loginMenuOkLoginButton = loginMenuLogin.createButton(410, l, 120, 25);
        l += 30;
        loginMenuLogin.drawButton(410, l, 120, 25);
        loginMenuLogin.drawText(410, l, "Cancel", 4, false);
        loginMenuCancelButton = loginMenuLogin.createButton(410, l, 120, 25);
        l += 30;
        loginMenuLogin.setFocus(loginMenuUserText);
    }

    protected final void lostConnection()
    {
        systemUpdate = 0;
        if(logoutTimer != 0)
        {
            resetIntVars();
            return;
        } else
        {
            super.lostConnection();
            return;
        }
    }

    private final void loadMedia()
    {
        byte media[] = unpackData("media" + Version.VERSION_MEDIA + ".jag", "2d graphics", 20);
        if(media == null)
        {
            errorLoading = true;
            return;
        }
        byte abyte1[] = DataOperations.loadData("index.dat", 0, media);
        gameGraphics.unpackImageData(baseInventoryPic, DataOperations.loadData("inv1.dat", 0, media), abyte1, 1);
        gameGraphics.unpackImageData(baseInventoryPic + 1, DataOperations.loadData("inv2.dat", 0, media), abyte1, 6);
        gameGraphics.unpackImageData(baseInventoryPic + 9, DataOperations.loadData("bubble.dat", 0, media), abyte1, 1);
        gameGraphics.unpackImageData(baseInventoryPic + 10, DataOperations.loadData("runescape.dat", 0, media), abyte1, 1);
        gameGraphics.unpackImageData(baseInventoryPic + 11, DataOperations.loadData("splat.dat", 0, media), abyte1, 3);
        gameGraphics.unpackImageData(baseInventoryPic + 14, DataOperations.loadData("icon.dat", 0, media), abyte1, 8);
        gameGraphics.unpackImageData(baseInventoryPic + 22, DataOperations.loadData("hbar.dat", 0, media), abyte1, 1);
        gameGraphics.unpackImageData(baseInventoryPic + 23, DataOperations.loadData("hbar2.dat", 0, media), abyte1, 1);
        gameGraphics.unpackImageData(baseInventoryPic + 24, DataOperations.loadData("compass.dat", 0, media), abyte1, 1);
        gameGraphics.unpackImageData(baseInventoryPic + 25, DataOperations.loadData("buttons.dat", 0, media), abyte1, 2);
        gameGraphics.unpackImageData(baseScrollPic, DataOperations.loadData("scrollbar.dat", 0, media), abyte1, 2);
        gameGraphics.unpackImageData(baseScrollPic + 2, DataOperations.loadData("corners.dat", 0, media), abyte1, 4);
        gameGraphics.unpackImageData(baseScrollPic + 6, DataOperations.loadData("arrows.dat", 0, media), abyte1, 2);
        gameGraphics.unpackImageData(baseProjectilePic, DataOperations.loadData("projectile.dat", 0, media), abyte1, Data.spellProjectileCount);
        int l = Data.highestLoadedPicture;
        for(int i1 = 1; l > 0; i1++)
        {
            int j1 = l;
            l -= 30;
            if(j1 > 30)
                j1 = 30;
            gameGraphics.unpackImageData(baseItemPicture + (i1 - 1) * 30, DataOperations.loadData("objects" + i1 + ".dat", 0, media), abyte1, j1);
        }

        gameGraphics.loadImage(baseInventoryPic);
        gameGraphics.loadImage(baseInventoryPic + 9);
        for(int k1 = 11; k1 <= 26; k1++)
            gameGraphics.loadImage(baseInventoryPic + k1);

        for(int l1 = 0; l1 < Data.spellProjectileCount; l1++)
            gameGraphics.loadImage(baseProjectilePic + l1);

        for(int i2 = 0; i2 < Data.highestLoadedPicture; i2++)
            gameGraphics.loadImage(baseItemPicture + i2);

    }

    protected final void checkInputs()
    {
        if(codebaseError)
            return;
        if(memoryError)
            return;
        if(errorLoading)
            return;
        try
        {
            tick++;
            if(loggedIn == 0)
            {
                super.lastActionTimeout = 0;
                checkLoginScreenInputs();
            }
            if(loggedIn == 1)
            {
                super.lastActionTimeout++;
                checkGameInputs();
            }
            super.lastMouseButton = 0;
            cameraRotateTime++;
            if(cameraRotateTime > 500)
            {
                cameraRotateTime = 0;
                int l = (int)(Math.random() * 4D);
                if((l & 1) == 1)
                    cameraRotationXAmount += cameraRotationXIncrement;
                if((l & 2) == 2)
                    cameraRotationYAmount += cameraRotationYIncrement;
            }
            if(cameraRotationXAmount < -50)
                cameraRotationXIncrement = 2;
            if(cameraRotationXAmount > 50)
                cameraRotationXIncrement = -2;
            if(cameraRotationYAmount < -50)
                cameraRotationYIncrement = 2;
            if(cameraRotationYAmount > 50)
                cameraRotationYIncrement = -2;
            if(chatTabAllMsgFlash > 0)
                chatTabAllMsgFlash--;
            if(chatTabHistoryFlash > 0)
                chatTabHistoryFlash--;
            if(chatTabQuestFlash > 0)
                chatTabQuestFlash--;
            if(chatTabPrivateFlash > 0)
                chatTabPrivateFlash--;
        }
        catch(OutOfMemoryError _ex)
        {
            cleanUp();
            memoryError = true;
        }
    }

    private final void loadAnimations()
    {
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = unpackData("entity" + Version.VERSION_ENTITY + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            errorLoading = true;
            return;
        }
        abyte1 = DataOperations.loadData("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(members)
        {
            abyte2 = unpackData("entity" + Version.VERSION_ENTITY + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                errorLoading = true;
                return;
            }
            abyte3 = DataOperations.loadData("index.dat", 0, abyte2);
        }
        int l = 0;
        //ebi = 0;
        animationNumber = ebi;
label0:
        for(int i1 = 0; i1 < Data.animationCount; i1++)
        {
            String s1 = Data.animationName[i1];
            for(int j1 = 0; j1 < i1; j1++)
            {
                if(!Data.animationName[j1].equalsIgnoreCase(s1))
                    continue;
                Data.animationNumber[i1] = Data.animationNumber[j1];
                continue label0;
            }

            byte abyte7[] = DataOperations.loadData(s1 + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && members)
            {
                abyte7 = DataOperations.loadData(s1 + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                gameGraphics.unpackImageData(animationNumber, abyte7, abyte4, 15);
                l += 15;
                if(Data.animationHasA[i1] == 1)
                {
                    byte abyte8[] = DataOperations.loadData(s1 + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && members)
                    {
                        abyte8 = DataOperations.loadData(s1 + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    gameGraphics.unpackImageData(animationNumber + 15, abyte8, abyte5, 3);
                    l += 3;
                }
                if(Data.animationHasF[i1] == 1)
                {
                    byte abyte9[] = DataOperations.loadData(s1 + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && members)
                    {
                        abyte9 = DataOperations.loadData(s1 + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    gameGraphics.unpackImageData(animationNumber + 18, abyte9, abyte6, 9);
                    l += 9;
                }
                if(Data.animationGenderModels[i1] != 0)
                {
                    for(int k1 = animationNumber; k1 < animationNumber + 27; k1++)
                        gameGraphics.loadImage(k1);

                }
            }
            Data.animationNumber[i1] = animationNumber;
            animationNumber += 27;
        }

        System.out.println("Loaded: " + l + " frames of animation");
    }

    private final void updateAppearanceWindow()
    {
        appearanceMenu.mouseClick(super.mouseX, super.mouseY, super.lastMouseButton, super.mouseButton);
        if(appearanceMenu.isClicked(appearanceHeadLeftArrow))
            do
                appearanceHeadType = ((appearanceHeadType - 1) + Data.animationCount) % Data.animationCount;
            while((Data.animationGenderModels[appearanceHeadType] & 3) != 1 || (Data.animationGenderModels[appearanceHeadType] & 4 * appearanceHeadGender) == 0);
        if(appearanceMenu.isClicked(appearanceHeadRightArrow))
            do
                appearanceHeadType = (appearanceHeadType + 1) % Data.animationCount;
            while((Data.animationGenderModels[appearanceHeadType] & 3) != 1 || (Data.animationGenderModels[appearanceHeadType] & 4 * appearanceHeadGender) == 0);
        if(appearanceMenu.isClicked(appearanceHairLeftArrow))
            appearanceHairColour = ((appearanceHairColour - 1) + appearanceHairColours.length) % appearanceHairColours.length;
        if(appearanceMenu.isClicked(appearanceHairRightArrow))
            appearanceHairColour = (appearanceHairColour + 1) % appearanceHairColours.length;
        if(appearanceMenu.isClicked(appearanceGenderLeftArrow) || appearanceMenu.isClicked(appearanceGenderRightArrow))
        {
            for(appearanceHeadGender = 3 - appearanceHeadGender; (Data.animationGenderModels[appearanceHeadType] & 3) != 1 || (Data.animationGenderModels[appearanceHeadType] & 4 * appearanceHeadGender) == 0; appearanceHeadType = (appearanceHeadType + 1) % Data.animationCount);
            for(; (Data.animationGenderModels[appearanceBodyGender] & 3) != 2 || (Data.animationGenderModels[appearanceBodyGender] & 4 * appearanceHeadGender) == 0; appearanceBodyGender = (appearanceBodyGender + 1) % Data.animationCount);
        }
        if(appearanceMenu.isClicked(appearanceTopLeftArrow))
            appearanceTopColour = ((appearanceTopColour - 1) + appearanceTopBottomColours.length) % appearanceTopBottomColours.length;
        if(appearanceMenu.isClicked(appearanceTopRightArrow))
            appearanceTopColour = (appearanceTopColour + 1) % appearanceTopBottomColours.length;
        if(appearanceMenu.isClicked(appearanceSkinLeftArrow))
            appearanceSkinColour = ((appearanceSkinColour - 1) + dki.length) % dki.length;
        if(appearanceMenu.isClicked(appearanceSkingRightArrow))
            appearanceSkinColour = (appearanceSkinColour + 1) % dki.length;
        if(appearanceMenu.isClicked(appearanceBottomLeftArrow))
            appearanceBottomColour = ((appearanceBottomColour - 1) + appearanceTopBottomColours.length) % appearanceTopBottomColours.length;
        if(appearanceMenu.isClicked(appearanceBottomRightArrow))
            appearanceBottomColour = (appearanceBottomColour + 1) % appearanceTopBottomColours.length;
        if(appearanceMenu.isClicked(appearanceAcceptButton))
        {
            super.streamClass.createPacket(218);
            super.streamClass.addByte(appearanceHeadGender);
            super.streamClass.addByte(appearanceHeadType);
            super.streamClass.addByte(appearanceBodyGender);
            super.streamClass.addByte(appearance2Colour);
            super.streamClass.addByte(appearanceHairColour);
            super.streamClass.addByte(appearanceTopColour);
            super.streamClass.addByte(appearanceBottomColour);
            super.streamClass.addByte(appearanceSkinColour);
            super.streamClass.formatPacket();
            gameGraphics.clearScreen();
            showAppearanceWindow = false;
        }
    }

    private final void drawWelcomeBox()
    {
        int l = 65;
        if(lastChangedRecoveryDays != 201)
            l += 60;
        if(unreadMessages > 0)
            l += 60;
        if(lastLoginIPInt != 0)
            l += 45;
        int i1 = 167 - l / 2;
        gameGraphics.drawBox(56, 167 - l / 2, 400, l, 0);
        gameGraphics.drawBoxEdge(56, 167 - l / 2, 400, l, 0xffffff);
        i1 += 20;
        gameGraphics.drawText("Welcome to RuneScape " + loginUsername, 256, i1, 4, 0xffff00);
        i1 += 30;
        String s1;
        if(lastLoginDays == 0)
            s1 = "earlier today";
        else
        if(lastLoginDays == 1)
            s1 = "yesterday";
        else
            s1 = lastLoginDays + " days ago";
        if(lastLoginIPInt != 0)
        {
            gameGraphics.drawText("You last logged in " + s1, 256, i1, 1, 0xffffff);
            i1 += 15;
            if(lastLoginAddress == null)
                lastLoginAddress = resolveIP(lastLoginIPInt);
            gameGraphics.drawText("from: " + lastLoginAddress, 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(unreadMessages > 0)
        {
            int j1 = 0xffffff;
            gameGraphics.drawText("Jagex staff will NEVER email you. We use the", 256, i1, 1, j1);
            i1 += 15;
            gameGraphics.drawText("message-centre on this website instead.", 256, i1, 1, j1);
            i1 += 15;
            if(unreadMessages == 1)
                gameGraphics.drawText("You have @yel@0@whi@ unread messages in your message-centre", 256, i1, 1, 0xffffff);
            else
                gameGraphics.drawText("You have @gre@" + (unreadMessages - 1) + " unread messages @whi@in your message-centre", 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(lastChangedRecoveryDays != 201)
        {
            if(lastChangedRecoveryDays == 200)
            {
                gameGraphics.drawText("You have not yet set any password recovery questions.", 256, i1, 1, 0xff8000);
                i1 += 15;
                gameGraphics.drawText("We strongly recommend you do so now to secure your account.", 256, i1, 1, 0xff8000);
                i1 += 15;
                gameGraphics.drawText("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            } else
            {
                String s2;
                if(lastChangedRecoveryDays == 0)
                    s2 = "Earlier today";
                else
                if(lastChangedRecoveryDays == 1)
                    s2 = "Yesterday";
                else
                    s2 = lastChangedRecoveryDays + " days ago";
                gameGraphics.drawText(s2 + " you changed your recovery questions", 256, i1, 1, 0xff8000);
                i1 += 15;
                gameGraphics.drawText("If you do not remember making this change then cancel it immediately", 256, i1, 1, 0xff8000);
                i1 += 15;
                gameGraphics.drawText("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            }
            i1 += 15;
        }
        int k1 = 0xffffff;
        if(super.mouseY > i1 - 12 && super.mouseY <= i1 && super.mouseX > 106 && super.mouseX < 406)
            k1 = 0xff0000;
        gameGraphics.drawText("Click here to close window", 256, i1, 1, k1);
        if(mouseButtonClick == 1)
        {
            if(k1 == 0xff0000)
                showWelcomeBox = false;
            if((super.mouseX < 86 || super.mouseX > 426) && (super.mouseY < 167 - l / 2 || super.mouseY > 167 + l / 2))
                showWelcomeBox = false;
        }
        mouseButtonClick = 0;
    }

    private final int getInventoryItemTotalCount(int arg0)
    {
        int l = 0;
        for(int i1 = 0; i1 < inventoryItemsCount; i1++)
            if(inventoryItems[i1] == arg0)
                if(Data.itemStackable[arg0] == 1)
                    l++;
                else
                    l += inventoryItemCount[i1];

        return l;
    }

    private final void sendLogout()
    {
        if(loggedIn == 0)
            return;
        if(combatTimeout > 450)
        {
            displayMessage("@cya@You can't logout during combat!", 3);
            return;
        }
        if(combatTimeout > 0)
        {
            displayMessage("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.streamClass.createPacket(129);
            super.streamClass.formatPacket();
            logoutTimer = 1000;
            return;
        }
    }

    public final URL getCodeBase()
    {
        if(link.gameApplet != null)
            return link.gameApplet.getCodeBase();
        else
            return super.getCodeBase();
    }

    private final boolean walkTo(int startX, int startY, int destBottomX, int destBottomY, int destTopX, int destTopY, boolean checkForObjects, 
            boolean walkToACommand)
    {
        int stepCount = engineHandle.generatePath(startX, startY, destBottomX, destBottomY, destTopX, destTopY, walkArrayX, walkArrayY, checkForObjects);
        if(stepCount == -1)
            if(walkToACommand)
            {
                stepCount = 1;
                walkArrayX[0] = destBottomX;
                walkArrayY[0] = destBottomY;
            } else
            {
                return false;
            }
        stepCount--;
        startX = walkArrayX[stepCount];
        startY = walkArrayY[stepCount];
        stepCount--;
        if(walkToACommand)
            super.streamClass.createPacket(246);
        else
            super.streamClass.createPacket(132);
        super.streamClass.addShort(startX + areaX);
        super.streamClass.addShort(startY + areaY);
        if(walkToACommand && stepCount == -1 && (startX + areaX) % 5 == 0)
            stepCount = 0;
        for(int i1 = stepCount; i1 >= 0 && i1 > stepCount - 25; i1--)
        {
            super.streamClass.addByte(walkArrayX[i1] - startX);
            super.streamClass.addByte(walkArrayY[i1] - startY);
        }

        super.streamClass.formatPacket();
        actionPictureType = -24;
        walkMouseX = super.mouseX;
        walkMouseY = super.mouseY;
        return true;
    }

    private final boolean walkTo2(int startX, int startY, int destBottomX, int destBottomY, int destTopX, int destTopY, boolean unknownDifferent, 
            boolean walkToACommand)
    {
        int stepCount = engineHandle.generatePath(startX, startY, destBottomX, destBottomY, destTopX, destTopY, walkArrayX, walkArrayY, unknownDifferent);
        if(stepCount == -1)
            return false;
        stepCount--;
        startX = walkArrayX[stepCount];
        startY = walkArrayY[stepCount];
        stepCount--;
        if(walkToACommand)
            super.streamClass.createPacket(246);
        else
            super.streamClass.createPacket(132);
        super.streamClass.addShort(startX + areaX);
        super.streamClass.addShort(startY + areaY);
        if(walkToACommand && stepCount == -1 && (startX + areaX) % 5 == 0)
            stepCount = 0;
        for(int i1 = stepCount; i1 >= 0 && i1 > stepCount - 25; i1--)
        {
            super.streamClass.addByte(walkArrayX[i1] - startX);
            super.streamClass.addByte(walkArrayY[i1] - startY);
        }

        super.streamClass.formatPacket();
        actionPictureType = -24;
        walkMouseX = super.mouseX;
        walkMouseY = super.mouseY;
        return true;
    }

    private final void drawOptionsMenu(boolean canClick)
    {
        int l = ((GameImage) (gameGraphics)).gameWidth - 199;
        int i1 = 36;
        gameGraphics.drawPicture(l - 49, 3, baseInventoryPic + 6);
        char c1 = '\304';
        gameGraphics.drawBoxAlpha(l, 36, c1, 65, GameImage.rgbToInt(181, 181, 181), 160);
        gameGraphics.drawBoxAlpha(l, 101, c1, 65, GameImage.rgbToInt(201, 201, 201), 160);
        gameGraphics.drawBoxAlpha(l, 166, c1, 95, GameImage.rgbToInt(181, 181, 181), 160);
        gameGraphics.drawBoxAlpha(l, 261, c1, 40, GameImage.rgbToInt(201, 201, 201), 160);
        int j1 = l + 3;
        int l1 = i1 + 15;
        gameGraphics.drawString("Game options - click to toggle", j1, l1, 1, 0);
        l1 += 15;
        if(configCmeraAutoAngle)
            gameGraphics.drawString("Camera angle mode - @gre@Auto", j1, l1, 1, 0xffffff);
        else
            gameGraphics.drawString("Camera angle mode - @red@Manual", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(configOneMouseButton)
            gameGraphics.drawString("Mouse buttons - @red@One", j1, l1, 1, 0xffffff);
        else
            gameGraphics.drawString("Mouse buttons - @gre@Two", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(members)
            if(configSoundOff)
                gameGraphics.drawString("Sound effects - @red@off", j1, l1, 1, 0xffffff);
            else
                gameGraphics.drawString("Sound effects - @gre@on", j1, l1, 1, 0xffffff);
        l1 += 15;
        gameGraphics.drawString("To change your contact details,", j1, l1, 0, 0xffffff);
        l1 += 15;
        gameGraphics.drawString("password, recovery questions, etc..", j1, l1, 0, 0xffffff);
        l1 += 15;
        gameGraphics.drawString("please select 'account management'", j1, l1, 0, 0xffffff);
        l1 += 15;
        if(referId == 0)
            gameGraphics.drawString("from the runescape.com front page", j1, l1, 0, 0xffffff);
        else
        if(referId == 1)
            gameGraphics.drawString("from the link below the gamewindow", j1, l1, 0, 0xffffff);
        else
            gameGraphics.drawString("from the runescape front webpage", j1, l1, 0, 0xffffff);
        l1 += 15;
        l1 += 5;
        gameGraphics.drawString("Privacy settings. Will be applied to", l + 3, l1, 1, 0);
        l1 += 15;
        gameGraphics.drawString("all people not on your friends list", l + 3, l1, 1, 0);
        l1 += 15;
        if(super.blockChat == 0)
            gameGraphics.drawString("Block chat messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            gameGraphics.drawString("Block chat messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.blockPrivate == 0)
            gameGraphics.drawString("Block private messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            gameGraphics.drawString("Block private messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.blockTrade == 0)
            gameGraphics.drawString("Block trade requests: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            gameGraphics.drawString("Block trade requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(members)
            if(super.blockDuel == 0)
                gameGraphics.drawString("Block duel requests: @red@<off>", l + 3, l1, 1, 0xffffff);
            else
                gameGraphics.drawString("Block duel requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        l1 += 5;
        gameGraphics.drawString("Always logout when you finish", j1, l1, 1, 0);
        l1 += 15;
        int j2 = 0xffffff;
        if(super.mouseX > j1 && super.mouseX < j1 + c1 && super.mouseY > l1 - 12 && super.mouseY < l1 + 4)
            j2 = 0xffff00;
        gameGraphics.drawString("Click here to logout", l + 3, l1, 1, j2);
        if(!canClick)
            return;
        l = super.mouseX - (((GameImage) (gameGraphics)).gameWidth - 199);
        i1 = super.mouseY - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 265)
        {
            int k2 = ((GameImage) (gameGraphics)).gameWidth - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int k1 = k2 + 3;
            int i2 = byte0 + 30;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && mouseButtonClick == 1)
            {
                configCmeraAutoAngle = !configCmeraAutoAngle;
                super.streamClass.createPacket(157);
                super.streamClass.addByte(0);
                super.streamClass.addByte(configCmeraAutoAngle ? 1 : 0);
                super.streamClass.formatPacket();
            }
            i2 += 15;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && mouseButtonClick == 1)
            {
                configOneMouseButton = !configOneMouseButton;
                super.streamClass.createPacket(157);
                super.streamClass.addByte(2);
                super.streamClass.addByte(configOneMouseButton ? 1 : 0);
                super.streamClass.formatPacket();
            }
            i2 += 15;
            if(members && super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && mouseButtonClick == 1)
            {
                configSoundOff = !configSoundOff;
                super.streamClass.createPacket(157);
                super.streamClass.addByte(3);
                super.streamClass.addByte(configSoundOff ? 1 : 0);
                super.streamClass.formatPacket();
            }
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            boolean flag = false;
            i2 += 35;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && mouseButtonClick == 1)
            {
                super.blockChat = 1 - super.blockChat;
                flag = true;
            }
            i2 += 15;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && mouseButtonClick == 1)
            {
                super.blockPrivate = 1 - super.blockPrivate;
                flag = true;
            }
            i2 += 15;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && mouseButtonClick == 1)
            {
                super.blockTrade = 1 - super.blockTrade;
                flag = true;
            }
            i2 += 15;
            if(members && super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && mouseButtonClick == 1)
            {
                super.blockDuel = 1 - super.blockDuel;
                flag = true;
            }
            i2 += 15;
            if(flag)
                sendUpdatedPrivacyInfo(super.blockChat, super.blockPrivate, super.blockTrade, super.blockDuel);
            i2 += 20;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && mouseButtonClick == 1)
                sendLogout();
            mouseButtonClick = 0;
        }
    }

    private final void walkToObject(int arg0, int arg1, int arg2, int arg3)
    {
        int l;
        int i1;
        if(arg2 == 0 || arg2 == 4)
        {
            l = Data.objectWidth[arg3];
            i1 = Data.objectHeight[arg3];
        } else
        {
            i1 = Data.objectWidth[arg3];
            l = Data.objectHeight[arg3];
        }
        if(Data.objectType[arg3] == 2 || Data.objectType[arg3] == 3)
        {
            if(arg2 == 0)
            {
                arg0--;
                l++;
            }
            if(arg2 == 2)
                i1++;
            if(arg2 == 4)
                l++;
            if(arg2 == 6)
            {
                arg1--;
                i1++;
            }
            walkTo(sectionX, sectionY, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, false, true);
            return;
        } else
        {
            walkTo(sectionX, sectionY, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, true, true);
            return;
        }
    }

    private final void createChatInputMenu()
    {
        chatInputMenu = new Menu(gameGraphics, 10);
        messagesHandleType2 = chatInputMenu.gfh(5, 269, 502, 56, 1, 20, true);
        chatInputBox = chatInputMenu.gfi(7, 324, 498, 14, 1, 80, false, true);
        messagesHandleType5 = chatInputMenu.gfh(5, 269, 502, 56, 1, 20, true);
        messagesHandleType6 = chatInputMenu.gfh(5, 269, 502, 56, 1, 20, true);
        chatInputMenu.setFocus(chatInputBox);
    }

    private final void drawCombatStyleBox()
    {
        byte byte0 = 7;
        byte byte1 = 15;
        char c1 = '\257';
        if(mouseButtonClick != 0)
        {
            for(int l = 0; l < 5; l++)
            {
                if(l <= 0 || super.mouseX <= byte0 || super.mouseX >= byte0 + c1 || super.mouseY <= byte1 + l * 20 || super.mouseY >= byte1 + l * 20 + 20)
                    continue;
                combatStyle = l - 1;
                mouseButtonClick = 0;
                super.streamClass.createPacket(42);
                super.streamClass.addByte(combatStyle);
                super.streamClass.formatPacket();
                break;
            }

        }
        for(int i1 = 0; i1 < 5; i1++)
        {
            if(i1 == combatStyle + 1)
                gameGraphics.drawBoxAlpha(byte0, byte1 + i1 * 20, c1, 20, GameImage.rgbToInt(255, 0, 0), 128);
            else
                gameGraphics.drawBoxAlpha(byte0, byte1 + i1 * 20, c1, 20, GameImage.rgbToInt(190, 190, 190), 128);
            gameGraphics.drawLineX(byte0, byte1 + i1 * 20, c1, 0);
            gameGraphics.drawLineX(byte0, byte1 + i1 * 20 + 20, c1, 0);
        }

        gameGraphics.drawText("Select combat style", byte0 + c1 / 2, byte1 + 16, 3, 0xffffff);
        gameGraphics.drawText("Controlled (+1 of each)", byte0 + c1 / 2, byte1 + 36, 3, 0);
        gameGraphics.drawText("Aggressive (+3 strength)", byte0 + c1 / 2, byte1 + 56, 3, 0);
        gameGraphics.drawText("Accurate   (+3 attack)", byte0 + c1 / 2, byte1 + 76, 3, 0);
        gameGraphics.drawText("Defensive  (+3 defense)", byte0 + c1 / 2, byte1 + 96, 3, 0);
    }

    private final void drawTradeBox()
    {
        if(mouseButtonClick != 0 && mouseClickedHeldInTradeDuelBox == 0)
            mouseClickedHeldInTradeDuelBox = 1;
        if(mouseClickedHeldInTradeDuelBox > 0)
        {
            int mx = super.mouseX - 22;
            int my = super.mouseY - 36;
            if(mx >= 0 && my >= 0 && mx < 468 && my < 262)
            {
                if(mx > 216 && my > 30 && mx < 462 && my < 235)
                {
                    int curItem = (mx - 217) / 49 + ((my - 31) / 34) * 5;
                    if(curItem >= 0 && curItem < inventoryItemsCount)
                    {
                        boolean ourTradeItemsChanged = false;
                        int someInt = 0;
                        int item = inventoryItems[curItem];
                        for(int tradeItem = 0; tradeItem < tradeItemsOurCount; tradeItem++)
                            if(tradeItemsOur[tradeItem] == item)
                                if(Data.itemStackable[item] == 0)
                                {
                                    for(int l4 = 0; l4 < mouseClickedHeldInTradeDuelBox; l4++)
                                    {
                                        if(tradeItemOurCount[tradeItem] < inventoryItemCount[curItem])
                                            tradeItemOurCount[tradeItem]++;
                                        ourTradeItemsChanged = true;
                                    }

                                }
                                else {
                                    someInt ++;
                                }

                        if(getInventoryItemTotalCount(item) <= someInt)
                            ourTradeItemsChanged = true;
                        if(Data.itemSpecial[item] == 1)
                        {
                            displayMessage("This object cannot be traded with other players", 3);
                            ourTradeItemsChanged = true;
                        }
                        if(!ourTradeItemsChanged && tradeItemsOurCount < 12)
                        {
                            tradeItemsOur[tradeItemsOurCount] = item;
                            tradeItemOurCount[tradeItemsOurCount] = 1;
                            tradeItemsOurCount++;
                            ourTradeItemsChanged = true;
                        }
                        if(ourTradeItemsChanged)
                        {
                            super.streamClass.createPacket(70);
                            super.streamClass.addByte(tradeItemsOurCount);
                            for(int i5 = 0; i5 < tradeItemsOurCount; i5++)
                            {
                                super.streamClass.addShort(tradeItemsOur[i5]);
                                super.streamClass.addInt(tradeItemOurCount[i5]);
                            }

                            super.streamClass.formatPacket();
                            tradeOtherAccepted = false;
                            tradeWeAccepted = false;
                        }
                    }
                }
                if(mx > 8 && my > 30 && mx < 205 && my < 133)
                {
                    int k1 = (mx - 9) / 49 + ((my - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < tradeItemsOurCount)
                    {
                        int i2 = tradeItemsOur[k1];
                        for(int l2 = 0; l2 < mouseClickedHeldInTradeDuelBox; l2++)
                        {
                            if(Data.itemStackable[i2] == 0 && tradeItemOurCount[k1] > 1)
                            {
                                tradeItemOurCount[k1]--;
                                continue;
                            }
                            tradeItemsOurCount--;
                            mouseButtonHeldTime = 0;
                            for(int k3 = k1; k3 < tradeItemsOurCount; k3++)
                            {
                                tradeItemsOur[k3] = tradeItemsOur[k3 + 1];
                                tradeItemOurCount[k3] = tradeItemOurCount[k3 + 1];
                            }

                            break;
                        }

                        super.streamClass.createPacket(70);
                        super.streamClass.addByte(tradeItemsOurCount);
                        for(int l3 = 0; l3 < tradeItemsOurCount; l3++)
                        {
                            super.streamClass.addShort(tradeItemsOur[l3]);
                            super.streamClass.addInt(tradeItemOurCount[l3]);
                        }

                        super.streamClass.formatPacket();
                        tradeOtherAccepted = false;
                        tradeWeAccepted = false;
                    }
                }
                if(mx >= 217 && my >= 238 && mx <= 286 && my <= 259)
                {
                    tradeWeAccepted = true;
                    super.streamClass.createPacket(211);
                    super.streamClass.formatPacket();
                }
                if(mx >= 394 && my >= 238 && mx < 463 && my < 259)
                {
                    showTradeBox = false;
                    super.streamClass.createPacket(216);
                    super.streamClass.formatPacket();
                }
            } else
            if(mouseButtonClick != 0)
            {
                showTradeBox = false;
                super.streamClass.createPacket(216);
                super.streamClass.formatPacket();
            }
            mouseButtonClick = 0;
            mouseClickedHeldInTradeDuelBox = 0;
        }
        if(!showTradeBox)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        gameGraphics.drawBox(byte0, byte1, 468, 12, 192);
        int l1 = 0x989898;
        gameGraphics.drawBoxAlpha(byte0, byte1 + 12, 468, 18, l1, 160);
        gameGraphics.drawBoxAlpha(byte0, byte1 + 30, 8, 248, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 133, 197, 22, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 30, 197, 103, j2, 160);
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 155, 197, 103, j2, 160);
        gameGraphics.drawBoxAlpha(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 4; i3++)
            gameGraphics.drawLineX(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 4; i4++)
            gameGraphics.drawLineX(byte0 + 8, byte1 + 155 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            gameGraphics.drawLineX(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                gameGraphics.drawLineY(byte0 + 8 + j5 * 49, byte1 + 30, 103, 0);
            if(j5 < 5)
                gameGraphics.drawLineY(byte0 + 8 + j5 * 49, byte1 + 155, 103, 0);
            gameGraphics.drawLineY(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        gameGraphics.drawString("Trading with: " + tradeOtherName, byte0 + 1, byte1 + 10, 1, 0xffffff);
        gameGraphics.drawString("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        gameGraphics.drawString("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        gameGraphics.drawString("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!tradeWeAccepted)
            gameGraphics.drawPicture(byte0 + 217, byte1 + 238, baseInventoryPic + 25);
        gameGraphics.drawPicture(byte0 + 394, byte1 + 238, baseInventoryPic + 26);
        if(tradeOtherAccepted)
        {
            gameGraphics.drawText("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            gameGraphics.drawText("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(tradeWeAccepted)
        {
            gameGraphics.drawText("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            gameGraphics.drawText("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < inventoryItemsCount; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            gameGraphics.drawImage(l5, j6, 48, 32, baseItemPicture + Data.itemInventoryPicture[inventoryItems[k5]], Data.itemPictureMask[inventoryItems[k5]], 0, 0, false);
            if(Data.itemStackable[inventoryItems[k5]] == 0)
                gameGraphics.drawString(String.valueOf(inventoryItemCount[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < tradeItemsOurCount; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            gameGraphics.drawImage(k6, i7, 48, 32, baseItemPicture + Data.itemInventoryPicture[tradeItemsOur[i6]], Data.itemPictureMask[tradeItemsOur[i6]], 0, 0, false);
            if(Data.itemStackable[tradeItemsOur[i6]] == 0)
                gameGraphics.drawString(String.valueOf(tradeItemOurCount[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > i7 && super.mouseY < i7 + 32)
                gameGraphics.drawString(Data.itemName[tradeItemsOur[i6]] + ": @whi@" + Data.itemDescription[tradeItemsOur[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < tradeItemsOtherCount; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 156 + byte1 + (l6 / 4) * 34;
            gameGraphics.drawImage(j7, k7, 48, 32, baseItemPicture + Data.itemInventoryPicture[tradeItemsOther[l6]], Data.itemPictureMask[tradeItemsOther[l6]], 0, 0, false);
            if(Data.itemStackable[tradeItemsOther[l6]] == 0)
                gameGraphics.drawString(String.valueOf(dff[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.mouseX > j7 && super.mouseX < j7 + 48 && super.mouseY > k7 && super.mouseY < k7 + 32)
                gameGraphics.drawString(Data.itemName[tradeItemsOther[l6]] + ": @whi@" + Data.itemDescription[tradeItemsOther[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void autoRotateCamera()
    {
        if((cameraAutoAngle & 1) == 1 && validCameraAngle(cameraAutoAngle))
            return;
        if((cameraAutoAngle & 1) == 0 && validCameraAngle(cameraAutoAngle))
        {
            if(validCameraAngle(cameraAutoAngle + 1 & 7))
            {
                cameraAutoAngle = cameraAutoAngle + 1 & 7;
                return;
            }
            if(validCameraAngle(cameraAutoAngle + 7 & 7))
                cameraAutoAngle = cameraAutoAngle + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int l = 0; l < 7; l++)
        {
            if(!validCameraAngle(cameraAutoAngle + ai[l] + 8 & 7))
                continue;
            cameraAutoAngle = cameraAutoAngle + ai[l] + 8 & 7;
            break;
        }

        if((cameraAutoAngle & 1) == 0 && validCameraAngle(cameraAutoAngle))
        {
            if(validCameraAngle(cameraAutoAngle + 1 & 7))
            {
                cameraAutoAngle = cameraAutoAngle + 1 & 7;
                return;
            }
            if(validCameraAngle(cameraAutoAngle + 7 & 7))
                cameraAutoAngle = cameraAutoAngle + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    public final String getParameter(String s1)
    {
        if(link.gameApplet != null)
            return link.gameApplet.getParameter(s1);
        else
            return super.getParameter(s1);
    }

    private final void drawLogoutBox()
    {
        gameGraphics.drawBox(126, 137, 260, 60, 0);
        gameGraphics.drawBoxEdge(126, 137, 260, 60, 0xffffff);
        gameGraphics.drawText("Logging out...", 256, 173, 5, 0xffffff);
    }

    private final void walkToGroundItem(int l, int i1, int j1, int k1, boolean flag)
    {
        if(walkTo2(l, i1, j1, k1, j1, k1, false, flag))
        {
            return;
        } else
        {
            walkTo(l, i1, j1, k1, j1, k1, true, flag);
            return;
        }
    }

    protected final void loginScreenPrint(String s1, String s2)
    {
        if(loginScreen == 2)
            loginMenuLogin.updateText(loginMenuStatusText, s1 + " " + s2);
        drawLoginScreens();
        resetTimings();
    }

    final void drawTeleBubble(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int type = teleBubbleType[l1];
        int time = teleBubbleTime[l1];
        if(type == 0)
        {
            int i3 = 255 + time * 5 * 256;
            gameGraphics.drawCircle(l + j1 / 2, i1 + k1 / 2, 20 + time * 2, i3, 255 - time * 5);
        }
        if(type == 1)
        {
            int j3 = 0xff0000 + time * 5 * 256;
            gameGraphics.drawCircle(l + j1 / 2, i1 + k1 / 2, 10 + time, j3, 255 - time * 5);
        }
    }

    private final void checkLoginScreenInputs()
    {
        if(super.socketTimeout > 0)
            super.socketTimeout--;
        if(loginScreen == 0)
        {
            loginMenuFirst.mouseClick(super.mouseX, super.mouseY, super.lastMouseButton, super.mouseButton);
            if(loginMenuFirst.isClicked(loginButtonNewUser))
                loginScreen = 1;
            if(loginMenuFirst.isClicked(loginMenuLoginButton))
            {
                loginScreen = 2;
                loginMenuLogin.updateText(loginMenuStatusText, "Please enter your username and password");
                loginMenuLogin.updateText(loginMenuUserText, "");
                loginMenuLogin.updateText(loginMenuPasswordText, "");
                loginMenuLogin.setFocus(loginMenuUserText);
                return;
            }
        } else
        if(loginScreen == 1)
        {
            loginNewUser.mouseClick(super.mouseX, super.mouseY, super.lastMouseButton, super.mouseButton);
            if(loginNewUser.isClicked(loginMenuOkButton))
            {
                loginScreen = 0;
                return;
            }
        } else
        if(loginScreen == 2)
        {
            loginMenuLogin.mouseClick(super.mouseX, super.mouseY, super.lastMouseButton, super.mouseButton);
            if(loginMenuLogin.isClicked(loginMenuCancelButton))
                loginScreen = 0;
            if(loginMenuLogin.isClicked(loginMenuUserText))
                loginMenuLogin.setFocus(loginMenuPasswordText);
            if(loginMenuLogin.isClicked(loginMenuPasswordText) || loginMenuLogin.isClicked(loginMenuOkLoginButton))
            {
                loginUsername = loginMenuLogin.getText(loginMenuUserText);
                loginPassword = loginMenuLogin.getText(loginMenuPasswordText);
                connect(loginUsername, loginPassword, false);
            }
        }
    }

    private final boolean isItemEquipped(int arg0)
    {
        for(int l = 0; l < inventoryItemsCount; l++)
            if(inventoryItems[l] == arg0 && inventoryItemEquipped[l] == 1)
                return true;

        return false;
    }

    protected final void drawWindow()
    {
        if(errorLoading)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 16));
            g1.setColor(Color.yellow);
            int l = 35;
            g1.drawString("Sorry, an error has occured whilst loading RuneScape", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.drawString("To fix this try the following (in order):", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.setFont(new Font("Helvetica", 1, 12));
            g1.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, l);
            l += 30;
            g1.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, l);
            l += 30;
            g1.drawString("3: Try using a different game-world", 30, l);
            l += 30;
            g1.drawString("4: Try rebooting your computer", 30, l);
            l += 30;
            g1.drawString("5: Try selecting a different version of Java from the play-game menu", 30, l);
            setRefreshRate(1);
            return;
        }
        if(codebaseError)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - unable to load game!", 50, 50);
            g2.drawString("To play RuneScape make sure you play from", 50, 100);
            g2.drawString("http://www.runescape.com", 50, 150);
            setRefreshRate(1);
            return;
        }
        if(memoryError)
        {
            Graphics g3 = getGraphics();
            g3.setColor(Color.black);
            g3.fillRect(0, 0, 512, 356);
            g3.setFont(new Font("Helvetica", 1, 20));
            g3.setColor(Color.white);
            g3.drawString("Error - out of memory!", 50, 50);
            g3.drawString("Close ALL unnecessary programs", 50, 100);
            g3.drawString("and windows before loading the game", 50, 150);
            g3.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            setRefreshRate(1);
            return;
        }
        try
        {
            if(loggedIn == 0)
            {
                gameGraphics.loggedIn = false;
                drawLoginScreens();
            }
            if(loggedIn == 1)
            {
                gameGraphics.loggedIn = true;
                drawGame();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            cleanUp();
            memoryError = true;
        }
    }

    private final void cleanUp()
    {
        try
        {
            if(gameGraphics != null)
            {
                gameGraphics.cleanUp();
                gameGraphics.pixels = null;
                gameGraphics = null;
            }
            if(gameCamera != null)
            {
                gameCamera.cleanUp();
                gameCamera = null;
            }
            gameDataObjects = null;
            objectArray = null;
            wallObjectArray = null;
            playerBufferArray = null;
            playerArray = null;
            npcAttackingArray = null;
            npcArray = null;
            ourPlayer = null;
            if(engineHandle != null)
            {
                engineHandle.ghn = null;
                engineHandle.gim = null;
                engineHandle.gih = null;
                engineHandle.gia = null;
                engineHandle = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    private final void drawQuestionMenu()
    {
        if(mouseButtonClick != 0)
        {
            for(int l = 0; l < questionMenuCount; l++)
            {
                if(super.mouseX >= gameGraphics.textWidth(questionMenuAnswer[l], 1) || super.mouseY <= l * 12 || super.mouseY >= 12 + l * 12)
                    continue;
                super.streamClass.createPacket(154);
                super.streamClass.addByte(l);
                super.streamClass.formatPacket();
                break;
            }

            mouseButtonClick = 0;
            showQuestionMenu = false;
            return;
        }
        for(int i1 = 0; i1 < questionMenuCount; i1++)
        {
            int j1 = 65535;
            if(super.mouseX < gameGraphics.textWidth(questionMenuAnswer[i1], 1) && super.mouseY > i1 * 12 && super.mouseY < 12 + i1 * 12)
                j1 = 0xff0000;
            gameGraphics.drawString(questionMenuAnswer[i1], 6, 12 + i1 * 12, 1, j1);
        }

    }

    private final void drawTradeConfirmBox()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        gameGraphics.drawBox(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        gameGraphics.drawBoxAlpha(byte0, byte1 + 16, 468, 246, l, 160);
        gameGraphics.drawText("Please confirm your trade with @yel@" + DataOperations.hashToName(tradeConfirmOtherNameLong), byte0 + 234, byte1 + 12, 1, 0xffffff);
        gameGraphics.drawText("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < tradeConfigItemCount; i1++)
        {
            String s1 = Data.itemName[tradeConfirmItems[i1]];
            if(Data.itemStackable[tradeConfirmItems[i1]] == 0)
                s1 = s1 + " x " + formatItemCount(tradeConfigItemsCount[i1]);
            gameGraphics.drawText(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(tradeConfigItemCount == 0)
            gameGraphics.drawText("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        gameGraphics.drawText("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < tradeConfirmOtherItemCount; j1++)
        {
            String s2 = Data.itemName[tradeConfirmOtherItems[j1]];
            if(Data.itemStackable[tradeConfirmOtherItems[j1]] == 0)
                s2 = s2 + " x " + formatItemCount(tradeConfirmOtherItemsCount[j1]);
            gameGraphics.drawText(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(tradeConfirmOtherItemCount == 0)
            gameGraphics.drawText("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        gameGraphics.drawText("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        gameGraphics.drawText("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        gameGraphics.drawText("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!tradeConfirmAccepted)
        {
            gameGraphics.drawPicture((byte0 + 118) - 35, byte1 + 238, baseInventoryPic + 25);
            gameGraphics.drawPicture((byte0 + 352) - 35, byte1 + 238, baseInventoryPic + 26);
        } else
        {
            gameGraphics.drawText("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(mouseButtonClick == 1)
        {
            if(super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262)
            {
                showTradeConfirmBox = false;
                super.streamClass.createPacket(216);
                super.streamClass.formatPacket();
            }
            if(super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                tradeConfirmAccepted = true;
                super.streamClass.createPacket(53);
                super.streamClass.formatPacket();
            }
            if(super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                showTradeConfirmBox = false;
                super.streamClass.createPacket(216);
                super.streamClass.formatPacket();
            }
            mouseButtonClick = 0;
        }
    }

    private final void drawLoginScreens()
    {
        loginScreenShown = false;
        gameGraphics.interlace = false;
        gameGraphics.clearScreen();
        if(loginScreen == 0 || loginScreen == 1 || loginScreen == 2 || loginScreen == 3)
        {
            int l = (tick * 2) % 3072;
            if(l < 1024)
            {
                gameGraphics.drawPicture(0, 10, baseLoginScreenBackgroundPic);
                if(l > 768)
                    gameGraphics.ccd(0, 10, baseLoginScreenBackgroundPic + 1, l - 768);
            } else
            if(l < 2048)
            {
                gameGraphics.drawPicture(0, 10, baseLoginScreenBackgroundPic + 1);
                if(l > 1792)
                    gameGraphics.ccd(0, 10, baseInventoryPic + 10, l - 1792);
            } else
            {
                gameGraphics.drawPicture(0, 10, baseInventoryPic + 10);
                if(l > 2816)
                    gameGraphics.ccd(0, 10, baseLoginScreenBackgroundPic, l - 2816);
            }
        }
        if(loginScreen == 0)
            loginMenuFirst.drawMenu();
        if(loginScreen == 1)
            loginNewUser.drawMenu();
        if(loginScreen == 2)
            loginMenuLogin.drawMenu();
        gameGraphics.drawPicture(0, windowHeight, baseInventoryPic + 22);
        gameGraphics.drawImage(graphics, 0, 0);
    }

    final void drawItem(int x, int y, int width, int height, int itemID, int i2, int j2)
    {
        int picture = Data.itemInventoryPicture[itemID] + baseItemPicture;
        int mask = Data.itemPictureMask[itemID];
        gameGraphics.drawImage(x, y, width, height, picture, mask, 0, 0, false);
    }

    private final Mob makePlayer(int index, int x, int y, int sprite)
    {
        if(playerBufferArray[index] == null)
        {
            playerBufferArray[index] = new Mob();
            playerBufferArray[index].serverIndex = index;
            playerBufferArray[index].serverID = 0;
        }
        Mob existingPlayer = playerBufferArray[index];
        boolean flag = false;
        for(int l = 0; l < lastPlayerCount; l++)
        {
            if(lastPlayerArray[l].serverIndex != index)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            existingPlayer.nextSprite = sprite;
            int i1 = existingPlayer.waypointCurrent;
            if(x != existingPlayer.waypointsX[i1] || y != existingPlayer.waypointsY[i1])
            {
                existingPlayer.waypointCurrent = i1 = (i1 + 1) % 10;
                existingPlayer.waypointsX[i1] = x;
                existingPlayer.waypointsY[i1] = y;
            }
        } else
        {
            existingPlayer.serverIndex = index;
            existingPlayer.waypointsEndSprite = 0;
            existingPlayer.waypointCurrent = 0;
            existingPlayer.waypointsX[0] = existingPlayer.currentX = x;
            existingPlayer.waypointsY[0] = existingPlayer.currentY = y;
            existingPlayer.nextSprite = existingPlayer.currentSprite = sprite;
            existingPlayer.stepCount = 0;
        }
        playerArray[playerCount++] = existingPlayer;
        return existingPlayer;
    }

    private final void walkTo1Tile(int l, int i1, int j1, int k1, boolean flag)
    {
        walkTo(l, i1, j1, k1, j1, k1, false, flag);
    }

    private final void loadChatFilter()
    {
        byte abyte0[] = unpackData("config" + Version.VERSION_CONFIG + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            errorLoading = true;
            return;
        }
        Data.baa(abyte0, members);
        byte abyte1[] = unpackData("filter" + Version.VERSION_FILTER + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            errorLoading = true;
            return;
        } else
        {
            byte abyte2[] = DataOperations.loadData("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = DataOperations.loadData("badenc.txt", 0, abyte1);
            byte abyte4[] = DataOperations.loadData("hostenc.txt", 0, abyte1);
            byte abyte5[] = DataOperations.loadData("tldlist.txt", 0, abyte1);
            ChatFilter.addFilterData(new DataEncryption(abyte2), new DataEncryption(abyte3), new DataEncryption(abyte4), new DataEncryption(abyte5));
            return;
        }
    }

    protected final void handleMouseDown(int arg0, int arg1, int arg2)
    {
        mouseTrailX[mouseTrailIndex] = arg1;
        mouseTrailY[mouseTrailIndex] = arg2;
        mouseTrailIndex = mouseTrailIndex + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++)
        {
            int lastMouseTrailIndex = mouseTrailIndex - l & 0x1fff;
            if(mouseTrailX[lastMouseTrailIndex] == arg1 && mouseTrailY[lastMouseTrailIndex] == arg2)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int mouseNew = mouseTrailIndex - j1 & 0x1fff;
                    int mouseOld = lastMouseTrailIndex - j1 & 0x1fff;
                    if(mouseTrailX[mouseOld] != arg1 || mouseTrailY[mouseOld] != arg2)
                        flag = true;
                    if(mouseTrailX[mouseNew] != mouseTrailX[mouseOld] || mouseTrailY[mouseNew] != mouseTrailY[mouseOld])
                        break;
                    if(j1 == l - 1 && flag && combatTimeout == 0 && logoutTimer == 0)
                    {
                        sendLogout();
                        return;
                    }
                }

            }
        }

    }

    private final void drawFriendsMenu(boolean canClick)
    {
        int l = ((GameImage) (gameGraphics)).gameWidth - 199;
        int i1 = 36;
        gameGraphics.drawPicture(l - 49, 3, baseInventoryPic + 5);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = GameImage.rgbToInt(160, 160, 160);
        if(friendsIgnoreMenuSelected == 0)
            j1 = GameImage.rgbToInt(220, 220, 220);
        else
            k1 = GameImage.rgbToInt(220, 220, 220);
        gameGraphics.drawBoxAlpha(l, i1, c1 / 2, 24, j1, 128);
        gameGraphics.drawBoxAlpha(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        gameGraphics.drawBoxAlpha(l, i1 + 24, c1, c2 - 24, GameImage.rgbToInt(220, 220, 220), 128);
        gameGraphics.drawLineX(l, i1 + 24, c1, 0);
        gameGraphics.drawLineY(l + c1 / 2, i1, 24, 0);
        gameGraphics.drawLineX(l, (i1 + c2) - 16, c1, 0);
        gameGraphics.drawText("Friends", l + c1 / 4, i1 + 16, 4, 0);
        gameGraphics.drawText("Ignore", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        friendsMenu.clearList(friendsMenuHandle);
        if(friendsIgnoreMenuSelected == 0)
        {
            for(int l1 = 0; l1 < super.friendsCount; l1++)
            {
                String s1;
                if(super.friendsWorld[l1] == 99)
                    s1 = "@gre@";
                else
                if(super.friendsWorld[l1] > 0)
                    s1 = "@yel@";
                else
                    s1 = "@red@";
                friendsMenu.addListItem(friendsMenuHandle, l1, s1 + DataOperations.hashToName(super.friendsList[l1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(friendsIgnoreMenuSelected == 1)
        {
            for(int i2 = 0; i2 < super.ignoresCount; i2++)
                friendsMenu.addListItem(friendsMenuHandle, i2, "@yel@" + DataOperations.hashToName(super.ignoresList[i2]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        friendsMenu.drawMenu();
        if(friendsIgnoreMenuSelected == 0)
        {
            int j2 = friendsMenu.getEntryHighlighted(friendsMenuHandle);
            if(j2 >= 0 && super.mouseX < 489)
            {
                if(super.mouseX > 429)
                    gameGraphics.drawText("Click to remove " + DataOperations.hashToName(super.friendsList[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.friendsWorld[j2] == 99)
                    gameGraphics.drawText("Click to message " + DataOperations.hashToName(super.friendsList[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.friendsWorld[j2] > 0)
                    gameGraphics.drawText(DataOperations.hashToName(super.friendsList[j2]) + " is on world " + super.friendsWorld[j2], l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                    gameGraphics.drawText(DataOperations.hashToName(super.friendsList[j2]) + " is offline", l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                gameGraphics.drawText("Click a name to send a message", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int j3;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > (i1 + c2) - 16 && super.mouseY < i1 + c2)
                j3 = 0xffff00;
            else
                j3 = 0xffffff;
            gameGraphics.drawText("Click here to add a friend", l + c1 / 2, (i1 + c2) - 3, 1, j3);
        }
        if(friendsIgnoreMenuSelected == 1)
        {
            int k2 = friendsMenu.getEntryHighlighted(friendsMenuHandle);
            if(k2 >= 0 && super.mouseX < 489 && super.mouseX > 429)
            {
                if(super.mouseX > 429)
                    gameGraphics.drawText("Click to remove " + DataOperations.hashToName(super.ignoresList[k2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                gameGraphics.drawText("Blocking messages from:", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int k3;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > (i1 + c2) - 16 && super.mouseY < i1 + c2)
                k3 = 0xffff00;
            else
                k3 = 0xffffff;
            gameGraphics.drawText("Click here to add a name", l + c1 / 2, (i1 + c2) - 3, 1, k3);
        }
        if(!canClick)
            return;
        l = super.mouseX - (((GameImage) (gameGraphics)).gameWidth - 199);
        i1 = super.mouseY - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            friendsMenu.mouseClick(l + (((GameImage) (gameGraphics)).gameWidth - 199), i1 + 36, super.lastMouseButton, super.mouseButton);
            if(i1 <= 24 && mouseButtonClick == 1)
                if(l < 98 && friendsIgnoreMenuSelected == 1)
                {
                    friendsIgnoreMenuSelected = 0;
                    friendsMenu.switchList(friendsMenuHandle);
                } else
                if(l > 98 && friendsIgnoreMenuSelected == 0)
                {
                    friendsIgnoreMenuSelected = 1;
                    friendsMenu.switchList(friendsMenuHandle);
                }
            if(mouseButtonClick == 1 && friendsIgnoreMenuSelected == 0)
            {
                int l2 = friendsMenu.getEntryHighlighted(friendsMenuHandle);
                if(l2 >= 0 && super.mouseX < 489)
                    if(super.mouseX > 429)
                        removeFriend(super.friendsList[l2]);
                    else
                    if(super.friendsWorld[l2] != 0)
                    {
                        showFriendsBox = 2;
                        pmTarget = super.friendsList[l2];
                        super.pmText = "";
                        super.enteredPMText = "";
                    }
            }
            if(mouseButtonClick == 1 && friendsIgnoreMenuSelected == 1)
            {
                int i3 = friendsMenu.getEntryHighlighted(friendsMenuHandle);
                if(i3 >= 0 && super.mouseX < 489 && super.mouseX > 429)
                    removeIgnore(super.ignoresList[i3]);
            }
            if(i1 > 166 && mouseButtonClick == 1 && friendsIgnoreMenuSelected == 0)
            {
                showFriendsBox = 1;
                super.inputText = "";
                super.enteredInputText = "";
            }
            if(i1 > 166 && mouseButtonClick == 1 && friendsIgnoreMenuSelected == 1)
            {
                showFriendsBox = 3;
                super.inputText = "";
                super.enteredInputText = "";
            }
            mouseButtonClick = 0;
        }
    }

    private final void drawPrayerMagicMenu(boolean canClick)
    {
        int l = ((GameImage) (gameGraphics)).gameWidth - 199;
        int i1 = 36;
        gameGraphics.drawPicture(l - 49, 3, baseInventoryPic + 4);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = GameImage.rgbToInt(160, 160, 160);
        if(menuMagicPrayersSelected == 0)
            j1 = GameImage.rgbToInt(220, 220, 220);
        else
            k1 = GameImage.rgbToInt(220, 220, 220);
        gameGraphics.drawBoxAlpha(l, i1, c1 / 2, 24, j1, 128);
        gameGraphics.drawBoxAlpha(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        gameGraphics.drawBoxAlpha(l, i1 + 24, c1, 90, GameImage.rgbToInt(220, 220, 220), 128);
        gameGraphics.drawBoxAlpha(l, i1 + 24 + 90, c1, c2 - 90 - 24, GameImage.rgbToInt(160, 160, 160), 128);
        gameGraphics.drawLineX(l, i1 + 24, c1, 0);
        gameGraphics.drawLineY(l + c1 / 2, i1, 24, 0);
        gameGraphics.drawLineX(l, i1 + 113, c1, 0);
        gameGraphics.drawText("Magic", l + c1 / 4, i1 + 16, 4, 0);
        gameGraphics.drawText("Prayers", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(menuMagicPrayersSelected == 0)
        {
            spellMenu.clearList(spellMenuHandle);
            int l1 = 0;
            for(int l2 = 0; l2 < Data.spellCount; l2++)
            {
                String s1 = "@yel@";
                for(int k4 = 0; k4 < Data.spellDifferentRuneCount[l2]; k4++)
                {
                    int j5 = Data.spelRequiredRuneID[l2][k4];
                    if(hasRequiredRunes(j5, Data.spellRequiredRuneCount[l2][k4]))
                        continue;
                    s1 = "@whi@";
                    break;
                }

                int k5 = playerStatCurrent[6];
                if(Data.spellRequiredLevel[l2] > k5)
                    s1 = "@bla@";
                spellMenu.addListItem(spellMenuHandle, l1++, s1 + "Level " + Data.spellRequiredLevel[l2] + ": " + Data.spellName[l2]);
            }

            spellMenu.drawMenu();
            int l3 = spellMenu.getEntryHighlighted(spellMenuHandle);
            if(l3 != -1)
            {
                gameGraphics.drawString("Level " + Data.spellRequiredLevel[l3] + ": " + Data.spellName[l3], l + 2, i1 + 124, 1, 0xffff00);
                gameGraphics.drawString(Data.spellDescription[l3], l + 2, i1 + 136, 0, 0xffffff);
                for(int l4 = 0; l4 < Data.spellDifferentRuneCount[l3]; l4++)
                {
                    int l5 = Data.spelRequiredRuneID[l3][l4];
                    gameGraphics.drawPicture(l + 2 + l4 * 44, i1 + 150, baseItemPicture + Data.itemInventoryPicture[l5]);
                    int i6 = getInventoryItemTotalCount(l5);
                    int j6 = Data.spellRequiredRuneCount[l3][l4];
                    String s3 = "@red@";
                    if(hasRequiredRunes(l5, j6))
                        s3 = "@gre@";
                    gameGraphics.drawString(s3 + i6 + "/" + j6, l + 2 + l4 * 44, i1 + 150, 1, 0xffffff);
                }

            } else
            {
                gameGraphics.drawString("Point at a spell for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(menuMagicPrayersSelected == 1)
        {
            spellMenu.clearList(spellMenuHandle);
            int i2 = 0;
            for(int i3 = 0; i3 < Data.prayerCount; i3++)
            {
                String s2 = "@whi@";
                if(Data.prayerRequiredLevel[i3] > playerStatBase[5])
                    s2 = "@bla@";
                if(prayerOn[i3])
                    s2 = "@gre@";
                spellMenu.addListItem(spellMenuHandle, i2++, s2 + "Level " + Data.prayerRequiredLevel[i3] + ": " + Data.prayerName[i3]);
            }

            spellMenu.drawMenu();
            int i4 = spellMenu.getEntryHighlighted(spellMenuHandle);
            if(i4 != -1)
            {
                gameGraphics.drawText("Level " + Data.prayerRequiredLevel[i4] + ": " + Data.prayerName[i4], l + c1 / 2, i1 + 130, 1, 0xffff00);
                gameGraphics.drawText(Data.prayerDescription[i4], l + c1 / 2, i1 + 145, 0, 0xffffff);
                gameGraphics.drawText("Drain rate: " + Data.prayerDrainRate[i4], l + c1 / 2, i1 + 160, 1, 0);
            } else
            {
                gameGraphics.drawString("Point at a prayer for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(!canClick)
            return;
        l = super.mouseX - (((GameImage) (gameGraphics)).gameWidth - 199);
        i1 = super.mouseY - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            spellMenu.mouseClick(l + (((GameImage) (gameGraphics)).gameWidth - 199), i1 + 36, super.lastMouseButton, super.mouseButton);
            if(i1 <= 24 && mouseButtonClick == 1)
                if(l < 98 && menuMagicPrayersSelected == 1)
                {
                    menuMagicPrayersSelected = 0;
                    spellMenu.switchList(spellMenuHandle);
                } else
                if(l > 98 && menuMagicPrayersSelected == 0)
                {
                    menuMagicPrayersSelected = 1;
                    spellMenu.switchList(spellMenuHandle);
                }
            if(mouseButtonClick == 1 && menuMagicPrayersSelected == 0)
            {
                int j2 = spellMenu.getEntryHighlighted(spellMenuHandle);
                if(j2 != -1)
                {
                    int j3 = playerStatCurrent[6];
                    if(Data.spellRequiredLevel[j2] > j3)
                    {
                        displayMessage("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int j4;
                        for(j4 = 0; j4 < Data.spellDifferentRuneCount[j2]; j4++)
                        {
                            int i5 = Data.spelRequiredRuneID[j2][j4];
                            if(hasRequiredRunes(i5, Data.spellRequiredRuneCount[j2][j4]))
                                continue;
                            displayMessage("You don't have all the reagents you need for this spell", 3);
                            j4 = -1;
                            break;
                        }

                        if(j4 == Data.spellDifferentRuneCount[j2])
                        {
                            selectedSpell = j2;
                            selectedItem = -1;
                        }
                    }
                }
            }
            if(mouseButtonClick == 1 && menuMagicPrayersSelected == 1)
            {
                int k2 = spellMenu.getEntryHighlighted(spellMenuHandle);
                if(k2 != -1)
                {
                    int k3 = playerStatBase[5];
                    if(Data.prayerRequiredLevel[k2] > k3)
                        displayMessage("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(playerStatCurrent[5] == 0)
                        displayMessage("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(prayerOn[k2])
                    {
                        super.streamClass.createPacket(248);
                        super.streamClass.addByte(k2);
                        super.streamClass.formatPacket();
                        prayerOn[k2] = false;
                        playSound("prayeroff");
                    } else
                    {
                        super.streamClass.createPacket(56);
                        super.streamClass.addByte(k2);
                        super.streamClass.formatPacket();
                        prayerOn[k2] = true;
                        playSound("prayeron");
                    }
                }
            }
            mouseButtonClick = 0;
        }
    }

    protected final byte[] unpackData(String arg0, String arg1, int arg2)
    {
        byte abyte0[] = link.getFile(arg0);
        if(abyte0 != null)
        {
            int l = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int i1 = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int j1 = 0; j1 < abyte0.length - 6; j1++)
                abyte1[j1] = abyte0[j1 + 6];

            drawLoadingBarText(arg2, "Unpacking " + arg1);
            if(i1 != l)
            {
                byte abyte2[] = new byte[l];
                DataFileDecrypter.unpackData(abyte2, l, abyte1, i1, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.unpackData(arg0, arg1, arg2);
        }
    }

    private final void drawChatMessageTabs()
    {
        gameGraphics.drawPicture(0, windowHeight - 4, baseInventoryPic + 23);
        int l = GameImage.rgbToInt(200, 200, 255);
        if(dea == 0)
            l = GameImage.rgbToInt(255, 200, 50);
        if(chatTabAllMsgFlash % 30 > 15)
            l = GameImage.rgbToInt(255, 50, 50);
        gameGraphics.drawText("All messages", 54, windowHeight + 6, 0, l);
        l = GameImage.rgbToInt(200, 200, 255);
        if(dea == 1)
            l = GameImage.rgbToInt(255, 200, 50);
        if(chatTabHistoryFlash % 30 > 15)
            l = GameImage.rgbToInt(255, 50, 50);
        gameGraphics.drawText("Chat history", 155, windowHeight + 6, 0, l);
        l = GameImage.rgbToInt(200, 200, 255);
        if(dea == 2)
            l = GameImage.rgbToInt(255, 200, 50);
        if(chatTabQuestFlash % 30 > 15)
            l = GameImage.rgbToInt(255, 50, 50);
        gameGraphics.drawText("Quest history", 255, windowHeight + 6, 0, l);
        l = GameImage.rgbToInt(200, 200, 255);
        if(dea == 3)
            l = GameImage.rgbToInt(255, 200, 50);
        if(chatTabPrivateFlash % 30 > 15)
            l = GameImage.rgbToInt(255, 50, 50);
        gameGraphics.drawText("Private history", 355, windowHeight + 6, 0, l);
        gameGraphics.drawText("Report abuse", 457, windowHeight + 6, 0, 0xffffff);
    }

    public final URL getDocumentBase()
    {
        if(link.gameApplet != null)
            return link.gameApplet.getDocumentBase();
        else
            return super.getDocumentBase();
    }

    private final void checkGameInputs()
    {
        if(systemUpdate > 1)
            systemUpdate--;
        sendPingPacket();
        if(logoutTimer > 0)
            logoutTimer--;
        if(super.lastActionTimeout > 4500 && combatTimeout == 0 && logoutTimer == 0)
        {
            super.lastActionTimeout -= 500;
            sendLogout();
            return;
        }
        if(ourPlayer.currentSprite == 8 || ourPlayer.currentSprite == 9)
            combatTimeout = 500;
        if(combatTimeout > 0)
            combatTimeout--;
        if(showAppearanceWindow)
        {
            updateAppearanceWindow();
            return;
        }
        for(int l = 0; l < playerCount; l++)
        {
            Mob player = playerArray[l];
            int j1 = (player.waypointCurrent + 1) % 10;
            if(player.waypointsEndSprite != j1)
            {
                int l1 = -1;
                int k3 = player.waypointsEndSprite;
                int i5;
                if(k3 < j1)
                    i5 = j1 - k3;
                else
                    i5 = (10 + j1) - k3;
                int i6 = 4;
                if(i5 > 2)
                    i6 = (i5 - 1) * 4;
                if(player.waypointsX[k3] - player.currentX > magicLoc * 3 || player.waypointsY[k3] - player.currentY > magicLoc * 3 || player.waypointsX[k3] - player.currentX < -magicLoc * 3 || player.waypointsY[k3] - player.currentY < -magicLoc * 3 || i5 > 8)
                {
                    player.currentX = player.waypointsX[k3];
                    player.currentY = player.waypointsY[k3];
                } else
                {
                    if(player.currentX < player.waypointsX[k3])
                    {
                        player.currentX += i6;
                        player.stepCount++;
                        l1 = 2;
                    } else
                    if(player.currentX > player.waypointsX[k3])
                    {
                        player.currentX -= i6;
                        player.stepCount++;
                        l1 = 6;
                    }
                    if(player.currentX - player.waypointsX[k3] < i6 && player.currentX - player.waypointsX[k3] > -i6)
                        player.currentX = player.waypointsX[k3];
                    if(player.currentY < player.waypointsY[k3])
                    {
                        player.currentY += i6;
                        player.stepCount++;
                        if(l1 == -1)
                            l1 = 4;
                        else
                        if(l1 == 2)
                            l1 = 3;
                        else
                            l1 = 5;
                    } else
                    if(player.currentY > player.waypointsY[k3])
                    {
                        player.currentY -= i6;
                        player.stepCount++;
                        if(l1 == -1)
                            l1 = 0;
                        else
                        if(l1 == 2)
                            l1 = 1;
                        else
                            l1 = 7;
                    }
                    if(player.currentY - player.waypointsY[k3] < i6 && player.currentY - player.waypointsY[k3] > -i6)
                        player.currentY = player.waypointsY[k3];
                }
                if(l1 != -1)
                    player.currentSprite = l1;
                if(player.currentX == player.waypointsX[k3] && player.currentY == player.waypointsY[k3])
                    player.waypointsEndSprite = (k3 + 1) % 10;
            } else
            {
                player.currentSprite = player.nextSprite;
            }
            if(player.lastMessageTimeout > 0)
                player.lastMessageTimeout--;
            if(player.itemAboveHeadTimeout > 0)
                player.itemAboveHeadTimeout--;
            if(player.combatTimer > 0)
                player.combatTimer--;
            if(playerAliveTimeout > 0)
            {
                playerAliveTimeout--;
                if(playerAliveTimeout == 0)
                    displayMessage("You have been granted another life. Be more careful this time!", 3);
                if(playerAliveTimeout == 0)
                    displayMessage("You retain your skills. Your objects land where you died", 3);
            }
        }

        for(int i1 = 0; i1 < npcCount; i1++)
        {
            Mob f2 = npcArray[i1];
            int i2 = (f2.waypointCurrent + 1) % 10;
            if(f2.waypointsEndSprite != i2)
            {
                int l3 = -1;
                int j5 = f2.waypointsEndSprite;
                int j6;
                if(j5 < i2)
                    j6 = i2 - j5;
                else
                    j6 = (10 + i2) - j5;
                int k6 = 4;
                if(j6 > 2)
                    k6 = (j6 - 1) * 4;
                if(f2.waypointsX[j5] - f2.currentX > magicLoc * 3 || f2.waypointsY[j5] - f2.currentY > magicLoc * 3 || f2.waypointsX[j5] - f2.currentX < -magicLoc * 3 || f2.waypointsY[j5] - f2.currentY < -magicLoc * 3 || j6 > 8)
                {
                    f2.currentX = f2.waypointsX[j5];
                    f2.currentY = f2.waypointsY[j5];
                } else
                {
                    if(f2.currentX < f2.waypointsX[j5])
                    {
                        f2.currentX += k6;
                        f2.stepCount++;
                        l3 = 2;
                    } else
                    if(f2.currentX > f2.waypointsX[j5])
                    {
                        f2.currentX -= k6;
                        f2.stepCount++;
                        l3 = 6;
                    }
                    if(f2.currentX - f2.waypointsX[j5] < k6 && f2.currentX - f2.waypointsX[j5] > -k6)
                        f2.currentX = f2.waypointsX[j5];
                    if(f2.currentY < f2.waypointsY[j5])
                    {
                        f2.currentY += k6;
                        f2.stepCount++;
                        if(l3 == -1)
                            l3 = 4;
                        else
                        if(l3 == 2)
                            l3 = 3;
                        else
                            l3 = 5;
                    } else
                    if(f2.currentY > f2.waypointsY[j5])
                    {
                        f2.currentY -= k6;
                        f2.stepCount++;
                        if(l3 == -1)
                            l3 = 0;
                        else
                        if(l3 == 2)
                            l3 = 1;
                        else
                            l3 = 7;
                    }
                    if(f2.currentY - f2.waypointsY[j5] < k6 && f2.currentY - f2.waypointsY[j5] > -k6)
                        f2.currentY = f2.waypointsY[j5];
                }
                if(l3 != -1)
                    f2.currentSprite = l3;
                if(f2.currentX == f2.waypointsX[j5] && f2.currentY == f2.waypointsY[j5])
                    f2.waypointsEndSprite = (j5 + 1) % 10;
            } else
            {
                f2.currentSprite = f2.nextSprite;
                if(f2.gmj == 43)
                    f2.stepCount++;
            }
            if(f2.lastMessageTimeout > 0)
                f2.lastMessageTimeout--;
            if(f2.itemAboveHeadTimeout > 0)
                f2.itemAboveHeadTimeout--;
            if(f2.combatTimer > 0)
                f2.combatTimer--;
        }

        if(drawMenuTab != 2)
        {
            if(GameImage.bnn > 0)
                sleepWordDelayTimer++;
            if(GameImage.caa > 0)
                sleepWordDelayTimer = 0;
            GameImage.bnn = 0;
            GameImage.caa = 0;
        }
        for(int k1 = 0; k1 < playerCount; k1++)
        {
            Mob f3 = playerArray[k1];
            if(f3.projectileDistance > 0)
                f3.projectileDistance--;
        }

        if(cameraAutoAngleDebug)
        {
            if(cameraAutoRotatePlayerX - ourPlayer.currentX < -500 || cameraAutoRotatePlayerX - ourPlayer.currentX > 500 || cameraAutoRotatePlayerY - ourPlayer.currentY < -500 || cameraAutoRotatePlayerY - ourPlayer.currentY > 500)
            {
                cameraAutoRotatePlayerX = ourPlayer.currentX;
                cameraAutoRotatePlayerY = ourPlayer.currentY;
            }
        } else
        {
            if(cameraAutoRotatePlayerX - ourPlayer.currentX < -500 || cameraAutoRotatePlayerX - ourPlayer.currentX > 500 || cameraAutoRotatePlayerY - ourPlayer.currentY < -500 || cameraAutoRotatePlayerY - ourPlayer.currentY > 500)
            {
                cameraAutoRotatePlayerX = ourPlayer.currentX;
                cameraAutoRotatePlayerY = ourPlayer.currentY;
            }
            if(cameraAutoRotatePlayerX != ourPlayer.currentX)
                cameraAutoRotatePlayerX += (ourPlayer.currentX - cameraAutoRotatePlayerX) / (16 + (cameraDistance - 500) / 15);
            if(cameraAutoRotatePlayerY != ourPlayer.currentY)
                cameraAutoRotatePlayerY += (ourPlayer.currentY - cameraAutoRotatePlayerY) / (16 + (cameraDistance - 500) / 15);
            if(configCmeraAutoAngle)
            {
                int j2 = cameraAutoAngle * 32;
                int i4 = j2 - cameraRotation;
                byte byte0 = 1;
                if(i4 != 0)
                {
                    cameraAutoRotationAmoun++;
                    if(i4 > 128)
                    {
                        byte0 = -1;
                        i4 = 256 - i4;
                    } else
                    if(i4 > 0)
                        byte0 = 1;
                    else
                    if(i4 < -128)
                    {
                        byte0 = 1;
                        i4 = 256 + i4;
                    } else
                    if(i4 < 0)
                    {
                        byte0 = -1;
                        i4 = -i4;
                    }
                    cameraRotation += ((cameraAutoRotationAmoun * i4 + 255) / 256) * byte0;
                    cameraRotation &= 0xff;
                } else
                {
                    cameraAutoRotationAmoun = 0;
                }
            }
        }
        if(sleepWordDelayTimer > 20)
        {
            sleepWordDelay = false;
            sleepWordDelayTimer = 0;
        }
        if(isSleeping)
        {
            if(super.enteredInputText.length() > 0)
                if(super.enteredInputText.equalsIgnoreCase("::lostcon") && !appletMode)
                    super.streamClass.closeStream();
                else
                if(super.enteredInputText.equalsIgnoreCase("::closecon") && !appletMode)
                {
                    requestLogout();
                } else
                {
                    super.streamClass.createPacket(200);
                    super.streamClass.addString(super.enteredInputText);
                    if(!sleepWordDelay)
                    {
                        super.streamClass.addByte(0);
                        sleepWordDelay = true;
                    }
                    super.streamClass.formatPacket();
                    super.inputText = "";
                    super.enteredInputText = "";
                    del = "Please wait...";
                }
            if(super.lastMouseButton == 1 && super.mouseY > 275 && super.mouseY < 310 && super.mouseX > 56 && super.mouseX < 456)
            {
                super.streamClass.createPacket(200);
                super.streamClass.addString("-null-");
                if(!sleepWordDelay)
                {
                    super.streamClass.addByte(0);
                    sleepWordDelay = true;
                }
                super.streamClass.formatPacket();
                super.inputText = "";
                super.enteredInputText = "";
                del = "Please wait...";
            }
            super.lastMouseButton = 0;
            return;
        }
        if(super.mouseY > windowHeight - 4)
        {
            if(super.mouseX > 15 && super.mouseX < 96 && super.lastMouseButton == 1)
                dea = 0;
            if(super.mouseX > 110 && super.mouseX < 194 && super.lastMouseButton == 1)
            {
                dea = 1;
                chatInputMenu.gbc[messagesHandleType2] = 0xf423f;
            }
            if(super.mouseX > 215 && super.mouseX < 295 && super.lastMouseButton == 1)
            {
                dea = 2;
                chatInputMenu.gbc[messagesHandleType5] = 0xf423f;
            }
            if(super.mouseX > 315 && super.mouseX < 395 && super.lastMouseButton == 1)
            {
                dea = 3;
                chatInputMenu.gbc[messagesHandleType6] = 0xf423f;
            }
            if(super.mouseX > 417 && super.mouseX < 497 && super.lastMouseButton == 1)
            {
                showAbuseBox = 1;
                reportAbuseOptionSelected = 0;
                super.inputText = "";
                super.enteredInputText = "";
            }
            super.lastMouseButton = 0;
            super.mouseButton = 0;
        }
        chatInputMenu.mouseClick(super.mouseX, super.mouseY, super.lastMouseButton, super.mouseButton);
        if(dea > 0 && super.mouseX >= 494 && super.mouseY >= windowHeight - 66)
            super.lastMouseButton = 0;
        if(chatInputMenu.isClicked(chatInputBox))
        {
            String s1 = chatInputMenu.getText(chatInputBox);
            chatInputMenu.updateText(chatInputBox, "");
            if(s1.startsWith("::"))
            {
                if(s1.equalsIgnoreCase("::closecon") && !appletMode)
                    super.streamClass.closeStream();
                else
                if(s1.equalsIgnoreCase("::logout") && !appletMode)
                    requestLogout();
                else
                if(s1.equalsIgnoreCase("::lostcon") && !appletMode)
                    lostConnection();
                else
                    sendCommand(s1.substring(2));
            } else
            {
                int j4 = v.stringToBytes(s1);
                sendChatMessage(v.ceg, j4);
                s1 = v.bytesToString(v.ceg, 0, j4);
                s1 = ChatFilter.fgd(s1);
                ourPlayer.lastMessageTimeout = 150;
                ourPlayer.gne = s1;
                displayMessage(ourPlayer.gme + ": " + s1, 2);
            }
        }
        if(dea == 0)
        {
            for(int k2 = 0; k2 < 5; k2++)
                if(eib[k2] > 0)
                    eib[k2]--;

        }
        if(playerAliveTimeout != 0)
            super.lastMouseButton = 0;
        if(showTradeBox || eld)
        {
            if(super.mouseButton != 0)
                mouseButtonHeldTime++;
            else
                mouseButtonHeldTime = 0;
            if(mouseButtonHeldTime > 600)
                mouseClickedHeldInTradeDuelBox += 5000;
            else
            if(mouseButtonHeldTime > 450)
                mouseClickedHeldInTradeDuelBox += 500;
            else
            if(mouseButtonHeldTime > 300)
                mouseClickedHeldInTradeDuelBox += 50;
            else
            if(mouseButtonHeldTime > 150)
                mouseClickedHeldInTradeDuelBox += 5;
            else
            if(mouseButtonHeldTime > 50)
                mouseClickedHeldInTradeDuelBox++;
            else
            if(mouseButtonHeldTime > 20 && (mouseButtonHeldTime & 5) == 0)
                mouseClickedHeldInTradeDuelBox++;
        } else
        {
            mouseButtonHeldTime = 0;
            mouseClickedHeldInTradeDuelBox = 0;
        }
        if(super.lastMouseButton == 1)
            mouseButtonClick = 1;
        else
        if(super.lastMouseButton == 2)
            mouseButtonClick = 2;
        gameCamera.bhg(super.mouseX, super.mouseY);
        super.lastMouseButton = 0;
        if(configCmeraAutoAngle)
        {
            if(cameraAutoRotationAmoun == 0 || cameraAutoAngleDebug)
            {
                if(super.keyLeftDown)
                {
                    cameraAutoAngle = cameraAutoAngle + 1 & 7;
                    super.keyLeftDown = false;
                    if(!ebg)
                    {
                        if((cameraAutoAngle & 1) == 0)
                            cameraAutoAngle = cameraAutoAngle + 1 & 7;
                        for(int l2 = 0; l2 < 8; l2++)
                        {
                            if(validCameraAngle(cameraAutoAngle))
                                break;
                            cameraAutoAngle = cameraAutoAngle + 1 & 7;
                        }

                    }
                }
                if(super.keyRightDown)
                {
                    cameraAutoAngle = cameraAutoAngle + 7 & 7;
                    super.keyRightDown = false;
                    if(!ebg)
                    {
                        if((cameraAutoAngle & 1) == 0)
                            cameraAutoAngle = cameraAutoAngle + 7 & 7;
                        for(int i3 = 0; i3 < 8; i3++)
                        {
                            if(validCameraAngle(cameraAutoAngle))
                                break;
                            cameraAutoAngle = cameraAutoAngle + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.keyLeftDown)
            cameraRotation = cameraRotation + 2 & 0xff;
        else
        if(super.keyRightDown)
            cameraRotation = cameraRotation - 2 & 0xff;
        if(ebg && cameraDistance > 550)
            cameraDistance -= 4;
        else
        if(!ebg && cameraDistance < 750)
            cameraDistance += 4;
        if(actionPictureType > 0)
            actionPictureType--;
        else
        if(actionPictureType < 0)
            actionPictureType++;
        gameCamera.bji(17);
        edd++;
        if(edd > 5)
        {
            edd = 0;
            dfa = (dfa + 1) % 3;
            dfb = (dfb + 1) % 4;
            dfc = (dfc + 1) % 5;
        }
        for(int j3 = 0; j3 < objectCount; j3++)
        {
            int k4 = objectX[j3];
            int k5 = objectY[j3];
            if(k4 >= 0 && k5 >= 0 && k4 < 96 && k5 < 96 && objectID[j3] == 74)
                objectArray[j3].cmi(1, 0, 0);
        }

        for(int l4 = 0; l4 < eig; l4++)
        {
            teleBubbleTime[l4]++;
            if(teleBubbleTime[l4] > 50)
            {
                eig--;
                for(int l5 = l4; l5 < eig; l5++)
                {
                    ell[l5] = ell[l5 + 1];
                    elh[l5] = elh[l5 + 1];
                    teleBubbleTime[l5] = teleBubbleTime[l5 + 1];
                    teleBubbleType[l5] = teleBubbleType[l5 + 1];
                }

            }
        }

    }

    private final void createAppearanceWindow()
    {
        appearanceMenu = new Menu(gameGraphics, 100);
        appearanceMenu.drawText(256, 10, "Please design Your Character", 4, true);
        int l = 140;
        int i1 = 34;
        l += 116;
        i1 -= 10;
        appearanceMenu.drawText(l - 55, i1 + 110, "Front", 3, true);
        appearanceMenu.drawText(l, i1 + 110, "Side", 3, true);
        appearanceMenu.drawText(l + 55, i1 + 110, "Back", 3, true);
        byte byte0 = 54;
        i1 += 145;
        appearanceMenu.gff(l - byte0, i1, 53, 41);
        appearanceMenu.drawText(l - byte0, i1 - 8, "Head", 1, true);
        appearanceMenu.drawText(l - byte0, i1 + 8, "Type", 1, true);
        appearanceMenu.gfg(l - byte0 - 40, i1, Menu.gdi + 7);
        appearanceHeadLeftArrow = appearanceMenu.createButton(l - byte0 - 40, i1, 20, 20);
        appearanceMenu.gfg((l - byte0) + 40, i1, Menu.gdi + 6);
        appearanceHeadRightArrow = appearanceMenu.createButton((l - byte0) + 40, i1, 20, 20);
        appearanceMenu.gff(l + byte0, i1, 53, 41);
        appearanceMenu.drawText(l + byte0, i1 - 8, "Hair", 1, true);
        appearanceMenu.drawText(l + byte0, i1 + 8, "Color", 1, true);
        appearanceMenu.gfg((l + byte0) - 40, i1, Menu.gdi + 7);
        appearanceHairLeftArrow = appearanceMenu.createButton((l + byte0) - 40, i1, 20, 20);
        appearanceMenu.gfg(l + byte0 + 40, i1, Menu.gdi + 6);
        appearanceHairRightArrow = appearanceMenu.createButton(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        appearanceMenu.gff(l - byte0, i1, 53, 41);
        appearanceMenu.drawText(l - byte0, i1, "Gender", 1, true);
        appearanceMenu.gfg(l - byte0 - 40, i1, Menu.gdi + 7);
        appearanceGenderLeftArrow = appearanceMenu.createButton(l - byte0 - 40, i1, 20, 20);
        appearanceMenu.gfg((l - byte0) + 40, i1, Menu.gdi + 6);
        appearanceGenderRightArrow = appearanceMenu.createButton((l - byte0) + 40, i1, 20, 20);
        appearanceMenu.gff(l + byte0, i1, 53, 41);
        appearanceMenu.drawText(l + byte0, i1 - 8, "Top", 1, true);
        appearanceMenu.drawText(l + byte0, i1 + 8, "Color", 1, true);
        appearanceMenu.gfg((l + byte0) - 40, i1, Menu.gdi + 7);
        appearanceTopLeftArrow = appearanceMenu.createButton((l + byte0) - 40, i1, 20, 20);
        appearanceMenu.gfg(l + byte0 + 40, i1, Menu.gdi + 6);
        appearanceTopRightArrow = appearanceMenu.createButton(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        appearanceMenu.gff(l - byte0, i1, 53, 41);
        appearanceMenu.drawText(l - byte0, i1 - 8, "Skin", 1, true);
        appearanceMenu.drawText(l - byte0, i1 + 8, "Color", 1, true);
        appearanceMenu.gfg(l - byte0 - 40, i1, Menu.gdi + 7);
        appearanceSkinLeftArrow = appearanceMenu.createButton(l - byte0 - 40, i1, 20, 20);
        appearanceMenu.gfg((l - byte0) + 40, i1, Menu.gdi + 6);
        appearanceSkingRightArrow = appearanceMenu.createButton((l - byte0) + 40, i1, 20, 20);
        appearanceMenu.gff(l + byte0, i1, 53, 41);
        appearanceMenu.drawText(l + byte0, i1 - 8, "Bottom", 1, true);
        appearanceMenu.drawText(l + byte0, i1 + 8, "Color", 1, true);
        appearanceMenu.gfg((l + byte0) - 40, i1, Menu.gdi + 7);
        appearanceBottomLeftArrow = appearanceMenu.createButton((l + byte0) - 40, i1, 20, 20);
        appearanceMenu.gfg(l + byte0 + 40, i1, Menu.gdi + 6);
        appearanceBottomRightArrow = appearanceMenu.createButton(l + byte0 + 40, i1, 20, 20);
        i1 += 82;
        i1 -= 35;
        appearanceMenu.drawButton(l, i1, 200, 30);
        appearanceMenu.drawText(l, i1, "Accept", 4, false);
        appearanceAcceptButton = appearanceMenu.createButton(l, i1, 200, 30);
    }

    protected final void handleKeyDown(int l)
    {
        if(loggedIn == 0)
        {
            if(loginScreen == 0)
                loginMenuFirst.gec(l);
            if(loginScreen == 1)
                loginNewUser.gec(l);
            if(loginScreen == 2)
                loginMenuLogin.gec(l);
        }
        if(loggedIn == 1)
        {
            if(showAppearanceWindow)
            {
                appearanceMenu.gec(l);
                return;
            }
            if(showFriendsBox == 0 && showAbuseBox == 0 && !isSleeping)
                chatInputMenu.gec(l);
        }
    }

    private final void fcg()
    {
        int l = 2203 - (sectionY + eaj + areaY);
        if(sectionX + eai + areaX >= 2640)
            l = -50;
        int i1 = -1;
        for(int j1 = 0; j1 < objectCount; j1++)
            dij[j1] = false;

        for(int k1 = 0; k1 < wallObjectCount; k1++)
            eah[k1] = false;

        int l1 = gameCamera.bhh();
        i ai[] = gameCamera.bhj();
        int ai1[] = gameCamera.bhi();
        for(int i2 = 0; i2 < l1; i2++)
        {
            if(menuOptionsCount > 200)
                break;
            int j2 = ai1[i2];
            i l2 = ai[i2];
            if(l2.chl[j2] <= 65535 || l2.chl[j2] >= 0x30d40 && l2.chl[j2] <= 0x493e0)
                if(l2 == gameCamera.beh)
                {
                    int i3 = l2.chl[j2] % 10000;
                    int l3 = l2.chl[j2] / 10000;
                    if(l3 == 1)
                    {
                        String s1 = "";
                        int k4 = 0;
                        if(ourPlayer.gnm > 0 && playerArray[i3].gnm > 0)
                            k4 = ourPlayer.gnm - playerArray[i3].gnm;
                        if(k4 < 0)
                            s1 = "@or1@";
                        if(k4 < -3)
                            s1 = "@or2@";
                        if(k4 < -6)
                            s1 = "@or3@";
                        if(k4 < -9)
                            s1 = "@red@";
                        if(k4 > 0)
                            s1 = "@gr1@";
                        if(k4 > 3)
                            s1 = "@gr2@";
                        if(k4 > 6)
                            s1 = "@gr3@";
                        if(k4 > 9)
                            s1 = "@gre@";
                        s1 = " " + s1 + "(level-" + playerArray[i3].gnm + ")";
                        if(selectedSpell >= 0)
                        {
                            if(Data.amd[selectedSpell] == 1 || Data.amd[selectedSpell] == 2)
                            {
                                menuText1[menuOptionsCount] = "Cast " + Data.spellName[selectedSpell] + " on";
                                menuText2[menuOptionsCount] = "@whi@" + playerArray[i3].gme + s1;
                                menuActionID[menuOptionsCount] = 800;
                                menuActionX[menuOptionsCount] = playerArray[i3].currentX;
                                menuActionY[menuOptionsCount] = playerArray[i3].currentY;
                                menuActionType[menuOptionsCount] = playerArray[i3].serverIndex;
                                menuActionVar1[menuOptionsCount] = selectedSpell;
                                menuOptionsCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText1[menuOptionsCount] = "Use " + selectedItemName + " with";
                            menuText2[menuOptionsCount] = "@whi@" + playerArray[i3].gme + s1;
                            menuActionID[menuOptionsCount] = 810;
                            menuActionX[menuOptionsCount] = playerArray[i3].currentX;
                            menuActionY[menuOptionsCount] = playerArray[i3].currentY;
                            menuActionType[menuOptionsCount] = playerArray[i3].serverIndex;
                            menuActionVar1[menuOptionsCount] = selectedItem;
                            menuOptionsCount++;
                        } else
                        {
                            if(l > 0 && (playerArray[i3].currentY - 64) / magicLoc + eaj + areaY < 2203)
                            {
                                menuText1[menuOptionsCount] = "Attack";
                                menuText2[menuOptionsCount] = "@whi@" + playerArray[i3].gme + s1;
                                if(k4 >= 0 && k4 < 5)
                                    menuActionID[menuOptionsCount] = 805;
                                else
                                    menuActionID[menuOptionsCount] = 2805;
                                menuActionX[menuOptionsCount] = playerArray[i3].currentX;
                                menuActionY[menuOptionsCount] = playerArray[i3].currentY;
                                menuActionType[menuOptionsCount] = playerArray[i3].serverIndex;
                                menuOptionsCount++;
                            } else
                            if(members)
                            {
                                menuText1[menuOptionsCount] = "Duel with";
                                menuText2[menuOptionsCount] = "@whi@" + playerArray[i3].gme + s1;
                                menuActionX[menuOptionsCount] = playerArray[i3].currentX;
                                menuActionY[menuOptionsCount] = playerArray[i3].currentY;
                                menuActionID[menuOptionsCount] = 2806;
                                menuActionType[menuOptionsCount] = playerArray[i3].serverIndex;
                                menuOptionsCount++;
                            }
                            menuText1[menuOptionsCount] = "Trade with";
                            menuText2[menuOptionsCount] = "@whi@" + playerArray[i3].gme + s1;
                            menuActionID[menuOptionsCount] = 2810;
                            menuActionType[menuOptionsCount] = playerArray[i3].serverIndex;
                            menuOptionsCount++;
                            menuText1[menuOptionsCount] = "Follow";
                            menuText2[menuOptionsCount] = "@whi@" + playerArray[i3].gme + s1;
                            menuActionID[menuOptionsCount] = 2820;
                            menuActionType[menuOptionsCount] = playerArray[i3].serverIndex;
                            menuOptionsCount++;
                        }
                    } else
                    if(l3 == 2)
                    {
                        if(selectedSpell >= 0)
                        {
                            if(Data.amd[selectedSpell] == 3)
                            {
                                menuText1[menuOptionsCount] = "Cast " + Data.spellName[selectedSpell] + " on";
                                menuText2[menuOptionsCount] = "@lre@" + Data.itemName[dmn[i3]];
                                menuActionID[menuOptionsCount] = 200;
                                menuActionX[menuOptionsCount] = dml[i3];
                                menuActionY[menuOptionsCount] = dmm[i3];
                                menuActionType[menuOptionsCount] = dmn[i3];
                                menuActionVar1[menuOptionsCount] = selectedSpell;
                                menuOptionsCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText1[menuOptionsCount] = "Use " + selectedItemName + " with";
                            menuText2[menuOptionsCount] = "@lre@" + Data.itemName[dmn[i3]];
                            menuActionID[menuOptionsCount] = 210;
                            menuActionX[menuOptionsCount] = dml[i3];
                            menuActionY[menuOptionsCount] = dmm[i3];
                            menuActionType[menuOptionsCount] = dmn[i3];
                            menuActionVar1[menuOptionsCount] = selectedItem;
                            menuOptionsCount++;
                        } else
                        {
                            menuText1[menuOptionsCount] = "Take";
                            menuText2[menuOptionsCount] = "@lre@" + Data.itemName[dmn[i3]];
                            menuActionID[menuOptionsCount] = 220;
                            menuActionX[menuOptionsCount] = dml[i3];
                            menuActionY[menuOptionsCount] = dmm[i3];
                            menuActionType[menuOptionsCount] = dmn[i3];
                            menuOptionsCount++;
                            menuText1[menuOptionsCount] = "Examine";
                            menuText2[menuOptionsCount] = "@lre@" + Data.itemName[dmn[i3]];
                            menuActionID[menuOptionsCount] = 3200;
                            menuActionType[menuOptionsCount] = dmn[i3];
                            menuOptionsCount++;
                        }
                    } else
                    if(l3 == 3)
                    {
                        String s2 = "";
                        int l4 = -1;
                        int i5 = npcArray[i3].gmj;
                        if(Data.alf[i5] > 0)
                        {
                            int j5 = (Data.alb[i5] + Data.ale[i5] + Data.alc[i5] + Data.ald[i5]) / 4;
                            int k5 = (playerStatBase[0] + playerStatBase[1] + playerStatBase[2] + playerStatBase[3] + 27) / 4;
                            l4 = k5 - j5;
                            s2 = "@yel@";
                            if(l4 < 0)
                                s2 = "@or1@";
                            if(l4 < -3)
                                s2 = "@or2@";
                            if(l4 < -6)
                                s2 = "@or3@";
                            if(l4 < -9)
                                s2 = "@red@";
                            if(l4 > 0)
                                s2 = "@gr1@";
                            if(l4 > 3)
                                s2 = "@gr2@";
                            if(l4 > 6)
                                s2 = "@gr3@";
                            if(l4 > 9)
                                s2 = "@gre@";
                            s2 = " " + s2 + "(level-" + j5 + ")";
                        }
                        if(selectedSpell >= 0)
                        {
                            if(Data.amd[selectedSpell] == 2)
                            {
                                menuText1[menuOptionsCount] = "Cast " + Data.spellName[selectedSpell] + " on";
                                menuText2[menuOptionsCount] = "@yel@" + Data.ahd[npcArray[i3].gmj];
                                menuActionID[menuOptionsCount] = 700;
                                menuActionX[menuOptionsCount] = npcArray[i3].currentX;
                                menuActionY[menuOptionsCount] = npcArray[i3].currentY;
                                menuActionType[menuOptionsCount] = npcArray[i3].serverIndex;
                                menuActionVar1[menuOptionsCount] = selectedSpell;
                                menuOptionsCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText1[menuOptionsCount] = "Use " + selectedItemName + " with";
                            menuText2[menuOptionsCount] = "@yel@" + Data.ahd[npcArray[i3].gmj];
                            menuActionID[menuOptionsCount] = 710;
                            menuActionX[menuOptionsCount] = npcArray[i3].currentX;
                            menuActionY[menuOptionsCount] = npcArray[i3].currentY;
                            menuActionType[menuOptionsCount] = npcArray[i3].serverIndex;
                            menuActionVar1[menuOptionsCount] = selectedItem;
                            menuOptionsCount++;
                        } else
                        {
                            if(Data.alf[i5] > 0)
                            {
                                menuText1[menuOptionsCount] = "Attack";
                                menuText2[menuOptionsCount] = "@yel@" + Data.ahd[npcArray[i3].gmj] + s2;
                                if(l4 >= 0)
                                    menuActionID[menuOptionsCount] = 715;
                                else
                                    menuActionID[menuOptionsCount] = 2715;
                                menuActionX[menuOptionsCount] = npcArray[i3].currentX;
                                menuActionY[menuOptionsCount] = npcArray[i3].currentY;
                                menuActionType[menuOptionsCount] = npcArray[i3].serverIndex;
                                menuOptionsCount++;
                            }
                            menuText1[menuOptionsCount] = "Talk-to";
                            menuText2[menuOptionsCount] = "@yel@" + Data.ahd[npcArray[i3].gmj];
                            menuActionID[menuOptionsCount] = 720;
                            menuActionX[menuOptionsCount] = npcArray[i3].currentX;
                            menuActionY[menuOptionsCount] = npcArray[i3].currentY;
                            menuActionType[menuOptionsCount] = npcArray[i3].serverIndex;
                            menuOptionsCount++;
                            if(!Data.ahf[i5].equals(""))
                            {
                                menuText1[menuOptionsCount] = Data.ahf[i5];
                                menuText2[menuOptionsCount] = "@yel@" + Data.ahd[npcArray[i3].gmj];
                                menuActionID[menuOptionsCount] = 725;
                                menuActionX[menuOptionsCount] = npcArray[i3].currentX;
                                menuActionY[menuOptionsCount] = npcArray[i3].currentY;
                                menuActionType[menuOptionsCount] = npcArray[i3].serverIndex;
                                menuOptionsCount++;
                            }
                            menuText1[menuOptionsCount] = "Examine";
                            menuText2[menuOptionsCount] = "@yel@" + Data.ahd[npcArray[i3].gmj];
                            menuActionID[menuOptionsCount] = 3700;
                            menuActionType[menuOptionsCount] = npcArray[i3].gmj;
                            menuOptionsCount++;
                        }
                    }
                } else
                if(l2 != null && l2.chk >= 10000)
                {
                    int j3 = l2.chk - 10000;
                    int i4 = wallObjectID[j3];
                    if(!eah[j3])
                    {
                        if(selectedSpell >= 0)
                        {
                            if(Data.amd[selectedSpell] == 4)
                            {
                                menuText1[menuOptionsCount] = "Cast " + Data.spellName[selectedSpell] + " on";
                                menuText2[menuOptionsCount] = "@cya@" + Data.ahi[i4];
                                menuActionID[menuOptionsCount] = 300;
                                menuActionX[menuOptionsCount] = wallObjectX[j3];
                                menuActionY[menuOptionsCount] = wallObjectY[j3];
                                menuActionType[menuOptionsCount] = wallObjectDirection[j3];
                                menuActionVar1[menuOptionsCount] = selectedSpell;
                                menuOptionsCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText1[menuOptionsCount] = "Use " + selectedItemName + " with";
                            menuText2[menuOptionsCount] = "@cya@" + Data.ahi[i4];
                            menuActionID[menuOptionsCount] = 310;
                            menuActionX[menuOptionsCount] = wallObjectX[j3];
                            menuActionY[menuOptionsCount] = wallObjectY[j3];
                            menuActionType[menuOptionsCount] = wallObjectDirection[j3];
                            menuActionVar1[menuOptionsCount] = selectedItem;
                            menuOptionsCount++;
                        } else
                        {
                            if(!Data.ahk[i4].equalsIgnoreCase("WalkTo"))
                            {
                                menuText1[menuOptionsCount] = Data.ahk[i4];
                                menuText2[menuOptionsCount] = "@cya@" + Data.ahi[i4];
                                menuActionID[menuOptionsCount] = 320;
                                menuActionX[menuOptionsCount] = wallObjectX[j3];
                                menuActionY[menuOptionsCount] = wallObjectY[j3];
                                menuActionType[menuOptionsCount] = wallObjectDirection[j3];
                                menuOptionsCount++;
                            }
                            if(!Data.ahl[i4].equalsIgnoreCase("Examine"))
                            {
                                menuText1[menuOptionsCount] = Data.ahl[i4];
                                menuText2[menuOptionsCount] = "@cya@" + Data.ahi[i4];
                                menuActionID[menuOptionsCount] = 2300;
                                menuActionX[menuOptionsCount] = wallObjectX[j3];
                                menuActionY[menuOptionsCount] = wallObjectY[j3];
                                menuActionType[menuOptionsCount] = wallObjectDirection[j3];
                                menuOptionsCount++;
                            }
                            menuText1[menuOptionsCount] = "Examine";
                            menuText2[menuOptionsCount] = "@cya@" + Data.ahi[i4];
                            menuActionID[menuOptionsCount] = 3300;
                            menuActionType[menuOptionsCount] = i4;
                            menuOptionsCount++;
                        }
                        eah[j3] = true;
                    }
                } else
                if(l2 != null && l2.chk >= 0)
                {
                    int k3 = l2.chk;
                    int j4 = objectID[k3];
                    if(!dij[k3])
                    {
                        if(selectedSpell >= 0)
                        {
                            if(Data.amd[selectedSpell] == 5)
                            {
                                menuText1[menuOptionsCount] = "Cast " + Data.spellName[selectedSpell] + " on";
                                menuText2[menuOptionsCount] = "@cya@" + Data.ajm[j4];
                                menuActionID[menuOptionsCount] = 400;
                                menuActionX[menuOptionsCount] = objectX[k3];
                                menuActionY[menuOptionsCount] = objectY[k3];
                                menuActionType[menuOptionsCount] = elb[k3];
                                menuActionVar1[menuOptionsCount] = objectID[k3];
                                menuActionVar2[menuOptionsCount] = selectedSpell;
                                menuOptionsCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText1[menuOptionsCount] = "Use " + selectedItemName + " with";
                            menuText2[menuOptionsCount] = "@cya@" + Data.ajm[j4];
                            menuActionID[menuOptionsCount] = 410;
                            menuActionX[menuOptionsCount] = objectX[k3];
                            menuActionY[menuOptionsCount] = objectY[k3];
                            menuActionType[menuOptionsCount] = elb[k3];
                            menuActionVar1[menuOptionsCount] = objectID[k3];
                            menuActionVar2[menuOptionsCount] = selectedItem;
                            menuOptionsCount++;
                        } else
                        {
                            if(!Data.aka[j4].equalsIgnoreCase("WalkTo"))
                            {
                                menuText1[menuOptionsCount] = Data.aka[j4];
                                menuText2[menuOptionsCount] = "@cya@" + Data.ajm[j4];
                                menuActionID[menuOptionsCount] = 420;
                                menuActionX[menuOptionsCount] = objectX[k3];
                                menuActionY[menuOptionsCount] = objectY[k3];
                                menuActionType[menuOptionsCount] = elb[k3];
                                menuActionVar1[menuOptionsCount] = objectID[k3];
                                menuOptionsCount++;
                            }
                            if(!Data.akb[j4].equalsIgnoreCase("Examine"))
                            {
                                menuText1[menuOptionsCount] = Data.akb[j4];
                                menuText2[menuOptionsCount] = "@cya@" + Data.ajm[j4];
                                menuActionID[menuOptionsCount] = 2400;
                                menuActionX[menuOptionsCount] = objectX[k3];
                                menuActionY[menuOptionsCount] = objectY[k3];
                                menuActionType[menuOptionsCount] = elb[k3];
                                menuActionVar1[menuOptionsCount] = objectID[k3];
                                menuOptionsCount++;
                            }
                            menuText1[menuOptionsCount] = "Examine";
                            menuText2[menuOptionsCount] = "@cya@" + Data.ajm[j4];
                            menuActionID[menuOptionsCount] = 3400;
                            menuActionType[menuOptionsCount] = j4;
                            menuOptionsCount++;
                        }
                        dij[k3] = true;
                    }
                } else
                {
                    if(j2 >= 0)
                        j2 = l2.chl[j2] - 0x30d40;
                    if(j2 >= 0)
                        i1 = j2;
                }
        }

        if(selectedSpell >= 0 && Data.amd[selectedSpell] <= 1)
        {
            menuText1[menuOptionsCount] = "Cast " + Data.spellName[selectedSpell] + " on self";
            menuText2[menuOptionsCount] = "";
            menuActionID[menuOptionsCount] = 1000;
            menuActionType[menuOptionsCount] = selectedSpell;
            menuOptionsCount++;
        }
        if(i1 != -1)
        {
            int k2 = i1;
            if(selectedSpell >= 0)
            {
                if(Data.amd[selectedSpell] == 6)
                {
                    menuText1[menuOptionsCount] = "Cast " + Data.spellName[selectedSpell] + " on ground";
                    menuText2[menuOptionsCount] = "";
                    menuActionID[menuOptionsCount] = 900;
                    menuActionX[menuOptionsCount] = engineHandle.gin[k2];
                    menuActionY[menuOptionsCount] = engineHandle.ghk[k2];
                    menuActionType[menuOptionsCount] = selectedSpell;
                    menuOptionsCount++;
                    return;
                }
            } else
            if(selectedItem < 0)
            {
                menuText1[menuOptionsCount] = "Walk here";
                menuText2[menuOptionsCount] = "";
                menuActionID[menuOptionsCount] = 920;
                menuActionX[menuOptionsCount] = engineHandle.gin[k2];
                menuActionY[menuOptionsCount] = engineHandle.ghk[k2];
                menuOptionsCount++;
            }
        }
    }

    private final void fch()
    {
        if(mouseButtonClick != 0)
        {
            mouseButtonClick = 0;
            int l = super.mouseX - 52;
            int i1 = super.mouseY - 44;
            if(l >= 0 && i1 >= 12 && l < 408 && i1 < 246)
            {
                int j1 = 0;
                for(int l1 = 0; l1 < 5; l1++)
                {
                    for(int l2 = 0; l2 < 8; l2++)
                    {
                        int k3 = 7 + l2 * 49;
                        int k4 = 28 + l1 * 34;
                        if(l > k3 && l < k3 + 49 && i1 > k4 && i1 < k4 + 34 && efa[j1] != -1)
                        {
                            dej = j1;
                            dek = efa[j1];
                        }
                        j1++;
                    }

                }

                if(dej >= 0)
                {
                    int i3 = efa[dej];
                    if(i3 != -1)
                    {
                        if(efb[dej] > 0 && l > 298 && i1 >= 204 && l < 408 && i1 <= 215)
                        {
                            int l3 = dmd + efc[dej];
                            if(l3 < 10)
                                l3 = 10;
                            int l4 = (l3 * Data.aif[i3]) / 100;
                            super.streamClass.createPacket(67);
                            super.streamClass.addShort(efa[dej]);
                            super.streamClass.addInt(l4);
                            super.streamClass.formatPacket();
                        }
                        if(getInventoryItemTotalCount(i3) > 0 && l > 2 && i1 >= 229 && l < 112 && i1 <= 240)
                        {
                            int i4 = dmc + efc[dej];
                            if(i4 < 10)
                                i4 = 10;
                            int i5 = (i4 * Data.aif[i3]) / 100;
                            super.streamClass.createPacket(177);
                            super.streamClass.addShort(efa[dej]);
                            super.streamClass.addInt(i5);
                            super.streamClass.formatPacket();
                        }
                    }
                }
            } else
            {
                super.streamClass.createPacket(92);
                super.streamClass.formatPacket();
                showShopBox = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        gameGraphics.drawBox(byte0, byte1, 408, 12, 192);
        int k1 = 0x989898;
        gameGraphics.drawBoxAlpha(byte0, byte1 + 12, 408, 17, k1, 160);
        gameGraphics.drawBoxAlpha(byte0, byte1 + 29, 8, 170, k1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 399, byte1 + 29, 9, 170, k1, 160);
        gameGraphics.drawBoxAlpha(byte0, byte1 + 199, 408, 47, k1, 160);
        gameGraphics.drawString("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int i2 = 0xffffff;
        if(super.mouseX > byte0 + 320 && super.mouseY >= byte1 && super.mouseX < byte0 + 408 && super.mouseY < byte1 + 12)
            i2 = 0xff0000;
        gameGraphics.cdk("Close window", byte0 + 406, byte1 + 10, 1, i2);
        gameGraphics.drawString("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        gameGraphics.drawString("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        gameGraphics.drawString("Your money: " + getInventoryItemTotalCount(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int j3 = 0xd0d0d0;
        int j4 = 0;
        for(int j5 = 0; j5 < 5; j5++)
        {
            for(int k5 = 0; k5 < 8; k5++)
            {
                int i6 = byte0 + 7 + k5 * 49;
                int l6 = byte1 + 28 + j5 * 34;
                if(dej == j4)
                    gameGraphics.drawBoxAlpha(i6, l6, 49, 34, 0xff0000, 160);
                else
                    gameGraphics.drawBoxAlpha(i6, l6, 49, 34, j3, 160);
                gameGraphics.drawBoxEdge(i6, l6, 50, 35, 0);
                if(efa[j4] != -1)
                {
                    gameGraphics.drawImage(i6, l6, 48, 32, baseItemPicture + Data.itemInventoryPicture[efa[j4]], Data.itemPictureMask[efa[j4]], 0, 0, false);
                    gameGraphics.drawString(String.valueOf(efb[j4]), i6 + 1, l6 + 10, 1, 65280);
                    gameGraphics.cdk(String.valueOf(getInventoryItemTotalCount(efa[j4])), i6 + 47, l6 + 10, 1, 65535);
                }
                j4++;
            }

        }

        gameGraphics.drawLineX(byte0 + 5, byte1 + 222, 398, 0);
        if(dej == -1)
        {
            gameGraphics.drawText("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int l5 = efa[dej];
        if(l5 != -1)
        {
            if(efb[dej] > 0)
            {
                int j6 = dmd + efc[dej];
                if(j6 < 10)
                    j6 = 10;
                int i7 = (j6 * Data.aif[l5]) / 100;
                gameGraphics.drawString("Buy a new " + Data.itemName[l5] + " for " + i7 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int j2 = 0xffffff;
                if(super.mouseX > byte0 + 298 && super.mouseY >= byte1 + 204 && super.mouseX < byte0 + 408 && super.mouseY <= byte1 + 215)
                    j2 = 0xff0000;
                gameGraphics.cdk("Click here to buy", byte0 + 405, byte1 + 214, 3, j2);
            } else
            {
                gameGraphics.drawText("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(getInventoryItemTotalCount(l5) > 0)
            {
                int k6 = dmc + efc[dej];
                if(k6 < 10)
                    k6 = 10;
                int j7 = (k6 * Data.aif[l5]) / 100;
                gameGraphics.cdk("Sell your " + Data.itemName[l5] + " for " + j7 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int k2 = 0xffffff;
                if(super.mouseX > byte0 + 2 && super.mouseY >= byte1 + 229 && super.mouseX < byte0 + 112 && super.mouseY <= byte1 + 240)
                    k2 = 0xff0000;
                gameGraphics.drawString("Click here to sell", byte0 + 2, byte1 + 239, 3, k2);
                return;
            }
            gameGraphics.drawText("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    private final void loadTextures()
    {
        byte abyte0[] = unpackData("textures" + Version.cfd + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            errorLoading = true;
            return;
        }
        byte abyte1[] = DataOperations.loadData("index.dat", 0, abyte0);
        gameCamera.bje(Data.akc, 7, 11);
        for(int l = 0; l < Data.akc; l++)
        {
            String s1 = Data.ajk[l];
            byte abyte2[] = DataOperations.loadData(s1 + ".dat", 0, abyte0);
            gameGraphics.unpackImageData(baseTexturePic, abyte2, abyte1, 1);
            gameGraphics.drawBox(0, 0, 128, 128, 0xff00ff);
            gameGraphics.drawPicture(0, 0, baseTexturePic);
            int i1 = ((GameImage) (gameGraphics)).bmj[baseTexturePic];
            String s2 = Data.ajl[l];
            if(s2 != null && s2.length() > 0)
            {
                byte abyte3[] = DataOperations.loadData(s2 + ".dat", 0, abyte0);
                gameGraphics.unpackImageData(baseTexturePic, abyte3, abyte1, 1);
                gameGraphics.drawPicture(0, 0, baseTexturePic);
            }
            gameGraphics.cca(subTexturePic + l, 0, 0, i1, i1);
            int j1 = i1 * i1;
            for(int k1 = 0; k1 < j1; k1++)
                if(((GameImage) (gameGraphics)).bmc[subTexturePic + l][k1] == 65280)
                    ((GameImage) (gameGraphics)).bmc[subTexturePic + l][k1] = 0xff00ff;

            gameGraphics.cbl(subTexturePic + l);
            gameCamera.bjf(l, ((GameImage) (gameGraphics)).bmd[subTexturePic + l], ((GameImage) (gameGraphics)).bme[subTexturePic + l], i1 / 64 - 1);
        }

    }

    private final void fcj()
    {
        gameGraphics.interlace = false;
        gameGraphics.clearScreen();
        appearanceMenu.drawMenu();
        int l = 140;
        int i1 = 50;
        l += 116;
        i1 -= 25;
        gameGraphics.ccf(l - 32 - 55, i1, 64, 102, Data.animationNumber[appearance2Colour], appearanceTopBottomColours[appearanceBottomColour]);
        gameGraphics.drawImage(l - 32 - 55, i1, 64, 102, Data.animationNumber[appearanceBodyGender], appearanceTopBottomColours[appearanceTopColour], dki[appearanceSkinColour], 0, false);
        gameGraphics.drawImage(l - 32 - 55, i1, 64, 102, Data.animationNumber[appearanceHeadType], appearanceHairColours[appearanceHairColour], dki[appearanceSkinColour], 0, false);
        gameGraphics.ccf(l - 32, i1, 64, 102, Data.animationNumber[appearance2Colour] + 6, appearanceTopBottomColours[appearanceBottomColour]);
        gameGraphics.drawImage(l - 32, i1, 64, 102, Data.animationNumber[appearanceBodyGender] + 6, appearanceTopBottomColours[appearanceTopColour], dki[appearanceSkinColour], 0, false);
        gameGraphics.drawImage(l - 32, i1, 64, 102, Data.animationNumber[appearanceHeadType] + 6, appearanceHairColours[appearanceHairColour], dki[appearanceSkinColour], 0, false);
        gameGraphics.ccf((l - 32) + 55, i1, 64, 102, Data.animationNumber[appearance2Colour] + 12, appearanceTopBottomColours[appearanceBottomColour]);
        gameGraphics.drawImage((l - 32) + 55, i1, 64, 102, Data.animationNumber[appearanceBodyGender] + 12, appearanceTopBottomColours[appearanceTopColour], dki[appearanceSkinColour], 0, false);
        gameGraphics.drawImage((l - 32) + 55, i1, 64, 102, Data.animationNumber[appearanceHeadType] + 12, appearanceHairColours[appearanceHairColour], dki[appearanceSkinColour], 0, false);
        gameGraphics.drawPicture(0, windowHeight, baseInventoryPic + 22);
        gameGraphics.drawImage(graphics, 0, 0);
    }

    private final void fck()
    {
        if(selectedSpell >= 0 || selectedItem >= 0)
        {
            menuText1[menuOptionsCount] = "Cancel";
            menuText2[menuOptionsCount] = "";
            menuActionID[menuOptionsCount] = 4000;
            menuOptionsCount++;
        }
        for(int l = 0; l < menuOptionsCount; l++)
            dec[l] = l;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int i1 = 0; i1 < menuOptionsCount - 1; i1++)
            {
                int k1 = dec[i1];
                int i2 = dec[i1 + 1];
                if(menuActionID[k1] > menuActionID[i2])
                {
                    dec[i1] = i2;
                    dec[i1 + 1] = k1;
                    flag = false;
                }
            }

        }

        if(menuOptionsCount > 20)
            menuOptionsCount = 20;
        if(menuOptionsCount > 0)
        {
            int j1 = -1;
            for(int l1 = 0; l1 < menuOptionsCount; l1++)
            {
                if(menuText2[dec[l1]] == null || menuText2[dec[l1]].length() <= 0)
                    continue;
                j1 = l1;
                break;
            }

            String s1 = null;
            if((selectedItem >= 0 || selectedSpell >= 0) && menuOptionsCount == 1)
                s1 = "Choose a target";
            else
            if((selectedItem >= 0 || selectedSpell >= 0) && menuOptionsCount > 1)
                s1 = "@whi@" + menuText1[dec[0]] + " " + menuText2[dec[0]];
            else
            if(j1 != -1)
                s1 = menuText2[dec[j1]] + ": @whi@" + menuText1[dec[0]];
            if(menuOptionsCount == 2 && s1 != null)
                s1 = s1 + "@whi@ / 1 more option";
            if(menuOptionsCount > 2 && s1 != null)
                s1 = s1 + "@whi@ / " + (menuOptionsCount - 1) + " more options";
            if(s1 != null)
                gameGraphics.drawString(s1, 6, 14, 1, 0xffff00);
            if(!configOneMouseButton && mouseButtonClick == 1 || configOneMouseButton && mouseButtonClick == 1 && menuOptionsCount == 1)
            {
                menuClick(dec[0]);
                mouseButtonClick = 0;
                return;
            }
            if(!configOneMouseButton && mouseButtonClick == 2 || configOneMouseButton && mouseButtonClick == 1)
            {
                eje = (menuOptionsCount + 1) * 15;
                ejd = gameGraphics.textWidth("Choose option", 1) + 5;
                for(int j2 = 0; j2 < menuOptionsCount; j2++)
                {
                    int k2 = gameGraphics.textWidth(menuText1[j2] + " " + menuText2[j2], 1) + 5;
                    if(k2 > ejd)
                        ejd = k2;
                }

                ejb = super.mouseX - ejd / 2;
                ejc = super.mouseY - 7;
                dkk = true;
                if(ejb < 0)
                    ejb = 0;
                if(ejc < 0)
                    ejc = 0;
                if(ejb + ejd > 510)
                    ejb = 510 - ejd;
                if(ejc + eje > 315)
                    ejc = 315 - eje;
                mouseButtonClick = 0;
            }
        }
    }

    private final void drawGame()
    {
        if(playerAliveTimeout != 0)
        {
            gameGraphics.screenFadeToBlack();
            gameGraphics.drawText("Oh dear! You are dead...", windowWidth / 2, windowHeight / 2, 7, 0xff0000);
            drawChatMessageTabs();
            gameGraphics.drawImage(graphics, 0, 0);
            return;
        }
        if(showAppearanceWindow)
        {
            fcj();
            return;
        }
        if(isSleeping)
        {
            gameGraphics.screenFadeToBlack();
            if(Math.random() < 0.14999999999999999D)
                gameGraphics.drawText("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                gameGraphics.drawText("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            gameGraphics.drawBox(windowWidth / 2 - 100, 160, 200, 40, 0);
            gameGraphics.drawText("You are sleeping", windowWidth / 2, 50, 7, 0xffff00);
            gameGraphics.drawText("Fatigue: " + (dhk * 100) / 750 + "%", windowWidth / 2, 90, 7, 0xffff00);
            gameGraphics.drawText("When you want to wake up just use your", windowWidth / 2, 140, 5, 0xffffff);
            gameGraphics.drawText("keyboard to type the word in the box below", windowWidth / 2, 160, 5, 0xffffff);
            gameGraphics.drawText(super.inputText + "*", windowWidth / 2, 180, 5, 65535);
            if(del == null)
                gameGraphics.drawPicture(windowWidth / 2 - 127, 230, baseTexturePic + 1);
            else
                gameGraphics.drawText(del, windowWidth / 2, 260, 5, 0xff0000);
            gameGraphics.drawBoxEdge(windowWidth / 2 - 128, 229, 257, 42, 0xffffff);
            drawChatMessageTabs();
            gameGraphics.drawText("If you can't read the word", windowWidth / 2, 290, 1, 0xffffff);
            gameGraphics.drawText("@yel@click here@whi@ to get a different one", windowWidth / 2, 305, 1, 0xffffff);
            gameGraphics.drawImage(graphics, 0, 0);
            return;
        }
        if(!engineHandle.gii)
            return;
        for(int l = 0; l < 64; l++)
        {
            gameCamera.removeModel(engineHandle.gih[eal][l]);
            if(eal == 0)
            {
                gameCamera.removeModel(engineHandle.gim[1][l]);
                gameCamera.removeModel(engineHandle.gih[1][l]);
                gameCamera.removeModel(engineHandle.gim[2][l]);
                gameCamera.removeModel(engineHandle.gih[2][l]);
            }
            ebg = true;
            if(eal == 0 && (engineHandle.tiles[ourPlayer.currentX / 128][ourPlayer.currentY / 128] & 0x80) == 0)
            {
                gameCamera.bgm(engineHandle.gih[eal][l]);
                if(eal == 0)
                {
                    gameCamera.bgm(engineHandle.gim[1][l]);
                    gameCamera.bgm(engineHandle.gih[1][l]);
                    gameCamera.bgm(engineHandle.gim[2][l]);
                    gameCamera.bgm(engineHandle.gih[2][l]);
                }
                ebg = false;
            }
        }

        if(dfa != ehi)
        {
            ehi = dfa;
            for(int i1 = 0; i1 < objectCount; i1++)
            {
                if(objectID[i1] == 97)
                    emj(i1, "firea" + (dfa + 1));
                if(objectID[i1] == 274)
                    emj(i1, "fireplacea" + (dfa + 1));
                if(objectID[i1] == 1031)
                    emj(i1, "lightning" + (dfa + 1));
                if(objectID[i1] == 1036)
                    emj(i1, "firespell" + (dfa + 1));
                if(objectID[i1] == 1147)
                    emj(i1, "spellcharge" + (dfa + 1));
            }

        }
        if(dfb != ehj)
        {
            ehj = dfb;
            for(int j1 = 0; j1 < objectCount; j1++)
            {
                if(objectID[j1] == 51)
                    emj(j1, "torcha" + (dfb + 1));
                if(objectID[j1] == 143)
                    emj(j1, "skulltorcha" + (dfb + 1));
            }

        }
        if(dfc != ehk)
        {
            ehk = dfc;
            for(int k1 = 0; k1 < objectCount; k1++)
                if(objectID[k1] == 1142)
                    emj(k1, "clawspell" + (dfc + 1));

        }
        gameCamera.bhc(dha);
        dha = 0;
        for(int l1 = 0; l1 < playerCount; l1++)
        {
            Mob f1 = playerArray[l1];
            if(f1.hab != 255)
            {
                int j2 = f1.currentX;
                int l2 = f1.currentY;
                int j3 = -engineHandle.gjf(j2, l2);
                int k4 = gameCamera.bhd(5000 + l1, j2, j3, l2, 145, 220, l1 + 10000);
                dha++;
                if(f1 == ourPlayer)
                    gameCamera.bhe(k4);
                if(f1.currentSprite == 8)
                    gameCamera.bhf(k4, -30);
                if(f1.currentSprite == 9)
                    gameCamera.bhf(k4, 30);
            }
        }

        for(int i2 = 0; i2 < playerCount; i2++)
        {
            Mob f2 = playerArray[i2];
            if(f2.projectileDistance > 0)
            {
                Mob f3 = null;
                if(f2.haf != -1)
                    f3 = npcAttackingArray[f2.haf];
                else
                if(f2.hae != -1)
                    f3 = playerBufferArray[f2.hae];
                if(f3 != null)
                {
                    int k3 = f2.currentX;
                    int l4 = f2.currentY;
                    int k7 = -engineHandle.gjf(k3, l4) - 110;
                    int k9 = f3.currentX;
                    int j10 = f3.currentY;
                    int k10 = -engineHandle.gjf(k9, j10) - Data.aia[f3.gmj] / 2;
                    int l10 = (k3 * f2.projectileDistance + k9 * (eic - f2.projectileDistance)) / eic;
                    int i11 = (k7 * f2.projectileDistance + k10 * (eic - f2.projectileDistance)) / eic;
                    int j11 = (l4 * f2.projectileDistance + j10 * (eic - f2.projectileDistance)) / eic;
                    gameCamera.bhd(baseProjectilePic + f2.had, l10, i11, j11, 32, 32, 0);
                    dha++;
                }
            }
        }

        for(int k2 = 0; k2 < npcCount; k2++)
        {
            Mob f4 = npcArray[k2];
            int l3 = f4.currentX;
            int i5 = f4.currentY;
            int l7 = -engineHandle.gjf(l3, i5);
            int l9 = gameCamera.bhd(20000 + k2, l3, l7, i5, Data.ahn[f4.gmj], Data.aia[f4.gmj], k2 + 30000);
            dha++;
            if(f4.currentSprite == 8)
                gameCamera.bhf(l9, -30);
            if(f4.currentSprite == 9)
                gameCamera.bhf(l9, 30);
        }

        for(int i3 = 0; i3 < groundItemCount; i3++)
        {
            int i4 = dml[i3] * magicLoc + 64;
            int j5 = dmm[i3] * magicLoc + 64;
            gameCamera.bhd(40000 + dmn[i3], i4, -engineHandle.gjf(i4, j5) - dna[i3], j5, 96, 64, i3 + 20000);
            dha++;
        }

        for(int j4 = 0; j4 < eig; j4++)
        {
            int k5 = ell[j4] * magicLoc + 64;
            int i8 = elh[j4] * magicLoc + 64;
            int i10 = teleBubbleType[j4];
            if(i10 == 0)
            {
                gameCamera.bhd(50000 + j4, k5, -engineHandle.gjf(k5, i8), i8, 128, 256, j4 + 50000);
                dha++;
            }
            if(i10 == 1)
            {
                gameCamera.bhd(50000 + j4, k5, -engineHandle.gjf(k5, i8), i8, 128, 64, j4 + 50000);
                dha++;
            }
        }

        gameGraphics.interlace = false;
        gameGraphics.clearScreen();
        gameGraphics.interlace = super.keyF1Toggle;
        if(eal == 3)
        {
            int l5 = 40 + (int)(Math.random() * 3D);
            int j8 = 40 + (int)(Math.random() * 7D);
            gameCamera.bjl(l5, j8, -50, -10, -50);
        }
        dib = 0;
        egg = 0;
        ejl = 0;
        if(cameraAutoAngleDebug)
        {
            if(configCmeraAutoAngle && !ebg)
            {
                int i6 = cameraAutoAngle;
                autoRotateCamera();
                if(cameraAutoAngle != i6)
                {
                    cameraAutoRotatePlayerX = ourPlayer.currentX;
                    cameraAutoRotatePlayerY = ourPlayer.currentY;
                }
            }
            gameCamera.zoom1 = 3000;
            gameCamera.zoom2 = 3000;
            gameCamera.zoom3 = 1;
            gameCamera.zoom4 = 2800;
            cameraRotation = cameraAutoAngle * 32;
            int j6 = cameraAutoRotatePlayerX + cameraRotationXAmount;
            int k8 = cameraAutoRotatePlayerY + cameraRotationYAmount;
            gameCamera.setCamera(j6, -engineHandle.gjf(j6, k8), k8, 912, cameraRotation * 4, 0, 2000);
        } else
        {
            if(configCmeraAutoAngle && !ebg)
                autoRotateCamera();
            if(!super.keyF1Toggle)
            {
                gameCamera.zoom1 = 2400;
                gameCamera.zoom2 = 2400;
                gameCamera.zoom3 = 1;
                gameCamera.zoom4 = 2300;
            } else
            {
                gameCamera.zoom1 = 2200;
                gameCamera.zoom2 = 2200;
                gameCamera.zoom3 = 1;
                gameCamera.zoom4 = 2100;
            }
            int k6 = cameraAutoRotatePlayerX + cameraRotationXAmount;
            int l8 = cameraAutoRotatePlayerY + cameraRotationYAmount;
            gameCamera.setCamera(k6, -engineHandle.gjf(k6, l8), l8, 912, cameraRotation * 4, 0, cameraDistance * 2);
        }
        gameCamera.finishCamera();
        fde();
        if(actionPictureType > 0)
            gameGraphics.drawPicture(walkMouseX - 8, walkMouseY - 8, baseInventoryPic + 14 + (24 - actionPictureType) / 6);
        if(actionPictureType < 0)
            gameGraphics.drawPicture(walkMouseX - 8, walkMouseY - 8, baseInventoryPic + 18 + (24 + actionPictureType) / 6);
        if(systemUpdate != 0)
        {
            int l6 = systemUpdate / 50;
            int i9 = l6 / 60;
            l6 %= 60;
            if(l6 < 10)
                gameGraphics.drawText("System update in: " + i9 + ":0" + l6, 256, windowHeight - 7, 1, 0xffff00);
            else
                gameGraphics.drawText("System update in: " + i9 + ":" + l6, 256, windowHeight - 7, 1, 0xffff00);
        }
        if(!elk)
        {
            int i7 = 2203 - (sectionY + eaj + areaY);
            if(sectionX + eai + areaX >= 2640)
                i7 = -50;
            if(i7 > 0)
            {
                int j9 = 1 + i7 / 6;
                gameGraphics.drawPicture(453, windowHeight - 56, baseInventoryPic + 13);
                gameGraphics.drawText("Wilderness", 465, windowHeight - 20, 1, 0xffff00);
                gameGraphics.drawText("Level: " + j9, 465, windowHeight - 7, 1, 0xffff00);
                if(dme == 0)
                    dme = 2;
            }
            if(dme == 0 && i7 > -10 && i7 <= 0)
                dme = 1;
        }
        if(dea == 0)
        {
            for(int j7 = 0; j7 < 5; j7++)
                if(eib[j7] > 0)
                {
                    String s1 = die[j7];
                    gameGraphics.drawString(s1, 7, windowHeight - 18 - j7 * 12, 1, 0xffff00);
                }

        }
        chatInputMenu.ggf(messagesHandleType2);
        chatInputMenu.ggf(messagesHandleType5);
        chatInputMenu.ggf(messagesHandleType6);
        if(dea == 1)
            chatInputMenu.gge(messagesHandleType2);
        else
        if(dea == 2)
            chatInputMenu.gge(messagesHandleType5);
        else
        if(dea == 3)
            chatInputMenu.gge(messagesHandleType6);
        Menu.gdm = 2;
        chatInputMenu.drawMenu();
        Menu.gdm = 0;
        gameGraphics.ccd(((GameImage) (gameGraphics)).gameWidth - 3 - 197, 3, baseInventoryPic, 128);
        fcn();
        gameGraphics.loggedIn = false;
        drawChatMessageTabs();
        gameGraphics.drawImage(graphics, 0, 0);
    }

    private final void fcm()
    {
        if(super.enteredInputText.length() > 0)
        {
            String s1 = super.enteredInputText.trim();
            super.inputText = "";
            super.enteredInputText = "";
            if(s1.length() > 0)
            {
                long l1 = DataOperations.nameToHash(s1);
                super.streamClass.createPacket(215);
                super.streamClass.addLong(l1);
                super.streamClass.addByte(reportAbuseOptionSelected);
                super.streamClass.addByte(dia ? 1 : 0);
                super.streamClass.formatPacket();
            }
            showAbuseBox = 0;
            return;
        }
        gameGraphics.drawBox(56, 130, 400, 100, 0);
        gameGraphics.drawBoxEdge(56, 130, 400, 100, 0xffffff);
        int l = 160;
        gameGraphics.drawText("Now type the name of the offending player, and press enter", 256, l, 1, 0xffff00);
        l += 18;
        gameGraphics.drawText("Name: " + super.inputText + "*", 256, l, 4, 0xffffff);
        if(super.abj > 0)
        {
            l = 207;
            if(dia)
                gameGraphics.drawText("Moderator option: Mute player for 48 hours: <ON>", 256, l, 1, 0xff8000);
            else
                gameGraphics.drawText("Moderator option: Mute player for 48 hours: <OFF>", 256, l, 1, 0xffffff);
            if(super.mouseX > 106 && super.mouseX < 406 && super.mouseY > l - 13 && super.mouseY < l + 2 && mouseButtonClick == 1)
            {
                mouseButtonClick = 0;
                dia = !dia;
            }
        }
        l = 222;
        int i1 = 0xffffff;
        if(super.mouseX > 196 && super.mouseX < 316 && super.mouseY > l - 13 && super.mouseY < l + 2)
        {
            i1 = 0xffff00;
            if(mouseButtonClick == 1)
            {
                mouseButtonClick = 0;
                showAbuseBox = 0;
            }
        }
        gameGraphics.drawText("Click here to cancel", 256, l, 1, i1);
        if(mouseButtonClick == 1 && (super.mouseX < 56 || super.mouseX > 456 || super.mouseY < 130 || super.mouseY > 230))
        {
            mouseButtonClick = 0;
            showAbuseBox = 0;
        }
    }

    private final void fcn()
    {
        if(logoutTimer != 0)
            drawLogoutBox();
        else
        if(showWelcomeBox)
            drawWelcomeBox();
        else
        if(ecc)
            fdl();
        else
        if(dme == 1)
            fdc();
        else
        if(showBankBox && combatTimeout == 0)
            fdf();
        else
        if(showShopBox && combatTimeout == 0)
            fch();
        else
        if(showTradeConfirmBox)
            drawTradeConfirmBox();
        else
        if(showTradeBox)
            drawTradeBox();
        else
        if(showDuelConfirmBox)
            drawDuelConfirmBox();
        else
        if(eld)
            fdb();
        else
        if(showAbuseBox == 1)
            drawReportAbuseBox1();
        else
        if(showAbuseBox == 2)
            fcm();
        else
        if(showFriendsBox != 0)
        {
            fed();
        } else
        {
            if(showQuestionMenu)
                drawQuestionMenu();
            if(ourPlayer.currentSprite == 8 || ourPlayer.currentSprite == 9)
                drawCombatStyleBox();
            feg();
            boolean flag = !showQuestionMenu && !dkk;
            if(flag)
                menuOptionsCount = 0;
            if(drawMenuTab == 0 && flag)
                fcg();
            if(drawMenuTab == 1)
                drawInventoryMenu(flag);
            if(drawMenuTab == 2)
                drawMinimapMenu(flag);
            if(drawMenuTab == 3)
                fec(flag);
            if(drawMenuTab == 4)
                drawPrayerMagicMenu(flag);
            if(drawMenuTab == 5)
                drawFriendsMenu(flag);
            if(drawMenuTab == 6)
                drawOptionsMenu(flag);
            if(!dkk && !showQuestionMenu)
                fck();
            if(dkk && !showQuestionMenu)
                fef();
        }
        mouseButtonClick = 0;
    }

    private final void loadModels()
    {
        Data.anj("torcha2");
        Data.anj("torcha3");
        Data.anj("torcha4");
        Data.anj("skulltorcha2");
        Data.anj("skulltorcha3");
        Data.anj("skulltorcha4");
        Data.anj("firea2");
        Data.anj("firea3");
        Data.anj("fireplacea2");
        Data.anj("fireplacea3");
        Data.anj("firespell2");
        Data.anj("firespell3");
        Data.anj("lightning2");
        Data.anj("lightning3");
        Data.anj("clawspell2");
        Data.anj("clawspell3");
        Data.anj("clawspell4");
        Data.anj("clawspell5");
        Data.anj("spellcharge2");
        Data.anj("spellcharge3");
        if(inBrowser())
        {
            byte abyte0[] = unpackData("models" + Version.cfc + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                errorLoading = true;
                return;
            }
            for(int i1 = 0; i1 < Data.ama; i1++)
            {
                int j1 = DataOperations.getSoundOffset(Data.ajj[i1] + ".ob3", abyte0);
                if(j1 != 0)
                    gameDataObjects[i1] = new i(abyte0, j1, true);
                else
                    gameDataObjects[i1] = new i(1, 1);
                if(Data.ajj[i1].equals("giantcrystal"))
                    gameDataObjects[i1].chj = true;
            }

            return;
        }
        drawLoadingBarText(70, "Loading 3d models");
        for(int l = 0; l < Data.ama; l++)
        {
            gameDataObjects[l] = new i("../gamedata/models/" + Data.ajj[l] + ".ob2");
            if(Data.ajj[l].equals("giantcrystal"))
                gameDataObjects[l].chj = true;
        }

    }

    private final void fdb()
    {
        if(mouseButtonClick != 0 && mouseClickedHeldInTradeDuelBox == 0)
            mouseClickedHeldInTradeDuelBox = 1;
        if(mouseClickedHeldInTradeDuelBox > 0)
        {
            int l = super.mouseX - 22;
            int i1 = super.mouseY - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < inventoryItemsCount)
                    {
                        boolean flag1 = false;
                        int k2 = 0;
                        int j3 = inventoryItems[j1];
                        for(int j4 = 0; j4 < ded; j4++)
                            if(dee[j4] == j3)
                                if(Data.itemStackable[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < mouseClickedHeldInTradeDuelBox; l4++)
                                    {
                                        if(def[j4] < inventoryItemCount[j1])
                                            def[j4]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(getInventoryItemTotalCount(j3) <= k2)
                            flag1 = true;
                        if(Data.itemSpecial[j3] == 1)
                        {
                            displayMessage("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && ded < 8)
                        {
                            dee[ded] = j3;
                            def[ded] = 1;
                            ded++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.streamClass.createPacket(229);
                            super.streamClass.addByte(ded);
                            for(int i5 = 0; i5 < ded; i5++)
                            {
                                super.streamClass.addShort(dee[i5]);
                                super.streamClass.addInt(def[i5]);
                            }

                            super.streamClass.formatPacket();
                            dhe = false;
                            dhf = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 129)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < ded)
                    {
                        int i2 = dee[k1];
                        for(int l2 = 0; l2 < mouseClickedHeldInTradeDuelBox; l2++)
                        {
                            if(Data.itemStackable[i2] == 0 && def[k1] > 1)
                            {
                                def[k1]--;
                                continue;
                            }
                            ded--;
                            mouseButtonHeldTime = 0;
                            for(int k3 = k1; k3 < ded; k3++)
                            {
                                dee[k3] = dee[k3 + 1];
                                def[k3] = def[k3 + 1];
                            }

                            break;
                        }

                        super.streamClass.createPacket(229);
                        super.streamClass.addByte(ded);
                        for(int l3 = 0; l3 < ded; l3++)
                        {
                            super.streamClass.addShort(dee[l3]);
                            super.streamClass.addInt(def[l3]);
                        }

                        super.streamClass.formatPacket();
                        dhe = false;
                        dhf = false;
                    }
                }
                boolean flag = false;
                if(l >= 93 && i1 >= 221 && l <= 104 && i1 <= 232)
                {
                    dgg = !dgg;
                    flag = true;
                }
                if(l >= 93 && i1 >= 240 && l <= 104 && i1 <= 251)
                {
                    dgh = !dgh;
                    flag = true;
                }
                if(l >= 191 && i1 >= 221 && l <= 202 && i1 <= 232)
                {
                    dgi = !dgi;
                    flag = true;
                }
                if(l >= 191 && i1 >= 240 && l <= 202 && i1 <= 251)
                {
                    dgj = !dgj;
                    flag = true;
                }
                if(flag)
                {
                    super.streamClass.createPacket(138);
                    super.streamClass.addByte(dgg ? 1 : 0);
                    super.streamClass.addByte(dgh ? 1 : 0);
                    super.streamClass.addByte(dgi ? 1 : 0);
                    super.streamClass.addByte(dgj ? 1 : 0);
                    super.streamClass.formatPacket();
                    dhe = false;
                    dhf = false;
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    dhf = true;
                    super.streamClass.createPacket(125);
                    super.streamClass.formatPacket();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    eld = false;
                    super.streamClass.createPacket(43);
                    super.streamClass.formatPacket();
                }
            } else
            if(mouseButtonClick != 0)
            {
                eld = false;
                super.streamClass.createPacket(43);
                super.streamClass.formatPacket();
            }
            mouseButtonClick = 0;
            mouseClickedHeldInTradeDuelBox = 0;
        }
        if(!eld)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        gameGraphics.drawBox(byte0, byte1, 468, 12, 0xc90b1d);
        int l1 = 0x989898;
        gameGraphics.drawBoxAlpha(byte0, byte1 + 12, 468, 18, l1, 160);
        gameGraphics.drawBoxAlpha(byte0, byte1 + 30, 8, 248, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 99, 197, 24, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 192, 197, 23, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        gameGraphics.drawBoxAlpha(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 30, 197, 69, j2, 160);
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 123, 197, 69, j2, 160);
        gameGraphics.drawBoxAlpha(byte0 + 8, byte1 + 215, 197, 43, j2, 160);
        gameGraphics.drawBoxAlpha(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 3; i3++)
            gameGraphics.drawLineX(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 3; i4++)
            gameGraphics.drawLineX(byte0 + 8, byte1 + 123 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            gameGraphics.drawLineX(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                gameGraphics.drawLineY(byte0 + 8 + j5 * 49, byte1 + 30, 69, 0);
            if(j5 < 5)
                gameGraphics.drawLineY(byte0 + 8 + j5 * 49, byte1 + 123, 69, 0);
            gameGraphics.drawLineY(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        gameGraphics.drawLineX(byte0 + 8, byte1 + 215, 197, 0);
        gameGraphics.drawLineX(byte0 + 8, byte1 + 257, 197, 0);
        gameGraphics.drawLineY(byte0 + 8, byte1 + 215, 43, 0);
        gameGraphics.drawLineY(byte0 + 204, byte1 + 215, 43, 0);
        gameGraphics.drawString("Preparing to duel with: " + eke, byte0 + 1, byte1 + 10, 1, 0xffffff);
        gameGraphics.drawString("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        gameGraphics.drawString("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        gameGraphics.drawString("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        gameGraphics.drawString("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        gameGraphics.drawString("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        gameGraphics.drawString("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        gameGraphics.drawString("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        gameGraphics.drawString("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        gameGraphics.drawBoxEdge(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(dgg)
            gameGraphics.drawBox(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        gameGraphics.drawBoxEdge(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dgh)
            gameGraphics.drawBox(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        gameGraphics.drawBoxEdge(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(dgi)
            gameGraphics.drawBox(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        gameGraphics.drawBoxEdge(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dgj)
            gameGraphics.drawBox(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!dhf)
            gameGraphics.drawPicture(byte0 + 217, byte1 + 238, baseInventoryPic + 25);
        gameGraphics.drawPicture(byte0 + 394, byte1 + 238, baseInventoryPic + 26);
        if(dhe)
        {
            gameGraphics.drawText("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            gameGraphics.drawText("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(dhf)
        {
            gameGraphics.drawText("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            gameGraphics.drawText("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < inventoryItemsCount; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            gameGraphics.drawImage(l5, j6, 48, 32, baseItemPicture + Data.itemInventoryPicture[inventoryItems[k5]], Data.itemPictureMask[inventoryItems[k5]], 0, 0, false);
            if(Data.itemStackable[inventoryItems[k5]] == 0)
                gameGraphics.drawString(String.valueOf(inventoryItemCount[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < ded; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            gameGraphics.drawImage(k6, i7, 48, 32, baseItemPicture + Data.itemInventoryPicture[dee[i6]], Data.itemPictureMask[dee[i6]], 0, 0, false);
            if(Data.itemStackable[dee[i6]] == 0)
                gameGraphics.drawString(String.valueOf(def[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > i7 && super.mouseY < i7 + 32)
                gameGraphics.drawString(Data.itemName[dee[i6]] + ": @whi@" + Data.itemDescription[dee[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < dkl; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 124 + byte1 + (l6 / 4) * 34;
            gameGraphics.drawImage(j7, k7, 48, 32, baseItemPicture + Data.itemInventoryPicture[dkm[l6]], Data.itemPictureMask[dkm[l6]], 0, 0, false);
            if(Data.itemStackable[dkm[l6]] == 0)
                gameGraphics.drawString(String.valueOf(dkn[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.mouseX > j7 && super.mouseX < j7 + 48 && super.mouseY > k7 && super.mouseY < k7 + 32)
                gameGraphics.drawString(Data.itemName[dkm[l6]] + ": @whi@" + Data.itemDescription[dkm[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void fdc()
    {
        int l = 97;
        gameGraphics.drawBox(86, 77, 340, 180, 0);
        gameGraphics.drawBoxEdge(86, 77, 340, 180, 0xffffff);
        gameGraphics.drawText("Warning! Proceed with caution", 256, l, 4, 0xff0000);
        l += 26;
        gameGraphics.drawText("If you go much further north you will enter the", 256, l, 1, 0xffffff);
        l += 13;
        gameGraphics.drawText("wilderness. This a very dangerous area where", 256, l, 1, 0xffffff);
        l += 13;
        gameGraphics.drawText("other players can attack you!", 256, l, 1, 0xffffff);
        l += 22;
        gameGraphics.drawText("The further north you go the more dangerous it", 256, l, 1, 0xffffff);
        l += 13;
        gameGraphics.drawText("becomes, but the more treasure you will find.", 256, l, 1, 0xffffff);
        l += 22;
        gameGraphics.drawText("In the wilderness an indicator at the bottom-right", 256, l, 1, 0xffffff);
        l += 13;
        gameGraphics.drawText("of the screen will show the current level of danger", 256, l, 1, 0xffffff);
        l += 22;
        int i1 = 0xffffff;
        if(super.mouseY > l - 12 && super.mouseY <= l && super.mouseX > 181 && super.mouseX < 331)
            i1 = 0xff0000;
        gameGraphics.drawText("Click here to close window", 256, l, 1, i1);
        if(mouseButtonClick != 0)
        {
            if(super.mouseY > l - 12 && super.mouseY <= l && super.mouseX > 181 && super.mouseX < 331)
                dme = 2;
            if(super.mouseX < 86 || super.mouseX > 426 || super.mouseY < 77 || super.mouseY > 257)
                dme = 2;
            mouseButtonClick = 0;
        }
    }

    final void fdd(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        Mob f1 = npcArray[arg4];
        int l = f1.currentSprite + (cameraRotation + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;
        if(i1 == 5)
        {
            i1 = 3;
            flag = true;
        } else
        if(i1 == 6)
        {
            i1 = 2;
            flag = true;
        } else
        if(i1 == 7)
        {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + dhn[(f1.stepCount / Data.akl[f1.gmj]) % 4];
        if(f1.currentSprite == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (Data.akn[f1.gmj] * arg6) / 100;
            j1 = i1 * 3 + eme[(tick / (Data.akm[f1.gmj] - 1)) % 8];
        } else
        if(f1.currentSprite == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (Data.akn[f1.gmj] * arg6) / 100;
            j1 = i1 * 3 + eab[(tick / Data.akm[f1.gmj]) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = dgl[l][k1];
            int k2 = Data.ala[f1.gmj][l1];
            if(k2 >= 0)
            {
                int i3 = 0;
                int j3 = 0;
                int k3 = j1;
                if(flag && i1 >= 1 && i1 <= 3 && Data.animationHasF[k2] == 1)
                    k3 += 15;
                if(i1 != 5 || Data.animationHasA[k2] == 1)
                {
                    int l3 = k3 + Data.animationNumber[k2];
                    i3 = (i3 * arg2) / ((GameImage) (gameGraphics)).bmj[l3];
                    j3 = (j3 * arg3) / ((GameImage) (gameGraphics)).bmk[l3];
                    int i4 = (arg2 * ((GameImage) (gameGraphics)).bmj[l3]) / ((GameImage) (gameGraphics)).bmj[Data.animationNumber[k2]];
                    i3 -= (i4 - arg2) / 2;
                    int j4 = Data.alh[k2];
                    int k4 = 0;
                    if(j4 == 1)
                    {
                        j4 = Data.ajc[f1.gmj];
                        k4 = Data.ajf[f1.gmj];
                    } else
                    if(j4 == 2)
                    {
                        j4 = Data.ajd[f1.gmj];
                        k4 = Data.ajf[f1.gmj];
                    } else
                    if(j4 == 3)
                    {
                        j4 = Data.aje[f1.gmj];
                        k4 = Data.ajf[f1.gmj];
                    }
                    gameGraphics.drawImage(arg0 + i3, arg1 + j3, i4, arg3, l3, j4, k4, arg5, flag);
                }
            }
        }

        if(f1.lastMessageTimeout > 0)
        {
            eaf[egg] = gameGraphics.textWidth(f1.gne, 1) / 2;
            if(eaf[egg] > 150)
                eaf[egg] = 150;
            eag[egg] = (gameGraphics.textWidth(f1.gne, 1) / 300) * gameGraphics.ced(1);
            ead[egg] = arg0 + arg2 / 2;
            eae[egg] = arg1;
            egh[egg++] = f1.gne;
        }
        if(f1.currentSprite == 8 || f1.currentSprite == 9 || f1.combatTimer != 0)
        {
            if(f1.combatTimer > 0)
            {
                int i2 = arg0;
                if(f1.currentSprite == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.currentSprite == 9)
                    i2 += (20 * arg6) / 100;
                int l2 = (f1.gnj * 30) / f1.gnk;
                ekj[ejl] = i2 + arg2 / 2;
                ekk[ejl] = arg1;
                ekl[ejl++] = l2;
            }
            if(f1.combatTimer > 150)
            {
                int j2 = arg0;
                if(f1.currentSprite == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.currentSprite == 9)
                    j2 += (10 * arg6) / 100;
                gameGraphics.drawPicture((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, baseInventoryPic + 12);
                gameGraphics.drawText(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
    }

    protected final void handleServerMessage(String s1)
    {
        if(s1.startsWith("@bor@"))
        {
            displayMessage(s1, 4);
            return;
        }
        if(s1.startsWith("@que@"))
        {
            displayMessage("@whi@" + s1, 5);
            return;
        }
        if(s1.startsWith("@pri@"))
        {
            displayMessage(s1, 6);
            return;
        } else
        {
            displayMessage(s1, 3);
            return;
        }
    }

    private final void fde()
    {
        for(int l = 0; l < egg; l++)
        {
            int i1 = gameGraphics.ced(1);
            int k1 = ead[l];
            int j2 = eae[l];
            int i3 = eaf[l];
            int l3 = eag[l];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int l4 = 0; l4 < l; l4++)
                    if(j2 + l3 > eae[l4] - i1 && j2 - i1 < eae[l4] + eag[l4] && k1 - i3 < ead[l4] + eaf[l4] && k1 + i3 > ead[l4] - eaf[l4] && eae[l4] - i1 - l3 < j2)
                    {
                        j2 = eae[l4] - i1 - l3;
                        flag = true;
                    }

            }
            eae[l] = j2;
            gameGraphics.cdm(egh[l], k1, j2, 1, 0xffff00, 300);
        }

        for(int j1 = 0; j1 < dib; j1++)
        {
            int l1 = ebk[j1];
            int k2 = ebl[j1];
            int j3 = dfi[j1];
            int i4 = dfj[j1];
            int k4 = (39 * j3) / 100;
            int i5 = (27 * j3) / 100;
            int j5 = k2 - i5;
            gameGraphics.cce(l1 - k4 / 2, j5, k4, i5, baseInventoryPic + 9, 85);
            int k5 = (36 * j3) / 100;
            int l5 = (24 * j3) / 100;
            gameGraphics.drawImage(l1 - k5 / 2, (j5 + i5 / 2) - l5 / 2, k5, l5, Data.itemInventoryPicture[i4] + baseItemPicture, Data.itemPictureMask[i4], 0, 0, false);
        }

        for(int i2 = 0; i2 < ejl; i2++)
        {
            int l2 = ekj[i2];
            int k3 = ekk[i2];
            int j4 = ekl[i2];
            gameGraphics.drawBoxAlpha(l2 - 15, k3 - 3, j4, 5, 65280, 192);
            gameGraphics.drawBoxAlpha((l2 - 15) + j4, k3 - 3, 30 - j4, 5, 0xff0000, 192);
        }

    }

    protected final void cantLogout()
    {
        logoutTimer = 0;
        displayMessage("@cya@Sorry, you can't logout at the moment", 3);
    }

    private final void fdf()
    {
        char c1 = '\u0198';
        char c2 = '\u014E';
        if(ekf > 0 && elm <= 48)
            ekf = 0;
        if(ekf > 1 && elm <= 96)
            ekf = 1;
        if(ekf > 2 && elm <= 144)
            ekf = 2;
        if(ecj >= elm || ecj < 0)
            ecj = -1;
        if(ecj != -1 && eam[ecj] != eck)
        {
            ecj = -1;
            eck = -2;
        }
        if(mouseButtonClick != 0)
        {
            mouseButtonClick = 0;
            int l = super.mouseX - (256 - c1 / 2);
            int j1 = super.mouseY - (170 - c2 / 2);
            if(l >= 0 && j1 >= 12 && l < 408 && j1 < 280)
            {
                int l1 = ekf * 48;
                for(int k2 = 0; k2 < 6; k2++)
                {
                    for(int i3 = 0; i3 < 8; i3++)
                    {
                        int k7 = 7 + i3 * 49;
                        int i8 = 28 + k2 * 34;
                        if(l > k7 && l < k7 + 49 && j1 > i8 && j1 < i8 + 34 && l1 < elm && eam[l1] != -1)
                        {
                            eck = eam[l1];
                            ecj = l1;
                        }
                        l1++;
                    }

                }

                l = 256 - c1 / 2;
                j1 = 170 - c2 / 2;
                int j3;
                if(ecj < 0)
                    j3 = -1;
                else
                    j3 = eam[ecj];
                if(j3 != -1)
                {
                    int i2 = ean[ecj];
                    if(Data.itemStackable[j3] == 1 && i2 > 1)
                        i2 = 1;
                    if(i2 >= 1 && super.mouseX >= l + 220 && super.mouseY >= j1 + 238 && super.mouseX < l + 250 && super.mouseY <= j1 + 249)
                    {
                        super.streamClass.createPacket(131);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(1);
                        super.streamClass.formatPacket();
                    }
                    if(i2 >= 5 && super.mouseX >= l + 250 && super.mouseY >= j1 + 238 && super.mouseX < l + 280 && super.mouseY <= j1 + 249)
                    {
                        super.streamClass.createPacket(131);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(5);
                        super.streamClass.formatPacket();
                    }
                    if(i2 >= 25 && super.mouseX >= l + 280 && super.mouseY >= j1 + 238 && super.mouseX < l + 305 && super.mouseY <= j1 + 249)
                    {
                        super.streamClass.createPacket(131);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(25);
                        super.streamClass.formatPacket();
                    }
                    if(i2 >= 100 && super.mouseX >= l + 305 && super.mouseY >= j1 + 238 && super.mouseX < l + 335 && super.mouseY <= j1 + 249)
                    {
                        super.streamClass.createPacket(131);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(100);
                        super.streamClass.formatPacket();
                    }
                    if(i2 >= 500 && super.mouseX >= l + 335 && super.mouseY >= j1 + 238 && super.mouseX < l + 368 && super.mouseY <= j1 + 249)
                    {
                        super.streamClass.createPacket(131);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(500);
                        super.streamClass.formatPacket();
                    }
                    if(i2 >= 2500 && super.mouseX >= l + 370 && super.mouseY >= j1 + 238 && super.mouseX < l + 400 && super.mouseY <= j1 + 249)
                    {
                        super.streamClass.createPacket(131);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(2500);
                        super.streamClass.formatPacket();
                    }
                    if(getInventoryItemTotalCount(j3) >= 1 && super.mouseX >= l + 220 && super.mouseY >= j1 + 263 && super.mouseX < l + 250 && super.mouseY <= j1 + 274)
                    {
                        super.streamClass.createPacket(190);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(1);
                        super.streamClass.formatPacket();
                    }
                    if(getInventoryItemTotalCount(j3) >= 5 && super.mouseX >= l + 250 && super.mouseY >= j1 + 263 && super.mouseX < l + 280 && super.mouseY <= j1 + 274)
                    {
                        super.streamClass.createPacket(190);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(5);
                        super.streamClass.formatPacket();
                    }
                    if(getInventoryItemTotalCount(j3) >= 25 && super.mouseX >= l + 280 && super.mouseY >= j1 + 263 && super.mouseX < l + 305 && super.mouseY <= j1 + 274)
                    {
                        super.streamClass.createPacket(190);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(25);
                        super.streamClass.formatPacket();
                    }
                    if(getInventoryItemTotalCount(j3) >= 100 && super.mouseX >= l + 305 && super.mouseY >= j1 + 263 && super.mouseX < l + 335 && super.mouseY <= j1 + 274)
                    {
                        super.streamClass.createPacket(190);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(100);
                        super.streamClass.formatPacket();
                    }
                    if(getInventoryItemTotalCount(j3) >= 500 && super.mouseX >= l + 335 && super.mouseY >= j1 + 263 && super.mouseX < l + 368 && super.mouseY <= j1 + 274)
                    {
                        super.streamClass.createPacket(190);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(500);
                        super.streamClass.formatPacket();
                    }
                    if(getInventoryItemTotalCount(j3) >= 2500 && super.mouseX >= l + 370 && super.mouseY >= j1 + 263 && super.mouseX < l + 400 && super.mouseY <= j1 + 274)
                    {
                        super.streamClass.createPacket(190);
                        super.streamClass.addShort(j3);
                        super.streamClass.addShort(2500);
                        super.streamClass.formatPacket();
                    }
                }
            } else
            if(elm > 48 && l >= 50 && l <= 115 && j1 <= 12)
                ekf = 0;
            else
            if(elm > 48 && l >= 115 && l <= 180 && j1 <= 12)
                ekf = 1;
            else
            if(elm > 96 && l >= 180 && l <= 245 && j1 <= 12)
                ekf = 2;
            else
            if(elm > 144 && l >= 245 && l <= 310 && j1 <= 12)
            {
                ekf = 3;
            } else
            {
                super.streamClass.createPacket(78);
                super.streamClass.formatPacket();
                showBankBox = false;
                return;
            }
        }
        int i1 = 256 - c1 / 2;
        int k1 = 170 - c2 / 2;
        gameGraphics.drawBox(i1, k1, 408, 12, 192);
        int j2 = 0x989898;
        gameGraphics.drawBoxAlpha(i1, k1 + 12, 408, 17, j2, 160);
        gameGraphics.drawBoxAlpha(i1, k1 + 29, 8, 204, j2, 160);
        gameGraphics.drawBoxAlpha(i1 + 399, k1 + 29, 9, 204, j2, 160);
        gameGraphics.drawBoxAlpha(i1, k1 + 233, 408, 47, j2, 160);
        gameGraphics.drawString("Bank", i1 + 1, k1 + 10, 1, 0xffffff);
        int l2 = 50;
        if(elm > 48)
        {
            int k3 = 0xffffff;
            if(ekf == 0)
                k3 = 0xff0000;
            else
            if(super.mouseX > i1 + l2 && super.mouseY >= k1 && super.mouseX < i1 + l2 + 65 && super.mouseY < k1 + 12)
                k3 = 0xffff00;
            gameGraphics.drawString("<page 1>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
            k3 = 0xffffff;
            if(ekf == 1)
                k3 = 0xff0000;
            else
            if(super.mouseX > i1 + l2 && super.mouseY >= k1 && super.mouseX < i1 + l2 + 65 && super.mouseY < k1 + 12)
                k3 = 0xffff00;
            gameGraphics.drawString("<page 2>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
        }
        if(elm > 96)
        {
            int l3 = 0xffffff;
            if(ekf == 2)
                l3 = 0xff0000;
            else
            if(super.mouseX > i1 + l2 && super.mouseY >= k1 && super.mouseX < i1 + l2 + 65 && super.mouseY < k1 + 12)
                l3 = 0xffff00;
            gameGraphics.drawString("<page 3>", i1 + l2, k1 + 10, 1, l3);
            l2 += 65;
        }
        if(elm > 144)
        {
            int i4 = 0xffffff;
            if(ekf == 3)
                i4 = 0xff0000;
            else
            if(super.mouseX > i1 + l2 && super.mouseY >= k1 && super.mouseX < i1 + l2 + 65 && super.mouseY < k1 + 12)
                i4 = 0xffff00;
            gameGraphics.drawString("<page 4>", i1 + l2, k1 + 10, 1, i4);
            l2 += 65;
        }
        int j4 = 0xffffff;
        if(super.mouseX > i1 + 320 && super.mouseY >= k1 && super.mouseX < i1 + 408 && super.mouseY < k1 + 12)
            j4 = 0xff0000;
        gameGraphics.cdk("Close window", i1 + 406, k1 + 10, 1, j4);
        gameGraphics.drawString("Number in bank in green", i1 + 7, k1 + 24, 1, 65280);
        gameGraphics.drawString("Number held in blue", i1 + 289, k1 + 24, 1, 65535);
        int l7 = 0xd0d0d0;
        int j8 = ekf * 48;
        for(int l8 = 0; l8 < 6; l8++)
        {
            for(int i9 = 0; i9 < 8; i9++)
            {
                int k9 = i1 + 7 + i9 * 49;
                int l9 = k1 + 28 + l8 * 34;
                if(ecj == j8)
                    gameGraphics.drawBoxAlpha(k9, l9, 49, 34, 0xff0000, 160);
                else
                    gameGraphics.drawBoxAlpha(k9, l9, 49, 34, l7, 160);
                gameGraphics.drawBoxEdge(k9, l9, 50, 35, 0);
                if(j8 < elm && eam[j8] != -1)
                {
                    gameGraphics.drawImage(k9, l9, 48, 32, baseItemPicture + Data.itemInventoryPicture[eam[j8]], Data.itemPictureMask[eam[j8]], 0, 0, false);
                    gameGraphics.drawString(String.valueOf(ean[j8]), k9 + 1, l9 + 10, 1, 65280);
                    gameGraphics.cdk(String.valueOf(getInventoryItemTotalCount(eam[j8])), k9 + 47, l9 + 29, 1, 65535);
                }
                j8++;
            }

        }

        gameGraphics.drawLineX(i1 + 5, k1 + 256, 398, 0);
        if(ecj == -1)
        {
            gameGraphics.drawText("Select an object to withdraw or deposit", i1 + 204, k1 + 248, 3, 0xffff00);
            return;
        }
        int j9;
        if(ecj < 0)
            j9 = -1;
        else
            j9 = eam[ecj];
        if(j9 != -1)
        {
            int k8 = ean[ecj];
            if(Data.itemStackable[j9] == 1 && k8 > 1)
                k8 = 1;
            if(k8 > 0)
            {
                gameGraphics.drawString("Withdraw " + Data.itemName[j9], i1 + 2, k1 + 248, 1, 0xffffff);
                int k4 = 0xffffff;
                if(super.mouseX >= i1 + 220 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 250 && super.mouseY <= k1 + 249)
                    k4 = 0xff0000;
                gameGraphics.drawString("One", i1 + 222, k1 + 248, 1, k4);
                if(k8 >= 5)
                {
                    int l4 = 0xffffff;
                    if(super.mouseX >= i1 + 250 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 280 && super.mouseY <= k1 + 249)
                        l4 = 0xff0000;
                    gameGraphics.drawString("Five", i1 + 252, k1 + 248, 1, l4);
                }
                if(k8 >= 25)
                {
                    int i5 = 0xffffff;
                    if(super.mouseX >= i1 + 280 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 305 && super.mouseY <= k1 + 249)
                        i5 = 0xff0000;
                    gameGraphics.drawString("25", i1 + 282, k1 + 248, 1, i5);
                }
                if(k8 >= 100)
                {
                    int j5 = 0xffffff;
                    if(super.mouseX >= i1 + 305 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 335 && super.mouseY <= k1 + 249)
                        j5 = 0xff0000;
                    gameGraphics.drawString("100", i1 + 307, k1 + 248, 1, j5);
                }
                if(k8 >= 500)
                {
                    int k5 = 0xffffff;
                    if(super.mouseX >= i1 + 335 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 368 && super.mouseY <= k1 + 249)
                        k5 = 0xff0000;
                    gameGraphics.drawString("500", i1 + 337, k1 + 248, 1, k5);
                }
                if(k8 >= 2500)
                {
                    int l5 = 0xffffff;
                    if(super.mouseX >= i1 + 370 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 400 && super.mouseY <= k1 + 249)
                        l5 = 0xff0000;
                    gameGraphics.drawString("2500", i1 + 370, k1 + 248, 1, l5);
                }
            }
            if(getInventoryItemTotalCount(j9) > 0)
            {
                gameGraphics.drawString("Deposit " + Data.itemName[j9], i1 + 2, k1 + 273, 1, 0xffffff);
                int i6 = 0xffffff;
                if(super.mouseX >= i1 + 220 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 250 && super.mouseY <= k1 + 274)
                    i6 = 0xff0000;
                gameGraphics.drawString("One", i1 + 222, k1 + 273, 1, i6);
                if(getInventoryItemTotalCount(j9) >= 5)
                {
                    int j6 = 0xffffff;
                    if(super.mouseX >= i1 + 250 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 280 && super.mouseY <= k1 + 274)
                        j6 = 0xff0000;
                    gameGraphics.drawString("Five", i1 + 252, k1 + 273, 1, j6);
                }
                if(getInventoryItemTotalCount(j9) >= 25)
                {
                    int k6 = 0xffffff;
                    if(super.mouseX >= i1 + 280 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 305 && super.mouseY <= k1 + 274)
                        k6 = 0xff0000;
                    gameGraphics.drawString("25", i1 + 282, k1 + 273, 1, k6);
                }
                if(getInventoryItemTotalCount(j9) >= 100)
                {
                    int l6 = 0xffffff;
                    if(super.mouseX >= i1 + 305 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 335 && super.mouseY <= k1 + 274)
                        l6 = 0xff0000;
                    gameGraphics.drawString("100", i1 + 307, k1 + 273, 1, l6);
                }
                if(getInventoryItemTotalCount(j9) >= 500)
                {
                    int i7 = 0xffffff;
                    if(super.mouseX >= i1 + 335 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 368 && super.mouseY <= k1 + 274)
                        i7 = 0xff0000;
                    gameGraphics.drawString("500", i1 + 337, k1 + 273, 1, i7);
                }
                if(getInventoryItemTotalCount(j9) >= 2500)
                {
                    int j7 = 0xffffff;
                    if(super.mouseX >= i1 + 370 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 400 && super.mouseY <= k1 + 274)
                        j7 = 0xff0000;
                    gameGraphics.drawString("2500", i1 + 370, k1 + 273, 1, j7);
                }
            }
        }
    }

    public final Graphics getGraphics()
    {
        if(GameApplet.gameFrame != null)
            return GameApplet.gameFrame.getGraphics();
        if(link.gameApplet != null)
            return link.gameApplet.getGraphics();
        else
            return super.getGraphics();
    }

    private final boolean fdg(int arg0, int arg1)
    {
        if(playerAliveTimeout != 0)
        {
            engineHandle.gii = false;
            return false;
        }
        elk = false;
        arg0 += eai;
        arg1 += eaj;
        if(eal == dnk && arg0 > ega && arg0 < egc && arg1 > egb && arg1 < egd)
        {
            engineHandle.gii = true;
            return false;
        }
        gameGraphics.drawText("Loading... Please wait", 256, 192, 1, 0xffffff);
        drawChatMessageTabs();
        gameGraphics.drawImage(graphics, 0, 0);
        int l = areaX;
        int i1 = areaY;
        int j1 = (arg0 + 24) / 48;
        int k1 = (arg1 + 24) / 48;
        eal = dnk;
        areaX = j1 * 48 - 48;
        areaY = k1 * 48 - 48;
        ega = j1 * 48 - 32;
        egb = k1 * 48 - 32;
        egc = j1 * 48 + 32;
        egd = k1 * 48 + 32;
        engineHandle.gjj(arg0, arg1, eal);
        areaX -= eai;
        areaY -= eaj;
        int l1 = areaX - l;
        int i2 = areaY - i1;
        for(int j2 = 0; j2 < objectCount; j2++)
        {
            objectX[j2] -= l1;
            objectY[j2] -= i2;
            int k2 = objectX[j2];
            int i3 = objectY[j2];
            int l3 = objectID[j2];
            i k4 = objectArray[j2];
            try
            {
                int j5 = elb[j2];
                int i6;
                int l6;
                if(j5 == 0 || j5 == 4)
                {
                    i6 = Data.objectWidth[l3];
                    l6 = Data.objectHeight[l3];
                } else
                {
                    l6 = Data.objectWidth[l3];
                    i6 = Data.objectHeight[l3];
                }
                int i7 = ((k2 + k2 + i6) * magicLoc) / 2;
                int j7 = ((i3 + i3 + l6) * magicLoc) / 2;
                if(k2 >= 0 && i3 >= 0 && k2 < 96 && i3 < 96)
                {
                    gameCamera.bgm(k4);
                    k4.cml(i7, -engineHandle.gjf(i7, j7), j7);
                    engineHandle.gla(k2, i3, l3);
                    if(l3 == 74)
                        k4.cmk(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + j2 + " obj:" + k4);
                runtimeexception.printStackTrace();
            }
        }

        for(int l2 = 0; l2 < wallObjectCount; l2++)
        {
            wallObjectX[l2] -= l1;
            wallObjectY[l2] -= i2;
            int j3 = wallObjectX[l2];
            int i4 = wallObjectY[l2];
            int l4 = wallObjectID[l2];
            int k5 = wallObjectDirection[l2];
            try
            {
                engineHandle.gkc(j3, i4, k5, l4);
                i j6 = fdm(j3, i4, k5, l4, l2);
                wallObjectArray[l2] = j6;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int k3 = 0; k3 < groundItemCount; k3++)
        {
            dml[k3] -= l1;
            dmm[k3] -= i2;
        }

        for(int j4 = 0; j4 < playerCount; j4++)
        {
            Mob f1 = playerArray[j4];
            f1.currentX -= l1 * magicLoc;
            f1.currentY -= i2 * magicLoc;
            for(int l5 = 0; l5 <= f1.waypointCurrent; l5++)
            {
                f1.waypointsX[l5] -= l1 * magicLoc;
                f1.waypointsY[l5] -= i2 * magicLoc;
            }

        }

        for(int i5 = 0; i5 < npcCount; i5++)
        {
            Mob f2 = npcArray[i5];
            f2.currentX -= l1 * magicLoc;
            f2.currentY -= i2 * magicLoc;
            for(int k6 = 0; k6 <= f2.waypointCurrent; k6++)
            {
                f2.waypointsX[k6] -= l1 * magicLoc;
                f2.waypointsY[k6] -= i2 * magicLoc;
            }

        }

        engineHandle.gii = true;
        return true;
    }

    private static final String formatItemCount(int arg0)
    {
        String s1 = String.valueOf(arg0);
        for(int l = s1.length() - 3; l > 0; l -= 3)
            s1 = s1.substring(0, l) + "," + s1.substring(l);

        if(s1.length() > 8)
            s1 = "@gre@" + s1.substring(0, s1.length() - 8) + " million @whi@(" + s1 + ")";
        else
        if(s1.length() > 4)
            s1 = "@cya@" + s1.substring(0, s1.length() - 4) + "K @whi@(" + s1 + ")";
        return s1;
    }

    private final boolean hasRequiredRunes(int l, int i1)
    {
        if(l == 31 && (isItemEquipped(197) || isItemEquipped(615) || isItemEquipped(682)))
            return true;
        if(l == 32 && (isItemEquipped(102) || isItemEquipped(616) || isItemEquipped(683)))
            return true;
        if(l == 33 && (isItemEquipped(101) || isItemEquipped(617) || isItemEquipped(684)))
            return true;
        if(l == 34 && (isItemEquipped(103) || isItemEquipped(618) || isItemEquipped(685)))
            return true;
        return getInventoryItemTotalCount(l) >= i1;
    }

    private final void displayMessage(String arg0, int arg1)
    {
        if(arg1 == 2 || arg1 == 4 || arg1 == 6)
        {
            for(; arg0.length() > 5 && arg0.charAt(0) == '@' && arg0.charAt(4) == '@'; arg0 = arg0.substring(5));
            int l = arg0.indexOf(":");
            if(l != -1)
            {
                String s1 = arg0.substring(0, l);
                long l1 = DataOperations.nameToHash(s1);
                for(int j1 = 0; j1 < super.ignoresCount; j1++)
                    if(super.ignoresList[j1] == l1)
                        return;

            }
        }
        if(arg1 == 2)
            arg0 = "@yel@" + arg0;
        if(arg1 == 3 || arg1 == 4)
            arg0 = "@whi@" + arg0;
        if(arg1 == 6)
            arg0 = "@cya@" + arg0;
        if(dea != 0)
        {
            if(arg1 == 4 || arg1 == 3)
                chatTabAllMsgFlash = 200;
            if(arg1 == 2 && dea != 1)
                chatTabHistoryFlash = 200;
            if(arg1 == 5 && dea != 2)
                chatTabQuestFlash = 200;
            if(arg1 == 6 && dea != 3)
                chatTabPrivateFlash = 200;
            if(arg1 == 3 && dea != 0)
                dea = 0;
            if(arg1 == 6 && dea != 3 && dea != 0)
                dea = 0;
        }
        for(int i1 = 4; i1 > 0; i1--)
        {
            die[i1] = die[i1 - 1];
            eib[i1] = eib[i1 - 1];
        }

        die[0] = arg0;
        eib[0] = 300;
        if(arg1 == 2)
            if(chatInputMenu.gbc[messagesHandleType2] == chatInputMenu.gbd[messagesHandleType2] - 4)
                chatInputMenu.ggb(messagesHandleType2, arg0, true);
            else
                chatInputMenu.ggb(messagesHandleType2, arg0, false);
        if(arg1 == 5)
            if(chatInputMenu.gbc[messagesHandleType5] == chatInputMenu.gbd[messagesHandleType5] - 4)
                chatInputMenu.ggb(messagesHandleType5, arg0, true);
            else
                chatInputMenu.ggb(messagesHandleType5, arg0, false);
        if(arg1 == 6)
        {
            if(chatInputMenu.gbc[messagesHandleType6] == chatInputMenu.gbd[messagesHandleType6] - 4)
            {
                chatInputMenu.ggb(messagesHandleType6, arg0, true);
                return;
            }
            chatInputMenu.ggb(messagesHandleType6, arg0, false);
        }
    }

    private final void drawMinimapObject(int l, int i1, int j1)
    {
        gameGraphics.cbe(l, i1, j1);
        gameGraphics.cbe(l - 1, i1, j1);
        gameGraphics.cbe(l + 1, i1, j1);
        gameGraphics.cbe(l, i1 - 1, j1);
        gameGraphics.cbe(l, i1 + 1, j1);
    }

    private final void fdl()
    {
        char c1 = '\u0190';
        char c2 = 'd';
        if(dhi)
        {
            c2 = '\u01C2';
            c2 = '\u012C';
        }
        gameGraphics.drawBox(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0);
        gameGraphics.drawBoxEdge(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0xffffff);
        gameGraphics.cdm(dhc, 256, (167 - c2 / 2) + 20, 1, 0xffffff, c1 - 40);
        int l = 157 + c2 / 2;
        int i1 = 0xffffff;
        if(super.mouseY > l - 12 && super.mouseY <= l && super.mouseX > 106 && super.mouseX < 406)
            i1 = 0xff0000;
        gameGraphics.drawText("Click here to close window", 256, l, 1, i1);
        if(mouseButtonClick == 1)
        {
            if(i1 == 0xff0000)
                ecc = false;
            if((super.mouseX < 256 - c1 / 2 || super.mouseX > 256 + c1 / 2) && (super.mouseY < 167 - c2 / 2 || super.mouseY > 167 + c2 / 2))
                ecc = false;
        }
        mouseButtonClick = 0;
    }

    public final Image createImage(int l, int i1)
    {
        if(GameApplet.gameFrame != null)
            return GameApplet.gameFrame.createImage(l, i1);
        if(link.gameApplet != null)
            return link.gameApplet.createImage(l, i1);
        else
            return super.createImage(l, i1);
    }

    private final i fdm(int l, int i1, int j1, int k1, int l1)
    {
        int i2 = l;
        int j2 = i1;
        int k2 = l;
        int l2 = i1;
        int i3 = Data.amn[k1];
        int j3 = Data.ana[k1];
        int k3 = Data.amm[k1];
        i l3 = new i(4, 1);
        if(j1 == 0)
            k2 = l + 1;
        if(j1 == 1)
            l2 = i1 + 1;
        if(j1 == 2)
        {
            i2 = l + 1;
            l2 = i1 + 1;
        }
        if(j1 == 3)
        {
            k2 = l + 1;
            l2 = i1 + 1;
        }
        i2 *= magicLoc;
        j2 *= magicLoc;
        k2 *= magicLoc;
        l2 *= magicLoc;
        int i4 = l3.cln(i2, -engineHandle.gjf(i2, j2), j2);
        int j4 = l3.cln(i2, -engineHandle.gjf(i2, j2) - k3, j2);
        int k4 = l3.cln(k2, -engineHandle.gjf(k2, l2) - k3, l2);
        int l4 = l3.cln(k2, -engineHandle.gjf(k2, l2), l2);
        int ai[] = {
            i4, j4, k4, l4
        };
        l3.cmb(4, ai, i3, j3);
        l3.cme(false, 60, 24, -50, -10, -50);
        if(l >= 0 && i1 >= 0 && l < 96 && i1 < 96)
            gameCamera.bgm(l3);
        l3.chk = l1 + 10000;
        return l3;
    }

    private final void resetPrivateMessages()
    {
        super.pmText = "";
        super.enteredPMText = "";
    }

    private final Mob fea(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        if(npcAttackingArray[arg0] == null)
        {
            npcAttackingArray[arg0] = new Mob();
            npcAttackingArray[arg0].serverIndex = arg0;
        }
        Mob f1 = npcAttackingArray[arg0];
        boolean flag = false;
        for(int l = 0; l < ebc; l++)
        {
            if(edc[l].serverIndex != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.gmj = arg4;
            f1.nextSprite = arg3;
            int i1 = f1.waypointCurrent;
            if(arg1 != f1.waypointsX[i1] || arg2 != f1.waypointsY[i1])
            {
                f1.waypointCurrent = i1 = (i1 + 1) % 10;
                f1.waypointsX[i1] = arg1;
                f1.waypointsY[i1] = arg2;
            }
        } else
        {
            f1.serverIndex = arg0;
            f1.waypointsEndSprite = 0;
            f1.waypointCurrent = 0;
            f1.waypointsX[0] = f1.currentX = arg1;
            f1.waypointsY[0] = f1.currentY = arg2;
            f1.gmj = arg4;
            f1.nextSprite = f1.currentSprite = arg3;
            f1.stepCount = 0;
        }
        npcArray[npcCount++] = f1;
        return f1;
    }

    private final void feb()
    {
        elm = elg;
        for(int l = 0; l < elg; l++)
        {
            eam[l] = dmi[l];
            ean[l] = dmj[l];
        }

        for(int i1 = 0; i1 < inventoryItemsCount; i1++)
        {
            if(elm >= dnc)
                break;
            int j1 = inventoryItems[i1];
            boolean flag = false;
            for(int k1 = 0; k1 < elm; k1++)
            {
                if(eam[k1] != j1)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                eam[elm] = j1;
                ean[elm] = 0;
                elm++;
            }
        }

    }

    private final void fec(boolean arg0)
    {
        int l = ((GameImage) (gameGraphics)).gameWidth - 199;
        int i1 = 36;
        gameGraphics.drawPicture(l - 49, 3, baseInventoryPic + 3);
        char c1 = '\304';
        char c2 = '\u0113';
        int k1;
        int j1 = k1 = GameImage.rgbToInt(160, 160, 160);
        if(dii == 0)
            j1 = GameImage.rgbToInt(220, 220, 220);
        else
            k1 = GameImage.rgbToInt(220, 220, 220);
        gameGraphics.drawBoxAlpha(l, i1, c1 / 2, 24, j1, 128);
        gameGraphics.drawBoxAlpha(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        gameGraphics.drawBoxAlpha(l, i1 + 24, c1, c2 - 24, GameImage.rgbToInt(220, 220, 220), 128);
        gameGraphics.drawLineX(l, i1 + 24, c1, 0);
        gameGraphics.drawLineY(l + c1 / 2, i1, 24, 0);
        gameGraphics.drawText("Stats", l + c1 / 4, i1 + 16, 4, 0);
        gameGraphics.drawText("Quests", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(dii == 0)
        {
            int l1 = 72;
            int j2 = -1;
            gameGraphics.drawString("Skills", l + 5, l1, 3, 0xffff00);
            l1 += 13;
            for(int k2 = 0; k2 < 9; k2++)
            {
                int l2 = 0xffffff;
                if(super.mouseX > l + 3 && super.mouseY >= l1 - 11 && super.mouseY < l1 + 2 && super.mouseX < l + 90)
                {
                    l2 = 0xff0000;
                    j2 = k2;
                }
                gameGraphics.drawString(eba[k2] + ":@yel@" + playerStatCurrent[k2] + "/" + playerStatBase[k2], l + 5, l1, 1, l2);
                l2 = 0xffffff;
                if(super.mouseX >= l + 90 && super.mouseY >= l1 - 13 - 11 && super.mouseY < (l1 - 13) + 2 && super.mouseX < l + 196)
                {
                    l2 = 0xff0000;
                    j2 = k2 + 9;
                }
                gameGraphics.drawString(eba[k2 + 9] + ":@yel@" + playerStatCurrent[k2 + 9] + "/" + playerStatBase[k2 + 9], (l + c1 / 2) - 5, l1 - 13, 1, l2);
                l1 += 13;
            }

            gameGraphics.drawString("Quest Points:@yel@" + ema, (l + c1 / 2) - 5, l1 - 13, 1, 0xffffff);
            l1 += 12;
            gameGraphics.drawString("Fatigue: @yel@" + (dhj * 100) / 750 + "%", l + 5, l1 - 13, 1, 0xffffff);
            l1 += 8;
            gameGraphics.drawString("Equipment Status", l + 5, l1, 3, 0xffff00);
            l1 += 12;
            for(int i3 = 0; i3 < 3; i3++)
            {
                gameGraphics.drawString(eha[i3] + ":@yel@" + ege[i3], l + 5, l1, 1, 0xffffff);
                if(i3 < 2)
                    gameGraphics.drawString(eha[i3 + 3] + ":@yel@" + ege[i3 + 3], l + c1 / 2 + 25, l1, 1, 0xffffff);
                l1 += 13;
            }

            l1 += 6;
            gameGraphics.drawLineX(l, l1 - 15, c1, 0);
            if(j2 != -1)
            {
                gameGraphics.drawString(dfn[j2] + " skill", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int j3 = experienceList[0];
                for(int l3 = 0; l3 < 98; l3++)
                    if(edn[j2] >= experienceList[l3])
                        j3 = experienceList[l3 + 1];

                gameGraphics.drawString("Total xp: " + edn[j2] / 4, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                gameGraphics.drawString("Next level at: " + j3 / 4, l + 5, l1, 1, 0xffffff);
            } else
            {
                gameGraphics.drawString("Overall levels", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int k3 = 0;
                for(int i4 = 0; i4 < 18; i4++)
                    k3 += playerStatBase[i4];

                gameGraphics.drawString("Skill total: " + k3, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                gameGraphics.drawString("Combat level: " + ourPlayer.gnm, l + 5, l1, 1, 0xffffff);
                l1 += 12;
            }
        }
        if(dii == 1)
        {
            questMenu.clearList(questMenuHandle);
            questMenu.addListItem(questMenuHandle, 0, "@whi@Quest-list (green=completed)");
            for(int i2 = 0; i2 < 50; i2++)
                questMenu.addListItem(questMenuHandle, i2 + 1, (ehf[i2] ? "@gre@" : "@red@") + dei[i2]);

            questMenu.drawMenu();
        }
        if(!arg0)
            return;
        l = super.mouseX - (((GameImage) (gameGraphics)).gameWidth - 199);
        i1 = super.mouseY - 36;
        if(l >= 0 && i1 >= 0 && l < c1 && i1 < c2)
        {
            if(dii == 1)
                questMenu.mouseClick(l + (((GameImage) (gameGraphics)).gameWidth - 199), i1 + 36, super.lastMouseButton, super.mouseButton);
            if(i1 <= 24 && mouseButtonClick == 1)
            {
                if(l < 98)
                {
                    dii = 0;
                    return;
                }
                if(l > 98)
                    dii = 1;
            }
        }
    }

    private final void fed()
    {
        if(mouseButtonClick != 0)
        {
            mouseButtonClick = 0;
            if(showFriendsBox == 1 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215))
            {
                showFriendsBox = 0;
                return;
            }
            if(showFriendsBox == 2 && (super.mouseX < 6 || super.mouseY < 145 || super.mouseX > 506 || super.mouseY > 215))
            {
                showFriendsBox = 0;
                return;
            }
            if(showFriendsBox == 3 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215))
            {
                showFriendsBox = 0;
                return;
            }
            if(super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213)
            {
                showFriendsBox = 0;
                return;
            }
        }
        int l = 145;
        if(showFriendsBox == 1)
        {
            gameGraphics.drawBox(106, l, 300, 70, 0);
            gameGraphics.drawBoxEdge(106, l, 300, 70, 0xffffff);
            l += 20;
            gameGraphics.drawText("Enter name to add to friends list", 256, l, 4, 0xffffff);
            l += 20;
            gameGraphics.drawText(super.inputText + "*", 256, l, 4, 0xffffff);
            if(super.enteredInputText.length() > 0)
            {
                String s1 = super.enteredInputText.trim();
                super.inputText = "";
                super.enteredInputText = "";
                showFriendsBox = 0;
                if(s1.length() > 0 && DataOperations.nameToHash(s1) != ourPlayer.gmd)
                    addFriend(s1);
            }
        }
        if(showFriendsBox == 2)
        {
            gameGraphics.drawBox(6, l, 500, 70, 0);
            gameGraphics.drawBoxEdge(6, l, 500, 70, 0xffffff);
            l += 20;
            gameGraphics.drawText("Enter message to send to " + DataOperations.hashToName(pmTarget), 256, l, 4, 0xffffff);
            l += 20;
            gameGraphics.drawText(super.pmText + "*", 256, l, 4, 0xffffff);
            if(super.enteredPMText.length() > 0)
            {
                String s2 = super.enteredPMText;
                super.pmText = "";
                super.enteredPMText = "";
                showFriendsBox = 0;
                int j1 = v.stringToBytes(s2);
                sendPrivateMessage(pmTarget, v.ceg, j1);
                s2 = v.bytesToString(v.ceg, 0, j1);
                s2 = ChatFilter.fgd(s2);
                handleServerMessage("@pri@You tell " + DataOperations.hashToName(pmTarget) + ": " + s2);
            }
        }
        if(showFriendsBox == 3)
        {
            gameGraphics.drawBox(106, l, 300, 70, 0);
            gameGraphics.drawBoxEdge(106, l, 300, 70, 0xffffff);
            l += 20;
            gameGraphics.drawText("Enter name to add to ignore list", 256, l, 4, 0xffffff);
            l += 20;
            gameGraphics.drawText(super.inputText + "*", 256, l, 4, 0xffffff);
            if(super.enteredInputText.length() > 0)
            {
                String s3 = super.enteredInputText.trim();
                super.inputText = "";
                super.enteredInputText = "";
                showFriendsBox = 0;
                if(s3.length() > 0 && DataOperations.nameToHash(s3) != ourPlayer.gmd)
                    addIgnore(s3);
            }
        }
        int i1 = 0xffffff;
        if(super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213)
            i1 = 0xffff00;
        gameGraphics.drawText("Cancel", 256, 208, 1, i1);
    }

    private final void playSound(String s1)
    {
        if(audioPlayer == null)
            return;
        if(!configSoundOff)
            audioPlayer.play(soundData, DataOperations.getSoundOffset(s1 + ".pcm", soundData), DataOperations.getSoundLength(s1 + ".pcm", soundData));
    }

    private final void fef()
    {
        if(mouseButtonClick != 0)
        {
            for(int l = 0; l < menuOptionsCount; l++)
            {
                int j1 = ejb + 2;
                int l1 = ejc + 27 + l * 15;
                if(super.mouseX <= j1 - 2 || super.mouseY <= l1 - 12 || super.mouseY >= l1 + 4 || super.mouseX >= (j1 - 3) + ejd)
                    continue;
                menuClick(dec[l]);
                break;
            }

            mouseButtonClick = 0;
            dkk = false;
            return;
        }
        if(super.mouseX < ejb - 10 || super.mouseY < ejc - 10 || super.mouseX > ejb + ejd + 10 || super.mouseY > ejc + eje + 10)
        {
            dkk = false;
            return;
        }
        gameGraphics.drawBoxAlpha(ejb, ejc, ejd, eje, 0xd0d0d0, 160);
        gameGraphics.drawString("Choose option", ejb + 2, ejc + 12, 1, 65535);
        for(int i1 = 0; i1 < menuOptionsCount; i1++)
        {
            int k1 = ejb + 2;
            int i2 = ejc + 27 + i1 * 15;
            int j2 = 0xffffff;
            if(super.mouseX > k1 - 2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && super.mouseX < (k1 - 3) + ejd)
                j2 = 0xffff00;
            gameGraphics.drawString(menuText1[dec[i1]] + " " + menuText2[dec[i1]], k1, i2, 1, j2);
        }

    }

    private final void feg()
    {
        if(drawMenuTab == 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 && super.mouseY < 35)
            drawMenuTab = 1;
        if(drawMenuTab == 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 33 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 33 && super.mouseY < 35)
        {
            drawMenuTab = 2;
            minimapRandomRotationX = (int)(Math.random() * 13D) - 6;
            minimapRandomRotationY = (int)(Math.random() * 23D) - 11;
        }
        if(drawMenuTab == 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 66 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 66 && super.mouseY < 35)
            drawMenuTab = 3;
        if(drawMenuTab == 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 99 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 99 && super.mouseY < 35)
            drawMenuTab = 4;
        if(drawMenuTab == 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 132 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 132 && super.mouseY < 35)
            drawMenuTab = 5;
        if(drawMenuTab == 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 165 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 165 && super.mouseY < 35)
            drawMenuTab = 6;
        if(drawMenuTab != 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 && super.mouseY < 26)
            drawMenuTab = 1;
        if(drawMenuTab != 0 && drawMenuTab != 2 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 33 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 33 && super.mouseY < 26)
        {
            drawMenuTab = 2;
            minimapRandomRotationX = (int)(Math.random() * 13D) - 6;
            minimapRandomRotationY = (int)(Math.random() * 23D) - 11;
        }
        if(drawMenuTab != 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 66 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 66 && super.mouseY < 26)
            drawMenuTab = 3;
        if(drawMenuTab != 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 99 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 99 && super.mouseY < 26)
            drawMenuTab = 4;
        if(drawMenuTab != 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 132 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 132 && super.mouseY < 26)
            drawMenuTab = 5;
        if(drawMenuTab != 0 && super.mouseX >= ((GameImage) (gameGraphics)).gameWidth - 35 - 165 && super.mouseY >= 3 && super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 3 - 165 && super.mouseY < 26)
            drawMenuTab = 6;
        if(drawMenuTab == 1 && (super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 248 || super.mouseY > 36 + (maxInventoryItems / 5) * 34))
            drawMenuTab = 0;
        if(drawMenuTab == 3 && (super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 199 || super.mouseY > 316))
            drawMenuTab = 0;
        if((drawMenuTab == 2 || drawMenuTab == 4 || drawMenuTab == 5) && (super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 199 || super.mouseY > 240))
            drawMenuTab = 0;
        if(drawMenuTab == 6 && (super.mouseX < ((GameImage) (gameGraphics)).gameWidth - 199 || super.mouseY > 311))
            drawMenuTab = 0;
    }

    protected final int adi()
    {
        return link.uid;
    }

    public mudclient()
    {
        tradeOtherName = "";
        windowWidth = 512;
        windowHeight = 334;
        dcj = 9;
        showQuestionMenu = false;
        dcl = "";
        loginScreenShown = false;
        appletMode = true;
        questionMenuAnswer = new String[5];
        appearanceBodyGender = 1;
        appearance2Colour = 2;
        appearanceHairColour = 2;
        appearanceTopColour = 8;
        appearanceBottomColour = 14;
        appearanceHeadGender = 1;
        dec = new int[250];
        dee = new int[8];
        def = new int[8];
        playerArray = new Mob[500];
        dej = -1;
        dek = -2;
        menuText1 = new String[250];
        isSleeping = false;
        tradeItemsOther = new int[14];
        dff = new int[14];
        tradeOtherAccepted = false;
        tradeWeAccepted = false;
        dfi = new int[50];
        dfj = new int[50];
        playerStatCurrent = new int[18];
        menuActionX = new int[250];
        menuActionY = new int[250];
        menuActionID = new int[250];
        showTradeBox = false;
        npcArray = new Mob[500];
        dgg = false;
        dgh = false;
        dgi = false;
        dgj = false;
        playerBufferArray = new Mob[4000];
        dhc = "";
        dhe = false;
        dhf = false;
        wallObjectX = new int[500];
        wallObjectY = new int[500];
        dhi = false;
        cameraRotationYIncrement = 2;
        dia = false;
        wallObjectArray = new i[500];
        die = new String[5];
        dij = new boolean[1500];
        objectArray = new i[1500];
        selectedSpell = -1;
        cameraAutoAngleDebug = false;
        dja = "";
        ourPlayer = new Mob();
        djf = -1;
        tradeItemsOur = new int[14];
        tradeItemOurCount = new int[14];
        showWelcomeBox = false;
        menuActionType = new int[250];
        menuActionVar1 = new int[250];
        menuActionVar2 = new int[250];
        sleepWordDelay = true;
        configCmeraAutoAngle = true;
        cameraRotation = 128;
        configSoundOff = false;
        dkk = false;
        dkm = new int[8];
        dkn = new int[8];
        showBankBox = false;
        playerStatBase = new int[18];
        dmi = new int[256];
        dmj = new int[256];
        showShopBox = false;
        dml = new int[5000];
        dmm = new int[5000];
        dmn = new int[5000];
        dna = new int[5000];
        dnc = 48;
        tradeConfirmOtherItems = new int[14];
        tradeConfirmOtherItemsCount = new int[14];
        dnk = -1;
        walkArrayX = new int[8000];
        walkArrayY = new int[8000];
        cameraDistance = 550;
        ead = new int[50];
        eae = new int[50];
        eaf = new int[50];
        eag = new int[50];
        eah = new boolean[500];
        eal = -1;
        eam = new int[256];
        ean = new int[256];
        maxInventoryItems = 30;
        ebg = false;
        errorLoading = false;
        ebk = new int[50];
        ebl = new int[50];
        ecc = false;
        ece = new int[500];
        tradeConfirmItems = new int[14];
        tradeConfigItemsCount = new int[14];
        ecj = -1;
        eck = -2;
        showDuelConfirmBox = false;
        duelConfirmOurAccepted = false;
        wallObjectDirection = new int[500];
        wallObjectID = new int[500];
        gameDataObjects = new i[1000];
        edc = new Mob[500];
        inventoryItems = new int[35];
        inventoryItemCount = new int[35];
        inventoryItemEquipped = new int[35];
        selectedItem = -1;
        selectedItemName = "";
        lastPlayerArray = new Mob[500];
        showTradeConfirmBox = false;
        tradeConfirmAccepted = false;
        edn = new int[18];
        mouseTrailX = new int[8192];
        mouseTrailY = new int[8192];
        configOneMouseButton = false;
        eeg = 0xbc614e;
        prayerOn = new boolean[50];
        efa = new int[256];
        efb = new int[256];
        efc = new int[256];
        eff = new int[8];
        duelOutStakeItemCount = new int[8];
        ege = new int[5];
        egh = new String[50];
        members = false;
        cameraRotationXIncrement = 2;
        teleBubbleTime = new int[50];
        magicLoc = 128;
        ehf = new boolean[50];
        teleBubbleType = new int[50];
        experienceList = new int[99];
        ehi = -1;
        ehj = -1;
        ehk = -1;
        eib = new int[5];
        eic = 40;
        eif = "";
        memoryError = false;
        duelOurStakeItem = new int[8];
        duelOurStakeItemCount = new int[8];
        menuText2 = new String[250];
        loginUsername = "";
        loginPassword = "";
        eke = "";
        codebaseError = false;
        ekj = new int[50];
        ekk = new int[50];
        ekl = new int[50];
        objectX = new int[1500];
        objectY = new int[1500];
        objectID = new int[1500];
        elb = new int[1500];
        eld = false;
        npcAttackingArray = new Mob[5000];
        elh = new int[50];
        cameraAutoAngle = 1;
        elk = false;
        ell = new int[50];
        showAppearanceWindow = false;
    }

    private final int dbi = 250;
    private final int dbj = 5;
    private final int dbk = 50;
    private final int dbl = 18;
    private final int dbm = 500;
    private final int dbn = 1500;
    private final int dca = 5000;
    private final int dcb = 5000;
    private final int dcc = 500;
    private final int dcd = 4000;
    private final int dce = 500;
    private final int dcf = 8000;
    private String tradeOtherName;
    private int windowWidth;
    private int windowHeight;
    private int dcj;
    private boolean showQuestionMenu;
    private String dcl;
    private boolean loginScreenShown;
    private boolean appletMode;
    private String questionMenuAnswer[];
    private int appearanceHeadType;
    private int appearanceBodyGender;
    private int appearance2Colour;
    private int appearanceHairColour;
    private int appearanceTopColour;
    private int appearanceBottomColour;
    private int appearanceSkinColour;
    private int appearanceHeadGender;
    private Menu chatInputMenu;
    int messagesHandleType2;
    int chatInputBox;
    int messagesHandleType5;
    int messagesHandleType6;
    int dea;
    private int deb;
    private int dec[];
    private int ded;
    private int dee[];
    private int def[];
    private int systemUpdate;
    private Mob playerArray[];
    private final String dei[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    private int dej;
    private int dek;
    private String del;
    private String menuText1[];
    private boolean isSleeping;
    private int dfa;
    private int dfb;
    private int dfc;
    private int tradeItemsOtherCount;
    private int tradeItemsOther[];
    private int dff[];
    private boolean tradeOtherAccepted;
    private boolean tradeWeAccepted;
    private int dfi[];
    private int dfj[];
    private int playerStatCurrent[];
    private int menuActionX[];
    private int menuActionY[];
    private final String dfn[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private int menuActionID[];
    private int playerAliveTimeout;
    private int cameraAutoRotatePlayerX;
    private int cameraAutoRotatePlayerY;
    private boolean showTradeBox;
    private Mob npcArray[];
    private boolean dgg;
    private boolean dgh;
    private boolean dgi;
    private boolean dgj;
    private Menu appearanceMenu;
    private int dgl[][] = {
        {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 4
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 3
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            4, 3
        }
    };
    private int playerCount;
    private int lastPlayerCount;
    private int dha;
    private Mob playerBufferArray[];
    private String dhc;
    private int groundItemCount;
    private boolean dhe;
    private boolean dhf;
    private int wallObjectX[];
    private int wallObjectY[];
    private boolean dhi;
    private int dhj;
    private int dhk;
    private int cameraRotationYAmount;
    private int cameraRotationYIncrement;
    private int dhn[] = {
        0, 1, 2, 1
    };
    private boolean dia;
    private int dib;
    private AudioReader audioPlayer;
    private i wallObjectArray[];
    private String die[];
    private long duelOpponentHash;
    private Menu questMenu;
    int questMenuHandle;
    int dii;
    private boolean dij[];
    private i objectArray[];
    private int selectedSpell;
    private boolean cameraAutoAngleDebug;
    private String lastLoginAddress;
    private String dja;
    private String djb;
    private Mob ourPlayer;
    int sectionX;
    int sectionY;
    int djf;
    private int tradeItemsOurCount;
    private int tradeItemsOur[];
    private int tradeItemOurCount[];
    private boolean showWelcomeBox;
    private int menuActionType[];
    private int menuActionVar1[];
    private int menuActionVar2[];
    private boolean sleepWordDelay;
    private boolean configCmeraAutoAngle;
    private int minimapRandomRotationX;
    private int minimapRandomRotationY;
    private int referId;
    private int loginMenuNotUsedText;
    private int loginMenuOkButton;
    private int cameraRotation;
    private int combatStyle;
    private final int dki[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    private boolean configSoundOff;
    private boolean dkk;
    private int dkl;
    private int dkm[];
    private int dkn[];
    private Menu loginMenuLogin;
    private int appearanceHeadLeftArrow;
    private int appearanceHeadRightArrow;
    private int appearanceHairLeftArrow;
    private int appearanceHairRightArrow;
    private int appearanceGenderLeftArrow;
    private int appearanceGenderRightArrow;
    private int appearanceTopLeftArrow;
    private int appearanceTopRightArrow;
    private int appearanceSkinLeftArrow;
    private int appearanceSkingRightArrow;
    private int appearanceBottomLeftArrow;
    private int appearanceBottomRightArrow;
    private int appearanceAcceptButton;
    private byte soundData[];
    private boolean showBankBox;
    private int dmc;
    private int dmd;
    private int dme;
    private int playerStatBase[];
    private long tradeConfirmOtherNameLong;
    private int showAbuseBox;
    private int dmi[];
    private int dmj[];
    private boolean showShopBox;
    private int dml[];
    private int dmm[];
    private int dmn[];
    private int dna[];
    private GameImageMiddleMan gameGraphics;
    private int dnc;
    private int tradeConfirmOtherItemCount;
    private int tradeConfirmOtherItems[];
    private int tradeConfirmOtherItemsCount[];
    private int tick;
    private EngineHandle engineHandle;
    private int areaX;
    private int areaY;
    private int dnk;
    private int mouseButtonClick;
    private Menu loginNewUser;
    private int walkArrayX[];
    private int walkArrayY[];
    private int eab[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    private int cameraDistance;
    private int ead[];
    private int eae[];
    private int eaf[];
    private int eag[];
    private boolean eah[];
    private int eai;
    private int eaj;
    private int eak;
    private int eal;
    private int eam[];
    private int ean[];
    private final String eba[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private int npcCount;
    private int ebc;
    private int combatTimeout;
    private int maxInventoryItems;
    private Graphics graphics;
    private boolean ebg;
    private boolean errorLoading;
    private int ebi;
    private int animationNumber;
    private int ebk[];
    private int ebl[];
    private int duelRetreat;
    private int duelMagic;
    private int duelPrayer;
    private int duelWeapons;
    private boolean ecc;
    private int unreadMessages;
    private int ece[];
    private int loginScreen;
    private int tradeConfigItemCount;
    private int tradeConfirmItems[];
    private int tradeConfigItemsCount[];
    private int ecj;
    private int eck;
    private boolean showDuelConfirmBox;
    private boolean duelConfirmOurAccepted;
    private int wallObjectDirection[];
    private int wallObjectID[];
    private i gameDataObjects[];
    private Mob edc[];
    private int edd;
    private int inventoryItemsCount;
    private int inventoryItems[];
    private int inventoryItemCount[];
    private int inventoryItemEquipped[];
    private int selectedItem;
    String selectedItemName;
    private Mob lastPlayerArray[];
    private boolean showTradeConfirmBox;
    private boolean tradeConfirmAccepted;
    private int edn[];
    private int loginButtonNewUser;
    private int loginMenuLoginButton;
    private int mouseTrailIndex;
    int mouseTrailX[];
    int mouseTrailY[];
    private boolean configOneMouseButton;
    private int eeg;
    private boolean prayerOn[];
    private int lastLoginDays;
    private int loginMenuStatusText;
    private int loginMenuUserText;
    private int loginMenuPasswordText;
    private int loginMenuOkLoginButton;
    private int loginMenuCancelButton;
    private int efa[];
    private int efb[];
    private int efc[];
    private int objectCount;
    private int duelOpponentStakeCount;
    private int eff[];
    private int duelOutStakeItemCount[];
    private int baseInventoryPic;
    private int baseScrollPic;
    private int baseItemPicture;
    private int baseProjectilePic;
    private int baseTexturePic;
    private int subTexturePic;
    private int baseLoginScreenBackgroundPic;
    private int ega;
    private int egb;
    private int egc;
    private int egd;
    private int ege[];
    private int drawMenuTab;
    private int egg;
    String egh[];
    private boolean members;
    private int cameraRotateTime;
    private int questionMenuCount;
    private int cameraRotationXAmount;
    private int cameraRotationXIncrement;
    private int teleBubbleTime[];
    private final String eha[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    private int logoutTimer;
    private int wallObjectCount;
    private int magicLoc;
    private int loggedIn;
    private boolean ehf[];
    private int teleBubbleType[];
    private int experienceList[];
    private int ehi;
    private int ehj;
    private int ehk;
    private int chatTabAllMsgFlash;
    private int chatTabHistoryFlash;
    private int chatTabQuestFlash;
    private int chatTabPrivateFlash;
    private int eib[];
    private int eic;
    private final int appearanceTopBottomColours[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    private int showFriendsBox;
    private String eif;
    private int eig;
    private boolean memoryError;
    private final int appearanceHairColours[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    private Menu spellMenu;
    int spellMenuHandle;
    int menuMagicPrayersSelected;
    private int duelOurStakeCount;
    private int duelOurStakeItem[];
    private int duelOurStakeItemCount[];
    private int ejb;
    private int ejc;
    private int ejd;
    private int eje;
    private int menuOptionsCount;
    private Camera gameCamera;
    private Menu friendsMenu;
    int friendsMenuHandle;
    int friendsIgnoreMenuSelected;
    long pmTarget;
    private int ejl;
    private String menuText2[];
    private int sleepWordDelayTimer;
    private int mouseButtonHeldTime;
    private int mouseClickedHeldInTradeDuelBox;
    private String loginUsername;
    private String loginPassword;
    private String eke;
    private int ekf;
    private int lastChangedRecoveryDays;
    private boolean codebaseError;
    private Menu loginMenuFirst;
    private int ekj[];
    private int ekk[];
    private int ekl[];
    private int objectX[];
    private int objectY[];
    private int objectID[];
    private int elb[];
    private int reportAbuseOptionSelected;
    private boolean eld;
    private Mob npcAttackingArray[];
    private int lastLoginIPInt;
    private int elg;
    private int elh[];
    private int cameraAutoAngle;
    private int cameraAutoRotationAmoun;
    private boolean elk;
    private int ell[];
    private int elm;
    private boolean showAppearanceWindow;
    private int ema;
    private int actionPictureType;
    int walkMouseX;
    int walkMouseY;
    private int eme[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    private final String emf[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
}
