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
["Math class at 10:00am, "Gym at 2:00pm"],
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

        //create dayOfWeek
        ArrayList<String> Monday = new ArrayList<>();
        ArrayList<String> Tuesday = new ArrayList<>();
        ArrayList<String> Wednesday = new ArrayList<>();
        ArrayList<String> Thursday = new ArrayList<>();
        ArrayList<String> Friday = new ArrayList<>();
        ArrayList<String> Saturday = new ArrayList<>();
        ArrayList<String> Sunday = new ArrayList<>();

        //add to weeklyCalendar
        weeklyCalendar.add(Monday);     //idx: 0
        weeklyCalendar.add(Tuesday);    //idx: 1
        weeklyCalendar.add(Wednesday);  //idx: 2
        weeklyCalendar.add(Thursday);   //idx: 3
        weeklyCalendar.add(Friday);     //idx: 4
        weeklyCalendar.add(Saturday);   //idx: 5
        weeklyCalendar.add(Sunday);     //idx: 6

        //---------------- CREATING TEST CALENDAR ------------------------/

        
        weeklyCalendar.get(0).add("Go to the beach at 10:00am");


        printCalendar(weeklyCalendar);


    }

    static void addEvent(){}

    /**
     * deletes an event from the weekly calendar based on matching the first word of the event string.
     * 
     * this method searches through all days in the calendar and compares the first word 
     * (before the first space) of each event against the userInputEvent parameter. 
     * When a match is found, the entire event is removed from that day.
     * 
     * intended implementation:
     * - iterates through each day of the week
     * - for each event in the day, extracts the event by splitting at the " at "
     * - Compares that evnet with the userInputEvent parameter
     * - If a match is found, removes the event and sets removedFlag to true
     * - After searching all days, if any event was removed, prints the updated calendar
     * 
     * example usage:
     *   deleteEvent(myCalendar, "Math")  // this wiill delete "Math class at 10:00am" event
     * oh and time complexity is O(n^n))
     */
    static void deleteEvent(ArrayList<ArrayList<String>> calendar, String userInputEvent){
        if (calendar == null){
            System.err.println("no calendar, please check your calendar.");

        } else {
            boolean removedFlag = false; 

            for (ArrayList<String> dayOfWeek : calendar ) {
                if (dayOfWeek == null){
                    System.err.println("dayOfweek does not exist, please check your calender.");

                } else {
                    int weekSize = dayOfWeek.size();

                    for (int i = 0; i < weekSize; i++){
                        String extractedEventString = dayOfWeek.get(0);
                        //can be "" or null
                        if (extractedEventString.equals("") || extractedEventString == null){
                            //skips over the rest of loop and continues iteration
                            continue;
                            
                        }
                        
                        ArrayList<String> newEventsInDay = new ArrayList <>();

                        for (String event: dayOfWeek){
                            /* docs: https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
                            *Returns the index of the first (for atIndex) and last (for atLastIndex) occurrence of the specified substring
                            */
                            int splitAt = event.lastIndexOf(" at ");
                            String eventName = event.substring(0, splitAt);
                            String eventRest = event.substring(splitAt);

                            if (eventName.toLowerCase().equals(userInputEvent.toLowerCase())){
                                removedFlag = true;

                            } else {
                                newEventsInDay.add(eventName + eventRest);

                            }
                        }
                    }
                }
            }

            if (removedFlag){
                System.out.println("Event Deleted, here is your new calendar!");
                printCalendar(calendar);
            } else { 
                System.err.println("No events found! please check your input and try again.");
            }
        }
    }
    

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