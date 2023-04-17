
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuStart extends JFrame implements MouseListener{
    public static ImageIcon imageResize(ImageIcon image, int width, int height) {
        ImageIcon lama = image;
        Image lama1 = lama.getImage();
        Image baru1 = lama1.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(baru1);

        return baru;
    }

    public MenuStart() {
        JPanel panelJudul = new JPanel();
        // panelJudul.setBackground(Color.red);
        panelJudul.setOpaque(false);
        panelJudul.setBackground(new Color(0, 0, 0,0));
        panelJudul.setBounds(0, 200, 780, 100);
        JLabel judul = new JLabel();
        ImageIcon logo = new ImageIcon("Assets/title_text.png");
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
        bg.setBounds(0, 0, size.width, size.height);
        


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(null);
        setTitle("MINESWEEPER");
        setResizable(false);
        add(panelJudul);
        add(panel);
        Container c = getContentPane();
        c.add(bg);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuStart();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

}


