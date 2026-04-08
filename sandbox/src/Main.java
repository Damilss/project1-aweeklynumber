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