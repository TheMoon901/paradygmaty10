import java.awt.*;

import static java.lang.Math.*;

public class Segment extends Primitive{

    protected Point start;
    protected Point end;
    protected int length;
    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
        position = new Point(min(start.getX(), end.getX()), min(start.getY(), end.getY()));
        endPosition = new Point(max(start.getX(), end.getX()), max(start.getY(), end.getY()));
        length = (int) sqrt(pow(start.getX() - end.getX(), 2) + pow(start.getY() - end.getY(), 2));
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void translate(Point p) {
        position = new Point(position.getX() + p.getX(), position.getY() + p.getY());
        endPosition = new Point(endPosition.getX() + p.getX(), endPosition.getY() + p.getY());;
        start = new Point(start.getX() + p.getX(), start.getY() + p.getY());
        end = new Point(end.getX() + p.getX(), end.getY() + p.getY());
    }

    @Override
    public Tuple<Point, Point> getBoundingBox() {
        return new Tuple<Point, Point>(position, endPosition);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawPolygon(new int[]{start.getX(), end.getX()}, new int[]{start.getY(), end.getY()}, 2);
    }

    @Override
    public String getName() {
        return "Segment";
    }
}
