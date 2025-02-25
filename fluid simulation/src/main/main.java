package main;
import java.awt.Color;

import javax.swing.JFrame;

public class main {
    public static void main(String[] args) {
        
        // Defining the JFrame window
        JFrame window = new JFrame();
        videopanel videopanel = new videopanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        window.setLocation(100,20);
        window.setVisible(true);
        window.setTitle("fluid simulation");
        videopanel.setBackground(Color.decode("#18181c"));
        window.add(videopanel);
        
        window.pack();
        videopanel.setAllParameter();
        videopanel.startGameThread();
    }
}
