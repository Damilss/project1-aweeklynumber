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
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final String[] DAY_NAMES = {
            "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"
    };

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> weeklyCalendar = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            weeklyCalendar.add(new ArrayList<>());
        }

        weeklyCalendar.get(0).add("Math class at 10:00am");
        weeklyCalendar.get(0).add("Gym at 2:00pm");
        weeklyCalendar.get(2).add("Dance class at 9:00am");
        weeklyCalendar.get(2).add("CS class at 11:00am");
        weeklyCalendar.get(3).add("Club meeting at 5:00pm");
        weeklyCalendar.get(6).add("Go to the beach at 10:00am");

        runCalendarUI(weeklyCalendar);
    }

    static void runCalendarUI(ArrayList<ArrayList<String>> calendar) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the weekly calendar. Pick an option from below by typing its number or type \"exit\" to terminate the program.");
        printMenu();

        boolean running = true;
        while (running) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("It was nice to see you! Have a great day.");
                running = false;
                continue;
            }

            switch (input) {
                case "1":
                    handleAdd(calendar, scanner);
                    break;
                case "2":
                    handleDelete(calendar, scanner);
                    break;
                case "3":
                    handleMoveDay(calendar, scanner);
                    break;
                case "4":
                    handleMoveTime(calendar, scanner);
                    break;
                case "5":
                    handlePrintDay(calendar, scanner);
                    break;
                case "6":
                    printCalendar(calendar);
                    break;
                default:
                    System.out.println("I'm afraid I don't have this option. Try typing your option again.");
                    continue;
            }

            System.out.println("\nWould you like to continue with something else? Pick an option from below by typing its number or type \"exit\" to terminate the program.");
            printMenu();
        }
    }

    static void printMenu() {
        System.out.println("1.\tAdd an event to the calendar");
        System.out.println("2.\tRemove an event from the calendar");
        System.out.println("3.\tMove an event from one day to another");
        System.out.println("4.\tMove an event to a different time");
        System.out.println("5.\tPrint a day");
        System.out.println("6.\tPrint the calendar");
    }

    static void handleAdd(ArrayList<ArrayList<String>> calendar, Scanner scanner) {
        System.out.println("Great, you want to add an event. What is the day for the event? You can type Monday, Tuesday, etc.");
        String day = promptValidDay(scanner);

        System.out.println("What is the event you want to add on " + day + "?");
        String eventName = scanner.nextLine().trim();

        System.out.println("What time would the event start? You can type 10:00am, 01:00pm, etc.");
        String time = promptValidTime(scanner);

        addEvent(calendar, day, eventName, time);
    }

    static void handleDelete(ArrayList<ArrayList<String>> calendar, Scanner scanner) {
        System.out.println("What event do you want to delete?");
        String eventName = scanner.nextLine().trim();
        deleteEvent(calendar, eventName);
    }

    static void handleMoveDay(ArrayList<ArrayList<String>> calendar, Scanner scanner) {
        System.out.println("What is the source day?");
        String sourceDay = promptValidDay(scanner);

        System.out.println("What day are you moving the event to?");
        String destDay = promptValidDay(scanner);

        System.out.println("What is the event?");
        String event = scanner.nextLine().trim();

        moveEventDay(calendar, sourceDay, destDay, event);
    }

    static void handleMoveTime(ArrayList<ArrayList<String>> calendar, Scanner scanner) {
        System.out.println("What is the event to be changed?");
        String event = scanner.nextLine().trim();

        System.out.println("What is your new time? You can type 10:00am, 01:00pm, etc.");
        String newTime = promptValidTime(scanner);

        moveEventTime(calendar, newTime, event, scanner);
    }

    static void handlePrintDay(ArrayList<ArrayList<String>> calendar, Scanner scanner) {
        System.out.println("Great! Which day do you want to print? You can type Monday, Tuesday, etc.");
        String day = promptValidDay(scanner);
        printDay(calendar, day);
    }

    static String promptValidDay(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            int idx = dayIndex(input);
            if (idx >= 0) {
                return DAY_NAMES[idx];
            }
            System.out.println("I'm afraid I don't have a day " + input + ". Try typing again the day.");
        }
    }

    static String promptValidTime(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (isValidTime(input)) {
                return input;
            }
            System.out.println("I'm afraid that is not a valid time. Try typing again the time.");
        }
    }

    static int dayIndex(String day) {
        if (day == null) return -1;
        for (int i = 0; i < DAY_NAMES.length; i++) {
            if (DAY_NAMES[i].equalsIgnoreCase(day.trim())) {
                return i;
            }
        }
        return -1;
    }

    static boolean isValidTime(String time) {
        if (time == null) return false;
        String t = time.trim().toLowerCase();
        if (t.length() < 6) return false;
        if (!(t.endsWith("am") || t.endsWith("pm"))) return false;

        String withoutAmPm = t.substring(0, t.length() - 2);
        if (!withoutAmPm.contains(":")) return false;
        String[] parts = withoutAmPm.split(":");
        if (parts.length != 2) return false;
        if (parts[1].length() != 2) return false;

        try {
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            if (hours < 1 || hours > 12) return false;
            if (minutes < 0 || minutes > 59) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static boolean isValidOption(String option) {
        return Arrays.asList("1", "2", "3", "4", "5", "6").contains(option);
    }

    static void addEvent(ArrayList<ArrayList<String>> calendar,
                         String day, String eventName, String time) {
        int idx = dayIndex(day);
        if (idx < 0) {
            System.out.println("I'm afraid I don't have a day " + day + ".");
            return;
        }
        if (!isValidTime(time)) {
            System.out.println("I'm afraid that is not a valid time.");
            return;
        }

        String newEvent = eventName + " at " + time;
        ArrayList<String> dayEvents = calendar.get(idx);

        for (String existing : dayEvents) {
            int splitAt = existing.lastIndexOf(" at ");
            String existingName = (splitAt >= 0) ? existing.substring(0, splitAt) : existing;
            if (existingName.equalsIgnoreCase(eventName)) {
                System.out.println("Event \"" + eventName + "\" already exists on " + DAY_NAMES[idx] + ": " + existing);
                return;
            }
        }

        int newTimeMinutes = getTimeInMinutes(time);
        int insertAt = dayEvents.size();
        for (int i = 0; i < dayEvents.size(); i++) {
            int existingMinutes = getTimeInMinutes(extractTime(dayEvents.get(i)));
            if (existingMinutes > newTimeMinutes) {
                insertAt = i;
                break;
            }
        }
        dayEvents.add(insertAt, newEvent);
        System.out.println("Done. " + eventName + " at " + time + " on " + DAY_NAMES[idx] + " is added on your calendar.");
    }

    static void deleteEvent(ArrayList<ArrayList<String>> calendar, String userInputEvent) {
        if (calendar == null) {
            System.err.println("No calendar, please check your calendar.");
            return;
        }

        boolean removedFlag = false;

        for (ArrayList<String> dayOfWeek : calendar) {
            if (dayOfWeek == null) {
                System.err.println("dayOfWeek does not exist, please check your calendar.");
                continue;
            }

            ArrayList<String> newEventsInDay = new ArrayList<>();
            for (String event : dayOfWeek) {
                int splitAt = event.lastIndexOf(" at ");
                if (splitAt < 0) {
                    newEventsInDay.add(event);
                    continue;
                }
                String eventName = event.substring(0, splitAt);
                String eventRest = event.substring(splitAt);

                if (eventName.equalsIgnoreCase(userInputEvent)) {
                    removedFlag = true;
                } else {
                    newEventsInDay.add(eventName + eventRest);
                }
            }
            dayOfWeek.clear();
            dayOfWeek.addAll(newEventsInDay);
        }

        if (removedFlag) {
            System.out.println("Event Deleted, here is your new calendar!");
            printCalendar(calendar);
        } else {
            System.err.println("No events found! Please check your input and try again.");
        }
    }

    static void moveEventDay(ArrayList<ArrayList<String>> calendar,
                             String sourceDay, String destinationDay, String event) {
        int sIdx = dayIndex(sourceDay);
        int dIdx = dayIndex(destinationDay);
        if (sIdx < 0) {
            System.out.println("I'm afraid I don't have a day " + sourceDay + ".");
            return;
        }
        if (dIdx < 0) {
            System.out.println("I'm afraid I don't have a day " + destinationDay + ".");
            return;
        }

        ArrayList<String> sourceEvents = calendar.get(sIdx);
        for (int i = 0; i < sourceEvents.size(); i++) {
            String full = sourceEvents.get(i);
            int splitAt = full.lastIndexOf(" at ");
            if (splitAt < 0) continue;

            String name = full.substring(0, splitAt);
            if (name.equalsIgnoreCase(event)) {
                String time = full.substring(splitAt + 4);
                sourceEvents.remove(i);
                addEvent(calendar, destinationDay, name, time);
                System.out.println("Moved " + name + " from " + DAY_NAMES[sIdx] + " to " + DAY_NAMES[dIdx] + ".");
                return;
            }
        }
        System.out.println("Event \"" + event + "\" not found on " + DAY_NAMES[sIdx] + ".");
    }

    static void moveEventTime(ArrayList<ArrayList<String>> calendar,
                              String newTime, String event, Scanner scanner) {
        if (!isValidTime(newTime)) {
            System.out.println("I'm afraid that is not a valid time.");
            return;
        }

        int foundDay = -1;
        int foundIdx = -1;
        String foundName = null;
        for (int d = 0; d < calendar.size(); d++) {
            ArrayList<String> dayEvents = calendar.get(d);
            for (int i = 0; i < dayEvents.size(); i++) {
                String full = dayEvents.get(i);
                int splitAt = full.lastIndexOf(" at ");
                if (splitAt < 0) continue;
                String name = full.substring(0, splitAt);
                if (name.equalsIgnoreCase(event)) {
                    foundDay = d;
                    foundIdx = i;
                    foundName = name;
                    break;
                }
            }
            if (foundDay >= 0) break;
        }

        if (foundDay < 0) {
            System.out.println("Event \"" + event + "\" not found.");
            return;
        }

        boolean conflict = false;
        for (int i = 0; i < calendar.get(foundDay).size(); i++) {
            if (i == foundIdx) continue;
            String full = calendar.get(foundDay).get(i);
            if (extractTime(full).equalsIgnoreCase(newTime)) {
                conflict = true;
                break;
            }
        }

        if (conflict) {
            boolean asking = true;
            while (asking) {
                System.out.println("There is already an event at " + newTime + " on " + DAY_NAMES[foundDay] + ". Do you still want to move this event? (yes/no)");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (answer.equals("yes")) {
                    asking = false;
                } else if (answer.equals("no")) {
                    System.out.println("No events have been edited.");
                    return;
                } else {
                    System.out.println("Invalid input. Please type yes or no.");
                }
            }
        }

        calendar.get(foundDay).remove(foundIdx);
        addEvent(calendar, DAY_NAMES[foundDay], foundName, newTime);
        System.out.println("Event time has been changed.");
    }

    static String extractTime(String fullEvent) {
        int splitAt = fullEvent.lastIndexOf(" at ");
        if (splitAt < 0) return "";
        return fullEvent.substring(splitAt + 4);
    }

    static int getTimeInMinutes(String time) {
        String t = time.trim().toLowerCase();
        String ampm = t.substring(t.length() - 2);
        String[] parts = t.substring(0, t.length() - 2).split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        if (ampm.equals("am")) {
            if (hours == 12) hours = 0;
        } else {
            if (hours != 12) hours += 12;
        }
        return hours * 60 + minutes;
    }

    static void printDay(ArrayList<ArrayList<String>> calendar, String day) {
        int idx = dayIndex(day);
        if (idx < 0) {
            System.out.println("I'm afraid I don't have a day " + day + ".");
            return;
        }

        ArrayList<String> events = calendar.get(idx);
        System.out.println(DAY_NAMES[idx] + ":");
        if (events.isEmpty()) {
            System.out.println("\tNo events");
            return;
        }
        for (String event : events) {
            System.out.println("\t" + event);
        }
    }

    static void printCalendar(ArrayList<ArrayList<String>> calendar) {
        System.out.println("Great! Here is your current calendar for this week.\n");

        for (int i = 0; i < calendar.size(); i++) {
            System.out.println(DAY_NAMES[i] + ":");
            ArrayList<String> day = calendar.get(i);
            if (day.isEmpty()) {
                System.out.println("\tNo events");
                continue;
            }
            for (String event : day) {
                System.out.println("\t" + event);
            }
        }
    }
}