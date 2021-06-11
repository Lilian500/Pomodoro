package PomodoroPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectDirectorDialog extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox;
    private JButton selectButton;

    private String selection = null;

    public selectDirectorDialog() {
        setContentPane(contentPane);
        pack();
        setModal(true);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selection = comboBox.getSelectedItem().toString();
                dispose();
            }
        });

        setVisible(true);
    }

    public String getSelection() {
        return selection;
    }
}
