 package SnakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class menu extends JFrame implements ActionListener {

    JButton playBtn = new JButton("HALIMAR");
    JButton exitBtn = new JButton("SAI");
    JLabel title = new JLabel("JOGU SAMEA");
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    public menu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        add(panel);
        setLocationRelativeTo(null);

        add(title);
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        title.setBounds(145, 60, 200, 50);
        title.setForeground(Color.black);

        add(playBtn);
        playBtn.setBounds(135, 130, 200, 50);
        playBtn.setBackground(Color.BLACK);
        playBtn.setForeground(Color.green);
        playBtn.setFocusable(false);
        playBtn.addActionListener(this);

        add(exitBtn);
        exitBtn.setBounds(135, 200, 200, 50);
        exitBtn.setBackground(Color.BLACK);
        exitBtn.setForeground(Color.red);
        exitBtn.setFocusable(false);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "SAI HUSI JOGU?", "KONFIRMASAUN", JOptionPane.YES_NO_OPTION);
                if (a == 0) {
                    System.exit(0);
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NivelJogu nj = new NivelJogu();
////        SnakeGame game = new SnakeGame();
        dispose();
    }

    public static void main(String[] args) {
        menu m = new menu();
    }
}
