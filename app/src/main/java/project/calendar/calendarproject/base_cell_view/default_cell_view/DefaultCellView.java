package project.calendar.calendarproject.base_cell_view.default_cell_view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import project.calendar.calendarproject.CellConfig;
import project.calendar.calendarproject.DayData;
import project.calendar.calendarproject.MarkStyle;
import project.calendar.calendarproject.R;
import project.calendar.calendarproject.base_cell_view.BaseCellView;

import static android.support.constraint.Constraints.TAG;


public class DefaultCellView extends BaseCellView {
    public TextView tvDay;
    public TextView tvTemp;
    public TextView tvTemp2;
    private AbsListView.LayoutParams matchParentParams;
    public DefaultCellView(Context context) {
        super(context);
        initLayout();
    }

    public DefaultCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout();
    }

    private void initLayout(){
        matchParentParams = new AbsListView.LayoutParams((int) CellConfig.cellWidth, (int) CellConfig.cellHeight);
        this.setLayoutParams(matchParentParams);
        this.setOrientation(VERTICAL);
        this.setGravity(Gravity.CENTER);

        tvDay = new TextView(getContext());
        tvTemp = new TextView(getContext());
        tvTemp2 = new TextView(getContext());

        tvDay.setGravity(Gravity.CENTER);
        tvTemp.setPadding(20, 0, 20, 0);
        tvTemp2.setPadding(20, 0, 20, 0);

        tvDay.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, (float) 1.0));
        tvTemp.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0, (float) 1.0));
        tvTemp2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0, (float) 1.0));

//        tvDay.setBackgroundColor(Color.RED);
//        tvTemp.setBackgroundColor(Color.YELLOW);
//        tvTemp2.setBackgroundColor(Color.GREEN);


tvDay.setTextColor(Color.GREEN);
        this.addView(tvDay);
//        tvTemp.setText("8");
//        tvTemp2.setText("8");
//        this.addView(tvTemp);
////        this.addView(tvTemp2);
        //Log.d(TAG,"tv arr size "+Integer.toString(StaticVaribles.tvArrays.size()));

    }

    @Override
    public void setDisplayText(DayData day) {
        tvDay.setText(day.getText());

    }

    @Override
    protected void onMeasure(int measureWidthSpec,int measureHeightSpec){
        super.onMeasure(measureWidthSpec, measureHeightSpec);
    }

    public boolean setDateChoose() {
        setBackgroundDrawable(MarkStyle.choose);
        tvDay.setTextColor(Color.WHITE);
        return true ;
    }

    public void setDateToday(){
        setBackgroundDrawable(MarkStyle.choose);
        tvDay.setTextColor(getResources().getColor(R.color.day_today));
    }

    public void setDateNormal() {
        tvDay.setTextColor(Color.BLACK);
        setBackgroundDrawable(null);
    }

    public void setTextColor(String text, int color, int position) {
        tvDay.setText(text);
//        tvDay.setText("R");
        if (color != 0) {
            tvDay.setTextColor(color);
        }
    }
}
