package gamer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ReadJSON
{
    @SuppressWarnings("unchecked")
    public static void scores()
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("score.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray scoreList = (JSONArray) obj;
            //System.out.println(animalList);
             
            //Iterate over employee array
            scoreList.forEach( num -> parsescoreObject( (JSONObject) num ) );
 
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
    }
 
    private static void parsescoreObject(JSONObject num)
    {
        
        JSONObject scoreObject = (JSONObject) num.get("score");
        Main.score.clear();
        String sfirst = (String) scoreObject.get("First");
        int first=Integer.parseInt(sfirst);
        //int first=(int) scoreObject.get("First");
        String ssecond = (String) scoreObject.get("Second");
        int second=Integer.parseInt(ssecond);
        String sthird = (String) scoreObject.get("Third");
        int third=Integer.parseInt(sthird);
        Main.score.add(0,first);
        Main.score.add(1,second);
        Main.score.add(2,third);
    }    
}