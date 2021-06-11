package PomodoroPackage;

import java.util.ArrayList;

public class CustomBuildDirector extends BuildDirector {
    private String scheduleName;
    private ArrayList<InstructionsComponent> buildInstructions;

    CustomBuildDirector(ScheduleBuilder schedSystem){ this.builder = schedSystem; }

    @Override
    public void buildSchedule() {
        customInstructionsDialog cid = new customInstructionsDialog();
        scheduleName = cid.getScheduleName();
        buildInstructions = cid.getSchedInstructions();

        if(scheduleName == null || buildInstructions.isEmpty()){
            return;
        }
        else{
            builder.addSchedule(scheduleName);
            for (InstructionsComponent ic: buildInstructions) {
                if(ic.blockTpe == "Study Block"){
                    builder.addStudyTime(ic.duration);
                }
                else if(ic.blockTpe == "Break Block"){
                    builder.addBreakTime(ic.duration);
                }
                else {}
            }
            builder.setCurrentSchedule("Schedule System");
        }
    }
}
