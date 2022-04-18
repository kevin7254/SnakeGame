package SnakeGame.gui;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JComponent;

import SnakeGame.gamelogic.Apple;
import SnakeGame.gamelogic.Gameplay;
import SnakeGame.gamelogic.Snake;

public class Panel extends JComponent implements Runnable {

    private static final long serialVersionUID = 1L;

    private Thread thread;
    public String state = "START";

    private Snake snake;
    private Apple apple;
    private Gameplay g;

    public Panel(Gameplay g) {
        this.setDoubleBuffered(true);
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
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void run() {
        while (true) {
            g.update();
            repaint();
            try {
                Thread.sleep(Window.GAME_SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
        thread = new Thread(this);
        thread.start();
    }
}