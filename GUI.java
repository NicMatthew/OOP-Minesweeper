import javax.swing.*;
// import javax.swing.JPanel;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 * GUI
 */
public class GUI extends JFrame {
    int spacing = 5;
    public int mx = -100;
    public int my = -100;

    public GUI() {
        this.setTitle("Minesweeper");
        this.setSize(1280, 820);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
        // test commit
        this.setResizable(false);

        Board board = new Board();
        this.setContentPane(board);
        Move move = new Move();
        this.addMouseMotionListener(move);
        Click click = new Click();
        this.addMouseListener(click);



    }

    public class Board extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 80, 1280, 800);
            
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 9; j++) {
                    g.setColor(Color.gray);
                    if ((mx >= spacing + i * 80 && mx < (spacing + i * 80)+80 ) && (my >= spacing+j*80+80&&my<(spacing+j*80+80)+80)) {
                        g.setColor(Color.red);
                    }
                    g.fillRect(spacing + i * 80, spacing + j * 80+80, 80 - spacing, 80 - spacing);
                }
            }
        }

    }

    public class Move implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub
            // throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println("The Mouse Was Moved!");
            mx = e.getX()-8;
            my = e.getY()-31;
            // System.out.println("X: " + mx + ", Y: ", +my);
            System.out.println("X: " + mx + ", Y: " +my);

        }

    }

    public class Click implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("The Mouse Was Clicked!");

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
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            // throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
        }
    }
    
}
