package adventofcode02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class main {
    
    
    private static ArrayList<String> boxes = new ArrayList<String>();
    private static int dubbles = 0, tripples = 0;
    
    private static void scanBox(String s){
        
    }
    
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("texts/adventofcode02.txt"));
            while(true){
                String temp = br.readLine();
                if(temp == null){
                    break;
                }else{
                    boxes.add(temp);
                }
                System.out.println(temp);
            }
            
            for(String s : boxes){
                scanBox(s);
            }
        
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
