public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        int num = son.num;
        System.out.println(num);
        son.showMethod();
    }
}

class Fa {

    public int num = 1;
    private int number = 3; //无法被子类直接调用,

    public void plus () {
        System.out.println(num);
    }

    private void showNumber() {
        System.out.println(number);
    }

    public void showMethod() {
        showNumber();
    }

}

class Son extends Fa {

    public int num = 2;
    public int number = 4;

    public void plus() {
        System.out.println("实现了对父类的重写" + num);
    }

    public void showMethod() {
        super.showMethod();
    }
}