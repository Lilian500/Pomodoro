package PomodoroPackage;

public class InstructionsComponent {
    protected String blockTpe;
    protected float duration;

    @Override
    public String toString(){ return blockTpe + " - " + duration + "mins"; }
}
