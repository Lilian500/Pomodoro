package PomodoroPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class setupTimeBlockDialog extends JDialog {
    private JPanel contentPane;
    private JButton addButton;
    private JComboBox comboBox;
    private JTextField textField;

    private InstructionsComponent timeBlockInstruction;

    public setupTimeBlockDialog() {
        timeBlockInstruction = new InstructionsComponent();
        setContentPane(contentPane);
        pack();
        setModal(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(contentPane,"Enter Duration.");
                }
                else{
                    timeBlockInstruction.blockTpe = (String) comboBox.getSelectedItem();
                    timeBlockInstruction.duration = Float.parseFloat(textField.getText());
                    dispose();
                }
            }
        });
        setVisible(true);
    }

    public InstructionsComponent getTimeBlockInstruction() {
        return timeBlockInstruction;
    }
}
