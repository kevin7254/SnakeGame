package SnakeGame.gamelogic;

import java.awt.event.*;

import SnakeGame.gui.Panel;
import SnakeGame.gui.Window;

public class Gameplay implements KeyListener {

    private Snake snake;
    private Apple apple;

    private Window window;
    private Panel panel;

    public Gameplay() {
        snake = new Snake();
        apple = new Apple(snake);

        window = new Window();
        panel = new Panel(this);
        window.add(panel);
        window.setVisible(true);
    }

    public void start() {
        panel.state = "RUNNING";
    }

    public void update() {
        if (panel.state.equals("RUNNING")) {
            if (foodColision()) {
                snake.grow();
                apple.generateLocation(snake);
            } else if (wallColision() || snakeColision()) {
                panel.state = "GAME_OVER";
                System.out.println("GAME OVER");
            } else {
                snake.move();
            }
        }
    }

    private boolean foodColision() {
        if (snake.getX() == apple.getX() && snake.getY() == apple.getY()) {
            return true;
        }
        return false;
    }

    private boolean wallColision() {
        if (snake.getX() < 0 || snake.getX() > Window.WIDTH - 35 || snake.getY() < 0
                || snake.getY() > Window.HEIGHT - 35) {
            return true;
        }
        return false;
    }

    private boolean snakeColision() {
        for (int i = 1; i < snake.getBody().size(); i++) {
            if (snake.getBody().get(i).getX() == snake.getX() && snake.getBody().get(i).getY() == snake.getY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (panel.state.equals("RUNNING")) {
            String movement = snake.getMovement();

            if (key == KeyEvent.VK_LEFT && !movement.equals("RIGHT")) {
                snake.left();
            }

            if (key == KeyEvent.VK_RIGHT && !movement.equals("LEFT")) {
                snake.right();
            }

            if (key == KeyEvent.VK_UP && !movement.equals("DOWN")) {
                snake.up();
            }

            if (key == KeyEvent.VK_DOWN && !movement.equals("UP")) {
                snake.down();
            }
        } else {
            start();
        }

    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}