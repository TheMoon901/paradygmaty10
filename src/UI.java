import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public static void mainLoop() {
        Scene scene = new Scene();
        scene.setSelectedObject(null);
        Scanner scanner = new Scanner(System.in);
        boolean looping = true;
        while (looping) {
            System.out.println("Type command (add/translate/draw/bounds/select/exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    add(scanner, scene);
                    break;

                case "draw":
                    scene.draw();
                    break;
                case "bounds":
                    bounds(scanner, scene);
                    break;
                case "translate":
                    translate(scanner, scene);
                    break;
                case "select":
                    select(scanner, scene);
                    break;
                case "exit":
                    looping = false;
                    break;

                default:
                    System.out.println("Couldn't recognize command");
            }
        }
        scanner.close();
        System.exit(0);
    }

    private static void bounds(Scanner scanner, Scene scene) {
        System.out.println("Do you want bounds to be drawn? (yes/no)");
        String answer = scanner.nextLine();
        if(answer.equals("yes")) {
            scene.setDrawBounds(true);
            System.out.println("Bounds will be drawn now!");
        }
        else if(answer.equals("no")) {
            scene.setDrawBounds(false);
            System.out.println("Bounds won't be drawn now!");
        }
        else {
            System.out.println("Couldn't recognize command");
        }
    }


    private static void translate(Scanner scanner, Scene scene) {
        System.out.println("Choose item (number) to transform: ");
        ArrayList<Item> items = scene.getItems();
        for(int i = 0; i < items.size(); i++) {
            System.out.println(i + ") " + items.get(i).getName());
        }

        int answer = scanner.nextInt();
        scanner.nextLine();

        if(answer >= items.size() || answer < 0) {
            System.out.println("Index out of bounds!");
            return;
        }

        Item item = items.get(answer);

        item.translate(askPosition(scanner, "translation"));
    }

    private static void select(Scanner scanner, Scene scene) {
        System.out.println("Choose item (number) to select: ");
        ArrayList<Item> items = scene.getItems();
        for(int i = 0; i < items.size(); i++) {
            System.out.println(i + ") " + items.get(i).getName());
        }

        int answer = scanner.nextInt();
        scanner.nextLine();

        if(answer >= items.size() || answer < 0) {
            System.out.println("Index out of bounds!");
            return;
        }

        Item item = items.get(answer);
        scene.setSelectedObject(item);
    }


    private static void add(Scanner scanner, Scene scene) {

        Item item = getItem(scanner);
        if(item != null) {
            scene.addItem(item);
            System.out.println("Item added!");
        }
    }

    private static ComplexItem getComplex(Scanner scanner) {
        boolean looping = true;
        ComplexItem complexItem = new ComplexItem(askPosition(scanner, "complex item"));
        System.out.println("Now you are in complex item mode!");

        while (looping) {
            Item item = getItem(scanner);
            if (item != null) {
                complexItem.addItem(item);
                System.out.println("Item added to complex item!");
            }
            System.out.println("Type 'exit' if you want to stop adding items!");
            String answer = scanner.nextLine();
            if(answer.equals("exit")) {
                looping = false;
            }
        }

        return complexItem;
    }
    private static Item getItem(Scanner scanner) {

        System.out.println("What do you want to add? (rect/circle/triangle/text/star/segment/complex)");
        String command = scanner.nextLine();
        Item item = new Rect(new Point(0, 0), 0, 0);
        boolean properly = true;

        switch (command) {
            case "rect":
                item = addRect(scanner, askPosition(scanner, command));
                break;
            case "circle":
                item = addCircle(scanner, askPosition(scanner, command));
                break;
            case "triangle":
                item = addTriangle(scanner);
                break;
            case "star":
                item = addStar(scanner, askPosition(scanner, command));
                break;
            case "text":
                item = addText(scanner, askPosition(scanner, command));
                break;
            case "segment":
                item = addSegment(scanner);
                break;
            case "complex":
                item = getComplex(scanner);
                break;

            default:
                System.out.println("Couldn't recognize command");
                return null;
        }


        if(item instanceof Shape) {
            Shape shape = (Shape) item;
            System.out.println("Do you want it to be filled? type 'y' if yes:");
            String answer = scanner.nextLine();
            shape.setFilled(answer.equals("y"));
        }

        return item;
    }

    private static Point askPosition(Scanner scanner, String name) {
        System.out.println("give X position of " + name + ": ");
        int x = scanner.nextInt();
        System.out.println("give Y position of " + name + ": ");
        int y = scanner.nextInt();
        scanner.nextLine();

        return new Point(x, y);
    }

    public static Segment addSegment(Scanner scanner) {
        return new Segment(askPosition(scanner, "starting point"), askPosition(scanner, "ending point"));
    }


    private static Rect addRect(Scanner scanner, Point pos) {
        System.out.println("give width of Rect:");
        int w = scanner.nextInt();
        System.out.println("give height of Rect:");
        int h = scanner.nextInt();
        scanner.nextLine();

        return new Rect(pos, w, h);
    }
    private static Circle addCircle(Scanner scanner, Point pos) {
        System.out.println("give radius of Circle:");
        int r = scanner.nextInt();
        scanner.nextLine();

        return new Circle(pos, r);
    }

    private static Triangle addTriangle(Scanner scanner) {
        System.out.println("give X of first point:");
        int x1 = scanner.nextInt();
        System.out.println("give Y of first point:");
        int y1 = scanner.nextInt();
        System.out.println("give X of second point:");
        int x2 = scanner.nextInt();
        System.out.println("give Y of second point:");
        int y2 = scanner.nextInt();
        System.out.println("give X of third point:");
        int x3 = scanner.nextInt();
        System.out.println("give Y of third point:");
        int y3 = scanner.nextInt();
        scanner.nextLine();

        return new Triangle(new Point(x1, y1), new Point(x2,y2), new Point(x3, y3));
    }

    private static Star addStar(Scanner scanner, Point pos) {
        System.out.println("give size of Star:");
        int s = scanner.nextInt();
        scanner.nextLine();
        return new Star(pos, s);
    }

    private static TextItem addText(Scanner scanner, Point pos) {
        System.out.println("Write text:");
        String text =  scanner.nextLine();

        return new TextItem(pos, text);
    }
}
