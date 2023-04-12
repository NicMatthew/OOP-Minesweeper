
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuStart{
       
    public static void main(String[] args) {
        JPanel panelJudul = new JPanel();
        panelJudul.setBackground(Color.red);
        panelJudul.setBounds(0, 0, 800, 100);






        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(panelJudul);
        
        

    }
    
}
