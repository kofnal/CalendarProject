package project.calendar.calendarproject;

import android.view.View;

public abstract class OnDateClickListener {
    public static OnDateClickListener instance;

    public abstract void onDateClick(View view, DateData date);
}
