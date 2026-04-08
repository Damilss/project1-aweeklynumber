# DeleteEvent.java

## Weekly calendar Structure 
```
ArrayList < ArrayList< String >> = new ArrayList<>(); 

for (int i = 0; i < 7; i++){
    arrayList <String> day = New ArrayList<>; 
    for (j = 0; < 24; i++){
        String event = (null);
    }
}
```

## visual aid for weeklyCalendar 

```
[
["Math class at 10:00am, Gym at 2:00pm"],
[],
["Dance class at 9:00am","CS class at 11:00am"],
["Club meeting at 5:00pm"],
[],
[],
["Go to the beach at 10:00am"],
]
```

## Implementation: 

- user calls to deleteEvent through specific function from UI
- program begins from the printed line: 
`"Great! Which day has the event you want to remove..."` 
- Event is filtered (through switch case) through day of Week as program specifies for DeleteEvent in program 1 instructions
- default case returns back to prompt!
- List all events within the calendar day to have a


## Testing for Cases: 
- Possible invalid input from user? 
- user might want to return to original UI?
- no events within specified date, return to day chooser or return back to original UI? 



