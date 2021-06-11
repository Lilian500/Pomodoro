package PomodoroPackage;
import java.util.ArrayList;
import java.util.List;

public class Schedule extends ScheduleItem{
    List<ScheduleItem> scheduleItems = new ArrayList<>();
    String name;

    public Schedule(String name){
        this.name = name;
    }

    public void addScheduleItem(ScheduleItem item){
        scheduleItems.add(item);
    }

    public List<ScheduleItem> getScheduleItems() { return scheduleItems; }

    @Override
    public String toString(){ return name; }
}
