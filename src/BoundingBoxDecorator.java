import java.awt.*;

import static java.lang.Math.abs;

public class BoundingBoxDecorator extends ItemDecorator{
    public BoundingBoxDecorator(Item item) {
        super(item);
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
        Tuple<Point, Point> tuple = wrapped.getBoundingBox();
        Color c = g2d.getColor();
        g2d.setColor(Color.RED);
        g2d.drawRect(tuple.x.getX(), tuple.x.getY(),
                abs(tuple.x.getX() - tuple.y.getX()), abs(tuple.x.getY() - tuple.y.getY()));
        g2d.setColor(c);
    }
}
