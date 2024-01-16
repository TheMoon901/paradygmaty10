import java.awt.*;

import static java.lang.Math.*;

public class Triangle extends Shape{
    protected Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        int minX = min(min(p1.getX(), p2.getX()), p3.getX());
        int minY = min(min(p1.getY(), p2.getY()), p3.getY());

        int maxX = max(max(p1.getX(), p2.getX()), p3.getX());
        int maxY = max(max(p1.getY(), p2.getY()), p3.getY());

        position = new Point(minX, minY);
        endPosition = new Point(maxX, maxY);

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public void translate(Point p) {
        super.translate(p);
        p1 = new Point(p1.getX() + p.getX(), p1.getY() + p.getY());
        p2 = new Point(p2.getX() + p.getX(), p2.getY() + p.getY());
        p3 = new Point(p3.getX() + p.getX(), p3.getY() + p.getY());
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if(isFilled) {
            g2d.fillPolygon(new int[]{p1.getX(), p2.getX(), p3.getX()}, new int[]{p1.getY(), p2.getY(), p3.getY()}, 3);
        }

        else {
            g2d.drawPolygon(new int[]{p1.getX(), p2.getX(), p3.getX()}, new int[]{p1.getY(), p2.getY(), p3.getY()}, 3);
        }
    }

    @Override
    public String getName() {
        return "Triangle";
    }
}
