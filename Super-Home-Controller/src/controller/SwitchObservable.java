package controller;
public class SwitchObservable {
    private SwitchObserver [] switchObserverArray=new SwitchObserver[100];
    private int nextIndex;
    private int condition;
    private String startHour, startMinute, endHour, endMinute;
    private int notifyIndex;
    public void addSwitchObserver(SwitchObserver ob){
        switchObserverArray[nextIndex++]=ob;
    }
    public void setCondition(int condition){
        if(this.condition!=condition){
            this.condition=condition;
            notifyObserver();
        }
    }
    public void notifyObserver(){
        for (int i = 0; i < nextIndex; i++){
            switchObserverArray[i].update(condition);

        }

    }
    public void getIndexForNotify(int notifyIndex){
        this.notifyIndex=notifyIndex;
    }

    public void setTime(String startHour, String startMinute, String endHour, String endMinute){
        if(this.startHour != startHour || this.startMinute != startMinute || this.endHour != endHour || this.endMinute!=endMinute){
            this.startHour=startHour;
            this.startMinute=startMinute;
            this.endHour=endHour;
            this.endMinute=endMinute;
            notifyByIndex();
        }
    }
    public void notifyByIndex(){
        switchObserverArray[notifyIndex].updateTime(startHour, startMinute, endHour, endMinute);
    }
    public void notifyTime(){
        for (int i = 0; i < nextIndex; i++){
            switchObserverArray[i].updateTime(startHour, startMinute, endHour, endMinute);
        }
    }
}
