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

import static jdk.internal.org.objectweb.asm.Opcodes.NULL;

public class GUI extends JFrame {
    int spacing = 5;
    int boxWidth = 80;
    Random random = new Random();
    // int count_mines = 16;
    int mx = -100;
    int my = -100;
    ArrayList<Integer> cx = new ArrayList<>();
    ArrayList<Integer> cy = new ArrayList<>();
    ArrayList<Mines> mines = new ArrayList<>();
    ArrayList<safebox> safeBox = new ArrayList<>();
    ArrayList<Image> images = new ArrayList<>();

    public GUI(int mine) {
//        for (int i = 1; i < 9; i++) {
//            var path = "Assets/Boxes/"+i+".png";
//            images.add(new ImageIcon(path).getImage());
//        }
        images.add(new ImageIcon("src/Assets/Boxes/nol.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/1.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/2.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/3.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/4.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/5.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/6.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/7.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/8.png").getImage());




        while (mines.size() < mine) {
            int ti = random.nextInt(16);
            int tj = random.nextInt(9);
            for (int i = 0; i < mines.size(); i++) {
                if (mines.get(i).getX() == ti && mines.get(i).getY() == tj) {
                    mines.remove(i);
                }
            }
            mines.add(new Mines(ti, tj));
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                boolean cek = true;
                for (Mines tmine: mines) {
                    if(i == tmine.getX() && j == tmine.getY()){
                        cek =false;
                    }
                }
                if(cek ==true){
                    safeBox.add(new safebox(i,j,cekAroundMines(i,j)));
                }
            }
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
    public int getIndexSafeBox(int x , int y){
        for (int i = 0; i < safeBox.size(); i++) {
            if(x == safeBox.get(i).getX() && y == safeBox.get(i).getY())return i;
        }
        return -1;
    }

    public class Board extends JPanel {
        public void paintComponent(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;
            g.setColor(Color.darkGray);
            g2D.drawImage(new ImageIcon("src/Assets/background.png").getImage(),0,0,1280,800,null);
//            g.fillRect(0, 0, 1280, 800);

            g.setColor(Color.gray);
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 9; j++) {
                    boolean cekdraw = false;
                    for (int j2 = 0; j2 < cx.size(); j2++) {
                        if (cx.get(j2) == i && cy.get(j2) == j) {
//                            g.setColor(Color.blue);
                            g2D.drawImage(images.get(safeBox.get(getIndexSafeBox(i,j)).getMineAround()),spacing + i * boxWidth, spacing + j * boxWidth + boxWidth, boxWidth - 2 * spacing,
                                    boxWidth - 2 * spacing,null);
                            g.setColor(Color.gray);
                            cekdraw =true;
                            break;

                        }
                    }
                    if(cekdraw == true)continue;;
                    if ((mx >= 8 + spacing + i * boxWidth)
                            && (mx <= 8 + spacing + i * boxWidth + boxWidth - 2 * spacing)) {
                        if ((my >= 110 + spacing + j * boxWidth)
                                && (my <= 110 + spacing + j * boxWidth + boxWidth - 2 * spacing)) {
                            g2D.drawImage(new ImageIcon("src/Assets/Boxes/box_hover.png").getImage(),spacing + i * boxWidth,spacing + j * boxWidth + boxWidth,boxWidth - 2 * spacing,boxWidth - 2 * spacing,null);

                        }
                    }
////                    =============================Developer mode==========================================
//                    for (Mines tMines : mines) {
//                        if (i == tMines.getX() && j == tMines.getY()) {
//                            g.setColor(Color.yellow);
//                        }
//                    }
                    g2D.drawImage(new ImageIcon("src/Assets/Boxes/box.png").getImage(),spacing + i * boxWidth,spacing + j * boxWidth + boxWidth,boxWidth - 2 * spacing,boxWidth - 2 * spacing,null);
//                    g.fillRect(spacing + i * boxWidth, spacing + j * boxWidth + boxWidth, boxWidth - 2 * spacing,
//                            boxWidth - 2 * spacing);
//                    g.setColor(Color.gray);
                }
            }
        }
    }
    public boolean cekmines(int x, int y) {
        if (x <= -1 || y <= -1) return true;
        for (Mines tmine : mines) {
            if (tmine.getX() == x && tmine.getY() == y) {
                return false;
            }
        }
        return true;
    }
    public int cekAroundMines(int x, int y) {
        int count = 0;
        if (!cekmines(x,y-1))count++;
        if (!cekmines(x,y+1))count++;

        if (!cekmines(x-1,y-1))count++;
        if (!cekmines(x-1,y))count++;
        if (!cekmines(x-1,y+1))count++;

        if (!cekmines(x+1,y-1))count++;
        if (!cekmines(x+1,y))count++;
        if (!cekmines(x+1,y+1))count++;
        return count;
    }

    public boolean cekclicked(int a,int b){
        for (int i = 0; i < cx.size(); i++) {
            if(a == cx.get(i) && b == cy.get(i)){
                return false;
            }
        }
        return true;
    }
    public void recursiveClick(int x, int y, int Ox, int Oy) {
        if (x < 0 || y < 0 || x > 15 || y > 8) {
            return;
        }
        
        if(!cekmines(x, y)){
            System.exit(0);
        }
        if(!cekclicked(x, y))return;
                    cx.add(x);
                    cy.add(y);  
        if (cekmines(x - 1, y - 1) && cekmines(x - 1, y) && cekmines(x - 1, y + 1)) {
            if (cekmines(x, y - 1) && cekmines(x, y + 1)) {
                if (cekmines(x + 1, y - 1) && cekmines(x + 1, y) && cekmines(x + 1, y + 1)) {
                    

                    recursiveClick(x - 1, y - 1, x, y);
                    recursiveClick(x, y - 1, x, y);
                    recursiveClick(x + 1, y - 1, x, y);

                    recursiveClick(x - 1, y + 1, x, y);
                    recursiveClick(x, y + 1, x, y);
                    recursiveClick(x + 1, y + 1, x, y);

                    recursiveClick(x - 1, y, x, y);
                    recursiveClick(x + 1, y, x, y);
                } else
                    return;
            } else
                return;
        } else
            return;


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
            if(e.getButton()==1){
                System.out.println("Clicked");
                int x = getindex_X(e.getX());
                int y = getindex_Y(e.getY());
                System.out.println(x + " " + y);
                if (x != -1 || y != -1) {
                    recursiveClick(x, y, x, y);
                }
            }
            if(e.getButton()==3){
                System.out.println("klik kanan");
            }
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
