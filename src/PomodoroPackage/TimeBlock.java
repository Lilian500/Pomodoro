package PomodoroPackage;

public abstract class TimeBlock extends ScheduleItem {
    protected String label;
    protected float time_minutes;

    public float getTime_minutes() {
        return time_minutes;
    }

    public String getLabel() { return label; }
}
