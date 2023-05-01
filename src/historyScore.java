import javax.swing.*;
import java.awt.*;

public class historyScore extends JFrame {

    public static ImageIcon imageResize(ImageIcon image, int width, int height) {
        ImageIcon lama = image;
        Image lama1 = lama.getImage();
        Image baru1 = lama1.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(baru1);

        return baru;
    }
    public historyScore(){
        JPanel topPanel = new JPanel(new GridLayout(1,1));
        topPanel.setBounds(19,50,750,100);
        topPanel.setOpaque(false);
        topPanel.setBackground(new Color(0, 0, 0,0));

        JLabel historyTitle = new JLabel();
        ImageIcon titleImage = new ImageIcon("Assets/historyTitle.png");
        historyTitle.setIcon(imageResize(titleImage, 750, 100));
        historyTitle.setHorizontalAlignment(JLabel.CENTER);

        //Background Image
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("Assets/background.png"));
        Dimension size = bg.getPreferredSize();
        bg.setBounds(0, 0, size.width, size.height);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setTitle("Minesweeper/Score History");
        setResizable(false);
        setVisible(true);

        topPanel.add(historyTitle);
        add(topPanel);
        add(bg);


    }

}
