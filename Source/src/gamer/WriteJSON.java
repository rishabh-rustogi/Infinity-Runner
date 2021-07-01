package gamer;

import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// Class to save the highscores
public class WriteJSON {
    
    // Suppress the warnings
    @SuppressWarnings("unchecked")
    public static void WriteScore(int first,int second,int third) {
       
        // Create json object
        JSONObject rank = new JSONObject();
        
        // Get the values of top three scores
        rank.put("First", Integer.toString(first));
        rank.put("Second",Integer.toString(second));
        rank.put("Third", Integer.toString(third));
        JSONObject rankObject = new JSONObject();
        rankObject.put("score", rank);
        
        JSONArray scoreList = new JSONArray();
        scoreList.add(rankObject);
        
        // Update the scores
        try (FileWriter file = new FileWriter("score.json")) {
 
            file.write(scoreList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}