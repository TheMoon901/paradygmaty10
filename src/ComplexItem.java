import java.awt.*;
import java.util.ArrayList;

public class ComplexItem extends Item{
    ArrayList<Item> items;

    ComplexItem(Point position) {
        this.position = position;
        endPosition = new Point(position.getX(), position.getY());
        items = new ArrayList<Item>();
    }

    void addItem(Item item) {
        item.translate(position);
        items.add(item);
        if(item.getBoundingBox().y.getX() > this.endPosition.getX()) {
            this.endPosition = new Point(item.getBoundingBox().y.getX(), endPosition.getY());
        }

        if(item.getBoundingBox().y.getY() > this.endPosition.getY()) {
            this.endPosition = new Point(endPosition.getX(), item.getBoundingBox().y.getY());
        }
    }

    ArrayList<Item> getChildren() {
        return items;
    }
    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void translate(Point p) {
        position = new Point(position.getX() + p.getX(), position.getY() + p.getY());
        endPosition = new Point(endPosition.getX() + p.getX(), endPosition.getY() + p.getY());
        for(int i = 0; i < items.size(); i++) {
            items.get(i).translate(p);
        }
    }

    @Override
    public Tuple<Point, Point> getBoundingBox() {
        return new Tuple<Point, Point>(position, endPosition);
    }

    @Override
    public void draw(Graphics2D g2d) {
        for(int i = 0; i < items.size(); i++) {
            items.get(i).draw(g2d);
        }
    }

    @Override
    public String getName() {
        return "Complex Item";
    }
}
