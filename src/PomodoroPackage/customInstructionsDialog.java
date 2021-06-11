package PomodoroPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class customInstructionsDialog extends JDialog {
    private JPanel contentPane;
    private JButton addButton;
    private JButton delButton;
    private JButton finishButton;
    private JList timeBlocksList;

    private ArrayList <InstructionsComponent> schedInstructions;
    private String scheduleName;


    public customInstructionsDialog() {
        schedInstructions = new ArrayList<InstructionsComponent>();
        setContentPane(contentPane);
        pack();
        setModal(true);
        DefaultListModel model = new DefaultListModel();
        timeBlocksList.setModel(model);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InstructionsComponent ic = new setupTimeBlockDialog().getTimeBlockInstruction();
                if(ic.blockTpe != null) {
                    schedInstructions.add(ic);
                    model.addElement(ic);
                }
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timeBlocksList.getSelectedIndex() != -1){
                    int selectedIndex = timeBlocksList.getSelectedIndex();
                    model.remove(selectedIndex);
                    schedInstructions.remove(selectedIndex);
                }
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleName = new enterNameDialog().getScheduleName();
                dispose();
            }
        });
        setVisible(true);
    }

    public ArrayList<InstructionsComponent> getSchedInstructions() {
        return schedInstructions;
    }

    public String getScheduleName() {
        return scheduleName;
    }
}
