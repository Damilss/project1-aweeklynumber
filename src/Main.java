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

//Example: deleteEvent ( myCalendar, “Watch football game” )
//         Deletes the Watch football game event from Friday.

//standard java library
import java.util.ArrayList; 


public class Main {
    public static void main(String[] args) {
        ArrayList< ArrayList<String> > weeklyCalendar = new ArrayList<>();

        ArrayList<String> Monday = new ArrayList<>();
        ArrayList<String> Tuesday = new ArrayList<>();
        ArrayList<String> Wednesday = new ArrayList<>();
        ArrayList<String> Thursday = new ArrayList<>();
        ArrayList<String> Friday = new ArrayList<>();
        ArrayList<String> Saturday = new ArrayList<>();
        ArrayList<String> Sunday = new ArrayList<>();

        weeklyCalendar.add(Monday);
        weeklyCalendar.add(Tuesday);
        weeklyCalendar.add(Wednesday);
        weeklyCalendar.add(Thursday);
        weeklyCalendar.add(Friday);
        weeklyCalendar.add(Saturday);
        weeklyCalendar.add(Sunday);



        weeklyCalendar.get(0).add("Go to the beach at 10:00am");

        printCalendar(weeklyCalendar);


    }

    static void addEvent(){}

    static void deleteEvent(){}

    static void moveEventDay(){}

    static void moveEventTime(){}

    static void printDay(){}

    static void printCalendar(ArrayList<ArrayList<String>> calendar) {
        System.out.println("Great! Here is your current calendar for this week.\n");

        for (ArrayList<String> day : calendar) {
          //  System.out.println(day.getFirst() + ":"); // Prints day


            if (day.size() == 0) {
                System.out.println("\tNo events");
            }
            for (String event : day) {
                System.out.println("\t" + event); // Prints event
            }
        }
    }

    static void userInputValidation(){}
}