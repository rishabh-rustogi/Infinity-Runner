package gamer;

import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class WriteJSON {
    
    public static void WriteScore(int first,int second,int third) {
       
        JSONObject rank = new JSONObject();
        rank.put("First", Integer.toString(first));
        rank.put("Second",Integer.toString(second));
        rank.put("Third", Integer.toString(third));
        JSONObject rankObject = new JSONObject();
        rankObject.put("score", rank);
        
        JSONArray scoreList = new JSONArray();
        scoreList.add(rankObject);
        
        try (FileWriter file = new FileWriter("score.json")) {
 
            file.write(scoreList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}