import java.util.ArrayList;

public class Tests {

    public static void main(String[] args) {
        testIsValidTime();
        testIsValidOption();
        testDayIndex();
        testAddEvent();
        testDeleteEvent();
        testMoveEventDay();
        testMoveEventTime();
        testPrintDay();
        testPrintCalendar();
    }

    static ArrayList<ArrayList<String>> makeCalendar() {
        ArrayList<ArrayList<String>> calendar = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            calendar.add(new ArrayList<>());
        }
        calendar.get(0).add("Math class at 10:00am");
        calendar.get(0).add("Gym at 2:00pm");
        calendar.get(2).add("Dance class at 9:00am");
        calendar.get(2).add("CS class at 11:00am");
        calendar.get(3).add("Club meeting at 5:00pm");
        calendar.get(6).add("Go to the beach at 10:00am");
        return calendar;
    }

    static void testIsValidTime() {
        System.out.println("--- testIsValidTime ---");

        boolean test1 = Main.isValidTime("10:00am");
        System.out.print(test1);
        System.out.println(", true");

        boolean test2 = Main.isValidTime("01:00pm");
        System.out.print(test2);
        System.out.println(", true");

        boolean test3 = Main.isValidTime("12:59pm");
        System.out.print(test3);
        System.out.println(", true");

        boolean test4 = Main.isValidTime("10:00");
        System.out.print(test4);
        System.out.println(", false");

        boolean test5 = Main.isValidTime("13:00pm");
        System.out.print(test5);
        System.out.println(", false");

        boolean test6 = Main.isValidTime("10:60am");
        System.out.print(test6);
        System.out.println(", false");

        boolean test7 = Main.isValidTime(null);
        System.out.print(test7);
        System.out.println(", false");

        System.out.println();
    }

    static void testIsValidOption() {
        System.out.println("--- testIsValidOption ---");

        boolean test1 = Main.isValidOption("1");
        System.out.print(test1);
        System.out.println(", true");

        boolean test2 = Main.isValidOption("6");
        System.out.print(test2);
        System.out.println(", true");

        boolean test3 = Main.isValidOption("7");
        System.out.print(test3);
        System.out.println(", false");

        boolean test4 = Main.isValidOption("exit");
        System.out.print(test4);
        System.out.println(", false");

        System.out.println();
    }

    static void testDayIndex() {
        System.out.println("--- testDayIndex ---");

        int test1 = Main.dayIndex("Monday");
        System.out.print(test1);
        System.out.println(", 0");

        int test2 = Main.dayIndex("sunday");
        System.out.print(test2);
        System.out.println(", 6");

        int test3 = Main.dayIndex("FRIDAY");
        System.out.print(test3);
        System.out.println(", 4");

        int test4 = Main.dayIndex("Mondayy");
        System.out.print(test4);
        System.out.println(", -1");

        int test5 = Main.dayIndex(null);
        System.out.print(test5);
        System.out.println(", -1");

        System.out.println();
    }

    static void testAddEvent() {
        System.out.println("--- testAddEvent ---");
        ArrayList<ArrayList<String>> calendar = makeCalendar();

        // adds in the middle in time order
        System.out.println("Test: add Lunch at 12:00pm on Monday (should go between 10:00am and 2:00pm)");
        Main.addEvent(calendar, "Monday", "Lunch", "12:00pm");
        System.out.println(calendar.get(0));
        System.out.println("Expected: [Math class at 10:00am, Lunch at 12:00pm, Gym at 2:00pm]");

        // adds at the front
        System.out.println("Test: add Early run at 6:00am on Monday (should go first)");
        Main.addEvent(calendar, "Monday", "Early run", "06:00am");
        System.out.println(calendar.get(0));
        System.out.println("Expected: [Early run at 06:00am, Math class at 10:00am, Lunch at 12:00pm, Gym at 2:00pm]");

        // duplicate prevention
        System.out.println("Test: add Math class again on Monday (should be rejected)");
        Main.addEvent(calendar, "Monday", "Math class", "10:00am");

        // invalid day
        System.out.println("Test: add event on Funday (should print error)");
        Main.addEvent(calendar, "Funday", "Test", "10:00am");

        System.out.println();
    }

    static void testDeleteEvent() {
        System.out.println("--- testDeleteEvent ---");
        ArrayList<ArrayList<String>> calendar = makeCalendar();

        // delete existing event
        System.out.println("Test: delete Math class");
        Main.deleteEvent(calendar, "Math class");
        boolean removed = !calendar.get(0).contains("Math class at 10:00am");
        System.out.print(removed);
        System.out.println(", true");

        // delete event that doesn't exist
        System.out.println("Test: delete nonexistent event (should print error)");
        Main.deleteEvent(calendar, "Nonexistent event");

        System.out.println();
    }

    static void testMoveEventDay() {
        System.out.println("--- testMoveEventDay ---");
        ArrayList<ArrayList<String>> calendar = makeCalendar();

        // move Gym from Monday to Friday
        System.out.println("Test: move Gym from Monday to Friday");
        Main.moveEventDay(calendar, "Monday", "Friday", "Gym");

        boolean removedFromMonday = !calendar.get(0).contains("Gym at 2:00pm");
        System.out.print(removedFromMonday);
        System.out.println(", true");

        boolean addedToFriday = calendar.get(4).contains("Gym at 2:00pm");
        System.out.print(addedToFriday);
        System.out.println(", true");

        // event not on that day
        System.out.println("Test: move event that doesn't exist on source day (should print error)");
        Main.moveEventDay(calendar, "Tuesday", "Friday", "Gym");

        // invalid source day
        System.out.println("Test: invalid source day (should print error)");
        Main.moveEventDay(calendar, "Funday", "Friday", "Gym");

        System.out.println();
    }

    static void testMoveEventTime() {
        System.out.println("--- testMoveEventTime ---");
        ArrayList<ArrayList<String>> calendar = makeCalendar();

        // move to a free time slot
        System.out.println("Test: move Math class to 08:00am (no conflict)");
        Main.moveEventTime(calendar, "08:00am", "Math class", null);
        System.out.println(calendar.get(0));
        System.out.println("Expected: [Math class at 08:00am, Gym at 2:00pm]");

        // event not found
        System.out.println("Test: move nonexistent event (should print error)");
        Main.moveEventTime(calendar, "08:00am", "Fake event", null);

        System.out.println();
    }

    static void testPrintDay() {
        System.out.println("--- testPrintDay ---");
        ArrayList<ArrayList<String>> calendar = makeCalendar();

        System.out.println("Test: print Monday");
        Main.printDay(calendar, "Monday");

        System.out.println("Test: print Tuesday (no events)");
        Main.printDay(calendar, "Tuesday");

        System.out.println("Test: print invalid day");
        Main.printDay(calendar, "Funday");

        System.out.println();
    }

    static void testPrintCalendar() {
        System.out.println("--- testPrintCalendar ---");
        ArrayList<ArrayList<String>> calendar = makeCalendar();
        Main.printCalendar(calendar);
    }
}