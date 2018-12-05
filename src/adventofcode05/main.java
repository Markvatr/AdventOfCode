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
        int lowestoccurences = Integer.MAX_VALUE;
        for (int i = 0; i < 25; i++) {
            temp = (ArrayList<Character>) charData.clone();
            removeCharNr(temp, i);
            int counter = 0;
            boolean noRepetitions = false;

            while (!noRepetitions) {
                noRepetitions = true;
                for (int j = 0; j < temp.size(); j++) {
                    Character lower = ("" + temp.get(j)).toLowerCase().charAt(0);
                    Character upper = ("" + temp.get(j)).toUpperCase().charAt(0);
                    if (j + 1 != temp.size()) {
                        if (temp.get(j).equals(lower)) {
                            if (temp.get(j + 1).equals(upper)) {
                                rmChars(temp, j);
                                noRepetitions = false;
                                break;
                            }
                        } else if (temp.get(j).equals(upper)) {
                            if (temp.get(j + 1).equals(lower)) {
                                rmChars(temp, j);
                                noRepetitions = false;
                                break;
                            }
                        }
                    }
                }
                counter++;
                //System.out.println("nextLoop: " + counter);
            }
            count.add(temp.size());
            System.out.println(i + " : " + temp.size());

        }
        for (int i : count) {
            if (i < lowestoccurences) {
                lowestoccurences = i;
            }
        }
        System.out.println(lowestoccurences);
        //System.out.println(charData.size());
    }

    private static void rmChars(ArrayList<Character> c, int j) {
        c.remove(j);
        c.remove(j);
    }

    private static void removeCharNr(ArrayList<Character> c, int i) {
        Character ch;
        char[] charslower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] charsupper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        ArrayList<Character> removals = new ArrayList<Character>();
        for (Character cha : c) {
            if (cha.equals((Character) charslower[i]) || cha.equals((Character) (charsupper[i]))) {
                removals.add(cha);

            }

        }
        for (Character cha : removals) {
            c.remove(cha);
        }
    }
}
