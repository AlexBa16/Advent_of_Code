package year_2024.day14;

import java.awt.*;

public class Robot {
    Point position;
    Point velocity;

    public Robot(int x, int y, int vx, int vy) {
        position = new Point(x, y);
        velocity = new Point(vx, vy);
    }

    @Override
    public String toString() {
        return "p=" + position.x + "," + position.y + " v=" + velocity.x + "," + velocity.y;
    }
}
