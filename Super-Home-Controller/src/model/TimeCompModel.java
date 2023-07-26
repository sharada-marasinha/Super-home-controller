package model;

public class TimeCompModel {
   private String startHour;
   private String startMinute;

   private String endHour;
   private String endMinute;

    public TimeCompModel(String startHour, String startMinute, String endHour, String endMinute) {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(String startMinute) {
        this.startMinute = startMinute;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(String endMinute) {
        this.endMinute = endMinute;
    }

    @Override
    public String toString() {
        return "Starts at : " + startHour + "." + startMinute +
                "  Ends at : " + endHour + "." + endMinute;
    }
}
