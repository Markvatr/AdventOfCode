/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class AdventOfCode {

    /**
     * @param args the command line arguments
     */
    private static File f = new File("texts/adventofcode01.txt");
    private static File ftest = new File("texts/test.txt");
    private static ArrayList<Integer> arr = new ArrayList<Integer>();
    private static ArrayList<Integer> freq = new ArrayList<Integer>();
    private static int sum = 0;

    public static void main(String[] args) {
        try {
            FileReader fip = new FileReader(f);
            BufferedReader dis = new BufferedReader(fip);

            while (true) {
                String temp = dis.readLine();
                if (temp == null) {
                    break;
                }
                switch (temp.charAt(0)) {
                    case '+':
                        temp = temp.substring(1);
                        break;
                    case '-':

                        break;
                }
                arr.add(Integer.parseInt(temp));
                //System.out.println(temp);
            }
            int itteration = 0;
            while (true) {
                itteration++;
                System.out.println(""+itteration);
                for (int i : arr) {
                    sum += i;
                    //System.out.println(sum);
                    if (freq.contains(sum)) {

                        System.out.println("Duplicate at " + sum);
                        System.exit(0);
                    } else {
                        freq.add(sum);
                    }
                }
            }
            //System.out.println(sum + "");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdventOfCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdventOfCode.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
