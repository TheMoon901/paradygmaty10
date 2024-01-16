import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rect extends Shape {
    protected int width;
    protected int height;

    public Rect(Point pos, int width, int height) {
        this.width = width;
        this.height = height;
        position = pos;
        endPosition = new Point(pos.getX() + width, pos.getY() + height);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    @Override
    public void draw(Graphics2D g2d) {
        if(isFilled) {
            g2d.fillRect(position.getX(), position.getY(), width, height);
        }

        else {
            g2d.drawRect(position.getX(), position.getY(), width, height);
        }
    }

    @Override
    public String getName() {
        return "Rect";
    }
}
