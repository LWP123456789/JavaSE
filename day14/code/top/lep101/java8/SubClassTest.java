package top.lep101.java8;

public class SubClassTest {
    public static void main(String[] args) {
        SubClass s = new SubClass();

        //接口中定义的静态方法，只能通过接口来调用
        CompareA.method1();
        //通过实现类的对象，可以调用接口中的默认方法
        //如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写后的方法
        s.method2();
    }
}

class SubClass implements CompareA{

    public void method2(){
        System.out.println("SubClass: 上海");
    }

}
