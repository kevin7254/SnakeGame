package SnakeGame.gui;

import javax.swing.JFrame;

import SnakeGame.gamelogic.Gameplay;

public class Window extends JFrame {
    Panel panel;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public static final int GAME_SPEED = 100; //in ms
    
    public Window() {
        setTitle("Snake");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
