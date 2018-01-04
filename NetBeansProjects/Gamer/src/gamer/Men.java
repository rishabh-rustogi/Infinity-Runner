package gamer;

import java.io.IOException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

class Men {

    Texture texture;
            
    public String begin() throws IOException {
        init();
        while(true)
        {
            if(!Main.result.isEmpty())
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
        texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/menu_fin.png"));
    }
    void renderGL()
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
    }
}
