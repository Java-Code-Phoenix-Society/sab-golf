package dev.jcps;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.util.Random;
import java.util.StringTokenizer;

public class Golf extends JFrame implements JavaAppletAdapter {
    public Random rand;
    protected static Clip sunkit = null;
    protected static Clip putt = null;
    protected static Clip water = null;
    protected static Clip swing = null;
    protected static Clip sand = null;
    protected static String serverName = "";
    protected static String serverPath = "";
    protected static String input = "";
    protected static String tourdata = "";
    protected static String rdata = "";
    protected static String csdata = "";
    protected static int inleng;
    protected static int myc;
    protected static int top10Flag = 1;
    protected static String cname = "";
    protected static int tenth;
    protected static int reportedIn;
    protected static int[] myarray = new int[]{
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int sfxin;
    static int sfxout;
    static int[] sfxque = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int allImages;
    static int imgflag;
    static int reportIn;
    static int redball;
    static int tourDone;
    static int round;
    static int[] tourScores = new int[5];
    static int[] tourPars = new int[40];
    static int leaderBoard;
    static int leaderRefresh;
    static int sfx;
    static int lastsfx;
    static int cuesfx;
    static String golfdata = "0";
    static int time2save;
    static int time2read = 1;
    static int gothole;
    static int picked = 1;
    static int slower;
    static int lastBallIsOn = 99;
    static int lakeScanner = -1;
    static int inHole;
    static int outOfBounds;
    static int bigRefresh = 1;
    static int fullRefresh;
    static int bigRefresh2;
    static String tname = "";
    static String p1name = "";
    static String p2name = "";
    static String p3name = "";
    static String p4name = "";
    static int player = 1;
    static int newPlayer;
    static int numOfPlayers = 1;
    static int keyClock = 1;
    static int playerClock = 1;
    static int keyFace = 1;
    static int keyBack = 1;
    static int keyRefresh = 1;
    static int gameOver;
    static int frontYards;
    static int frontPar;
    static int backYards;
    static int backPar;
    static int[] holeYards = new int[19];
    static int[] holePars = new int[19];
    static int[] player1Par = new int[19];
    static int[] player2Par = new int[19];
    static int[] player3Par = new int[19];
    static int[] player4Par = new int[19];
    static int player1Total;
    static int player2Total;
    static int player3Total;
    static int player4Total;
    static int[] playerStrokes = new int[5];
    static int[] playerBallX = new int[5];
    static int[] playerBallY = new int[5];
    static int[] playerSandchk = new int[5];
    static int[] dist = new int[5];
    static int[] honor = new int[5];
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
    static int newSlope = 1;
    static int slopeDX = 1;
    static int slopeDY = 1;
    static int newWind = 1;
    static int windDX = 3;
    static int windDY = 7;
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
    static int newPower = 1;
    static int power = 2;
    static int powerDir = 1;
    static int rangeClock;
    static int newClub = 1;
    static int club = 5;
    static int hole = 1;
    static int holebase;
    static int par = 4;
    static int yards = 324;
    static int infoX = 271;
    static int infoY = 275;
    static int infoBox;
    static int aimX = 300;
    static int aimY = 74;
    static int sandPlug;
    static int ballIsOn;
    static int globalSize = 10;
    static int showBar = 1;
    static int magX;
    static int magY;
    static int magSize = 1;
    static int magSelected;
    static int pinX = 300;
    static int pinY = 74;
    static int pinSelected;
    static int trackX = 50;
    static int trackY = 50;
    static int teeX = 50;
    static int teeY = 220;
    static int teeSelected;
    static int aniClock;
    static int button = 1;
    static int size;
    static int dx = 4;
    static int dy = -1;
    static int dz = 50;
    static int X = 30;
    static int Y = 220;
    static int ballX = 50;
    static int ballY = 220;
    static int magBallX = 50;
    static int magBallY = 220;
    static int holebuilt;
    static int undoSelected;
    static int lakeSelected = 1;
    static int roughSelected;
    static int fairwaySelected;
    static int greenSelected;
    static int sandSelected;
    static int treeSelected;
    static int showOptions = 1;
    static int onGreen;
    static int inSand;
    static int inLake;
    static int inRough;
    static int onFairway;
    static int fairways;
    static int[] fairwayX = new int[102];
    static int[] fairwayY = new int[102];
    static int[] fairwayRadius = new int[102];
    static int roughs;
    static int[] roughX = new int[102];
    static int[] roughY = new int[102];
    static int[] roughRadius = new int[102];
    static int lakes = 1;
    static int[] lakeX = new int[102];
    static int[] lakeY = new int[102];
    static int[] lakeRadius = new int[102];
    static int sandtraps = 4;
    static int[] sandX = new int[102];
    static int[] sandY = new int[102];
    static int[] sandRadius = new int[102];
    static int greens = 2;
    static int[] greenX = new int[102];
    static int[] greenY = new int[102];
    static int[] greenRadius = new int[102];
    static int trees;
    static int[] treeX = new int[102];
    static int[] treeY = new int[102];
    static int[] treeRadius = new int[102];
    static Color sand1 = new Color(90, 180, 120);
    static Color sand2 = new Color(180, 255, 160);
    static Color sand3 = new Color(255, 230, 180);
    static Color sand4 = new Color(223, 198, 148);
    static Color lake1 = new Color(128, 115, 90);
    static Color lake2 = new Color(255, 230, 180);
    static Color lake3 = new Color(0, 40, 200);
    static Color lake4 = new Color(100, 100, 200);
    static Color lake5 = new Color(132, 132, 232);
    static Color rough1 = new Color(90, 220, 90);
    static Color rough2 = new Color(58, 188, 58);
    static Color fairway1 = new Color(144, 234, 104);
    static Color fairway2 = new Color(100, 255, 120);
    static Color green1 = new Color(80, 180, 80);
    static Color green2 = new Color(56, 156, 56);
    static Color tee1 = new Color(80, 160, 100);
    static Color tee2 = new Color(250, 50, 50);
    static Color info1 = new Color(160, 40, 20);
    static String holedata1 = "";
    static String holedata2 = "";
    static String holedata3 = "";
    static String holedata4 = "";
    static String holedata5 = "";
    static String holedata6 = "";
    static String holedata7 = "";
    static String holedata8 = "";
    static String holedata9 = "";
    static String holedata10 = "";
    static String holedata11 = "";
    static String holedata12 = "";
    static String holedata13 = "";
    static String holedata14 = "";
    static String holedata15 = "";
    static String holedata16 = "";
    static String holedata17 = "";
    static String holedata18 = "";
    static Image powerbar;
    static Image wind;
    static Image greenslope;
    static Image clubface;
    static Image ball;
    static Image gold;
    static Image working;
    /**
     * Animation timer.
     */
    Timer aniTimer;

    public Golf() {
        rand = new Random();
        redball = 1;
    }

    public static void main(String[] args) {
        Golf game = new Golf();
        game.setSize(400, 210);
        game.setTitle("SAB Golf");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //game.setUndecorated(true);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        game.init();
        game.start();
    }

    public void init() {
        this.setForeground(Color.gray);
        this.setBackground(Color.gray);
        serverName = this.getParameter("servername");
        serverPath = this.getParameter("serverpath");
        sunkit = this.getAudioClip(this.getDocumentBase(), "sunkit.wav");
        putt = this.getAudioClip(this.getDocumentBase(), "putt.wav");
        water = this.getAudioClip(this.getDocumentBase(), "water.wav");
        swing = this.getAudioClip(this.getDocumentBase(), "swing.wav");
        sand = this.getAudioClip(this.getDocumentBase(), "sand.wav");
        greenslope = this.createImage(50, 50);
        clubface = this.createImage(50, 50);
        wind = this.createImage(50, 50);
        powerbar = this.createImage(50, 50);
        ball = this.createImage(50, 50);
        gold = this.createImage(600, 300);
        working = this.createImage(600, 300);
    }

    /**
     * <p>
     * Starts the animation timer.
     * </p>
     * <p>
     * This method initializes and starts a Timer object responsible for triggering the animation loop.
     * The Timer is set to execute the animation loop at regular intervals defined by the specified delay.
     * Upon execution, the animation loop invokes the {@code run} method to update the animation state.
     */
    public void start() {
        // Initialize a Timer object with a delay of 1 millisecond,
        // triggering the animation loop at regular intervals
        // and invoking the 'run' method to update the animation state
        aniTimer = new Timer(1, e -> this.run());
        aniTimer.start();
    }

    /**
     * Reads tournament scoring data from a data file.
     * This method retrieves golf tournament scoring data from 'golfscor.dat' file
     * located at the document base URL. The data is read line by line and stored
     * for further processing.
     */
    public void readtourdata() {
        try {
            URL golfScoreFileUrl = new URL(this.getDocumentBase() + "golfscor.dat");
            StringBuilder tournamentData = new StringBuilder();
            try (BufferedReader scoreFileReader = new BufferedReader(new InputStreamReader(golfScoreFileUrl.openStream()))) {
                String currentLine;
                while ((currentLine = scoreFileReader.readLine()) != null) {
                    tournamentData.append(currentLine).append("\n");
                }
            }
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }

    public void readgolfdata() {
        Graphics g = this.getGraphics();
        g.setColor(new Color(26, 156, 26));
        g.fillRect(0, 0, 600, 300);

        for (int i = 1; i < 19; ++i) {
            g.setColor(Color.blue);
            g.fillRect(0, 85, 600, 20);
            g.setColor(Color.black);
            g.drawString("READING HOLE " + i, 101, 101);
            g.setColor(Color.white);
            g.drawString("READING HOLE " + i, 100, 100);

            try {
                URL url = new URL(this.getDocumentBase() + "sbhole" + i + ".dat");
                DataInputStream dis = new DataInputStream(url.openStream());

                String line;
                String accumulatedData;
                for (rdata = ""; (line = dis.readLine()) != null; rdata = accumulatedData + line + "\n") {
                    accumulatedData = rdata;
                }

                dis.close();
            } catch (Exception e) {
                // ignored
            }

            switch (i) {
                case 1:
                    holedata1 = rdata;
                    break;
                case 2:
                    holedata2 = rdata;
                    break;
                case 3:
                    holedata3 = rdata;
                    break;
                case 4:
                    holedata4 = rdata;
                    break;
                case 5:
                    holedata5 = rdata;
                    break;
                case 6:
                    holedata6 = rdata;
                    break;
                case 7:
                    holedata7 = rdata;
                    break;
                case 8:
                    holedata8 = rdata;
                    break;
                case 9:
                    holedata9 = rdata;
                    break;
                case 10:
                    holedata10 = rdata;
                    break;
                case 11:
                    holedata11 = rdata;
                    break;
                case 12:
                    holedata12 = rdata;
                    break;
                case 13:
                    holedata13 = rdata;
                    break;
                case 14:
                    holedata14 = rdata;
                    break;
                case 15:
                    holedata15 = rdata;
                    break;
                case 16:
                    holedata16 = rdata;
                    break;
                case 17:
                    holedata17 = rdata;
                    break;
                case 18:
                    holedata18 = rdata;
            }

            String tokenString = "";
            if (!rdata.isEmpty()) {
                StringTokenizer stringTokenizer = new StringTokenizer(rdata, "+");
                if (stringTokenizer.hasMoreTokens()) {
                    tokenString = stringTokenizer.nextToken();
                }

                boolean tokenFull = false;

                while (!tokenFull) {
                    if (stringTokenizer.hasMoreTokens()) {
                        tokenString = stringTokenizer.nextToken();
                    }

                    tokenString = tokenString.substring(1, tokenString.length());
                    if (stringTokenizer.hasMoreTokens()) {
                        tokenString = stringTokenizer.nextToken();
                    }

                    switch (Integer.parseInt(tokenString)) {
                        case 1:
                            if (stringTokenizer.hasMoreTokens()) {
                                tokenString = stringTokenizer.nextToken();
                            }

                            teeX = Integer.parseInt(tokenString);
                            ballX = teeX;
                            if (stringTokenizer.hasMoreTokens()) {
                                tokenString = stringTokenizer.nextToken();
                            }

                            teeY = Integer.parseInt(tokenString);
                            ballY = teeY;
                            ballIsOn = 0;
                            if (stringTokenizer.hasMoreTokens()) {
                                tokenString = stringTokenizer.nextToken();
                            }

                            pinX = Integer.parseInt(tokenString);
                            if (stringTokenizer.hasMoreTokens()) {
                                tokenString = stringTokenizer.nextToken();
                            }

                            pinY = Integer.parseInt(tokenString);
                            aimX = pinX;
                            aimY = pinY;
                            int distanceX = (pinX - teeX) * (pinX - teeX);
                            int distanceY = (pinY - teeY) * (pinY - teeY) * 4;
                            int pinDistX = 0;
                            int pindistY = 0;
                            int maxD = 200;
                            if (pinX > teeX) {
                                pinDistX = pinX - teeX;
                            } else {
                                pinDistX = teeX - pinX;
                            }

                            if (pinY > teeY) {
                                pindistY = pinY - teeY;
                            } else {
                                pindistY = teeY - pinY;
                            }

                            if (pinDistX >= pindistY) {
                                maxD = pinDistX + pindistY / 4;
                            }

                            if (pinDistX < pindistY) {
                                maxD = pindistY + pinDistX / 4;
                            }

                            yards = (distanceX + distanceY) / maxD;
                            yards = (distanceX + distanceY) / ((yards + maxD) / 2);
                            par = 3;
                            if (yards > 225) {
                                par = 4;
                            }

                            if (yards > 450) {
                                par = 5;
                            }

                            holeYards[i] = yards;
                            holePars[i] = par;
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            if (stringTokenizer.hasMoreTokens()) {
                                tokenString = stringTokenizer.nextToken();
                            }

                            if (stringTokenizer.hasMoreTokens()) {
                                tokenString = stringTokenizer.nextToken();
                            }

                            if (stringTokenizer.hasMoreTokens()) {
                                tokenString = stringTokenizer.nextToken();
                            }
                            break;
                        case 8:
                            tokenFull = true;
                    }
                }
            }
        }

        g.dispose();
        gothole = 1;
    }

    public void nextplayer() {
        playerBallX[player] = ballX;
        playerBallY[player] = ballY;
        playerSandchk[player] = sandPlug;

        for (int i = 1; i < numOfPlayers + 1; ++i) {
            dist[i] = 0;
            if (i == 1 && player1Par[hole] == 0) {
                dist[i] = (playerBallX[i] - pinX) * (playerBallX[i] - pinX) + (playerBallY[i] - pinY) * (playerBallY[i] - pinY);
            }

            if (i == 2 && player2Par[hole] == 0) {
                dist[i] = (playerBallX[i] - pinX) * (playerBallX[i] - pinX) + (playerBallY[i] - pinY) * (playerBallY[i] - pinY);
            }

            if (i == 3 && player3Par[hole] == 0) {
                dist[i] = (playerBallX[i] - pinX) * (playerBallX[i] - pinX) + (playerBallY[i] - pinY) * (playerBallY[i] - pinY);
            }

            if (i == 4 && player4Par[hole] == 0) {
                dist[i] = (playerBallX[i] - pinX) * (playerBallX[i] - pinX) + (playerBallY[i] - pinY) * (playerBallY[i] - pinY);
            }
        }

        if (ballX != teeX && ballY != teeY || hole == 1) {
            int distVec = dist[1];
            player = 1;

            for (int j = 1; j < numOfPlayers + 1; ++j) {
                if (j == 1 && distVec < dist[j] && player1Par[hole] == 0) {
                    distVec = dist[j];
                    player = j;
                }

                if (j == 2 && distVec < dist[j] && player2Par[hole] == 0) {
                    distVec = dist[j];
                    player = j;
                }

                if (j == 3 && distVec < dist[j] && player3Par[hole] == 0) {
                    distVec = dist[j];
                    player = j;
                }

                if (j == 4 && distVec < dist[j] && player4Par[hole] == 0) {
                    distVec = dist[j];
                    player = j;
                }
            }
        }

        if (hole > 1 && ballX == teeX && ballY == teeY) {
            player = 1;
            int maxS = 999;

            for (int k = 1; k < numOfPlayers + 1; ++k) {
                if (k == 1 && honor[1] < maxS && player1Par[hole] == 0) {
                    player = 1;
                    maxS = honor[1];
                }

                if (k == 2 && honor[2] < maxS && player2Par[hole] == 0) {
                    player = 2;
                    maxS = honor[2];
                }

                if (k == 3 && honor[3] < maxS && player3Par[hole] == 0) {
                    player = 3;
                    maxS = honor[3];
                }

                if (k == 4 && honor[4] < maxS && player4Par[hole] == 0) {
                    player = 4;
                    maxS = honor[4];
                }
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

    public boolean imageUpdate(Image img, int bits, int x, int y, int w, int h) {
        try {
            if ((bits & 32) != 0) {
                imgflag = 1;
                return false;
            }
        } catch (Exception e) {
            System.out.println("Image Error:" + e);
        }

        return true;
    }

    public void update(Graphics g) {
        redball = 1;
        if (sfxin != sfxout) {
            switch (sfxque[sfxout]) {
                case 1:
                    swing.start();
                    sfxque[sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
                    break;
                case 2:
                    putt.start();
                    sfxque[sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
                    break;
                case 3:
                    sand.start();
                    sfxque[sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
                    break;
                case 4:
                    water.start();
                    sfxque[sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
                    break;
                case 5:
                    sunkit.start();
                    sfxque[sfxout] = 0;
                    sfxout = (sfxout + 1) % 8;
            }
        }

        this.paint(g);
        redball = 0;
    }

    public void writetourdata() {
        int currentScore = 0;
        String currentName = "";

        for (int i = 1; i < numOfPlayers + 1; ++i) {
            switch (i) {
                case 1:
                    currentName = p1name;
                    currentScore = player1Total;
                    break;
                case 2:
                    currentName = p2name;
                    currentScore = player2Total;
                    break;
                case 3:
                    currentName = p3name;
                    currentScore = player3Total;
                    break;
                case 4:
                    currentName = p4name;
                    currentScore = player4Total;
            }

            try {
                Socket socket = new Socket(serverName, 80);
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                if (holebase == 0) {
                    outputStream.writeBytes("GET " + serverPath + "golfscor.cgi?" + currentScore + "+(F)" + currentName + "+\n\n");
                }

                if (holebase == 9) {
                    outputStream.writeBytes("GET " + serverPath + "golfscor.cgi?" + currentScore + "+(B)" + currentName + "+\n\n");
                }

                String line1;
                String accumalatedData;
                for (tourdata = ""; (line1 = inputStream.readLine()) != null; tourdata = accumalatedData + line1 + "\n") {
                    accumalatedData = tourdata;
                }

                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (Exception var8) {
                System.out.println("Error:" + var8);
            }
        }

    }

    public void paint(Graphics g) {
        if (redball != 0) {
            ++aniClock;
            if (time2read == 1) {
                if (gothole == 0) {
                    this.readgolfdata();
                }

                rdata = "";
                switch (hole + holebase) {
                    case 1:
                        rdata = holedata1;
                        break;
                    case 2:
                        rdata = holedata2;
                        break;
                    case 3:
                        rdata = holedata3;
                        break;
                    case 4:
                        rdata = holedata4;
                        break;
                    case 5:
                        rdata = holedata5;
                        break;
                    case 6:
                        rdata = holedata6;
                        break;
                    case 7:
                        rdata = holedata7;
                        break;
                    case 8:
                        rdata = holedata8;
                        break;
                    case 9:
                        rdata = holedata9;
                        break;
                    case 10:
                        rdata = holedata10;
                        break;
                    case 11:
                        rdata = holedata11;
                        break;
                    case 12:
                        rdata = holedata12;
                        break;
                    case 13:
                        rdata = holedata13;
                        break;
                    case 14:
                        rdata = holedata14;
                        break;
                    case 15:
                        rdata = holedata15;
                        break;
                    case 16:
                        rdata = holedata16;
                        break;
                    case 17:
                        rdata = holedata17;
                        break;
                    case 18:
                        rdata = holedata18;
                }

                String line = "";
                if (!rdata.isEmpty() && gothole == 1) {
                    StringTokenizer tokenizer = new StringTokenizer(rdata, "+");
                    if (tokenizer.hasMoreTokens()) {
                        line = tokenizer.nextToken();
                    }

                    lakes = 0;
                    roughs = 0;
                    fairways = 0;
                    sandtraps = 0;
                    greens = 0;
                    trees = 0;
                    boolean noMore = false;

                    while (!noMore) {
                        if (tokenizer.hasMoreTokens()) {
                            line = tokenizer.nextToken();
                        }

                        line = line.substring(1, line.length());
                        if (tokenizer.hasMoreTokens()) {
                            line = tokenizer.nextToken();
                        }

                        switch (Integer.parseInt(line)) {
                            case 1:
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                teeX = Integer.parseInt(line);
                                ballX = teeX;
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                teeY = Integer.parseInt(line);
                                ballY = teeY;
                                ballIsOn = 0;
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                pinX = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                pinY = Integer.parseInt(line);
                                aimX = pinX;
                                aimY = pinY;
                                int distX = (pinX - teeX) * (pinX - teeX);
                                int distY = (pinY - teeY) * (pinY - teeY);
                                int xDist = 0;
                                int yDist = 0;
                                int max = 100;
                                if (pinX > teeX) {
                                    xDist = pinX - teeX;
                                } else {
                                    xDist = teeX - pinX;
                                }

                                if (pinY > teeY) {
                                    yDist = pinY - teeY;
                                } else {
                                    yDist = teeY - pinY;
                                }

                                if (xDist > yDist) {
                                    max = xDist + yDist / 4;
                                } else {
                                    max = yDist + xDist / 4;
                                }

                                yards = (distX + distY) / max;
                                yards = (distX + distY) / ((yards + max) / 2);
                                par = 3;
                                if (yards > 225) {
                                    par = 4;
                                }

                                if (yards > 410) {
                                    par = 5;
                                }
                                break;
                            case 2:
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                lakeX[lakes] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                lakeY[lakes] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                lakeRadius[lakes] = Integer.parseInt(line);
                                ++lakes;
                                break;
                            case 3:
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                roughX[roughs] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                roughY[roughs] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                roughRadius[roughs] = Integer.parseInt(line);
                                ++roughs;
                                break;
                            case 4:
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                fairwayX[fairways] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                fairwayY[fairways] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                fairwayRadius[fairways] = Integer.parseInt(line);
                                ++fairways;
                                break;
                            case 5:
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                sandX[sandtraps] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                sandY[sandtraps] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                sandRadius[sandtraps] = Integer.parseInt(line);
                                ++sandtraps;
                                break;
                            case 6:
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                greenX[greens] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                greenY[greens] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                greenRadius[greens] = Integer.parseInt(line);
                                ++greens;
                                break;
                            case 7:
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                treeX[trees] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                treeY[trees] = Integer.parseInt(line);
                                if (tokenizer.hasMoreTokens()) {
                                    line = tokenizer.nextToken();
                                }

                                treeRadius[trees] = Integer.parseInt(line);
                                treeRadius[trees] = treeY[trees] / 15 + 7;
                                ++trees;
                                break;
                            case 8:
                                noMore = true;
                        }
                    }

                    int arrYSize = 250;
                    int ySize = 0;
                    int arrXSize = 250;
                    int xSize = 0;

                    for (int i = 0; i < roughs; ++i) {
                        if (roughX[i] + roughRadius[i] > xSize) {
                            xSize = roughX[i] + roughRadius[i];
                        }

                        if (roughX[i] - roughRadius[i] < arrXSize) {
                            arrXSize = roughX[i] - roughRadius[i];
                        }

                        if (roughY[i] + roughRadius[i] > ySize) {
                            ySize = roughY[i] + roughRadius[i];
                        }

                        if (roughY[i] - roughRadius[i] < arrYSize) {
                            arrYSize = roughY[i] - roughRadius[i];
                        }
                    }

                    for (int j = 0; j < fairways; ++j) {
                        if (fairwayX[j] + fairwayRadius[j] > xSize) {
                            xSize = fairwayX[j] + fairwayRadius[j];
                        }

                        if (fairwayX[j] - fairwayRadius[j] < arrXSize) {
                            arrXSize = fairwayX[j] - fairwayRadius[j];
                        }

                        if (fairwayY[j] + fairwayRadius[j] > ySize) {
                            ySize = fairwayY[j] + fairwayRadius[j];
                        }

                        if (fairwayY[j] - fairwayRadius[j] < arrYSize) {
                            arrYSize = fairwayY[j] - fairwayRadius[j];
                        }
                    }

                    for (int k = 0; k < greens; ++k) {
                        if (greenX[k] + greenRadius[k] > xSize) {
                            xSize = greenX[k] + greenRadius[k];
                        }

                        if (greenX[k] - greenRadius[k] < arrXSize) {
                            arrXSize = greenX[k] - greenRadius[k];
                        }

                        if (greenY[k] + greenRadius[k] > ySize) {
                            ySize = greenY[k] + greenRadius[k];
                        }

                        if (greenY[k] - greenRadius[k] < arrYSize) {
                            arrYSize = greenY[k] - greenRadius[k];
                        }
                    }

                    for (int l = 0; l < trees; ++l) {
                        if (treeX[l] + treeRadius[l] > xSize) {
                            xSize = treeX[l] + treeRadius[l];
                        }

                        if (treeX[l] - treeRadius[l] < arrXSize) {
                            arrXSize = treeX[l] - treeRadius[l];
                        }

                        if (treeY[l] + treeRadius[l] > ySize) {
                            ySize = treeY[l] + treeRadius[l];
                        }

                        if (treeY[l] - treeRadius[l] < arrYSize) {
                            arrYSize = treeY[l] - treeRadius[l];
                        }
                    }

                    int distXrad = 300 - (arrXSize + xSize) / 2;
                    int distYrad = 125 - (arrYSize + ySize) / 2 + 10;
                    teeX += distXrad;
                    teeY += distYrad;
                    ballX = teeX;
                    ballY = teeY;

                    for (int m = 1; m < 5; ++m) {
                        playerSandchk[m] = 0;
                        playerBallX[m] = teeX;
                        playerBallY[m] = teeY;
                        playerStrokes[m] = 0;
                    }

                    pinX += distXrad;
                    pinY += distYrad;
                    club = 13;
                    newClub = 1;
                    aimX = pinX;
                    aimY = pinY;

                    for (int n = 0; n < lakes; ++n) {
                        int[] lakeX1 = lakeX;
                        lakeX1[n] += distXrad;
                        lakeX1 = lakeY;
                        lakeX1[n] += distYrad;
                    }

                    for (int o = 0; o < roughs; ++o) {
                        int[] roughX1 = roughX;
                        roughX1[o] += distXrad;
                        roughX1 = roughY;
                        roughX1[o] += distYrad;
                    }

                    for (int p = 0; p < fairways; ++p) {
                        int[] fairwayX1 = fairwayX;
                        fairwayX1[p] += distXrad;
                        fairwayX1 = fairwayY;
                        fairwayX1[p] += distYrad;
                    }

                    for (int p = 0; p < sandtraps; ++p) {
                        int[] sandX1 = sandX;
                        sandX1[p] += distXrad;
                        sandX1 = sandY;
                        sandX1[p] += distYrad;
                    }

                    for (int q = 0; q < greens; ++q) {
                        int[] greenX1 = greenX;
                        greenX1[q] += distXrad;
                        greenX1 = greenY;
                        greenX1[q] += distYrad;
                    }

                    for (int r = 0; r < trees; ++r) {
                        int[] treeX1 = treeX;
                        treeX1[r] += distXrad;
                        treeX1 = treeY;
                        treeX1[r] += distYrad;
                    }

                    magSelected = 0;
                    holebuilt = 0;
                    time2read = 0;
                    lastBallIsOn = 99;
                    playerClock = 20;
                    aniClock = 0;
                    newSlope = 1;
                    newWind = 1;
                    newSlope = 1;
                    windDX = 0;

                    for (windDY = 0; windDX < 3 && windDX > -3; windDX = rand.nextInt(16) - 7) {
                    }

                    while (windDY < 3 && windDY > -3) {
                        windDY = rand.nextInt(16) - 7;
                    }

                    slopeDX = 0;

                    for (slopeDY = 0; slopeDX < 2 && slopeDX > -2;
                         slopeDX = rand.nextInt(16) - 7) {
                        // processing is on loop
                    }

                    while (slopeDY < 2 && slopeDY > -2) {
                        slopeDY = rand.nextInt(16) - 7;
                    }
                }
            }

            if (newPlayer == 1 && aniClock > 10) {
                if (inLake == 1) {
                    playerClock = 20;
                }

                this.nextplayer();
                newPlayer = 0;
            }

            if (button == 1) {
                onFairway = 0;

                for (int d = 0; d < fairways; ++d) {
                    int fairwayRad = fairwayRadius[d];
                    fairwayRad *= fairwayRad;
                    int ballOn = ballX - fairwayX[d];
                    ballOn *= ballOn;
                    if (fairwayRad >= ballOn) {
                        int ballDistY = (ballY - fairwayY[d]) * 2;
                        ballDistY *= ballDistY;
                        if (fairwayRad >= ballOn + ballDistY) {
                            onFairway = 1;
                            d = 999;
                        }
                    }
                }
            }

            if (button == 1) {
                inRough = 0;

                for (int f = 0; f < roughs; ++f) {
                    int roughRadius1 = roughRadius[f];
                    roughRadius1 *= roughRadius1;
                    int var68 = ballX - roughX[f];
                    var68 *= var68;
                    if (roughRadius1 >= var68) {
                        int var106 = (ballY - roughY[f]) * 2;
                        var106 *= var106;
                        if (roughRadius1 >= var68 + var106) {
                            inRough = 1;
                            f = 999;
                        }
                    }
                }
            }

            if (button == 1) {
                inSand = 0;

                for (int t = 0; t < sandtraps; ++t) {
                    int sandTrap = sandRadius[t];
                    sandTrap *= sandTrap;
                    int var70 = ballX - sandX[t];
                    var70 *= var70;
                    if (sandTrap >= var70) {
                        int var108 = (ballY - sandY[t]) * 2;
                        var108 *= var108;
                        if (sandTrap >= var70 + var108) {
                            inSand = 1;
                            t = 999;
                        }
                    }
                }
            }

            if (button == 1) {
                onGreen = 0;

                for (int s = 0; s < greens; ++s) {
                    int greanArea = greenRadius[s];
                    greanArea *= greanArea;
                    int var72 = ballX - greenX[s];
                    var72 *= var72;
                    if (greanArea >= var72) {
                        int var110 = (ballY - greenY[s]) * 2;
                        var110 *= var110;
                        if (greanArea >= var72 + var110) {
                            onGreen = 1;
                            s = 999;
                        }
                    }
                }
            }

            if (button == 1) {
                inLake = 0;

                for (int lk = 0; lk < lakes; ++lk) {
                    int lakeArea = lakeRadius[lk];
                    lakeArea *= lakeArea;
                    int lakeXpos = ballX - lakeX[lk];
                    lakeXpos *= lakeXpos;
                    if (lakeArea >= lakeXpos) {
                        int lakeYr = (ballY - lakeY[lk]) * 2;
                        lakeYr *= lakeYr;
                        if (lakeArea >= lakeXpos + lakeYr) {
                            inLake = 1;
                            lk = 999;
                        }
                    }
                }
            }

            if (ballInFlight == 1 && bounced == 0 && onGreen == 0) {
                ballIsOn = 7;
                picked = 1;
                inSand = 0;
            }

            if (picked == 0) {
                if (ballX == teeX && ballY == teeY) {
                    picked = 1;
                    ballIsOn = 0;
                }

                if (player1Par[hole] > 0 && player == 1) {
                    picked = 1;
                    ballIsOn = 8;
                }

                if (player2Par[hole] > 0 && player == 2) {
                    picked = 1;
                    ballIsOn = 8;
                }

                if (player3Par[hole] > 0 && player == 3) {
                    picked = 1;
                    ballIsOn = 8;
                }

                if (player4Par[hole] > 0 && player == 4) {
                    picked = 1;
                    ballIsOn = 8;
                }

                if (onGreen == 0 && magSelected == 1 && newPlayer == 0 && ballX != 999 && ballY != 999) {
                    magSelected = 0;
                    holebuilt = 0;
                }

                if (onGreen == 1 && picked == 0) {
                    if (ballInFlight == 0) {
                        club = 12;
                        newClub = 1;
                    }

                    picked = 1;
                    ballIsOn = 4;
                    if (newPlayer == 0 && magSelected == 0 && ballInFlight == 0) {
                        magSelected = 1;
                        holebuilt = 0;
                    }
                }

                if (inLake == 1 && picked == 0 && onGreen == 0) {
                    picked = 1;
                    ballIsOn = 2;
                }

                if (inSand == 1 && picked == 0 && inLake == 0 && onGreen == 0) {
                    picked = 1;
                    ballIsOn = 1;
                }

                if (onFairway == 1 && inSand == 0 && onGreen == 0 && picked == 0 && inLake == 0) {
                    ballIsOn = 3;
                    picked = 1;
                }

                if (inRough == 1 && onFairway == 0 && inSand == 0 && onGreen == 0 && picked == 0 && inLake == 0) {
                    ballIsOn = 5;
                    picked = 1;
                }

                if (picked == 0) {
                    ballIsOn = 6;
                    picked = 1;
                }
            }

            if (infoBox == 1) {
                g.setColor(info1);
                g.fillRect(infoX - 20, infoY - 25, 350, 50);
                g.setColor(Color.white);
                g.drawRect(250, 250, 349, 49);
                g.setColor(Color.lightGray);
                g.drawRect(251, 251, 347, 47);
                g.setColor(Color.gray);
                g.drawRect(252, 252, 345, 45);
                if (newCard == 1) {
                    if (gameOver == 0) {
                        g.setColor(new Color(0, 180, 0));
                        g.fillRect(260, 255, 90, 39);
                        g.setColor(Color.white);
                        g.drawRect(260, 255, 90, 39);
                        g.setColor(Color.lightGray);
                        g.drawRect(261, 256, 88, 37);
                        g.setColor(Color.gray);
                        g.drawRect(262, 257, 86, 35);
                        g.setColor(Color.black);
                        g.drawString("NEXT TEE", 271, 279);
                        g.setColor(Color.white);
                        g.drawString("NEXT TEE", 270, 278);
                    }

                    if (gameOver == 1) {
                        g.setColor(new Color(0, 180, 0));
                        g.fillRect(260, 255, 120, 39);
                        g.setColor(Color.white);
                        g.drawRect(260, 255, 120, 39);
                        g.setColor(Color.lightGray);
                        g.drawRect(261, 256, 118, 37);
                        g.setColor(Color.gray);
                        g.drawRect(262, 257, 116, 35);
                        g.setColor(Color.black);
                        g.drawString("REPORT SCORE", 271, 279);
                        g.setColor(Color.white);
                        g.drawString("REPORT SCORE", 270, 278);
                    }

                    g.setColor(new Color(180, 0, 0));
                    g.fillRect(500, 255, 90, 39);
                    g.setColor(Color.white);
                    g.drawRect(500, 255, 90, 39);
                    g.setColor(Color.lightGray);
                    g.drawRect(501, 256, 88, 37);
                    g.setColor(Color.gray);
                    g.drawRect(502, 257, 86, 35);
                    g.setColor(Color.black);
                    g.drawString("NEW GAME", 511, 279);
                    g.setColor(Color.white);
                    g.drawString("NEW GAME", 510, 278);
                } else {
                    for (int var29 = 0; var29 < playerStrokes[player]; ++var29) {
                        g.setColor(Color.gray);
                        g.fillOval(var29 * 10 + infoX + 8 - 3, infoY + 14 - 2, 7, 7);
                        g.setColor(Color.lightGray);
                        g.fillOval(var29 * 10 + infoX + 8 - 2, infoY + 14 - 2, 6, 6);
                        g.setColor(Color.white);
                        g.fillOval(var29 * 10 + infoX + 8 - 1, infoY + 14 - 2, 5, 5);
                    }

                    g.setColor(Color.black);
                    switch (hole + holebase) {
                        case 1:
                            g.drawString((holebase + hole) + "st Hole - Par " + holePars[hole + holebase] +
                                    " - " + holeYards[hole + holebase] + "yd", infoX + 5, infoY - 11);
                            g.setColor(Color.white);
                            g.drawString((holebase + hole) + "st Hole - Par " + holePars[hole + holebase] +
                                    " - " + holeYards[hole + holebase] + "yd", infoX + 5, infoY - 10);
                            break;
                        case 2:
                            g.drawString((holebase + hole) + "nd Hole - Par " + holePars[hole + holebase] +
                                    " - " + holeYards[hole + holebase] + "yd", infoX + 5, infoY - 11);
                            g.setColor(Color.white);
                            g.drawString((holebase + hole) + "nd Hole - Par " + holePars[hole + holebase] +
                                    " - " + holeYards[hole + holebase] + "yd", infoX + 5, infoY - 10);
                            break;
                        case 3:
                            g.drawString((holebase + hole) + "rd Hole - Par " + holePars[hole + holebase] +
                                    " - " + holeYards[hole + holebase] + "yd", infoX + 5, infoY - 11);
                            g.setColor(Color.white);
                            g.drawString((holebase + hole) + "rd Hole - Par " + holePars[hole + holebase] +
                                    " - " + holeYards[hole + holebase] + "yd", infoX + 5, infoY - 10);
                            break;
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
                        case 18:
                            g.drawString((holebase + hole) + "th Hole - Par " + holePars[hole + holebase] +
                                    " - " + holeYards[hole + holebase] + "yd", infoX + 5, infoY - 11);
                            g.setColor(Color.white);
                            g.drawString((holebase + hole) + "th Hole - Par " + holePars[hole + holebase] +
                                    " - " + holeYards[hole + holebase] + "yd", infoX + 5, infoY - 10);
                    }

                    String pName = "";
                    g.setColor(Color.black);
                    switch (player) {
                        case 1:
                            pName = p1name;
                            break;
                        case 2:
                            pName = p2name;
                            break;
                        case 3:
                            pName = p3name;
                            break;
                        case 4:
                            pName = p4name;
                    }

                    g.setColor(Color.black);
                    switch (ballIsOn) {
                        case 0:
                            g.drawString(pName + "'s at the Tee", infoX + 5, infoY + 6 - 1);
                            g.setColor(Color.white);
                            g.drawString(pName + "'s at the Tee", infoX + 5, infoY + 6);
                            break;
                        case 1:
                            g.drawString(pName + "'s in the Sand", infoX + 5, infoY + 6 - 1);
                            g.setColor(Color.white);
                            g.drawString(pName + "'s in the Sand", infoX + 5, infoY + 6);
                            break;
                        case 2:
                            g.drawString(pName + "'s in the Water", infoX + 5, infoY + 6 - 1);
                            g.setColor(Color.white);
                            g.drawString(pName + "'s in the Water", infoX + 5, infoY + 6);
                            break;
                        case 3:
                            g.drawString(pName + "'s on the Fairway", infoX + 5, infoY + 6 - 1);
                            g.setColor(Color.white);
                            g.drawString(pName + "'s on the Fairway", infoX + 5, infoY + 6);
                            break;
                        case 4:
                            g.drawString(pName + "'s on the Green", infoX + 5, infoY + 6 - 1);
                            g.setColor(Color.white);
                            g.drawString(pName + "'s on the Green", infoX + 5, infoY + 6);
                            break;
                        case 5:
                            g.drawString(pName + "'s in light Rough", infoX + 5, infoY + 6 - 1);
                            g.setColor(Color.white);
                            g.drawString(pName + "'s in light Rough", infoX + 5, infoY + 6);
                            break;
                        case 6:
                            g.drawString(pName + "'s in heavy Rough", infoX + 5, infoY + 6 - 1);
                            g.setColor(Color.white);
                            g.drawString(pName + "'s in heavy Rough", infoX + 5, infoY + 6);
                            break;
                        case 7:
                            g.drawString(pName + "'s in the Air", infoX + 5, infoY + 6 - 1);
                            g.setColor(Color.white);
                            g.drawString(pName + "'s in the Air", infoX + 5, infoY + 6);
                            break;
                        case 8:
                            g.drawString(pName + "'s in the HOLE", infoX + 5, infoY + 6 - 1);
                            g.setColor(Color.white);
                            g.drawString(pName + "'s in the HOLE", infoX + 5, infoY + 6);
                    }
                }

                infoBox = 0;
            }

            if (newCard == 1) {
                if (newCardRefresh == 1) {
                    newCardRefresh = 0;
                    if (round > 0) {
                        this.readtourdata();
                    }

                    g.setColor(info1);
                    g.fillRect(8, 38, 585, 190);
                    g.setColor(Color.white);
                    g.drawRect(5, 35, 590, 194);
                    g.setColor(Color.lightGray);
                    g.drawRect(6, 36, 588, 192);
                    g.setColor(Color.gray);
                    g.drawRect(7, 37, 586, 190);
                    g.setColor(Color.white);
                    g.drawRect(5, 50, 590, 132);
                    g.setColor(Color.lightGray);
                    g.drawRect(6, 51, 588, 130);
                    g.setColor(Color.gray);
                    g.drawRect(7, 52, 586, 128);
                    g.setColor(new Color(0, 0, 180));
                    g.fillRect(8, 53, 585, 44);
                    g.setColor(Color.black);
                    g.drawString("Yards", 41, 65);
                    g.setColor(Color.white);
                    g.drawString("Yards", 40, 64);
                    frontYards = 0;

                    for (int var41 = 1; var41 < 10; ++var41) {
                        int var64 = holeYards[var41 + holebase];
                        frontYards += var64;
                        if (var64 > 0) {
                            g.setColor(Color.black);
                            g.drawString("" + var64, 63 + var41 * 29, 65);
                            g.setColor(Color.white);
                            g.drawString("" + var64, 62 + var41 * 29, 64);
                        }
                    }

                    g.setColor(Color.black);
                    g.drawString("" + frontYards, 353, 65);
                    g.setColor(Color.white);
                    g.drawString("" + frontYards, 352, 64);
                    g.setColor(Color.blue);
                    g.fillRect(8, 8, 175, 17);
                    g.setColor(Color.white);
                    g.drawRect(5, 5, 180, 22);
                    g.setColor(Color.lightGray);
                    g.drawRect(6, 6, 178, 20);
                    g.setColor(Color.gray);
                    g.drawRect(7, 7, 176, 18);
                    g.setColor(Color.black);
                    g.drawString("VIEW LEADER BOARD", 26, 22);
                    g.setColor(Color.white);
                    g.drawString("VIEW LEADER BOARD", 25, 21);
                    g.setColor(Color.black);
                    g.drawString("PAR", 46, 80);
                    g.setColor(Color.white);
                    g.drawString("PAR", 45, 79);
                    frontPar = 0;

                    for (int var65 = 1; var65 < 10; ++var65) {
                        int var101 = holePars[var65 + holebase];
                        frontPar += var101;
                        if (var101 > 0) {
                            g.setColor(Color.black);
                            g.drawString("" + var101, 63 + var65 * 29 + 7, 80);
                            g.setColor(Color.white);
                            g.drawString("" + var101, 62 + var65 * 29 + 7, 79);
                        }
                    }

                    g.setColor(Color.black);
                    g.drawString("" + frontPar, 360, 80);
                    g.setColor(Color.white);
                    g.drawString("" + frontPar, 359, 79);
                    g.setColor(Color.white);

                    for (int var102 = 30; var102 < 124; ++var102) {
                        g.fillRect(8, 53 + var102, 585, 1);
                    }

                    for (int var142 = 22; var142 < 35; ++var142) {
                        g.setColor(green2);
                        g.fillRect(8, 53 + var142 + 92, 585, 1);
                    }

                    g.setColor(new Color(255, 220, 220));
                    g.fillRect(8, 84, 585, 19);
                    g.fillRect(8, 105, 585, 19);
                    g.fillRect(8, 126, 585, 19);
                    g.fillRect(8, 147, 585, 19);
                    g.setColor(Color.lightGray);

                    for (int var166 = 1; var166 < 11; ++var166) {
                        g.drawRect(60 + var166 * 29 - 2, 64, 1, 114);
                    }

                    int var187 = 0;

                    for (int var198 = 1; var198 < hole; ++var198) {
                        var187 += holePars[var198 + holebase];
                    }

                    int var216 = 0;
                    if (numOfPlayers > 0) {
                        g.setColor(Color.black);
                        g.drawString(p1name, 10, 98);
                        var216 = 0;

                        for (int var231 = 1; var231 < 10; ++var231) {
                            int var240 = player1Par[var231];
                            var216 += var240;
                            if (var240 > 0) {
                                g.setColor(Color.black);
                                g.drawString("" + var240, 62 + var231 * 29 + 7, 98);
                                g.setColor(Color.red);
                                if (var240 <= holePars[var231 + holebase] - 1) {
                                    g.drawOval(60 + var231 * 29 + 4, 86, 18, 14);
                                }

                                if (var240 <= holePars[var231 + holebase] - 2) {
                                    g.drawOval(60 + var231 * 29 + 4 - 2, 84, 22, 18);
                                }

                                g.setColor(Color.blue);
                                if (var240 >= holePars[var231 + holebase] + 1) {
                                    g.drawRect(60 + var231 * 29 + 4, 86, 18, 14);
                                }

                                if (var240 >= holePars[var231 + holebase] + 2) {
                                    g.drawRect(60 + var231 * 29 + 4 - 2, 84, 22, 18);
                                }
                            }
                        }

                        g.setColor(Color.black);
                        if (var216 == var187) {
                            g.drawString(var216 + " (Even)", 359, 98);
                        }

                        if (var216 > var187) {
                            g.drawString(var216 + " (+" + (var216 - var187) + " over)", 359, 98);
                        }

                        if (var216 < var187) {
                            g.setColor(Color.red);
                            g.drawString(var216 + " (" + (var216 - var187) + " under)", 359, 98);
                            g.setColor(Color.black);
                            g.drawString("" + var216, 359, 98);
                        }

                        honor[1] = var216;
                        if (gameOver == 1) {
                            player1Total = var216;
                        }
                    }

                    if (numOfPlayers > 1) {
                        g.setColor(Color.black);
                        g.drawString(p2name, 10, 119);
                        var216 = 0;

                        for (int var232 = 1; var232 < 10; ++var232) {
                            int var241 = player2Par[var232];
                            var216 += var241;
                            if (var241 > 0) {
                                g.setColor(Color.black);
                                g.drawString("" + var241, 62 + var232 * 29 + 7, 119);
                                g.setColor(Color.red);
                                if (var241 <= holePars[var232 + holebase] - 1) {
                                    g.drawOval(60 + var232 * 29 + 4, 107, 18, 14);
                                }

                                if (var241 <= holePars[var232 + holebase] - 2) {
                                    g.drawOval(60 + var232 * 29 + 4 - 2, 105, 22, 18);
                                }

                                g.setColor(Color.blue);
                                if (var241 >= holePars[var232 + holebase] + 1) {
                                    g.drawRect(60 + var232 * 29 + 4, 107, 18, 14);
                                }

                                if (var241 >= holePars[var232 + holebase] + 2) {
                                    g.drawRect(60 + var232 * 29 + 4 - 2, 105, 22, 18);
                                }
                            }
                        }

                        g.setColor(Color.black);
                        if (var216 == var187) {
                            g.drawString(var216 + " (Even)", 359, 119);
                        }

                        if (var216 > var187) {
                            g.drawString(var216 + " (+" + (var216 - var187) + " over)", 359, 119);
                        }

                        if (var216 < var187) {
                            g.setColor(Color.red);
                            g.drawString(var216 + " (" + (var216 - var187) + " under)", 359, 119);
                            g.setColor(Color.black);
                            g.drawString("" + var216, 359, 119);
                        }

                        honor[2] = var216;
                        if (gameOver == 1) {
                            player2Total = var216;
                        }
                    }

                    if (numOfPlayers > 2) {
                        g.setColor(Color.black);
                        g.drawString(p3name, 10, 140);
                        var216 = 0;

                        for (int var233 = 1; var233 < 10; ++var233) {
                            int var242 = player3Par[var233];
                            var216 += var242;
                            if (var242 > 0) {
                                g.setColor(Color.black);
                                g.drawString("" + var242, 62 + var233 * 29 + 7, 140);
                                g.setColor(Color.red);
                                if (var242 <= holePars[var233 + holebase] - 1) {
                                    g.drawOval(60 + var233 * 29 + 4, 128, 18, 14);
                                }

                                if (var242 <= holePars[var233 + holebase] - 2) {
                                    g.drawOval(60 + var233 * 29 + 4 - 2, 126, 22, 18);
                                }

                                g.setColor(Color.blue);
                                if (var242 >= holePars[var233 + holebase] + 1) {
                                    g.drawRect(60 + var233 * 29 + 4, 128, 18, 14);
                                }

                                if (var242 >= holePars[var233 + holebase] + 2) {
                                    g.drawRect(60 + var233 * 29 + 4 - 2, 126, 22, 18);
                                }
                            }
                        }

                        g.setColor(Color.black);
                        if (var216 == var187) {
                            g.drawString(var216 + " (Even)", 359, 140);
                        }

                        if (var216 > var187) {
                            g.drawString(var216 + " (+" + (var216 - var187) + " over)", 359, 140);
                        }

                        if (var216 < var187) {
                            g.setColor(Color.red);
                            g.drawString(var216 + " (" + (var216 - var187) + " under)", 359, 140);
                            g.setColor(Color.black);
                            g.drawString("" + var216, 359, 140);
                        }

                        honor[3] = var216;
                        if (gameOver == 1) {
                            player3Total = var216;
                        }
                    }

                    if (numOfPlayers > 3) {
                        g.setColor(Color.black);
                        g.drawString(p4name, 10, 161);
                        var216 = 0;

                        for (int var234 = 1; var234 < 10; ++var234) {
                            int var243 = player4Par[var234];
                            var216 += var243;
                            if (var243 > 0) {
                                g.setColor(Color.black);
                                g.drawString("" + var243, 62 + var234 * 29 + 7, 161);
                                g.setColor(Color.red);
                                if (var243 <= holePars[var234 + holebase] - 1) {
                                    g.drawOval(60 + var234 * 29 + 4, 149, 18, 14);
                                }

                                if (var243 <= holePars[var234 + holebase] - 2) {
                                    g.drawOval(60 + var234 * 29 + 4 - 2, 147, 22, 18);
                                }

                                g.setColor(Color.blue);
                                if (var243 >= holePars[var234 + holebase] + 1) {
                                    g.drawRect(60 + var234 * 29 + 4, 149, 14, 14);
                                }

                                if (var243 >= holePars[var234 + holebase] + 2) {
                                    g.drawRect(60 + var234 * 29 + 4 - 2, 147, 22, 18);
                                }
                            }
                        }

                        g.setColor(Color.black);
                        if (var216 == var187) {
                            g.drawString(var216 + " (Even)", 359, 161);
                        }

                        if (var216 > var187) {
                            g.drawString(var216 + " (+" + (var216 - var187) + " over)", 359, 161);
                        }

                        if (var216 < var187) {
                            g.setColor(Color.red);
                            g.drawString(var216 + " (" + (var216 - var187) + " under)", 359, 161);
                            g.setColor(Color.black);
                            g.drawString("" + var216, 359, 161);
                        }

                        honor[4] = var216;
                        if (gameOver == 1) {
                            player4Total = var216;
                        }
                    }

                    g.setColor(Color.black);
                    g.drawString("Hole", 41, 180);
                    g.setColor(Color.white);
                    g.drawString("Hole", 40, 179);

                    for (int var235 = 1; var235 < 10; ++var235) {
                        g.setColor(Color.black);
                        g.drawString("" + (holebase + var235), 63 + var235 * 29 + 7, 180);
                        g.setColor(Color.white);
                        g.drawString("" + (holebase + var235), 62 + var235 * 29 + 7, 179);
                    }

                    if (holebase == 0) {
                        g.setColor(Color.black);
                        g.drawString("FRONT 9 Total", 360, 180);
                        g.setColor(Color.white);
                        g.drawString("FRONT 9 Total", 359, 179);
                    }

                    if (holebase == 9) {
                        g.setColor(Color.black);
                        g.drawString("BACK 9 Total", 360, 180);
                        g.setColor(Color.white);
                        g.drawString("BACK 9 Total", 359, 179);
                    }
                }

            } else if (leaderBoard == 1) {
                if (leaderRefresh == 1) {
                    if (gameOver == 1 && reportIn == 1) {
                        this.writetourdata();
                        reportIn = 0;
                    } else {
                        this.readtourdata();
                    }

                    leaderRefresh = 0;
                    bigRefresh2 = 0;
                    g.setColor(Color.blue);
                    g.fillRect(8, 8, 175, 17);
                    g.setColor(Color.white);
                    g.drawRect(5, 5, 180, 22);
                    g.setColor(Color.lightGray);
                    g.drawRect(6, 6, 178, 20);
                    g.setColor(Color.gray);
                    g.drawRect(7, 7, 176, 18);
                    g.setColor(Color.black);
                    g.drawString("VIEW SCORECARD", 26, 22);
                    g.setColor(Color.white);
                    g.drawString("VIEW SCORECARD", 25, 21);
                    g.setColor(info1);
                    g.fillRect(8, 38, 585, 190);
                    g.setColor(Color.black);
                    g.drawString("CURRENT SabGOLF LEADER BOARD", 29, 57);
                    g.setColor(Color.white);
                    g.drawString("CURRENT SabGOLF LEADER BOARD", 28, 56);
                    g.setColor(sand4);

                    for (int var40 = 0; var40 < 10; ++var40) {
                        g.fillRect(12, 80 + var40 * 14 - 10, 577, 13);
                    }

                    g.setColor(info1);
                    g.fillRect(10, 66, 3, 150);
                    g.fillRect(210, 66, 3, 150);
                    g.fillRect(410, 66, 3, 150);
                    g.fillRect(587, 66, 3, 150);
                    g.setColor(Color.white);
                    g.drawRect(5, 35, 590, 194);
                    g.setColor(Color.lightGray);
                    g.drawRect(6, 36, 588, 192);
                    g.setColor(Color.gray);
                    g.drawRect(7, 37, 586, 190);
                    String var63 = "";
                    if (!tourdata.isEmpty()) {
                        StringTokenizer var100 = new StringTokenizer(tourdata, "+");

                        for (int var141 = 0; var141 < 3; ++var141) {
                            for (int var165 = 0; var165 < 10; ++var165) {
                                if (var100.hasMoreTokens()) {
                                    var63 = var100.nextToken();
                                }

                                if (var141 * 10 + var165 + 1 > 1) {
                                    var63 = var63.substring(1, var63.length());
                                }

                                int var186 = Integer.parseInt(var63);
                                int var197 = var186 - 36;
                                if (var100.hasMoreTokens()) {
                                    var63 = var100.nextToken();
                                }

                                if (var197 == 0) {
                                    g.setColor(Color.black);
                                    g.drawString(var186 + " (E)", var141 * 200 + 20, 80 + var165 * 14);
                                }

                                if (var197 > 0) {
                                    g.setColor(Color.black);
                                    g.drawString(var186 + " (+" + var197 + ")", var141 * 200 + 20, 80 + var165 * 14);
                                }

                                if (var197 < 0) {
                                    g.setColor(Color.red);
                                    g.drawString(var186 + " (" + var197 + ")", var141 * 200 + 20, 80 + var165 * 14);
                                    g.setColor(Color.black);
                                    g.drawString("" + var186, var141 * 200 + 20, 80 + var165 * 14);
                                }

                                g.setColor(Color.black);
                                g.drawString(var63, var141 * 200 + 76, 80 + var165 * 14);
                            }
                        }
                    }
                }

            } else if (keyFace == 1) {
                if (keyRefresh == 1) {
                    keyRefresh = 0;
                    ++keyClock;
                    if (keyBack == 1) {
                        keyBack = 0;
                        Graphics goldGraphics = gold.getGraphics();
                        goldGraphics.setColor(new Color(26, 156, 26));
                        goldGraphics.fillRect(0, 0, 600, 300);
                        Color var61 = info1;
                        int var91 = 172;
                        --var91;
                        var91 -= 2;

                        for (int var139 = -11; var139 < 12; ++var139) {
                            goldGraphics.setColor(var61);
                            goldGraphics.drawLine(var91 + 50 + 12 - 3, 263, var91 + 50 + 12 + var139 - 3, 241);
                        }

                        int var162 = var91 + 50 + 13 - 3;
                        short var183 = 228;
                        int var195 = 0;

                        for (int var215 = 14; var215 > 0; --var215) {
                            goldGraphics.setColor(new Color(255 - var215 * 3, 255 - 3 * var215, 255 - 3 * var215));
                            goldGraphics.fillOval(var162 - var215 - var195 / 4, var183 - var215 + var195 * 2 / 3, var215 * 2, var215 * 2);
                            --var195;
                        }

                        goldGraphics.setColor(Color.black);
                        goldGraphics.drawString("SAB", var91 + 47, 232);
                        int var230 = (600 - goldGraphics.getFontMetrics().stringWidth("SabGOLF v1.3 (c)19971105 Steve A. Baker, All Rights Reserved")) / 2;
                        goldGraphics.drawString("SabGOLF v1.3 (c)19971105 Steve A. Baker, All Rights Reserved", var230, 280);
                        var91 -= 2;
                        --var91;
                        goldGraphics.setColor(var61);
                        goldGraphics.fillOval(var91 + 100 - 5, 217, 35, 47);
                        goldGraphics.setColor(new Color(26, 156, 26));
                        goldGraphics.fillOval(var91 + 100 + 8 - 5, 225, 19, 31);
                        goldGraphics.fillRect(var91 + 100 + 15 - 5 - 10 + 12, 235, 18, 4);
                        goldGraphics.setColor(var61);
                        goldGraphics.fillRect(var91 + 100 + 15 - 5 - 10 + 12, 239, 18, 8);
                        var91 -= 13;
                        var162 = var91 + 150 + 18;
                        var183 = 240;
                        var195 = 0;
                        goldGraphics.setColor(var61);
                        goldGraphics.fillOval(var162 - 23, var183 - 23, 47, 47);

                        for (int var239 = 15; var239 > 14; --var239) {
                            goldGraphics.setColor(rough1);
                            goldGraphics.fillOval(var162 - var239 - var195 / 4, var183 - var239 + var195 * 2 / 3, var239 * 2 + 1, var239 * 2 + 1);
                        }

                        goldGraphics.setColor(Color.black);
                        goldGraphics.fillRect(var162 - 1, var183 - 1, 3, 2);
                        goldGraphics.setColor(Color.white);
                        goldGraphics.fillRect(var162, var183 - 10, 1, 10);
                        goldGraphics.setColor(Color.orange);
                        goldGraphics.fillRect(var162 + 1, var183 - 10, 3, 3);
                        var91 -= 2;
                        goldGraphics.setColor(var61);
                        goldGraphics.fillOval(var91 + 200 - 4, 241, 23, 23);
                        goldGraphics.setColor(new Color(26, 156, 26));
                        goldGraphics.fillOval(var91 + 200 - 4 + 8, 249, 7, 7);
                        goldGraphics.fillRect(var91 + 200 - 4 + 8, 216, 15, 37);
                        goldGraphics.setColor(var61);
                        goldGraphics.fillRect(var91 + 200 - 4, 216, 8, 37);
                        var91 += 10;
                        goldGraphics.setColor(var61);
                        goldGraphics.fillOval(var91 + 215 - 4, 216, 23, 23);
                        goldGraphics.setColor(new Color(26, 156, 26));
                        goldGraphics.fillOval(var91 + 215 - 4 + 8, 224, 7, 7);
                        goldGraphics.fillRect(var91 + 215 - 4 + 8, 230, 15, 37);
                        goldGraphics.setColor(var61);
                        goldGraphics.fillRect(var91 + 215 - 4, 228, 8, 35);
                        goldGraphics.fillRect(var91 + 215 - 4 + 8, 232, 15, 8);
                        goldGraphics.dispose();
                    }

                    Graphics var39 = gold.getGraphics();
                    var39.setColor(Color.white);
                    var39.drawRect(5, 5, 590, 194);
                    var39.setColor(Color.lightGray);
                    var39.drawRect(6, 6, 588, 192);
                    var39.setColor(Color.gray);
                    var39.drawRect(7, 7, 586, 190);

                    for (int var62 = 0; var62 < 180; ++var62) {
                        var39.setColor(new Color(0, 0, 160 + var62 / 2));
                        var39.fillRect(8, 8 + var62, 585, 1);
                    }

                    for (int var99 = 0; var99 < 29; ++var99) {
                        var39.setColor(new Color(0, 80 + (var99 + 20) * 2, 0));
                        var39.fillRect(8, 168 + var99, 585, 1);
                    }

                    var39.setColor(Color.white);
                    var39.drawString("Who will be playing today?  (1 to 4 players)", 28, 26);
                    switch (player) {
                        case 1:
                            p1name = tname;
                            break;
                        case 2:
                            p2name = tname;
                            break;
                        case 3:
                            p3name = tname;
                            break;
                        case 4:
                            p4name = tname;
                    }

                    for (int var140 = 0; var140 < 20; ++var140) {
                        var39.setColor(new Color(0, 0, 160 + var140 / 2));
                        var39.fillRect(490, 175 + var140, 100, 1);
                        var39.fillRect(360, 175 + var140, 100, 1);
                    }

                    var39.setColor(Color.blue);
                    if (p1name.length() > 1 && p2name.length() != 1 && p3name.length() != 1 && p4name.length() != 1) {
                        var39.setColor(Color.white);
                    }

                    var39.drawString("Play Front-9", 370, 190);
                    var39.drawString("Play Back-9", 500, 190);
                    var39.setColor(Color.white);
                    var39.drawRect(490, 175, 100, 20);
                    var39.setColor(Color.lightGray);
                    var39.drawRect(491, 176, 98, 18);
                    var39.setColor(Color.gray);
                    var39.drawRect(492, 177, 96, 16);
                    var39.setColor(Color.white);
                    var39.drawRect(360, 175, 100, 20);
                    var39.setColor(Color.lightGray);
                    var39.drawRect(361, 176, 98, 18);
                    var39.setColor(Color.gray);
                    var39.drawRect(362, 177, 96, 16);
                    var39.setColor(Color.white);
                    var39.drawString("Welcome to the Brookdale Country Club", 20, 190);
                    var39.setColor(Color.white);

                    for (int var164 = 1; var164 < 10; ++var164) {
                        var39.fillRect(var164 + 550, 50 - var164, 1, var164 * 2);
                    }

                    var39.fillRect(560, 48, 10, 5);
                    var39.setColor(Color.black);
                    var39.setColor(new Color(255, 220, 220));
                    if (player == 1) {
                        var39.setColor(new Color(255, 160, 160));
                    }

                    var39.fillRect(8, 84, 585, 19);
                    var39.setColor(new Color(255, 220, 220));
                    if (player == 2) {
                        var39.setColor(new Color(255, 160, 160));
                    }

                    var39.fillRect(8, 105, 585, 19);
                    var39.setColor(new Color(255, 220, 220));
                    if (player == 3) {
                        var39.setColor(new Color(255, 160, 160));
                    }

                    var39.fillRect(8, 126, 585, 19);
                    var39.setColor(new Color(255, 220, 220));
                    if (player == 4) {
                        var39.setColor(new Color(255, 160, 160));
                    }

                    var39.fillRect(8, 147, 585, 19);
                    var39.setColor(Color.black);
                    if (player == 1) {
                        var39.drawString(p1name + "_", 53, 96);
                    } else {
                        var39.drawString(p1name, 53, 96);
                    }

                    if (player == 2) {
                        var39.drawString(p2name + "_", 53, 117);
                    } else {
                        var39.drawString(p2name, 53, 117);
                    }

                    if (player == 3) {
                        var39.drawString(p3name + "_", 53, 138);
                    } else {
                        var39.drawString(p3name, 53, 138);
                    }

                    if (player == 4) {
                        var39.drawString(p4name + "_", 53, 159);
                    } else {
                        var39.drawString(p4name, 53, 159);
                    }

                    for (int var185 = 1; var185 < 27; ++var185) {
                        var39.setColor(Color.white);
                        switch (var185) {
                            case 1:
                                var39.drawString("A", var185 * 20 + 8, 66);
                                var39.drawString("a", var185 * 20 + 8, 46);
                                break;
                            case 2:
                                var39.drawString("B", var185 * 20 + 8, 66);
                                var39.drawString("b", var185 * 20 + 8, 46);
                                break;
                            case 3:
                                var39.drawString("C", var185 * 20 + 8, 66);
                                var39.drawString("c", var185 * 20 + 8, 46);
                                break;
                            case 4:
                                var39.drawString("D", var185 * 20 + 8, 66);
                                var39.drawString("d", var185 * 20 + 8, 46);
                                break;
                            case 5:
                                var39.drawString("E", var185 * 20 + 8, 66);
                                var39.drawString("e", var185 * 20 + 8, 46);
                                break;
                            case 6:
                                var39.drawString("F", var185 * 20 + 8, 66);
                                var39.drawString("f", var185 * 20 + 8, 46);
                                break;
                            case 7:
                                var39.drawString("G", var185 * 20 + 8, 66);
                                var39.drawString("g", var185 * 20 + 8, 46);
                                break;
                            case 8:
                                var39.drawString("H", var185 * 20 + 8, 66);
                                var39.drawString("h", var185 * 20 + 8, 46);
                                break;
                            case 9:
                                var39.drawString("I", var185 * 20 + 8, 66);
                                var39.drawString("i", var185 * 20 + 8, 46);
                                break;
                            case 10:
                                var39.drawString("J", var185 * 20 + 8, 66);
                                var39.drawString("j", var185 * 20 + 8, 46);
                                break;
                            case 11:
                                var39.drawString("K", var185 * 20 + 8, 66);
                                var39.drawString("k", var185 * 20 + 8, 46);
                                break;
                            case 12:
                                var39.drawString("L", var185 * 20 + 8, 66);
                                var39.drawString("l", var185 * 20 + 8, 46);
                                break;
                            case 13:
                                var39.drawString("M", var185 * 20 + 8, 66);
                                var39.drawString("m", var185 * 20 + 8, 46);
                                break;
                            case 14:
                                var39.drawString("N", var185 * 20 + 8, 66);
                                var39.drawString("n", var185 * 20 + 8, 46);
                                break;
                            case 15:
                                var39.drawString("O", var185 * 20 + 8, 66);
                                var39.drawString("o", var185 * 20 + 8, 46);
                                break;
                            case 16:
                                var39.drawString("P", var185 * 20 + 8, 66);
                                var39.drawString("p", var185 * 20 + 8, 46);
                                break;
                            case 17:
                                var39.drawString("Q", var185 * 20 + 8, 66);
                                var39.drawString("q", var185 * 20 + 8, 46);
                                break;
                            case 18:
                                var39.drawString("R", var185 * 20 + 8, 66);
                                var39.drawString("r", var185 * 20 + 8, 46);
                                break;
                            case 19:
                                var39.drawString("S", var185 * 20 + 8, 66);
                                var39.drawString("s", var185 * 20 + 8, 46);
                                break;
                            case 20:
                                var39.drawString("T", var185 * 20 + 8, 66);
                                var39.drawString("t", var185 * 20 + 8, 46);
                                break;
                            case 21:
                                var39.drawString("U", var185 * 20 + 8, 66);
                                var39.drawString("u", var185 * 20 + 8, 46);
                                break;
                            case 22:
                                var39.drawString("V", var185 * 20 + 8, 66);
                                var39.drawString("v", var185 * 20 + 8, 46);
                                break;
                            case 23:
                                var39.drawString("W", var185 * 20 + 8, 66);
                                var39.drawString("w", var185 * 20 + 8, 46);
                                break;
                            case 24:
                                var39.drawString("X", var185 * 20 + 8, 66);
                                var39.drawString("x", var185 * 20 + 8, 46);
                                break;
                            case 25:
                                var39.drawString("Y", var185 * 20 + 8, 66);
                                var39.drawString("y", var185 * 20 + 8, 46);
                                break;
                            case 26:
                                var39.drawString("Z", var185 * 20 + 8, 66);
                                var39.drawString("z", var185 * 20 + 8, 46);
                        }
                    }

                    g.drawImage(gold, 0, 0, null);
                    var39.dispose();
                }

            } else {
                if (newSlope == 1) {
                    Graphics var30 = greenslope.getGraphics();
                    newSlope = 0;
                    var30.setColor(Color.white);
                    var30.drawRect(0, 0, 50, 49);
                    var30.setColor(Color.lightGray);
                    var30.drawRect(1, 1, 48, 47);
                    var30.setColor(Color.gray);
                    var30.drawRect(2, 2, 46, 45);
                    var30.setColor(new Color(40, 140, 60));
                    var30.fillRect(3, 3, 45, 44);
                    int var53 = slopeDX * 10;

                    int var76;
                    for (var76 = slopeDY * 10; var53 * var53 + var76 * var76 > 441; var76 /= 2) {
                        var53 /= 2;
                    }

                    while (var53 * var53 + var76 * var76 < 441) {
                        var53 += var53 / 4;
                        var76 += var76 / 4;
                    }

                    int var114 = 25;
                    if (slopeDY < 0) {
                        var114 -= 2;
                    }

                    var30.setColor(new Color(0, 200, 120));
                    var30.fillOval(5, var114 - 20, 40, 40);
                    int var144 = (slopeDX * slopeDX + slopeDY * slopeDY) / 10;
                    int var169 = 11 - var144;
                    var30.setColor(Color.green);

                    for (int var190 = 20; var190 > 0; var190 -= var169) {
                        int var201 = var53 * (22 - var190) / 24;
                        int var221 = var76 * (22 - var190) / 24;
                        var30.drawOval(25 - var201 - var190, var114 - var221 - var190, var190 * 2, var190 * 2);
                    }

                    var30.setColor(Color.black);
                    var30.fillRect(24, var114 - 1, 3, 2);
                    var30.setColor(Color.white);
                    var30.fillRect(25, var114 - 10, 1, 10);
                    var30.setColor(Color.orange);
                    if (windDX > 0) {
                        var30.fillRect(26, var114 - 10, 3, 3);
                    } else {
                        var30.fillRect(22, var114 - 10, 3, 3);
                    }

                    g.drawImage(greenslope, 200, 250, null);
                    var30.dispose();
                }

                if (newWind == 1) {
                    Graphics var31 = wind.getGraphics();
                    newWind = 0;
                    var31.setColor(Color.white);
                    var31.drawRect(0, 0, 50, 49);
                    var31.setColor(Color.lightGray);
                    var31.drawRect(1, 1, 48, 47);
                    var31.setColor(Color.gray);
                    var31.drawRect(2, 2, 46, 45);

                    for (int var54 = 0; var54 < 44; ++var54) {
                        var31.setColor(new Color(50 + var54 * 2, 110 + var54 * 2, 160 + var54 * 2));
                        var31.fillRect(3, 3 + var54, 45, 1);
                    }

                    if (windDY >= 0) {
                        var31.setColor(Color.orange);
                        var31.fillRect(24, 15, 3, 32);
                        var31.setColor(Color.yellow);
                        var31.fillRect(25, 15, 1, 32);
                    }

                    if (windDY < 0 && windDX > 0) {
                        var31.setColor(Color.orange);
                        var31.fillRect(22, 15, 3, 32);
                        var31.setColor(Color.yellow);
                        var31.fillRect(23, 15, 1, 32);
                    }

                    if (windDY < 0 && windDX < 0) {
                        var31.setColor(Color.orange);
                        var31.fillRect(26, 15, 3, 32);
                        var31.setColor(Color.yellow);
                        var31.fillRect(27, 15, 1, 32);
                    }

                    var31.dispose();
                }

                if (ballInFlight == 0) {
                    Graphics var32 = wind.getGraphics();
                    int var55 = aniClock % 16;

                    for (int var77 = 0; var77 < 16; ++var77) {
                        int var115 = (var55 + var77) % 16 * 4 + (int) (Math.random() * (double) 4.0F);
                        if (var115 > 32) {
                            var115 -= 32;
                        }

                        var32.setColor(new Color(var115 * 2 + 180, var115 * 8 / 5 + 120, var115 + 50));
                        var32.drawLine(25, 16 + var77, 25 + windDX * 2, 16 + var77 + windDY * 2);
                    }

                    g.drawImage(wind, 150, 250, null);
                    var32.dispose();
                }

                if (newPower == 1) {
                    Graphics powerbar = Golf.powerbar.getGraphics();
                    newPower = 0;
                    powerbar.setColor(Color.white);
                    powerbar.drawRect(0, 0, 50, 49);
                    powerbar.setColor(Color.lightGray);
                    powerbar.drawRect(1, 1, 48, 47);
                    powerbar.setColor(Color.gray);
                    powerbar.drawRect(2, 2, 46, 45);

                    for (int p1 = 0; p1 < 44; ++p1) {
                        powerbar.setColor(new Color(140 + p1 * 2, 140 + p1 * 2, 140 + p1 * 2));
                        powerbar.fillRect(3, 3 + p1, 45, 1);
                    }

                    powerbar.setColor(Color.black);
                    powerbar.drawOval(28, 7, 18, 36);
                    powerbar.drawOval(29, 7, 17, 36);
                    powerbar.drawOval(30, 7, 16, 36);

                    for (int p2 = 0; p2 < 44; ++p2) {
                        powerbar.setColor(new Color(140 + p2 * 2, 140 + p2 * 2, 140 + p2 * 2));
                        powerbar.fillRect(38, 3 + p2, 10, 1);
                    }

                    powerbar.setColor(Color.gray);
                    powerbar.fillOval(38, 38, 5, 5);
                    powerbar.setColor(Color.lightGray);
                    powerbar.fillOval(39, 38, 4, 4);
                    powerbar.setColor(Color.white);
                    powerbar.fillOval(40, 38, 3, 3);

                    for (int p3 = 0; p3 < 4; ++p3) {
                        powerbar.setColor(new Color(240 - p3 * 20, 240 - p3 * 20, 240 - p3 * 2));
                        powerbar.drawRect(5 + p3, 5 + p3, 20 - p3 * 2, 41 - p3 * 2);
                    }

                    powerbar.dispose();
                }

                if (ballInFlight == 0) {
                    Graphics pbGraphics = powerbar.getGraphics();
                    power += powerDir;
                    if (power > 32 || power < 2) {
                        powerDir = -powerDir;
                    }

                    if (33 - power > 0) {
                        pbGraphics.setColor(Color.black);
                        pbGraphics.fillRect(10, 10, 10, 33 - power);
                    }

                    pbGraphics.setColor(Color.red);
                    pbGraphics.fillRect(10, 43 - power, 10, power);
                    g.drawImage(powerbar, 100, 250, null);
                    pbGraphics.dispose();
                }

                if (newClub == 1) {
                    Graphics clubfaceGraphics = clubface.getGraphics();
                    switch (club) {
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                            globalSize = 200 - (club - 2) * 11;
                            break;
                        case 12:
                            globalSize = 80;
                            break;
                        case 13:
                        case 14:
                        case 15:
                            globalSize = 280 - (club - 13) * 25;
                    }

                    newClub = 0;
                    clubfaceGraphics.setColor(Color.white);
                    clubfaceGraphics.drawRect(0, 0, 50, 49);
                    clubfaceGraphics.setColor(Color.lightGray);
                    clubfaceGraphics.drawRect(1, 1, 48, 47);
                    clubfaceGraphics.setColor(Color.gray);
                    clubfaceGraphics.drawRect(2, 2, 46, 45);
                    clubfaceGraphics.setColor(new Color(0, 200, 120));
                    clubfaceGraphics.fillRect(3, 3, 45, 44);
                    clubfaceGraphics.setColor(new Color(80, 128, 60));
                    clubfaceGraphics.fillRect(4, 35, 20, 12);
                    clubfaceGraphics.fillRect(27, 35, 20, 12);
                    byte lineX = 25;
                    byte lineY = 41;
                    int w1 = 0;
                    clubfaceGraphics.setColor(Color.yellow);

                    for (int cfgI = -4; cfgI < 5; ++cfgI) {
                        clubfaceGraphics.drawLine(6, lineY, 21, lineY + cfgI);
                        clubfaceGraphics.drawLine(44, lineY, 29, lineY + cfgI);
                    }

                    lineX = 16;
                    lineY = 19;
                    w1 = 0;
                    switch (club) {
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                            for (int xx = 17; xx < 23; ++xx) {
                                if (xx > 17 && xx < 22) {
                                    clubfaceGraphics.setColor(new Color(410 - xx * 10, 410 - xx * 10, 410 - xx * 10));
                                    clubfaceGraphics.fillRect(lineX + xx + club - 5, 3, 1, 18);
                                }

                                clubfaceGraphics.setColor(new Color(200 - xx * 5, 200 - xx * 5, 200 - xx * 5));
                                clubfaceGraphics.fillRect(lineX + xx + club - 5, 21, 1, 12);
                            }

                            w1 = 0;

                            for (int xx1 = -12; xx1 < 15; ++xx1) {
                                clubfaceGraphics.setColor(new Color(200 - xx1 * 3, 200 - xx1 * 3, 200 - xx1 * 3));
                                clubfaceGraphics.fillRect(lineX + xx1 * club / 12, lineY + xx1, 12 + w1 / 4, 1);
                                if (xx1 > -11 && xx1 < 14) {
                                    if ((xx1 + 20) % 4 == 2) {
                                        clubfaceGraphics.setColor(Color.darkGray);
                                        clubfaceGraphics.fillRect(lineX + xx1 * club / 12 + 6, lineY + xx1, 3 + w1 / 5, 1);
                                    } else {
                                        clubfaceGraphics.setColor(new Color(160 - xx1 * 3, 160 - xx1 * 3, 160 - xx1 * 3));
                                        clubfaceGraphics.fillRect(lineX + xx1 * club / 12 + 5, lineY + xx1, 5 + w1 / 5, 1);
                                    }
                                }

                                ++w1;
                                if (w1 > 20) {
                                    w1 = 20;
                                }
                            }

                            if (club < 10) {
                                clubfaceGraphics.setColor(Color.black);
                                clubfaceGraphics.drawString("" + club, 6, 33);
                                clubfaceGraphics.drawString("" + club, 6, 32);
                                clubfaceGraphics.drawString("" + club, 5, 33);
                                clubfaceGraphics.setColor(Color.white);
                                clubfaceGraphics.drawString("" + club, 5, 32);
                            }

                            if (club == 10) {
                                clubfaceGraphics.setColor(Color.black);
                                clubfaceGraphics.drawString("PW", 6, 33);
                                clubfaceGraphics.drawString("PW", 6, 32);
                                clubfaceGraphics.drawString("PW", 5, 33);
                                clubfaceGraphics.setColor(Color.white);
                                clubfaceGraphics.drawString("PW", 5, 32);
                            }

                            if (club == 11) {
                                clubfaceGraphics.setColor(Color.black);
                                clubfaceGraphics.drawString("SW", 6, 33);
                                clubfaceGraphics.drawString("SW", 6, 32);
                                clubfaceGraphics.drawString("SW", 5, 33);
                                clubfaceGraphics.setColor(Color.white);
                                clubfaceGraphics.drawString("SW", 5, 32);
                            }
                            break;
                        case 12:
                            w1 = 42;

                            for (int gradii = 4; gradii < 15; ++gradii) {
                                clubfaceGraphics.setColor(new Color(240 - gradii * 3, 240 - gradii * 3, 100 - gradii * 3));
                                clubfaceGraphics.fillRect(lineX, lineY + gradii, 12 + w1 / 4, 1);
                                if (gradii > 1 && gradii < 14) {
                                    if ((gradii + 20) % 4 == 2) {
                                        clubfaceGraphics.setColor(Color.darkGray);
                                        clubfaceGraphics.fillRect(lineX + 6, lineY + gradii, 3 + w1 / 5, 1);
                                    } else {
                                        clubfaceGraphics.setColor(new Color(160 - gradii * 3, 160 - gradii * 3, 160 - gradii * 3));
                                        clubfaceGraphics.fillRect(lineX + 5, lineY + gradii, 5 + w1 / 5, 1);
                                    }
                                }

                                ++w1;
                            }

                            for (int gradii2 = 17; gradii2 < 23; ++gradii2) {
                                if (gradii2 > 17 && gradii2 < 22) {
                                    clubfaceGraphics.setColor(new Color(410 - gradii2 * 10, 410 - gradii2 * 10, 410 - gradii2 * 10));
                                    clubfaceGraphics.fillRect(lineX + gradii2 + club - 7, 3, 1, 18);
                                }

                                clubfaceGraphics.setColor(new Color(300 - gradii2 * 5, 300 - gradii2 * 5, 150 - gradii2 * 5));
                                clubfaceGraphics.fillRect(lineX + gradii2 + club - 7, 21, 1, 12);
                            }

                            clubfaceGraphics.setColor(Color.black);
                            clubfaceGraphics.drawString("P", 6, 33);
                            clubfaceGraphics.drawString("P", 6, 32);
                            clubfaceGraphics.drawString("P", 5, 33);
                            clubfaceGraphics.setColor(Color.white);
                            clubfaceGraphics.drawString("P", 5, 32);
                            break;
                        case 13:
                        case 14:
                        case 15:
                            w1 = 8;
                            lineY = 19;

                            for (int c1 = 0; c1 < 12; c1 += 2) {
                                clubfaceGraphics.setColor(new Color(105 + c1 * 6, 80 + c1 * 6, 50 + c1 * 6));
                                clubfaceGraphics.fillOval(w1 + c1, lineY - w1, w1, w1 * 2);
                                ++w1;
                            }

                            for (int c2 = 17; c2 < 23; ++c2) {
                                if (c2 > 17 && c2 < 22) {
                                    clubfaceGraphics.setColor(new Color(410 - c2 * 10, 410 - c2 * 10, 410 - c2 * 10));
                                    clubfaceGraphics.fillRect(lineX + c2 + club / 2, 3, 1, 18);
                                }

                                clubfaceGraphics.setColor(new Color(200 - c2 * 5, 200 - c2 * 5, 200 - c2 * 5));
                                clubfaceGraphics.fillRect(lineX + c2 + club / 2, 21, 1, 11);
                            }

                            w1 = 0;

                            for (int c4 = -12; c4 < 14; ++c4) {
                                clubfaceGraphics.setColor(new Color(200 - c4 * 3, 160 - c4 * 3, 80 - c4 * 3));
                                clubfaceGraphics.fillRect(10 + lineX + c4 * club / 48, lineY + c4, 12 + w1 / 4, 1);
                                if (c4 > -11 && c4 < 13) {
                                    if ((c4 + 20) % 4 == 2) {
                                        clubfaceGraphics.setColor(Color.darkGray);
                                        clubfaceGraphics.fillRect(10 + lineX + c4 * club / 48 + 6, lineY + c4, 3 + w1 / 5, 1);
                                    } else {
                                        clubfaceGraphics.setColor(new Color(160 - c4 * 3, 160 - c4 * 3, 160 - c4 * 3));
                                        clubfaceGraphics.fillRect(10 + lineX + c4 * club / 48 + 5, lineY + c4, 5 + w1 / 5, 1);
                                    }
                                }

                                ++w1;
                                if (w1 > 20) {
                                    w1 = 20;
                                }
                            }

                            if (club == 13) {
                                clubfaceGraphics.setColor(Color.black);
                                clubfaceGraphics.drawString("DR", 6, 33);
                                clubfaceGraphics.drawString("DR", 6, 32);
                                clubfaceGraphics.drawString("DR", 5, 33);
                                clubfaceGraphics.setColor(Color.white);
                                clubfaceGraphics.drawString("DR", 5, 32);
                            }

                            if (club == 14) {
                                clubfaceGraphics.setColor(Color.black);
                                clubfaceGraphics.drawString("3W", 6, 33);
                                clubfaceGraphics.drawString("3W", 6, 32);
                                clubfaceGraphics.drawString("3W", 5, 33);
                                clubfaceGraphics.setColor(Color.white);
                                clubfaceGraphics.drawString("3W", 5, 32);
                            }

                            if (club == 15) {
                                clubfaceGraphics.setColor(Color.black);
                                clubfaceGraphics.drawString("5W", 6, 33);
                                clubfaceGraphics.drawString("5W", 6, 32);
                                clubfaceGraphics.drawString("5W", 5, 33);
                                clubfaceGraphics.setColor(Color.white);
                                clubfaceGraphics.drawString("5W", 5, 32);
                            }
                    }

                    g.drawImage(clubface, 0, 250, null);
                    clubfaceGraphics.dispose();
                }

                if (picked == 1 && button == 1 && lastBallIsOn != ballIsOn) {
                    lastBallIsOn = ballIsOn;
                    Graphics ballGraphics = ball.getGraphics();
                    ballGraphics.setColor(Color.white);
                    ballGraphics.drawRect(0, 0, 50, 49);
                    ballGraphics.setColor(Color.lightGray);
                    ballGraphics.drawRect(1, 1, 48, 47);
                    ballGraphics.setColor(Color.gray);
                    ballGraphics.drawRect(2, 2, 46, 45);

                    for (int c4 = 0; c4 < 44; ++c4) {
                        ballGraphics.setColor(new Color(50 + c4 * 2, 110 + c4 * 2, 160 + c4 * 2));
                        ballGraphics.fillRect(3, 3 + c4, 45, 1);
                    }

                    int br3 = 25;
                    int br2 = 23;
                    int br1 = 0;

                    for (int c5 = 19; c5 > 0; --c5) {
                        ballGraphics.setColor(new Color(255 - c5 * 3, 255 - 3 * c5, 255 - 3 * c5));
                        ballGraphics.fillOval(br3 - c5 - br1 / 4, br2 - c5 + br1 * 2 / 3, c5 * 2, c5 * 2);
                        --br1;
                    }

                    br2 -= 4;
                    br3 -= 2;

                    for (int var191 = -15; var191 < 25; var191 += 5) {
                        int var202 = 2 - var191 * var191 / 120;
                        ballGraphics.setColor(Color.white);
                        if (var191 < 5) {
                            ballGraphics.fillOval(br3 + var191 + 8, br2 + var202 + 1 - 15, 3, 3);
                        }

                        if (var191 < 10) {
                            ballGraphics.fillOval(br3 + var191 + 5, br2 + var202 + 1 - 12, 3, 3);
                        }

                        if (var191 < 15) {
                            ballGraphics.fillOval(br3 + var191 + 3, br2 + var202 + 1 - 9, 3, 3);
                        }

                        if (var191 < 20) {
                            ballGraphics.fillOval(br3 + var191, br2 + var202 + 1 - 5, 3, 3);
                        }

                        ballGraphics.fillOval(br3 + var191 - 2, br2 + var202 + 1, 3, 3);
                        if (var191 < 20) {
                            ballGraphics.fillOval(br3 + var191, br2 + var202 + 1 + 5, 3, 3);
                        }

                        if (var191 < 15) {
                            ballGraphics.fillOval(br3 + var191 + 3, br2 + var202 + 1 + 9, 3, 3);
                        }

                        if (var191 < 10) {
                            ballGraphics.fillOval(br3 + var191 + 5, br2 + var202 + 1 + 12, 3, 3);
                        }

                        if (var191 < 5) {
                            ballGraphics.fillOval(br3 + var191 + 8, br2 + var202 + 1 + 15, 3, 3);
                        }

                        ballGraphics.setColor(Color.lightGray);
                        if (var191 < 5) {
                            ballGraphics.fillOval(br3 + var191 + 8, br2 + var202 - 15, 3, 3);
                        }

                        if (var191 < 10) {
                            ballGraphics.fillOval(br3 + var191 + 5, br2 + var202 - 12, 3, 3);
                        }

                        if (var191 < 15) {
                            ballGraphics.fillOval(br3 + var191 + 3, br2 + var202 - 9, 3, 3);
                        }

                        if (var191 < 20) {
                            ballGraphics.fillOval(br3 + var191, br2 + var202 - 5, 3, 3);
                        }

                        ballGraphics.fillOval(br3 + var191 - 2, br2 + var202, 3, 3);
                        if (var191 < 20) {
                            ballGraphics.fillOval(br3 + var191, br2 + var202 + 5, 3, 3);
                        }

                        if (var191 < 15) {
                            ballGraphics.fillOval(br3 + var191 + 3, br2 + var202 + 9, 3, 3);
                        }

                        if (var191 < 10) {
                            ballGraphics.fillOval(br3 + var191 + 5, br2 + var202 + 12, 3, 3);
                        }

                        if (var191 < 5) {
                            ballGraphics.fillOval(br3 + var191 + 8, br2 + var202 + 15, 3, 3);
                        }
                    }

                    br2 += 4;
                    br3 += 2;
                    switch (ballIsOn) {
                        case 0:
                            ballGraphics.setColor(new Color(64, 180, 64));
                            ballGraphics.fillRect(3, 44, 45, 3);
                            br2 = 50;
                            br1 = 0;

                            for (int var210 = 8; var210 > 3; --var210) {
                                for (int var224 = -var210 + 1; var224 < var210; ++var224) {
                                    ballGraphics.setColor(new Color(210 + var224 * 5, 160 + var224 * 5, 160 + var224 * 5));
                                    ballGraphics.fillRect(br3 + var224, br2 - var210, 1, 1);
                                }
                            }
                            break;
                        case 1:
                            lastBallIsOn = 99;
                            if (sandPlug == 0) {
                                ballGraphics.setColor(new Color(240, 180, 160));
                                ballGraphics.fillRect(3, 3, 45, 44);
                                br2 = 36;
                                br1 = 0;

                                for (int var209 = 0; var209 < 21; ++var209) {
                                    ballGraphics.setColor(new Color(135 + var209 * 5, 80 + var209 * 5, 60 + var209 * 5));
                                    ballGraphics.drawOval(br3 - var209, br2 - var209 / 2, var209 * 2, var209);
                                }

                                br2 = 23;
                                br1 = 0;

                                for (int var223 = 19; var223 > 0; --var223) {
                                    ballGraphics.setColor(new Color(255 - var223 * 3, 255 - 3 * var223, 255 - 3 * var223));
                                    ballGraphics.fillOval(br3 - var223 - br1 / 4, br2 - var223 + br1 * 2 / 3, var223 * 2, var223 * 2);
                                    --br1;
                                }

                                br2 -= 4;
                                br3 -= 2;

                                for (int var236 = -15; var236 < 25; var236 += 5) {
                                    int var244 = 2 - var236 * var236 / 120;
                                    ballGraphics.setColor(Color.white);
                                    if (var236 < 5) {
                                        ballGraphics.fillOval(br3 + var236 + 8, br2 + var244 + 1 - 15, 3, 3);
                                    }

                                    if (var236 < 10) {
                                        ballGraphics.fillOval(br3 + var236 + 5, br2 + var244 + 1 - 12, 3, 3);
                                    }

                                    if (var236 < 15) {
                                        ballGraphics.fillOval(br3 + var236 + 3, br2 + var244 + 1 - 9, 3, 3);
                                    }

                                    if (var236 < 20) {
                                        ballGraphics.fillOval(br3 + var236, br2 + var244 + 1 - 5, 3, 3);
                                    }

                                    ballGraphics.fillOval(br3 + var236 - 2, br2 + var244 + 1, 3, 3);
                                    if (var236 < 20) {
                                        ballGraphics.fillOval(br3 + var236, br2 + var244 + 1 + 5, 3, 3);
                                    }

                                    if (var236 < 15) {
                                        ballGraphics.fillOval(br3 + var236 + 3, br2 + var244 + 1 + 9, 3, 3);
                                    }

                                    if (var236 < 10) {
                                        ballGraphics.fillOval(br3 + var236 + 5, br2 + var244 + 1 + 12, 3, 3);
                                    }

                                    if (var236 < 5) {
                                        ballGraphics.fillOval(br3 + var236 + 8, br2 + var244 + 1 + 15, 3, 3);
                                    }

                                    ballGraphics.setColor(Color.lightGray);
                                    if (var236 < 5) {
                                        ballGraphics.fillOval(br3 + var236 + 8, br2 + var244 - 15, 3, 3);
                                    }

                                    if (var236 < 10) {
                                        ballGraphics.fillOval(br3 + var236 + 5, br2 + var244 - 12, 3, 3);
                                    }

                                    if (var236 < 15) {
                                        ballGraphics.fillOval(br3 + var236 + 3, br2 + var244 - 9, 3, 3);
                                    }

                                    if (var236 < 20) {
                                        ballGraphics.fillOval(br3 + var236, br2 + var244 - 5, 3, 3);
                                    }

                                    ballGraphics.fillOval(br3 + var236 - 2, br2 + var244, 3, 3);
                                    if (var236 < 20) {
                                        ballGraphics.fillOval(br3 + var236, br2 + var244 + 5, 3, 3);
                                    }

                                    if (var236 < 15) {
                                        ballGraphics.fillOval(br3 + var236 + 3, br2 + var244 + 9, 3, 3);
                                    }

                                    if (var236 < 10) {
                                        ballGraphics.fillOval(br3 + var236 + 5, br2 + var244 + 12, 3, 3);
                                    }

                                    if (var236 < 5) {
                                        ballGraphics.fillOval(br3 + var236 + 8, br2 + var244 + 15, 3, 3);
                                    }
                                }

                                br2 += 4;
                                br3 += 2;
                                break;
                            }

                            ballGraphics.setColor(new Color(240, 180, 160));
                            ballGraphics.fillRect(3, 3, 45, 44);
                            br2 = 26;
                            br1 = 0;

                            for (int var208 = 0; var208 < 22; ++var208) {
                                ballGraphics.setColor(new Color(130 + var208 * 5, 80 + var208 * 5, 60 + var208 * 5));
                                ballGraphics.drawOval(br3 - var208, br2 - var208, var208 * 2, var208 * 3 / 2);
                            }

                            br2 = 24;
                            br1 = 0;

                            for (int var222 = 15; var222 > 0; --var222) {
                                ballGraphics.setColor(new Color(255 - var222 * 4, 255 - 4 * var222, 255 - 4 * var222));
                                ballGraphics.fillOval(br3 - var222 + br1 / 4, br2 - var222 * 3 / 4 - br1 / 2 * 2 / 3, var222 * 2, var222 * 3 / 2);
                                ++br1;
                            }
                            break;
                        case 2:
                            ballGraphics.setColor(new Color(128, 128, 255));
                            ballGraphics.fillRect(3, 3, 45, 44);
                            br2 = 40;

                            for (int var206 = 12; var206 > 0; var206 -= 2) {
                                ballGraphics.setColor(new Color(128 - var206 * 4, 128 - var206 * 4, 255 - var206 * 4));
                                ballGraphics.fillOval(br3 - var206, br2 - var206, var206 * 2, var206);
                            }

                            br2 = 21;

                            for (int var207 = 20; var207 > 0; var207 -= 4) {
                                ballGraphics.setColor(new Color(255 - var207 * 4, 255 - var207 * 4, 255 - var207 * 4));
                                ballGraphics.drawOval(br3 - var207, br2 - var207 / 2, var207 * 2, var207);
                            }
                            break;
                        case 3:
                            ballGraphics.setColor(new Color(128, 255, 128));
                            ballGraphics.fillRect(3, 42, 45, 5);

                            for (int var205 = 0; var205 < 120; ++var205) {
                                br3 = (int) (Math.random() * (double) 20.0F) * 2 + 6;
                                br2 = 44;
                                br1 = (int) (Math.random() * (double) 5.0F) - 2;
                                ballGraphics.setColor(new Color(128, 220 + br1 * 15, 128));
                                ballGraphics.drawLine(br3 + br1, br2 - 5 - br1, br3, br2 - br1);
                            }
                            break;
                        case 4:
                            ballGraphics.setColor(new Color(64, 180, 64));
                            ballGraphics.fillRect(3, 42, 45, 5);
                            break;
                        case 5:
                            ballGraphics.setColor(new Color(100, 200, 100));
                            ballGraphics.fillRect(3, 34, 45, 13);

                            for (int var204 = 0; var204 < 120; ++var204) {
                                br3 = (int) (Math.random() * (double) 21.0F) * 2 + 5;
                                br2 = 42;
                                br1 = (int) (Math.random() * (double) 5.0F) - 2;
                                ballGraphics.setColor(new Color(100, 180 + br1 * 25, 100));
                                ballGraphics.drawLine(br3 + br1, br2 - 15 - br1, br3, br2 - br1);
                            }
                            break;
                        case 6:
                            ballGraphics.setColor(new Color(160, 160, 80));
                            ballGraphics.fillRect(3, 27, 45, 20);

                            for (int var203 = 0; var203 < 120; ++var203) {
                                br3 = (int) (Math.random() * (double) 21.0F) * 2 + 5;
                                br2 = 40;
                                br1 = (int) (Math.random() * (double) 5.0F) - 2;
                                ballGraphics.setColor(new Color(160, 160 + br1 * 25, 80));
                                ballGraphics.drawLine(br3 + br1, br2 - 25 - br1, br3, br2 - br1 * 2);
                            }
                        case 7:
                    }

                    g.drawImage(ball, 50, 250, null);
                    ballGraphics.dispose();
                }

                Graphics goldGraphics = gold.getGraphics();
                Graphics workingGraphics = working.getGraphics();
                int var90 = (ballX - pinX) * 2 + 300;
                int var138 = (ballY - pinY) * 2 + 125;
                if (ballInFlight == 1 && magSelected == 0 && ballTime > 1) {
                    workingGraphics.clipRect(ballX - 15, 0, 30, ballY + 10);
                }

                if (ballInFlight == 1 && magSelected == 1 && ballTime > 1) {
                    workingGraphics.clipRect(var90 - 15, 0, 30, var138 + 10);
                }

                if (ballInFlight == 1) {
                    workingGraphics.drawImage(gold, 0, 0, null);
                }

                if (holebuilt == 1 && ballInFlight == 0 && bigRefresh == 1) {
                    bigRefresh = 0;
                    bigRefresh2 = 1;
                    workingGraphics.drawImage(gold, 0, 0, null);
                }

                if (fullRefresh == 1 && holebuilt == 0) {
                    g.setColor(Color.black);
                    g.drawString("Club", 11, 248);
                    g.drawString("Lie", 64, 248);
                    g.drawString("Swing", 108, 248);
                    g.drawString("Wind", 161, 248);
                    g.drawString("Slope", 211, 248);
                    g.setColor(Color.white);
                    g.drawString("Club", 10, 247);
                    g.drawString("Lie", 63, 247);
                    g.drawString("Swing", 107, 247);
                    g.drawString("Wind", 160, 247);
                    g.drawString("Slope", 210, 247);
                    g.setColor(new Color(20, 120, 40));
                    g.fillRect(0, 86, 600, 20);
                    g.setColor(Color.black);
                    g.drawString("Refreshing the display...Please stand by", 201, 101);
                    g.setColor(Color.white);
                    g.drawString("Refreshing the display...Please stand by", 200, 100);
                    g.setColor(Color.white);
                    g.drawRect(0, 84, 599, 22);
                    g.setColor(Color.lightGray);
                    g.drawRect(1, 85, 597, 20);
                    g.setColor(Color.gray);
                    g.drawRect(2, 86, 595, 18);
                }

                if (holebuilt == 0 && gameOver == 0) {
                    if (fullRefresh == 0) {
                        g.setColor(new Color(20, 120, 40));
                        g.fillRect(0, 228, 600, 20);
                        g.setColor(Color.white);
                        g.drawRect(0, 228, 599, 20);
                        g.setColor(Color.lightGray);
                        g.drawRect(1, 229, 597, 18);
                        g.setColor(Color.gray);
                        g.drawRect(2, 230, 595, 16);
                        if (magSelected == 0) {
                            g.setColor(Color.black);
                            g.drawString("...ZOOMING OUT FOR A WIDE-ANGLE VIEW...", 121, 244);
                            g.setColor(Color.white);
                            g.drawString("...ZOOMING OUT FOR A WIDE-ANGLE VIEW...", 120, 243);
                        } else {
                            g.setColor(Color.black);
                            g.drawString("...ZOOMING IN FOR A CLOSE-UP VIEW...", 121, 244);
                            g.setColor(Color.white);
                            g.drawString("...ZOOMING IN FOR A CLOSE-UP VIEW...", 120, 243);
                        }
                    }

                    fullRefresh = 0;
                    goldGraphics.setColor(new Color(20, 120, 40));
                    goldGraphics.fillRect(0, 0, 600, 250);
                    goldGraphics.setColor(new Color(52, 152, 72));

                    for (int var155 = 0; var155 < 650; var155 += 2) {
                        goldGraphics.drawOval(300 - var155, -50, var155 * 2, var155 / 2);
                    }

                    for (int var178 = 0; var178 < roughs; ++var178) {
                        magX = roughX[var178];
                        magY = roughY[var178];
                        magSize = roughRadius[var178];
                        if (magSelected == 1) {
                            magX = (roughX[var178] - pinX) * 2 + 300;
                            magY = (roughY[var178] - pinY) * 2 + 125;
                            magSize = roughRadius[var178] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        int tempMag = magSize;
                        goldGraphics.setColor(rough1);
                        goldGraphics.fillOval(magX - tempMag, magY - tempMag / 2, tempMag * 2, tempMag);
                        int var211 = 0;
                        goldGraphics.setColor(rough2);

                        for (int calcMag = magSize; calcMag > 0; calcMag -= 2) {
                            goldGraphics.drawOval(magX - calcMag, magY - calcMag / 2 + var211, calcMag * 2, calcMag);
                            --var211;
                        }
                    }

                    for (int fIndex = 0; fIndex < fairways; ++fIndex) {
                        magX = fairwayX[fIndex];
                        magY = fairwayY[fIndex];
                        magSize = fairwayRadius[fIndex];
                        if (magSelected == 1) {
                            magX = (fairwayX[fIndex] - pinX) * 2 + 300;
                            magY = (fairwayY[fIndex] - pinY) * 2 + 125;
                            magSize = fairwayRadius[fIndex] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        int tMag = magSize;
                        goldGraphics.setColor(new Color(144, 234, 104));
                        goldGraphics.fillOval(magX - tMag, magY - tMag / 2, tMag * 2, tMag);
                        int var226 = 0;
                        goldGraphics.setColor(new Color(100, 255, 120));

                        for (int var237 = magSize; var237 > 0; var237 -= 2) {
                            goldGraphics.drawOval(magX - var237, magY - var237 / 2 + var226, var237 * 2, var237);
                            --var226;
                        }
                    }

                    for (int var213 = 0; var213 < sandtraps; ++var213) {
                        magX = sandX[var213];
                        magY = sandY[var213];
                        magSize = sandRadius[var213];
                        if (magSelected == 1) {
                            magX = (sandX[var213] - pinX) * 2 + 300;
                            magY = (sandY[var213] - pinY) * 2 + 125;
                            magSize = sandRadius[var213] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        int var227 = magSize + 1;
                        goldGraphics.setColor(sand1);
                        goldGraphics.fillOval(magX - var227, magY - var227 / 2 - 1, var227 * 2, var227);
                        goldGraphics.setColor(sand2);
                        goldGraphics.fillOval(magX - var227, magY - var227 / 2 + 1, var227 * 2, var227);
                    }

                    goldGraphics.setColor(sand3);

                    for (int var228 = 0; var228 < sandtraps; ++var228) {
                        magX = sandX[var228];
                        magY = sandY[var228];
                        magSize = sandRadius[var228];
                        if (magSelected == 1) {
                            magX = (sandX[var228] - pinX) * 2 + 300;
                            magY = (sandY[var228] - pinY) * 2 + 125;
                            magSize = sandRadius[var228] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        goldGraphics.fillOval(magX - magSize, magY - magSize / 2, magSize * 2, magSize);
                    }

                    goldGraphics.setColor(sand4);

                    for (int var238 = 0; var238 < sandtraps; ++var238) {
                        magX = sandX[var238];
                        magY = sandY[var238];
                        magSize = sandRadius[var238];
                        if (magSelected == 1) {
                            magX = (sandX[var238] - pinX) * 2 + 300;
                            magY = (sandY[var238] - pinY) * 2 + 125;
                            magSize = sandRadius[var238] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        int var245 = 0;

                        for (int var247 = magSize; var247 > 0; var247 -= 2) {
                            goldGraphics.drawOval(magX - var247, magY - var247 / 2 + var245, var247 * 2, var247);
                            --var245;
                        }
                    }

                    for (int var246 = 0; var246 < lakes; ++var246) {
                        magX = lakeX[var246];
                        magY = lakeY[var246];
                        magSize = lakeRadius[var246];
                        if (magSelected == 1) {
                            magX = (lakeX[var246] - pinX) * 2 + 300;
                            magY = (lakeY[var246] - pinY) * 2 + 125;
                            magSize = lakeRadius[var246] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        int var248 = magSize + 1;
                        goldGraphics.setColor(lake1);
                        goldGraphics.fillOval(magX - var248, magY - var248 / 2 - 1, var248 * 2, var248);
                        goldGraphics.setColor(lake2);
                        goldGraphics.fillOval(magX - var248, magY - var248 / 2 + 1, var248 * 2, var248);
                    }

                    goldGraphics.setColor(lake3);

                    for (int var249 = 0; var249 < lakes; ++var249) {
                        magX = lakeX[var249];
                        magY = lakeY[var249];
                        magSize = lakeRadius[var249];
                        if (magSelected == 1) {
                            magX = (lakeX[var249] - pinX) * 2 + 300;
                            magY = (lakeY[var249] - pinY) * 2 + 125;
                            magSize = lakeRadius[var249] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        int var250 = magSize;
                        goldGraphics.fillOval(magX - var250, magY - var250 / 2, var250 * 2, var250);
                    }

                    for (int var251 = 0; var251 < lakes; ++var251) {
                        magX = lakeX[var251];
                        magY = lakeY[var251];
                        magSize = lakeRadius[var251];
                        if (magSelected == 1) {
                            magX = (lakeX[var251] - pinX) * 2 + 300;
                            magY = (lakeY[var251] - pinY) * 2 + 125;
                            magSize = lakeRadius[var251] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        int var252 = 0;
                        int var254 = 32 * (var251 % 2 + 1);
                        if (var254 == 32) {
                            goldGraphics.setColor(lake4);
                        } else {
                            goldGraphics.setColor(lake5);
                        }

                        for (int var256 = magSize - 2; var256 > 0; --var256) {
                            int var261 = (int) (Math.random() * (double) 3.0F) - 1;
                            goldGraphics.drawOval(magX - var256 + var261, magY - var256 / 2 + var252 / 2 + 1, var256 * 2, var256);
                            --var252;
                        }
                    }

                    goldGraphics.setColor(green1);

                    for (int var253 = 0; var253 < greens; ++var253) {
                        magX = greenX[var253];
                        magY = greenY[var253];
                        magSize = greenRadius[var253];
                        if (magSelected == 1) {
                            magX = (greenX[var253] - pinX) * 2 + 300;
                            magY = (greenY[var253] - pinY) * 2 + 125;
                            magSize = greenRadius[var253] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        goldGraphics.fillOval(magX - magSize, magY - magSize / 2, 2 * magSize, magSize);
                    }

                    goldGraphics.setColor(green2);

                    for (int var255 = 0; var255 < greens; ++var255) {
                        magX = greenX[var255];
                        magY = greenY[var255];
                        magSize = greenRadius[var255];
                        if (magSelected == 1) {
                            magX = (greenX[var255] - pinX) * 2 + 300;
                            magY = (greenY[var255] - pinY) * 2 + 125;
                            magSize = greenRadius[var255] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        int var257 = 0;

                        for (int var262 = magSize; var262 > 0; var262 -= 2) {
                            goldGraphics.drawOval(magX - var262, magY - var262 / 2 - var257, var262 * 2, var262);
                            ++var257;
                        }
                    }

                    if (magSelected != 1) {
                        goldGraphics.setColor(Color.black);
                        goldGraphics.fillRect(pinX - 1, pinY - 1, 3, 2);
                        goldGraphics.setColor(Color.yellow);
                        goldGraphics.fillRect(pinX, pinY - 10, 1, 10);
                        goldGraphics.setColor(Color.orange);
                        if (windDX > 0) {
                            goldGraphics.fillRect(pinX + 1, pinY - 10, 3, 3);
                        } else {
                            goldGraphics.fillRect(pinX - 3, pinY - 10, 3, 3);
                        }
                    } else {
                        goldGraphics.setColor(Color.white);

                        for (int var258 = 9; var258 > 0; var258 -= 2) {
                            if (var258 == 7) {
                                goldGraphics.setColor(Color.lightGray);
                            }

                            if (var258 == 6) {
                                goldGraphics.setColor(Color.gray);
                            }

                            if (var258 == 5) {
                                goldGraphics.setColor(Color.darkGray);
                            }

                            goldGraphics.fillOval(300 - var258 / 2, 125 - var258 / 4, var258, var258 / 2);
                        }

                        goldGraphics.setColor(Color.black);
                        goldGraphics.fillOval(299, 124, 3, 3);
                    }

                    if (magSelected == 0) {
                        goldGraphics.setColor(tee1);
                        goldGraphics.fillOval(teeX - 13, teeY - 6, 27, 13);
                        int var259 = pinX - teeX;

                        int var263;
                        for (var263 = pinY - teeY; var263 * var263 + var259 * var259 > 100; var259 /= 2) {
                            var263 /= 2;
                        }

                        while (var263 * var263 + var259 * var259 < 100) {
                            var263 += var263 / 2;
                            var259 += var259 / 2;
                        }

                        goldGraphics.setColor(tee2);
                        goldGraphics.fillOval(teeX - var263 - 2, teeY + var259 / 2 - 2, 5, 5);
                        goldGraphics.fillOval(teeX + var263 - 2, teeY - var259 / 2 - 2, 5, 5);
                        goldGraphics.setColor(Color.white);
                        goldGraphics.fillOval(teeX - var263 - 2, teeY + var259 / 2 - 2, 2, 2);
                        goldGraphics.fillOval(teeX + var263 - 2, teeY - var259 / 2 - 2, 2, 2);
                    }

                    for (int var260 = 0; var260 < trees; ++var260) {
                        magX = treeX[var260];
                        magY = treeY[var260];
                        magSize = treeRadius[var260];
                        if (magSelected == 1) {
                            magX = (treeX[var260] - pinX) * 2 + 300;
                            magY = (treeY[var260] - pinY) * 2 + 125;
                            magSize = treeRadius[var260] * 2;
                            if (magX + magSize < 0 || magX - magSize > 600) {
                                magSize = 1;
                            }

                            if (magY + magSize < 0 || magY - magSize > 250) {
                                magSize = 1;
                            }
                        }

                        int var264 = magSize;
                        goldGraphics.setColor(new Color(160, 120, 50));

                        for (int var265 = -var264 / 10; var265 < var264 / 10 + 1; ++var265) {
                            goldGraphics.drawLine(magX, magY - var264 * 3, magX + var265, magY);
                        }

                        for (int var266 = 0; var266 < var264 * 4; ++var266) {
                            int var267 = var266 / 3 + 2;
                            int var22 = magX + (int) (Math.random() * (double) var267) - var267 / 2;
                            int var23 = magY - var264 * 3 + var266 * 2 / 3;
                            goldGraphics.setColor(new Color(130, 120, 20));
                            goldGraphics.drawLine(magX, magY - var264 / 2, var22, var23);
                            goldGraphics.setColor(new Color(120 + var22 % 5 * 15, 150 + var266 % 6 * 19, 20));
                            goldGraphics.fillOval(var22 - var264 / 16 - 1, var23 - var264 / 32 - 1, 2 + var267 / 25, 1 + var267 / 25);
                            if (var266 > var264) {
                                goldGraphics.fillOval(3 + var22 - var264 / 16 - 1, 2 + var23 - var264 / 32 - 1, 3, 2);
                            }

                            if (var266 > var264 * 2) {
                                goldGraphics.fillOval(-3 + var22 - var264 / 16 - 1, 2 + var23 - var264 / 32 - 1, 2, 1);
                            }

                            if (var266 > var264 * 2) {
                                goldGraphics.setColor(new Color(80, 140, 80));
                                var23 = magY + (int) (Math.random() * (double) var264 / (double) 2.0F) - var264 / 4;
                                goldGraphics.drawOval(var22 - var264 / 6, var23, var264 / 3, var264 / 6);
                            }
                        }

                        goldGraphics.setColor(new Color(100, 130, 100));
                        goldGraphics.fillOval(magX - var264 / 3, magY - var264 / 6 + 1, var264 * 2 / 3, var264 / 3);
                        goldGraphics.setColor(new Color(140, 100, 40));

                        for (int var268 = -var264 / 10; var268 < var264 / 10 + 1; ++var268) {
                            goldGraphics.setColor(new Color(150 + var268 % 10 * 10, 110 + var268 % 9 * 9, 40));
                            goldGraphics.drawLine(magX, magY - var264, magX + var268, magY);
                        }
                    }

                    workingGraphics.drawImage(gold, 0, 0, null);
                    holebuilt = 1;
                    bigRefresh = 1;
                }

                g.clipRect(0, 0, 600, 250);
                if (ballInFlight == 0) {
                    int var156 = 0;
                    int var179 = 0;
                    if (magSelected == 0) {
                        var156 = aimX - ballX;
                        var179 = (aimY - ballY) * 2;
                    } else {
                        var156 = aimX - ((ballX - pinX) * 2 + 300);
                        var179 = aimY - ((ballY - pinY) * 4 + 125);
                    }

                    int var194 = var156;
                    int var214 = var179;
                    int var229 = 100;
                    if (var156 * var156 + var179 * var179 > 2500) {
                        while (var156 * var156 + var179 * var179 > 2500 && var229 > 1) {
                            var156 = var194 * var229 / 100;
                            var179 = var214 * var229 / 100;
                            --var229;
                        }
                    } else {
                        while (var156 * var156 + var179 * var179 < 2500 && var229 > 1) {
                            var156 = var194 * 100 / var229;
                            var179 = var214 * 100 / var229;
                            --var229;
                        }
                    }

                    ballDX = var156;
                    ballDY = var179;
                    bpX = var156;
                    bpY = var179;
                }

                if (magSelected == 0 && rangeClock > 0) {
                    --rangeClock;
                    if (rangeClock == 0) {
                        bigRefresh = 1;
                    }

                    workingGraphics.setColor(Color.black);
                    workingGraphics.drawOval(ballX - globalSize, ballY - globalSize / 2, globalSize * 2, globalSize);
                }

                if (playerClock > 0 && magSelected == 0) {
                    if (inLake == 1) {
                        workingGraphics.setColor(Color.white);
                        int var158 = 5 - playerClock % 5;
                        if (playerClock % 2 == 0) {
                            workingGraphics.setColor(Color.lightGray);
                        }

                        workingGraphics.drawOval(ballX - 2 - var158, ballY - var158 / 2, var158 * 2, var158);
                    } else {
                        int var159 = playerClock * 8;
                        workingGraphics.setColor(Color.black);
                        workingGraphics.drawOval(ballX - var159 / 2, ballY - var159 / 4, var159, var159 / 2);
                    }
                }

                button = 0;
                workingGraphics.setColor(Color.black);
                if (ballInFlight == 1) {
                    if (bounced == 0) {
                        lastsfx = 0;
                    }

                    if (aniClock % 4 == 0) {
                        ++ballGravity;
                    }

                    ballZ += ballGravity;
                    if (ballZ > 0) {
                        if (onGreen == 0) {
                            sandchk = ballGravity;
                        }

                        if (club > 12) {
                            ballGravity = -ballGravity / 4;
                        }

                        if (club < 12) {
                            ballGravity = -ballGravity / 8;
                        }

                        ballZ = 0;
                        ++bounced;
                        picked = 0;
                        button = 1;
                        if (bounced > 1) {
                            switch (ballIsOn) {
                                case 1:
                                    ballTimeOut -= 5;
                                case 2:
                                default:
                                    break;
                                case 3:
                                    --ballTimeOut;
                                    break;
                                case 4:
                                    if (magSelected == 0) {
                                        --ballTimeOut;
                                    }
                                    break;
                                case 5:
                                    ballTimeOut -= 2;
                                    break;
                                case 6:
                                    ballTimeOut -= 5;
                            }
                        }

                        if (inSand == 1 && onGreen == 0) {
                            --ballTimeOut;
                        }

                        if (inRough == 1 && onGreen == 0) {
                            --ballTimeOut;
                        }
                    }

                    if (club != 12 && magSelected == 0 && ballZ < 0) {
                        ballDX += windDX * 15 * ballTime / 60;
                        ballDY += windDY * 15 * ballTime / 60;
                    }

                    if (onGreen == 1 && ballZ == 0) {
                        ballDX += slopeDX * 10 * ballTime / 60;
                        ballDY += slopeDY * 10 * ballTime / 60;
                    }

                    ballX = baseX + ballDX / (100 - slower) * ballTime / 60;
                    ballY = baseY + ballDY / (100 - slower) * ballTime / 60;
                    magBallX = magBaseX + 2 * ballDX / (100 - slower) * ballTime / 60;
                    magBallY = magBaseY + 2 * ballDY / (100 - slower) * ballTime / 60;
                    if (slower > 0) {
                        --slower;
                    }

                    if (magSelected == 1 && (ballY - pinY) * (ballY - pinY) + (ballX - pinX) * (ballX - pinX) < 3 && ballTime > ballTimeOut - 10) {
                        inHole = 1;
                        ballTime = ballTimeOut;
                    }

                    if (magSelected == 1 && (ballY - pinY) * (ballY - pinY) + (ballX - pinX) * (ballX - pinX) < 3 && ballDX * ballDX + ballDY * ballDY < 3500000) {
                        inHole = 1;
                        ballTime = ballTimeOut;
                    }

                    if (magSelected == 0 && (ballY - pinY) * (ballY - pinY) + (ballX - pinX) * (ballX - pinX) < 3 && ballTime > ballTimeOut - 4) {
                        inHole = 1;
                        ballTime = ballTimeOut;
                    }

                    if (inLake == 1) {
                        sfxque[sfxin] = 4;
                        sfxin = (sfxin + 1) % 8;
                        ballTime = ballTimeOut;
                    }

                    if (inSand == 1 && bounced == 1 && sandchk != 0) {
                        ballTime = ballTimeOut;
                        sandPlug = 1;
                        if (sandchk < 5) {
                            sandPlug = 0;
                        }
                    }

                    if (inLake == 0 && inSand == 1 && bounced < 3 && onGreen == 0) {
                        sfxque[sfxin] = 3;
                        sfxin = (sfxin + 1) % 8;
                    }

                    ++ballTime;
                    if (magSelected == 1) {
                        ++ballTime;
                    }

                    if (ballTime > ballTimeOut && bounced > 0) {
                        aniClock = 0;
                        picked = 0;
                        ballInFlight = 0;
                        ballZ = 0;
                        button = 1;
                        lakeDX = ballDX;
                        lakeDY = ballDY;
                        if (inHole == 0 && inLake == 0) {
                            newPlayer = 1;
                        }

                        if (inLake == 1) {
                            playerClock = 20;
                            infoBox = 1;
                        }

                        if (ballX > 600 || ballX < 0 || ballY > 250 || ballY < 0) {
                            outOfBounds = 1;
                            int var10002 = playerStrokes[player]++;
                        }
                    }
                }

                if (ballInFlight == 0 && inHole == 1) {
                    sfxque[sfxin] = 5;
                    sfxin = (sfxin + 1) % 8;
                    bigRefresh = 1;
                    switch (player) {
                        case 1:
                            player1Par[hole] = playerStrokes[player];
                            break;
                        case 2:
                            player2Par[hole] = playerStrokes[player];
                            break;
                        case 3:
                            player3Par[hole] = playerStrokes[player];
                            break;
                        case 4:
                            player4Par[hole] = playerStrokes[player];
                    }

                    infoBox = 1;
                    ballX = 999;
                    ballY = 999;
                    newPlayer = 1;
                    int var160 = 0;
                    if (player1Par[hole] != 0) {
                        ++var160;
                    }

                    if (player2Par[hole] != 0) {
                        ++var160;
                    }

                    if (player3Par[hole] != 0) {
                        ++var160;
                    }

                    if (player4Par[hole] != 0) {
                        ++var160;
                    }

                    if (var160 == numOfPlayers) {
                        ballIsOn = 8;
                        ++hole;
                        newCard = 1;
                        playerClock = 0;
                        bigRefresh2 = 1;
                        newCardRefresh = 1;
                        time2read = 1;
                        if (hole > 9) {
                            gameOver = 1;
                            time2read = 0;
                        }
                    }

                    inHole = 0;
                    ballIsOn = 0;
                }

                for (int var161 = 1; var161 < numOfPlayers + 1; ++var161) {
                    if (player != var161 && playerBallX[var161] != teeX && playerBallY[var161] != teeY) {
                        if (magSelected == 1) {
                            magX = (playerBallX[var161] - pinX) * 2 + 300;
                            magY = (playerBallY[var161] - pinY) * 2 + 125;
                            workingGraphics.setColor(Color.gray);
                            workingGraphics.fillOval(magX - 3, magY - 2, 5, 5);
                            workingGraphics.setColor(Color.lightGray);
                            workingGraphics.fillOval(magX - 2, magY - 2, 4, 4);
                            workingGraphics.setColor(Color.white);
                            workingGraphics.fillOval(magX - 1, magY - 2, 3, 3);
                        }

                        if (magSelected == 0) {
                            workingGraphics.setColor(Color.gray);
                            workingGraphics.fillOval(playerBallX[var161] - 3, playerBallY[var161] - 2, 5, 5);
                            workingGraphics.setColor(Color.lightGray);
                            workingGraphics.fillOval(playerBallX[var161] - 2, playerBallY[var161] - 2, 4, 4);
                            workingGraphics.setColor(Color.white);
                            workingGraphics.fillOval(playerBallX[var161] - 1, playerBallY[var161] - 2, 3, 3);
                        }
                    }
                }

                if (magSelected == 0) {
                    if (ballInFlight == 0 && button == 0 && newPlayer == 0 && inLake == 0 && outOfBounds == 0 && playerClock == 0) {
                        workingGraphics.setColor(Color.black);
                        workingGraphics.drawLine(ballX, ballY, ballX + bpX, ballY + bpY / 2);
                        workingGraphics.fillOval(ballX + bpX - 2, ballY + bpY / 2 - 2, 5, 5);
                    }

                    if (ballInFlight == 1) {
                        workingGraphics.setColor(Color.darkGray);
                        workingGraphics.fillOval(ballX - 3, ballY - 2, 5, 5);
                    }

                    if (inLake == 0) {
                        int var181 = 5 - ballZ / 8;
                        workingGraphics.setColor(Color.gray);
                        workingGraphics.fillOval(ballX - var181 / 2 - 2, ballY - var181 / 2 + ballZ, var181, var181);
                        workingGraphics.setColor(Color.lightGray);
                        workingGraphics.fillOval(ballX - var181 / 2 - 1, ballY - var181 / 2 + ballZ, var181 - 1, var181 - 1);
                        workingGraphics.setColor(Color.white);
                        workingGraphics.fillOval(ballX - var181 / 2, ballY - var181 / 2 + ballZ, var181 - 2, var181 - 2);
                    }

                    if (ballY < pinY) {
                        workingGraphics.setColor(Color.black);
                        workingGraphics.fillRect(pinX - 1, pinY - 1, 3, 2);
                        workingGraphics.setColor(Color.yellow);
                        workingGraphics.fillRect(pinX, pinY - 10, 1, 10);
                        workingGraphics.setColor(Color.orange);
                        if (windDX > 0) {
                            workingGraphics.fillRect(pinX + 1, pinY - 10, 3, 3);
                        } else {
                            workingGraphics.fillRect(pinX - 3, pinY - 10, 3, 3);
                        }
                    }
                } else {
                    if (ballInFlight == 0) {
                        magBallX = (ballX - pinX) * 2 + 300;
                        magBallY = (ballY - pinY) * 2 + 125;
                    }

                    magX = magBallX;
                    magY = magBallY;
                    if (ballInFlight == 0 && button == 0 && newPlayer == 0 && inLake == 0 && outOfBounds == 0 && playerClock == 0) {
                        workingGraphics.setColor(Color.black);
                        workingGraphics.drawLine(magX, magY, magX + bpX / 2, magY + bpY / 4);
                        workingGraphics.fillOval(magX + bpX / 2 - 2, magY + bpY / 4 - 2, 5, 5);
                    }

                    workingGraphics.setColor(Color.gray);
                    workingGraphics.fillOval(magX - 3, magY - 2, 5, 5);
                    workingGraphics.setColor(Color.lightGray);
                    workingGraphics.fillOval(magX - 2, magY - 2, 4, 4);
                    workingGraphics.setColor(Color.white);
                    workingGraphics.fillOval(magX - 1, magY - 2, 3, 3);
                }

                workingGraphics.setColor(Color.black);
                workingGraphics.drawString("Refresh", 5, 14);
                if (playerClock > 0 && gameOver == 0) {
                    bigRefresh2 = 1;
                    bigRefresh = 1;
                    if (inLake == 0 && outOfBounds == 0) {
                        workingGraphics.setColor(Color.black);
                        workingGraphics.drawString("Club", 11, 248);
                        workingGraphics.drawString("Lie", 64, 248);
                        workingGraphics.drawString("Swing", 108, 248);
                        workingGraphics.drawString("Wind", 161, 248);
                        workingGraphics.drawString("Slope", 211, 248);
                        workingGraphics.setColor(Color.white);
                        workingGraphics.drawString("Club", 10, 247);
                        workingGraphics.drawString("Lie", 63, 247);
                        workingGraphics.drawString("Swing", 107, 247);
                        workingGraphics.drawString("Wind", 160, 247);
                        workingGraphics.drawString("Slope", 210, 247);
                    }

                    --playerClock;
                    if (playerClock == 0) {
                        bigRefresh = 1;
                    }

                    if (playerClock == 4 && inLake == 1) {
                        ballX = baseX;
                        ballY = baseY;
                        sfxque[sfxin] = 1;
                        sfxin = (sfxin + 1) % 8;
                        inLake = 0;
                        picked = 0;
                        button = 1;
                        playerClock = 20;
                        int var283 = playerStrokes[player]++;
                        infoBox = 1;
                    }

                    if (playerClock == 4 && outOfBounds == 1) {
                        ballX = baseX;
                        ballY = baseY;
                        sfxque[sfxin] = 1;
                        sfxin = (sfxin + 1) % 8;
                        outOfBounds = 0;
                        picked = 0;
                        button = 1;
                        playerClock = 20;
                        infoBox = 1;
                    }

                    if (playerClock < 19) {
                        if (inLake == 1 || outOfBounds == 1) {
                            workingGraphics.setColor(new Color(180, 80, 40));
                            workingGraphics.fillRect(0, 228, 600, 20);
                            if (inLake == 1) {
                                workingGraphics.setColor(Color.black);
                                workingGraphics.drawString("Water Hazzard:  1 stroke penalty", 201, 244);
                                workingGraphics.setColor(Color.white);
                                workingGraphics.drawString("Water Hazzard:  1 stroke penalty", 200, 243);
                            }

                            if (outOfBounds == 1) {
                                workingGraphics.setColor(Color.black);
                                workingGraphics.drawString("Out of Bounds:  1 stroke penalty", 201, 244);
                                workingGraphics.setColor(Color.white);
                                workingGraphics.drawString("Out of Bounds:  1 stroke penalty", 200, 243);
                            }

                            workingGraphics.setColor(Color.white);
                            workingGraphics.drawRect(0, 228, 599, 22);
                            workingGraphics.setColor(Color.lightGray);
                            workingGraphics.drawRect(1, 229, 597, 20);
                            workingGraphics.setColor(Color.gray);
                            workingGraphics.drawRect(2, 230, 595, 18);
                        }

                        if (outOfBounds == 0 && inLake == 0) {
                            workingGraphics.setColor(info1);
                            workingGraphics.fillRect(0, 86, 600, 20);
                            switch (player) {
                                case 1:
                                    tname = p1name;
                                    break;
                                case 2:
                                    tname = p2name;
                                    break;
                                case 3:
                                    tname = p3name;
                                    break;
                                case 4:
                                    tname = p4name;
                            }

                            if (onGreen == 1 && playerStrokes[player] + 1 < holePars[hole + holebase] + 9) {
                                String var182 = "";
                                if (playerStrokes[player] + 1 == holePars[hole + holebase] - 2) {
                                    var182 = "an EAGLE";
                                }

                                if (playerStrokes[player] + 1 == holePars[hole + holebase] - 1) {
                                    var182 = "a BIRDIE";
                                }

                                if (playerStrokes[player] + 1 == holePars[hole + holebase]) {
                                    var182 = "PAR";
                                }

                                if (playerStrokes[player] + 1 == holePars[hole + holebase] + 1) {
                                    var182 = "BOGEY";
                                }

                                if (playerStrokes[player] + 1 == holePars[hole + holebase] + 2) {
                                    var182 = "DOUBLE-BOGEY";
                                }

                                if (holePars[hole + holebase] == 3 && playerStrokes[player] + 1 == holePars[hole + holebase] + 3) {
                                    var182 = "DOUBLE-PAR!!";
                                }

                                if (holePars[hole + holebase] > 3 && playerStrokes[player] + 1 == holePars[hole + holebase] + 3) {
                                    var182 = "TRIPLE-BOGEY!!!";
                                }

                                if (holePars[hole + holebase] == 4 && playerStrokes[player] + 1 == holePars[hole + holebase] + 4) {
                                    var182 = "DOUBLE-PAR!!";
                                }

                                if (holePars[hole + holebase] > 4 && playerStrokes[player] + 1 == holePars[hole + holebase] + 4) {
                                    var182 = "FOUR-OVER-PAR!!!!";
                                }

                                if (holePars[hole + holebase] == 5 && playerStrokes[player] + 1 == holePars[hole + holebase] + 5) {
                                    var182 = "DOUBLE-PAR!!";
                                }

                                if (holePars[hole + holebase] < 5 && playerStrokes[player] + 1 == holePars[hole + holebase] + 5) {
                                    var182 = "FIVE-OVER-PAR!!!!!";
                                }

                                if (holePars[hole + holebase] == 3 && playerStrokes[player] + 1 == holePars[hole + holebase] + 6) {
                                    var182 = "TRIPLE-PAR!!!";
                                }

                                if (holePars[hole + holebase] > 3 && playerStrokes[player] + 1 == holePars[hole + holebase] + 6) {
                                    var182 = "SIX-OVER-PAR!!!!!";
                                }

                                if (playerStrokes[player] + 1 == holePars[hole + holebase] + 7) {
                                    var182 = "SEVEN-OVER-PAR!!!!!!!";
                                }

                                if (playerStrokes[player] + 1 == holePars[hole + holebase] + 8) {
                                    var182 = "EIGHT-OVER-PAR!!!!!!!!";
                                }

                                workingGraphics.setColor(Color.black);
                                workingGraphics.drawString(tname + "'s TURN" + "     Stroke " + (playerStrokes[player] + 1) + " for " + var182, 201, 101);
                                workingGraphics.setColor(Color.white);
                                workingGraphics.drawString(tname + "'s TURN" + "     Stroke " + (playerStrokes[player] + 1) + " for " + var182, 200, 100);
                            } else {
                                workingGraphics.setColor(Color.black);
                                workingGraphics.drawString(tname + "'s TURN" + "     Stroke " + (playerStrokes[player] + 1), 201, 101);
                                workingGraphics.setColor(Color.white);
                                workingGraphics.drawString(tname + "'s TURN" + "     Stroke " + (playerStrokes[player] + 1), 200, 100);
                            }

                            workingGraphics.setColor(Color.white);
                            workingGraphics.drawRect(0, 84, 599, 22);
                            workingGraphics.setColor(Color.lightGray);
                            workingGraphics.drawRect(1, 85, 597, 20);
                            workingGraphics.setColor(Color.gray);
                            workingGraphics.drawRect(2, 86, 595, 18);
                        }
                    }
                }

                if (bigRefresh2 == 1 || ballInFlight == 1) {
                    bigRefresh2 = 0;
                    g.drawImage(working, 0, 0, null);
                }

                if (newCard == 0 && keyFace == 0 && ballInFlight == 0) {
                    boolean var282 = true;
                } else {
                    boolean var281 = false;
                }

                workingGraphics.dispose();
                goldGraphics.dispose();
            }
        }
    }

    public void run() {
        //if (redball != 0) continue;
        //this.repaint();
        this.paint(this.getGraphics());
    }

    public synchronized boolean mouseDown(Event event, int x, int y) {
        boolean b = false;
        if (leaderBoard == 0 && newCard == 1 && y < 250 && keyFace == 0) {
            leaderBoard = 1;
            leaderRefresh = 1;
            newCard = 0;
            b = true;
        }

        if (leaderBoard == 1 && y < 250 && !b) {
            leaderBoard = 0;
            newCard = 1;
            newCardRefresh = 1;
            infoBox = 1;
        }

        if (keyFace == 1) {
            keyRefresh = 1;
            if (x > 550 && x < 570 && y > 40 && y < 60 && !tname.isEmpty()) {
                tname = tname.substring(0, tname.length() - 1);
            }

            if ((x > 490 && x < 590 && y > 175 && y < 195 || x > 360 && x < 460 &&
                    y > 175 && y < 195) && p1name.length() > 1 && p2name.length() != 1 &&
                    p3name.length() != 1 && p4name.length() != 1) {
                keyFace = 0;
                player = 1;
                playerClock = 20;
                numOfPlayers = 1;
                if (!p2name.isEmpty()) {
                    ++numOfPlayers;
                }

                if (!p3name.isEmpty()) {
                    ++numOfPlayers;
                }

                if (!p4name.isEmpty()) {
                    ++numOfPlayers;
                }

                player1Total = 0;
                player2Total = 0;
                player3Total = 0;
                player4Total = 0;

                for (int psIndex = 1; psIndex < 19; ++psIndex) {
                    player1Par[psIndex] = 0;
                    player2Par[psIndex] = 0;
                    player3Par[psIndex] = 0;
                    player4Par[psIndex] = 0;
                }

                if (p2name.isEmpty() && (!p3name.isEmpty() || !p4name.isEmpty())) {
                    keyFace = 1;
                    if (p3name.isEmpty()) {
                        player = 2;
                        p2name = p4name;
                        tname = p2name;
                    } else {
                        player = 3;
                        p2name = p3name;
                        p3name = p4name;
                        tname = p3name;
                        if (p3name.isEmpty()) {
                            player = 2;
                            tname = p2name;
                        }
                    }

                    p4name = "";
                }

                if (p3name.isEmpty() && !p4name.isEmpty()) {
                    player = 3;
                    keyFace = 1;
                    p3name = p4name;
                    tname = p3name;
                    p4name = "";
                }

                if (keyFace == 0) {
                    holebase = 0;
                    if (x > 490) {
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
                    sfxque[sfxin] = 1;
                    sfxin = (sfxin + 1) % 8;
                }
            }

            if (x > 8 && x < 585 && y > 84 && y < 103) {
                player = 1;
                tname = p1name;
            }

            if (x > 8 && x < 585 && y > 105 && y < 124 && p1name.length() > 1) {
                player = 2;
                tname = p2name;
            }

            if (x > 8 && x < 585 && y > 126 && y < 145 && p2name.length() > 1) {
                player = 3;
                tname = p3name;
            }

            if (x > 8 && x < 585 && y > 147 && y < 166 && p3name.length() > 1) {
                player = 4;
                tname = p4name;
            }

            for (int i = 1; i < 27; ++i) {
                if (x > i * 20 && x < i * 20 + 20 && y > 50 && y < 70 && tname.length() < 10) {
                    switch (i) {
                        case 1:
                            tname += "A";
                            break;
                        case 2:
                            String var31 = tname;
                            tname = var31 + "B";
                            break;
                        case 3:
                            String var30 = tname;
                            tname = var30 + "C";
                            break;
                        case 4:
                            String var29 = tname;
                            tname = var29 + "D";
                            break;
                        case 5:
                            String var28 = tname;
                            tname = var28 + "E";
                            break;
                        case 6:
                            String var27 = tname;
                            tname = var27 + "F";
                            break;
                        case 7:
                            String var26 = tname;
                            tname = var26 + "G";
                            break;
                        case 8:
                            String var25 = tname;
                            tname = var25 + "H";
                            break;
                        case 9:
                            String var24 = tname;
                            tname = var24 + "I";
                            break;
                        case 10:
                            String var23 = tname;
                            tname = var23 + "J";
                            break;
                        case 11:
                            String var22 = tname;
                            tname = var22 + "K";
                            break;
                        case 12:
                            String var21 = tname;
                            tname = var21 + "L";
                            break;
                        case 13:
                            String var20 = tname;
                            tname = var20 + "M";
                            break;
                        case 14:
                            String var19 = tname;
                            tname = var19 + "N";
                            break;
                        case 15:
                            String var18 = tname;
                            tname = var18 + "O";
                            break;
                        case 16:
                            String var17 = tname;
                            tname = var17 + "P";
                            break;
                        case 17:
                            String var16 = tname;
                            tname = var16 + "Q";
                            break;
                        case 18:
                            String var15 = tname;
                            tname = var15 + "R";
                            break;
                        case 19:
                            String var14 = tname;
                            tname = var14 + "S";
                            break;
                        case 20:
                            String var13 = tname;
                            tname = var13 + "T";
                            break;
                        case 21:
                            String var12 = tname;
                            tname = var12 + "U";
                            break;
                        case 22:
                            String var11 = tname;
                            tname = var11 + "V";
                            break;
                        case 23:
                            String var10 = tname;
                            tname = var10 + "W";
                            break;
                        case 24:
                            String var9 = tname;
                            tname = var9 + "X";
                            break;
                        case 25:
                            String var8 = tname;
                            tname = var8 + "Y";
                            break;
                        case 26:
                        default:
                            tname += "Z";
                    }
                }

                if (x > i * 20 && x < i * 20 + 20 && y > 30 && y < 50 && tname.length() < 10) {
                    switch (i) {
                        case 1:
                            tname += "a";
                            break;
                        case 2:
                            tname += "b";
                            break;
                        case 3:
                            tname += "c";
                            break;
                        case 4:
                            tname += "d";
                            break;
                        case 5:
                            tname += "e";
                            break;
                        case 6:
                            tname += "f";
                            break;
                        case 7:
                            tname += "g";
                            break;
                        case 8:
                            tname += "h";
                            break;
                        case 9:
                            tname += "i";
                            break;
                        case 10:
                            tname += "j";
                            break;
                        case 11:
                            tname += "k";
                            break;
                        case 12:
                            tname += "l";
                            break;
                        case 13:
                            tname += "m";
                            break;
                        case 14:
                            tname += "n";
                            break;
                        case 15:
                            tname += "o";
                            break;
                        case 16:
                            tname += "p";
                            break;
                        case 17:
                            tname += "q";
                            break;
                        case 18:
                            tname += "r";
                            break;
                        case 19:
                            tname += "s";
                            break;
                        case 20:
                            tname += "t";
                            break;
                        case 21:
                            tname += "u";
                            break;
                        case 22:
                            tname += "v";
                            break;
                        case 23:
                            tname += "w";
                            break;
                        case 24:
                            tname += "x";
                            break;
                        case 25:
                            tname += "y";
                            break;
                        case 26:
                        default:
                            tname += "z";
                    }
                }
            }

            return true;
        } else {
            if (x > 0 && y > 0 && x < 50 && y < 14 && ballInFlight == 0 && newCard == 0) {
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
                sfxque[sfxin] = 3;
                sfxin = (sfxin + 1) % 8;
            }

            if (x > 500 && y > 255 && x < 590 && y < 294 && (newCard == 1 || leaderBoard == 1)) {
                sfxque[sfxin] = 4;
                sfxin = (sfxin + 1) % 8;
                newCard = 0;
                leaderBoard = 0;
                keyFace = 1;
                keyRefresh = 1;
                tname = p1name;
                player = 1;
            }

            if (x > 260 && y > 255 && x < 350 && y < 294 && (newCard == 1 || leaderBoard == 1) && gameOver == 0) {
                sfxque[sfxin] = 2;
                sfxin = (sfxin + 1) % 8;
                newCard = 0;
                leaderBoard = 0;
                infoBox = 1;
            }

            if (x > 260 && y > 255 && x < 380 && y < 294 && (newCard == 1 || leaderBoard == 1) && gameOver == 1) {
                reportIn = 1;
                newCard = 0;
                leaderBoard = 1;
                leaderRefresh = 1;
            }

            if (y < 250 && aniClock > 10 && newCard == 0) {
                aimX = x;
                aimY = y;
                bigRefresh = 1;
            }

            if (x > 0 && y > 250 && x < 50 && y < 299 && ballInFlight == 0 && newCard == 0) {
                rangeClock = 20;
                bigRefresh = 1;
            }

            if (x > 4 && y > 285 && x < 24 && y < 297 && newCard == 0 && ballInFlight == 0) {
                --club;
                if (club < 2) {
                    club = 15;
                }

                newClub = 1;
                rangeClock = 20;
                bigRefresh = 1;
            }

            if (x > 27 && y > 285 && x < 47 && y < 297 && newCard == 0 && ballInFlight == 0) {
                ++club;
                if (club > 15) {
                    club = 2;
                }

                newClub = 1;
                rangeClock = 20;
                bigRefresh = 1;
            }

            if (x > 100 && y > 250 && x < 150 && y < 299 && ballInFlight == 0 && inLake == 0 && newPlayer == 0 && aniClock > 20 && newCard == 0) {
                ballInFlight = 1;
                ballDX = ballDX * globalSize * 2;
                ballDY = ballDY * globalSize * 2;
                if (club != 12) {
                    ballDX += rand.nextInt(8) - 3;
                    ballDY += rand.nextInt(8) - 3;
                } else {
                    ballDX += rand.nextInt(4) - 1;
                    ballDY += rand.nextInt(4) - 1;
                }

                int var5 = 100;
                switch (ballIsOn) {
                    case 0:
                    case 3:
                        var5 = 100;
                        break;
                    case 1:
                        var5 = 120;
                        if (sandPlug == 1) {
                            var5 = 130 + rand.nextInt(21);
                        }
                    case 2:
                    default:
                        break;
                    case 4:
                        var5 = 100;
                        break;
                    case 5:
                        var5 = 110;
                        break;
                    case 6:
                        var5 = 120 + rand.nextInt(41);
                }

                ballDX = ballDX * 3 * (power + 1) / var5;
                ballDY = ballDY * 3 * (power + 1) / var5;
                ballDY /= 2;
                baseDX = ballDX;
                baseDY = ballDY;
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
                    sfxque[sfxin] = 2;
                    sfxin = (sfxin + 1) % 8;
                    ballGravity = 0;
                }

                ballZ = 0;
                lastsfx = 0;
                if (club != 12 && inSand == 1) {
                    sfxque[sfxin] = 3;
                    sfxin = (sfxin + 1) % 8;
                }

                if (club != 12 && inSand == 0) {
                    sfxque[sfxin] = 1;
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
                playerStrokes[player]++;
            }

            return true;
        }
    }
}
