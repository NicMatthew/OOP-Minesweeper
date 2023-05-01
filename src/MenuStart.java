
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuStart extends JFrame implements MouseListener {
    
    public static ImageIcon imageResize(ImageIcon image, int width, int height) {
        ImageIcon lama = image;
        Image lama1 = lama.getImage();
        Image baru1 = lama1.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(baru1);

        return baru;
    }
    JLabel start;
    JLabel quit;
    JLabel history;
    ImageIcon historyImage = new ImageIcon("src/Assets/historyLogo.png");
    ImageIcon startImage = new ImageIcon("src/Assets/start.png");
    ImageIcon quitImage = new ImageIcon("src/Assets/quit.png");
    ImageIcon startImageHover = new ImageIcon("src/Assets/start_hover.png");
    ImageIcon quitImageHover = new ImageIcon("src/Assets/quit_hover.png");

    public MenuStart() {
        start = new JLabel();
        quit = new JLabel();
        history = new JLabel();
        JPanel panelJudul = new JPanel();
        JPanel panelHistory = new JPanel();
        panelHistory.setOpaque(false);
        panelHistory.setBackground(new Color(0, 0, 0, 0));
        // panelHistory.setBackground(Color.red);
        panelHistory.setBounds(680, 650, 100, 100);
        history.setIcon(imageResize(historyImage, 100, 100));
        history.addMouseListener(this);
        // history.setBounds(0, 0, 100, 100);
        panelHistory.add(history);
        // panelJudul.setBackground(Color.red);
        panelJudul.setOpaque(false);
        panelJudul.setBackground(new Color(0, 0, 0,0));
        panelJudul.setBounds(0, 200, 780, 100);
        JLabel judul = new JLabel();
        ImageIcon logo = new ImageIcon("src/Assets/title_text.png");
        judul.setIcon(imageResize(logo, 700, 120));
        // judul.setBounds(0,0,500,100);
        panelJudul.add(judul);



        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBounds(250, 350, 300, 300);
        panel.setOpaque(false);
        panel.setBackground(new Color(0, 0, 0,0));
        // panel.setBackground(Color.red);
        
        

        start.setIcon(imageResize(startImage, 300, 120));
        start.setHorizontalAlignment(JLabel.CENTER);
        quit.setIcon(imageResize(quitImage, 300, 120));
        quit.setHorizontalAlignment(JLabel.CENTER);
        panel.add(start);
        panel.add(quit);
        start.addMouseListener(this);
        quit.addMouseListener(this);
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("src/Assets/background.png"));
        Dimension size = bg.getPreferredSize();
        bg.setBounds(0, 0, size.width, size.height);
        


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(null);
        setTitle("Minesweeper");
        setResizable(false);
        add(panelJudul);
        add(panel);
        add(panelHistory);
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
        // throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
        if (e.getSource() == quit) {
            dispose();
        }
        if (e.getSource() == start) {
            dispose();
            new menuLevel();
        }
        if (e.getSource() == history) {
            dispose();
            new historyScore();
        }
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
        if (e.getSource() == start) {
            start.setIcon(imageResize(startImageHover, 300, 120));
        }
        if (e.getSource() == quit) {
            quit.setIcon(imageResize(quitImageHover, 300, 120));
        }

        
        // throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == start) {
            start.setIcon(imageResize(startImage, 300, 120));
        }
        if (e.getSource() == quit) {
            quit.setIcon(imageResize(quitImage, 300, 120));
        }
        // throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

}


