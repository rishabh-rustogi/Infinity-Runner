package gamer;

import java.io.IOException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import javax.sound.sampled.LineUnavailableException;

 

public class Check{
    float x, y = 15, t=10;      
    double theta =0,cc;
    double rad,s,c;
    int check=0;
    int count=0;
    int a[]={0,0,0,0};  
    int st=0;
    Texture TD,TT,TF,GD,GT,GF,ID,IT,IF,AD,AT,AF;
    Texture texture,saythis,bar,LeftDown_Default,LeftUp_Default,RightDown_Default,RightUp_Default,LeftDown_True,LeftUp_True,RightDown_True,RightUp_True,LeftDown_False,LeftUp_False,RightDown_False,RightUp_False;   
    public void begin() throws LineUnavailableException, IOException
    {
        init();
        check=0;
        a[0]=0;
        a[1]=0;
        a[2]=0;
        a[3]=0;
        count=0;
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(0.2f, 0.2f, 0.2f, 0.0f);
        while (check!=4) 
        {
            update();
            renderGL();
            Display.update();
            Display.sync(60);
        }
        if(count>=3)
        {
            
        }
        else
        {
            begin();
        }
    }
     
    public void update() throws LineUnavailableException 
    {
                //Main.rec.start();
                try{
                    //m.start();
                    if((!Main.result.isEmpty())&&check<=4)
                    {
                        check++;
                        //System.out.println(Main.result);
                        if(check==1)
                        {
                            if(Main.result.equalsIgnoreCase("this"))
                            {
                                a[1]=1;
                                count++;
                            }
                            else
                            {
                                a[1]=2;
                            }
                        }
                        if(check==2)
                        {
                            if(Main.result.equalsIgnoreCase("game"))
                            {
                                a[0]=1;
                                count++;
                            }
                            else
                            {
                                a[0]=2;
                            }
                        }
                        if(check==3)
                        {
                            if(Main.result.equalsIgnoreCase("is"))
                            {
                                a[2]=1;
                                count++;
                            }
                            else
                            {
                                a[2]=2;
                            }
                        }
                        if(check==4)
                        {
                            if(Main.result.equalsIgnoreCase("awesome"))
                            {
                                a[3]=1;
                                count++;
                            }
                            else
                            {
                                a[3]=2;
                            }
                        }        
                        Main.result="";
                        System.gc();
                    }
                 }
                catch(Exception ex)
                {
                    
                }
                
                theta=theta+(Main.rms*150);
                rad=Math.toRadians(theta);
                x=(float) (55+(50*Math.cos(rad*5)));
    }
    void init() throws IOException {
        texture = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/image2.jpg"));
        saythis = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/say.png"));
        bar = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/bar.png"));
        LeftDown_Default = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/LeftDown_Default.jpg"));
        LeftUp_Default = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/LeftUp_Default.jpg"));
        RightDown_Default = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/RightDown_Default.jpg"));
        RightUp_Default = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/RightUp_Default.jpg"));
        LeftDown_True = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/LeftDown_True.jpg"));
        LeftUp_True = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/LeftUp_True.jpg"));
        RightDown_True = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/RightDown_True.jpg"));
        RightUp_True = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/RightUp_True.jpg"));
        LeftDown_False = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/LeftDown_False.jpg"));
        LeftUp_False = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/LeftUp_False.jpg"));
        RightDown_False = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/RightDown_False.jpg"));
        RightUp_False = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream("res/RightUp_False.jpg"));
        TD = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/This_Default.png"));
        TT = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/This_True.png"));
        TF = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/This_False.png"));
        GD = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/Game_Default.png"));
        GT = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/Game_True.png"));
        GF = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/Game_False.png"));
        ID = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/Is_Default.png"));
        IT = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/Is_True.png"));
        IF = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/Is_False.png"));
        AD = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/Awesome_Default.png"));
        AT = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/Awesome_True.png"));
        AF = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Start/Awesome_False.png"));      
    }
    
    public double blue(float t)
    {
        return t*Math.abs(Math.sin(Main.rms));
    }
    public void renderGL() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(0.2f, 0.2f, 0.2f, 0.0f);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        texture.bind();
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(244,750);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(756,750);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(756,632);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(244,632);            
        GL11.glEnd();
        
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        saythis.bind();
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(20,600);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(20+saythis.getTextureWidth()-28,600);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(20+saythis.getTextureWidth()-28,600-saythis.getImageHeight()+14);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(20,600-saythis.getImageHeight()+14);
            
        GL11.glEnd();
        
        switch(a[1])
        {
            case 0 : TD.bind();
                     break;
            case 1 : TT.bind();
                     break;
            case 2 : TF.bind();
                     break;
            default : TD.bind();
                      break;
        }
              GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(255-20,600);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(255-20+200,600);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(255-20+200,600-60);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(255-20,600-60);
            
        GL11.glEnd();
        switch(a[0])
        {
            case 0 : GD.bind();
                     break;
            case 1 : GT.bind();
                     break;
            case 2 : GF.bind();
                     break;
            default : GD.bind();
                      break;
        }
              GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(410,600);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(410+200-5,600);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(410+200-5,600-60);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(410,600-60);
            
        GL11.glEnd();
        switch(a[2])
        {
            case 0 : ID.bind();
                     break;
            case 1 : IT.bind();
                     break;
            case 2 : IF.bind();
                     break;
            default : ID.bind();
                      break;
        }
              GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(580-40,600-2);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(580-40+200-5,600-2);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(580-40+200-5,600-60-2);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(580-40,600-60-2);
            
        GL11.glEnd();
        switch(a[3])
        {
            case 0 : AD.bind();
                     break;
            case 1 : AT.bind();
                     break;
            case 2 : AF.bind();
                     break;
            default : AD.bind();
                      break;
        }
              GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(690-40,600-1);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(690-40+340,600-1);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(690-40+340,600-60-1);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(690-40,600-60-1);
            
        GL11.glEnd();
        
        
        switch(a[0])
        {
            case 0 : LeftDown_Default.bind();
                     break;
            case 1 : LeftDown_True.bind();
                     break;
            case 2 : LeftDown_False.bind();
                     break;
            default : LeftDown_Default.bind();
                      break;
        }
              GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(500-LeftDown_Default.getTextureWidth()-5,LeftDown_Default.getImageHeight()+10+10-5);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(500-5,LeftDown_Default.getImageHeight()+10+10-5);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(500-5,0+10+10-5);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(500-5-LeftDown_Default.getTextureWidth(),0+10+10-5);
            
        GL11.glEnd();
        
        switch(a[1])
        {
            case 0 : LeftUp_Default.bind();
                     break;
            case 1 : LeftUp_True.bind();
                     break;
            case 2 : LeftUp_False.bind();
                     break;
            default : LeftUp_Default.bind();
                      break;
        }
              GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(500-5-LeftDown_Default.getTextureWidth(),2*LeftDown_Default.getImageHeight()+10+10+5);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(500-5,2*LeftDown_Default.getImageHeight()+10+10+5);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(500-5,LeftDown_Default.getImageHeight()+10+10+5);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(500-5-LeftDown_Default.getTextureWidth(),LeftDown_Default.getImageHeight()+10+10+5);
            
        GL11.glEnd();
        
        switch(a[2])
        {
            case 0 : RightDown_Default.bind();
                     break;
            case 1 : RightDown_True.bind();
                     break;
            case 2 : RightDown_False.bind();
                     break;
            default : RightDown_Default.bind();
                      break;
        }
              GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(500+5,RightDown_Default.getImageHeight()+10+10-5);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(500+5+RightDown_Default.getTextureWidth(),RightDown_Default.getImageHeight()+10+10-5);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(500+5+RightDown_Default.getTextureWidth(),0+10+10-5);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(500+5,+10+10-5);
            
        GL11.glEnd();
        
        switch(a[3])
        {
            case 0 : RightUp_Default.bind();
                     break;
            case 1 : RightUp_True.bind();
                     break;
            case 2 : RightUp_False.bind();
                     break;
            default : RightUp_Default.bind();
                      break;
        }
              GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(500+5,2*RightDown_Default.getImageHeight()+10+10+5);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(500+5+RightDown_Default.getTextureWidth(),2*RightDown_Default.getImageHeight()+10+10+5);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(500+5+RightDown_Default.getTextureWidth(),RightDown_Default.getImageHeight()+10+10+5);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(500+5,LeftDown_Default.getImageHeight()+10+10+5);
            
        GL11.glEnd();
        
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
            s=Math.sin(rad);
            c=Math.cos(rad);
            bar.bind();
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
                GL11.glVertex2f((float) (500-(y*s)-((t/2)*c)), (float) (150+(y*c)-((t/2)*s)));
                GL11.glTexCoord2f(1,0);
                GL11.glVertex2f((float) (500-(y*s)+((t/2)*c)), (float) (150+(y*c)+((t/2)*s)));
                GL11.glTexCoord2f(1,1);
                GL11.glVertex2f((float) (500-(y*s)-(x*s)+((t/2)*c)), (float) (150+(y*c)+(x*c)+((t/2)*s)));
                GL11.glTexCoord2f(0,1);
                GL11.glVertex2f((float) (500-(y*s)-(x*s)-((t/2)*c)), (float) (150+(y*c)+(x*c)-((t/2)*s)));
            GL11.glEnd();
        GL11.glPopMatrix(); 
    }
}