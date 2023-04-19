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
<<<<<<< Updated upstream
        while (mines.size() != 16) {
            int ti = random.nextInt(17);
            int tj = random.nextInt(10);
            boolean cek = false;

            for (Mines tmines : mines) {
                if (ti == tmines.getX() && tj == tmines.getY()) {
                    cek = true;
                    // break;
                }
            }
            if (cek == true) {
                continue;
            }else{
                Mines temp_mine = new Mines(ti, tj);
                mines.add(temp_mine);
            }
            
=======
        while (mines.size() < 16) {
            int ti = random.nextInt(16);
            int tj = random.nextInt(9);
            for (int i = 0; i < mines.size(); i++) {
                if (mines.get(i).getX() == ti && mines.get(i).getY() == tj) {
                    mines.remove(i);
                }
            }
            mines.add(new Mines(ti, tj));
>>>>>>> Stashed changes
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
                        if (cx.get(j2) == i && cy.get(j2) == j) {
                            g.setColor(Color.blue);
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

    public boolean cekmines(int x, int y) {
        for (Mines tmine : mines) {
            if (tmine.getX() == x && tmine.getY() == y) {
                return false;
            }
        }
        return true;
    }

    public void recursiveClick(int x, int y, int Ox, int Oy) {
        if (x < 0 || y < 0 || x > 15 || y > 8) {
            return;
        }
        cx.add(x);
        cy.add(y);
        if (cekmines(x - 1, y - 1) && cekmines(x - 1, y) && cekmines(x - 1, y + 1)) {
            if (cekmines(x, y - 1) && cekmines(x, y) && cekmines(x, y + 1)) {
                if (cekmines(x + 1, y - 1) && cekmines(x + 1, y) && cekmines(x + 1, y + 1)) {

                } else
                    return;
            } else
                return;
        } else
            return;

        if (x - 1 != Ox && y - 1 != Oy) {
            recursiveClick(x - 1, y - 1, x, y);
        }
        if (x != Ox && y - 1 != Oy) {
            recursiveClick(x, y - 1, x, y);
        }
        if (x + 1 != Ox && y - 1 != Oy) {
            recursiveClick(x + 1, y - 1, x, y);
        }

        if (x - 1 != Ox && y + 1 != Oy) {
            recursiveClick(x - 1, y + 1, x, y);
        }
        if (x != Ox && y + 1 != Oy) {
            recursiveClick(x, y + 1, x, y);
        }
        if (x + 1 != Ox && y + 1 != Oy) {
            recursiveClick(x + 1, y + 1, x, y);
        }

        if (x - 1 != Ox && y != Oy) {
            recursiveClick(x - 1, y + 1, x, y);
        }
        if (x + 1 != Ox && y != Oy) {
            recursiveClick(x + 1, y + 1, x, y);
        }

    }

    public int getindex_X(int cek_X) {
        for (int i = 0; i < 16; i++) {
            if ((cek_X >= 8 + spacing + i * boxWidth) &&
                    (cek_X <= 8 + spacing + i * boxWidth + boxWidth - 2 * spacing)) {
                return i;
            }
        }
        return -1;
    }

    public int getindex_Y(int cek_Y) {
        for (int j = 0; j < 9; j++) {
            if ((cek_Y >= 110 + spacing + j * boxWidth)
                    && (cek_Y <= 110 + spacing + j * boxWidth + boxWidth - 2 * spacing)) {
                return j;
            }
        }
        return -1;
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
            int x = getindex_X(e.getX());
            int y = getindex_X(e.getY())-1;
            System.out.println(x + " " + y);
            recursiveClick(x, y, x, y);
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

    public Mines randomMines() {
        Mines tMines = new Mines(random.nextInt(17), random.nextInt(10));
        return tMines;
    }

}
