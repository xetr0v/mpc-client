package client;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 


public class Data
{

    public static int anj(String arg0)
    {
        if(arg0.equalsIgnoreCase("na"))
            return 0;
        for(int i = 0; i < ama; i++)
            if(ajj[i].equalsIgnoreCase(arg0))
                return i;

        ajj[ama++] = arg0;
        return ama - 1;
    }

    public static int ank()
    {
        int i = anf[anh] & 0xff;
        anh++;
        return i;
    }

    public static int anl()
    {
        int i = DataOperations.fmi(anf, anh);
        anh += 2;
        return i;
    }

    public static int anm()
    {
        int i = DataOperations.getInt(anf, anh);
        anh += 4;
        if(i > 0x5f5e0ff)
            i = 0x5f5e0ff - i;
        return i;
    }

    public static String ann()
    {
        String s;
        for(s = ""; ane[ang] != 0; s = s + (char)ane[ang++]);
        ang++;
        return s;
    }

    public static void baa(byte arg0[], boolean arg1)
    {
        ane = DataOperations.loadData("string.dat", 0, arg0);
        ang = 0;
        anf = DataOperations.loadData("integer.dat", 0, arg0);
        anh = 0;
        ahb = anl();
        itemName = new String[ahb];
        itemDescription = new String[ahb];
        itemCommand = new String[ahb];
        itemInventoryPicture = new int[ahb];
        aif = new int[ahb];
        itemStackable = new int[ahb];
        aih = new int[ahb];
        itemIsEquippable = new int[ahb];
        itemPictureMask = new int[ahb];
        itemSpecial = new int[ahb];
        ail = new int[ahb];
        for(int i = 0; i < ahb; i++)
            itemName[i] = ann();

        for(int j = 0; j < ahb; j++)
            itemDescription[j] = ann();

        for(int k = 0; k < ahb; k++)
            itemCommand[k] = ann();

        for(int l = 0; l < ahb; l++)
        {
            itemInventoryPicture[l] = anl();
            if(itemInventoryPicture[l] + 1 > highestLoadedPicture)
                highestLoadedPicture = itemInventoryPicture[l] + 1;
        }

        for(int i1 = 0; i1 < ahb; i1++)
            aif[i1] = anm();

        for(int j1 = 0; j1 < ahb; j1++)
            itemStackable[j1] = ank();

        for(int k1 = 0; k1 < ahb; k1++)
            aih[k1] = ank();

        for(int l1 = 0; l1 < ahb; l1++)
            itemIsEquippable[l1] = anl();

        for(int i2 = 0; i2 < ahb; i2++)
            itemPictureMask[i2] = anm();

        for(int j2 = 0; j2 < ahb; j2++)
            itemSpecial[j2] = ank();

        for(int k2 = 0; k2 < ahb; k2++)
            ail[k2] = ank();

        for(int l2 = 0; l2 < ahb; l2++)
            if(!arg1 && ail[l2] == 1)
            {
                itemName[l2] = "Members object";
                itemDescription[l2] = "You need to be a member to use this object";
                aif[l2] = 0;
                itemCommand[l2] = "";
                aih[0] = 0;
                itemIsEquippable[l2] = 0;
                itemSpecial[l2] = 1;
            }

        alg = anl();
        ahd = new String[alg];
        npcDescription = new String[alg];
        ahf = new String[alg];
        alb = new int[alg];
        alc = new int[alg];
        ald = new int[alg];
        ale = new int[alg];
        alf = new int[alg];
        ala = new int[alg][12];
        ajc = new int[alg];
        ajd = new int[alg];
        aje = new int[alg];
        ajf = new int[alg];
        ahn = new int[alg];
        aia = new int[alg];
        akl = new int[alg];
        akm = new int[alg];
        akn = new int[alg];
        for(int i3 = 0; i3 < alg; i3++)
            ahd[i3] = ann();

        for(int j3 = 0; j3 < alg; j3++)
            npcDescription[j3] = ann();

        for(int k3 = 0; k3 < alg; k3++)
            alb[k3] = ank();

        for(int l3 = 0; l3 < alg; l3++)
            alc[l3] = ank();

        for(int i4 = 0; i4 < alg; i4++)
            ald[i4] = ank();

        for(int j4 = 0; j4 < alg; j4++)
            ale[j4] = ank();

        for(int k4 = 0; k4 < alg; k4++)
            alf[k4] = ank();

        for(int l4 = 0; l4 < alg; l4++)
        {
            for(int i5 = 0; i5 < 12; i5++)
            {
                ala[l4][i5] = ank();
                if(ala[l4][i5] == 255)
                    ala[l4][i5] = -1;
            }

        }

        for(int j5 = 0; j5 < alg; j5++)
            ajc[j5] = anm();

        for(int k5 = 0; k5 < alg; k5++)
            ajd[k5] = anm();

        for(int l5 = 0; l5 < alg; l5++)
            aje[l5] = anm();

        for(int i6 = 0; i6 < alg; i6++)
            ajf[i6] = anm();

        for(int j6 = 0; j6 < alg; j6++)
            ahn[j6] = anl();

        for(int k6 = 0; k6 < alg; k6++)
            aia[k6] = anl();

        for(int l6 = 0; l6 < alg; l6++)
            akl[l6] = ank();

        for(int i7 = 0; i7 < alg; i7++)
            akm[i7] = ank();

        for(int j7 = 0; j7 < alg; j7++)
            akn[j7] = ank();

        for(int k7 = 0; k7 < alg; k7++)
            ahf[k7] = ann();

        akc = anl();
        ajk = new String[akc];
        ajl = new String[akc];
        for(int l7 = 0; l7 < akc; l7++)
            ajk[l7] = ann();

        for(int i8 = 0; i8 < akc; i8++)
            ajl[i8] = ann();

        animationCount = anl();
        animationName = new String[animationCount];
        alh = new int[animationCount];
        animationGenderModels = new int[animationCount];
        animationHasA = new int[animationCount];
        animationHasF = new int[animationCount];
        animationNumber = new int[animationCount];
        for(int j8 = 0; j8 < animationCount; j8++)
            animationName[j8] = ann();

        for(int k8 = 0; k8 < animationCount; k8++)
            alh[k8] = anm();

        for(int l8 = 0; l8 < animationCount; l8++)
            animationGenderModels[l8] = ank();

        for(int i9 = 0; i9 < animationCount; i9++)
            animationHasA[i9] = ank();

        for(int j9 = 0; j9 < animationCount; j9++)
            animationHasF[j9] = ank();

        for(int k9 = 0; k9 < animationCount; k9++)
            animationNumber[k9] = ank();

        ahh = anl();
        ajm = new String[ahh];
        objectDescription = new String[ahh];
        aka = new String[ahh];
        akb = new String[ahh];
        amg = new int[ahh];
        objectWidth = new int[ahh];
        objectHeight = new int[ahh];
        objectType = new int[ahh];
        amk = new int[ahh];
        for(int l9 = 0; l9 < ahh; l9++)
            ajm[l9] = ann();

        for(int i10 = 0; i10 < ahh; i10++)
            objectDescription[i10] = ann();

        for(int j10 = 0; j10 < ahh; j10++)
            aka[j10] = ann();

        for(int k10 = 0; k10 < ahh; k10++)
            akb[k10] = ann();

        for(int l10 = 0; l10 < ahh; l10++)
            amg[l10] = anj(ann());

        for(int i11 = 0; i11 < ahh; i11++)
            objectWidth[i11] = ank();

        for(int j11 = 0; j11 < ahh; j11++)
            objectHeight[j11] = ank();

        for(int k11 = 0; k11 < ahh; k11++)
            objectType[k11] = ank();

        for(int l11 = 0; l11 < ahh; l11++)
            amk[l11] = ank();

        ajh = anl();
        ahi = new String[ajh];
        wallObjectDescription = new String[ajh];
        ahk = new String[ajh];
        ahl = new String[ajh];
        amm = new int[ajh];
        amn = new int[ajh];
        ana = new int[ajh];
        anb = new int[ajh];
        anc = new int[ajh];
        for(int i12 = 0; i12 < ajh; i12++)
            ahi[i12] = ann();

        for(int j12 = 0; j12 < ajh; j12++)
            wallObjectDescription[j12] = ann();

        for(int k12 = 0; k12 < ajh; k12++)
            ahk[k12] = ann();

        for(int l12 = 0; l12 < ajh; l12++)
            ahl[l12] = ann();

        for(int i13 = 0; i13 < ajh; i13++)
            amm[i13] = anl();

        for(int j13 = 0; j13 < ajh; j13++)
            amn[j13] = anm();

        for(int k13 = 0; k13 < ajh; k13++)
            ana[k13] = anm();

        for(int l13 = 0; l13 < ajh; l13++)
            anb[l13] = ank();

        for(int i14 = 0; i14 < ajh; i14++)
            anc[i14] = ank();

        akd = anl();
        alm = new int[akd];
        aln = new int[akd];
        for(int j14 = 0; j14 < akd; j14++)
            alm[j14] = ank();

        for(int k14 = 0; k14 < akd; k14++)
            aln[k14] = ank();

        ajg = anl();
        akg = new int[ajg];
        akh = new int[ajg];
        aki = new int[ajg];
        for(int l14 = 0; l14 < ajg; l14++)
            akg[l14] = anm();

        for(int i15 = 0; i15 < ajg; i15++)
            akh[i15] = ank();

        for(int j15 = 0; j15 < ajg; j15++)
            aki[j15] = ank();

        spellProjectileCount = anl();
        spellCount = anl();
        spellName = new String[spellCount];
        spellDescription = new String[spellCount];
        spellRequiredLevel = new int[spellCount];
        spellDifferentRuneCount = new int[spellCount];
        amd = new int[spellCount];
        spelRequiredRuneID = new int[spellCount][];
        spellRequiredRuneCount = new int[spellCount][];
        for(int k15 = 0; k15 < spellCount; k15++)
            spellName[k15] = ann();

        for(int l15 = 0; l15 < spellCount; l15++)
            spellDescription[l15] = ann();

        for(int i16 = 0; i16 < spellCount; i16++)
            spellRequiredLevel[i16] = ank();

        for(int j16 = 0; j16 < spellCount; j16++)
            spellDifferentRuneCount[j16] = ank();

        for(int k16 = 0; k16 < spellCount; k16++)
            amd[k16] = ank();

        for(int l16 = 0; l16 < spellCount; l16++)
        {
            int i17 = ank();
            spelRequiredRuneID[l16] = new int[i17];
            for(int k17 = 0; k17 < i17; k17++)
                spelRequiredRuneID[l16][k17] = anl();

        }

        for(int j17 = 0; j17 < spellCount; j17++)
        {
            int l17 = ank();
            spellRequiredRuneCount[j17] = new int[l17];
            for(int j18 = 0; j18 < l17; j18++)
                spellRequiredRuneCount[j17][j18] = ank();

        }

        prayerCount = anl();
        prayerName = new String[prayerCount];
        prayerDescription = new String[prayerCount];
        prayerRequiredLevel = new int[prayerCount];
        prayerDrainRate = new int[prayerCount];
        for(int i18 = 0; i18 < prayerCount; i18++)
            prayerName[i18] = ann();

        for(int k18 = 0; k18 < prayerCount; k18++)
            prayerDescription[k18] = ann();

        for(int l18 = 0; l18 < prayerCount; l18++)
            prayerRequiredLevel[l18] = ank();

        for(int i19 = 0; i19 < prayerCount; i19++)
            prayerDrainRate[i19] = ank();

        ane = null;
        anf = null;
    }

    public static int ahb;
    public static int highestLoadedPicture;
    public static String ahd[];
    public static String npcDescription[];
    public static String ahf[];
    public static int spellProjectileCount;
    public static int ahh;
    public static String ahi[];
    public static String wallObjectDescription[];
    public static String ahk[];
    public static String ahl[];
    public static int spellCount;
    public static int ahn[];
    public static int aia[];
    public static String itemName[];
    public static String itemDescription[];
    public static String itemCommand[];
    public static int itemInventoryPicture[];
    public static int aif[];
    public static int itemStackable[];
    public static int aih[];
    public static int itemIsEquippable[];
    public static int itemPictureMask[];
    public static int itemSpecial[];
    public static int ail[];
    public static String prayerName[];
    public static String prayerDescription[];
    public static String animationName[];
    public static int prayerCount;
    public static int ajc[];
    public static int ajd[];
    public static int aje[];
    public static int ajf[];
    public static int ajg;
    public static int ajh;
    public static int animationCount;
    public static String ajj[] = new String[5000];
    public static String ajk[];
    public static String ajl[];
    public static String ajm[];
    public static String objectDescription[];
    public static String aka[];
    public static String akb[];
    public static int akc;
    public static int akd;
    public static int prayerRequiredLevel[];
    public static int prayerDrainRate[];
    public static int akg[];
    public static int akh[];
    public static int aki[];
    public static String spellName[];
    public static String spellDescription[];
    public static int akl[];
    public static int akm[];
    public static int akn[];
    public static int ala[][];
    public static int alb[];
    public static int alc[];
    public static int ald[];
    public static int ale[];
    public static int alf[];
    public static int alg;
    public static int alh[];
    public static int animationGenderModels[];
    public static int animationHasA[];
    public static int animationHasF[];
    public static int animationNumber[];
    public static int alm[];
    public static int aln[];
    public static int ama;
    public static int spellRequiredLevel[];
    public static int spellDifferentRuneCount[];
    public static int amd[];
    public static int spelRequiredRuneID[][];
    public static int spellRequiredRuneCount[][];
    public static int amg[];
    public static int objectWidth[];
    public static int objectHeight[];
    public static int objectType[];
    public static int amk[];
    public static String aml[] = new String[5000];
    public static int amm[];
    public static int amn[];
    public static int ana[];
    public static int anb[];
    public static int anc[];
    public static String and[] = new String[5000];
    static byte ane[];
    static byte anf[];
    static int ang;
    static int anh;
    public static int ani;

}
