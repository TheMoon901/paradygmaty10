import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Panel extends JPanel {
    private ArrayList<Item> items;
    private boolean drawBounds;

    public Panel(ArrayList<Item> items) {
        this.items = new ArrayList<Item>();
        this.items.addAll(items);
        drawBounds = false;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        g2D.setColor(Color.BLACK);
        for(int i = 0; i < items.size(); i++) {
            items.get(i).draw(g2D);

            if(drawBounds) {
               drawBoundingBox(items.get(i), g2D);
            }
        }
    }

    private void drawBoundingBox(Item item, Graphics2D g2D) {
        Tuple<Point, Point> tuple = item.getBoundingBox();
        float[] dash1 = { 2f, 0f, 2f };
        Stroke base = g2D.getStroke();
        g2D.setStroke(new BasicStroke(1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f, dash1,2f));
        g2D.drawRect(tuple.x.getX(), tuple.x.getY(),
                abs(tuple.x.getX() - tuple.y.getX()), abs(tuple.x.getY() - tuple.y.getY()));

        g2D.setStroke(base);
    }

    public void setDrawBounds(boolean b) {
        drawBounds = b;
    }
}
