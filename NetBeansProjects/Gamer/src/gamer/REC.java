package gamer;

import java.io.IOException;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import javax.sound.sampled.LineUnavailableException;

public class REC extends Thread{
	/**
	 * Constructor
     * @throws javax.sound.sampled.LineUnavailableException
	 */
	public REC() throws LineUnavailableException {
		Main.configuration = new Configuration();
		Main.configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		Main.configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		Main.configuration.setGrammarPath("resource:/grammars");
		Main.configuration.setGrammarName("grammar");
		Main.configuration.setUseGrammar(true);
                try {
			Main.recognizer = new LiveSpeechRecognizer(Main.configuration);
		} catch (IOException ex) {
			//logger.log(Level.SEVERE, null, ex);
		}
		Main.recognizer.startRecognition(true);                
	}

       // @Override
	public void run()
        {	
		    //logger.log(Level.INFO, "You can start to speak...\n");
                    while(true)
                    {
		    try 
                    {
                        //while(Main.pause==true)
                        {
                        Main.speechResult = Main.recognizer.getResult();
                        while (Main.speechResult != null&&Main.pause==true) 
                        {
                            Main.result = Main.speechResult.getHypothesis();
                            System.out.println(Main.result);
                            System.gc();
                            break;     
                        } 
                        }
                    }
                        catch (Exception ex) {
				//logger.log(Level.WARNING, null, ex);
			}
	}
        
        }

}