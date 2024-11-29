package SnakeGame;

import javax.swing.*;

public class SnakeGame extends JFrame {

    int SCREEN_WIDTH = 600;
    int SCREEN_HEIGHT = 600;

    SnakeGame() {
        JFrame frame = new JFrame("Jogu Samea");
        frame.setVisible(true);
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakePanel snakepanel = new SnakePanel(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.add(snakepanel);
        frame.pack();
        snakepanel.requestFocus();

    }

}
//HALO CLASS NE NIA PSVM LAKON NO HALO FALI IHA MAIN MENU
