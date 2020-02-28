package project.calendar.calendarproject;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Calendar;

public class MonthWeekData {
    private DateData pointDate;
    private Calendar calendar = Calendar.getInstance();

    private int realPosition;
    private int weekIndex, preNumber, afterNumber;

    private ArrayList<DayData> monthContent;

    public MonthWeekData(int position) {
//        System.out.println(position +" MonthWeekData " + Integer.toString(calendar.get(Calendar.MONTH) + 1));
        realPosition = position;
        calendar = Calendar.getInstance();
        DateData today = new DateData(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        if (CellConfig.m2wPointDate == null) {
            CellConfig.m2wPointDate = today;
        }
        if (CellConfig.w2mPointDate == null) {
            CellConfig.w2mPointDate = today;
        }
        if (CellConfig.weekAnchorPointDate == null) {
            CellConfig.weekAnchorPointDate = today;
        }

//            System.out.println("Init arr mont");
            getPointDate();
            initMonthArray();
    }

    private void getPointDate() {
        // получаем заказанную точку
        calendar.set(CellConfig.w2mPointDate.getYear(),
                CellConfig.w2mPointDate.getMonth() - 1, CellConfig.w2mPointDate.getDay());
        // получаем относительную разницу в смещении страниц
        int distance = CellConfig.Week2MonthPos - CellConfig.Month2WeekPos;
//        System.out.println(Integer.toString(distance)+" dist, Week2MonthPos " +
//                CellConfig.Week2MonthPos + " Month2WeekPos " +
//                CellConfig.Month2WeekPos);
        calendar.add(Calendar.DATE, distance * 7);
//        System.out.println("Месяц изменился ? " + CellConfig.w2mPointDate.getMonthString());
//        System.out.println("getPointDate  базовая дата: " +
//                Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)+1) + "." +
//                (calendar.get(Calendar.MONTH) + 1));
        // Определяем , будет ли средняя страница
//        System.out.println("if real Posit "+realPosition+" ?= "+CellConfig.middlePosition);
        if (realPosition == 500) {
//      if (realPosition == CellConfig.middlePosition) {
            CellConfig.m2wPointDate = new DateData(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
//            System.out.println(Integer.toString(calendar.get(Calendar.MONTH)+1)+" !!!!!!  выбран месяц текущий " + CellConfig.m2wPointDate.getMonthString());
        } else {
            calendar.add(Calendar.MONTH, realPosition - CellConfig.Week2MonthPos);
//            System.out.println(Integer.toString(calendar.get(Calendar.MONTH)+1)+" !!!!!! выбран месяц НEEEЕ текущий " + CellConfig.m2wPointDate.getMonthString());
        }
        calendar.set(Calendar.DATE, 1);
//        System.out.println("?????  getPointDate  после последнего вызова：" +
//                calendar.get(Calendar.DAY_OF_MONTH) +
//                "." + (calendar.get(Calendar.MONTH) + 1));

    }

    //создать массив с помесячным календарем
    private void initMonthArray() {
        DayData addDate;
        boolean vEtomMesiacePervoeHisloVVoskresenie = false;
        boolean vEtomMesiacePervoeHisloVVtornik = false;
        monthContent = new ArrayList<DayData>();
        initMonthParams();
        // Добавляет TextView этого месяца
//        calendar.add(Calendar.MONTH, 1);
        int thisMonthDaysNumberTotal = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        System.out.println("Mаксимальный день в месяце текущем "+Integer.toString(calendar.get(Calendar.MONTH)+1)+" "
//                +Integer.toString(thisMonthDaysNumberTotal)+" ");
        int indexVstavlenogoDniaOtPervogoHisla = 0;
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) vEtomMesiacePervoeHisloVVoskresenie = true;
        if (calendar.get(Calendar.DAY_OF_WEEK) == 2) vEtomMesiacePervoeHisloVVtornik = true;
//        System.out.println("Create arr month " + Integer.toString(calendar.get(Calendar.MONTH) + 1));

        //заполняет в массив временное значение для предыдущего месяца
        if (!vEtomMesiacePervoeHisloVVoskresenie) {
            // System.out.println("IF  ! vEtomMesiacePervoeHisloVVoskresenie"+Integer.toString(calendar.get(Calendar.MONTH)+1));
            indexVstavlenogoDniaOtPervogoHisla= calendar.get(Calendar.DAY_OF_WEEK) - 3 ;
            for (int x = 0; x < calendar.get(Calendar.DAY_OF_WEEK) - 2; x++) {
                //чтобы создать места в массиве предыдущего месяца,
                // вставляем временные значения в ячейки предыдущего месяца
                addDate = new DayData(new DateData(calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), 1));
                addDate.setTextColor(Color.RED);
                monthContent.add(addDate);
                System.out.println("Add date to massiv "+1);


            }
        } else {
            //System.out.println("NOOT IF  ! vEtomMesiacePervoeHisloVVoskresenie"+Integer.toString(calendar.get(Calendar.MONTH)+1));
            indexVstavlenogoDniaOtPervogoHisla = 5;
            for (int x = 0; x < 6; x++) {
                //чтобы создать места в массиве предыдущего месяца,
                // вставляем временные значения в ячейки предыдущего месяца
                addDate = new DayData(new DateData(calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), 1));
                addDate.setTextColor(Color.RED);
                monthContent.add(addDate);
            }
        }
        //System.out.println("indexVstavlenogoDniaOtPervogoHisla = "+indexVstavlenogoDniaOtPervogoHisla);

//заполняет даты в массив числа текущего месяца
        for (int day = 1; day < thisMonthDaysNumberTotal + 1; day++) {
            addDate = new DayData(new DateData(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), day));
            addDate.setTextColor(Color.RED);
//            addDate.setTextColor(Color.BLUE);
            monthContent.add(addDate);
                System.out.println(Integer.toString(day)+" if Calendar.DAY_OF_WEEK "+Integer.toString(calendar.get(Calendar.MONTH)+1)+"m "
                        +Integer.toString(calendar.get(Calendar.DAY_OF_MONTH))+"d");

        }
        // Добавляет TextView предыдущего месяца
        calendar.add(Calendar.MONTH, -1);
        int lastMonthDayNumberPreMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //if для того, что-бы не вставлять в понедельник последнее число предыдущего месяца
        //вместо первого
        if(!vEtomMesiacePervoeHisloVVtornik) {
            for (int preDay = lastMonthDayNumberPreMonth; indexVstavlenogoDniaOtPervogoHisla >= 0;
                 indexVstavlenogoDniaOtPervogoHisla--) {

                addDate = new DayData(new DateData(calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), preDay));
                addDate.setTextColor(Color.LTGRAY);
                monthContent.set(indexVstavlenogoDniaOtPervogoHisla, addDate);
                preDay--;
            }
        }

        // Добавляет TextView следующего месяца
        calendar.add(Calendar.MONTH, 2);
        for (int afterDay = 1; monthContent.size() < 42; afterDay++) {
            addDate = new DayData(new DateData(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), afterDay));
            addDate.setTextColor(Color.LTGRAY);
            monthContent.add(addDate);
        }
    }


    //понять понедельный либо помесячный вид
    public ArrayList getData() {
            return monthContent;
}

    //определяет старт и финиш дат месяца в массиве, что бы знать куда их воткнуть ,
    // если вставлять первым текущий месяц
    private void initMonthParams() {
        weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
//        System.out.println("initMonthParams "+"Calendar.DAY_OF_WEEK "+Integer.toString(Calendar.DAY_OF_WEEK));
        //подгонка на ноябрь, бред TODO
//        if (calendar.get(Calendar.MONTH) == 11)
//            weekIndex--;
        preNumber = weekIndex - 1;
//        System.out.println("initMonthParams "+"preNumber "+Integer.toString(preNumber));
        afterNumber = 42 - calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - preNumber;
//        System.out.println("initMonthParams "+"preNumber "+Integer.toString(afterNumber));
    }
}
