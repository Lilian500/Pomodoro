package PomodoroPackage;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PomodoroApp {
    //GUI Attributes
    private JButton addButton;
    public JPanel backPanel;
    private JList listOfSchedulesPanel;
    private JButton runButton;
    private JButton deleteButton;

    //Context Attributes
    private ScheduleBuilder scheduleSystem;
    private State state;
    private State notReadyState;
    private State readyState;
    private State buildState;
    private State runState;
    private int selectedSchedIndex;


    public PomodoroApp() {
        scheduleSystem = new ScheduleBuilder("Schedule System");
        notReadyState = new NotReadyState(this);
        readyState = new ReadyState(this);
        buildState = new BuildState(this);
        runState = new RunState(this);
        state = notReadyState;

        JFrame frame = new JFrame("PomodoroApp");
        frame.setContentPane(backPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        updateModel();

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("run clicked");
                selectedSchedIndex = listOfSchedulesPanel.getSelectedIndex();
                pressRun();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("add clicked");
                pressAdd();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("del clicked");
                selectedSchedIndex = listOfSchedulesPanel.getSelectedIndex();
                pressDel();
            }
        });

        listOfSchedulesPanel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("list engaged: ");
                //System.out.println(e);
                System.out.println(listOfSchedulesPanel.getSelectedValue());
            }
        });

    }

    public void updateModel(){
        DefaultListModel model = new DefaultListModel();
        listOfSchedulesPanel.setModel(model);

        for (ScheduleItem s : scheduleSystem.getRootSchedule().getScheduleItems()) {
            model.addElement(s);
        }
    }

    public void pressRun(){
        state.pressRunButton();
    }

    public void pressAdd() {
        state.pressAddButton();
    }

    public void pressDel(){
        state.pressDelButton();
    }

    public void setState(State newState){
        this.state = newState;
    }

    public ScheduleBuilder getScheduleSystem() { return scheduleSystem; }

    public State getState() {
        return state;
    }

    public State getReadyState() {
        return readyState;
    }

    public State getNotReadyState() {
        return notReadyState;
    }

    public State getRunState() {
        return runState;
    }

    public State getBuildState() {
        return buildState;
    }

    public int getSelectedSchedIndex() { return selectedSchedIndex; }
}
