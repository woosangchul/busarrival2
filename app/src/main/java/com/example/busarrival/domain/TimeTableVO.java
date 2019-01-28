package com.example.busarrival.domain;

import java.util.ArrayList;
import java.util.Map;

public class TimeTableVO {
    private String departText; // 출발지 텍스트
    private String arriveText; // 도착지 테스트
    private Map<Integer, Integer> scheduleBusMap; //스케줄 맵
    private ArrayList<String> scheduleBusList; // 스케줄 리스트
    private Map<Integer, Integer> scheduleSubMap; //스케줄 맵
    private ArrayList<String> scheduleSubList; // 스케줄 리스트


    public TimeTableVO() {
    }

    public TimeTableVO(String departText, String arriveText, Map<Integer, Integer> scheduleBusMap, ArrayList<String> scheduleBusList, Map<Integer, Integer> scheduleSubMap, ArrayList<String> scheduleSubList) {
        this.departText = departText;
        this.arriveText = arriveText;
        this.scheduleBusMap = scheduleBusMap;
        this.scheduleBusList = scheduleBusList;
        this.scheduleSubMap = scheduleSubMap;
        this.scheduleSubList = scheduleSubList;
    }

    public void setTimeTableVOAllFields(String departText, String arriveText, Map<Integer, Integer> scheduleBusMap, ArrayList<String> scheduleBusList, Map<Integer, Integer> scheduleSubMap, ArrayList<String> scheduleSubList){
        this.departText = departText;
        this.arriveText = arriveText;
        this.scheduleBusMap = scheduleBusMap;
        this.scheduleBusList = scheduleBusList;
        this.scheduleSubMap = scheduleSubMap;
        this.scheduleSubList = scheduleSubList;
    }
    public String getDepartText() {
        return departText;
    }

    public void setDepartText(String departText) {
        this.departText = departText;
    }

    public String getArriveText() {
        return arriveText;
    }

    public void setArriveText(String arriveText) {
        this.arriveText = arriveText;
    }

    public Map<Integer, Integer> getScheduleBusMap() {
        return scheduleBusMap;
    }

    public void setScheduleBusMap(Map<Integer, Integer> scheduleBusMap) {
        this.scheduleBusMap = scheduleBusMap;
    }

    public Map<Integer, Integer> getScheduleSubMap() {
        return scheduleSubMap;
    }

    public void setScheduleSubMap(Map<Integer, Integer> scheduleSubMap) {
        this.scheduleSubMap = scheduleSubMap;
    }

    public ArrayList<String> getScheduleBusList() {
        return scheduleBusList;
    }

    public void setScheduleBusList(ArrayList<String> scheduleBusList) {
        this.scheduleBusList = scheduleBusList;
    }

    public ArrayList<String> getScheduleSubList() {
        return scheduleSubList;
    }

    public void setScheduleSubList(ArrayList<String> scheduleSubList) {
        this.scheduleSubList = scheduleSubList;
    }
}
