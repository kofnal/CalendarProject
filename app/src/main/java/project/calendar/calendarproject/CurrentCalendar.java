package project.calendar.calendarproject;

import java.util.Calendar;

public class CurrentCalendar {
    public static DateData getCurrentDateData(){
        Calendar calendar = Calendar.getInstance();
        return new DateData(calendar.get(calendar.YEAR), calendar.get(calendar.MONTH) , calendar.get(calendar.DAY_OF_MONTH));
    }

}
