package PomodoroPackage;

public class BuildState extends State{
    public BuildState(PomodoroApp app){ this.pomoApp = app; }

    @Override
    public void pressRunButton() {
        System.out.println("Build State: Run Button Pressed, Do nothing.");
    }

    @Override
    public void pressAddButton() { System.out.println("Build State: Add Button Pressed, Do nothing."); }

    @Override
    public void pressDelButton() { System.out.println("Build State: Delete Button Pressed, Do nothing."); }
}
