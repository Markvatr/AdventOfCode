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
            if ((int) pair.getValue() == 2) {
                dubbs = true;
            } else if ((int) pair.getValue() == 3) {
                tripps = true;
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        if (dubbs) {
            dubbles++;
        }
        if (tripps) {
            tripples++;
        }
    }

    private static void compareBox(String s1, String s2) {
        char[] chars = s1.toCharArray();
        String ret = "";
        ArrayList<Character> charlist1 = new ArrayList<Character>();
        for (char c : chars) {
            charlist1.add(c);
        }
        chars = s2.toCharArray();
        ArrayList<Character> charlist2 = new ArrayList<Character>();
        for (char c : chars) {
            charlist2.add(c);
        }

        int errors = 0;
        for (int i = 0; i < charlist1.size(); i++) {
            if (charlist1.get(i).equals(charlist2.get(i))) {
                ret+= charlist1.get(i);
            } else {
                errors++;
                if (errors > 1) {
                    break;
                }
            }

        }
        if (errors == 1){
            System.out.println(s1 + "\n" + s2 + "\n" + ret +"\n");
            
        } 
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
            for (int i = 1; i < boxes.size(); i++) {
                for (String s : boxes) {
                    compareBox(s, boxes.get(i));
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
