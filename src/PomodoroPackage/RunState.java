package PomodoroPackage;

public class RunState extends State{
    public RunState(PomodoroApp app){ this.pomoApp = app; }

    @Override
    public void pressRunButton() { System.out.println("Run State: Run Button Pressed, Do nothing."); }

    @Override
    public void pressAddButton() { System.out.println("Run State: Add Button Pressed, Do nothing."); }

    @Override
    public void pressDelButton() { System.out.println("Run State: Delete Button Pressed, Do nothing."); }
}
