package project.calendar.calendarproject;

import java.util.Calendar;

public class ExpCalendarUtil {


    public static DateData position2Month(int absPos) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(CellConfig.m2wPointDate.getYear(), CellConfig.m2wPointDate.getMonth() - 1, CellConfig.m2wPointDate.getDay());
        int distance = absPos - CellConfig.Week2MonthPos;
        calendar.add(Calendar.MONTH, distance);
        return new DateData(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1);
    }



}
