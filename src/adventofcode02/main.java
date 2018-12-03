package adventofcode02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class main {

    private static ArrayList<String> boxes = new ArrayList<String>();
    private static int dubbles = 0, tripples = 0;

    private static void scanBox(String s) {
        boolean dubbs = false, tripps = false;
        char[] chars = s.toCharArray();
        ArrayList<Character> charlist = new ArrayList<Character>();
        for (char c : chars) {
            charlist.add(c);
        }
        HashMap<Character, Integer> charmap = new HashMap<Character, Integer>();

        for (Character c : charlist) {
            if (charmap.containsKey(c)) {
                charmap.put(c, charmap.get(c) + 1);
            } else {
                charmap.put(c, 1);
            }
        }
        Iterator it = charmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if((int)pair.getValue() == 2){
                dubbs = true;
            }else if((int)pair.getValue() == 3){
                tripps = true;
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        if(dubbs) dubbles++;
        if(tripps) tripples++;
    }
    
    private static void compareBox(String s){
        
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("texts/adventofcode02.txt"));
            while (true) {
                String temp = br.readLine();
                if (temp == null) {
                    break;
                } else {
                    boxes.add(temp);
                }
            }

//            for (String s : boxes) {
//                scanBox(s);
//            }
//            System.out.println((dubbles * tripples)+"");

            for (String s : boxes) {
                compareBox(s);
            }

            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
