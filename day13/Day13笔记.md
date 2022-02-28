# Day13笔记
## 抽象类与抽象方法 (关键字abstract)

abstract关键字的使用：

1.abstract ： 抽象的

2.abstract可以用来修饰的结构：类、方法

3.abstract修饰类：抽象类（此类不能实例化,抽象类中一定有构造器，便于子类实例化时调用,开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作）

4.abstract修饰方法：抽象方法

​	> 抽象方法只有方法的声明，没有方法体

​	> 包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法的

​	> 若子类重写了父类中的所有的抽象方法后，此子类方可实现实例化

```java
public class AbstractTest {
    public static void main(String[] args) {
		
        //一旦Person类抽象了，就不可实例化
        //Person p1 = new Person();
        //p1.eat();
        
    }
}

abstract class Creature {
    public abstract void breath();
}

abstract class Person extends Creature{
    String name;
    int age;
    
    public Person() {
        
    }
   
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat() {
    	System.out.println("人吃饭");
    }
    
    public void walk() {
    	System.out.println("人走路");
    }
}

class Student extends Person {
    
    public Student(String name,int age) {
        super(name,age);
    }
    
    public void eat() {
        System.out.println("吃东西");
    }
    
	@Override
    public void breath() {
        System.out.println("呼吸新鲜空气");
    }
    
}
```

### 抽象类应用

抽象类是用来模型化那些父类无法确定全部实现，而是由其子类提供具体实现的对象的类

（给子类编写一个父类标准）

### abstract使用注意点

1.abstract不能用来修饰：属性、构造器等结构

2.abstract不能用来修饰私有方法、静态方法、final关键字修饰的方法、final修饰的类

### 抽象类的匿名子类

```java
public class PersonTest {
    public static void main(String[] args) {
        method(new Student());//匿名对象
        
        Worker worker = new Worker();
        method1(worker);//非匿名的类非匿名对象
        
        method1(new Worker());//非匿名的类匿名的对象
        System.out.println("*****************");
        
        //创建匿名子类的匿名对象
        method1(new Person(){
            @Override
            public void eat() {
                System.out.println("吃好吃的");
            }
            
            @Override
            public void breath() {
                System.out.println("好好呼吸新鲜空气");
            }
        })
    }
    
    public static void method1(Person p) {
        p.eat();
        p.walk();
    }
    
    public static void method(Student s) {
        
    }
}

class Worker extends Person {
    
    @Override
    public void eat() {
        
    }
}
```

### 多态的应用：模板方法设计模式

抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。

解决的问题：

当功能内部一部分实现是确定的，一部分实现是不确定的。这时候可以把不确定的部分暴露出去，让子类去实现。

```java
public class TemplateTest {
    
    public static void main(String[] args) {
        
        SubTemplate t = new SubTemplate();
        
        t.spendTime();
            
    }
    
}
abstract class Template {
    
    //计算某段代码执行所需要花费的时间
    public void spendTime() {
        long start = System.currentTimeMillis();
        
        code();
        
        long end = System.currentTimeMillis();
        
        System.out.println("花费的时间： " + (end - start));
        
    }
    
    public abstract void code();
    
}

class SubTemplate extends Template {
    
    @Override
    public void code() {
        for(int i = 2; i <= 1000; i++) {
            boolean isFlag = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                
                if(i % j == 0) {
                    isFlag = false;
                    break;
                }
                
            }
            if(isFlag){
               System.out.println(i);  
            }
        }
    }
    
}
```

## 接口（interface）

接口的使用

1.接口使用interface来定义

2.Java中，**接口和类是并列的两个结构**

3.如何定义接口：定义接口中的成员

​	3.1 JDK7及以前: 只能定义全局常量和抽象方法

​		>全局常量：public static final的 . 但是书写时，可以省略不写

​		>抽象方法：public abstract的

​	3.2 JDK8:除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法（略）

​		>全局常量: public static final的

​		>抽象方法: public abstract的

​	3.2 JDK8：除了定义全局常量和抽象方法外，还可以定义静态方法、默认方法

4.接口中不能定义构造器！意味着接口不可以实例化

5.Java开发中，接口通过让类去实现（implements）的方式来使用

> ​	如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
>
> ​	如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类

6.Java类可以实现多个接口哦 ---> 弥补了Java单继承性的的局限性

> class Bullet implements Flyable, Attackable{}

> 先继承父类，再实现接口

7.接口与接口之间可以继承，而且可以多继承

8.接口的具体使用，体现多态性

9.接口，实际上可以看作是一种规范

```java
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
//*************************************************
interface AA {
    void method1();
}
interface BB {
    void method2();
}

interface CC extends AA,BB {
    
}


```

**面试题：抽象类与接口有哪些异同？**
