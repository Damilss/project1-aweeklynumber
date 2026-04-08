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


public class DeleteEvent {
    ArrayList < ArrayList< String > > weeklyCalendar = new ArrayList<>();
    int weekDayIdx = -1; 
    public void main() { 
        System.out.println(
            """
            Great! Which day has the event you want to remove? 
            You can type Monday, Tuesday, etc.
            """
        );
        Scanner input = new Scanner(System.in);
        System.out.print("Enter day of week: ");
        while (weekDayIdx.equals(-1);) {
            String weekDay = input.nextLine();
        }        

        switch (weekDay) {
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