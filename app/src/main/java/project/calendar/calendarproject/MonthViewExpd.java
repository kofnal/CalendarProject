package project.calendar.calendarproject;

import android.content.Context;
import android.util.AttributeSet;

public class MonthViewExpd extends MonthView {
    private MonthWeekData monthWeekData;
    private CalendarAdapter adapter;

    public MonthViewExpd(Context context) {
        super(context);
    }

    public MonthViewExpd(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initMonthAdapter(int pagePosition, int cellView, int markView) {
        getMonthWeekData(pagePosition);
        adapter = new CalendarAdapter(getContext(), 1, monthWeekData.getData()).setCellViews(cellView, markView);
        this.setAdapter(adapter);
    }

    private void getMonthWeekData(int position) {
        monthWeekData = new MonthWeekData(position);
    }


}
