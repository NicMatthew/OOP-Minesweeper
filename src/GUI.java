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
    ImageIcon easyImg = new ImageIcon("src/Assets/easy.png");
    ImageIcon mediumImg = new ImageIcon("src/Assets/medium.png");
    ImageIcon hardImg = new ImageIcon("src/Assets/hard.png");
    ImageIcon time_count = new ImageIcon("src/Assets/Boxes/time_count.png");
    ImageIcon flag_count = new ImageIcon("src/Assets/Boxes/flag_count.png");

    JPanel header;
    JLabel level;
    JLabel time;
    JLabel flag;
    ArrayList<Integer> cx = new ArrayList<>();
    ArrayList<Integer> cy = new ArrayList<>();
    ArrayList<Mines> mines = new ArrayList<>();
    ArrayList<safebox> safeBox = new ArrayList<>();
    ArrayList<Image> images = new ArrayList<>();
    ArrayList<boxes> flags = new ArrayList<>();
    private int mine;

    public GUI(int mine) {
        header = new JPanel();
        level = new JLabel();
        time = new JLabel();
        flag = new JLabel();
        this.mine = mine;

        images.add(new ImageIcon("src/Assets/Boxes/nol.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/1.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/2.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/3.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/4.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/5.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/6.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/7.png").getImage());
        images.add(new ImageIcon("src/Assets/Boxes/8.png").getImage());
        header = new JPanel(new GridLayout(1,3));
        time.setIcon(imageResize(time_count,150,80));
        flag.setIcon(imageResize(flag_count,150,80));
        if (mine==15){
//            Easy
            level.setIcon(imageResize(easyImg,150,75));
        } else if (mine==25) {
//            Medium
            level.setIcon(imageResize(mediumImg,200,75));

        }else{
//            Hard
            level.setIcon(imageResize(hardImg,200,75));
        }
        header.add(level);
        header.add(time);
        header.add(flag);
        header.setBounds(0,99,450,75);
        header.setOpaque(false);
        header.setBackground(new Color(0,0,0,0));




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
                        cek = false;
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
        add(header);
    }
    public int getIndexSafeBox(int x , int y){
        for (int i = 0; i < safeBox.size(); i++) {
            if(x == safeBox.get(i).getX() && y == safeBox.get(i).getY())return i;
        }
        return -1;
    }
    public static ImageIcon imageResize(ImageIcon image, int width, int height) {
        ImageIcon lama = image;
        Image lama1 = lama.getImage();
        Image baru1 = lama1.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon baru = new ImageIcon(baru1);

        return baru;
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
                    if(cekdraw == true){continue;
                    }

                    if ((mx >= 8 + spacing + i * boxWidth)
                            && (mx <= 8 + spacing + i * boxWidth + boxWidth - 2 * spacing)) {
                        if ((my >= 110 + spacing + j * boxWidth)
                                && (my <= 110 + spacing + j * boxWidth + boxWidth - 2 * spacing)) {
                            g2D.drawImage(new ImageIcon("src/Assets/Boxes/box_hover.png").getImage(),spacing + i * boxWidth,spacing + j * boxWidth + boxWidth,boxWidth - 2 * spacing,boxWidth - 2 * spacing,null);

                        }
                    }
                    for (int k = 0; k < flags.size(); k++) {
                        if (flags.get(k).getX() == i && flags.get(k).getY() == j) {
                            cekdraw = true;
                            g2D.drawImage(new ImageIcon("src/Assets/Boxes/flag.png").getImage(),spacing + i * boxWidth,spacing + j * boxWidth + boxWidth,boxWidth - 2 * spacing,boxWidth - 2 * spacing,null);
                        }
                    }
                    if(cekdraw == true){continue;
                    }
//                    =============================Developer mode==========================================
                    for (Mines tMines : mines) {
                        if (i == tMines.getX() && j == tMines.getY()) {
//                            g.setColor(Color.yellow);
                            g2D.drawImage(new ImageIcon("src/Assets/Boxes/bomb.png").getImage(),spacing + i * boxWidth,spacing + j * boxWidth + boxWidth,boxWidth - 2 * spacing,boxWidth - 2 * spacing,null);

                        }
                    }
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
//            System.exit(0);
//            buat exit
        }
        if(!cekclicked(x, y))return;
                    cx.add(x);
                    cy.add(y);
                    if(isFlag(x,y)){
                        for (int i = 0; i < flags.size(); i++) {
                            if(x == flags.get(i).getX() && y == flags.get(i).getY()){
                                flags.remove(i);
                                break;
                            }
                        }
                    }
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
    public boolean isFlag(int x,int y){
        for (int i = 0; i < flags.size(); i++) {
            if(x == flags.get(i).getX() && y == flags.get(i).getY())return true;
        }
        return false;
    }

    public class CLick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton()==1){
                System.out.println("Clicked");
                int x = getindex_X(e.getX());
                int y = getindex_Y(e.getY());

                System.out.println("flag : "+ flags.size());
                if ((x != -1 && y != -1) && !isFlag(x,y)) {
                    recursiveClick(x, y, x, y);
                }
            }
            if(e.getButton()==3){
//                System.out.println("klik kanan");
                int x = getindex_X(e.getX());
                int y = getindex_Y(e.getY());
                boolean cekk = false;
                for (int i = 0; i < flags.size(); i++) {
                    if(x == flags.get(i).getX() && y == flags.get(i).getY()) {
                        cekk = true;
                        flags.remove(i);
                        break;
                    }
                }
                if (x != -1 && y != -1 && cekk == false && cekclicked(x,y) && flags.size() <= mine){
                    flags.add(new boxes(x,y));
                }
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
