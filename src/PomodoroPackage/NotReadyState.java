package PomodoroPackage;

public class NotReadyState extends SelectionState{

    public NotReadyState(PomodoroApp app){
        this.pomoApp = app;
    }

    @Override
    public void pressRunButton() { System.out.println("Not Ready State: Run Button Pressed, Do nothing."); }

    @Override
    public void pressDelButton() {
        System.out.println("Not Ready State: Delete Button Pressed, Do nothing.");
    }

    @Override
    public State getThisState(){
        return pomoApp.getNotReadyState();
    }
}
