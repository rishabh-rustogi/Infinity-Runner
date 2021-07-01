/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamer;

import java.util.Collections;

// Class to update the highscores
public class Score {
    public static void update(double count)
    {
        // Retrieve the highscores
        ReadJSON.scores();
        Main.score.add(3,(int) count);
        
        // Sort the scores, select top 3 and write them to the "score.json" file 
        Collections.sort(Main.score, Collections.reverseOrder());
        System.out.println(Main.score);
        WriteJSON.WriteScore(Main.score.get(0),Main.score.get(1),Main.score.get(2));
    }
}
