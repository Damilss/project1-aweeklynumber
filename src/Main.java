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


    
    int weekDayIdx = -1; 
    static void deleteEvent() { 
        System.out.println(
            """
            Great! Which day has the event you want to remove? 
            You can type Monday, Tuesday, etc.
            """
        ); 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter day of week: ");    

        switch () {
            case "Monday":
            case "monday":
                System.out.println("Monday selected!");
                int weekDayIdx = 0; 
                break;
            case "Tuesday":
            case "tuesday":
                System.err.println("Tuesday Selected");
                

                
        }
    }
}