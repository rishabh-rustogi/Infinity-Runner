package gamer;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


// Main Class for the Infinity Runner game
public class Main extends Thread {
    
    // Define various objects and variables
    public static AudioFormat fmt = new AudioFormat(44100f, 16, 1, true, false);
    public static final int bufferByteSize = 2048;
    public static int sample;
    Men men = new Men();
    int exit=0;
    public static Number num =new Number();
    Instruction ins = new Instruction();
    Highscore hig = new Highscore();
    public static Configuration configuration;
    public static byte[] buf = new byte[bufferByteSize];
    public static float[] samples = new float[bufferByteSize / 2];
    public static TargetDataLine line;
    public static String choose;
    public static ArrayList<Integer> score = new ArrayList<Integer>();
    public static LiveSpeechRecognizer recognizer;
    public static SpeechResult speechResult;
    public static String result;
    public static int width=1000,height=750;
    long time;
    int delta;
    long lastFrame;
    long fps;
    long lastFPS;
    public static boolean pause=true;
    public static REC rec;
    Play play=new Play();
    Play_bg p_bg = new Play_bg();
    public static float rms = 0f;
    
    public Main() throws LineUnavailableException {
        Main.line = AudioSystem.getTargetDataLine(fmt);
        Main.line.open(fmt, bufferByteSize);
    }
    Check check = new Check();  
    boolean ch;
    public static Intensity intensity;
    
    // Start the game
    public void run()
    {
        try {
            Display.setDisplayMode(new DisplayMode(width,height));
            Display.create();
        } 
        catch (LWJGLException e) {
            System.exit(0);
        }
        
        // Initialize the game screen
        initGL();
        
        // Render page based on class chosen
        while (!Display.isCloseRequested())
        {              
            switch(choose)
            {
                case "check":
                    
                    try {
                        check.begin();
                    }
                    catch (LineUnavailableException | IOException ex )
                    {
                        System.out.println("errooooooor");
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        choose="menu";
                    
                case "menu"  :
                {
                    try
                    {
                        choose=men.begin();
                        Main.result="";
                        break;
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                
                case "play"  :
                        Main.pause=false;
                        Main.speechResult=null;
                        play.run();
                        choose="menu";
                        Main.result="";
                        
                        break;
                case "instructions"  :
                {
                    try
                    {
                        choose=ins.begin();
                        Main.result="";
                        break;
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "high score"  :
                {
                    try
                    {
                        choose=hig.begin();
                        Main.result="";
                        break;
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "exit" :   System.exit(0);
                
                default :   {
                    try
                    {
                        choose=men.begin();
                        Main.result="";
                        break;
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
           
        }
        Display.destroy();
    }
 
    // Intialize the game screen
    public void initGL() 
    {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, width, 0, height, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);                  
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        
    }
    
    // Run the application using multithreading
    public static void main(String[] argv) throws LineUnavailableException, IOException
    {
        // Choose intial screen as "check"
        choose="check";
        
        // Start the game
        Main main = new Main();
        
        // Start the voice recognition class
        rec=new REC();
        
        // Start the voice intensity class
        intensity = new Intensity();
        
        // Sleep initially for the splash screen to load
        try{
            Thread.sleep(2300);
            Fake f = new Fake();
            f.setVisible(true);
            f.dispose();
        }
        
        // In case any errors
        catch(InterruptedException ex) {}
        intensity.start();
        rec.start();
        main.start();
    }
}
