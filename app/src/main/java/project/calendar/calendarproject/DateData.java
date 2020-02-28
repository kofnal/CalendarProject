package project.calendar.calendarproject;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateData {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private MarkStyle markStyle;

    public DateData(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = 0;
        this.minute = 0;
        this.markStyle = new MarkStyle();
    }

    public int getYear() {
        return year;
    }

    public DateData setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }


    public String getMonthString(){
        Calendar c;
        String s;
        try {
            c= Calendar.getInstance();
            c.set(Calendar.MONTH,month-1);
            String[] russianMonat =
                    {       "Январь",
                            "Февраль",
                            "Март",
                            "Апрель",
                            "Май",
                            "Июнь",
                            "Июль",
                            "Август",
                            "Сентябрь",
                            "Октябрь",
                            "Ноябрь",
                            "Декабрь"
                    };
            DateFormatSymbols russSymbol = new DateFormatSymbols(Locale.getDefault());
            russSymbol.setMonths(russianMonat);
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM ", russSymbol);
//            System.out.println("Locale "+ Locale.getDefault());

            Date currentDate = c.getTime();
            System.out.println("currentDateTime = " + sdf.format(currentDate));
            s=sdf.format(currentDate);

        } catch (NullPointerException ex) {
            s=null;
        }
        return s;
    }



    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        DateData data = (DateData) o;
        return  ((data.year == this.year) && (data.month == this.month) && (data.day == this.day));
    }

    public MarkStyle getMarkStyle() {
        return markStyle;
    }

    public DateData setMarkStyle(MarkStyle markStyle) {
        this.markStyle = markStyle;
        return this;
    }

    public DateData setMarkStyle(int style, int color){
        this.markStyle = new MarkStyle(style, color);
        return this;
    }

    public Date getDate() {
        Date dateGet =new Date(this.year, this.month, this.day);
        return dateGet;
    }
}
