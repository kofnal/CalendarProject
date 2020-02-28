package project.calendar.calendarproject.base_cell_view.date_cell_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import project.calendar.calendarproject.DayData;
import project.calendar.calendarproject.R;
import project.calendar.calendarproject.base_cell_view.BaseCellView;

public class DateCellView extends BaseCellView {
    public DateCellView(Context context) {
        super(context);
    }

    public DateCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setDisplayText(DayData day) {
        ((TextView) this.findViewById(R.id.id_cell_text)).setText(day.getText());
    }
}
