package SnakeGame.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public class Snake {
    private List<Rectangle> body;

    private String moving;

    public Snake() {
        System.out.println("Snake created");
        this.body = new ArrayList<>();

        this.body.add(new Rectangle(100, 100, 20, 20));
        this.body.add(new Rectangle(80, 100, 20, 20));

        moving = "STILL";
    }

    public List<Rectangle> getBody() {
        return body;
    }

    public void setBody(List<Rectangle> body) {
        this.body = body;
    }

    public void up() {
        moving = "UP";
    }

    public void down() {
        moving = "DOWN";
    }

    public void left() {
        moving = "LEFT";
    }

    public void right() {
        moving = "RIGHT";
    }

    public void grow() {
        Rectangle last = body.get(body.size() - 1);
        Rectangle newBody = new Rectangle(last.x, last.y, 20, 20);

        body.add(newBody);
    }

    public void move() {
        if (moving.equals("UP")) {
            for (int i = body.size() - 1; i > 0; i--) {
                Rectangle current = body.get(i);
                Rectangle previous = body.get(i - 1);

                current.x = previous.x;
                current.y = previous.y;
            }

            Rectangle head = body.get(0);
            head.y -= 20;
        }

        if (moving.equals("DOWN")) {
            for (int i = body.size() - 1; i > 0; i--) {
                Rectangle current = body.get(i);
                Rectangle previous = body.get(i - 1);

                current.x = previous.x;
                current.y = previous.y;
            }

            Rectangle head = body.get(0);
            head.y += 20;
        }

        if (moving.equals("LEFT")) {
            for (int i = body.size() - 1; i > 0; i--) {
                Rectangle current = body.get(i);
                Rectangle previous = body.get(i - 1);

                current.x = previous.x;
                current.y = previous.y;
            }

            Rectangle head = body.get(0);
            head.x -= 20;
        }

        if (moving.equals("RIGHT")) {
            for (int i = body.size() - 1; i > 0; i--) {
                Rectangle current = body.get(i);
                Rectangle previous = body.get(i - 1);

                current.x = previous.x;
                current.y = previous.y;
            }

            Rectangle head = body.get(0);
            head.x += 20;
        }
    }

}
