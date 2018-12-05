package adventofcode04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class main {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader("texts/04"));
        ArrayList<String> data = new ArrayList<String>();
        bufferToList(data, br);
        ArrayList<rowFormat> formatedData = new ArrayList<rowFormat>();
        ArrayList<daySchedule> schedule = new ArrayList<daySchedule>();

        for (String s : data) {
            formatedData.add(new rowFormat(s));
        }

        formatedData.sort(new CustomComparator());
        int prevGuard = -1;
        for (int i = 0; i < formatedData.size(); i++) {
            
            if(formatedData.get(i).getEvent().equals("Guard")){
                
                schedule.add(new daySchedule(formatedData.get(i).getGuardID(), sdf.parse(formatedData.get(i).getDate())));
                prevGuard++;
            }else{
                schedule.get(prevGuard).add(formatedData.get(i).getMin(), formatedData.get(i).getEvent());
            }
        }
        for(daySchedule ds : schedule){
            System.out.println(Arrays.toString(ds.getActiveHours()));
        }

    }

    public static class CustomComparator implements Comparator<rowFormat> {

        @Override
        public int compare(rowFormat o1, rowFormat o2) {
            try {
                return sdf.parse(o1.getDate()).compareTo(sdf.parse(((rowFormat) o2).getDate()));
            } catch (ParseException ex) {
            }
            return 0;
        }
    }

    protected static class rowFormat {

        ArrayList<String> formatedRow = new ArrayList<String>();

        protected rowFormat(String s) {
            formatedRow.add(s.substring(1, 17));
            formatedRow.add(s.substring(19, 24));

            if (s.indexOf("#") != -1) {
                int temp = s.indexOf("b", s.indexOf("#"));
                formatedRow.add(s.substring(s.indexOf("#"), temp));
            } else {
                formatedRow.add(null);
            }
        }

        protected String getDate() {
            return formatedRow.get(0);
        }
        
        protected int getMin() throws ParseException{
            return sdf.parse(getDate()).getMinutes();
        }

        protected String getEvent() {
            return formatedRow.get(1);
        }

        protected String getGuardID() {
            return formatedRow.get(2);
        }
    }

    protected static class daySchedule {

        Date date;
        String guardID;
        ArrayList<Integer> eventstime = new ArrayList<Integer>();
        ArrayList<String> events = new ArrayList<String>();
        String[] activeHours = new String[59];

        /**
         *
         * @param guardID
         * @param workDate
         */
        protected daySchedule(String guardID, Date workDate) {
            date = workDate;
            this.guardID = guardID;
        }

        protected void add(int time, String event) {
            
            eventstime.add(time);
            events.add(event);
        }

        protected Date getDate() {
            return date;
        }

        protected String[] getActiveHours() {
            for (int i = 0; i < activeHours.length; i++) {
                activeHours[i] = ".";
            }
            for (int i = 0; i < events.size(); i++) {
                switch (events.get(i)) {
                    case "falls":
                        for (int j = eventstime.get(i); j < eventstime.get(i + 1); j++) {
                            activeHours[j] = "X";
                        }
                        break;
                    case "wakes":

                        break;
                }
            }
            
            return activeHours;
        }
    }

    private static void bufferToList(ArrayList<String> data, BufferedReader br) throws IOException {
        while (true) {
            String temp = br.readLine();
            if (temp == null) {
                break;
            }
            data.add(temp);
        }
    }
}
