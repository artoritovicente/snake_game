package SnakeGame;

import javax.swing.JFrame;

public class SnakeDifisilFrame extends JFrame {
    int SCREEN_WIDTH = 600;
    int SCREEN_HEIGHT = 600;

    SnakeDifisilFrame(){
        JFrame frame = new JFrame("Jogu Samea");
        frame.setVisible(true);
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGameDifisil sgd = new SnakeGameDifisil(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.add(sgd);
        frame.pack();
        sgd.requestFocus();
       
    }
}
