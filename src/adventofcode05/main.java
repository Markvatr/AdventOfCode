package adventofcode05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("texts/05"));
        String data = "";
        while (true) {
            String temp = br.readLine();
            if (temp == null) {
                break;
            }
            data = temp;
        }
        char[] chars = data.toCharArray();
        ArrayList<Character> charData = new ArrayList<Character>();
        for (int i = 0; i < chars.length; i++) {
            charData.add(chars[i]);
        }
        ArrayList<Character> temp;
        ArrayList<Integer> count = new ArrayList<Integer>();
        for (int i = 0; i < 25; i++) {
            temp = (ArrayList<Character>)charData.clone();
            removeCharNr(i);
            int counter = 0;
            boolean noRepetitions = false;
            int occurences = 0;
            while (!noRepetitions) {
                noRepetitions = true;
                for (int j = 0; j < charData.size(); j++) {
                    Character lower = ("" + charData.get(j)).toLowerCase().charAt(0);
                    Character upper = ("" + charData.get(j)).toUpperCase().charAt(0);
                    if (j + 1 != charData.size()) {
                        if (charData.get(j).equals(lower)) {
                            if (charData.get(j + 1).equals(upper)) {
                                rmChars(charData, j);
                                noRepetitions = false;
                                break;
                            }
                        } else if (charData.get(j).equals(upper)) {
                            if (charData.get(j + 1).equals(lower)) {
                                rmChars(charData, j);
                                noRepetitions = false;
                                break;
                            }
                        }
                    }
                }
                counter++;
                System.out.println("nextLoop: " + counter);
            }
            count.add(counter);
        }
        System.out.println(charData.size());
    }

    private static void rmChars(ArrayList<Character> c, int j) {
        c.remove(j);
        c.remove(j);
    }

    private static void removeCharNr(ArrayList<Character> c, int i) {
        Character ch;
        char[] Chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','v','w','x','y','z'};
        for(int j = 0 ; j < c.size(); j++){
            
        }
    }
}
