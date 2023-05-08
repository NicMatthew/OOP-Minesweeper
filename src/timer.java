import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class timer extends JFrame {
    private Timer timer;
    private int seconds=10;

    private JLabel timerLabel;

    public timer () {
        setTitle("Timer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timerLabel = new JLabel("");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));

        startTimer();

        add(timerLabel);
//        add(resetButton);
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds--;
                timerLabel.setText(String.format("%d",seconds));
                if (seconds==0){
                    stopTimer();
                }
            }
        });
        timer.start();
    }

    private void stopTimer() {
        timer.stop();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                timer  timerGUI = new timer ();
                timerGUI.setVisible(true);
            }
        });
    }
}
