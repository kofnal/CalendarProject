package project.calendar.calendarproject;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MonthView extends GridView {
    public MonthView(Context context) {
        super(context);
        this.setNumColumns(7);
    }

    public MonthView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setNumColumns(7);
    }


}
