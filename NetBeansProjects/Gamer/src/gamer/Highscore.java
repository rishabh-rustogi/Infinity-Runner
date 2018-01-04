package gamer;

import java.io.IOException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

class Highscore {

    Texture texture,high;
            
    public String begin() throws IOException {
        init();
        while(true)
        {
            if(Main.result.equals("menu"))
            {
                return Main.result;
            }
            renderGL();
            Display.update();
            Display.sync(60);
        }
    }
    void init() throws IOException
    {
        texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/high__score.png"));
        //high = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/high_text.png"));
    }
    void renderGL() throws IOException
    {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        texture.bind();
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(0,750);
            
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(1000,750);
            
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(1000,0);
            
            GL11.glTexCoord2f(0,1);
            GL11.glVertex2f(0,0);            
        GL11.glEnd();
        ReadJSON.scores();
        Main.num.print(Main.score.get(0), 480, 370, 60);
        Main.num.print(Main.score.get(1), 480, 250, 60);
        Main.num.print(Main.score.get(2), 480, 142, 60);
    }
}
