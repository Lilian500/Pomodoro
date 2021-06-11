package PomodoroPackage;

public class StudyBlock extends TimeBlock {
    StudyBlock(float time){
        this.time_minutes = time;
        int time_sec = (int) (time_minutes * 60);
        this.label = "Study Block:\nStay focused for " + time_sec/60 + ":" + time_sec % 60 + " minutes.";
    }
}
