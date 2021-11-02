package top.lep101.java3;

/**
 * 写一个测试类，创建两个Circle对象，判断其颜色是否相等;
 */
public class CircleTest {
    public static void main(String[] args) {

        Circle circle1 = new Circle(2.3);
        Circle circle2 = new Circle(new String("white"),2.0,3.3);

        System.out.println("颜色是否相等：" + circle1.getColor().equals(circle2.getColor()));

        System.out.println("半径是否相等：" + circle1.equals(circle2));

        System.out.println(circle1);
        System.out.println(circle2.toString());
    }
}
