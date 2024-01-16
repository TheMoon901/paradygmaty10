import java.awt.*;

public class ItemDecorator extends Item{
    Item wrapped;
    public ItemDecorator(Item item) {
        wrapped = item;
    }

    public Item unwrap() {
        return wrapped;
    }

    @Override
    public Point getPosition() {
        return wrapped.getPosition();
    }

    @Override
    public void translate(Point p) {
        wrapped.translate(p);
    }

    @Override
    public Tuple<Point, Point> getBoundingBox() {
        return wrapped.getBoundingBox();
    }

    @Override
    public void draw(Graphics2D g2d) {
        wrapped.draw(g2d);
    }

    @Override
    public String getName() {
        return wrapped.getName();
    }
}
