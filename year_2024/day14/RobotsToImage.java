package year_2024.day14;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class RobotsToImage extends JPanel {

    static final int rec = 10;
    public List<Robot> robots;

    public RobotsToImage(List<Robot> robots) {
        this.robots = robots;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Robot robot : robots) g.fillRect(robot.position.x * rec, robot.position.y * rec, rec, rec);
    }

    public void saveImage(String fileName, int width, int height) {
        BufferedImage image = new BufferedImage(width * rec, height * rec, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        this.paintComponent(g2d);
        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File(fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
