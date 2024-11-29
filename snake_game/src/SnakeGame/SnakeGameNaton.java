package SnakeGame;

//import static SnakeGameNaton.GamePanel.SCREEN_HEIGHT;
//import static SnakeGameNaton.GamePanel.SCREEN_WIDTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGameNaton extends JPanel implements ActionListener, KeyListener {

    JFrame gameover = new JFrame();
    JLabel gameOverLabel = new JLabel("JOGU REMATA");
    JButton retrybtn = new JButton("REPETE");
    JButton newGamebtn = new JButton("JOGU FOUN");
    JButton exitbtn = new JButton("SAI");

    private class Tile {

        int x;
        int y;
//        int wallX;
//        int wallY;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
    int boardWidth;
    int boardHeight;
    int unit_size = 25;
    //snake
    Tile snakeHead;
    ArrayList<Tile> snakeBody;

    //moru
//    Tile walls;
//    ArrayList<Tile> wall;
    //apple
    Tile apples;
    Random random;

    //game logic
    Timer gameLoop;
    int velocityX;
    int velocityY;
    boolean gameOver = false;

    SnakeGameNaton(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);

        snakeHead = new Tile(5, 5);
        snakeBody = new ArrayList<Tile>();

        //moru
//        walls = new Tile(5, 5);
//        wall = new ArrayList<Tile>();
        apples = new Tile(10, 10);
        random = new Random();
        placeApples();

        velocityX = 1;
        velocityY = 0;
//      NIVEL NATON
        gameLoop = new Timer(70, this);
        gameLoop.start();
        startGame();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

    }

    public void draw(Graphics g) {
        //grid
        /*for (int i = 0; i < boardWidth / unit_size; i++) {
            //(x1, y1, x2, y2)
            g.drawLine(i * unit_size, 0, i * unit_size, boardHeight);
            g.drawLine(0, i * unit_size, boardWidth, i * unit_size);
            
       }
         */
        //apples
        g.setColor(Color.yellow);
//        g.fillRect(apples.x * unit_size, apples.y * unit_size, unit_size, unit_size);
        g.fill3DRect(apples.x * unit_size, apples.y * unit_size, unit_size, unit_size, true);

        //walls
//        g.setColor(Color.white);
//        g.fillRect(200, 240, 25, 25);
//        g.fillRect(200, 265, 25, 25);
//        g.fillRect(200, 290, 25, 25);
//        g.fillRect(200, 315, 25, 25);
//
//        g.fillRect(375, 240, 25, 25);
//        g.fillRect(375, 265, 25, 25);
//        g.fillRect(375, 290, 25, 25);
//        g.fillRect(375, 315, 25, 25);
        //snake head
        g.setColor(Color.red);
//        g.fillRect(snakeHead.x * unit_size, snakeHead.y * unit_size, unit_size, unit_size);
        g.fill3DRect(snakeHead.x * unit_size, snakeHead.y * unit_size, unit_size, unit_size, true);
        //snake body
        for (int i = 0; i < snakeBody.size(); i++) {
            g.setColor(Color.green);
            Tile snakePart = snakeBody.get(i);
//            g.fillRect(snakePart.x * unit_size, snakePart.y * unit_size, unit_size, unit_size);
            g.fill3DRect(snakePart.x * unit_size, snakePart.y * unit_size, unit_size, unit_size, true);
        }

        //score
        g.setFont(new Font("serif", Font.BOLD, 18));
        if (gameOver) {
//            g.setColor(Color.black);
            // g.setColor(Color.red);
//            g.setFont(new Font("serif", Font.BOLD, 75));
//            FontMetrics metrics2 = getFontMetrics(g.getFont());
//            g.drawString("JOGU REMATA", (SCREEN_WIDTH - metrics2.stringWidth("JOGU REMATA")) / 2, SCREEN_HEIGHT / 2);
//            int choice = 0;
//            String mensajem = "Try Again?";
//            JOptionPane.showConfirmDialog(null, mensajem, "CONFIRMATION", JOptionPane.YES_NO_OPTION);
//
//            if (choice == JOptionPane.YES_OPTION) {
//                SnakePanel p = new SnakePanel(SCREEN_WIDTH, SCREEN_HEIGHT);
//            }
//            g.drawString("GAME OVER: " + String.valueOf(snakeBody.size()), unit_size - 16, unit_size);
        } else {
            g.drawString("SCORE: " + String.valueOf(snakeBody.size()), unit_size - 16, unit_size);
        }
    }

    public void placeApples() {
        apples.x = random.nextInt(boardWidth / unit_size);
        apples.y = random.nextInt(boardHeight / unit_size);
    }

    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }

    //collision moru
//    public boolean collision2(Tile walls1, Tile walls2) {
//        return walls1.wallX == walls2.wallX && walls1.wallY == walls2.wallY;
//    }
    public void move() {
        //eat apples
        if (collision(snakeHead, apples)) {
            snakeBody.add(new Tile(apples.x, apples.y));
            placeApples();
        }

        //snake body
        for (int i = snakeBody.size() - 1; i >= 0; i--) {
            Tile snakePart = snakeBody.get(i);
            if (i == 0) {
                snakePart.x = snakeHead.x;
                snakePart.y = snakeHead.y;
            } else {
                Tile prevSnakePart = snakeBody.get(i - 1);
                snakePart.x = prevSnakePart.x;
                snakePart.y = prevSnakePart.y;

            }
        }
        //snake head
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;

        //game over conditions
        for (int i = 0; i < snakeBody.size(); i++) {
            Tile snakePart = snakeBody.get(i);
            //collide with snake head
            if (collision(snakeHead, snakePart)) {
                gameOver = true;
            }
        }
        if (snakeHead.x * unit_size < 0 || snakeHead.x * unit_size > boardWidth || snakeHead.y * unit_size < 0 || snakeHead.y * unit_size > boardHeight) {
            gameOver = true;
        }
        //game over moru
//        for (int i = 0; i < wall.size(); i++) {
//            Tile walls = wall.get(i);
//
//            if (collision2(snakeHead, walls)) {
//                gameOver = true;
//            }
//        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            gameover.setSize(400, 400);
            gameover.setLayout(null);
            gameover.setLocationRelativeTo(null);
            gameover.setVisible(true);
            gameover.setResizable(false);
            gameover.add(gameOverLabel);
            gameOverLabel.setBounds(115, -40, 200, 200);
            gameOverLabel.setFont(new Font("calibri", Font.BOLD, 25));

            gameover.add(retrybtn);
            retrybtn.setBounds(130, 100, 120, 40);
            retrybtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SnakeNatonFrame sgn = new SnakeNatonFrame();

                }
            });
            retrybtn.setBackground(Color.BLACK);
            retrybtn.setForeground(Color.GREEN);
            retrybtn.setFocusable(false);

            gameover.add(newGamebtn);
            newGamebtn.setBounds(130, 160, 120, 40);
            newGamebtn.setBackground(Color.BLACK);
            newGamebtn.setForeground(Color.white);
            newGamebtn.setFocusable(false);
            newGamebtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    NivelJogu nj = new NivelJogu();
                    gameover.dispose();
                }

            });

            gameover.add(exitbtn);
            exitbtn.setBounds(130, 220, 120, 40);
            exitbtn.setForeground(Color.red);
            exitbtn.setBackground(Color.BLACK);
            exitbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int a = JOptionPane.showConfirmDialog(null, "SAI HUSI JOGU?", "KONFIRMASAUN", JOptionPane.YES_NO_OPTION);
                    if (a == 0) {
                        System.exit(0);
                    }
                }

            });

            // Display final score
            JLabel finalScoreLabel = new JLabel("PONTUS FINAL: " + snakeBody.size());
            System.out.println("");
            finalScoreLabel.setBounds(130, 60, 200, 40);
            finalScoreLabel.setFont(new Font("calibri", Font.BOLD, 16));
            finalScoreLabel.setForeground(Color.BLUE);
            gameover.add(finalScoreLabel);

            exitbtn.setFocusable(false);
            gameLoop.stop();
            pauseGame();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyPressed = e.getKeyChar();

        // Check the key pressed and adjust the snake's movement
        if (keyPressed == KeyEvent.VK_UP) {
            // Move the snake upwards (change its direction)
            velocityX = 0;
            velocityY = -1;
        } else if (keyPressed == KeyEvent.VK_DOWN) {
            // Move the snake downwards (change its direction)
            velocityX = 0;
            velocityY = 1;
        } else if (keyPressed == KeyEvent.VK_LEFT) {
            // Move the snake leftwards (change its direction)
            velocityX = -1;
            velocityY = 0;
        } else if (keyPressed == KeyEvent.VK_RIGHT) {
            // Move the snake rightwards (change its direction)
            velocityX = 1;
            velocityY = 0;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && velocityY != 1) {
            velocityX = 0;
            velocityY = -1;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && velocityY != -1) {
            velocityX = 0;
            velocityY = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && velocityX != 1) {
            velocityX = -1;
            velocityY = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && velocityX != -1) {
            velocityX = 1;
            velocityY = 0;
        }
    }

    public void pauseGame() {
        gameLoop.stop();
    }

    public void startGame() {
        gameLoop.start();
        requestFocusInWindow(); // Ensures the panel has focus for key events
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && velocityY != 1) {
            // ... (existing code for movement)
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && velocityY != -1) {
            // ... (existing code for movement)
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && velocityX != 1) {
            // ... (existing code for movement)
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && velocityX != -1) {
            // ... (existing code for movement)
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) { // Key 'P' for pause/resume
            if (gameLoop.isRunning()) {
                pauseGame();
            } else {
                startGame();
            }
        }
    }

}
