package project.calendar.calendarproject;

import android.support.v4.view.ViewPager;


public abstract class OnMonthScrollListener implements ViewPager.OnPageChangeListener {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        onMonthScroll(positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
        CellConfig.middlePosition = position;
        DateData date;
            date = ExpCalendarUtil.position2Month(position);
        onMonthChangeString(date.getYear(), date.getMonthString());
        System.out.println(Integer.toString(position)+" positionMonth");
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public abstract void onMonthChange(int year, int month);

    public abstract void onMonthChangeString(int year, String monthStr);

    public abstract void onMonthScroll(float positionOffset);
}
