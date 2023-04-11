import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends JFrame {
    int spacing = 5;
    int boxWidth = 80;
    public GUI(){
        this.setTitle("mineswepper");
        this.setSize(1286,829);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        Board board = new Board();
        this.setContentPane(board);
        Move move = new Move();
        this.addMouseMotionListener(move);
        CLick click = new CLick();
        this.addMouseListener(click);
    }

    public class Board extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.darkGray);
            g.fillRect(0,0,1280,800);
            g.setColor(Color.gray);
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 9; j++) {
                    g.fillRect(spacing+i*boxWidth,spacing+j*boxWidth+boxWidth,boxWidth-2*spacing,boxWidth-2*spacing);
                }
            }
        }
    }
    public class  Move implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println("moved");
        }
    }

    public class CLick implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Clicked");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
