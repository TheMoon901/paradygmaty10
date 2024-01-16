import javax.swing.*;
import java.util.ArrayList;

public class Scene extends JFrame {
private ArrayList<Item> items;
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
        if(item instanceof Singleton) {
            ((Singleton)item).removeAnotherSingleton(items);
        }

        if(item instanceof ComplexItem) {
            Singleton s = ((ComplexItem) item).getSingleton();
            if(s != null) {
                s.removeAnotherSingleton(items);
            }
        }
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
}
