import java.awt.*;
import java.awt.geom.AffineTransform;
import static java.lang.Math.abs;

public class TextItem extends Item{

    protected String text;
    TextItem(Point pos, String text) {
        position = pos;
        endPosition = pos;
        this.text = text;
    }

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

        endPosition = new Point(g2d.getFontMetrics().stringWidth(text) + position.getX(), g2d.getFontMetrics().getHeight() + position.getY());
        java.awt.Shape originalClip = g2d.getClip();
        g2d.drawString(text, position.getX(), position.getY() + g2d.getFontMetrics().getHeight() - g2d.getFontMetrics().getDescent() * 2);
    }

    @Override
    public String getName() {
        return "Text: '" + text + "'";
    }

    public String getText() {
        return text;
    }
}
