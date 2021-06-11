package PomodoroPackage;

import java.security.InvalidParameterException;
import java.util.Stack;

public class ScheduleBuilder {

    private Schedule rootSchedule;
    private Schedule currentSchedule;

    public ScheduleBuilder(String schedName){
        rootSchedule = new Schedule(schedName);
        currentSchedule = rootSchedule;
    }

    public StudyBlock addStudyTime(float time){
        StudyBlock studyBlock = new StudyBlock(time);
        currentSchedule.addScheduleItem(studyBlock);
        return studyBlock;
    }

    public BreakBlock addBreakTime(float time){
        BreakBlock breakBlock = new BreakBlock(time);
        currentSchedule.addScheduleItem(breakBlock);
        return breakBlock;
    }

    public Schedule addSchedule(String schedName){
        Schedule schedule = new Schedule(schedName);
        currentSchedule.addScheduleItem(schedule);
        currentSchedule = schedule;
        return schedule;
    }

    public Schedule setCurrentSchedule(String schedName){
        Stack<Schedule> schedStack = new Stack<Schedule>();
        schedStack.push(rootSchedule);
        while(!schedStack.empty()){
            Schedule currentSched = schedStack.pop();

            if(schedName == currentSched.name){
                this.currentSchedule = currentSched;
                return currentSched;
            }

            for(ScheduleItem item: currentSched.scheduleItems) {
                if(item instanceof Schedule)
                    schedStack.push((Schedule) item);
            }
        }
        throw new InvalidParameterException("Schedule name: " + schedName);
    }

    public Schedule getCurrentSchedule() {
        return currentSchedule;
    }

    public Schedule getRootSchedule() {
        return rootSchedule;
    }
}
