//DeleteEvent.java
//Weekly calendar Structure 
/*
ArrayList < ArrayList< String >> = new ArrayList<>(); 

for (int i = 0; i < 7; i++){
    arrayList <String> day = New ArrayList<>; 
    for (j = 0; < 24; i++){
        String event = (null);
    }
}
*/

//visual aid for weeklyCalendar 
/*
[
["Math class at 10:00am, Gym at 2:00pm"],
[],
["Dance class at 9:00am","CS class at 11:00am"],
["Club meeting at 5:00pm"],
[],
[],
["Go to the beach at 10:00am"],
]
*/

//standard java library
import java.util.ArrayList; 
import java.util.Scanner; 


public class Main {
    ArrayList<ArrayList<String>> weeklyCalendar = new ArrayList<>();

    ArrayList<String> Monday = new ArrayList<>(); 
    ArrayList<String> Tuesday = new ArrayList<>();
    ArrayList<String> Wednesday = new ArrayList<>();
    ArrayList<String> Thursday = new ArrayList<>();
    ArrayList<String> Friday = new ArrayList<>();
    ArrayList<String> Saturday = new ArrayList<>();
    ArrayList<String> Sunday = new ArrayList<>();
    void main(String[] args){
        weeklyCalendar.add(Monday);
        weeklyCalendar.add(Tuesday);
        weeklyCalendar.add(Wednesday);
        weeklyCalendar.add(Thursday);
        weeklyCalendar.add(Friday);
        weeklyCalendar.add(Saturday);
        weeklyCalendar.add(Sunday);
    }

    static void deleteEvent(ArrayList<ArrayList<String> Calendar, String event) {
        int weekDayIdx = -1;

        while (weekDayIdx == -1) {
            switch (event.toLowerCase()) {
                case "monday":
                    System.out.println("Monday selected!");
                    int weekDayIdx = 0;
                    break;
                case "tuesday":
                    System.err.println("Tuesday Selected");
                    int weekDayIdx = 1;
                    break;
                case "wednesday":
                    System.err.println("Wednesday Selected");
                    int weekDayIdx = 2;
                    break;
                case "thursday":
                    System.err.println("Thursday Selected");
                    int weekDayIdx = 3;
                    break;
                case "friday":
                    System.err.println("Friday Selected");
                    int weekDayIdx = 4;
                    break;
                case "saturday":
                    System.err.println("Saturday Selected");
                    int weekDayIdx = 5;
                    break;
                case "sunday":
                    System.err.println("Sunday Selected");
                    int weekDayIdx = 6;
                    break;
            }

            int eventIdx = -1;
            while (eventIdx == -1) {
                for (int i = 0; i < weeklyCalendar[weekDayIdx].length; i++) {
                    if (weeklyCalendar[weekDayIdx] == event) {
                        eventIdx = i;
                    }
                }
                System.out.println("Event not found.");
            }

        }

        weeklyCalendar.remove(weekDayIdx, eventIdx);
    }
}