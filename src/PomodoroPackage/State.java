package PomodoroPackage;

public abstract class State {
    public PomodoroApp pomoApp;
    abstract void pressRunButton();
    abstract void pressAddButton();
    abstract void pressDelButton();
}
