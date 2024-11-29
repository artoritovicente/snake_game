package SnakeGame;

import javax.swing.JFrame;

public class SnakeNatonFrame extends JFrame {
    int SCREEN_WIDTH = 600;
    int SCREEN_HEIGHT = 600;

    SnakeNatonFrame(){
        JFrame frame = new JFrame("Jogu Samea");
        frame.setVisible(true);
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGameNaton sgn = new SnakeGameNaton(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.add(sgn);
        frame.pack();
        sgn.requestFocus();
       
    }
}

