import java.awt.*;

public abstract class Item {

    protected Point position;
    protected Point endPosition;
    public abstract Point getPosition();
    public abstract void translate(Point p);
    public abstract Tuple<Point, Point> getBoundingBox();
    public abstract void draw(Graphics2D g2d);
    
    public abstract String getName();
}
