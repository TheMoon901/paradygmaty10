import java.awt.*;

import static java.lang.Math.sqrt;

public class Star extends Shape{
    private int size;
    public Star(Point pos, int size) {
        position = pos;
        this.size = size;
        endPosition = new Point(pos.getX() + size, pos.getY() + size);
    }

    public void draw(Graphics2D g2d) {
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];

        for (int i = 0; i < 10; i++) {
            double angle = Math.toRadians(i * 36 + 90);
            int radius = size / 2;
            if(i % 2 == 0)  {
                radius /= 2;
            }

            xPoints[i] = (endPosition.getX() + position.getX()) / 2 + (int) (radius * Math.cos(angle));
            yPoints[i] = (endPosition.getY() + position.getY()) / 2 + (int) (radius * Math.sin(angle));
        }

        if(isFilled) {
            g2d.fillPolygon(xPoints, yPoints, 10);
        }

        else {
            g2d.drawPolygon(xPoints, yPoints, 10);
        }
    }

    @Override
    public String getName() {
        return "Star";
    }
}
