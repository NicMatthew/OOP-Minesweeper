import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class menuLevel extends JFrame implements MouseListener {
    public static ImageIcon imageResize(ImageIcon image, int width, int height) {
        ImageIcon lama = image;
        Image lama1 = lama.getImage();
        Image baru1 = lama1.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(baru1);

        return baru;
    }

    JLabel easy;
    JLabel medium;
    JLabel hard;
    ImageIcon easyImg = new ImageIcon("src/Assets/easy.png");
    ImageIcon mediumImg = new ImageIcon("src/Assets/medium.png");
    ImageIcon hardImg = new ImageIcon("src/Assets/hard.png");

    ImageIcon easyHover = new ImageIcon("src/Assets/easy_hover.png");
    ImageIcon mediumHover = new ImageIcon("src/Assets/medium_hover.png");
    ImageIcon hardHover = new ImageIcon("src/Assets/hard_hover.png");


    public menuLevel(){

        //Judul 
        JPanel panelJudul = new JPanel();
        panelJudul.setOpaque(false);
        panelJudul.setBackground(new Color(0, 0, 0,0));
        panelJudul.setBounds(0, 200, 780, 80);

        JLabel judul = new JLabel();
        ImageIcon logo = new ImageIcon("src/Assets/choose.png");
        judul.setIcon(imageResize(logo, 710, 80));

        //Panel for level
        JPanel levelPanel = new JPanel(new GridLayout(3,1));
        levelPanel.setBounds(250, 290, 300, 300);
        levelPanel.setOpaque(false);
        levelPanel.setBackground(new Color(0, 0, 0,0));
        // levelPanel.setBackground(Color.BLUE);

        //Easy
        easy = new JLabel();
        easy.setIcon(imageResize(easyImg, 250, 90));
        easy.setHorizontalAlignment(JLabel.CENTER);
        easy.addMouseListener(this);

        //Medium
        medium = new JLabel();
        medium.setIcon(imageResize(mediumImg, 250, 90));
        medium.setHorizontalAlignment(JLabel.CENTER);
        medium.addMouseListener(this);


        //Hard
        hard = new JLabel();
        hard.setIcon(imageResize(hardImg, 250, 90));
        hard.setHorizontalAlignment(JLabel.CENTER);
        hard.addMouseListener(this);

        //Background Image
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("src/Assets/background.png"));
        Dimension size = bg.getPreferredSize();
        bg.setBounds(0, 0, size.width, size.height);
        setSize(800,800);
        setLayout(null);
        setTitle("Minesweeper/ Choose Level");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        levelPanel.add(easy);
        levelPanel.add(medium);
        levelPanel.add(hard);
        add(levelPanel);
        panelJudul.add(judul);
        add(panelJudul);
        add(bg);
    }

    public static void main(String[] args) {
        new menuLevel();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
        if(e.getSource() == easy){
            easy.setIcon(imageResize(easyHover, 250, 90));
        }
        if(e.getSource() == medium){
            medium.setIcon(imageResize(mediumHover, 250, 90));
        }
        if(e.getSource() == hard){
            hard.setIcon(imageResize(hardHover, 250, 90));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
        if(e.getSource() == easy){
            easy.setIcon(imageResize(easyImg, 250, 90));
        }
        if(e.getSource() == medium){
            medium.setIcon(imageResize(mediumImg, 250, 90));
        }
        if(e.getSource() == hard){
            hard.setIcon(imageResize(hardImg, 250, 90));
        }
    }

}
