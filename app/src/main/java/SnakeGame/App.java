package SnakeGame;

import javax.swing.SwingUtilities;

import SnakeGame.gamelogic.Gameplay;

public class App {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Gameplay();
            }
        });
    }
}