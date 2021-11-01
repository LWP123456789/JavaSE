# Day08笔记

## super

```java
/*
	super关键字的使用
	1.super理解为：父类的
	2.super可以用来调用：属性、方法、构造器
	
	3.super的使用
		3.1 我们可以在子类的方法或构造器中。通过使用"super.属性"或"super.方法"的方式，显式的调用父类中声明的属性或方法。但是，通常情况下，我们习惯省略"super."
		3.2 特殊情况：当子类和父类中定义了同名的属性时，我们要想在子类中调用父类中声明的属性，则必须显式的使用"super.属性"的方式，表明调用的是父类中声明的属性
		3.3 特殊情况:当子类重写了父类中的方法以后，我们想在子类的方法中调用父类中被重写的方法时，则必须显式的使用"super.方法"的方式，表明调用的是父类中被重写的方法。
	4.super调用构造器
		4.1 我们可以在子类的构造器中显式的使用"super(形参列表)"的方式，调用父类中声明的指定的构造器
		4.2 "super(形参列表)"的使用，必须声明在子类构造器的首行!
		4.3 我们在类的构造器中，针对于"this(形参列表)"或"super(形参列表)"只能二选一，不能同时出现
		4.4 当构造器的首行，没有显式的声明"this(形参列表)"或"super(形参列表)"，则默认调用的是父类中空参的构造器
		4.5 在类的多个构造器中，至少有一个类的构造器中使用了"super(形参列表)"，调用父类中的构造器
*/

public class Person {
    String name;
    int age;
    int id = 1001;//身份证号
    
    public Person() {
        
    }
    
    public Person(String name){
        this.name = name;
    }
    
    public Person(String name,int age){
        this(name);
        this.age = age;
    }
    
    public void eat(){
        System.out.println("人，吃饭");
    }
    
    public void walk(){
        System.out.println("人，走路");
    }
}

public class Student extends Person{
    
    String major;
    int id = 1002;//学号
    
    public Student(){
        
    }
    public Student(String major){
        this.major = major;
    }
    
    public Student(String name,int age,String major){
        //this.name = name;
        //this.age = age;
        super(name,age);
        this.major = major;
    }
    
    @Override
    public void eat() {
        System.out.println("学生，多吃有营养的食物");
    }
    
    public void study() {
        System.out.println("学生，学习知识");
    }
    
    public void show() {
        System.out.println("name = " + this.name + ", age = " + super.age);
    }
}

public class SuperTest {
    public static void main(String[] args) {
        
        Student s = new Student();
        s.show();
        
        System.out.println();
        
        S.study();
        
        Student s1 = new Student("Tom",21,"IT");
        s1.show();
    }
}
```

> 属性不会出现覆盖

**调用父类的构造器** 

子类中所有的构造器**默认**都会访问父类中**空参数**的构造器 

当父类中没有空参数的构造器时，子类的构造器必须通过**this(参数列表)**或者**super(参数列表)**语句指定调用本类或者父类中相应的

构造器。同时，只能”二选一”，且必须放在构造器的首行 

`如果子类构造器中既未显式调用父类或本类的构造器，且父类中又`

`没有无参的构造器，则**编译出错`**

```java
/*
 * 子类对象实例化的全过程
 * 
 * 1. 从结果上来看：（继承性）
 * 		子类继承父类以后，就获取了父类中声明的属性或方法。
 *      创建子类的对象，在堆空间中，就会加载所有父类中声明的属性。
 * 
 * 2. 从过程上来看：
 * 		当我们通过子类的构造器创建子类对象时，我们一定会直接或间接的调用其父类的构造器，进而调用父类的父类的构造器，...
 *    直到调用了java.lang.Object类中空参的构造器为止。正因为加载过所有的父类的结构，所以才可以看到内存中有
 *    父类中的结构，子类对象才可以考虑进行调用。
 *    
 *  
 * 明确：虽然创建子类对象时，调用了父类的构造器，但是自始至终就创建过一个对象，即为new的子类对象。
 * 
 */
```

## 多态性

```java
package top.lep101.java;

/**
 * 编译看左，运行看右
 *
 * 面向对象特征之三：多态性
 *
 * 1.理解多态性：可以理解为一个事物的多种邢台。
 * 2.何为多态性：
 *     对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
 * 3.多态的使用：虚拟方法调用
 *     有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际运行的是子类重写父类的方法。
 *     总结：编译，看左边；运行，看右边。
 * 4.多态性的使用前提：① 类的继承关系 ② 要有方法的重写
 * 5.对象的多态性,只适用于方法，不适用于属性（编译和运行都看左边）
 */
public class PersonTest {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.eat();

        Man man = new Man();
        man.eat();
        man.age = 25;
        man.earnMoney();

        //***************************************************
        //对象的多态性：父类的引用指向子类的对象
        Person p2 = new Man();

        Person p3 = new Woman();

        //多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法  ---虚拟方法调用
        p2.eat();
        p2.walk();



    }
}

public class Man extends Person{

    boolean isSmoking;

    @Override
    public void walk() {
        System.out.println("handsome walking");
    }

    @Override
    public void eat() {
        System.out.println("eat more");
    }

    public void earnMoney(){
        System.out.println("earning Money");
    }

}

public class Woman extends Person{

    boolean isBeauty;

    public void goShopping(){
        System.out.println("goShopping");
    }

    @Override
    public void eat() {
        System.out.println("eat less");
    }

    @Override
    public void walk() {
        System.out.println("beautifully walk");
    }
}

public class Person {
    String name;
    int age;

    public void eat(){
        System.out.println("eating");
    }

    public void walk(){
        System.out.println("walking");
    }
}

//多态性的使用举例一：
//可见多态性省去了很多方法重载的过程
public class AnimalTest {

    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new Dog());

        test.func(new Cat());
    }

    public void func(Animal animal){
        animal.eat();
        animal.shout();
    }
}

class Animal {
    public void eat(){
        System.out.println("动物：进食");
    }

    public void shout(){
        System.out.println("动物：叫");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void shout() {
        System.out.println("喵喵喵");
    }
}

```

下转型

有了对象的多态性以后，内存中实际上是加载了类特有的属性和方法的，但是由于变量声明为父亲类型，导致编译时，只能调用父类声明的属性和方法，子类持有的属性和方法不能调用。



//使用强制类型转换符实现向下转型

```
Man m1 = (Man)p1;
m1.earnMoney();
m1.isSmoking = true;
```

instanceof关键字的使用

a instance A ： 判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。

使用情景：为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先进行instanceof的判断，一旦返回true，就进行向下转型，如果返回false，不进行向下转型。



如果

```java
if(p1 instanceof Woman){
    Woman w1 = (Woman)p1;
    w1.goShopping();
    System.out.println("******Woman********");
}
if(p1 instanceof Man){
    Man m1 = (Man)p1;
	m1.earnMoney();
    System.out.println("******Man********");
}
```

//练习

```java
//问题一：编译时通过，运行时不通过
Person p3 = new Woman();
Man m3 = (Man)p3;

//问题二：编译通过，运行时也通过
Object obj = new Woman();
Person p = (Person)obj
    
//问题三：编译不通过
    Man m5 = new Woman();
/*
1.若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，系统将不可能把父类里的方法转移到子类中。
2.对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，这个实例变量依然不可能覆盖父类中定义的实例变量，编译运行都看左边
*/
```

```java
/**
 * java.lang.Object类
 * 1.Object类是所有Java类的根父类
 * 2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类
 * 3.Object类中的功能（属性、方法）就具有通用型。
 *      属性：无
 *      方法：equals()/toString()/getClass()/hashCode()/clone()/finalize()/wait()/notify()/notifyAll()
 * 4.Object类只声明了一个空参的构造器
 *
 * 面试题：final、finally、finalize的区别？
 * 前俩关键字，后一个垃圾回收，三者之间无关系
 */
public class ObjectTest {
    public static void main(String[] args) {

        Order order = new Order();
        System.out.println(order.getClass().getSuperclass());

    }
}

class Order{

}
```

==运算符比较基本数据类型和引用数据类型

```java
/**
 * 面试题： == 和 equals() 区别
 *
 * 一、回顾 == 的使用
 * ==：运算符
 * 1.可以使用在基本数据类型变量和引用数据类型变量中
 * 2.如果比较的基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
 *   如果比较的引用数据类型变量：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
 *
 * 二、equals()方法的使用
 * 1.是一个方法，而非运算符
 * 2.只能使用于引用数据类型
 * 3.Object类中equals()的定义：
 *      public boolean equals(Object obj) {
 *          return (this == obj);
 *      }
 *      说明：Object类中定义的equals()和==的作用是相同的；比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
 * 4.像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是两个引用的地址是否相同，而是比较两个对象的"实体内容"是否相同
 * 5.通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们就需要对Object类中的equals()进行重写。
 *   重写的原则：比较两个对象的实体内容是否相同
 */
public class EqualsTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(j == i);
        System.out.println(i == d);

        char c = 10;
        System.out.println(i == c);


    }
}

```

