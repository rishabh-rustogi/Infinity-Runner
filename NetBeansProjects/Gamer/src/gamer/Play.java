package gamer;

import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

class Play extends Thread
{
    Character player;
    Texture texture1, texture2, texture3, down_small, down_med, down_big, up_small, up_med, up_big, score,spikes,spikes1,one,two,three,b1,b2;
    int nblock,wid,counter,save,run_pose,jumpy,outx1,outx2,outx3,once,trigger;
    double framerate,x1,x2,x3,x11,x31,add,add1,bspeed,del,del1,x4,x5,x6,x41,x51,cc;
    public static double count;
    long t1;
    double t;
    boolean pause1,pause2;
    boolean done,out;
    String ch,ch1;
    public static int jump,early;
    int start;
    int upd;
    int s1,s2,change;
    int gap=100;
    int gap1=-20;
    ArrayList<Integer> lblock = new ArrayList<>();
    ArrayList<Integer> ublock = new ArrayList<>();
    static int count_out=0;
    static boolean out_scene=false;
    //private TrueTypeFont font;
    //private Font awtFont;

    public void run() 
    {
        player =new Character();
        try {
            player.init();
        } catch (IOException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }
        counter=0;
        count=0;
        pause2=false;
        framerate=30;
        add=0;
        upd=0;
        add1=0;
        bspeed=1;
        run_pose=0;
        x1 = 0;
        x4=0;
        x11=0;
        x41=0;
        trigger=0;
        x51=1200;
        x31=1200;
        outx3=200;
        start=1;
        s1=-200;
        s2=-200;
        jump=1;
        change=0;
        //x2 = 1;
        x2=16;
        x6=18;
        x3 = 0;
        x5=0;
        out=false;
        nblock = 10;
        jumpy=0;
        pause1 = false;
        done = true;
        ch = "junk";
        ch1="junk";
        del=0;
        del1=0;
        GL11.glColor4f(1f, 1f, 1f, 1f);
        //t1=t = (Sys.getTime() * 1000) / Sys.getTimerResolution();
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }
        init_block();
        init_block1();
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        //awtFont = new Font("Times New Roman",Font.BOLD,24);
        //font=new TrueTypeFont(awtFont,true);
        /*Main.sound="play_s";
        Main.sound_c=true;
        try {
            player.init();
        } catch (IOException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        while (done) 
        {
            try {
                update();
                renderGL();
                Display.update();
                Display.sync(120);
                count++;
            } catch (InterruptedException | IOException ex) {
                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void init() throws IOException 
    {
        texture1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/BG.png"));
        texture2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/BG.png"));
        b1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Play/bg1.png"));
        b2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Play/bg2.png"));
        down_small = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/T1_Small.png"));
        down_med = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/T1_Medium.png"));
        down_big = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/T1_Large.png"));
        up_small = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/T2_Small.png"));
        up_med = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/T2_Medium.png"));
        up_big = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/T2_Large.png"));
        texture3 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/pause1.png"));
        spikes=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/spike3.png"));
        spikes1=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/spike4.png"));
        one = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/one.png"));
        two=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/two.png"));
        three=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/three.png"));
        score=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/score.png"));
        
    }

    void init_block() 
    {
        int i;
        lblock.add(0,3);
        for (i = 1; i < 10; i++) 
        {
            lblock.add(i,1 + (int) (Math.random() * 3));
        }
        lblock.add(8,3);
    }
    void init_block1() 
    {
        int i;
        ublock.add(0,3);
        for (i = 1; i < 10; i++) 
        {
            ublock.add(i,1 + (int) (Math.random() * 3));
        }
        ublock.add(7,3);
    }
    void update() throws InterruptedException, IOException
    {
        
        if(!pause1)
        {
            t=(double)count/(double)framerate;
        }
        
        if (!pause1) 
        {
            if (Main.rms>=0.5)
            {
                pause1 = true;
                Main.pause=true;
                Main.speechResult=null;
            }
        }
        if (!pause1) {
            if ((Main.rms >= 0.1 && Main.rms < 0.45) || trigger != 0) {
                //count = count + 5;
                
                early = jump;
                jump = 2;
                if (trigger != 0) {
                    jump = trigger;
                }
            }
        }
        if(trigger!=0)
        {
            jump=trigger;
            pause1=false;
            pause2=true;
            Main.pause=true;
            Main.speechResult=null;
        }
        if(pause2)
        {
            switch(ch1)
            {
                case "reset":
                    pause1 = false;
                    Main.pause=false;
                    start();
                    break;
                case "menu":
                    done = false;
                    ch = "junk";
                    break;
                default:
                    if (!Main.result.isEmpty()) 
                    {
                        ch1 = Main.result;
                    }
                    break;
            }
        }
        if (pause1) 
        {
            count--;
            switch (ch) 
            {
                case "resume":
                    pause1 = false;
                    Main.pause=false;
                    ch = "junk";
                    break;
                case "reset":
                    pause1 = false;
                    Main.pause=false;
                    start();
                    break;
                case "menu":
                    done = false;
                    ch = "junk";
                    break;
                default:
                    if (!Main.result.isEmpty()) 
                    {
                        ch = Main.result;
                    }
                    break;
            }
        }
        bgupdate1();
        //bgupdate2();
        blocksdown();
        blocksup();
    }
    void bgupdate1()
    {
        x1=(x11-(t*x2));
        x3=(x31-(t*x2));
        if (x1 <= -1198) 
        {
            x11 = x11+2400;
        }
        if (x3 <= -1198) 
        {
            x31=x31+2400;
        }
    }
    /*
    void bgupdate2()
    {
        x4=(x41-(t*x6));
        x5=(x51-(t*x6));
        if (x4 <= -1198) 
        {
            x41 = x41+2400;
        }
        if (x5 <= -1198) 
        {
            x51=x51+2400;
        }
    }
    */
    void blocksdown()
    {
        add=del;
        del=del-bspeed;
    }
    void blocksup()
    {
        add1=del1;
        del1=del1-bspeed;
        if(change==1)
        {
            change=2;
        }
        else
        {
            change=1;
        }
    }
    void renderGL() throws InterruptedException, IOException 
    {
        if (!pause1) 
        {
            bgrender1();
            //bgrender2();
            lowerblock();
            upperblock();
            player.prender(jump,t,bspeed);
        }
        if (pause1) 
        {
            //Score.update(count);
            GL11.glColor4f(1f, 1f, 1f, 1f);
            texture3.bind();
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(0, 750);

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f(1000, 750);

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f(1000, 0);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f(000, 00);
            GL11.glEnd();
            if(upd==0)
            {
                Main.num.print((int)count, 500, 116,50);
            }
            else if(upd==1)
            {
                Main.num.print((int) cc, 500, 116,50);
            }
            ReadJSON.scores();
            Main.num.print(Main.score.get(0), 500, 79,50);
        }
        
        score.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(700, 770);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(800, 770);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(800, 670);

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(700, 670);
        GL11.glEnd();
        Main.num.print((int) count, 810, 690, 50);
        
    }
    void bgrender1()
    {
        texture1.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f((float) x1, 750);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f((float) (x1 + 1200), 750);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f((float) (x1 + 1200), 0);

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f((float) x1, 0);
        GL11.glEnd();

        texture2.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f((float) x3, 750);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f((float) (x3 + 1200), 750);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f((float) (x3 + 1200), 0);

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f((float) x3, 0);
        GL11.glEnd();
    }
/*
    void bgrender2()
    {
        b2.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f((float) x4, 650);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f((float) (x4 + 1200), 650);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f((float) (x4 + 1200), 0);

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f((float) x4, 0);
        GL11.glEnd();

        b2.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f((float) x5, 750);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f((float) (x5 + 1200), 750);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f((float) (x5 + 1200), 0);

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f((float) x5, 0);
        GL11.glEnd();
    }
*/
    void lowerblock()
    {
        for (int i = 0; i < 10; i++) {
            switch (lblock.get(i)) {
                case 1:
                    down_small.bind();
                    wid = (int) (down_small.getImageWidth());
                    break;
                case 2:
                    down_med.bind();
                    wid = (int) (down_med.getImageWidth());
                    break;
                case 3:
                    down_big.bind();
                    wid = (int) (down_big.getImageWidth());
                    break;
            }
            add = (int) (wid + gap + add);
            if (i == 8 && (add - wid - gap) <= 0) {
                del = 0;
                init_block();
                break;
            }
            if (add - gap - wid >= 1100) {
                break;
            }
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f((float) (add - wid - gap), (float) (down_big.getImageHeight() * 0.75));

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f((float) (add - gap), (float) (down_big.getImageHeight() * 0.75));

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f((float) (add - gap), 0);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f((float) (add - gap - wid), 0);
            GL11.glEnd();
            if (jump == 1) 
            {
                if (add - gap <= 201 && add >= 281) {
                    if(upd==0)
                    {
                        cc=count;
                        Score.update(count);
                        upd=1;
                    }
                    trigger = 3;
                }
            }
        }
    }
    void upperblock()
    {
        for (int i = 0; i < 10; i++) {
            switch (ublock.get(i)) {
                case 1:
                    up_small.bind();
                    wid = (int) (down_small.getImageWidth());
                    break;
                case 2:
                    up_med.bind();
                    wid = (int) (down_med.getImageWidth());
                    break;
                case 3:
                    up_big.bind();
                    wid = (int) (down_big.getImageWidth());
                    break;
            }

            add1 = (int) (wid + gap1) + add1;
            if (i == 7 && (add1 - gap1 - wid) <= 0) {
                del1 = 0;
                init_block1();
                break;
            }
            if (add1 - gap1 - wid >= 1100) {
                break;
            }
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f((float) (add1 - wid - gap1), (float) (750 - up_big.getImageHeight() * 0.75));

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f((float) (add1 - gap1), (float) (750 - up_big.getImageHeight() * 0.75));

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f((float) (add1 - gap1), 750);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f((float) (add1 - gap1 - wid), 750);
            GL11.glEnd();
            if (change == 1) {
                spikes.bind();
            } else {
                spikes1.bind();
            }
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f((float) (s1), s2);

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f((float) (s1 + 100), s2);

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f((float) (s1 + 100), s2 - 100);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f((float) (s1), s2 - 100);
            GL11.glEnd();

            s1 = (int) (add1 - gap1 - 50);
            s2 = (int) ((750 - up_big.getImageHeight() * 0.75 * 0.5) + 10);
            if (jump == 5) 
            {
                if (s1-50 <= 201 && s1+50 >= 281) {
                    if(upd==0)
                    {
                        cc=count;
                        Score.update(count);
                        upd=1;
                    }
                    trigger = 4;
                }
            }
        }
    }
}
