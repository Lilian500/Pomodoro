package PomodoroPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class enterNameDialog extends JDialog {
    private JPanel contentPane;
    private JTextField textField;
    private JButton enterButton;

    private String scheduleName;

    public enterNameDialog() {
        setContentPane(contentPane);
        pack();
        setModal(true);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(contentPane, "You must enter a name.");
                }
                else{
                    scheduleName = textField.getText();
                    dispose();
                }
            }
        });

        setVisible(true);
    }

    public String getScheduleName() {
        return scheduleName;
    }
}
