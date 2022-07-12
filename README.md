# 안드로이드 셔틀버스 프로젝트


<div align=center>
  
![img](https://user-images.githubusercontent.com/40749537/138593884-342646ea-cdc2-454b-a411-5f6b6ddfbe60.gif)
</div>



## **개발환경**

- Android Studio
- Andriod Nexus 5X 24 (Android 7.0, API 24)



## **적용기술**

- Android Fragment

- Android RecyclerView



## **프로젝트 소개**

- 학교 셔틀버스 시간표를 볼 수 있는 어플리케이션 제작. 학교특성상 셔틀버스시간과 지하철 도착정보 같이 제공해야 함

- 기존에 존재하던 셔틀버스 어플리케이션 UX/UI가 굉장히 불편했다. 적용된 기술만 보자면 잘 만든 어플리케이션이였지만 사용자 UX/UI가 전혀 고려되지 않아 사용자들에게 외면당했다



**UI 구조도**

![img](https://user-images.githubusercontent.com/40749537/178414965-69cdd00a-0fe8-467c-a9e9-262cea154a02.png)



## **class 구조**

- adptor
  - pager나 RecyclerView Adapter에 대한 클래스 
- domain
  - 버스시간표나 지하철시간표에 대한 VO data 
- fragment
  - Fragment로 표현할 화면 클래스
- Listener
  - Fragment Touch 이벤트에 대한 리스너
- ver2
  - decoration까지 진행하고 싶었으나 뷰를 drawable을 통해 만들어줘야 원하는 기능을 구현할 수 있어 보류한 상태

```
busarrival
    ├─adaptor
    │      MyPagerAdapter.java
    │      MyRecyclerAdapter.java
    │      MySubwayRecyclerAdapter.java
    │      MyTransportationRecyclerAdapter.java
    │
    ├─domain
    │      ScheduleVO.java
    │      TimeCalculator.java
    │      TimeTableVO.java
    │      TransportationNew.java
    │
    ├─fragment
    │      BusFragment.java
    │      mainFragment.java
    │      SecondFragment.java
    │      SubwayFragment.java
    │      ThirdFragment.java
    │
    ├─Listener
    │      FragmentSelectedListener.java
    │      FragmentSelectedListenerImpl.java
    │
    └─ver2
            MainActivity.java
            MyItemDecoration.java
```

