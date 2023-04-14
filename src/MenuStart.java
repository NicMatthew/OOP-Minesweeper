
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuStart {

    public static void main(String[] args) {
        JPanel panelJudul = new JPanel();
        // panelJudul.setBackground(Color.red);
        panelJudul.setOpaque(false);
        panelJudul.setBackground(new Color(0, 0, 0,0));
        panelJudul.setBounds(0, 200, 780, 100);
        JLabel judul = new JLabel();

        ImageIcon lama = new ImageIcon("Assets/logo.png");
        Image lama1 = lama.getImage();
        Image baru1 = lama1.getScaledInstance(700, 90, java.awt.Image.SCALE_SMOOTH);
        ImageIcon gambarJudul = new ImageIcon(baru1);

        judul.setIcon(gambarJudul);
        // judul.setBounds(0,0,500,100);
        panelJudul.add(judul);



        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBounds(0, 350, 780, 300);
        panel.setBackground(Color.red);
        JLabel start = new JLabel();

        start.setIcon(new ImageIcon("Assets/start.png"));
        start.setHorizontalAlignment(JLabel.CENTER);
        JLabel quit = new JLabel();
        quit.setIcon(new ImageIcon("Assets/quit.png"));
        quit.setHorizontalAlignment(JLabel.CENTER);
        panel.add(start);
        panel.add(quit);



        
        



        
        
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("Assets/background.png"));
        Dimension size = bg.getPreferredSize();
        bg.setBounds(0,0,size.width,size.height);


        JFrame frame = new JFrame();
        // frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setTitle("MINESWEEPER");
        frame.setResizable(false);
        // frame.setContentPane();
        // frame.add(background);
        frame.add(panelJudul);
        frame.add(panel);
        Container c = frame.getContentPane();
        c.add(bg);
        frame.setVisible(true);
        // frame.add(bg);
        

    }

}


