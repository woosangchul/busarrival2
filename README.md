# 안드로이드 셔틀버스 프로젝트


<div align=center>
  
![img](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/476f3682-845b-4076-b799-70a42d4ae3bc/Untitled.gif?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210910%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210910T022457Z&X-Amz-Expires=86400&X-Amz-Signature=2af163b9c43e33107f631228247e70a4cbb478628978b9921697d46e6445e574&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.gif%22)
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

![img](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/23a47f13-82c3-4047-8b26-fa7a03c83ad1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210910%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210910T022640Z&X-Amz-Expires=86400&X-Amz-Signature=ab63fd62e08ed579f7c66ee16d0cf5d2486e806d79b72b2f9e19daa528782bc3&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)



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

