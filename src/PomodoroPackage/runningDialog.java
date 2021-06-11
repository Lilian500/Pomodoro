package PomodoroPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class runningDialog extends JDialog {
    private JPanel contentPane;
    private JButton startButton;
    private JLabel label;
    private JLabel timerLabel;
    int time_sec;

    public runningDialog(String label, float time_mins) {
        this.label.setText(label);
        time_sec = (int) (time_mins * 60);

        setContentPane(contentPane);
        pack();
        setModal(true);

        timerLabel.setText(time_sec / 60 + ":" + time_sec % 60);

        Timer timer = new Timer(1000, null);

        ActionListener p = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time_sec--;
                if(time_sec >= 1){
                    timerLabel.setText(time_sec/ 60 + ":" + time_sec% 60);
                }
                else{
                    timer.stop();
                    for(int i = 0; i < 5; i++){
                        Toolkit.getDefaultToolkit().beep();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }
                    dispose();
                }
            }
        };

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.addActionListener(p);
                startButton.setEnabled(false);
                timer.start();
            }

        });

        setVisible(true);
    }

}


