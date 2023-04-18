import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
// import java.awt.Dimension;
// import java.awt.Image;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
import java.util.Random;
// import javax.swing.ImageIcon;
import javax.swing.JPanel;
// /testtttttt
import java.util.ArrayList;

public class GUI extends JFrame {
    int spacing = 5;
    int boxWidth = 80;
    Random random = new Random();
    int count_mines = 16;
    int mx = -100;
    int my = -100;
    ArrayList<Integer> cx = new ArrayList<>();
    ArrayList<Integer> cy = new ArrayList<>();
    ArrayList<Mines> mines = new ArrayList<>();

    public GUI() {
        while (mines.size() < 16) {
            int ti = random.nextInt(17);
            int tj = random.nextInt(10);
            boolean cek = false;

            for (Mines tmines : mines) {
                if (ti == tmines.getX() && tj == tmines.getY()) {
                    cek = true;
                    break;
                }
            }
            if (cek == true) {
                continue;
            }
            Mines temp_mine = new Mines(ti, tj);
            mines.add(temp_mine);
        }
        this.setTitle("mineswepper");
        this.setSize(1295, 838);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        Board board = new Board();
        this.setContentPane(board);
        Move move = new Move();
        this.addMouseMotionListener(move);
        CLick click = new CLick();
        this.addMouseListener(click);
    }

    public class Board extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.darkGray);
            g.fillRect(0, 0, 1280, 800);
            g.setColor(Color.gray);
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 9; j++) {
                    for (int j2 = 0; j2 < cx.size(); j2++) {
                        if ((cx.get(j2) >= 8 + spacing + i * boxWidth)
                                && (cx.get(j2) <= 8 + spacing + i * boxWidth + boxWidth - 2 * spacing)) {
                            if ((cy.get(j2) >= 110 + spacing + j * boxWidth)
                                    && (cy.get(j2) <= 110 + spacing + j * boxWidth + boxWidth - 2 * spacing)) {
                                g.setColor(Color.blue);
                            }
                        }
                    }
                    if ((mx >= 8 + spacing + i * boxWidth)
                            && (mx <= 8 + spacing + i * boxWidth + boxWidth - 2 * spacing)) {
                        if ((my >= 110 + spacing + j * boxWidth)
                                && (my <= 110 + spacing + j * boxWidth + boxWidth - 2 * spacing)) {
                            g.setColor(Color.red);
                        }
                    }
                    for (Mines tMines : mines) {
                        if (i == tMines.getX() && j == tMines.getY()) {
                            g.setColor(Color.yellow);
                        }
                    }

                    g.fillRect(spacing + i * boxWidth, spacing + j * boxWidth + boxWidth, boxWidth - 2 * spacing,
                            boxWidth - 2 * spacing);
                    g.setColor(Color.gray);
                }
            }
        }
    }

    public class Move implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // System.out.println("moved");
            mx = e.getX();
            my = e.getY();
            // System.out.println("X : " + mx + " Y : " + my);
        }
    }

    public class CLick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Clicked");
            cx.add(e.getX());
            cy.add(e.getY());

            // System.out.println("X : " + cx + " Y : " + cy);
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
