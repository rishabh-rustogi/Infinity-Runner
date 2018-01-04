/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamer;

import java.io.IOException;
import java.util.ArrayList;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author rishabhrustogi
 */
public class Number {
    Texture num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
    int ch;
    Number(){
        ch=0;
    }
    void init() throws IOException
    {
        num0=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/0.png"));
        num1=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/1.png"));
        num2=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/2.png"));
        num3=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/3.png"));
        num4=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/4.png"));
        num5=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/5.png"));
        num6=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/6.png"));
        num7=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/7.png"));
        num8=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/8.png"));
        num9=TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Number/9.png"));
    }
    void print(int num,int x,int y,int size) throws IOException
    {
        if(ch==0)
        {
            init();
            ch=1;
        }
        ArrayList<Integer> fin = new ArrayList<Integer>();
        GL11.glColor4f(1f, 1f, 1f, 1f);
        int digit=0;
        int i=0;
        for(int n=num;n>0;n=n/10)
        {
            digit=n%10;
            fin.add(i, digit);
            i++;
        }
        i--;
        for(;i>=0;i--,x=x+size)
        {
            digit=fin.get(i);
            switch(digit)
            {
                case 0 : num0.bind();
                         break;
                case 1 : num1.bind();
                         break;
                case 2 : num2.bind();
                         break;
                case 3 : num3.bind();
                         break;
                case 4 : num4.bind();
                         break;
                case 5 : num5.bind();
                         break;
                case 6 : num6.bind();
                         break;
                case 7 : num7.bind();
                         break;
                case 8 : num8.bind();
                         break;
                case 9 : num9.bind();
                         break;
                default : num0.bind();
                         break;
            }
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(x,y+size);

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f(x+size,y+size);

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f(x+size,y);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f(x,y);
            GL11.glEnd();
        }
    }
}
