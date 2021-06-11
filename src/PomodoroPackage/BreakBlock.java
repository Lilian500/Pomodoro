package PomodoroPackage;

public class BreakBlock extends TimeBlock{
    BreakBlock(float time){
        this.time_minutes = time;
        int time_sec = (int) (time_minutes * 60);
        this.label = "Break Block:\nTake a " + (time_sec/60) + ":" + (time_sec % 60) +  "min break.";
    }
}
