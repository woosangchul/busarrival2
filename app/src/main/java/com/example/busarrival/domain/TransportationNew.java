package com.example.busarrival.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class TransportationNew extends TimeCalculator{
    private Map<Integer, Integer> busMap;
    private Map<Integer, Integer> subMap;
    private ArrayList<String> busSchedule;
    private ArrayList<String> subSchedule;
    private String departText, arriveText;
    private int busFlag=-1;
    private int subFlag=-1;


    public TransportationNew(Map<Integer, Integer> busMap, ArrayList<String> busSchedule, Map<Integer, Integer> subMap, ArrayList<String> subSchedule, String[] text) {
        this.busMap = busMap;
        this.subMap = subMap;
        this.busSchedule = busSchedule;
        this.subSchedule = subSchedule;
        this.departText = text[0]; //카드뷰에 표시할 출발지 이름(2캠 >> 지행)
        this.arriveText = text[1]; //카드뷰에 표시할 도착지 이름
    }

    public String getDepartText() {
        return departText;
    }

    public String getArriveText() {
        return arriveText;
    }

    /*
    * 모든 교통정보는 transMap 과 transSchedule로 구성
    * Map은 시간별 인덱스를 저장하고있고 Schedule는 시간정보 저장하고있음
    * 맵과 스케줄을 파라미터로 받아
    * 현재시간기준으로 현재시간바로 뒤에 스케쥴 인덱스를 찾아서 반환
    * */
    private int getScheduleIndex(Map<Integer, Integer> transMap, ArrayList<String> transSchedule){
        String str[] = new String[2];
        int flag=0;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (transMap.get(hour) != null) {
            Log.d("1234", String.valueOf(transSchedule.size()));
            for (int i = transMap.get(hour); i < transSchedule.size(); i++) {
                if (timeCompare(transSchedule.get(i))) {
                    flag = i;
                    break;
                }else if(i == transSchedule.size()-1){
                    flag = -1;
                }
            }
        }else {
            flag = -1;
        }
        return flag;
    }


    /*
     * 지하철 인덱스는 버스인덱스에 영향받음
     * 버스 인덱스를 입력하면 버스와 연동하여 탈수있는 지하철인덱스 반환
     *
     */
    private int getSubFlag(int tempFlagBus){
        int tempFlagSub = 0;
        if(tempFlagBus == -1)
            return -1;

        while(timeCompare(busSchedule.get(tempFlagBus),subSchedule.get(tempFlagSub))){
                tempFlagSub++;
        }
        return tempFlagSub;
    }

    public String[] getSchedule() {
        String str[] = new String[4];
        int tempBusFlag=0;
        int tempSubFlag=0;
        ScheduleVO scheduleText = new ScheduleVO();

        //int hour = calendar.get(Calendar.HOUR_OF_DAY);

        tempBusFlag = getScheduleIndex(busMap, busSchedule);

        if(tempBusFlag != -1){
            tempSubFlag = getSubFlag(tempBusFlag);
            scheduleText.setStatus(tempBusFlag);
            scheduleText.setBusTimeFirstType(timeCalc(busSchedule.get(tempBusFlag)),busSchedule.get(tempBusFlag) );
            scheduleText.setSubTimeFirstType(timeCalc(subSchedule.get(tempSubFlag)), subSchedule.get(tempSubFlag));
            scheduleText.setSubTimeNextType(timeCalc(subSchedule.get(tempSubFlag+1)), subSchedule.get(tempSubFlag+1));

            str[0] = timeCalc(busSchedule.get(tempBusFlag)) + "(" + busSchedule.get(tempBusFlag) + ")";
            str[2] = timeCalc(subSchedule.get(tempSubFlag)) + "(" + subSchedule.get(tempSubFlag) + ")";
            str[3] = timeCalc(subSchedule.get(tempSubFlag+1)) + "(" + subSchedule.get(tempSubFlag+1) + ")";

            if(tempBusFlag == busSchedule.size()-1){
                str[1] = "다음차 종료";
            }else
                str[1] = timeCalc(busSchedule.get(tempBusFlag+1)) + "(" + busSchedule.get(tempBusFlag+1) + ")";
                scheduleText.setBusTimeNextType(timeCalc(busSchedule.get(tempBusFlag+1)), busSchedule.get(tempBusFlag+1));
        }else{
            scheduleText.setStatus(tempBusFlag);
            scheduleText.setBusTimeFirstType("운행종료", "운행종료" );
            scheduleText.setBusTimeNextType("운행종료", "운행종료");
            scheduleText.setSubTimeFirstType("운행종료", "운행종료" );
            scheduleText.setSubTimeNextType("운행종료", "운행종료" );
            str[0] = "운행종료";
            str[1] = "운행종료";
            str[2] = "운행종료";
            str[3] = "운행종료";
        }
        return str;
    }

    public String[] getNextButton(String[] text){
       // int busFlag=0;
       // int subFlag=0;
        String str[] = new String[4];
        ScheduleVO scheduleText = new ScheduleVO();

        if(busFlag != -1){
            if(!timeCompare(busSchedule.get(busFlag)))
                busFlag = -1;
        }

        if(busFlag == -1){
            busFlag = getScheduleIndex(busMap, busSchedule);
        }

        if(busFlag < busSchedule.size()-1 && busFlag != -1){
            busFlag++;
        }

        if(busFlag == -1){
            scheduleText.setStatus(busFlag);
            scheduleText.setBusTimeFirstType(text[0],text[0]);
            scheduleText.setBusTimeNextType(text[1],text[1]);
            scheduleText.setSubTimeFirstType(text[2],text[2]);
            scheduleText.setSubTimeNextType(text[3],text[3]);
            str[0] = text[0];
            str[1] = text[1];
            str[2] = text[2];
            str[3] = text[3];
        }else {
            subFlag = getSubFlag(busFlag);
            scheduleText.setStatus(busFlag);
            scheduleText.setBusTimeFirstType(timeCalc(busSchedule.get(busFlag)),busSchedule.get(busFlag) );
            scheduleText.setSubTimeFirstType(timeCalc(subSchedule.get(subFlag)), subSchedule.get(subFlag));
            scheduleText.setSubTimeNextType(timeCalc(subSchedule.get(subFlag+1)), subSchedule.get(subFlag+1));
            str[0] = timeCalc(busSchedule.get(busFlag)) + "(" + busSchedule.get(busFlag) + ")";
            str[2] = timeCalc(subSchedule.get(subFlag)) + "(" + subSchedule.get(subFlag) + ")";
            str[3] = timeCalc(subSchedule.get(subFlag + 1)) + "(" + subSchedule.get(subFlag + 1) + ")";

            if (busFlag < busSchedule.size() - 1) {
                scheduleText.setBusTimeNextType(timeCalc(busSchedule.get(busFlag+1)), busSchedule.get(busFlag+1));
                str[1] = timeCalc(busSchedule.get(busFlag + 1)) + "(" + busSchedule.get(busFlag + 1) + ")";
            }else if(busFlag == busSchedule.size()-1)
                str[1] = "운행종료";
                scheduleText.setBusTimeNextType("운행종료","운행종료");
        }

        return str;

    }

    public String[] getPrevButton(String[] text){
        String[] str = new String[4];
        ScheduleVO scheduleText = new ScheduleVO();
        if(busFlag != -1){
            if(!timeCompare(busSchedule.get(busFlag)))
                busFlag = -1;
        }

        if(busFlag == -1){
            busFlag = getScheduleIndex(busMap, busSchedule);
        }

        if(busFlag != -1 && busFlag != 0){
            if(timeCompare(busSchedule.get(busFlag-1))){
                busFlag--;
            }
        }
        if(busFlag == -1){
            scheduleText.setStatus(busFlag);
            scheduleText.setBusTimeFirstType(text[0],text[0]);
            scheduleText.setBusTimeNextType(text[1],text[1]);
            scheduleText.setSubTimeFirstType(text[2],text[2]);
            scheduleText.setSubTimeNextType(text[3],text[3]);
            str[0] = text[0];
            str[1] = text[1];
            str[2] = text[2];
            str[3] = text[3];
        }else{
            subFlag = getSubFlag(busFlag);
            scheduleText.setBusTimeFirstType(timeCalc(busSchedule.get(busFlag)),busSchedule.get(busFlag) );
            scheduleText.setBusTimeNextType(timeCalc(busSchedule.get(busFlag+1)),busSchedule.get(busFlag+1) );
            scheduleText.setSubTimeFirstType(timeCalc(subSchedule.get(subFlag)), subSchedule.get(subFlag));
            scheduleText.setSubTimeNextType(timeCalc(subSchedule.get(subFlag+1)), subSchedule.get(subFlag+1));
            str[0] = timeCalc(busSchedule.get(busFlag)) + "(" + busSchedule.get(busFlag) + ")";
            str[1] = timeCalc(busSchedule.get(busFlag+1)) + "(" + busSchedule.get(busFlag+1) + ")";
            str[2] = timeCalc(subSchedule.get(subFlag)) + "(" + subSchedule.get(subFlag) + ")";
            str[3] = timeCalc(subSchedule.get(subFlag + 1)) + "(" + subSchedule.get(subFlag + 1) + ")";
        }
        return str;
    }




}
