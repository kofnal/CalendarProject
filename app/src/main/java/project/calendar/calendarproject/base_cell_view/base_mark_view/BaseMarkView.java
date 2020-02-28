package project.calendar.calendarproject.base_cell_view.base_mark_view;

import android.content.Context;
import android.util.AttributeSet;

import project.calendar.calendarproject.DateData;
import project.calendar.calendarproject.OnDateClickListener;
import project.calendar.calendarproject.base_cell_view.BaseCellView;

public abstract class BaseMarkView extends BaseCellView {
    private OnDateClickListener clickListener;
    private DateData date;

    public BaseMarkView(Context context) {
        super(context);
    }

    public BaseMarkView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
