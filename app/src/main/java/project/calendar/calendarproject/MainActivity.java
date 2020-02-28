package project.calendar.calendarproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private TextView YearMonthTv;
    private ExpCalendarView expCalendarView;
    private DateData selectedDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        expCalendarView = ((ExpCalendarView) findViewById(R.id.calendar_exp));
        YearMonthTv = (TextView) findViewById(R.id.main_YYMM_Tv);
        DateData dateDataNow=new DateData(Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH)+1,
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        YearMonthTv.setText(dateDataNow.getMonthString()+dateDataNow.getYear());

expCalendarView.setOnMonthScrollListener(new OnMonthScrollListener() {
    @Override
    public void onMonthChange(int year, int month) {
        System.out.println("onMonthChange");
    }

    @Override
    public void onMonthChangeString(int year, String monthStr) {
        YearMonthTv.setText(monthStr+" "+Integer.toString(year));
    }

    @Override
    public void onMonthScroll(float positionOffset) {
//        System.out.println("onMonthScroll");
    }
});

        expCalendarView.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(View view, DateData date) {
                System.out.println("expCalenda CL");
                expCalendarView.getMarkedDates().removeAdd();
                expCalendarView.markDate(date);
                selectedDate = date;
            }
        });
    }
}
