import javax.swing.*;
import java.util.ArrayList;

public class Scene extends JFrame {
private ArrayList<Item> items;
private BoundingBoxDecorator selectedObject;
private boolean drawBounds;

private Panel p;
    public Scene() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 512);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        items = new ArrayList<Item>();
        drawBounds = false;

    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void draw() {
        if(p != null) {
            this.remove(p);
        }
        p = new Panel(items);
        p.setDrawBounds(drawBounds);
        this.add(p);
        this.revalidate();
        this.repaint();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setDrawBounds(boolean b) {
        drawBounds = b;
    }

    public void setSelectedObject(Item item) {
        if(item == null) {
            selectedObject = null;
            return;
        }

        BoundingBoxDecorator bd = new BoundingBoxDecorator(item);

        if(selectedObject != null) {

            if(item.equals(selectedObject.unwrap())) {
                System.out.println("Object already selected!");
                return;
            }

            Item unwrapped = selectedObject.unwrap();
            items.remove(selectedObject);
            items.add(unwrapped);
        }

        items.remove(item);
        items.add(bd);
        selectedObject = bd;
    }
}
