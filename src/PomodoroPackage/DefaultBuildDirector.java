package PomodoroPackage;

public class DefaultBuildDirector extends BuildDirector {

    DefaultBuildDirector(ScheduleBuilder schedSystem){
        this.builder = schedSystem;
    }

    @Override
    public void buildSchedule() {
        builder.setCurrentSchedule("Schedule System");
        builder.addSchedule("Default Schedule");
        builder.addStudyTime(25);
        builder.addBreakTime(5);
        builder.addStudyTime(25);
        builder.addBreakTime(5);
        builder.addStudyTime(25);
        builder.addBreakTime(5);
        builder.addStudyTime(25);
        builder.setCurrentSchedule("Schedule System");
    }
}
