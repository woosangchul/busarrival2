package com.example.busarrival.domain;

public class ScheduleVO {
    private int status=-1;
    private String busTimeFirstTypeMiute; //현재시간 16:00 버스출발시간 16:10일 경우 "10분후 도착" 저장
    private String busTimeNextTypeMiute;
    private String subTimeFirstTypeMiute;
    private String subTimeNextTypeMiute;

    private String busTimeFirstTypeTime; //현재시간 16:00 버스출발시간 16:10일 경우 "16:10" 저장
    private String busTimeNextTypeTime;
    private String subTimeFirstTypeTime;
    private String subTimeNextTypeTime;

    public void setBusTimeFirstType(String busTimeFirstTypeMiute, String busTimeFirstTypeTime) {
        this.busTimeFirstTypeMiute = busTimeFirstTypeMiute;
        this.busTimeFirstTypeTime = busTimeFirstTypeTime;
    }

    public void setBusTimeNextType(String busTimeNextTypeMiute, String busTimeNextTypeTime) {
        this.busTimeNextTypeMiute = busTimeNextTypeMiute;
        this.busTimeNextTypeTime = busTimeNextTypeTime;
    }

    public void setSubTimeFirstType(String subTimeFirstTypeMiute, String subTimeFirstTypeTime) {
        this.subTimeFirstTypeMiute = subTimeFirstTypeMiute;
        this.subTimeFirstTypeTime = subTimeFirstTypeTime;
    }

    public void setSubTimeNextType(String subTimeNextTypeMiute, String subTimeNextTypeTime) {
       this.subTimeNextTypeMiute = subTimeNextTypeMiute;
       this.subTimeNextTypeTime = subTimeNextTypeTime;
    }

    public String getBusTimeFirstTypeMiute() {
        return busTimeFirstTypeMiute;
    }

    public String getBusTimeNextTypeMiute() {
        return busTimeNextTypeMiute;
    }

    public String getSubTimeFirstTypeMiute() {
        return subTimeFirstTypeMiute;
    }

    public String getSubTimeNextTypeMiute() {
        return subTimeNextTypeMiute;
    }

    public String getBusTimeFirstTypeTime() {
        return busTimeFirstTypeTime;
    }

    public String getBusTimeNextTypeTime() {
        return busTimeNextTypeTime;
    }

    public String getSubTimeFirstTypeTime() {
        return subTimeFirstTypeTime;
    }

    public String getSubTimeNextTypeTime() {
        return subTimeNextTypeTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}








