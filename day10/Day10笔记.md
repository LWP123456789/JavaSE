# Day10笔记

## static

**成员变量**就是类里面的变量，不区分static
没有static的成员变量叫**实例变量**
加了static就叫**类变量**，实际上和类没啥关系，就相当于一个寄生物一样，而且除了类变量外，你喜欢叫全局变量(public 修饰)、静态变量都行
最后他俩统称**类的成员变量**

```java
package top.lep101.java4;

/**
 * static关键字的使用
 *
 * 1.static：静态的
 * 2.static可以用来修饰：属性、方法、代码块、内部类
 *
 * 3.使用static修饰属性：静态变量
 *      3.1属性：按是否使用static修饰，又分为：静态属性 vs 非静态属性(实例变量)
 *          实例变量：我们创建了类的多个对象，每个对象都独立地拥有一套类中的非静态属性。当修改其中一个对象中的非静态属性时，不会导致其他对象中同样的属性值的修改。
 *          静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致其他对象调用此静态变量时，是修改过了的。
 *      3.2 static修饰属性的其他说明：
 *          ①静态变量随着类的加载而加载。可以通过"类.静态变量"的方式进行调用
 *          ②静态变量的加载要早于对象的创建。
 *          ③由于类只会加载一次，则静态变量在内存中也只会存在一份，存在方法区的静态域中。
 *
 *          ④           类变量             实例变量
 *          类            yes                no
 *          对象          yes                yes
 *
 *      3.3 静态变量举例：System.out;Math.PI;
 *
 * 4.使用static修饰方法：静态方法
 *      ① 随着类的加载而加载，可以通过"类.静态方法"的方式进行调用
 *      ②               静态方法            非静态方法
 *          类             yes                 no
 *          对象           yes                 yes
 *      ③ 静态方法中，只能调用静态的方法或属性
 *         非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
 *
 * 5.static注意点：
 *      5,1 在静态的方法内，不能使用this、super关键字
 *      //this是基于当前对象的
 *      5.2关于静态属性和静态方法的使用，大家都从声明周期的角度去理解。
 *		5.3父类static方法不会被重写
 *
 * 6.开发中如何确定一个属性是否要声明为static的？
 *      > 属性是可以被多个对象所共享的，不会随着对象的不同而不同的。
 *
 *   开发中如何确定一个方法是否要声明为static的？
 *      > 操作静态属性的方法，通常设置为static的
 *      > 工具类中的方法，习惯上声明为static的，比如：Math、Arrays、Collections
 *
 */
public class StaticTest {
    public static void main(String[] args) {

        Chinese.nation = "中国";

        Chinese c1 = new Chinese();
        c1.name = "yaoming";
        c1.age = 40;

        Chinese c2 = new Chinese();
        c2.name = "malong";
        c2.age = 30;

        c1.eat();

        Chinese.show();

/*        Chinese.nation = "CNH";*/

//        System.out.println(Chinese.nation);
    }
}

//中国人
class Chinese{

    String name;
    int age;
    static String nation;

    public void eat(){
        System.out.println("Chinese eat Chinese food");
    }

    public static void show() {
        System.out.println("I am a Chinese");
    }
}
```

> 操作静态属性的方法，通常设置为static的
>
> 工具类中的方法，习惯上声明为static的，比如：Math、Arrays、Collections

static理解练习

```java
package top.lep101.java4;

public class AccountTest {

    public static void main(String[] args) {

        Account acct1 = new Account();
        Account acct2 = new Account("Golang123456",2000);

        Account.setInterestRate(0.012);
        Account.setMinMoney(100);

        System.out.println(acct1);
        System.out.println(acct2);

        System.out.println(acct1.getInterestRate());
        System.out.println(acct1.getMinMoney());
    }
}

class Account {

    private int id;
    private String pwd = "000000";
    private double balance;

    private static double interestRate;
    private static double minMoney = 1.0;
    private static int init = 1001;//用于自动生成id使用的

    public Account() {
        id = init++;
    }

    public Account(String pwd,double balance) {
        this();
        this.pwd = pwd;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }

}
```

```java
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

```

