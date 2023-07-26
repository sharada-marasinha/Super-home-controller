package controller;

public interface SwitchObserver {
     void update(int condition);
     void updateTime(String startHour, String startMinute, String endHour, String endMinute);
}
