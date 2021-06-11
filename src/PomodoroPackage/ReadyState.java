package PomodoroPackage;


public class ReadyState extends SelectionState{

    public ReadyState(PomodoroApp app){
        this.pomoApp = app;
    }

    @Override
    public void pressRunButton() {
        System.out.println("Ready State: Run Button Pressed, running schedule...");
        pomoApp.setState(pomoApp.getRunState());

        if(pomoApp.getSelectedSchedIndex() != -1) {
            Schedule selectedSchedule = (Schedule) pomoApp.getScheduleSystem().getRootSchedule().getScheduleItems()
                    .get(pomoApp.getSelectedSchedIndex());
            for (ScheduleItem currentTimeBlock : selectedSchedule.getScheduleItems()) {
                TimeBlock timeBlock = (TimeBlock) currentTimeBlock;
                new runningDialog(timeBlock.getLabel(), timeBlock.getTime_minutes());
            }
        }
        pomoApp.setState(pomoApp.getReadyState());
    }

    @Override
    public void pressDelButton() {
        System.out.println("Ready State: del Button Pressed, deleting selected schedule");
        if(pomoApp.getSelectedSchedIndex() != -1) {
            pomoApp.getScheduleSystem().getRootSchedule().getScheduleItems().remove(pomoApp.getSelectedSchedIndex());

            pomoApp.updateModel();

            if(pomoApp.getScheduleSystem().getRootSchedule().getScheduleItems().isEmpty())
                pomoApp.setState(pomoApp.getNotReadyState());
        }
    }

    @Override
    public State getThisState(){
        return pomoApp.getNotReadyState();
    }
}
