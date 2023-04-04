import java.util.Random;
import javax.swing.JFrame;

public class Main implements Runnable{
    GUI gui = new GUI();
    public static void main(String[] args) {
        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
        while (true) {
            gui.repaint();
        }

    }
}