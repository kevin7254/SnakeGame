package SnakeGame.gamelogic;

import java.awt.event.*;

import SnakeGame.gui.Panel;
import SnakeGame.gui.Window;

public class Gameplay implements KeyListener {

    private Snake snake;
    private Apple apple;

    private Window window;
    private Panel panel;

    private int x = 0;
    private int y = 0;

    public Gameplay() {
        snake = new Snake();
        apple = new Apple(snake);

        window = new Window();
        panel = new Panel(this);
        window.add(panel);
        window.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            snake.left();
            snake.move();
        }

        if (key == KeyEvent.VK_RIGHT) {
            snake.right();
            snake.move();
        }

        if (key == KeyEvent.VK_UP) {
            snake.up();
            snake.move();
        }

        if (key == KeyEvent.VK_DOWN) {
            snake.down();
            snake.move();
        }

        //enter key
        if (key == KeyEvent.VK_ENTER) {
            System.out.println("enter");
            snake.grow();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }
    
}
