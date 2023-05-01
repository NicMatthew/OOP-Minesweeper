public class Main implements Runnable {
    int bom;
    GUI gui;

    public Main(int mine){
        gui = new GUI(mine);
    }

    public static void main(String[] args) {
//        new MenuStart();

        // System.out.println("testtttt methewwww");
//        new Thread(new Main()).start();
        
    }

    @Override
    public void run() {
        while (true) {
            gui.repaint();
        }
    }
}