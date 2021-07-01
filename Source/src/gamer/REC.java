package gamer;

import java.io.IOException;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import javax.sound.sampled.LineUnavailableException;

// Class for voice recognition using CMU Sphinx
public class REC extends Thread{
	public REC() throws LineUnavailableException {
            
                // Voice recognition configuration object
		Main.configuration = new Configuration();
                
                // Set language to english
		Main.configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		Main.configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
                
                // Get voice grammer (from which all words to choose)
		Main.configuration.setGrammarPath("resource:/grammars");
		Main.configuration.setGrammarName("grammar");
		Main.configuration.setUseGrammar(true);
                try {
			Main.recognizer = new LiveSpeechRecognizer(Main.configuration);
		} catch (IOException ex) {
		}
		Main.recognizer.startRecognition(true);                
	}
        // Run the class for recognition
        // @Override
	public void run()
        {	
                    while(true)
                    {
		    try 
                    {
                        {
                        Main.speechResult = Main.recognizer.getResult();
                        while (Main.speechResult != null&&Main.pause==true) 
                        {
                            // Store the result of the recognition in main class variable
                            Main.result = Main.speechResult.getHypothesis();
                            System.out.println(Main.result);
                            System.gc();
                            break;     
                        } 
                        }
                    }
                        catch (Exception ex) {
			}
	}
        
        }

}