public class Main implements Runnable {
    GUI gui = new GUI(50);

    public static void main(String[] args) {

        // System.out.println("testtttt methewwww");
        new Thread(new Main()).start();
        
    }

    @Override
    public void run() {
        while (true) {
            gui.repaint();
        }
    }
}