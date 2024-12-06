/*
 * Decompiled with CFR 0.152.
 */

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.net.Socket;
import java.net.URL;
import java.util.StringTokenizer;

public class Golf extends JFrame implements Runnable, JavaAppletFramework {
    protected static AudioClip sunkit = null;
    protected static AudioClip putt = null;
    protected static AudioClip water = null;
    protected static AudioClip swing = null;
    protected static AudioClip sand = null;
    protected static String serverName;
    protected static String serverPath;
    protected static String input;
    protected static String tourdata;
    protected static String rdata;
    protected static String csdata;
    protected static int inleng;
    protected static int myc;
    protected static int top10Flag;
    protected static String cname;
    protected static int tenth;
    protected static int reportedIn;
    protected static int[] myarray;
    static int sfxin;
    static int sfxout;
    static int[] sfxque;
    static int allImages;
    static int imgflag;
    static int reportIn;
    static int redball;
    static int tourDone;
    static int round;
    static int[] tourScores;
    static int[] tourPars;
    static int leaderBoard;
    static int leaderRefresh;
    static int sfx;
    static int lastsfx;
    static int cuesfx;
    static String golfdata;
    static int time2save;
    static int time2read;
    static int gothole;
    static int picked;
    static int slower;
    static int lastBallIsOn;
    static int lakeScanner;
    static int inHole;
    static int outOfBounds;
    static int bigRefresh;
    static int fullRefresh;
    static int bigRefresh2;
    static String tname;
    static String p1name;
    static String p2name;
    static String p3name;
    static String p4name;
    static int player;
    static int newPlayer;
    static int numOfPlayers;
    static int keyClock;
    static int playerClock;
    static int keyFace;
    static int keyBack;
    static int keyRefresh;
    static int gameOver;
    static int frontYards;
    static int frontPar;
    static int backYards;
    static int backPar;
    static int[] holeYards;
    static int[] holePars;
    static int[] player1Par;
    static int[] player2Par;
    static int[] player3Par;
    static int[] player4Par;
    static int player1Total;
    static int player2Total;
    static int player3Total;
    static int player4Total;
    static int[] playerStrokes;
    static int[] playerBallX;
    static int[] playerBallY;
    static int[] playerSandchk;
    static int[] dist;
    static int[] honor;
    static int ballInFlight;
    static int ballZ;
    static int ballTime;
    static int ballTimeOut;
    static int ballGravity;
    static int ballDX;
    static int ballDY;
    static int lakeDX;
    static int lakeDY;
    static int newCard;
    static int newCardRefresh;
    static int newSlope;
    static int slopeDX;
    static int slopeDY;
    static int newWind;
    static int windDX;
    static int windDY;
    static int baseX;
    static int baseY;
    static int magBaseX;
    static int magBaseY;
    static int baseDX;
    static int baseDY;
    static int bpX;
    static int bpY;
    static int bounced;
    static int sandchk;
    static int newPower;
    static int power;
    static int powerDir;
    static int rangeClock;
    static int newClub;
    static int club;
    static int hole;
    static int holebase;
    static int par;
    static int yards;
    static int infoX;
    static int infoY;
    static int infoBox;
    static int aimX;
    static int aimY;
    static int sandPlug;
    static int ballIsOn;
    static int globalSize;
    static int showBar;
    static int magX;
    static int magY;
    static int magSize;
    static int magSelected;
    static int pinX;
    static int pinY;
    static int pinSelected;
    static int trackX;
    static int trackY;
    static int teeX;
    static int teeY;
    static int teeSelected;
    static int aniClock;
    static int button;
    static int size;
    static int dx;
    static int dy;
    static int dz;
    static int X;
    static int Y;
    static int ballX;
    static int ballY;
    static int magBallX;
    static int magBallY;
    static int holebuilt;
    static int undoSelected;
    static int lakeSelected;
    static int roughSelected;
    static int fairwaySelected;
    static int greenSelected;
    static int sandSelected;
    static int treeSelected;
    static int showOptions;
    static int onGreen;
    static int inSand;
    static int inLake;
    static int inRough;
    static int onFairway;
    static int fairways;
    static int[] fairwayX;
    static int[] fairwayY;
    static int[] fairwayRadius;
    static int roughs;
    static int[] roughX;
    static int[] roughY;
    static int[] roughRadius;
    static int lakes;
    static int[] lakeX;
    static int[] lakeY;
    static int[] lakeRadius;
    static int sandtraps;
    static int[] sandX;
    static int[] sandY;
    static int[] sandRadius;
    static int greens;
    static int[] greenX;
    static int[] greenY;
    static int[] greenRadius;
    static int trees;
    static int[] treeX;
    static int[] treeY;
    static int[] treeRadius;
    static Color sand1;
    static Color sand2;
    static Color sand3;
    static Color sand4;
    static Color lake1;
    static Color lake2;
    static Color lake3;
    static Color lake4;
    static Color lake5;
    static Color rough1;
    static Color rough2;
    static Color fairway1;
    static Color fairway2;
    static Color green1;
    static Color green2;
    static Color tee1;
    static Color tee2;
    static Color info1;
    static String holedata1;
    static String holedata2;
    static String holedata3;
    static String holedata4;
    static String holedata5;
    static String holedata6;
    static String holedata7;
    static String holedata8;
    static String holedata9;
    static String holedata10;
    static String holedata11;
    static String holedata12;
    static String holedata13;
    static String holedata14;
    static String holedata15;
    static String holedata16;
    static String holedata17;
    static String holedata18;
    static Image powerbar;
    static Image wind;
    static Image greenslope;
    static Image clubface;
    static Image ball;
    static Image gold;
    static Image working;

    static {
        sfxque = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        tourScores = new int[5];
        tourPars = new int[40];
        golfdata = "0";
        time2read = 1;
        picked = 1;
        lastBallIsOn = 99;
        lakeScanner = -1;
        bigRefresh = 1;
        tname = "";
        p1name = "";
        p2name = "";
        p3name = "";
        p4name = "";
        player = 1;
        numOfPlayers = 1;
        keyClock = 1;
        playerClock = 1;
        keyFace = 1;
        keyBack = 1;
        keyRefresh = 1;
        holeYards = new int[19];
        holePars = new int[19];
        player1Par = new int[19];
        player2Par = new int[19];
        player3Par = new int[19];
        player4Par = new int[19];
        playerStrokes = new int[5];
        playerBallX = new int[5];
        playerBallY = new int[5];
        playerSandchk = new int[5];
        dist = new int[5];
        honor = new int[5];
        newSlope = 1;
        slopeDX = 1;
        slopeDY = 1;
        newWind = 1;
        windDX = 3;
        windDY = 7;
        newPower = 1;
        power = 2;
        powerDir = 1;
        newClub = 1;
        club = 5;
        hole = 1;
        par = 4;
        yards = 324;
        infoX = 271;
        infoY = 275;
        aimX = 300;
        aimY = 74;
        globalSize = 10;
        showBar = 1;
        magSize = 1;
        pinX = 300;
        pinY = 74;
        trackX = 50;
        trackY = 50;
        teeX = 50;
        teeY = 220;
        button = 1;
        dx = 4;
        dy = -1;
        dz = 50;
        X = 30;
        Y = 220;
        ballX = 50;
        ballY = 220;
        magBallX = 50;
        magBallY = 220;
        lakeSelected = 1;
        showOptions = 1;
        fairwayX = new int[102];
        fairwayY = new int[102];
        fairwayRadius = new int[102];
        roughX = new int[102];
        roughY = new int[102];
        roughRadius = new int[102];
        lakes = 1;
        lakeX = new int[102];
        lakeY = new int[102];
        lakeRadius = new int[102];
        sandtraps = 4;
        sandX = new int[102];
        sandY = new int[102];
        sandRadius = new int[102];
        greens = 2;
        greenX = new int[102];
        greenY = new int[102];
        greenRadius = new int[102];
        treeX = new int[102];
        treeY = new int[102];
        treeRadius = new int[102];
        sand1 = new Color(90, 180, 120);
        sand2 = new Color(180, 255, 160);
        sand3 = new Color(255, 230, 180);
        sand4 = new Color(223, 198, 148);
        lake1 = new Color(128, 115, 90);
        lake2 = new Color(255, 230, 180);
        lake3 = new Color(0, 40, 200);
        lake4 = new Color(100, 100, 200);
        lake5 = new Color(132, 132, 232);
        rough1 = new Color(90, 220, 90);
        rough2 = new Color(58, 188, 58);
        fairway1 = new Color(144, 234, 104);
        fairway2 = new Color(100, 255, 120);
        green1 = new Color(80, 180, 80);
        green2 = new Color(56, 156, 56);
        tee1 = new Color(80, 160, 100);
        tee2 = new Color(250, 50, 50);
        info1 = new Color(160, 40, 20);
        holedata1 = "";
        holedata2 = "";
        holedata3 = "";
        holedata4 = "";
        holedata5 = "";
        holedata6 = "";
        holedata7 = "";
        holedata8 = "";
        holedata9 = "";
        holedata10 = "";
        holedata11 = "";
        holedata12 = "";
        holedata13 = "";
        holedata14 = "";
        holedata15 = "";
        holedata16 = "";
        holedata17 = "";
        holedata18 = "";
        serverName = "";
        serverPath = "";
        input = "";
        tourdata = "";
        rdata = "";
        csdata = "";
        top10Flag = 1;
        cname = "";
        myarray = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    Thread aniThread;

    public void init() {
        this.setForeground(Color.gray);
        this.setBackground(Color.gray);
        serverName = this.getParameter("servername");
        serverPath = this.getParameter("serverpath");
        sunkit = this.getAudioClip(this.getDocumentBase(), "sunkit.au");
        putt = this.getAudioClip(this.getDocumentBase(), "putt.au");
        water = this.getAudioClip(this.getDocumentBase(), "water.au");
        swing = this.getAudioClip(this.getDocumentBase(), "swing.au");
        sand = this.getAudioClip(this.getDocumentBase(), "sand.au");
        greenslope = this.createImage(50, 50);
        clubface = this.createImage(50, 50);
        wind = this.createImage(50, 50);
        powerbar = this.createImage(50, 50);
        ball = this.createImage(50, 50);
        gold = this.createImage(600, 300);
        working = this.createImage(600, 300);
    }

    public void readtourdata() {
        try {
            String string;
            URL uRL = new URL(this.getDocumentBase(), "golfscor.dat");
            DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
            tourdata = "";
            while ((string = dataInputStream.readLine()) != null) {
                tourdata = tourdata + string + "\n";
            }
            dataInputStream.close();
            return;
        } catch (Exception exception) {
            System.out.println("Error:" + exception);
            return;
        }
    }

    public void readgolfdata() {
        Graphics graphics = this.getGraphics();
        graphics.setColor(new Color(26, 156, 26));
        graphics.fillRect(0, 0, 600, 300);
        int n = 1;
        while (n < 19) {
            Object object;
            Object object2;
            graphics.setColor(Color.blue);
            graphics.fillRect(0, 85, 600, 20);
            graphics.setColor(Color.black);
            graphics.drawString("READING HOLE " + n, 101, 101);
            graphics.setColor(Color.white);
            graphics.drawString("READING HOLE " + n, 100, 100);
            try {
                String string;
                object2 = new URL(this.getDocumentBase(), "sbhole" + n + ".dat");
                object = new DataInputStream(((URL) object2).openStream());
                rdata = "";
                while ((string = ((DataInputStream) object).readLine()) != null) {
                    rdata = rdata + string + "\n";
                }
                ((FilterInputStream) object).close();
            } catch (Exception exception) {
            }
            switch (n) {
                case 1: {
                    holedata1 = rdata;
                    break;
                }
                case 2: {
                    holedata2 = rdata;
                    break;
                }
                case 3: {
                    holedata3 = rdata;
                    break;
                }
                case 4: {
                    holedata4 = rdata;
                    break;
                }
                case 5: {
                    holedata5 = rdata;
                    break;
                }
                case 6: {
                    holedata6 = rdata;
                    break;
                }
                case 7: {
                    holedata7 = rdata;
                    break;
                }
                case 8: {
                    holedata8 = rdata;
                    break;
                }
                case 9: {
                    holedata9 = rdata;
                    break;
                }
                case 10: {
                    holedata10 = rdata;
                    break;
                }
                case 11: {
                    holedata11 = rdata;
                    break;
                }
                case 12: {
                    holedata12 = rdata;
                    break;
                }
                case 13: {
                    holedata13 = rdata;
                    break;
                }
                case 14: {
                    holedata14 = rdata;
                    break;
                }
                case 15: {
                    holedata15 = rdata;
                    break;
                }
                case 16: {
                    holedata16 = rdata;
                    break;
                }
                case 17: {
                    holedata17 = rdata;
                    break;
                }
                case 18: {
                    holedata18 = rdata;
                }
            }
            object2 = "";
            if (rdata.length() > 0) {
                object = new StringTokenizer(rdata, "+");
                if (((StringTokenizer) object).hasMoreTokens()) {
                    object2 = ((StringTokenizer) object).nextToken();
                }
                boolean bl = false;
                while (!bl) {
                    if (((StringTokenizer) object).hasMoreTokens()) {
                        object2 = ((StringTokenizer) object).nextToken();
                    }
                    object2 = ((String) object2).substring(1, ((String) object2).length());
                    if (((StringTokenizer) object).hasMoreTokens()) {
                        object2 = ((StringTokenizer) object).nextToken();
                    }
                    switch (Integer.parseInt((String) object2)) {
                        case 1: {
                            if (((StringTokenizer) object).hasMoreTokens()) {
                                object2 = ((StringTokenizer) object).nextToken();
                            }
                            ballX = teeX = Integer.parseInt((String) object2);
                            if (((StringTokenizer) object).hasMoreTokens()) {
                                object2 = ((StringTokenizer) object).nextToken();
                            }
                            ballY = teeY = Integer.parseInt((String) object2);
                            ballIsOn = 0;
                            if (((StringTokenizer) object).hasMoreTokens()) {
                                object2 = ((StringTokenizer) object).nextToken();
                            }
                            pinX = Integer.parseInt((String) object2);
                            if (((StringTokenizer) object).hasMoreTokens()) {
                                object2 = ((StringTokenizer) object).nextToken();
                            }
                            pinY = Integer.parseInt((String) object2);
                            aimX = pinX;
                            aimY = pinY;
                            int n2 = (pinX - teeX) * (pinX - teeX);
                            int n3 = (pinY - teeY) * (pinY - teeY) * 4;
                            int n4 = 0;
                            int n5 = 0;
                            int n6 = 200;
                            n4 = pinX > teeX ? pinX - teeX : teeX - pinX;
                            if (n4 >= (n5 = pinY > teeY ? pinY - teeY : teeY - pinY)) {
                                n6 = n4 + n5 / 4;
                            }
                            if (n4 < n5) {
                                n6 = n5 + n4 / 4;
                            }
                            yards = (n2 + n3) / n6;
                            yards = (n2 + n3) / ((yards + n6) / 2);
                            par = 3;
                            if (yards > 225) {
                                par = 4;
                            }
                            if (yards > 450) {
                                par = 5;
                            }
                            Golf.holeYards[n] = yards;
                            Golf.holePars[n] = par;
                            break;
                        }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7: {
                            if (((StringTokenizer) object).hasMoreTokens()) {
                                object2 = ((StringTokenizer) object).nextToken();
                            }
                            if (((StringTokenizer) object).hasMoreTokens()) {
                                object2 = ((StringTokenizer) object).nextToken();
                            }
                            if (!((StringTokenizer) object).hasMoreTokens()) break;
                            object2 = ((StringTokenizer) object).nextToken();
                            break;
                        }
                        case 8: {
                            bl = true;
                        }
                    }
                }
            }
            ++n;
        }
        graphics.dispose();
        gothole = 1;
    }

    public void nextplayer() {
        int n;
        int n2;
        Golf.playerBallX[Golf.player] = ballX;
        Golf.playerBallY[Golf.player] = ballY;
        Golf.playerSandchk[Golf.player] = sandPlug;
        int n3 = 1;
        while (n3 < numOfPlayers + 1) {
            Golf.dist[n3] = 0;
            if (n3 == 1 && player1Par[hole] == 0) {
                Golf.dist[n3] = (playerBallX[n3] - pinX) * (playerBallX[n3] - pinX) + (playerBallY[n3] - pinY) * (playerBallY[n3] - pinY);
            }
            if (n3 == 2 && player2Par[hole] == 0) {
                Golf.dist[n3] = (playerBallX[n3] - pinX) * (playerBallX[n3] - pinX) + (playerBallY[n3] - pinY) * (playerBallY[n3] - pinY);
            }
            if (n3 == 3 && player3Par[hole] == 0) {
                Golf.dist[n3] = (playerBallX[n3] - pinX) * (playerBallX[n3] - pinX) + (playerBallY[n3] - pinY) * (playerBallY[n3] - pinY);
            }
            if (n3 == 4 && player4Par[hole] == 0) {
                Golf.dist[n3] = (playerBallX[n3] - pinX) * (playerBallX[n3] - pinX) + (playerBallY[n3] - pinY) * (playerBallY[n3] - pinY);
            }
            ++n3;
        }
        if (ballX != teeX && ballY != teeY || hole == 1) {
            n2 = dist[1];
            player = 1;
            n = 1;
            while (n < numOfPlayers + 1) {
                if (n == 1 && n2 < dist[n] && player1Par[hole] == 0) {
                    n2 = dist[n];
                    player = n;
                }
                if (n == 2 && n2 < dist[n] && player2Par[hole] == 0) {
                    n2 = dist[n];
                    player = n;
                }
                if (n == 3 && n2 < dist[n] && player3Par[hole] == 0) {
                    n2 = dist[n];
                    player = n;
                }
                if (n == 4 && n2 < dist[n] && player4Par[hole] == 0) {
                    n2 = dist[n];
                    player = n;
                }
                ++n;
            }
        }
        if (hole > 1 && ballX == teeX && ballY == teeY) {
            player = 1;
            n2 = 999;
            n = 1;
            while (n < numOfPlayers + 1) {
                if (n == 1 && honor[1] < n2 && player1Par[hole] == 0) {
                    player = 1;
                    n2 = honor[1];
                }
                if (n == 2 && honor[2] < n2 && player2Par[hole] == 0) {
                    player = 2;
                    n2 = honor[2];
                }
                if (n == 3 && honor[3] < n2 && player3Par[hole] == 0) {
                    player = 3;
                    n2 = honor[3];
                }
                if (n == 4 && honor[4] < n2 && player4Par[hole] == 0) {
                    player = 4;
                    n2 = honor[4];
                }
                ++n;
            }
        }
        sandPlug = playerSandchk[player];
        ballX = playerBallX[player];
        ballY = playerBallY[player];
        playerClock = 20;
        picked = 0;
        button = 1;
        aniClock = 0;
        infoBox = 1;
        aimX = pinX;
        aimY = pinY;
        if (magSelected == 1) {
            aimX = 300;
            aimY = 125;
        }
    }

    public boolean imageUpdate(Image image, int n, int n2, int n3, int n4, int n5) {
        try {
            if ((n & 0x20) != 0) {
                imgflag = 1;
                return false;
            }
        } catch (Exception exception) {
            System.out.println("Image Error:" + exception);
        }
        return true;
    }

    public void update(Graphics graphics) {
        redball = 1;
        if (sfxin != sfxout) {
            switch (sfxque[sfxout]) {
                case 1: {
                    swing.play();
                    Golf.sfxque[Golf.sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
                    break;
                }
                case 2: {
                    putt.play();
                    Golf.sfxque[Golf.sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
                    break;
                }
                case 3: {
                    sand.play();
                    Golf.sfxque[Golf.sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
                    break;
                }
                case 4: {
                    water.play();
                    Golf.sfxque[Golf.sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
                    break;
                }
                case 5: {
                    sunkit.play();
                    Golf.sfxque[Golf.sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
                }
            }
        }
        this.paint(graphics);
        redball = 0;
    }

    public void writetourdata() {
        int n = 0;
        String string = "";
        int n2 = 1;
        while (n2 < numOfPlayers + 1) {
            switch (n2) {
                case 1: {
                    string = p1name;
                    n = player1Total;
                    break;
                }
                case 2: {
                    string = p2name;
                    n = player2Total;
                    break;
                }
                case 3: {
                    string = p3name;
                    n = player3Total;
                    break;
                }
                case 4: {
                    string = p4name;
                    n = player4Total;
                }
            }
            try {
                String string2;
                Socket socket = new Socket(serverName, 80);
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                if (holebase == 0) {
                    dataOutputStream.writeBytes("GET " + serverPath + "golfscor.cgi?" + n + "+(F)" + string + "+\n\n");
                }
                if (holebase == 9) {
                    dataOutputStream.writeBytes("GET " + serverPath + "golfscor.cgi?" + n + "+(B)" + string + "+\n\n");
                }
                tourdata = "";
                while ((string2 = dataInputStream.readLine()) != null) {
                    tourdata = tourdata + string2 + "\n";
                }
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();
            } catch (Exception exception) {
                System.out.println("Error:" + exception);
            }
            ++n2;
        }
    }

    /*
     * Opcode count of 13017 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     * Unable to fully structure code
     */
    public void paint(Graphics var1_1) {
        block587:
        {
            block588:
            {
                if (Golf.redball == 0) {
                    return;
                }
                ++Golf.aniClock;
                if (Golf.time2read == 1) {
                    if (Golf.gothole == 0) {
                        this.readgolfdata();
                    }
                    Golf.rdata = "";
                    switch (Golf.hole + Golf.holebase) {
                        case 1: {
                            Golf.rdata = Golf.holedata1;
                            break;
                        }
                        case 2: {
                            Golf.rdata = Golf.holedata2;
                            break;
                        }
                        case 3: {
                            Golf.rdata = Golf.holedata3;
                            break;
                        }
                        case 4: {
                            Golf.rdata = Golf.holedata4;
                            break;
                        }
                        case 5: {
                            Golf.rdata = Golf.holedata5;
                            break;
                        }
                        case 6: {
                            Golf.rdata = Golf.holedata6;
                            break;
                        }
                        case 7: {
                            Golf.rdata = Golf.holedata7;
                            break;
                        }
                        case 8: {
                            Golf.rdata = Golf.holedata8;
                            break;
                        }
                        case 9: {
                            Golf.rdata = Golf.holedata9;
                            break;
                        }
                        case 10: {
                            Golf.rdata = Golf.holedata10;
                            break;
                        }
                        case 11: {
                            Golf.rdata = Golf.holedata11;
                            break;
                        }
                        case 12: {
                            Golf.rdata = Golf.holedata12;
                            break;
                        }
                        case 13: {
                            Golf.rdata = Golf.holedata13;
                            break;
                        }
                        case 14: {
                            Golf.rdata = Golf.holedata14;
                            break;
                        }
                        case 15: {
                            Golf.rdata = Golf.holedata15;
                            break;
                        }
                        case 16: {
                            Golf.rdata = Golf.holedata16;
                            break;
                        }
                        case 17: {
                            Golf.rdata = Golf.holedata17;
                            break;
                        }
                        case 18: {
                            Golf.rdata = Golf.holedata18;
                        }
                    }
                    var2_2 = "";
                    if (Golf.rdata.length() > 0 && Golf.gothole == 1) {
                        var3_21 = new StringTokenizer(Golf.rdata, "+");
                        if (var3_21.hasMoreTokens()) {
                            var2_2 = var3_21.nextToken();
                        }
                        Golf.lakes = 0;
                        Golf.roughs = 0;
                        Golf.fairways = 0;
                        Golf.sandtraps = 0;
                        Golf.greens = 0;
                        Golf.trees = 0;
                        var4_37 = 0;
                        while (var4_37 == 0) {
                            if (var3_21.hasMoreTokens()) {
                                var2_2 = var3_21.nextToken();
                            }
                            var2_2 = var2_2.substring(1, var2_2.length());
                            if (var3_21.hasMoreTokens()) {
                                var2_2 = var3_21.nextToken();
                            }
                            switch (Integer.parseInt(var2_2)) {
                                case 1: {
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.ballX = Golf.teeX = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.ballY = Golf.teeY = Integer.parseInt(var2_2);
                                    Golf.ballIsOn = 0;
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.pinX = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.pinY = Integer.parseInt(var2_2);
                                    Golf.aimX = Golf.pinX;
                                    Golf.aimY = Golf.pinY;
                                    var5_39 = (Golf.pinX - Golf.teeX) * (Golf.pinX - Golf.teeX);
                                    var6_40 = (Golf.pinY - Golf.teeY) * (Golf.pinY - Golf.teeY);
                                    var7_41 = 0;
                                    var8_43 = 0;
                                    var9_44 = 100;
                                    var7_41 = Golf.pinX > Golf.teeX ? Golf.pinX - Golf.teeX : Golf.teeX - Golf.pinX;
                                    var8_43 = Golf.pinY > Golf.teeY ? Golf.pinY - Golf.teeY : Golf.teeY - Golf.pinY;
                                    var9_44 = var7_41 > var8_43 ? var7_41 + var8_43 / 4 : var8_43 + var7_41 / 4;
                                    Golf.yards = (var5_39 + var6_40) / var9_44;
                                    Golf.yards = (var5_39 + var6_40) / ((Golf.yards + var9_44) / 2);
                                    Golf.par = 3;
                                    if (Golf.yards > 225) {
                                        Golf.par = 4;
                                    }
                                    if (Golf.yards <= 410) break;
                                    Golf.par = 5;
                                    break;
                                }
                                case 2: {
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.lakeX[Golf.lakes] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.lakeY[Golf.lakes] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.lakeRadius[Golf.lakes] = Integer.parseInt(var2_2);
                                    ++Golf.lakes;
                                    break;
                                }
                                case 3: {
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.roughX[Golf.roughs] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.roughY[Golf.roughs] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.roughRadius[Golf.roughs] = Integer.parseInt(var2_2);
                                    ++Golf.roughs;
                                    break;
                                }
                                case 4: {
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.fairwayX[Golf.fairways] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.fairwayY[Golf.fairways] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.fairwayRadius[Golf.fairways] = Integer.parseInt(var2_2);
                                    ++Golf.fairways;
                                    break;
                                }
                                case 5: {
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.sandX[Golf.sandtraps] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.sandY[Golf.sandtraps] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.sandRadius[Golf.sandtraps] = Integer.parseInt(var2_2);
                                    ++Golf.sandtraps;
                                    break;
                                }
                                case 6: {
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.greenX[Golf.greens] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.greenY[Golf.greens] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.greenRadius[Golf.greens] = Integer.parseInt(var2_2);
                                    ++Golf.greens;
                                    break;
                                }
                                case 7: {
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.treeX[Golf.trees] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.treeY[Golf.trees] = Integer.parseInt(var2_2);
                                    if (var3_21.hasMoreTokens()) {
                                        var2_2 = var3_21.nextToken();
                                    }
                                    Golf.treeRadius[Golf.trees] = Integer.parseInt(var2_2);
                                    Golf.treeRadius[Golf.trees] = Golf.treeY[Golf.trees] / 15 + 7;
                                    ++Golf.trees;
                                    break;
                                }
                                case 8: {
                                    var4_37 = 1;
                                }
                            }
                        }
                        var5_39 = 250;
                        var6_40 = 0;
                        var7_41 = 250;
                        var8_43 = 0;
                        var9_44 = 0;
                        while (var9_44 < Golf.roughs) {
                            if (Golf.roughX[var9_44] + Golf.roughRadius[var9_44] > var8_43) {
                                var8_43 = Golf.roughX[var9_44] + Golf.roughRadius[var9_44];
                            }
                            if (Golf.roughX[var9_44] - Golf.roughRadius[var9_44] < var7_41) {
                                var7_41 = Golf.roughX[var9_44] - Golf.roughRadius[var9_44];
                            }
                            if (Golf.roughY[var9_44] + Golf.roughRadius[var9_44] > var6_40) {
                                var6_40 = Golf.roughY[var9_44] + Golf.roughRadius[var9_44];
                            }
                            if (Golf.roughY[var9_44] - Golf.roughRadius[var9_44] < var5_39) {
                                var5_39 = Golf.roughY[var9_44] - Golf.roughRadius[var9_44];
                            }
                            ++var9_44;
                        }
                        var10_47 = 0;
                        while (var10_47 < Golf.fairways) {
                            if (Golf.fairwayX[var10_47] + Golf.fairwayRadius[var10_47] > var8_43) {
                                var8_43 = Golf.fairwayX[var10_47] + Golf.fairwayRadius[var10_47];
                            }
                            if (Golf.fairwayX[var10_47] - Golf.fairwayRadius[var10_47] < var7_41) {
                                var7_41 = Golf.fairwayX[var10_47] - Golf.fairwayRadius[var10_47];
                            }
                            if (Golf.fairwayY[var10_47] + Golf.fairwayRadius[var10_47] > var6_40) {
                                var6_40 = Golf.fairwayY[var10_47] + Golf.fairwayRadius[var10_47];
                            }
                            if (Golf.fairwayY[var10_47] - Golf.fairwayRadius[var10_47] < var5_39) {
                                var5_39 = Golf.fairwayY[var10_47] - Golf.fairwayRadius[var10_47];
                            }
                            ++var10_47;
                        }
                        var11_48 = 0;
                        while (var11_48 < Golf.greens) {
                            if (Golf.greenX[var11_48] + Golf.greenRadius[var11_48] > var8_43) {
                                var8_43 = Golf.greenX[var11_48] + Golf.greenRadius[var11_48];
                            }
                            if (Golf.greenX[var11_48] - Golf.greenRadius[var11_48] < var7_41) {
                                var7_41 = Golf.greenX[var11_48] - Golf.greenRadius[var11_48];
                            }
                            if (Golf.greenY[var11_48] + Golf.greenRadius[var11_48] > var6_40) {
                                var6_40 = Golf.greenY[var11_48] + Golf.greenRadius[var11_48];
                            }
                            if (Golf.greenY[var11_48] - Golf.greenRadius[var11_48] < var5_39) {
                                var5_39 = Golf.greenY[var11_48] - Golf.greenRadius[var11_48];
                            }
                            ++var11_48;
                        }
                        var12_49 = 0;
                        while (var12_49 < Golf.trees) {
                            if (Golf.treeX[var12_49] + Golf.treeRadius[var12_49] > var8_43) {
                                var8_43 = Golf.treeX[var12_49] + Golf.treeRadius[var12_49];
                            }
                            if (Golf.treeX[var12_49] - Golf.treeRadius[var12_49] < var7_41) {
                                var7_41 = Golf.treeX[var12_49] - Golf.treeRadius[var12_49];
                            }
                            if (Golf.treeY[var12_49] + Golf.treeRadius[var12_49] > var6_40) {
                                var6_40 = Golf.treeY[var12_49] + Golf.treeRadius[var12_49];
                            }
                            if (Golf.treeY[var12_49] - Golf.treeRadius[var12_49] < var5_39) {
                                var5_39 = Golf.treeY[var12_49] - Golf.treeRadius[var12_49];
                            }
                            ++var12_49;
                        }
                        var13_50 = 300 - (var7_41 + var8_43) / 2;
                        var14_51 = 125 - (var5_39 + var6_40) / 2 + 10;
                        Golf.ballX = Golf.teeX += var13_50;
                        Golf.ballY = Golf.teeY += var14_51;
                        var15_52 = 1;
                        while (var15_52 < 5) {
                            Golf.playerSandchk[var15_52] = 0;
                            Golf.playerBallX[var15_52] = Golf.teeX;
                            Golf.playerBallY[var15_52] = Golf.teeY;
                            Golf.playerStrokes[var15_52] = 0;
                            ++var15_52;
                        }
                        Golf.club = 13;
                        Golf.newClub = 1;
                        Golf.aimX = Golf.pinX += var13_50;
                        Golf.aimY = Golf.pinY += var14_51;
                        var16_53 = 0;
                        while (var16_53 < Golf.lakes) {
                            v0 = var16_53;
                            Golf.lakeX[v0] = Golf.lakeX[v0] + var13_50;
                            v1 = var16_53++;
                            Golf.lakeY[v1] = Golf.lakeY[v1] + var14_51;
                        }
                        var17_54 = 0;
                        while (var17_54 < Golf.roughs) {
                            v2 = var17_54;
                            Golf.roughX[v2] = Golf.roughX[v2] + var13_50;
                            v3 = var17_54++;
                            Golf.roughY[v3] = Golf.roughY[v3] + var14_51;
                        }
                        var18_55 = 0;
                        while (var18_55 < Golf.fairways) {
                            v4 = var18_55;
                            Golf.fairwayX[v4] = Golf.fairwayX[v4] + var13_50;
                            v5 = var18_55++;
                            Golf.fairwayY[v5] = Golf.fairwayY[v5] + var14_51;
                        }
                        var19_56 = 0;
                        while (var19_56 < Golf.sandtraps) {
                            v6 = var19_56;
                            Golf.sandX[v6] = Golf.sandX[v6] + var13_50;
                            v7 = var19_56++;
                            Golf.sandY[v7] = Golf.sandY[v7] + var14_51;
                        }
                        var20_57 = 0;
                        while (var20_57 < Golf.greens) {
                            v8 = var20_57;
                            Golf.greenX[v8] = Golf.greenX[v8] + var13_50;
                            v9 = var20_57++;
                            Golf.greenY[v9] = Golf.greenY[v9] + var14_51;
                        }
                        var21_58 = 0;
                        while (var21_58 < Golf.trees) {
                            v10 = var21_58;
                            Golf.treeX[v10] = Golf.treeX[v10] + var13_50;
                            v11 = var21_58++;
                            Golf.treeY[v11] = Golf.treeY[v11] + var14_51;
                        }
                        Golf.magSelected = 0;
                        Golf.holebuilt = 0;
                        Golf.time2read = 0;
                        Golf.lastBallIsOn = 99;
                        Golf.playerClock = 20;
                        Golf.aniClock = 0;
                        Golf.newSlope = 1;
                        Golf.newWind = 1;
                        Golf.newSlope = 1;
                        Golf.windDX = 0;
                        Golf.windDY = 0;
                        while (Golf.windDX < 3 && Golf.windDX > -3) {
                            Golf.windDX = (int) (Math.random() * 15.0) - 7;
                        }
                        while (Golf.windDY < 3 && Golf.windDY > -3) {
                            Golf.windDY = (int) (Math.random() * 15.0) - 7;
                        }
                        Golf.slopeDX = 0;
                        Golf.slopeDY = 0;
                        while (Golf.slopeDX < 2 && Golf.slopeDX > -2) {
                            Golf.slopeDX = (int) (Math.random() * 15.0) - 7;
                        }
                        while (Golf.slopeDY < 2 && Golf.slopeDY > -2) {
                            Golf.slopeDY = (int) (Math.random() * 15.0) - 7;
                        }
                    }
                }
                if (Golf.newPlayer == 1 && Golf.aniClock > 10) {
                    if (Golf.inLake == 1) {
                        Golf.playerClock = 20;
                    }
                    this.nextplayer();
                    Golf.newPlayer = 0;
                }
                if (Golf.button == 1) {
                    Golf.onFairway = 0;
                    var2_3 = 0;
                    while (var2_3 < Golf.fairways) {
                        var3_22 = Golf.fairwayRadius[var2_3];
                        var3_22 *= var3_22;
                        var4_37 = Golf.ballX - Golf.fairwayX[var2_3];
                        if (var3_22 >= (var4_37 *= var4_37)) {
                            var5_39 = (Golf.ballY - Golf.fairwayY[var2_3]) * 2;
                            if (var3_22 >= var4_37 + (var5_39 *= var5_39)) {
                                Golf.onFairway = 1;
                                var2_3 = 999;
                            }
                        }
                        ++var2_3;
                    }
                }
                if (Golf.button == 1) {
                    Golf.inRough = 0;
                    var2_4 = 0;
                    while (var2_4 < Golf.roughs) {
                        var3_23 = Golf.roughRadius[var2_4];
                        var3_23 *= var3_23;
                        var4_37 = Golf.ballX - Golf.roughX[var2_4];
                        if (var3_23 >= (var4_37 *= var4_37)) {
                            var5_39 = (Golf.ballY - Golf.roughY[var2_4]) * 2;
                            if (var3_23 >= var4_37 + (var5_39 *= var5_39)) {
                                Golf.inRough = 1;
                                var2_4 = 999;
                            }
                        }
                        ++var2_4;
                    }
                }
                if (Golf.button == 1) {
                    Golf.inSand = 0;
                    var2_5 = 0;
                    while (var2_5 < Golf.sandtraps) {
                        var3_24 = Golf.sandRadius[var2_5];
                        var3_24 *= var3_24;
                        var4_37 = Golf.ballX - Golf.sandX[var2_5];
                        if (var3_24 >= (var4_37 *= var4_37)) {
                            var5_39 = (Golf.ballY - Golf.sandY[var2_5]) * 2;
                            if (var3_24 >= var4_37 + (var5_39 *= var5_39)) {
                                Golf.inSand = 1;
                                var2_5 = 999;
                            }
                        }
                        ++var2_5;
                    }
                }
                if (Golf.button == 1) {
                    Golf.onGreen = 0;
                    var2_6 = 0;
                    while (var2_6 < Golf.greens) {
                        var3_25 = Golf.greenRadius[var2_6];
                        var3_25 *= var3_25;
                        var4_37 = Golf.ballX - Golf.greenX[var2_6];
                        if (var3_25 >= (var4_37 *= var4_37)) {
                            var5_39 = (Golf.ballY - Golf.greenY[var2_6]) * 2;
                            if (var3_25 >= var4_37 + (var5_39 *= var5_39)) {
                                Golf.onGreen = 1;
                                var2_6 = 999;
                            }
                        }
                        ++var2_6;
                    }
                }
                if (Golf.button == 1) {
                    Golf.inLake = 0;
                    var2_7 = 0;
                    while (var2_7 < Golf.lakes) {
                        var3_26 = Golf.lakeRadius[var2_7];
                        var3_26 *= var3_26;
                        var4_37 = Golf.ballX - Golf.lakeX[var2_7];
                        if (var3_26 >= (var4_37 *= var4_37)) {
                            var5_39 = (Golf.ballY - Golf.lakeY[var2_7]) * 2;
                            if (var3_26 >= var4_37 + (var5_39 *= var5_39)) {
                                Golf.inLake = 1;
                                var2_7 = 999;
                            }
                        }
                        ++var2_7;
                    }
                }
                if (Golf.ballInFlight == 1 && Golf.bounced == 0 && Golf.onGreen == 0) {
                    Golf.ballIsOn = 7;
                    Golf.picked = 1;
                    Golf.inSand = 0;
                }
                if (Golf.picked == 0) {
                    if (Golf.ballX == Golf.teeX && Golf.ballY == Golf.teeY) {
                        Golf.picked = 1;
                        Golf.ballIsOn = 0;
                    }
                    if (Golf.player1Par[Golf.hole] > 0 && Golf.player == 1) {
                        Golf.picked = 1;
                        Golf.ballIsOn = 8;
                    }
                    if (Golf.player2Par[Golf.hole] > 0 && Golf.player == 2) {
                        Golf.picked = 1;
                        Golf.ballIsOn = 8;
                    }
                    if (Golf.player3Par[Golf.hole] > 0 && Golf.player == 3) {
                        Golf.picked = 1;
                        Golf.ballIsOn = 8;
                    }
                    if (Golf.player4Par[Golf.hole] > 0 && Golf.player == 4) {
                        Golf.picked = 1;
                        Golf.ballIsOn = 8;
                    }
                    if (Golf.onGreen == 0 && Golf.magSelected == 1 && Golf.newPlayer == 0 && Golf.ballX != 999 && Golf.ballY != 999) {
                        Golf.magSelected = 0;
                        Golf.holebuilt = 0;
                    }
                    if (Golf.onGreen == 1 && Golf.picked == 0) {
                        if (Golf.ballInFlight == 0) {
                            Golf.club = 12;
                            Golf.newClub = 1;
                        }
                        Golf.picked = 1;
                        Golf.ballIsOn = 4;
                        if (Golf.newPlayer == 0 && Golf.magSelected == 0 && Golf.ballInFlight == 0) {
                            Golf.magSelected = 1;
                            Golf.holebuilt = 0;
                        }
                    }
                    if (Golf.inLake == 1 && Golf.picked == 0 && Golf.onGreen == 0) {
                        Golf.picked = 1;
                        Golf.ballIsOn = 2;
                    }
                    if (Golf.inSand == 1 && Golf.picked == 0 && Golf.inLake == 0 && Golf.onGreen == 0) {
                        Golf.picked = 1;
                        Golf.ballIsOn = 1;
                    }
                    if (Golf.onFairway == 1 && Golf.inSand == 0 && Golf.onGreen == 0 && Golf.picked == 0 && Golf.inLake == 0) {
                        Golf.ballIsOn = 3;
                        Golf.picked = 1;
                    }
                    if (Golf.inRough == 1 && Golf.onFairway == 0 && Golf.inSand == 0 && Golf.onGreen == 0 && Golf.picked == 0 && Golf.inLake == 0) {
                        Golf.ballIsOn = 5;
                        Golf.picked = 1;
                    }
                    if (Golf.picked == 0) {
                        Golf.ballIsOn = 6;
                        Golf.picked = 1;
                    }
                }
                if (Golf.infoBox == 1) {
                    var1_1.setColor(Golf.info1);
                    var1_1.fillRect(Golf.infoX - 20, Golf.infoY - 25, 350, 50);
                    var1_1.setColor(Color.white);
                    var1_1.drawRect(250, 250, 349, 49);
                    var1_1.setColor(Color.lightGray);
                    var1_1.drawRect(251, 251, 347, 47);
                    var1_1.setColor(Color.gray);
                    var1_1.drawRect(252, 252, 345, 45);
                    if (Golf.newCard == 1) {
                        if (Golf.gameOver == 0) {
                            var1_1.setColor(new Color(0, 180, 0));
                            var1_1.fillRect(260, 255, 90, 39);
                            var1_1.setColor(Color.white);
                            var1_1.drawRect(260, 255, 90, 39);
                            var1_1.setColor(Color.lightGray);
                            var1_1.drawRect(261, 256, 88, 37);
                            var1_1.setColor(Color.gray);
                            var1_1.drawRect(262, 257, 86, 35);
                            var1_1.setColor(Color.black);
                            var1_1.drawString("NEXT TEE", 271, 279);
                            var1_1.setColor(Color.white);
                            var1_1.drawString("NEXT TEE", 270, 278);
                        }
                        if (Golf.gameOver == 1) {
                            var1_1.setColor(new Color(0, 180, 0));
                            var1_1.fillRect(260, 255, 120, 39);
                            var1_1.setColor(Color.white);
                            var1_1.drawRect(260, 255, 120, 39);
                            var1_1.setColor(Color.lightGray);
                            var1_1.drawRect(261, 256, 118, 37);
                            var1_1.setColor(Color.gray);
                            var1_1.drawRect(262, 257, 116, 35);
                            var1_1.setColor(Color.black);
                            var1_1.drawString("REPORT SCORE", 271, 279);
                            var1_1.setColor(Color.white);
                            var1_1.drawString("REPORT SCORE", 270, 278);
                        }
                        var1_1.setColor(new Color(180, 0, 0));
                        var1_1.fillRect(500, 255, 90, 39);
                        var1_1.setColor(Color.white);
                        var1_1.drawRect(500, 255, 90, 39);
                        var1_1.setColor(Color.lightGray);
                        var1_1.drawRect(501, 256, 88, 37);
                        var1_1.setColor(Color.gray);
                        var1_1.drawRect(502, 257, 86, 35);
                        var1_1.setColor(Color.black);
                        var1_1.drawString("NEW GAME", 511, 279);
                        var1_1.setColor(Color.white);
                        var1_1.drawString("NEW GAME", 510, 278);
                    } else {
                        var2_8 = 0;
                        while (var2_8 < Golf.playerStrokes[Golf.player]) {
                            var1_1.setColor(Color.gray);
                            var1_1.fillOval(var2_8 * 10 + Golf.infoX + 8 - 3, Golf.infoY + 14 - 2, 7, 7);
                            var1_1.setColor(Color.lightGray);
                            var1_1.fillOval(var2_8 * 10 + Golf.infoX + 8 - 2, Golf.infoY + 14 - 2, 6, 6);
                            var1_1.setColor(Color.white);
                            var1_1.fillOval(var2_8 * 10 + Golf.infoX + 8 - 1, Golf.infoY + 14 - 2, 5, 5);
                            ++var2_8;
                        }
                        var1_1.setColor(Color.black);
                        switch (Golf.hole + Golf.holebase) {
                            case 1: {
                                var1_1.drawString("" + (Golf.holebase + Golf.hole) + "st Hole - Par " + Golf.holePars[Golf.hole + Golf.holebase] + " - " + Golf.holeYards[Golf.hole + Golf.holebase] + "yd", Golf.infoX + 5, Golf.infoY - 11);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (Golf.holebase + Golf.hole) + "st Hole - Par " + Golf.holePars[Golf.hole + Golf.holebase] + " - " + Golf.holeYards[Golf.hole + Golf.holebase] + "yd", Golf.infoX + 5, Golf.infoY - 10);
                                break;
                            }
                            case 2: {
                                var1_1.drawString("" + (Golf.holebase + Golf.hole) + "nd Hole - Par " + Golf.holePars[Golf.hole + Golf.holebase] + " - " + Golf.holeYards[Golf.hole + Golf.holebase] + "yd", Golf.infoX + 5, Golf.infoY - 11);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (Golf.holebase + Golf.hole) + "nd Hole - Par " + Golf.holePars[Golf.hole + Golf.holebase] + " - " + Golf.holeYards[Golf.hole + Golf.holebase] + "yd", Golf.infoX + 5, Golf.infoY - 10);
                                break;
                            }
                            case 3: {
                                var1_1.drawString("" + (Golf.holebase + Golf.hole) + "rd Hole - Par " + Golf.holePars[Golf.hole + Golf.holebase] + " - " + Golf.holeYards[Golf.hole + Golf.holebase] + "yd", Golf.infoX + 5, Golf.infoY - 11);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (Golf.holebase + Golf.hole) + "rd Hole - Par " + Golf.holePars[Golf.hole + Golf.holebase] + " - " + Golf.holeYards[Golf.hole + Golf.holebase] + "yd", Golf.infoX + 5, Golf.infoY - 10);
                                break;
                            }
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18: {
                                var1_1.drawString("" + (Golf.holebase + Golf.hole) + "th Hole - Par " + Golf.holePars[Golf.hole + Golf.holebase] + " - " + Golf.holeYards[Golf.hole + Golf.holebase] + "yd", Golf.infoX + 5, Golf.infoY - 11);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (Golf.holebase + Golf.hole) + "th Hole - Par " + Golf.holePars[Golf.hole + Golf.holebase] + " - " + Golf.holeYards[Golf.hole + Golf.holebase] + "yd", Golf.infoX + 5, Golf.infoY - 10);
                            }
                        }
                        var3_21 = "";
                        var1_1.setColor(Color.black);
                        switch (Golf.player) {
                            case 1: {
                                var3_21 = Golf.p1name;
                                break;
                            }
                            case 2: {
                                var3_21 = Golf.p2name;
                                break;
                            }
                            case 3: {
                                var3_21 = Golf.p3name;
                                break;
                            }
                            case 4: {
                                var3_21 = Golf.p4name;
                            }
                        }
                        var1_1.setColor(Color.black);
                        switch (Golf.ballIsOn) {
                            case 0: {
                                var1_1.drawString("" + (String) var3_21 + "'s at the Tee", Golf.infoX + 5, Golf.infoY + 6 - 1);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (String) var3_21 + "'s at the Tee", Golf.infoX + 5, Golf.infoY + 6);
                                break;
                            }
                            case 1: {
                                var1_1.drawString("" + (String) var3_21 + "'s in the Sand", Golf.infoX + 5, Golf.infoY + 6 - 1);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (String) var3_21 + "'s in the Sand", Golf.infoX + 5, Golf.infoY + 6);
                                break;
                            }
                            case 2: {
                                var1_1.drawString("" + (String) var3_21 + "'s in the Water", Golf.infoX + 5, Golf.infoY + 6 - 1);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (String) var3_21 + "'s in the Water", Golf.infoX + 5, Golf.infoY + 6);
                                break;
                            }
                            case 3: {
                                var1_1.drawString("" + (String) var3_21 + "'s on the Fairway", Golf.infoX + 5, Golf.infoY + 6 - 1);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (String) var3_21 + "'s on the Fairway", Golf.infoX + 5, Golf.infoY + 6);
                                break;
                            }
                            case 4: {
                                var1_1.drawString("" + (String) var3_21 + "'s on the Green", Golf.infoX + 5, Golf.infoY + 6 - 1);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (String) var3_21 + "'s on the Green", Golf.infoX + 5, Golf.infoY + 6);
                                break;
                            }
                            case 5: {
                                var1_1.drawString("" + (String) var3_21 + "'s in light Rough", Golf.infoX + 5, Golf.infoY + 6 - 1);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (String) var3_21 + "'s in light Rough", Golf.infoX + 5, Golf.infoY + 6);
                                break;
                            }
                            case 6: {
                                var1_1.drawString("" + (String) var3_21 + "'s in heavy Rough", Golf.infoX + 5, Golf.infoY + 6 - 1);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (String) var3_21 + "'s in heavy Rough", Golf.infoX + 5, Golf.infoY + 6);
                                break;
                            }
                            case 7: {
                                var1_1.drawString("" + (String) var3_21 + "'s in the Air", Golf.infoX + 5, Golf.infoY + 6 - 1);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (String) var3_21 + "'s in the Air", Golf.infoX + 5, Golf.infoY + 6);
                                break;
                            }
                            case 8: {
                                var1_1.drawString("" + (String) var3_21 + "'s in the HOLE", Golf.infoX + 5, Golf.infoY + 6 - 1);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + (String) var3_21 + "'s in the HOLE", Golf.infoX + 5, Golf.infoY + 6);
                            }
                        }
                    }
                    Golf.infoBox = 0;
                }
                if (Golf.newCard == 1) {
                    if (Golf.newCardRefresh == 1) {
                        Golf.newCardRefresh = 0;
                        if (Golf.round > 0) {
                            this.readtourdata();
                        }
                        var1_1.setColor(Golf.info1);
                        var1_1.fillRect(8, 38, 585, 190);
                        var1_1.setColor(Color.white);
                        var1_1.drawRect(5, 35, 590, 194);
                        var1_1.setColor(Color.lightGray);
                        var1_1.drawRect(6, 36, 588, 192);
                        var1_1.setColor(Color.gray);
                        var1_1.drawRect(7, 37, 586, 190);
                        var1_1.setColor(Color.white);
                        var1_1.drawRect(5, 50, 590, 132);
                        var1_1.setColor(Color.lightGray);
                        var1_1.drawRect(6, 51, 588, 130);
                        var1_1.setColor(Color.gray);
                        var1_1.drawRect(7, 52, 586, 128);
                        var1_1.setColor(new Color(0, 0, 180));
                        var1_1.fillRect(8, 53, 585, 44);
                        var1_1.setColor(Color.black);
                        var1_1.drawString("Yards", 41, 65);
                        var1_1.setColor(Color.white);
                        var1_1.drawString("Yards", 40, 64);
                        Golf.frontYards = 0;
                        var2_9 = 1;
                        while (var2_9 < 10) {
                            var3_27 = Golf.holeYards[var2_9 + Golf.holebase];
                            Golf.frontYards += var3_27;
                            if (var3_27 > 0) {
                                var1_1.setColor(Color.black);
                                var1_1.drawString("" + var3_27, 63 + var2_9 * 29, 65);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + var3_27, 62 + var2_9 * 29, 64);
                            }
                            ++var2_9;
                        }
                        var1_1.setColor(Color.black);
                        var1_1.drawString("" + Golf.frontYards, 353, 65);
                        var1_1.setColor(Color.white);
                        var1_1.drawString("" + Golf.frontYards, 352, 64);
                        var1_1.setColor(Color.blue);
                        var1_1.fillRect(8, 8, 175, 17);
                        var1_1.setColor(Color.white);
                        var1_1.drawRect(5, 5, 180, 22);
                        var1_1.setColor(Color.lightGray);
                        var1_1.drawRect(6, 6, 178, 20);
                        var1_1.setColor(Color.gray);
                        var1_1.drawRect(7, 7, 176, 18);
                        var1_1.setColor(Color.black);
                        var1_1.drawString("VIEW LEADER BOARD", 26, 22);
                        var1_1.setColor(Color.white);
                        var1_1.drawString("VIEW LEADER BOARD", 25, 21);
                        var1_1.setColor(Color.black);
                        var1_1.drawString("PAR", 46, 80);
                        var1_1.setColor(Color.white);
                        var1_1.drawString("PAR", 45, 79);
                        Golf.frontPar = 0;
                        var3_28 = 1;
                        while (var3_28 < 10) {
                            var4_37 = Golf.holePars[var3_28 + Golf.holebase];
                            Golf.frontPar += var4_37;
                            if (var4_37 > 0) {
                                var1_1.setColor(Color.black);
                                var1_1.drawString("" + var4_37, 63 + var3_28 * 29 + 7, 80);
                                var1_1.setColor(Color.white);
                                var1_1.drawString("" + var4_37, 62 + var3_28 * 29 + 7, 79);
                            }
                            ++var3_28;
                        }
                        var1_1.setColor(Color.black);
                        var1_1.drawString("" + Golf.frontPar, 360, 80);
                        var1_1.setColor(Color.white);
                        var1_1.drawString("" + Golf.frontPar, 359, 79);
                        var1_1.setColor(Color.white);
                        var4_37 = 30;
                        while (var4_37 < 124) {
                            var1_1.fillRect(8, 53 + var4_37, 585, 1);
                            ++var4_37;
                        }
                        var5_39 = 22;
                        while (var5_39 < 35) {
                            var1_1.setColor(Golf.green2);
                            var1_1.fillRect(8, 53 + var5_39 + 92, 585, 1);
                            ++var5_39;
                        }
                        var1_1.setColor(new Color(255, 220, 220));
                        var1_1.fillRect(8, 84, 585, 19);
                        var1_1.fillRect(8, 105, 585, 19);
                        var1_1.fillRect(8, 126, 585, 19);
                        var1_1.fillRect(8, 147, 585, 19);
                        var1_1.setColor(Color.lightGray);
                        var6_40 = 1;
                        while (var6_40 < 11) {
                            var1_1.drawRect(60 + var6_40 * 29 - 2, 64, 1, 114);
                            ++var6_40;
                        }
                        var7_41 = 0;
                        var8_43 = 1;
                        while (var8_43 < Golf.hole) {
                            var7_41 += Golf.holePars[var8_43 + Golf.holebase];
                            ++var8_43;
                        }
                        var9_44 = 0;
                        if (Golf.numOfPlayers > 0) {
                            var1_1.setColor(Color.black);
                            var1_1.drawString("" + Golf.p1name, 10, 98);
                            var9_44 = 0;
                            var10_47 = 1;
                            while (var10_47 < 10) {
                                var11_48 = Golf.player1Par[var10_47];
                                var9_44 += var11_48;
                                if (var11_48 > 0) {
                                    var1_1.setColor(Color.black);
                                    var1_1.drawString("" + var11_48, 62 + var10_47 * 29 + 7, 98);
                                    var1_1.setColor(Color.red);
                                    if (var11_48 <= Golf.holePars[var10_47 + Golf.holebase] - 1) {
                                        var1_1.drawOval(60 + var10_47 * 29 + 4, 86, 18, 14);
                                    }
                                    if (var11_48 <= Golf.holePars[var10_47 + Golf.holebase] - 2) {
                                        var1_1.drawOval(60 + var10_47 * 29 + 4 - 2, 84, 22, 18);
                                    }
                                    var1_1.setColor(Color.blue);
                                    if (var11_48 >= Golf.holePars[var10_47 + Golf.holebase] + 1) {
                                        var1_1.drawRect(60 + var10_47 * 29 + 4, 86, 18, 14);
                                    }
                                    if (var11_48 >= Golf.holePars[var10_47 + Golf.holebase] + 2) {
                                        var1_1.drawRect(60 + var10_47 * 29 + 4 - 2, 84, 22, 18);
                                    }
                                }
                                ++var10_47;
                            }
                            var1_1.setColor(Color.black);
                            if (var9_44 == var7_41) {
                                var1_1.drawString("" + var9_44 + " (Even)", 359, 98);
                            }
                            if (var9_44 > var7_41) {
                                var1_1.drawString("" + var9_44 + " (+" + (var9_44 - var7_41) + " over)", 359, 98);
                            }
                            if (var9_44 < var7_41) {
                                var1_1.setColor(Color.red);
                                var1_1.drawString("" + var9_44 + " (" + (var9_44 - var7_41) + " under)", 359, 98);
                                var1_1.setColor(Color.black);
                                var1_1.drawString("" + var9_44, 359, 98);
                            }
                            Golf.honor[1] = var9_44;
                            if (Golf.gameOver == 1) {
                                Golf.player1Total = var9_44;
                            }
                        }
                        if (Golf.numOfPlayers > 1) {
                            var1_1.setColor(Color.black);
                            var1_1.drawString("" + Golf.p2name, 10, 119);
                            var9_44 = 0;
                            var10_47 = 1;
                            while (var10_47 < 10) {
                                var11_48 = Golf.player2Par[var10_47];
                                var9_44 += var11_48;
                                if (var11_48 > 0) {
                                    var1_1.setColor(Color.black);
                                    var1_1.drawString("" + var11_48, 62 + var10_47 * 29 + 7, 119);
                                    var1_1.setColor(Color.red);
                                    if (var11_48 <= Golf.holePars[var10_47 + Golf.holebase] - 1) {
                                        var1_1.drawOval(60 + var10_47 * 29 + 4, 107, 18, 14);
                                    }
                                    if (var11_48 <= Golf.holePars[var10_47 + Golf.holebase] - 2) {
                                        var1_1.drawOval(60 + var10_47 * 29 + 4 - 2, 105, 22, 18);
                                    }
                                    var1_1.setColor(Color.blue);
                                    if (var11_48 >= Golf.holePars[var10_47 + Golf.holebase] + 1) {
                                        var1_1.drawRect(60 + var10_47 * 29 + 4, 107, 18, 14);
                                    }
                                    if (var11_48 >= Golf.holePars[var10_47 + Golf.holebase] + 2) {
                                        var1_1.drawRect(60 + var10_47 * 29 + 4 - 2, 105, 22, 18);
                                    }
                                }
                                ++var10_47;
                            }
                            var1_1.setColor(Color.black);
                            if (var9_44 == var7_41) {
                                var1_1.drawString("" + var9_44 + " (Even)", 359, 119);
                            }
                            if (var9_44 > var7_41) {
                                var1_1.drawString("" + var9_44 + " (+" + (var9_44 - var7_41) + " over)", 359, 119);
                            }
                            if (var9_44 < var7_41) {
                                var1_1.setColor(Color.red);
                                var1_1.drawString("" + var9_44 + " (" + (var9_44 - var7_41) + " under)", 359, 119);
                                var1_1.setColor(Color.black);
                                var1_1.drawString("" + var9_44, 359, 119);
                            }
                            Golf.honor[2] = var9_44;
                            if (Golf.gameOver == 1) {
                                Golf.player2Total = var9_44;
                            }
                        }
                        if (Golf.numOfPlayers > 2) {
                            var1_1.setColor(Color.black);
                            var1_1.drawString("" + Golf.p3name, 10, 140);
                            var9_44 = 0;
                            var10_47 = 1;
                            while (var10_47 < 10) {
                                var11_48 = Golf.player3Par[var10_47];
                                var9_44 += var11_48;
                                if (var11_48 > 0) {
                                    var1_1.setColor(Color.black);
                                    var1_1.drawString("" + var11_48, 62 + var10_47 * 29 + 7, 140);
                                    var1_1.setColor(Color.red);
                                    if (var11_48 <= Golf.holePars[var10_47 + Golf.holebase] - 1) {
                                        var1_1.drawOval(60 + var10_47 * 29 + 4, 128, 18, 14);
                                    }
                                    if (var11_48 <= Golf.holePars[var10_47 + Golf.holebase] - 2) {
                                        var1_1.drawOval(60 + var10_47 * 29 + 4 - 2, 126, 22, 18);
                                    }
                                    var1_1.setColor(Color.blue);
                                    if (var11_48 >= Golf.holePars[var10_47 + Golf.holebase] + 1) {
                                        var1_1.drawRect(60 + var10_47 * 29 + 4, 128, 18, 14);
                                    }
                                    if (var11_48 >= Golf.holePars[var10_47 + Golf.holebase] + 2) {
                                        var1_1.drawRect(60 + var10_47 * 29 + 4 - 2, 126, 22, 18);
                                    }
                                }
                                ++var10_47;
                            }
                            var1_1.setColor(Color.black);
                            if (var9_44 == var7_41) {
                                var1_1.drawString("" + var9_44 + " (Even)", 359, 140);
                            }
                            if (var9_44 > var7_41) {
                                var1_1.drawString("" + var9_44 + " (+" + (var9_44 - var7_41) + " over)", 359, 140);
                            }
                            if (var9_44 < var7_41) {
                                var1_1.setColor(Color.red);
                                var1_1.drawString("" + var9_44 + " (" + (var9_44 - var7_41) + " under)", 359, 140);
                                var1_1.setColor(Color.black);
                                var1_1.drawString("" + var9_44, 359, 140);
                            }
                            Golf.honor[3] = var9_44;
                            if (Golf.gameOver == 1) {
                                Golf.player3Total = var9_44;
                            }
                        }
                        if (Golf.numOfPlayers > 3) {
                            var1_1.setColor(Color.black);
                            var1_1.drawString("" + Golf.p4name, 10, 161);
                            var9_44 = 0;
                            var10_47 = 1;
                            while (var10_47 < 10) {
                                var11_48 = Golf.player4Par[var10_47];
                                var9_44 += var11_48;
                                if (var11_48 > 0) {
                                    var1_1.setColor(Color.black);
                                    var1_1.drawString("" + var11_48, 62 + var10_47 * 29 + 7, 161);
                                    var1_1.setColor(Color.red);
                                    if (var11_48 <= Golf.holePars[var10_47 + Golf.holebase] - 1) {
                                        var1_1.drawOval(60 + var10_47 * 29 + 4, 149, 18, 14);
                                    }
                                    if (var11_48 <= Golf.holePars[var10_47 + Golf.holebase] - 2) {
                                        var1_1.drawOval(60 + var10_47 * 29 + 4 - 2, 147, 22, 18);
                                    }
                                    var1_1.setColor(Color.blue);
                                    if (var11_48 >= Golf.holePars[var10_47 + Golf.holebase] + 1) {
                                        var1_1.drawRect(60 + var10_47 * 29 + 4, 149, 14, 14);
                                    }
                                    if (var11_48 >= Golf.holePars[var10_47 + Golf.holebase] + 2) {
                                        var1_1.drawRect(60 + var10_47 * 29 + 4 - 2, 147, 22, 18);
                                    }
                                }
                                ++var10_47;
                            }
                            var1_1.setColor(Color.black);
                            if (var9_44 == var7_41) {
                                var1_1.drawString("" + var9_44 + " (Even)", 359, 161);
                            }
                            if (var9_44 > var7_41) {
                                var1_1.drawString("" + var9_44 + " (+" + (var9_44 - var7_41) + " over)", 359, 161);
                            }
                            if (var9_44 < var7_41) {
                                var1_1.setColor(Color.red);
                                var1_1.drawString("" + var9_44 + " (" + (var9_44 - var7_41) + " under)", 359, 161);
                                var1_1.setColor(Color.black);
                                var1_1.drawString("" + var9_44, 359, 161);
                            }
                            Golf.honor[4] = var9_44;
                            if (Golf.gameOver == 1) {
                                Golf.player4Total = var9_44;
                            }
                        }
                        var1_1.setColor(Color.black);
                        var1_1.drawString("Hole", 41, 180);
                        var1_1.setColor(Color.white);
                        var1_1.drawString("Hole", 40, 179);
                        var10_47 = 1;
                        while (var10_47 < 10) {
                            var1_1.setColor(Color.black);
                            var1_1.drawString("" + (Golf.holebase + var10_47), 63 + var10_47 * 29 + 7, 180);
                            var1_1.setColor(Color.white);
                            var1_1.drawString("" + (Golf.holebase + var10_47), 62 + var10_47 * 29 + 7, 179);
                            ++var10_47;
                        }
                        if (Golf.holebase == 0) {
                            var1_1.setColor(Color.black);
                            var1_1.drawString("FRONT 9 Total", 360, 180);
                            var1_1.setColor(Color.white);
                            var1_1.drawString("FRONT 9 Total", 359, 179);
                        }
                        if (Golf.holebase == 9) {
                            var1_1.setColor(Color.black);
                            var1_1.drawString("BACK 9 Total", 360, 180);
                            var1_1.setColor(Color.white);
                            var1_1.drawString("BACK 9 Total", 359, 179);
                        }
                    }
                    return;
                }
                if (Golf.leaderBoard == 1) {
                    if (Golf.leaderRefresh == 1) {
                        if (Golf.gameOver == 1 && Golf.reportIn == 1) {
                            this.writetourdata();
                            Golf.reportIn = 0;
                        } else {
                            this.readtourdata();
                        }
                        Golf.leaderRefresh = 0;
                        Golf.bigRefresh2 = 0;
                        var1_1.setColor(Color.blue);
                        var1_1.fillRect(8, 8, 175, 17);
                        var1_1.setColor(Color.white);
                        var1_1.drawRect(5, 5, 180, 22);
                        var1_1.setColor(Color.lightGray);
                        var1_1.drawRect(6, 6, 178, 20);
                        var1_1.setColor(Color.gray);
                        var1_1.drawRect(7, 7, 176, 18);
                        var1_1.setColor(Color.black);
                        var1_1.drawString("VIEW SCORECARD", 26, 22);
                        var1_1.setColor(Color.white);
                        var1_1.drawString("VIEW SCORECARD", 25, 21);
                        var1_1.setColor(Golf.info1);
                        var1_1.fillRect(8, 38, 585, 190);
                        var1_1.setColor(Color.black);
                        var1_1.drawString("CURRENT SabGOLF LEADER BOARD", 29, 57);
                        var1_1.setColor(Color.white);
                        var1_1.drawString("CURRENT SabGOLF LEADER BOARD", 28, 56);
                        var1_1.setColor(Golf.sand4);
                        var2_10 = 0;
                        while (var2_10 < 10) {
                            var1_1.fillRect(12, 80 + var2_10 * 14 - 10, 577, 13);
                            ++var2_10;
                        }
                        var1_1.setColor(Golf.info1);
                        var1_1.fillRect(10, 66, 3, 150);
                        var1_1.fillRect(210, 66, 3, 150);
                        var1_1.fillRect(410, 66, 3, 150);
                        var1_1.fillRect(587, 66, 3, 150);
                        var1_1.setColor(Color.white);
                        var1_1.drawRect(5, 35, 590, 194);
                        var1_1.setColor(Color.lightGray);
                        var1_1.drawRect(6, 36, 588, 192);
                        var1_1.setColor(Color.gray);
                        var1_1.drawRect(7, 37, 586, 190);
                        var3_21 = "";
                        if (Golf.tourdata.length() > 0) {
                            var4_38 = new StringTokenizer(Golf.tourdata, "+");
                            var5_39 = 0;
                            while (var5_39 < 3) {
                                var6_40 = 0;
                                while (var6_40 < 10) {
                                    if (var4_38.hasMoreTokens()) {
                                        var3_21 = var4_38.nextToken();
                                    }
                                    if (var5_39 * 10 + var6_40 + 1 > 1) {
                                        var3_21 = var3_21.substring(1, var3_21.length());
                                    }
                                    var7_41 = Integer.parseInt((String) var3_21);
                                    var8_43 = var7_41 - 36;
                                    if (var4_38.hasMoreTokens()) {
                                        var3_21 = var4_38.nextToken();
                                    }
                                    var9_46 = var3_21;
                                    if (var8_43 == 0) {
                                        var1_1.setColor(Color.black);
                                        var1_1.drawString("" + var7_41 + " (E)", var5_39 * 200 + 20, 80 + var6_40 * 14);
                                    }
                                    if (var8_43 > 0) {
                                        var1_1.setColor(Color.black);
                                        var1_1.drawString("" + var7_41 + " (+" + var8_43 + ")", var5_39 * 200 + 20, 80 + var6_40 * 14);
                                    }
                                    if (var8_43 < 0) {
                                        var1_1.setColor(Color.red);
                                        var1_1.drawString("" + var7_41 + " (" + var8_43 + ")", var5_39 * 200 + 20, 80 + var6_40 * 14);
                                        var1_1.setColor(Color.black);
                                        var1_1.drawString("" + var7_41, var5_39 * 200 + 20, 80 + var6_40 * 14);
                                    }
                                    var1_1.setColor(Color.black);
                                    var1_1.drawString("" + (String) var9_46, var5_39 * 200 + 76, 80 + var6_40 * 14);
                                    ++var6_40;
                                }
                                ++var5_39;
                            }
                        }
                    }
                    return;
                }
                if (Golf.keyFace == 1) {
                    if (Golf.keyRefresh == 1) {
                        Golf.keyRefresh = 0;
                        ++Golf.keyClock;
                        if (Golf.keyBack == 1) {
                            Golf.keyBack = 0;
                            var2_11 = Golf.gold.getGraphics();
                            var2_11.setColor(new Color(26, 156, 26));
                            var2_11.fillRect(0, 0, 600, 300);
                            var3_21 = Golf.info1;
                            var4_37 = 172;
                            --var4_37;
                            var4_37 -= 2;
                            var5_39 = -11;
                            while (var5_39 < 12) {
                                var2_11.setColor((Color) var3_21);
                                var2_11.drawLine(var4_37 + 50 + 12 - 3, 263, var4_37 + 50 + 12 + var5_39 - 3, 241);
                                ++var5_39;
                            }
                            var6_40 = var4_37 + 50 + 13 - 3;
                            var7_41 = 228;
                            var8_43 = 0;
                            var9_44 = 14;
                            while (var9_44 > 0) {
                                var2_11.setColor(new Color(255 - var9_44 * 3, 255 - 3 * var9_44, 255 - 3 * var9_44));
                                var2_11.fillOval(var6_40 - var9_44 - var8_43 / 4, var7_41 - var9_44 + var8_43 * 2 / 3, var9_44 * 2, var9_44 * 2);
                                --var8_43;
                                --var9_44;
                            }
                            var2_11.setColor(Color.black);
                            var2_11.drawString("SAB", var4_37 + 47, 232);
                            var10_47 = (600 - var2_11.getFontMetrics().stringWidth("SabGOLF v1.3 (c)19971105 Steve A. Baker, All Rights Reserved")) / 2;
                            var2_11.drawString("SabGOLF v1.3 (c)19971105 Steve A. Baker, All Rights Reserved", var10_47, 280);
                            var4_37 -= 2;
                            var2_11.setColor((Color) var3_21);
                            var2_11.fillOval(--var4_37 + 100 - 5, 217, 35, 47);
                            var2_11.setColor(new Color(26, 156, 26));
                            var2_11.fillOval(var4_37 + 100 + 8 - 5, 225, 19, 31);
                            var2_11.fillRect(var4_37 + 100 + 15 - 5 - 10 + 12, 235, 18, 4);
                            var2_11.setColor((Color) var3_21);
                            var2_11.fillRect(var4_37 + 100 + 15 - 5 - 10 + 12, 239, 18, 8);
                            var6_40 = (var4_37 -= 13) + 150 + 18;
                            var7_41 = 240;
                            var8_43 = 0;
                            var2_11.setColor((Color) var3_21);
                            var2_11.fillOval(var6_40 - 23, var7_41 - 23, 47, 47);
                            var11_48 = 15;
                            while (var11_48 > 14) {
                                var2_11.setColor(Golf.rough1);
                                var2_11.fillOval(var6_40 - var11_48 - var8_43 / 4, var7_41 - var11_48 + var8_43 * 2 / 3, var11_48 * 2 + 1, var11_48 * 2 + 1);
                                --var11_48;
                            }
                            var2_11.setColor(Color.black);
                            var2_11.fillRect(var6_40 - 1, var7_41 - 1, 3, 2);
                            var2_11.setColor(Color.white);
                            var2_11.fillRect(var6_40, var7_41 - 10, 1, 10);
                            var2_11.setColor(Color.orange);
                            var2_11.fillRect(var6_40 + 1, var7_41 - 10, 3, 3);
                            var2_11.setColor((Color) var3_21);
                            var2_11.fillOval((var4_37 -= 2) + 200 - 4, 241, 23, 23);
                            var2_11.setColor(new Color(26, 156, 26));
                            var2_11.fillOval(var4_37 + 200 - 4 + 8, 249, 7, 7);
                            var2_11.fillRect(var4_37 + 200 - 4 + 8, 216, 15, 37);
                            var2_11.setColor((Color) var3_21);
                            var2_11.fillRect(var4_37 + 200 - 4, 216, 8, 37);
                            var2_11.setColor((Color) var3_21);
                            var2_11.fillOval((var4_37 += 10) + 215 - 4, 216, 23, 23);
                            var2_11.setColor(new Color(26, 156, 26));
                            var2_11.fillOval(var4_37 + 215 - 4 + 8, 224, 7, 7);
                            var2_11.fillRect(var4_37 + 215 - 4 + 8, 230, 15, 37);
                            var2_11.setColor((Color) var3_21);
                            var2_11.fillRect(var4_37 + 215 - 4, 228, 8, 35);
                            var2_11.fillRect(var4_37 + 215 - 4 + 8, 232, 15, 8);
                            var2_11.dispose();
                        }
                        var2_12 = Golf.gold.getGraphics();
                        var2_12.setColor(Color.white);
                        var2_12.drawRect(5, 5, 590, 194);
                        var2_12.setColor(Color.lightGray);
                        var2_12.drawRect(6, 6, 588, 192);
                        var2_12.setColor(Color.gray);
                        var2_12.drawRect(7, 7, 586, 190);
                        var3_29 = 0;
                        while (var3_29 < 180) {
                            var2_12.setColor(new Color(0, 0, 160 + var3_29 / 2));
                            var2_12.fillRect(8, 8 + var3_29, 585, 1);
                            ++var3_29;
                        }
                        var4_37 = 0;
                        while (var4_37 < 29) {
                            var2_12.setColor(new Color(0, 80 + (var4_37 + 20) * 2, 0));
                            var2_12.fillRect(8, 168 + var4_37, 585, 1);
                            ++var4_37;
                        }
                        var2_12.setColor(Color.white);
                        var2_12.drawString("Who will be playing today?  (1 to 4 players)", 28, 26);
                        switch (Golf.player) {
                            case 1: {
                                Golf.p1name = Golf.tname;
                                break;
                            }
                            case 2: {
                                Golf.p2name = Golf.tname;
                                break;
                            }
                            case 3: {
                                Golf.p3name = Golf.tname;
                                break;
                            }
                            case 4: {
                                Golf.p4name = Golf.tname;
                            }
                        }
                        var5_39 = 0;
                        while (var5_39 < 20) {
                            var2_12.setColor(new Color(0, 0, 160 + var5_39 / 2));
                            var2_12.fillRect(490, 175 + var5_39, 100, 1);
                            var2_12.fillRect(360, 175 + var5_39, 100, 1);
                            ++var5_39;
                        }
                        var2_12.setColor(Color.blue);
                        if (Golf.p1name.length() > 1 && Golf.p2name.length() != 1 && Golf.p3name.length() != 1 && Golf.p4name.length() != 1) {
                            var2_12.setColor(Color.white);
                        }
                        var2_12.drawString("Play Front-9", 370, 190);
                        var2_12.drawString("Play Back-9", 500, 190);
                        var2_12.setColor(Color.white);
                        var2_12.drawRect(490, 175, 100, 20);
                        var2_12.setColor(Color.lightGray);
                        var2_12.drawRect(491, 176, 98, 18);
                        var2_12.setColor(Color.gray);
                        var2_12.drawRect(492, 177, 96, 16);
                        var2_12.setColor(Color.white);
                        var2_12.drawRect(360, 175, 100, 20);
                        var2_12.setColor(Color.lightGray);
                        var2_12.drawRect(361, 176, 98, 18);
                        var2_12.setColor(Color.gray);
                        var2_12.drawRect(362, 177, 96, 16);
                        var2_12.setColor(Color.white);
                        var2_12.drawString("Welcome to the Brookdale Country Club", 20, 190);
                        var2_12.setColor(Color.white);
                        var6_40 = 1;
                        while (var6_40 < 10) {
                            var2_12.fillRect(var6_40 + 550, 50 - var6_40, 1, var6_40 * 2);
                            ++var6_40;
                        }
                        var2_12.fillRect(560, 48, 10, 5);
                        var2_12.setColor(Color.black);
                        var2_12.setColor(new Color(255, 220, 220));
                        if (Golf.player == 1) {
                            var2_12.setColor(new Color(255, 160, 160));
                        }
                        var2_12.fillRect(8, 84, 585, 19);
                        var2_12.setColor(new Color(255, 220, 220));
                        if (Golf.player == 2) {
                            var2_12.setColor(new Color(255, 160, 160));
                        }
                        var2_12.fillRect(8, 105, 585, 19);
                        var2_12.setColor(new Color(255, 220, 220));
                        if (Golf.player == 3) {
                            var2_12.setColor(new Color(255, 160, 160));
                        }
                        var2_12.fillRect(8, 126, 585, 19);
                        var2_12.setColor(new Color(255, 220, 220));
                        if (Golf.player == 4) {
                            var2_12.setColor(new Color(255, 160, 160));
                        }
                        var2_12.fillRect(8, 147, 585, 19);
                        var2_12.setColor(Color.black);
                        if (Golf.player == 1) {
                            var2_12.drawString("" + Golf.p1name + "_", 53, 96);
                        } else {
                            var2_12.drawString("" + Golf.p1name, 53, 96);
                        }
                        if (Golf.player == 2) {
                            var2_12.drawString("" + Golf.p2name + "_", 53, 117);
                        } else {
                            var2_12.drawString("" + Golf.p2name, 53, 117);
                        }
                        if (Golf.player == 3) {
                            var2_12.drawString("" + Golf.p3name + "_", 53, 138);
                        } else {
                            var2_12.drawString("" + Golf.p3name, 53, 138);
                        }
                        if (Golf.player == 4) {
                            var2_12.drawString("" + Golf.p4name + "_", 53, 159);
                        } else {
                            var2_12.drawString("" + Golf.p4name, 53, 159);
                        }
                        var7_41 = 1;
                        while (var7_41 < 27) {
                            var2_12.setColor(Color.white);
                            switch (var7_41) {
                                case 1: {
                                    var2_12.drawString("A", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("a", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 2: {
                                    var2_12.drawString("B", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("b", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 3: {
                                    var2_12.drawString("C", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("c", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 4: {
                                    var2_12.drawString("D", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("d", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 5: {
                                    var2_12.drawString("E", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("e", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 6: {
                                    var2_12.drawString("F", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("f", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 7: {
                                    var2_12.drawString("G", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("g", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 8: {
                                    var2_12.drawString("H", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("h", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 9: {
                                    var2_12.drawString("I", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("i", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 10: {
                                    var2_12.drawString("J", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("j", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 11: {
                                    var2_12.drawString("K", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("k", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 12: {
                                    var2_12.drawString("L", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("l", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 13: {
                                    var2_12.drawString("M", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("m", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 14: {
                                    var2_12.drawString("N", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("n", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 15: {
                                    var2_12.drawString("O", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("o", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 16: {
                                    var2_12.drawString("P", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("p", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 17: {
                                    var2_12.drawString("Q", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("q", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 18: {
                                    var2_12.drawString("R", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("r", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 19: {
                                    var2_12.drawString("S", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("s", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 20: {
                                    var2_12.drawString("T", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("t", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 21: {
                                    var2_12.drawString("U", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("u", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 22: {
                                    var2_12.drawString("V", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("v", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 23: {
                                    var2_12.drawString("W", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("w", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 24: {
                                    var2_12.drawString("X", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("x", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 25: {
                                    var2_12.drawString("Y", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("y", var7_41 * 20 + 8, 46);
                                    break;
                                }
                                case 26: {
                                    var2_12.drawString("Z", var7_41 * 20 + 8, 66);
                                    var2_12.drawString("z", var7_41 * 20 + 8, 46);
                                }
                            }
                            ++var7_41;
                        }
                        var1_1.drawImage(Golf.gold, 0, 0, null);
                        var2_12.dispose();
                    }
                    return;
                }
                if (Golf.newSlope == 1) {
                    var2_13 = Golf.greenslope.getGraphics();
                    Golf.newSlope = 0;
                    var2_13.setColor(Color.white);
                    var2_13.drawRect(0, 0, 50, 49);
                    var2_13.setColor(Color.lightGray);
                    var2_13.drawRect(1, 1, 48, 47);
                    var2_13.setColor(Color.gray);
                    var2_13.drawRect(2, 2, 46, 45);
                    var2_13.setColor(new Color(40, 140, 60));
                    var2_13.fillRect(3, 3, 45, 44);
                    var3_30 = Golf.slopeDX * 10;
                    var4_37 = Golf.slopeDY * 10;
                    while (var3_30 * var3_30 + var4_37 * var4_37 > 441) {
                        var3_30 /= 2;
                        var4_37 /= 2;
                    }
                    while (var3_30 * var3_30 + var4_37 * var4_37 < 441) {
                        var3_30 += var3_30 / 4;
                        var4_37 += var4_37 / 4;
                    }
                    var5_39 = 25;
                    if (Golf.slopeDY < 0) {
                        var5_39 -= 2;
                    }
                    var2_13.setColor(new Color(0, 200, 120));
                    var2_13.fillOval(5, var5_39 - 20, 40, 40);
                    var6_40 = (Golf.slopeDX * Golf.slopeDX + Golf.slopeDY * Golf.slopeDY) / 10;
                    var7_41 = 11 - var6_40;
                    var2_13.setColor(Color.green);
                    var8_43 = 20;
                    while (var8_43 > 0) {
                        var9_44 = var3_30 * (22 - var8_43) / 24;
                        var10_47 = var4_37 * (22 - var8_43) / 24;
                        var2_13.drawOval(25 - var9_44 - var8_43, var5_39 - var10_47 - var8_43, var8_43 * 2, var8_43 * 2);
                        var8_43 -= var7_41;
                    }
                    var2_13.setColor(Color.black);
                    var2_13.fillRect(24, var5_39 - 1, 3, 2);
                    var2_13.setColor(Color.white);
                    var2_13.fillRect(25, var5_39 - 10, 1, 10);
                    var2_13.setColor(Color.orange);
                    if (Golf.windDX > 0) {
                        var2_13.fillRect(26, var5_39 - 10, 3, 3);
                    } else {
                        var2_13.fillRect(22, var5_39 - 10, 3, 3);
                    }
                    var1_1.drawImage(Golf.greenslope, 200, 250, null);
                    var2_13.dispose();
                }
                if (Golf.newWind == 1) {
                    var2_14 = Golf.wind.getGraphics();
                    Golf.newWind = 0;
                    var2_14.setColor(Color.white);
                    var2_14.drawRect(0, 0, 50, 49);
                    var2_14.setColor(Color.lightGray);
                    var2_14.drawRect(1, 1, 48, 47);
                    var2_14.setColor(Color.gray);
                    var2_14.drawRect(2, 2, 46, 45);
                    var3_31 = 0;
                    while (var3_31 < 44) {
                        var2_14.setColor(new Color(50 + var3_31 * 2, 110 + var3_31 * 2, 160 + var3_31 * 2));
                        var2_14.fillRect(3, 3 + var3_31, 45, 1);
                        ++var3_31;
                    }
                    if (Golf.windDY >= 0) {
                        var2_14.setColor(Color.orange);
                        var2_14.fillRect(24, 15, 3, 32);
                        var2_14.setColor(Color.yellow);
                        var2_14.fillRect(25, 15, 1, 32);
                    }
                    if (Golf.windDY < 0 && Golf.windDX > 0) {
                        var2_14.setColor(Color.orange);
                        var2_14.fillRect(22, 15, 3, 32);
                        var2_14.setColor(Color.yellow);
                        var2_14.fillRect(23, 15, 1, 32);
                    }
                    if (Golf.windDY < 0 && Golf.windDX < 0) {
                        var2_14.setColor(Color.orange);
                        var2_14.fillRect(26, 15, 3, 32);
                        var2_14.setColor(Color.yellow);
                        var2_14.fillRect(27, 15, 1, 32);
                    }
                    var2_14.dispose();
                }
                if (Golf.ballInFlight == 0) {
                    var2_15 = Golf.wind.getGraphics();
                    var3_32 = Golf.aniClock % 16;
                    var4_37 = 0;
                    while (var4_37 < 16) {
                        var5_39 = (var3_32 + var4_37) % 16 * 4 + (int) (Math.random() * 4.0);
                        if (var5_39 > 32) {
                            var5_39 -= 32;
                        }
                        var2_15.setColor(new Color(var5_39 * 2 + 180, var5_39 * 8 / 5 + 120, var5_39 + 50));
                        var2_15.drawLine(25, 16 + var4_37, 25 + Golf.windDX * 2, 16 + var4_37 + Golf.windDY * 2);
                        ++var4_37;
                    }
                    var1_1.drawImage(Golf.wind, 150, 250, null);
                    var2_15.dispose();
                }
                if (Golf.newPower == 1) {
                    var2_16 = Golf.powerbar.getGraphics();
                    Golf.newPower = 0;
                    var2_16.setColor(Color.white);
                    var2_16.drawRect(0, 0, 50, 49);
                    var2_16.setColor(Color.lightGray);
                    var2_16.drawRect(1, 1, 48, 47);
                    var2_16.setColor(Color.gray);
                    var2_16.drawRect(2, 2, 46, 45);
                    var3_33 = 0;
                    while (var3_33 < 44) {
                        var2_16.setColor(new Color(140 + var3_33 * 2, 140 + var3_33 * 2, 140 + var3_33 * 2));
                        var2_16.fillRect(3, 3 + var3_33, 45, 1);
                        ++var3_33;
                    }
                    var2_16.setColor(Color.black);
                    var2_16.drawOval(28, 7, 18, 36);
                    var2_16.drawOval(29, 7, 17, 36);
                    var2_16.drawOval(30, 7, 16, 36);
                    var4_37 = 0;
                    while (var4_37 < 44) {
                        var2_16.setColor(new Color(140 + var4_37 * 2, 140 + var4_37 * 2, 140 + var4_37 * 2));
                        var2_16.fillRect(38, 3 + var4_37, 10, 1);
                        ++var4_37;
                    }
                    var2_16.setColor(Color.gray);
                    var2_16.fillOval(38, 38, 5, 5);
                    var2_16.setColor(Color.lightGray);
                    var2_16.fillOval(39, 38, 4, 4);
                    var2_16.setColor(Color.white);
                    var2_16.fillOval(40, 38, 3, 3);
                    var5_39 = 0;
                    while (var5_39 < 4) {
                        var2_16.setColor(new Color(240 - var5_39 * 20, 240 - var5_39 * 20, 240 - var5_39 * 2));
                        var2_16.drawRect(5 + var5_39, 5 + var5_39, 20 - var5_39 * 2, 41 - var5_39 * 2);
                        ++var5_39;
                    }
                    var2_16.dispose();
                }
                if (Golf.ballInFlight == 0) {
                    var2_17 = Golf.powerbar.getGraphics();
                    if ((Golf.power += Golf.powerDir) > 32 || Golf.power < 2) {
                        Golf.powerDir = -Golf.powerDir;
                    }
                    if (33 - Golf.power > 0) {
                        var2_17.setColor(Color.black);
                        var2_17.fillRect(10, 10, 10, 33 - Golf.power);
                    }
                    var2_17.setColor(Color.red);
                    var2_17.fillRect(10, 43 - Golf.power, 10, Golf.power);
                    var1_1.drawImage(Golf.powerbar, 100, 250, null);
                    var2_17.dispose();
                }
                if (Golf.newClub == 1) {
                    var2_18 = Golf.clubface.getGraphics();
                    switch (Golf.club) {
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11: {
                            Golf.globalSize = 200 - (Golf.club - 2) * 11;
                            break;
                        }
                        case 12: {
                            Golf.globalSize = 80;
                            break;
                        }
                        case 13:
                        case 14:
                        case 15: {
                            Golf.globalSize = 280 - (Golf.club - 13) * 25;
                        }
                    }
                    Golf.newClub = 0;
                    var2_18.setColor(Color.white);
                    var2_18.drawRect(0, 0, 50, 49);
                    var2_18.setColor(Color.lightGray);
                    var2_18.drawRect(1, 1, 48, 47);
                    var2_18.setColor(Color.gray);
                    var2_18.drawRect(2, 2, 46, 45);
                    var2_18.setColor(new Color(0, 200, 120));
                    var2_18.fillRect(3, 3, 45, 44);
                    var2_18.setColor(new Color(80, 128, 60));
                    var2_18.fillRect(4, 35, 20, 12);
                    var2_18.fillRect(27, 35, 20, 12);
                    var3_34 = 25;
                    var4_37 = 41;
                    var5_39 = 0;
                    var2_18.setColor(Color.yellow);
                    var6_40 = -4;
                    while (var6_40 < 5) {
                        var2_18.drawLine(6, var4_37, 21, var4_37 + var6_40);
                        var2_18.drawLine(44, var4_37, 29, var4_37 + var6_40);
                        ++var6_40;
                    }
                    var3_34 = 16;
                    var4_37 = 19;
                    var5_39 = 0;
                    switch (Golf.club) {
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11: {
                            var7_41 = 17;
                            while (var7_41 < 23) {
                                if (var7_41 > 17 && var7_41 < 22) {
                                    var2_18.setColor(new Color(410 - var7_41 * 10, 410 - var7_41 * 10, 410 - var7_41 * 10));
                                    var2_18.fillRect(var3_34 + var7_41 + Golf.club - 5, 3, 1, 18);
                                }
                                var2_18.setColor(new Color(200 - var7_41 * 5, 200 - var7_41 * 5, 200 - var7_41 * 5));
                                var2_18.fillRect(var3_34 + var7_41 + Golf.club - 5, 21, 1, 12);
                                ++var7_41;
                            }
                            var5_39 = 0;
                            var7_41 = -12;
                            while (var7_41 < 15) {
                                var2_18.setColor(new Color(200 - var7_41 * 3, 200 - var7_41 * 3, 200 - var7_41 * 3));
                                var2_18.fillRect(var3_34 + var7_41 * Golf.club / 12, var4_37 + var7_41, 12 + var5_39 / 4, 1);
                                if (var7_41 > -11 && var7_41 < 14) {
                                    if ((var7_41 + 20) % 4 == 2) {
                                        var2_18.setColor(Color.darkGray);
                                        var2_18.fillRect(var3_34 + var7_41 * Golf.club / 12 + 6, var4_37 + var7_41, 3 + var5_39 / 5, 1);
                                    } else {
                                        var2_18.setColor(new Color(160 - var7_41 * 3, 160 - var7_41 * 3, 160 - var7_41 * 3));
                                        var2_18.fillRect(var3_34 + var7_41 * Golf.club / 12 + 5, var4_37 + var7_41, 5 + var5_39 / 5, 1);
                                    }
                                }
                                if (++var5_39 > 20) {
                                    var5_39 = 20;
                                }
                                ++var7_41;
                            }
                            if (Golf.club < 10) {
                                var2_18.setColor(Color.black);
                                var2_18.drawString("" + Golf.club, 6, 33);
                                var2_18.drawString("" + Golf.club, 6, 32);
                                var2_18.drawString("" + Golf.club, 5, 33);
                                var2_18.setColor(Color.white);
                                var2_18.drawString("" + Golf.club, 5, 32);
                            }
                            if (Golf.club == 10) {
                                var2_18.setColor(Color.black);
                                var2_18.drawString("PW", 6, 33);
                                var2_18.drawString("PW", 6, 32);
                                var2_18.drawString("PW", 5, 33);
                                var2_18.setColor(Color.white);
                                var2_18.drawString("PW", 5, 32);
                            }
                            if (Golf.club != 11) break;
                            var2_18.setColor(Color.black);
                            var2_18.drawString("SW", 6, 33);
                            var2_18.drawString("SW", 6, 32);
                            var2_18.drawString("SW", 5, 33);
                            var2_18.setColor(Color.white);
                            var2_18.drawString("SW", 5, 32);
                            break;
                        }
                        case 12: {
                            var5_39 = 42;
                            var7_41 = 4;
                            while (var7_41 < 15) {
                                var2_18.setColor(new Color(240 - var7_41 * 3, 240 - var7_41 * 3, 100 - var7_41 * 3));
                                var2_18.fillRect(var3_34, var4_37 + var7_41, 12 + var5_39 / 4, 1);
                                if (var7_41 > 1 && var7_41 < 14) {
                                    if ((var7_41 + 20) % 4 == 2) {
                                        var2_18.setColor(Color.darkGray);
                                        var2_18.fillRect(var3_34 + 6, var4_37 + var7_41, 3 + var5_39 / 5, 1);
                                    } else {
                                        var2_18.setColor(new Color(160 - var7_41 * 3, 160 - var7_41 * 3, 160 - var7_41 * 3));
                                        var2_18.fillRect(var3_34 + 5, var4_37 + var7_41, 5 + var5_39 / 5, 1);
                                    }
                                }
                                ++var5_39;
                                ++var7_41;
                            }
                            var7_41 = 17;
                            while (var7_41 < 23) {
                                if (var7_41 > 17 && var7_41 < 22) {
                                    var2_18.setColor(new Color(410 - var7_41 * 10, 410 - var7_41 * 10, 410 - var7_41 * 10));
                                    var2_18.fillRect(var3_34 + var7_41 + Golf.club - 7, 3, 1, 18);
                                }
                                var2_18.setColor(new Color(300 - var7_41 * 5, 300 - var7_41 * 5, 150 - var7_41 * 5));
                                var2_18.fillRect(var3_34 + var7_41 + Golf.club - 7, 21, 1, 12);
                                ++var7_41;
                            }
                            var2_18.setColor(Color.black);
                            var2_18.drawString("P", 6, 33);
                            var2_18.drawString("P", 6, 32);
                            var2_18.drawString("P", 5, 33);
                            var2_18.setColor(Color.white);
                            var2_18.drawString("P", 5, 32);
                            break;
                        }
                        case 13:
                        case 14:
                        case 15: {
                            var5_39 = 8;
                            var4_37 = 19;
                            var7_41 = 0;
                            while (var7_41 < 12) {
                                var2_18.setColor(new Color(105 + var7_41 * 6, 80 + var7_41 * 6, 50 + var7_41 * 6));
                                var2_18.fillOval(var5_39 + var7_41, var4_37 - var5_39, var5_39, var5_39 * 2);
                                ++var5_39;
                                var7_41 += 2;
                            }
                            var7_41 = 17;
                            while (var7_41 < 23) {
                                if (var7_41 > 17 && var7_41 < 22) {
                                    var2_18.setColor(new Color(410 - var7_41 * 10, 410 - var7_41 * 10, 410 - var7_41 * 10));
                                    var2_18.fillRect(var3_34 + var7_41 + Golf.club / 2, 3, 1, 18);
                                }
                                var2_18.setColor(new Color(200 - var7_41 * 5, 200 - var7_41 * 5, 200 - var7_41 * 5));
                                var2_18.fillRect(var3_34 + var7_41 + Golf.club / 2, 21, 1, 11);
                                ++var7_41;
                            }
                            var5_39 = 0;
                            var7_41 = -12;
                            while (var7_41 < 14) {
                                var2_18.setColor(new Color(200 - var7_41 * 3, 160 - var7_41 * 3, 80 - var7_41 * 3));
                                var2_18.fillRect(10 + var3_34 + var7_41 * Golf.club / 48, var4_37 + var7_41, 12 + var5_39 / 4, 1);
                                if (var7_41 > -11 && var7_41 < 13) {
                                    if ((var7_41 + 20) % 4 == 2) {
                                        var2_18.setColor(Color.darkGray);
                                        var2_18.fillRect(10 + var3_34 + var7_41 * Golf.club / 48 + 6, var4_37 + var7_41, 3 + var5_39 / 5, 1);
                                    } else {
                                        var2_18.setColor(new Color(160 - var7_41 * 3, 160 - var7_41 * 3, 160 - var7_41 * 3));
                                        var2_18.fillRect(10 + var3_34 + var7_41 * Golf.club / 48 + 5, var4_37 + var7_41, 5 + var5_39 / 5, 1);
                                    }
                                }
                                if (++var5_39 > 20) {
                                    var5_39 = 20;
                                }
                                ++var7_41;
                            }
                            if (Golf.club == 13) {
                                var2_18.setColor(Color.black);
                                var2_18.drawString("DR", 6, 33);
                                var2_18.drawString("DR", 6, 32);
                                var2_18.drawString("DR", 5, 33);
                                var2_18.setColor(Color.white);
                                var2_18.drawString("DR", 5, 32);
                            }
                            if (Golf.club == 14) {
                                var2_18.setColor(Color.black);
                                var2_18.drawString("3W", 6, 33);
                                var2_18.drawString("3W", 6, 32);
                                var2_18.drawString("3W", 5, 33);
                                var2_18.setColor(Color.white);
                                var2_18.drawString("3W", 5, 32);
                            }
                            if (Golf.club != 15) break;
                            var2_18.setColor(Color.black);
                            var2_18.drawString("5W", 6, 33);
                            var2_18.drawString("5W", 6, 32);
                            var2_18.drawString("5W", 5, 33);
                            var2_18.setColor(Color.white);
                            var2_18.drawString("5W", 5, 32);
                        }
                    }
                    var1_1.drawImage(Golf.clubface, 0, 250, null);
                    var2_18.dispose();
                }
                if (Golf.picked == 1 && Golf.button == 1 && Golf.lastBallIsOn != Golf.ballIsOn) {
                    Golf.lastBallIsOn = Golf.ballIsOn;
                    var2_19 = Golf.ball.getGraphics();
                    var2_19.setColor(Color.white);
                    var2_19.drawRect(0, 0, 50, 49);
                    var2_19.setColor(Color.lightGray);
                    var2_19.drawRect(1, 1, 48, 47);
                    var2_19.setColor(Color.gray);
                    var2_19.drawRect(2, 2, 46, 45);
                    var3_35 = 0;
                    while (var3_35 < 44) {
                        var2_19.setColor(new Color(50 + var3_35 * 2, 110 + var3_35 * 2, 160 + var3_35 * 2));
                        var2_19.fillRect(3, 3 + var3_35, 45, 1);
                        ++var3_35;
                    }
                    var4_37 = 25;
                    var5_39 = 23;
                    var6_40 = 0;
                    var7_41 = 19;
                    while (var7_41 > 0) {
                        var2_19.setColor(new Color(255 - var7_41 * 3, 255 - 3 * var7_41, 255 - 3 * var7_41));
                        var2_19.fillOval(var4_37 - var7_41 - var6_40 / 4, var5_39 - var7_41 + var6_40 * 2 / 3, var7_41 * 2, var7_41 * 2);
                        --var6_40;
                        --var7_41;
                    }
                    var5_39 -= 4;
                    var4_37 -= 2;
                    var8_43 = -15;
                    while (var8_43 < 25) {
                        var9_44 = 2 - var8_43 * var8_43 / 120;
                        var2_19.setColor(Color.white);
                        if (var8_43 < 5) {
                            var2_19.fillOval(var4_37 + var8_43 + 8, var5_39 + var9_44 + 1 - 15, 3, 3);
                        }
                        if (var8_43 < 10) {
                            var2_19.fillOval(var4_37 + var8_43 + 5, var5_39 + var9_44 + 1 - 12, 3, 3);
                        }
                        if (var8_43 < 15) {
                            var2_19.fillOval(var4_37 + var8_43 + 3, var5_39 + var9_44 + 1 - 9, 3, 3);
                        }
                        if (var8_43 < 20) {
                            var2_19.fillOval(var4_37 + var8_43, var5_39 + var9_44 + 1 - 5, 3, 3);
                        }
                        var2_19.fillOval(var4_37 + var8_43 - 2, var5_39 + var9_44 + 1, 3, 3);
                        if (var8_43 < 20) {
                            var2_19.fillOval(var4_37 + var8_43, var5_39 + var9_44 + 1 + 5, 3, 3);
                        }
                        if (var8_43 < 15) {
                            var2_19.fillOval(var4_37 + var8_43 + 3, var5_39 + var9_44 + 1 + 9, 3, 3);
                        }
                        if (var8_43 < 10) {
                            var2_19.fillOval(var4_37 + var8_43 + 5, var5_39 + var9_44 + 1 + 12, 3, 3);
                        }
                        if (var8_43 < 5) {
                            var2_19.fillOval(var4_37 + var8_43 + 8, var5_39 + var9_44 + 1 + 15, 3, 3);
                        }
                        var2_19.setColor(Color.lightGray);
                        if (var8_43 < 5) {
                            var2_19.fillOval(var4_37 + var8_43 + 8, var5_39 + var9_44 - 15, 3, 3);
                        }
                        if (var8_43 < 10) {
                            var2_19.fillOval(var4_37 + var8_43 + 5, var5_39 + var9_44 - 12, 3, 3);
                        }
                        if (var8_43 < 15) {
                            var2_19.fillOval(var4_37 + var8_43 + 3, var5_39 + var9_44 - 9, 3, 3);
                        }
                        if (var8_43 < 20) {
                            var2_19.fillOval(var4_37 + var8_43, var5_39 + var9_44 - 5, 3, 3);
                        }
                        var2_19.fillOval(var4_37 + var8_43 - 2, var5_39 + var9_44, 3, 3);
                        if (var8_43 < 20) {
                            var2_19.fillOval(var4_37 + var8_43, var5_39 + var9_44 + 5, 3, 3);
                        }
                        if (var8_43 < 15) {
                            var2_19.fillOval(var4_37 + var8_43 + 3, var5_39 + var9_44 + 9, 3, 3);
                        }
                        if (var8_43 < 10) {
                            var2_19.fillOval(var4_37 + var8_43 + 5, var5_39 + var9_44 + 12, 3, 3);
                        }
                        if (var8_43 < 5) {
                            var2_19.fillOval(var4_37 + var8_43 + 8, var5_39 + var9_44 + 15, 3, 3);
                        }
                        var8_43 += 5;
                    }
                    var5_39 += 4;
                    var4_37 += 2;
                    switch (Golf.ballIsOn) {
                        case 0: {
                            var2_19.setColor(new Color(64, 180, 64));
                            var2_19.fillRect(3, 44, 45, 3);
                            var5_39 = 50;
                            var6_40 = 0;
                            var9_44 = 8;
                            while (var9_44 > 3) {
                                var10_47 = -var9_44 + 1;
                                while (var10_47 < var9_44) {
                                    var2_19.setColor(new Color(210 + var10_47 * 5, 160 + var10_47 * 5, 160 + var10_47 * 5));
                                    var2_19.fillRect(var4_37 + var10_47, var5_39 - var9_44, 1, 1);
                                    ++var10_47;
                                }
                                --var9_44;
                            }
                            break;
                        }
                        case 1: {
                            Golf.lastBallIsOn = 99;
                            if (Golf.sandPlug == 0) {
                                var2_19.setColor(new Color(240, 180, 160));
                                var2_19.fillRect(3, 3, 45, 44);
                                var5_39 = 36;
                                var6_40 = 0;
                                var9_44 = 0;
                                while (var9_44 < 21) {
                                    var2_19.setColor(new Color(135 + var9_44 * 5, 80 + var9_44 * 5, 60 + var9_44 * 5));
                                    var2_19.drawOval(var4_37 - var9_44, var5_39 - var9_44 / 2, var9_44 * 2, var9_44);
                                    ++var9_44;
                                }
                                var5_39 = 23;
                                var6_40 = 0;
                                var10_47 = 19;
                                while (var10_47 > 0) {
                                    var2_19.setColor(new Color(255 - var10_47 * 3, 255 - 3 * var10_47, 255 - 3 * var10_47));
                                    var2_19.fillOval(var4_37 - var10_47 - var6_40 / 4, var5_39 - var10_47 + var6_40 * 2 / 3, var10_47 * 2, var10_47 * 2);
                                    --var6_40;
                                    --var10_47;
                                }
                                var5_39 -= 4;
                                var4_37 -= 2;
                                var11_48 = -15;
                                while (var11_48 < 25) {
                                    var12_49 = 2 - var11_48 * var11_48 / 120;
                                    var2_19.setColor(Color.white);
                                    if (var11_48 < 5) {
                                        var2_19.fillOval(var4_37 + var11_48 + 8, var5_39 + var12_49 + 1 - 15, 3, 3);
                                    }
                                    if (var11_48 < 10) {
                                        var2_19.fillOval(var4_37 + var11_48 + 5, var5_39 + var12_49 + 1 - 12, 3, 3);
                                    }
                                    if (var11_48 < 15) {
                                        var2_19.fillOval(var4_37 + var11_48 + 3, var5_39 + var12_49 + 1 - 9, 3, 3);
                                    }
                                    if (var11_48 < 20) {
                                        var2_19.fillOval(var4_37 + var11_48, var5_39 + var12_49 + 1 - 5, 3, 3);
                                    }
                                    var2_19.fillOval(var4_37 + var11_48 - 2, var5_39 + var12_49 + 1, 3, 3);
                                    if (var11_48 < 20) {
                                        var2_19.fillOval(var4_37 + var11_48, var5_39 + var12_49 + 1 + 5, 3, 3);
                                    }
                                    if (var11_48 < 15) {
                                        var2_19.fillOval(var4_37 + var11_48 + 3, var5_39 + var12_49 + 1 + 9, 3, 3);
                                    }
                                    if (var11_48 < 10) {
                                        var2_19.fillOval(var4_37 + var11_48 + 5, var5_39 + var12_49 + 1 + 12, 3, 3);
                                    }
                                    if (var11_48 < 5) {
                                        var2_19.fillOval(var4_37 + var11_48 + 8, var5_39 + var12_49 + 1 + 15, 3, 3);
                                    }
                                    var2_19.setColor(Color.lightGray);
                                    if (var11_48 < 5) {
                                        var2_19.fillOval(var4_37 + var11_48 + 8, var5_39 + var12_49 - 15, 3, 3);
                                    }
                                    if (var11_48 < 10) {
                                        var2_19.fillOval(var4_37 + var11_48 + 5, var5_39 + var12_49 - 12, 3, 3);
                                    }
                                    if (var11_48 < 15) {
                                        var2_19.fillOval(var4_37 + var11_48 + 3, var5_39 + var12_49 - 9, 3, 3);
                                    }
                                    if (var11_48 < 20) {
                                        var2_19.fillOval(var4_37 + var11_48, var5_39 + var12_49 - 5, 3, 3);
                                    }
                                    var2_19.fillOval(var4_37 + var11_48 - 2, var5_39 + var12_49, 3, 3);
                                    if (var11_48 < 20) {
                                        var2_19.fillOval(var4_37 + var11_48, var5_39 + var12_49 + 5, 3, 3);
                                    }
                                    if (var11_48 < 15) {
                                        var2_19.fillOval(var4_37 + var11_48 + 3, var5_39 + var12_49 + 9, 3, 3);
                                    }
                                    if (var11_48 < 10) {
                                        var2_19.fillOval(var4_37 + var11_48 + 5, var5_39 + var12_49 + 12, 3, 3);
                                    }
                                    if (var11_48 < 5) {
                                        var2_19.fillOval(var4_37 + var11_48 + 8, var5_39 + var12_49 + 15, 3, 3);
                                    }
                                    var11_48 += 5;
                                }
                                var5_39 += 4;
                                var4_37 += 2;
                                break;
                            }
                            var2_19.setColor(new Color(240, 180, 160));
                            var2_19.fillRect(3, 3, 45, 44);
                            var5_39 = 26;
                            var6_40 = 0;
                            var9_44 = 0;
                            while (var9_44 < 22) {
                                var2_19.setColor(new Color(130 + var9_44 * 5, 80 + var9_44 * 5, 60 + var9_44 * 5));
                                var2_19.drawOval(var4_37 - var9_44, var5_39 - var9_44, var9_44 * 2, var9_44 * 3 / 2);
                                ++var9_44;
                            }
                            var5_39 = 24;
                            var6_40 = 0;
                            var10_47 = 15;
                            while (var10_47 > 0) {
                                var2_19.setColor(new Color(255 - var10_47 * 4, 255 - 4 * var10_47, 255 - 4 * var10_47));
                                var2_19.fillOval(var4_37 - var10_47 + var6_40 / 4, var5_39 - var10_47 * 3 / 4 - var6_40 / 2 * 2 / 3, var10_47 * 2, var10_47 * 3 / 2);
                                ++var6_40;
                                --var10_47;
                            }
                            break;
                        }
                        case 2: {
                            var2_19.setColor(new Color(128, 128, 255));
                            var2_19.fillRect(3, 3, 45, 44);
                            var5_39 = 40;
                            var9_44 = 12;
                            while (var9_44 > 0) {
                                var2_19.setColor(new Color(128 - var9_44 * 4, 128 - var9_44 * 4, 255 - var9_44 * 4));
                                var2_19.fillOval(var4_37 - var9_44, var5_39 - var9_44, var9_44 * 2, var9_44);
                                var9_44 -= 2;
                            }
                            var5_39 = 21;
                            var9_44 = 20;
                            while (var9_44 > 0) {
                                var2_19.setColor(new Color(255 - var9_44 * 4, 255 - var9_44 * 4, 255 - var9_44 * 4));
                                var2_19.drawOval(var4_37 - var9_44, var5_39 - var9_44 / 2, var9_44 * 2, var9_44);
                                var9_44 -= 4;
                            }
                            break;
                        }
                        case 3: {
                            var2_19.setColor(new Color(128, 255, 128));
                            var2_19.fillRect(3, 42, 45, 5);
                            var9_44 = 0;
                            while (var9_44 < 120) {
                                var4_37 = (int) (Math.random() * 20.0) * 2 + 6;
                                var5_39 = 44;
                                var6_40 = (int) (Math.random() * 5.0) - 2;
                                var2_19.setColor(new Color(128, 220 + var6_40 * 15, 128));
                                var2_19.drawLine(var4_37 + var6_40, var5_39 - 5 - var6_40, var4_37, var5_39 - var6_40);
                                ++var9_44;
                            }
                            break;
                        }
                        case 4: {
                            var2_19.setColor(new Color(64, 180, 64));
                            var2_19.fillRect(3, 42, 45, 5);
                            break;
                        }
                        case 5: {
                            var2_19.setColor(new Color(100, 200, 100));
                            var2_19.fillRect(3, 34, 45, 13);
                            var9_44 = 0;
                            while (var9_44 < 120) {
                                var4_37 = (int) (Math.random() * 21.0) * 2 + 5;
                                var5_39 = 42;
                                var6_40 = (int) (Math.random() * 5.0) - 2;
                                var2_19.setColor(new Color(100, 180 + var6_40 * 25, 100));
                                var2_19.drawLine(var4_37 + var6_40, var5_39 - 15 - var6_40, var4_37, var5_39 - var6_40);
                                ++var9_44;
                            }
                            break;
                        }
                        case 6: {
                            var2_19.setColor(new Color(160, 160, 80));
                            var2_19.fillRect(3, 27, 45, 20);
                            var9_44 = 0;
                            while (var9_44 < 120) {
                                var4_37 = (int) (Math.random() * 21.0) * 2 + 5;
                                var5_39 = 40;
                                var6_40 = (int) (Math.random() * 5.0) - 2;
                                var2_19.setColor(new Color(160, 160 + var6_40 * 25, 80));
                                var2_19.drawLine(var4_37 + var6_40, var5_39 - 25 - var6_40, var4_37, var5_39 - var6_40 * 2);
                                ++var9_44;
                            }
                            break;
                        }
                    }
                    var1_1.drawImage(Golf.ball, 50, 250, null);
                    var2_19.dispose();
                }
                var2_20 = Golf.gold.getGraphics();
                var3_36 = Golf.working.getGraphics();
                var4_37 = (Golf.ballX - Golf.pinX) * 2 + 300;
                var5_39 = (Golf.ballY - Golf.pinY) * 2 + 125;
                if (Golf.ballInFlight == 1 && Golf.magSelected == 0 && Golf.ballTime > 1) {
                    var3_36.clipRect(Golf.ballX - 15, 0, 30, Golf.ballY + 10);
                }
                if (Golf.ballInFlight == 1 && Golf.magSelected == 1 && Golf.ballTime > 1) {
                    var3_36.clipRect(var4_37 - 15, 0, 30, var5_39 + 10);
                }
                if (Golf.ballInFlight == 1) {
                    var3_36.drawImage(Golf.gold, 0, 0, null);
                }
                if (Golf.holebuilt == 1 && Golf.ballInFlight == 0 && Golf.bigRefresh == 1) {
                    Golf.bigRefresh = 0;
                    Golf.bigRefresh2 = 1;
                    var3_36.drawImage(Golf.gold, 0, 0, null);
                }
                if (Golf.fullRefresh == 1 && Golf.holebuilt == 0) {
                    var1_1.setColor(Color.black);
                    var1_1.drawString("Club", 11, 248);
                    var1_1.drawString("Lie", 64, 248);
                    var1_1.drawString("Swing", 108, 248);
                    var1_1.drawString("Wind", 161, 248);
                    var1_1.drawString("Slope", 211, 248);
                    var1_1.setColor(Color.white);
                    var1_1.drawString("Club", 10, 247);
                    var1_1.drawString("Lie", 63, 247);
                    var1_1.drawString("Swing", 107, 247);
                    var1_1.drawString("Wind", 160, 247);
                    var1_1.drawString("Slope", 210, 247);
                    var1_1.setColor(new Color(20, 120, 40));
                    var1_1.fillRect(0, 86, 600, 20);
                    var1_1.setColor(Color.black);
                    var1_1.drawString("Refreshing the display...Please stand by", 201, 101);
                    var1_1.setColor(Color.white);
                    var1_1.drawString("Refreshing the display...Please stand by", 200, 100);
                    var1_1.setColor(Color.white);
                    var1_1.drawRect(0, 84, 599, 22);
                    var1_1.setColor(Color.lightGray);
                    var1_1.drawRect(1, 85, 597, 20);
                    var1_1.setColor(Color.gray);
                    var1_1.drawRect(2, 86, 595, 18);
                }
                if (Golf.holebuilt == 0 && Golf.gameOver == 0) {
                    if (Golf.fullRefresh == 0) {
                        var1_1.setColor(new Color(20, 120, 40));
                        var1_1.fillRect(0, 228, 600, 20);
                        var1_1.setColor(Color.white);
                        var1_1.drawRect(0, 228, 599, 20);
                        var1_1.setColor(Color.lightGray);
                        var1_1.drawRect(1, 229, 597, 18);
                        var1_1.setColor(Color.gray);
                        var1_1.drawRect(2, 230, 595, 16);
                        if (Golf.magSelected == 0) {
                            var1_1.setColor(Color.black);
                            var1_1.drawString("...ZOOMING OUT FOR A WIDE-ANGLE VIEW...", 121, 244);
                            var1_1.setColor(Color.white);
                            var1_1.drawString("...ZOOMING OUT FOR A WIDE-ANGLE VIEW...", 120, 243);
                        } else {
                            var1_1.setColor(Color.black);
                            var1_1.drawString("...ZOOMING IN FOR A CLOSE-UP VIEW...", 121, 244);
                            var1_1.setColor(Color.white);
                            var1_1.drawString("...ZOOMING IN FOR A CLOSE-UP VIEW...", 120, 243);
                        }
                    }
                    Golf.fullRefresh = 0;
                    var2_20.setColor(new Color(20, 120, 40));
                    var2_20.fillRect(0, 0, 600, 250);
                    var2_20.setColor(new Color(52, 152, 72));
                    var6_40 = 0;
                    while (var6_40 < 650) {
                        var2_20.drawOval(300 - var6_40, -50, var6_40 * 2, var6_40 / 2);
                        var6_40 += 2;
                    }
                    var7_41 = 0;
                    while (var7_41 < Golf.roughs) {
                        Golf.magX = Golf.roughX[var7_41];
                        Golf.magY = Golf.roughY[var7_41];
                        Golf.magSize = Golf.roughRadius[var7_41];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.roughX[var7_41] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.roughY[var7_41] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.roughRadius[var7_41] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var8_43 = Golf.magSize;
                        var2_20.setColor(Golf.rough1);
                        var2_20.fillOval(Golf.magX - var8_43, Golf.magY - var8_43 / 2, var8_43 * 2, var8_43);
                        var9_44 = 0;
                        var2_20.setColor(Golf.rough2);
                        var10_47 = Golf.magSize;
                        while (var10_47 > 0) {
                            var2_20.drawOval(Golf.magX - var10_47, Golf.magY - var10_47 / 2 + var9_44, var10_47 * 2, var10_47);
                            --var9_44;
                            var10_47 -= 2;
                        }
                        ++var7_41;
                    }
                    var8_43 = 0;
                    while (var8_43 < Golf.fairways) {
                        Golf.magX = Golf.fairwayX[var8_43];
                        Golf.magY = Golf.fairwayY[var8_43];
                        Golf.magSize = Golf.fairwayRadius[var8_43];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.fairwayX[var8_43] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.fairwayY[var8_43] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.fairwayRadius[var8_43] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var9_44 = Golf.magSize;
                        var2_20.setColor(new Color(144, 234, 104));
                        var2_20.fillOval(Golf.magX - var9_44, Golf.magY - var9_44 / 2, var9_44 * 2, var9_44);
                        var10_47 = 0;
                        var2_20.setColor(new Color(100, 255, 120));
                        var11_48 = Golf.magSize;
                        while (var11_48 > 0) {
                            var2_20.drawOval(Golf.magX - var11_48, Golf.magY - var11_48 / 2 + var10_47, var11_48 * 2, var11_48);
                            --var10_47;
                            var11_48 -= 2;
                        }
                        ++var8_43;
                    }
                    var9_44 = 0;
                    while (var9_44 < Golf.sandtraps) {
                        Golf.magX = Golf.sandX[var9_44];
                        Golf.magY = Golf.sandY[var9_44];
                        Golf.magSize = Golf.sandRadius[var9_44];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.sandX[var9_44] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.sandY[var9_44] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.sandRadius[var9_44] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var10_47 = Golf.magSize + 1;
                        var2_20.setColor(Golf.sand1);
                        var2_20.fillOval(Golf.magX - var10_47, Golf.magY - var10_47 / 2 - 1, var10_47 * 2, var10_47);
                        var2_20.setColor(Golf.sand2);
                        var2_20.fillOval(Golf.magX - var10_47, Golf.magY - var10_47 / 2 + 1, var10_47 * 2, var10_47);
                        ++var9_44;
                    }
                    var2_20.setColor(Golf.sand3);
                    var10_47 = 0;
                    while (var10_47 < Golf.sandtraps) {
                        Golf.magX = Golf.sandX[var10_47];
                        Golf.magY = Golf.sandY[var10_47];
                        Golf.magSize = Golf.sandRadius[var10_47];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.sandX[var10_47] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.sandY[var10_47] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.sandRadius[var10_47] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var2_20.fillOval(Golf.magX - Golf.magSize, Golf.magY - Golf.magSize / 2, Golf.magSize * 2, Golf.magSize);
                        ++var10_47;
                    }
                    var2_20.setColor(Golf.sand4);
                    var11_48 = 0;
                    while (var11_48 < Golf.sandtraps) {
                        Golf.magX = Golf.sandX[var11_48];
                        Golf.magY = Golf.sandY[var11_48];
                        Golf.magSize = Golf.sandRadius[var11_48];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.sandX[var11_48] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.sandY[var11_48] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.sandRadius[var11_48] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var12_49 = 0;
                        var13_50 = Golf.magSize;
                        while (var13_50 > 0) {
                            var2_20.drawOval(Golf.magX - var13_50, Golf.magY - var13_50 / 2 + var12_49, var13_50 * 2, var13_50);
                            --var12_49;
                            var13_50 -= 2;
                        }
                        ++var11_48;
                    }
                    var12_49 = 0;
                    while (var12_49 < Golf.lakes) {
                        Golf.magX = Golf.lakeX[var12_49];
                        Golf.magY = Golf.lakeY[var12_49];
                        Golf.magSize = Golf.lakeRadius[var12_49];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.lakeX[var12_49] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.lakeY[var12_49] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.lakeRadius[var12_49] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var13_50 = Golf.magSize + 1;
                        var2_20.setColor(Golf.lake1);
                        var2_20.fillOval(Golf.magX - var13_50, Golf.magY - var13_50 / 2 - 1, var13_50 * 2, var13_50);
                        var2_20.setColor(Golf.lake2);
                        var2_20.fillOval(Golf.magX - var13_50, Golf.magY - var13_50 / 2 + 1, var13_50 * 2, var13_50);
                        ++var12_49;
                    }
                    var2_20.setColor(Golf.lake3);
                    var13_50 = 0;
                    while (var13_50 < Golf.lakes) {
                        Golf.magX = Golf.lakeX[var13_50];
                        Golf.magY = Golf.lakeY[var13_50];
                        Golf.magSize = Golf.lakeRadius[var13_50];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.lakeX[var13_50] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.lakeY[var13_50] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.lakeRadius[var13_50] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var14_51 = Golf.magSize;
                        var2_20.fillOval(Golf.magX - var14_51, Golf.magY - var14_51 / 2, var14_51 * 2, var14_51);
                        ++var13_50;
                    }
                    var14_51 = 0;
                    while (var14_51 < Golf.lakes) {
                        Golf.magX = Golf.lakeX[var14_51];
                        Golf.magY = Golf.lakeY[var14_51];
                        Golf.magSize = Golf.lakeRadius[var14_51];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.lakeX[var14_51] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.lakeY[var14_51] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.lakeRadius[var14_51] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var15_52 = 0;
                        var16_53 = 32 * (var14_51 % 2 + 1);
                        if (var16_53 == 32) {
                            var2_20.setColor(Golf.lake4);
                        } else {
                            var2_20.setColor(Golf.lake5);
                        }
                        var17_54 = Golf.magSize - 2;
                        while (var17_54 > 0) {
                            var18_55 = (int) (Math.random() * 3.0) - 1;
                            var2_20.drawOval(Golf.magX - var17_54 + var18_55, Golf.magY - var17_54 / 2 + var15_52 / 2 + 1, var17_54 * 2, var17_54);
                            --var15_52;
                            --var17_54;
                        }
                        ++var14_51;
                    }
                    var2_20.setColor(Golf.green1);
                    var15_52 = 0;
                    while (var15_52 < Golf.greens) {
                        Golf.magX = Golf.greenX[var15_52];
                        Golf.magY = Golf.greenY[var15_52];
                        Golf.magSize = Golf.greenRadius[var15_52];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.greenX[var15_52] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.greenY[var15_52] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.greenRadius[var15_52] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var2_20.fillOval(Golf.magX - Golf.magSize, Golf.magY - Golf.magSize / 2, 2 * Golf.magSize, Golf.magSize);
                        ++var15_52;
                    }
                    var2_20.setColor(Golf.green2);
                    var16_53 = 0;
                    while (var16_53 < Golf.greens) {
                        Golf.magX = Golf.greenX[var16_53];
                        Golf.magY = Golf.greenY[var16_53];
                        Golf.magSize = Golf.greenRadius[var16_53];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.greenX[var16_53] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.greenY[var16_53] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.greenRadius[var16_53] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var17_54 = 0;
                        var18_55 = Golf.magSize;
                        while (var18_55 > 0) {
                            var2_20.drawOval(Golf.magX - var18_55, Golf.magY - var18_55 / 2 - var17_54, var18_55 * 2, var18_55);
                            ++var17_54;
                            var18_55 -= 2;
                        }
                        ++var16_53;
                    }
                    if (Golf.magSelected == 1) {
                        var2_20.setColor(Color.white);
                        var17_54 = 9;
                        while (var17_54 > 0) {
                            if (var17_54 == 7) {
                                var2_20.setColor(Color.lightGray);
                            }
                            if (var17_54 == 6) {
                                var2_20.setColor(Color.gray);
                            }
                            if (var17_54 == 5) {
                                var2_20.setColor(Color.darkGray);
                            }
                            var2_20.fillOval(300 - var17_54 / 2, 125 - var17_54 / 4, var17_54, var17_54 / 2);
                            var17_54 -= 2;
                        }
                        var2_20.setColor(Color.black);
                        var2_20.fillOval(299, 124, 3, 3);
                    } else {
                        var2_20.setColor(Color.black);
                        var2_20.fillRect(Golf.pinX - 1, Golf.pinY - 1, 3, 2);
                        var2_20.setColor(Color.yellow);
                        var2_20.fillRect(Golf.pinX, Golf.pinY - 10, 1, 10);
                        var2_20.setColor(Color.orange);
                        if (Golf.windDX > 0) {
                            var2_20.fillRect(Golf.pinX + 1, Golf.pinY - 10, 3, 3);
                        } else {
                            var2_20.fillRect(Golf.pinX - 3, Golf.pinY - 10, 3, 3);
                        }
                    }
                    if (Golf.magSelected == 0) {
                        var2_20.setColor(Golf.tee1);
                        var2_20.fillOval(Golf.teeX - 13, Golf.teeY - 6, 27, 13);
                        var17_54 = Golf.pinX - Golf.teeX;
                        var18_55 = Golf.pinY - Golf.teeY;
                        while (var18_55 * var18_55 + var17_54 * var17_54 > 100) {
                            var18_55 /= 2;
                            var17_54 /= 2;
                        }
                        while (var18_55 * var18_55 + var17_54 * var17_54 < 100) {
                            var18_55 += var18_55 / 2;
                            var17_54 += var17_54 / 2;
                        }
                        var2_20.setColor(Golf.tee2);
                        var2_20.fillOval(Golf.teeX - var18_55 - 2, Golf.teeY + var17_54 / 2 - 2, 5, 5);
                        var2_20.fillOval(Golf.teeX + var18_55 - 2, Golf.teeY - var17_54 / 2 - 2, 5, 5);
                        var2_20.setColor(Color.white);
                        var2_20.fillOval(Golf.teeX - var18_55 - 2, Golf.teeY + var17_54 / 2 - 2, 2, 2);
                        var2_20.fillOval(Golf.teeX + var18_55 - 2, Golf.teeY - var17_54 / 2 - 2, 2, 2);
                    }
                    var17_54 = 0;
                    while (var17_54 < Golf.trees) {
                        Golf.magX = Golf.treeX[var17_54];
                        Golf.magY = Golf.treeY[var17_54];
                        Golf.magSize = Golf.treeRadius[var17_54];
                        if (Golf.magSelected == 1) {
                            Golf.magX = (Golf.treeX[var17_54] - Golf.pinX) * 2 + 300;
                            Golf.magY = (Golf.treeY[var17_54] - Golf.pinY) * 2 + 125;
                            Golf.magSize = Golf.treeRadius[var17_54] * 2;
                            if (Golf.magX + Golf.magSize < 0 || Golf.magX - Golf.magSize > 600) {
                                Golf.magSize = 1;
                            }
                            if (Golf.magY + Golf.magSize < 0 || Golf.magY - Golf.magSize > 250) {
                                Golf.magSize = 1;
                            }
                        }
                        var18_55 = Golf.magSize;
                        var2_20.setColor(new Color(160, 120, 50));
                        var19_56 = -var18_55 / 10;
                        while (var19_56 < var18_55 / 10 + 1) {
                            var2_20.drawLine(Golf.magX, Golf.magY - var18_55 * 3, Golf.magX + var19_56, Golf.magY);
                            ++var19_56;
                        }
                        var20_57 = 0;
                        while (var20_57 < var18_55 * 4) {
                            var21_58 = var20_57 / 3 + 2;
                            var22_59 = Golf.magX + (int) (Math.random() * (double) var21_58) - var21_58 / 2;
                            var23_60 = Golf.magY - var18_55 * 3 + var20_57 * 2 / 3;
                            var2_20.setColor(new Color(130, 120, 20));
                            var2_20.drawLine(Golf.magX, Golf.magY - var18_55 / 2, var22_59, var23_60);
                            var2_20.setColor(new Color(120 + var22_59 % 5 * 15, 150 + var20_57 % 6 * 19, 20));
                            var2_20.fillOval(var22_59 - var18_55 / 16 - 1, var23_60 - var18_55 / 32 - 1, 2 + var21_58 / 25, 1 + var21_58 / 25);
                            if (var20_57 > var18_55) {
                                var2_20.fillOval(3 + var22_59 - var18_55 / 16 - 1, 2 + var23_60 - var18_55 / 32 - 1, 3, 2);
                            }
                            if (var20_57 > var18_55 * 2) {
                                var2_20.fillOval(-3 + var22_59 - var18_55 / 16 - 1, 2 + var23_60 - var18_55 / 32 - 1, 2, 1);
                            }
                            if (var20_57 > var18_55 * 2) {
                                var2_20.setColor(new Color(80, 140, 80));
                                var23_60 = Golf.magY + (int) (Math.random() * (double) var18_55 / 2.0) - var18_55 / 4;
                                var2_20.drawOval(var22_59 - var18_55 / 6, var23_60, var18_55 / 3, var18_55 / 6);
                            }
                            ++var20_57;
                        }
                        var2_20.setColor(new Color(100, 130, 100));
                        var2_20.fillOval(Golf.magX - var18_55 / 3, Golf.magY - var18_55 / 6 + 1, var18_55 * 2 / 3, var18_55 / 3);
                        var2_20.setColor(new Color(140, 100, 40));
                        var21_58 = -var18_55 / 10;
                        while (var21_58 < var18_55 / 10 + 1) {
                            var2_20.setColor(new Color(150 + var21_58 % 10 * 10, 110 + var21_58 % 9 * 9, 40));
                            var2_20.drawLine(Golf.magX, Golf.magY - var18_55, Golf.magX + var21_58, Golf.magY);
                            ++var21_58;
                        }
                        ++var17_54;
                    }
                    var3_36.drawImage(Golf.gold, 0, 0, null);
                    Golf.holebuilt = 1;
                    Golf.bigRefresh = 1;
                }
                var1_1.clipRect(0, 0, 600, 250);
                if (Golf.ballInFlight != 0) break block587;
                var6_40 = 0;
                var7_41 = 0;
                if (Golf.magSelected == 0) {
                    var6_40 = Golf.aimX - Golf.ballX;
                    var7_41 = (Golf.aimY - Golf.ballY) * 2;
                } else {
                    var6_40 = Golf.aimX - ((Golf.ballX - Golf.pinX) * 2 + 300);
                    var7_41 = Golf.aimY - ((Golf.ballY - Golf.pinY) * 4 + 125);
                }
                var8_43 = var6_40;
                var9_44 = var7_41;
                var10_47 = 100;
                if (var6_40 * var6_40 + var7_41 * var7_41 <= 2500) **GOTO lbl2190
                while (var6_40 * var6_40 + var7_41 * var7_41 > 2500 && var10_47 > 1) {
                    var6_40 = var8_43 * var10_47 / 100;
                    var7_41 = var9_44 * var10_47 / 100;
                    --var10_47;
                }
                break block588;
                lbl - 1000:
                // 1 sources

                {
                    var6_40 = var8_43 * 100 / var10_47;
                    var7_41 = var9_44 * 100 / var10_47;
                    --var10_47;
                    lbl2190:
                    // 2 sources

                    **while (var6_40 * var6_40 + var7_41 * var7_41 < 2500 && var10_47 > 1)
                }
            }
            Golf.ballDX = var6_40;
            Golf.ballDY = var7_41;
            Golf.bpX = var6_40;
            Golf.bpY = var7_41;
        }
        if (Golf.magSelected == 0 && Golf.rangeClock > 0) {
            if (--Golf.rangeClock == 0) {
                Golf.bigRefresh = 1;
            }
            var3_36.setColor(Color.black);
            var3_36.drawOval(Golf.ballX - Golf.globalSize, Golf.ballY - Golf.globalSize / 2, Golf.globalSize * 2, Golf.globalSize);
        }
        if (Golf.playerClock > 0 && Golf.magSelected == 0) {
            if (Golf.inLake == 1) {
                var3_36.setColor(Color.white);
                var6_40 = 5 - Golf.playerClock % 5;
                if (Golf.playerClock % 2 == 0) {
                    var3_36.setColor(Color.lightGray);
                }
                var3_36.drawOval(Golf.ballX - 2 - var6_40, Golf.ballY - var6_40 / 2, var6_40 * 2, var6_40);
            } else {
                var6_40 = Golf.playerClock * 8;
                var3_36.setColor(Color.black);
                var3_36.drawOval(Golf.ballX - var6_40 / 2, Golf.ballY - var6_40 / 4, var6_40, var6_40 / 2);
            }
        }
        Golf.button = 0;
        var3_36.setColor(Color.black);
        if (Golf.ballInFlight == 1) {
            if (Golf.bounced == 0) {
                Golf.lastsfx = 0;
            }
            if (Golf.aniClock % 4 == 0) {
                ++Golf.ballGravity;
            }
            if ((Golf.ballZ += Golf.ballGravity) > 0) {
                if (Golf.onGreen == 0) {
                    Golf.sandchk = Golf.ballGravity;
                }
                if (Golf.club > 12) {
                    Golf.ballGravity = -Golf.ballGravity / 4;
                }
                if (Golf.club < 12) {
                    Golf.ballGravity = -Golf.ballGravity / 8;
                }
                Golf.ballZ = 0;
                Golf.picked = 0;
                Golf.button = 1;
                if (++Golf.bounced > 1) {
                    switch (Golf.ballIsOn) {
                        case 1: {
                            Golf.ballTimeOut -= 5;
                            break;
                        }
                        case 3: {
                            --Golf.ballTimeOut;
                            break;
                        }
                        case 4: {
                            if (Golf.magSelected != 0) break;
                            --Golf.ballTimeOut;
                            break;
                        }
                        case 5: {
                            Golf.ballTimeOut -= 2;
                            break;
                        }
                        case 6: {
                            Golf.ballTimeOut -= 5;
                        }
                    }
                }
                if (Golf.inSand == 1 && Golf.onGreen == 0) {
                    --Golf.ballTimeOut;
                }
                if (Golf.inRough == 1 && Golf.onGreen == 0) {
                    --Golf.ballTimeOut;
                }
            }
            if (Golf.club != 12 && Golf.magSelected == 0 && Golf.ballZ < 0) {
                Golf.ballDX += Golf.windDX * 15 * Golf.ballTime / 60;
                Golf.ballDY += Golf.windDY * 15 * Golf.ballTime / 60;
            }
            if (Golf.onGreen == 1 && Golf.ballZ == 0) {
                Golf.ballDX += Golf.slopeDX * 10 * Golf.ballTime / 60;
                Golf.ballDY += Golf.slopeDY * 10 * Golf.ballTime / 60;
            }
            Golf.ballX = Golf.baseX + Golf.ballDX / (100 - Golf.slower) * Golf.ballTime / 60;
            Golf.ballY = Golf.baseY + Golf.ballDY / (100 - Golf.slower) * Golf.ballTime / 60;
            Golf.magBallX = Golf.magBaseX + 2 * Golf.ballDX / (100 - Golf.slower) * Golf.ballTime / 60;
            Golf.magBallY = Golf.magBaseY + 2 * Golf.ballDY / (100 - Golf.slower) * Golf.ballTime / 60;
            if (Golf.slower > 0) {
                --Golf.slower;
            }
            if (Golf.magSelected == 1 && (Golf.ballY - Golf.pinY) * (Golf.ballY - Golf.pinY) + (Golf.ballX - Golf.pinX) * (Golf.ballX - Golf.pinX) < 3 && Golf.ballTime > Golf.ballTimeOut - 10) {
                Golf.inHole = 1;
                Golf.ballTime = Golf.ballTimeOut;
            }
            if (Golf.magSelected == 1 && (Golf.ballY - Golf.pinY) * (Golf.ballY - Golf.pinY) + (Golf.ballX - Golf.pinX) * (Golf.ballX - Golf.pinX) < 3 && Golf.ballDX * Golf.ballDX + Golf.ballDY * Golf.ballDY < 3500000) {
                Golf.inHole = 1;
                Golf.ballTime = Golf.ballTimeOut;
            }
            if (Golf.magSelected == 0 && (Golf.ballY - Golf.pinY) * (Golf.ballY - Golf.pinY) + (Golf.ballX - Golf.pinX) * (Golf.ballX - Golf.pinX) < 3 && Golf.ballTime > Golf.ballTimeOut - 4) {
                Golf.inHole = 1;
                Golf.ballTime = Golf.ballTimeOut;
            }
            if (Golf.inLake == 1) {
                Golf.sfxque[Golf.sfxin] = 4;
                Golf.sfxin = (Golf.sfxin + 1) % 8;
                Golf.ballTime = Golf.ballTimeOut;
            }
            if (Golf.inSand == 1 && Golf.bounced == 1 && Golf.sandchk != 0) {
                Golf.ballTime = Golf.ballTimeOut;
                Golf.sandPlug = 1;
                if (Golf.sandchk < 5) {
                    Golf.sandPlug = 0;
                }
            }
            if (Golf.inLake == 0 && Golf.inSand == 1 && Golf.bounced < 3 && Golf.onGreen == 0) {
                Golf.sfxque[Golf.sfxin] = 3;
                Golf.sfxin = (Golf.sfxin + 1) % 8;
            }
            ++Golf.ballTime;
            if (Golf.magSelected == 1) {
                ++Golf.ballTime;
            }
            if (Golf.ballTime > Golf.ballTimeOut && Golf.bounced > 0) {
                Golf.aniClock = 0;
                Golf.picked = 0;
                Golf.ballInFlight = 0;
                Golf.ballZ = 0;
                Golf.button = 1;
                Golf.lakeDX = Golf.ballDX;
                Golf.lakeDY = Golf.ballDY;
                if (Golf.inHole == 0 && Golf.inLake == 0) {
                    Golf.newPlayer = 1;
                }
                if (Golf.inLake == 1) {
                    Golf.playerClock = 20;
                    Golf.infoBox = 1;
                }
                if (Golf.ballX > 600 || Golf.ballX < 0 || Golf.ballY > 250 || Golf.ballY < 0) {
                    Golf.outOfBounds = 1;
                    v12 = Golf.player;
                    Golf.playerStrokes[v12] = Golf.playerStrokes[v12] + 1;
                }
            }
        }
        if (Golf.ballInFlight == 0 && Golf.inHole == 1) {
            Golf.sfxque[Golf.sfxin] = 5;
            Golf.sfxin = (Golf.sfxin + 1) % 8;
            Golf.bigRefresh = 1;
            switch (Golf.player) {
                case 1: {
                    Golf.player1Par[Golf.hole] = Golf.playerStrokes[Golf.player];
                    break;
                }
                case 2: {
                    Golf.player2Par[Golf.hole] = Golf.playerStrokes[Golf.player];
                    break;
                }
                case 3: {
                    Golf.player3Par[Golf.hole] = Golf.playerStrokes[Golf.player];
                    break;
                }
                case 4: {
                    Golf.player4Par[Golf.hole] = Golf.playerStrokes[Golf.player];
                }
            }
            Golf.infoBox = 1;
            Golf.ballX = 999;
            Golf.ballY = 999;
            Golf.newPlayer = 1;
            var6_40 = 0;
            if (Golf.player1Par[Golf.hole] != 0) {
                ++var6_40;
            }
            if (Golf.player2Par[Golf.hole] != 0) {
                ++var6_40;
            }
            if (Golf.player3Par[Golf.hole] != 0) {
                ++var6_40;
            }
            if (Golf.player4Par[Golf.hole] != 0) {
                ++var6_40;
            }
            if (var6_40 == Golf.numOfPlayers) {
                Golf.ballIsOn = 8;
                ++Golf.hole;
                Golf.newCard = 1;
                Golf.playerClock = 0;
                Golf.bigRefresh2 = 1;
                Golf.newCardRefresh = 1;
                Golf.time2read = 1;
                if (Golf.hole > 9) {
                    Golf.gameOver = 1;
                    Golf.time2read = 0;
                }
            }
            Golf.inHole = 0;
            Golf.ballIsOn = 0;
        }
        var6_40 = 1;
        while (var6_40 < Golf.numOfPlayers + 1) {
            if (Golf.player != var6_40 && Golf.playerBallX[var6_40] != Golf.teeX && Golf.playerBallY[var6_40] != Golf.teeY) {
                if (Golf.magSelected == 1) {
                    Golf.magX = (Golf.playerBallX[var6_40] - Golf.pinX) * 2 + 300;
                    Golf.magY = (Golf.playerBallY[var6_40] - Golf.pinY) * 2 + 125;
                    var3_36.setColor(Color.gray);
                    var3_36.fillOval(Golf.magX - 3, Golf.magY - 2, 5, 5);
                    var3_36.setColor(Color.lightGray);
                    var3_36.fillOval(Golf.magX - 2, Golf.magY - 2, 4, 4);
                    var3_36.setColor(Color.white);
                    var3_36.fillOval(Golf.magX - 1, Golf.magY - 2, 3, 3);
                }
                if (Golf.magSelected == 0) {
                    var3_36.setColor(Color.gray);
                    var3_36.fillOval(Golf.playerBallX[var6_40] - 3, Golf.playerBallY[var6_40] - 2, 5, 5);
                    var3_36.setColor(Color.lightGray);
                    var3_36.fillOval(Golf.playerBallX[var6_40] - 2, Golf.playerBallY[var6_40] - 2, 4, 4);
                    var3_36.setColor(Color.white);
                    var3_36.fillOval(Golf.playerBallX[var6_40] - 1, Golf.playerBallY[var6_40] - 2, 3, 3);
                }
            }
            ++var6_40;
        }
        if (Golf.magSelected == 0) {
            if (Golf.ballInFlight == 0 && Golf.button == 0 && Golf.newPlayer == 0 && Golf.inLake == 0 && Golf.outOfBounds == 0 && Golf.playerClock == 0) {
                var3_36.setColor(Color.black);
                var3_36.drawLine(Golf.ballX, Golf.ballY, Golf.ballX + Golf.bpX, Golf.ballY + Golf.bpY / 2);
                var3_36.fillOval(Golf.ballX + Golf.bpX - 2, Golf.ballY + Golf.bpY / 2 - 2, 5, 5);
            }
            if (Golf.ballInFlight == 1) {
                var3_36.setColor(Color.darkGray);
                var3_36.fillOval(Golf.ballX - 3, Golf.ballY - 2, 5, 5);
            }
            if (Golf.inLake == 0) {
                var7_41 = 5 - Golf.ballZ / 8;
                var3_36.setColor(Color.gray);
                var3_36.fillOval(Golf.ballX - var7_41 / 2 - 2, Golf.ballY - var7_41 / 2 + Golf.ballZ, var7_41, var7_41);
                var3_36.setColor(Color.lightGray);
                var3_36.fillOval(Golf.ballX - var7_41 / 2 - 1, Golf.ballY - var7_41 / 2 + Golf.ballZ, var7_41 - 1, var7_41 - 1);
                var3_36.setColor(Color.white);
                var3_36.fillOval(Golf.ballX - var7_41 / 2, Golf.ballY - var7_41 / 2 + Golf.ballZ, var7_41 - 2, var7_41 - 2);
            }
            if (Golf.ballY < Golf.pinY) {
                var3_36.setColor(Color.black);
                var3_36.fillRect(Golf.pinX - 1, Golf.pinY - 1, 3, 2);
                var3_36.setColor(Color.yellow);
                var3_36.fillRect(Golf.pinX, Golf.pinY - 10, 1, 10);
                var3_36.setColor(Color.orange);
                if (Golf.windDX > 0) {
                    var3_36.fillRect(Golf.pinX + 1, Golf.pinY - 10, 3, 3);
                } else {
                    var3_36.fillRect(Golf.pinX - 3, Golf.pinY - 10, 3, 3);
                }
            }
        } else {
            if (Golf.ballInFlight == 0) {
                Golf.magBallX = (Golf.ballX - Golf.pinX) * 2 + 300;
                Golf.magBallY = (Golf.ballY - Golf.pinY) * 2 + 125;
            }
            Golf.magX = Golf.magBallX;
            Golf.magY = Golf.magBallY;
            if (Golf.ballInFlight == 0 && Golf.button == 0 && Golf.newPlayer == 0 && Golf.inLake == 0 && Golf.outOfBounds == 0 && Golf.playerClock == 0) {
                var3_36.setColor(Color.black);
                var3_36.drawLine(Golf.magX, Golf.magY, Golf.magX + Golf.bpX / 2, Golf.magY + Golf.bpY / 4);
                var3_36.fillOval(Golf.magX + Golf.bpX / 2 - 2, Golf.magY + Golf.bpY / 4 - 2, 5, 5);
            }
            var3_36.setColor(Color.gray);
            var3_36.fillOval(Golf.magX - 3, Golf.magY - 2, 5, 5);
            var3_36.setColor(Color.lightGray);
            var3_36.fillOval(Golf.magX - 2, Golf.magY - 2, 4, 4);
            var3_36.setColor(Color.white);
            var3_36.fillOval(Golf.magX - 1, Golf.magY - 2, 3, 3);
        }
        var3_36.setColor(Color.black);
        var3_36.drawString("Refresh", 5, 14);
        if (Golf.playerClock > 0 && Golf.gameOver == 0) {
            Golf.bigRefresh2 = 1;
            Golf.bigRefresh = 1;
            if (Golf.inLake == 0 && Golf.outOfBounds == 0) {
                var3_36.setColor(Color.black);
                var3_36.drawString("Club", 11, 248);
                var3_36.drawString("Lie", 64, 248);
                var3_36.drawString("Swing", 108, 248);
                var3_36.drawString("Wind", 161, 248);
                var3_36.drawString("Slope", 211, 248);
                var3_36.setColor(Color.white);
                var3_36.drawString("Club", 10, 247);
                var3_36.drawString("Lie", 63, 247);
                var3_36.drawString("Swing", 107, 247);
                var3_36.drawString("Wind", 160, 247);
                var3_36.drawString("Slope", 210, 247);
            }
            if (--Golf.playerClock == 0) {
                Golf.bigRefresh = 1;
            }
            if (Golf.playerClock == 4 && Golf.inLake == 1) {
                Golf.ballX = Golf.baseX;
                Golf.ballY = Golf.baseY;
                Golf.sfxque[Golf.sfxin] = 1;
                Golf.sfxin = (Golf.sfxin + 1) % 8;
                Golf.inLake = 0;
                Golf.picked = 0;
                Golf.button = 1;
                Golf.playerClock = 20;
                v13 = Golf.player;
                Golf.playerStrokes[v13] = Golf.playerStrokes[v13] + 1;
                Golf.infoBox = 1;
            }
            if (Golf.playerClock == 4 && Golf.outOfBounds == 1) {
                Golf.ballX = Golf.baseX;
                Golf.ballY = Golf.baseY;
                Golf.sfxque[Golf.sfxin] = 1;
                Golf.sfxin = (Golf.sfxin + 1) % 8;
                Golf.outOfBounds = 0;
                Golf.picked = 0;
                Golf.button = 1;
                Golf.playerClock = 20;
                Golf.infoBox = 1;
            }
            if (Golf.playerClock < 19) {
                if (Golf.inLake == 1 || Golf.outOfBounds == 1) {
                    var3_36.setColor(new Color(180, 80, 40));
                    var3_36.fillRect(0, 228, 600, 20);
                    if (Golf.inLake == 1) {
                        var3_36.setColor(Color.black);
                        var3_36.drawString("Water Hazzard:  1 stroke penalty", 201, 244);
                        var3_36.setColor(Color.white);
                        var3_36.drawString("Water Hazzard:  1 stroke penalty", 200, 243);
                    }
                    if (Golf.outOfBounds == 1) {
                        var3_36.setColor(Color.black);
                        var3_36.drawString("Out of Bounds:  1 stroke penalty", 201, 244);
                        var3_36.setColor(Color.white);
                        var3_36.drawString("Out of Bounds:  1 stroke penalty", 200, 243);
                    }
                    var3_36.setColor(Color.white);
                    var3_36.drawRect(0, 228, 599, 22);
                    var3_36.setColor(Color.lightGray);
                    var3_36.drawRect(1, 229, 597, 20);
                    var3_36.setColor(Color.gray);
                    var3_36.drawRect(2, 230, 595, 18);
                }
                if (Golf.outOfBounds == 0 && Golf.inLake == 0) {
                    var3_36.setColor(Golf.info1);
                    var3_36.fillRect(0, 86, 600, 20);
                    switch (Golf.player) {
                        case 1: {
                            Golf.tname = Golf.p1name;
                            break;
                        }
                        case 2: {
                            Golf.tname = Golf.p2name;
                            break;
                        }
                        case 3: {
                            Golf.tname = Golf.p3name;
                            break;
                        }
                        case 4: {
                            Golf.tname = Golf.p4name;
                        }
                    }
                    if (Golf.onGreen == 1 && Golf.playerStrokes[Golf.player] + 1 < Golf.holePars[Golf.hole + Golf.holebase] + 9) {
                        var7_42 = "";
                        if (Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] - 2) {
                            var7_42 = "an EAGLE";
                        }
                        if (Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] - 1) {
                            var7_42 = "a BIRDIE";
                        }
                        if (Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase]) {
                            var7_42 = "PAR";
                        }
                        if (Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 1) {
                            var7_42 = "BOGEY";
                        }
                        if (Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 2) {
                            var7_42 = "DOUBLE-BOGEY";
                        }
                        if (Golf.holePars[Golf.hole + Golf.holebase] == 3 && Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 3) {
                            var7_42 = "DOUBLE-PAR!!";
                        }
                        if (Golf.holePars[Golf.hole + Golf.holebase] > 3 && Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 3) {
                            var7_42 = "TRIPLE-BOGEY!!!";
                        }
                        if (Golf.holePars[Golf.hole + Golf.holebase] == 4 && Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 4) {
                            var7_42 = "DOUBLE-PAR!!";
                        }
                        if (Golf.holePars[Golf.hole + Golf.holebase] > 4 && Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 4) {
                            var7_42 = "FOUR-OVER-PAR!!!!";
                        }
                        if (Golf.holePars[Golf.hole + Golf.holebase] == 5 && Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 5) {
                            var7_42 = "DOUBLE-PAR!!";
                        }
                        if (Golf.holePars[Golf.hole + Golf.holebase] < 5 && Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 5) {
                            var7_42 = "FIVE-OVER-PAR!!!!!";
                        }
                        if (Golf.holePars[Golf.hole + Golf.holebase] == 3 && Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 6) {
                            var7_42 = "TRIPLE-PAR!!!";
                        }
                        if (Golf.holePars[Golf.hole + Golf.holebase] > 3 && Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 6) {
                            var7_42 = "SIX-OVER-PAR!!!!!";
                        }
                        if (Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 7) {
                            var7_42 = "SEVEN-OVER-PAR!!!!!!!";
                        }
                        if (Golf.playerStrokes[Golf.player] + 1 == Golf.holePars[Golf.hole + Golf.holebase] + 8) {
                            var7_42 = "EIGHT-OVER-PAR!!!!!!!!";
                        }
                        var3_36.setColor(Color.black);
                        var3_36.drawString("" + Golf.tname + "'s TURN" + "     Stroke " + (Golf.playerStrokes[Golf.player] + 1) + " for " + var7_42, 201, 101);
                        var3_36.setColor(Color.white);
                        var3_36.drawString("" + Golf.tname + "'s TURN" + "     Stroke " + (Golf.playerStrokes[Golf.player] + 1) + " for " + var7_42, 200, 100);
                    } else {
                        var3_36.setColor(Color.black);
                        var3_36.drawString("" + Golf.tname + "'s TURN" + "     Stroke " + (Golf.playerStrokes[Golf.player] + 1), 201, 101);
                        var3_36.setColor(Color.white);
                        var3_36.drawString("" + Golf.tname + "'s TURN" + "     Stroke " + (Golf.playerStrokes[Golf.player] + 1), 200, 100);
                    }
                    var3_36.setColor(Color.white);
                    var3_36.drawRect(0, 84, 599, 22);
                    var3_36.setColor(Color.lightGray);
                    var3_36.drawRect(1, 85, 597, 20);
                    var3_36.setColor(Color.gray);
                    var3_36.drawRect(2, 86, 595, 18);
                }
            }
        }
        if (Golf.bigRefresh2 == 1 || Golf.ballInFlight == 1) {
            Golf.bigRefresh2 = 0;
            var1_1.drawImage(Golf.working, 0, 0, null);
        }
        v14 = Golf.newCard == 0 && Golf.keyFace == 0 && Golf.ballInFlight == 0;
        var3_36.dispose();
        var2_20.dispose();
    }

    public void start() {
        this.aniThread = new Thread(this);
        this.aniThread.start();
    }

    public void stop() {
        this.aniThread.stop();
    }

    public void run() {
        while (true) {
            try {
                while (true) {
                    Thread.sleep(100L);
                    if (redball != 0) continue;
                    this.repaint();
                }
            } catch (Exception exception) {
                continue;
            }
            break;
        }
    }

    public synchronized boolean mouseDown(Event event, int n, int n2) {
        boolean bl = false;
        if (leaderBoard == 0 && newCard == 1 && n2 < 250 && keyFace == 0) {
            leaderBoard = 1;
            leaderRefresh = 1;
            newCard = 0;
            bl = true;
        }
        if (leaderBoard == 1 && n2 < 250 && !bl) {
            leaderBoard = 0;
            newCard = 1;
            newCardRefresh = 1;
            infoBox = 1;
        }
        if (keyFace == 1) {
            int n3;
            keyRefresh = 1;
            if (n > 550 && n < 570 && n2 > 40 && n2 < 60 && tname.length() > 0) {
                tname = tname.substring(0, tname.length() - 1);
            }
            if ((n > 490 && n < 590 && n2 > 175 && n2 < 195 || n > 360 && n < 460 && n2 > 175 && n2 < 195) && p1name.length() > 1 && p2name.length() != 1 && p3name.length() != 1 && p4name.length() != 1) {
                keyFace = 0;
                player = 1;
                playerClock = 20;
                numOfPlayers = 1;
                if (p2name.length() > 0) {
                    ++numOfPlayers;
                }
                if (p3name.length() > 0) {
                    ++numOfPlayers;
                }
                if (p4name.length() > 0) {
                    ++numOfPlayers;
                }
                player1Total = 0;
                player2Total = 0;
                player3Total = 0;
                player4Total = 0;
                n3 = 1;
                while (n3 < 19) {
                    Golf.player1Par[n3] = 0;
                    Golf.player2Par[n3] = 0;
                    Golf.player3Par[n3] = 0;
                    Golf.player4Par[n3] = 0;
                    ++n3;
                }
                if (p2name.length() == 0 && (p3name.length() > 0 || p4name.length() > 0)) {
                    keyFace = 1;
                    if (p3name.length() == 0) {
                        player = 2;
                        tname = p2name = p4name;
                    } else {
                        player = 3;
                        p2name = p3name;
                        tname = p3name = p4name;
                        if (p3name.length() == 0) {
                            player = 2;
                            tname = p2name;
                        }
                    }
                    p4name = "";
                }
                if (p3name.length() == 0 && p4name.length() > 0) {
                    player = 3;
                    keyFace = 1;
                    tname = p3name = p4name;
                    p4name = "";
                }
                if (keyFace == 0) {
                    holebase = 0;
                    if (n > 490) {
                        holebase = 9;
                    }
                    round = 0;
                    button = 1;
                    picked = 0;
                    aniClock = 0;
                    infoBox = 1;
                    newPower = 1;
                    newClub = 1;
                    newWind = 1;
                    newSlope = 1;
                    rangeClock = 0;
                    time2read = 1;
                    holebuilt = 0;
                    keyBack = 1;
                    gameOver = 0;
                    hole = 1;
                    Golf.sfxque[Golf.sfxin] = 1;
                    sfxin = (sfxin + 1) % 8;
                }
            }
            if (n > 8 && n < 585 && n2 > 84 && n2 < 103) {
                player = 1;
                tname = p1name;
            }
            if (n > 8 && n < 585 && n2 > 105 && n2 < 124 && p1name.length() > 1) {
                player = 2;
                tname = p2name;
            }
            if (n > 8 && n < 585 && n2 > 126 && n2 < 145 && p2name.length() > 1) {
                player = 3;
                tname = p3name;
            }
            if (n > 8 && n < 585 && n2 > 147 && n2 < 166 && p3name.length() > 1) {
                player = 4;
                tname = p4name;
            }
            n3 = 1;
            while (n3 < 27) {
                if (n > n3 * 20 && n < n3 * 20 + 20 && n2 > 50 && n2 < 70 && tname.length() < 10) {
                    switch (n3) {
                        case 1: {
                            tname = tname + "A";
                            break;
                        }
                        case 2: {
                            tname = tname + "B";
                            break;
                        }
                        case 3: {
                            tname = tname + "C";
                            break;
                        }
                        case 4: {
                            tname = tname + "D";
                            break;
                        }
                        case 5: {
                            tname = tname + "E";
                            break;
                        }
                        case 6: {
                            tname = tname + "F";
                            break;
                        }
                        case 7: {
                            tname = tname + "G";
                            break;
                        }
                        case 8: {
                            tname = tname + "H";
                            break;
                        }
                        case 9: {
                            tname = tname + "I";
                            break;
                        }
                        case 10: {
                            tname = tname + "J";
                            break;
                        }
                        case 11: {
                            tname = tname + "K";
                            break;
                        }
                        case 12: {
                            tname = tname + "L";
                            break;
                        }
                        case 13: {
                            tname = tname + "M";
                            break;
                        }
                        case 14: {
                            tname = tname + "N";
                            break;
                        }
                        case 15: {
                            tname = tname + "O";
                            break;
                        }
                        case 16: {
                            tname = tname + "P";
                            break;
                        }
                        case 17: {
                            tname = tname + "Q";
                            break;
                        }
                        case 18: {
                            tname = tname + "R";
                            break;
                        }
                        case 19: {
                            tname = tname + "S";
                            break;
                        }
                        case 20: {
                            tname = tname + "T";
                            break;
                        }
                        case 21: {
                            tname = tname + "U";
                            break;
                        }
                        case 22: {
                            tname = tname + "V";
                            break;
                        }
                        case 23: {
                            tname = tname + "W";
                            break;
                        }
                        case 24: {
                            tname = tname + "X";
                            break;
                        }
                        case 25: {
                            tname = tname + "Y";
                            break;
                        }
                        case 26: {
                            tname = tname + "Z";
                        }
                    }
                }
                if (n > n3 * 20 && n < n3 * 20 + 20 && n2 > 30 && n2 < 50 && tname.length() < 10) {
                    switch (n3) {
                        case 1: {
                            tname = tname + "a";
                            break;
                        }
                        case 2: {
                            tname = tname + "b";
                            break;
                        }
                        case 3: {
                            tname = tname + "c";
                            break;
                        }
                        case 4: {
                            tname = tname + "d";
                            break;
                        }
                        case 5: {
                            tname = tname + "e";
                            break;
                        }
                        case 6: {
                            tname = tname + "f";
                            break;
                        }
                        case 7: {
                            tname = tname + "g";
                            break;
                        }
                        case 8: {
                            tname = tname + "h";
                            break;
                        }
                        case 9: {
                            tname = tname + "i";
                            break;
                        }
                        case 10: {
                            tname = tname + "j";
                            break;
                        }
                        case 11: {
                            tname = tname + "k";
                            break;
                        }
                        case 12: {
                            tname = tname + "l";
                            break;
                        }
                        case 13: {
                            tname = tname + "m";
                            break;
                        }
                        case 14: {
                            tname = tname + "n";
                            break;
                        }
                        case 15: {
                            tname = tname + "o";
                            break;
                        }
                        case 16: {
                            tname = tname + "p";
                            break;
                        }
                        case 17: {
                            tname = tname + "q";
                            break;
                        }
                        case 18: {
                            tname = tname + "r";
                            break;
                        }
                        case 19: {
                            tname = tname + "s";
                            break;
                        }
                        case 20: {
                            tname = tname + "t";
                            break;
                        }
                        case 21: {
                            tname = tname + "u";
                            break;
                        }
                        case 22: {
                            tname = tname + "v";
                            break;
                        }
                        case 23: {
                            tname = tname + "w";
                            break;
                        }
                        case 24: {
                            tname = tname + "x";
                            break;
                        }
                        case 25: {
                            tname = tname + "y";
                            break;
                        }
                        case 26: {
                            tname = tname + "z";
                        }
                    }
                }
                ++n3;
            }
            return true;
        }
        if (n > 0 && n2 > 0 && n < 50 && n2 < 14 && ballInFlight == 0 && newCard == 0) {
            picked = 0;
            button = 1;
            lastBallIsOn = 99;
            ballIsOn = 0;
            infoBox = 1;
            aniClock = 0;
            newPower = 1;
            newClub = 1;
            newWind = 1;
            newSlope = 1;
            rangeClock = 0;
            bigRefresh = 1;
            fullRefresh = 1;
            playerClock = 20;
            holebuilt = 0;
            Golf.sfxque[Golf.sfxin] = 3;
            sfxin = (sfxin + 1) % 8;
        }
        if (n > 500 && n2 > 255 && n < 590 && n2 < 294 && (newCard == 1 || leaderBoard == 1)) {
            Golf.sfxque[Golf.sfxin] = 4;
            sfxin = (sfxin + 1) % 8;
            newCard = 0;
            leaderBoard = 0;
            keyFace = 1;
            keyRefresh = 1;
            tname = p1name;
            player = 1;
        }
        if (n > 260 && n2 > 255 && n < 350 && n2 < 294 && (newCard == 1 || leaderBoard == 1) && gameOver == 0) {
            Golf.sfxque[Golf.sfxin] = 2;
            sfxin = (sfxin + 1) % 8;
            newCard = 0;
            leaderBoard = 0;
            infoBox = 1;
        }
        if (n > 260 && n2 > 255 && n < 380 && n2 < 294 && (newCard == 1 || leaderBoard == 1) && gameOver == 1) {
            reportIn = 1;
            newCard = 0;
            leaderBoard = 1;
            leaderRefresh = 1;
        }
        if (n2 < 250 && aniClock > 10 && newCard == 0) {
            aimX = n;
            aimY = n2;
            bigRefresh = 1;
        }
        if (n > 0 && n2 > 250 && n < 50 && n2 < 299 && ballInFlight == 0 && newCard == 0) {
            rangeClock = 20;
            bigRefresh = 1;
        }
        if (n > 4 && n2 > 285 && n < 24 && n2 < 297 && newCard == 0 && ballInFlight == 0) {
            if (--club < 2) {
                club = 15;
            }
            newClub = 1;
            rangeClock = 20;
            bigRefresh = 1;
        }
        if (n > 27 && n2 > 285 && n < 47 && n2 < 297 && newCard == 0 && ballInFlight == 0) {
            if (++club > 15) {
                club = 2;
            }
            newClub = 1;
            rangeClock = 20;
            bigRefresh = 1;
        }
        if (n > 100 && n2 > 250 && n < 150 && n2 < 299 && ballInFlight == 0 && inLake == 0 && newPlayer == 0 && aniClock > 20 && newCard == 0) {
            ballInFlight = 1;
            ballDX = ballDX * globalSize * 2;
            ballDY = ballDY * globalSize * 2;
            if (club != 12) {
                ballDX += (int) (Math.random() * 7.0) - 3;
                ballDY += (int) (Math.random() * 7.0) - 3;
            } else {
                ballDX += (int) (Math.random() * 3.0) - 1;
                ballDY += (int) (Math.random() * 3.0) - 1;
            }
            int n4 = 100;
            switch (ballIsOn) {
                case 0:
                case 3: {
                    n4 = 100;
                    break;
                }
                case 1: {
                    n4 = 120;
                    if (sandPlug != 1) break;
                    n4 = 130 + (int) (Math.random() * 20.0);
                    break;
                }
                case 4: {
                    n4 = 100;
                    break;
                }
                case 5: {
                    n4 = 110;
                    break;
                }
                case 6: {
                    n4 = 120 + (int) (Math.random() * 40.0);
                }
            }
            ballDX = ballDX * 3 * (power + 1) / n4;
            ballDY = ballDY * 3 * (power + 1) / n4;
            baseDX = ballDX;
            baseDY = ballDY /= 2;
            ballTime = 1;
            ballTimeOut = 19 + globalSize / 30;
            if (club < 12) {
                ballTimeOut += 6;
            }
            ballTimeOut *= 2;
            ++ballTimeOut;
            bounced = 0;
            ballGravity = -(18 - globalSize / 30);
            ballGravity = ballGravity * (power * 3 + 2) / 100;
            ballGravity /= 2;
            if (club > 12 && (ballIsOn == 6 || ballIsOn == 1)) {
                ballTimeOut /= 4;
                ballGravity /= 4;
            }
            if (club == 13 && ballIsOn != 0) {
                ballTimeOut /= 2;
                ballGravity /= 2;
            }
            if (club == 12) {
                Golf.sfxque[Golf.sfxin] = 2;
                sfxin = (sfxin + 1) % 8;
                ballGravity = 0;
            }
            ballZ = 0;
            lastsfx = 0;
            if (club != 12 && inSand == 1) {
                Golf.sfxque[Golf.sfxin] = 3;
                sfxin = (sfxin + 1) % 8;
            }
            if (club != 12 && inSand == 0) {
                Golf.sfxque[Golf.sfxin] = 1;
                sfxin = (sfxin + 1) % 8;
            }
            slower = ballTimeOut;
            baseX = ballX;
            baseY = ballY;
            magBallX = (ballX - pinX) * 2 + 300;
            magBallY = (ballY - pinY) * 2 + 125;
            magBaseX = magBallX;
            magBaseY = magBallY;
            sandchk = 0;
            sandPlug = 0;
            button = 1;
            picked = 0;
            int n5 = player;
            playerStrokes[n5] = playerStrokes[n5] + 1;
        }
        return true;
    }
}
