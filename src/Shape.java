import java.awt.*;

public abstract class Shape extends Primitive {
    protected boolean isFilled;
    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void translate(Point p) {
        position = new Point(position.getX() + p.getX(), position.getY() + p.getY());
        endPosition = new Point(endPosition.getX() + p.getX(), endPosition.getY() + p.getY());
    }

    @Override
    public Tuple<Point, Point> getBoundingBox() {
        return new Tuple<Point, Point>(position, endPosition);
    }

    @Override
    public void draw(Graphics2D g2d) {

    }

    public boolean getFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}
