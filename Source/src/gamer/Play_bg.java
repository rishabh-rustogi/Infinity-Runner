package gamer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


// Class for various background images
public class Play_bg extends Thread {
    
    
    // Background image holders
    Texture b1,b2,f1,f2,q1,q2;
    int x1,x11, x2,x22, x3,x33, x4,x44;
    boolean pause1;
    
    // Game time variables
    long t,t1;
    
    
    // Main render loop for this class
    public void run()
    {
        
        x1 = 0 ;
        x11=0;
        
        pause1=false;
        x2 = 1;
        x22=1;
        x3 = 2000;
        x33=2000;
        x4 = 1;
        x44=1;
        
        GL11.glColor4f(1f, 1f, 1f, 1f);
        t1=t = (Sys.getTime() * 1000) / Sys.getTimerResolution();
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(Play_bg.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
       
        
        while (true) 
        {
            try {
                update();
                renderGL();
                Display.update();
                Display.sync(120);
            } catch (InterruptedException ex) {
                Logger.getLogger(Play_bg.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Play_bg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Load images in the image holders
    void init() throws IOException 
    {
        b1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Play/bg1.png"));
        b2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Play/bg1.png"));
        f1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Play/bg2.png"));
        f2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Play/bg2.png"));
        q1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Play/BG.png"));
        q2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Play/BG.png"));
    }
    
    void update() throws InterruptedException, IOException
    {
    }
    
    // Render the updated background image in the background
    void renderGL() throws InterruptedException 
    {
        if (!pause1) 
        {
            q1.bind();
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(x1, 750);

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f(x1 + 2000, 750);

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f(x1 + 2000, 0);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f(x1, 0);
            GL11.glEnd();
            
            q2.bind();
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(x3, 750);

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f(x3 + 2000, 750);

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f(x3 + 2000, 0);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f(x3, 0);
            GL11.glEnd();
            
    }
}
}
