package SnakeGame.gamelogic;

import SnakeGame.gui.Window;

public class Apple {
        
        private int x;
        private int y;
        
        public Apple(Snake snake) {
            generateLocation(snake);
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public void setX(int x) {
            this.x = x;
        }
        
        public void setY(int y) {
            this.y = y;
        }

        private void generateLocation(Snake snake) {
            int x = (int) (Math.random() * (Window.WIDTH - 20));
            int y = (int) (Math.random() * (Window.HEIGHT - 20));
            
            for (int i = 0; i < snake.getBody().size(); i++) {
                if (snake.getBody().get(i).getX() == x && snake.getBody().get(i).getY() == y) {
                    generateLocation(snake);
                }
            }
            
            this.x = x;
            this.y = y;
        }
}
