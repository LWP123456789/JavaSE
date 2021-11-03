package top.lep101.java4;
//static关键字的应用
public class CircleTest {
    public static void main(String[] args) {

        Circle c1 = new Circle();

        Circle c2 = new Circle();

        System.out.println("c1的id：" + c1.getId());
        System.out.println("c2的id：" + c2.getId());

        System.out.println("创建的圆的个数为：" + Circle.getTotal());
    }
}

class Circle{

    private double radius;
    private int id;

    public Circle(){
        id = init++;
        total++;
    }

    public Circle(double radius) {
        this();
        this.radius = radius;
        /*id = init;
        total++;*/
    }

    private static int total;//记录造了多少个圆的对象
    private static int init = 1001;//多个对象共享

    public double findArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotal() {
        return total;
    }

    public static int getInit() {
        return init;
    }
}
