package gamer;

import java.io.IOException;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Character extends Thread
{
    Texture player0,player1,player2,player3,player4,player5,player6,player7,player8,player9;
    Texture playerj0,playerj1,playerj2,playerj3,playerj4,playerj5,playerj6,playerj7,playerj8,playerj9;
    Texture playerd0,playerd1,playerd2,playerd3,playerd4,playerd5,playerd6,playerd7,playerd8,playerd9;
    Texture end,high;
    Texture down_small;
    int update1=0,update2=0,update3=0;
    static double time=0;
    int i=0;
    int cc,upd=0;
    void init() throws IOException
    {
        update1=0;
        update2=0;
        update3=0;
        time=0;
        i=0;
        upd=0;
        player0=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__000.png"));
        player1=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__001.png"));
        player2=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__002.png"));
        player3=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__003.png"));
        player4=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__004.png"));
        player5=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__005.png"));
        player6=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__006.png"));
        player7=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__007.png"));
        player8=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__008.png"));
        player9=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/run/Run__009.png"));
        
        playerj0=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__000.png"));
        playerj1=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__001.png"));
        playerj2=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__002.png"));
        playerj3=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__003.png"));
        playerj4=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__004.png"));
        playerj5=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__005.png"));
        playerj6=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__006.png"));
        playerj7=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__007.png"));
        playerj8=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__008.png"));
        playerj9=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/jump/Jump__009.png"));
        
        playerd0=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__000.png"));
        playerd1=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__001.png"));
        playerd2=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__002.png"));
        playerd3=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__003.png"));
        playerd4=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__004.png"));
        playerd5=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__005.png"));
        playerd6=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__006.png"));
        playerd7=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__007.png"));
        playerd8=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__008.png"));
        playerd9=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dead/Dead__009.png"));
        
        end=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Exit.png"));
        down_small = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/T1_Small.png"));
        //high= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/high_text.png"));
    }
    void prender(int stage,double t,double bspeed) throws IOException
    {
        if(t-time>=0.24)
        {
            time=t;
            update1++;
            update2++;
            if(stage==3 || stage==4)
            {
                update3++;
            }
        }
        if(update1>=10)
        {
            update1=0;
        }
        if(update2>=10)
        {
            update2=0;
        }
        switch (stage) {
            case 1:
                runningd();
                break;
            case 2:
                shift();
                update1 = 0;
                update2 = 0;
                break;
            case 3:
                //update3=0;
                if(upd==0)
                {
                    upd=1;
                    cc=(int)Play.count;
                }
                i++;
                falldown();
                break;
            case 4:
                //update3=0;
                if(upd==0)
                {
                    upd=1;
                    cc=(int)Play.count;
                }
                i++;
                fallup();
                break;
            case 5:
                runningu();
                break;
        }
    }
    void runningd()
    {
        switch (update1) 
            {
            case 0:
                player0.bind();
                break;
            case 1:
                player1.bind();
                break;
            case 2:
                player2.bind();
                break;
            case 3:
                player3.bind();
                break;
            case 4:
                player4.bind();
                break;
            case 5:
                player5.bind();
                break;
            case 6:
                player6.bind();
                break;
            case 7:
                player7.bind();
                break;
            case 8:
                player8.bind();
                break;
            case 9:
                player9.bind();
                break;
            default :
                player9.bind();
        }
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(200, (float) (down_small.getImageHeight() * 0.75) + 100);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(282, (float) (down_small.getImageHeight() * 0.75) + 100);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(282, (float) (down_small.getImageHeight() * 0.75));

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(200, (float) (down_small.getImageHeight() * 0.75));
        GL11.glEnd();
        
    }
    void shift()
    {
        if(Play.early==1)
        {
            Play.jump=5;
        }
        if(Play.early==5)
        {
            Play.jump=1;
        }
    }
    void falldown() throws IOException
    {
        switch (update3) 
            {
            case 0:
                playerd0.bind();
                break;
            case 1:
                playerd1.bind();
                break;
            case 2:
                playerd2.bind();
                break;
            case 3:
                playerd3.bind();
                break;
            case 4:
                playerd4.bind();
                break;
            case 5:
                playerd5.bind();
                break;
            case 6:
                playerd6.bind();
                break;
            case 7:
                playerd7.bind();
                break;
            case 8:
                playerd8.bind();
                break;
            case 9:
                playerd9.bind();
                break;
            default : 
                playerd9.bind();
                break;
        }
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(200, (float) (down_small.getImageHeight() * 0.75) + 100-(update3*10));

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(282, (float) (down_small.getImageHeight() * 0.75) + 100-(update3*10));

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(282, (float) (down_small.getImageHeight() * 0.75)-(update3*10));

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(200, (float) (down_small.getImageHeight() * 0.75)-(update3*10));
        GL11.glEnd();
        if(i>=150)
        {
            i=151;
        GL11.glColor4f(1f, 1f, 1f, 1f);
            end.bind();
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
            Main.num.print(cc, 580, 266,50);
            ReadJSON.scores();
        }
    }
    void fallup() throws IOException
    {
        switch (update3) 
            {
            case 0:
                playerd0.bind();
                break;
            case 1:
                playerd1.bind();
                break;
            case 2:
                playerd2.bind();
                break;
            case 3:
                playerd3.bind();
                break;
            case 4:
                playerd4.bind();
                break;
            case 5:
                playerd5.bind();
                break;
            case 6:
                playerd6.bind();
                break;
            case 7:
                playerd7.bind();
                break;
            case 8:
                playerd8.bind();
                break;
            case 9:
                playerd9.bind();
                break;
            default : 
                playerd9.bind();
                break;
        }
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(200, (float) (750-down_small.getImageHeight() * 0.75) - 100-(update3*10));

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(282, (float) (750-down_small.getImageHeight() * 0.75) - 100-(update3*10));

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(282, (float) (750-down_small.getImageHeight() * 0.75)-(update3*10));

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(200, (float) (750-down_small.getImageHeight() * 0.75)-(update3*10));
        GL11.glEnd();
        if(i>=400)
        {
            i=401;
        GL11.glColor4f(1f, 1f, 1f, 1f);
            end.bind();
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
            Main.num.print(cc, 580, 266,50);
            ReadJSON.scores();
        }
    }
    void runningu()
    {
        switch (update1) 
            {
            case 0:
                player0.bind();
                break;
            case 1:
                player1.bind();
                break;
            case 2:
                player2.bind();
                break;
            case 3:
                player3.bind();
                break;
            case 4:
                player4.bind();
                break;
            case 5:
                player5.bind();
                break;
            case 6:
                player6.bind();
                break;
            case 7:
                player7.bind();
                break;
            case 8:
                player8.bind();
                break;
            case 9:
                player9.bind();
                break;
            default :
                player1.bind();
        }
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(200, (float) (750-down_small.getImageHeight() * 0.75) - 100);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(282, (float) (750-down_small.getImageHeight() * 0.75) - 100);

        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(282, (float) (750-down_small.getImageHeight() * 0.75));

        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(200, (float) (750-down_small.getImageHeight() * 0.75));
        GL11.glEnd();
    }
}
