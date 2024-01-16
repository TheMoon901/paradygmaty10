import java.awt.*;

public class Circle extends Shape{

    protected int radius;
    public Circle(Point pos, int radius)
    {
        this.radius = radius;
        position = pos;
        endPosition = new Point(pos.getX() + 2 * radius, pos.getY() + 2 * radius);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if(isFilled) {
            g2d.fillOval(position.getX(), position.getY(), radius * 2, radius * 2);
        }

        else {
            g2d.drawOval(position.getX(), position.getY(), radius * 2, radius * 2);
        }
    }

    @Override
    public String getName() {
        return "Circle";
    }
}
