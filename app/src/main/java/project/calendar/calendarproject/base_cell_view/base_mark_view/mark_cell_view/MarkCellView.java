package project.calendar.calendarproject.base_cell_view.base_mark_view.mark_cell_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import project.calendar.calendarproject.DayData;
import project.calendar.calendarproject.MarkStyle;
import project.calendar.calendarproject.R;
import project.calendar.calendarproject.base_cell_view.base_mark_view.BaseMarkView;


public class MarkCellView extends BaseMarkView {
    public MarkCellView(Context context) {
        super(context);
    }

    public MarkCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setDisplayText(DayData day) {

        ((TextView) this.findViewById(R.id.id_cell_text)).setText(day.getText());
    }
    public void setDateToday(){
        setBackgroundDrawable(MarkStyle.choose);
//        tvDay.setTextColor(getResources().getColor(R.color.day_today));
    }
}
