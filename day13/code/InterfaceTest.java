public class InterfaceTest {
    public static void main(String[] args) {

        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);

    }
}

interface Flyable{

    //全局常量
    public static final int MAX_SPEED = 7900;//第一宇宙速度
    int MIN_SPEED = 1;

    //抽象方法
    public abstract void fly();
    void stop();
}

class Plane implements Flyable {

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }
}