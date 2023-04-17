
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuStart {
    public static ImageIcon imageResize(ImageIcon image, int width, int height) {
        ImageIcon lama = image;
        Image lama1 = lama.getImage();
        Image baru1 = lama1.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(baru1);
        
        return baru;
    }

    public static void main(String[] args) {
        JPanel panelJudul = new JPanel();
        // panelJudul.setBackground(Color.red);
        panelJudul.setOpaque(false);
        panelJudul.setBackground(new Color(0, 0, 0,0));
        panelJudul.setBounds(0, 200, 780, 100);
        JLabel judul = new JLabel();
        ImageIcon logo = new ImageIcon("Assets/logo.png");
        judul.setIcon(imageResize(logo, 700, 90));
        // judul.setBounds(0,0,500,100);
        panelJudul.add(judul);



        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBounds(0, 350, 780, 300);
        panel.setOpaque(false);
        panel.setBackground(new Color(0, 0, 0,0));
        JLabel start = new JLabel();
        JLabel quit = new JLabel();
        ImageIcon startImage = new ImageIcon("Assets/start.png");
        ImageIcon quitImage = new ImageIcon("Assets/quit.png");

        start.setIcon(imageResize(startImage, 300, 150));
        start.setHorizontalAlignment(JLabel.CENTER);
        quit.setIcon(imageResize(quitImage, 300, 150));
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


