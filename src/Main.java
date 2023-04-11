public class Main implements Runnable {
    // test jesslyn
    GUI gui = new GUI();

    public static void main(String[] args) {

        System.out.println("testtttt methewwww");
        new Thread(new Main()).start();

    }

    @Override
    public void run() {
        while (true) {
            gui.repaint();
        }
    }
}