package com.self.learn.java.innerClassDemo;

public class Circle {
    public static int count = 1;
    private double radius = 0;
    private Draw draw = null;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    //member inner class
    class Draw {
        double radius = 2;

        public void drawShape() {
            System.out.println(Circle.this.radius); //outer
            System.out.println(Draw.this.radius);
            System.out.println(this.radius); //inner
            System.out.println(count);  //local
        }
    }

    public Draw getDrawInstance() {
        if (draw == null) {
            draw = new Draw();
        }
        return draw;
    }

    //local inner class
    public int getRadius() {
        int a = 1;
        class Radius {
            int b = a;
            int radius = 6;
        }

        new Thread() {
            public void run() {
                System.out.println(a);
//                System.out.println(b);
            };
        }.start();

        return new Radius().radius;
    }

    //static inner class
    static class staticInner {
        public staticInner() {
        }
    }

    public void test() {

    }

    public static void main(String[] args) {
        Circle circle = new Circle(3);
        Draw draw = circle.new Draw();
        draw.drawShape();
        circle.getDrawInstance().drawShape();

        Circle.staticInner staticInner = new Circle.staticInner();
    }
}
