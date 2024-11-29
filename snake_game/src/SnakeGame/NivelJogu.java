package SnakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NivelJogu extends JFrame implements ActionListener {

    JButton fasilBtn = new JButton("FASIL");
    JButton NatonBtn = new JButton("NATON");
    JButton DifisilBtn = new JButton("DIFISIL");
    JLabel Title = new JLabel("NIVEL SIRA");
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public NivelJogu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        add(panel);

        add(Title);
        Title.setFont(new Font("calibri", Font.BOLD, 30));
        Title.setBounds(170, 60, 200, 50);
        Title.setForeground(Color.black);

        add(fasilBtn);
        fasilBtn.setBounds(135, 130, 200, 50);
        fasilBtn.setBackground(Color.black);
        fasilBtn.setForeground(Color.green);
        fasilBtn.setFocusable(false);
        fasilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SnakeGame sg = new SnakeGame();
                dispose();
            }
        });

        add(NatonBtn);
        NatonBtn.setBounds(135, 200, 200, 50);
        NatonBtn.setBackground(Color.black);
        NatonBtn.setForeground(Color.yellow);
        NatonBtn.setFocusable(false);
        NatonBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SnakeNatonFrame f = new SnakeNatonFrame();
                dispose();
            }
        });

        add(DifisilBtn);
        DifisilBtn.setBounds(135, 270, 200, 50);
        DifisilBtn.setBackground(Color.black);
        DifisilBtn.setForeground(Color.red);
        DifisilBtn.setFocusable(false);
        DifisilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SnakeDifisilFrame sdf = new SnakeDifisilFrame();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

}
