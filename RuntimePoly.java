
// without @Override
class Shape {
    void draw() {
        System.out.println("This is the shape class");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Circle is drawn");
    }
}

class Triangle extends Shape {
    void draw() {
        System.out.println("Triangle is drawn");
    }
}

public class RuntimePoly {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
    }
}
