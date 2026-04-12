# Notes

## 4.10.2026

Today I thought about how I was going to go about recreating a new list. 

### Initial thoughts

My initial thoughts was to creaete a new list then replace dayOfweek with newEventsInDay. Changing the item. In theory, not the smartest to mutate a loop you're iterating over. 

### But: 

I wonder if we're not mutating the actualy size of the list if it's fine? Obviously in pracice it's not the smartest. Maybe it would be smarter to iterate over the index the days in the week for the weeklyCalendar. Outside of the loop return the. new list and set it to the day of the week. This avoids mutating the list while iterating over it. 
### Conclusion:
Either set the selected event to null and removing null, or 