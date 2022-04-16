package SnakeGame.gui;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SnakeGame.gamelogic.Apple;
import SnakeGame.gamelogic.Gameplay;
import SnakeGame.gamelogic.Snake;

public class Panel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final Timer timer = new Timer(Window.GAME_SPEED, this);
    public String state = "START";

    private Snake snake;
    private Apple apple;
    private Gameplay g;

    public Panel(Gameplay g) {
        timer.start(); // activates listeners every 100 ms
        this.g = g;

        snake = g.getSnake();
        apple = g.getApple();

        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(java.awt.Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D) graphics;

        // Draw the background
        g.setColor(java.awt.Color.BLACK);
        g.fill(new Rectangle(0, 0, Window.WIDTH, Window.HEIGHT));

        if (state.equals("START")) {
            String s = "PRESS ANY KEY TO START";
            g.setColor(java.awt.Color.WHITE);
            int x = (Window.WIDTH - g.getFontMetrics().stringWidth(s)) / 2 - 20;
            int y = (Window.HEIGHT - g.getFontMetrics().stringWidth(s)) / 2 + 20;
            g.drawString("PRESS ANY KEY TO START", x, y);
        }
        if (state.equals("RUNNING")) {
            g.setColor(java.awt.Color.RED);
            g.fill(new Rectangle(apple.getX(), apple.getY(), 20, 20));

            g.setColor(java.awt.Color.GREEN);
            for (Rectangle r : snake.getBody()) {
                g.fill(r);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        g.update();
    }
}