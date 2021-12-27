package top.lep101.java;
/*
* 单例设计模式
* */
public class Singleton {
    public static void main(String[] args) {

        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2);

        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();

        System.out.println(order1==order2);

    }

}

//饿汉式
class Bank {

    //1.私有化类的构造器
    private Bank(){

    }

    //2.内部创建类的对象
    private static Bank instance = new Bank();

    //3.提供公共的方法，返回类的对象
    public static Bank getInstance() {
        return  instance;
    }

}

//懒汉式
class Order {

    //1.私有化类的构造器
    private Order() {

    }

    //2.声明当前类对象，没有初始化
    private static Order instance = null;

    //3.声明public、static的返回类对象的方法
    public static Order getInstance() {
        if (instance == null){
            instance = new Order();
        }
        return instance;
    }

}

