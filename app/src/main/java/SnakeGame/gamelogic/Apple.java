package SnakeGame.gamelogic;

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

    public void generateLocation(Snake snake) {
        int x = (int) (Math.random() * (38)) * 20; // TODO: fix, it's 38 because (800 pixels - 20) *snake size* /20 = 38
        int y = (int) (Math.random() * (38)) * 20;

        // So it doesn't spawn on the snake's body.
        for (int i = 0; i < snake.getBody().size(); i++) {
            if (snake.getBody().get(i).getX() == x && snake.getBody().get(i).getY() == y) {
                generateLocation(snake);
            }
        }

        this.x = x;
        this.y = y;
    }
}
