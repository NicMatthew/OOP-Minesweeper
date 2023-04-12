
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuStart extends JFrame {
    private JLabel test = new JLabel("Minesweeper");
    private JPanel panel = new JPanel(new GridLayout(1, 4));

    public MenuStart() {
        
        
        
        
        
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Main Menu");
        setVisible(true);
        // panel.add(test);
        add(test);    

        // add(panel);
        
        
        
        
    }
    
   

    public static void main(String[] args) {
        new MenuStart();

        
        

    }
    
}
