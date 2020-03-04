package java15_0304.shape;

public class Test {
    public static void main(String[] args) {
        drawShapes2();
    }

    public static void drawShapes() {
        String[] shapes = {"circle", "rect", "circle", "rect", "flower"};

        // for each
        for (String shape : shapes) {
            if (shape.equals("circle")) {
                Circle circle = new Circle();
                circle.draw();
            } else if (shape.equals("rect")) {
                Rect rect = new Rect();
                rect.draw();
            } else if (shape.equals("flower")) {
                Flower flower = new Flower();
                flower.draw();
            }
        }
    }

    public static void drawShapes2() {
        Shape[] shapes = {new Circle(), new Rect(), new Circle(), new Rect(), new Flower()};
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
