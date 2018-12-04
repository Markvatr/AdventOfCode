package adventofcode04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String[][] schedule;
        BufferedReader br = new BufferedReader(new FileReader("texts/04"));
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<dateEvent> eventObjects = new ArrayList<dateEvent>();

        while (true) {
            String temp = br.readLine();
            if (temp == null) {
                break;
            }
            data.add(temp);
        }
        for (String s : data) {
            String[] temp = new String[3];
            temp[0] = s.substring(6, 11);
            temp[1] = s.substring(12, 17);
            temp[2] = s.substring(19);
            eventObjects.add(new dateEvent(temp[0], temp[1], temp[2]));
        }
        eventObjects.sort(dateEvent.sort);
        
        schedule = new String[eventObjects.size() + 1][61];
        schedule[0][0] = "Date";
        schedule[0][1] = "ID";
        for(int i = 0; i < eventObjects.size(); i++){
            schedule[0][i+2] = "" + eventObjects.get(i).returnminutes();
        }
        
        
        for(String[] str : schedule){
            for(String s : str){
                System.out.println("["+s+"] \t");
            }
        }
    }

    protected static class dateEvent {

        String mins = "";
        String event = "";
        String day = "";
        
        protected dateEvent(String day, String mins, String event) {
            this.mins = mins;
            this.event = event;
            this.day = day;
        }
        
        public static Comparator<dateEvent> sort = new Comparator<dateEvent>(){
            @Override
            public int compare(dateEvent o1, dateEvent o2) {
                Date d1 = new Date(1518, o1.getMonth(), o1.getDay(), o1.returnhours(), o1.returnminutes());
                Date d2 = new Date(1518, o2.getMonth(), o2.getDay(), o2.returnhours(), o2.returnminutes());
                return d1.compareTo(d2);
            }
            
        };
        
        
        protected int getMonth(){
            char[] temp = day.toCharArray();
            
            return Integer.parseInt((temp[0] + "" + temp[1]));
        }
        
        protected int getDay(){
            char[] temp = day.toCharArray();
            
            return Integer.parseInt((temp[3] + "" + temp[4]));
        }
        
        protected int returnhours(){
            char[] temp = mins.toCharArray();
            
            
            return Integer.parseInt((temp[0] + "" + temp[1]));
        }
        
        protected int returnminutes() {
            char[] temp = mins.toCharArray();
            
            
            return Integer.parseInt((temp[3] + "" + temp[4]));
        }
    }
}
