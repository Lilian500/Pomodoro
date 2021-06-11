package PomodoroPackage;

public abstract class SelectionState extends State{

    @Override
    public void pressAddButton(){
        pomoApp.setState(pomoApp.getBuildState());

        selectDirectorDialog sdd = new selectDirectorDialog();
        String directorType= sdd.getSelection();

        if(directorType == "Custom Schedule"){
            System.out.println("Custom Builder initiating...");
            new CustomBuildDirector(pomoApp.getScheduleSystem()).buildSchedule();
            pomoApp.updateModel();
        }
        else if (directorType == "Default Schedule"){
            System.out.println("Default Builder initiating...");
            new DefaultBuildDirector(pomoApp.getScheduleSystem()).buildSchedule();
            pomoApp.updateModel();
        }
        else{
            pomoApp.setState(getThisState());
            return;
        }

        pomoApp.setState(pomoApp.getReadyState());
    }

    public abstract State getThisState();
}
