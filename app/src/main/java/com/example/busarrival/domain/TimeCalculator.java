package com.example.busarrival.domain;

import java.util.Calendar;

public class TimeCalculator {
    private Calendar busTime = Calendar.getInstance();
    public static Calendar calendar = Calendar.getInstance();

    public boolean timeCompare(String time) {  //스마트폰 현재시계와 버스시계 비교해서 스마트폰시계보다 버스기계가 더 앞인지 여부 반환
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3,5));
        busTime.clear();
        busTime.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), hour, minute, 0);
        if (calendar.getTimeInMillis() < busTime.getTimeInMillis()) {
            return true;
        } else
            return false;
    }

    public boolean timeCompare(String time1, String time2) {


        Calendar cTime1 = Calendar.getInstance();
        Calendar cTime2 = Calendar.getInstance();
        cTime1.clear();
        cTime2.clear();
        cTime1.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), Integer.parseInt(time1.substring(0,2)), Integer.parseInt(time1.substring(3,5)), 0);
        cTime2.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), Integer.parseInt(time2.substring(0,2)), Integer.parseInt(time2.substring(3,5)), 0);
        if (cTime1.getTimeInMillis() > cTime2.getTimeInMillis()) {
            return true;
        } else
            return false;
    }


    public String timeCalc(String time) {
        long hour, minute;
        String temp = "";
        int length = time.length();
        int tempHour = Integer.parseInt(time.substring(0, 2));
        int tempMinute = Integer.parseInt(time.substring(3,5));

        if(length != 5) temp = time.substring(5,length);
        busTime.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), tempHour, tempMinute, 0);

        String str = "";

        long time1 = (busTime.getTimeInMillis() - calendar.getTimeInMillis()) / 1000;
        hour = time1 / (60 * 60);
        minute = (time1 - (hour * 60 * 60)) / 60;

        if (hour <= 24) {
            if (hour == 0)
                if (minute == 0)
                    str = "곧 도착";
                else
                    str = String.valueOf(minute) + "분";
            else
                str = String.valueOf(hour) + "시간" + String.valueOf(minute) + "분";
        } else
            str = "시간오류";

        return str;
    }

}