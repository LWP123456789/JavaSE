package top.lep101.java;
/*
* final关键字
* */
public class FinalTest {

    {
        LEFT = 1;
    }

    final int WIDTH = 0;
    final int LEFT;
    final int RIGHT;



    public FinalTest() {
        RIGHT = 2;
    }

    public FinalTest(int n) {
        RIGHT = n;
    }

    public static void main(String[] args) {
        int num = 10;

        num = num + 5;

        FinalTest test = new FinalTest(30);

        System.out.println(test.WIDTH + " " + test.RIGHT + " " + test.LEFT);

    }
}

final class FinalA { //FinalA不能被继承

}

/*
class B extends FinalA{

}*/

class AA {
    public final void show() {

    }
}

class BB extends AA {
    /*
    public void show() {

    }
    */
}
