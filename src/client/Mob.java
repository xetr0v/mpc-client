package client;

final class Mob {

    Mob() {
        waypointsX = new int[10];
        waypointsY = new int[10];
        appearanceItems = new int[12];
        level = -1;
        hah = false;
        hai = -1;
    }

    public long nameHash;
    public String username;
    public int serverIndex;
    public int serverID;
    public int currentX;
    public int currentY;
    public int npcId;
    public int stepCount;
    public int currentSprite;
    public int nextSprite;
    public int waypointsEndSprite;
    public int waypointCurrent;
    public int waypointsX[];
    public int waypointsY[];
    public int appearanceItems[];
    public String lastMessage;
    public int lastMessageTimeout;
    public int itemAboveHeadID;
    public int itemAboveHeadTimeout;
    public int lastDamageCount;
    public int currentHits;
    public int baseHits;
    public int combatTimer;
    public int level;
    public int hairColour;
    public int topColour;
    public int bottomColour;
    public int skinColour;
    public int projectileType;
    public int attackingPlayerIndex;
    public int attackingNpcIndex;
    public int projectileDistance;
    public boolean hah;
    public int hai;
    public int itemAboveHeadVisible;
}
