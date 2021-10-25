# Day04笔记

## Java面向对象

```java
/*
个人总结
Java面向对象学习的三条主线:
1.Java类及类的成员：属性、方法、构造器；代码块、内部类
2.面向对象的三大特征：封装性、继承性、多态性、（抽象性）
3.其它关键字：this、super、static、final、abstract、interface、package、import

面向对象的两个要素：类和对象
类：抽象概念；对象：实实在在的概念
面向对象程序设计的重点是类的设计
设计类，就是设计类的成员

属性 = 成员变量 = field = 域、字段
方法 = 成员方法 = 函数 = method
*/

//创建类的对象 = 类的实例化 = 实例化类
//类和对象的使用（面向对象思想落地的实现）
//1.创建类、设计类的成员
//2.创建类的对象
//3.通过"对象.属性"或"对象.方法"调用对象的结构
//测试类
public class PersonTest{
    public static void main(String[] args) {
        //创建Person类的对象
        Person p1 = new Person();
        
        //调用对象的结构：属性、方法
        //调用属性：“对象.属性”
        p1.name = "Tom";
        p1.isMale = true;
        System.out.println(p1.name);
        
        //调用方法：“对象.方法”
        p1.eat();
        p1.sleep();
        p1.talk("Chinese");
        
    }
}

class Person{
    
    //属性
    String name;
    int age = 1;
    boolean isMale;
    
    //方法
    public void eat(){
        System.out.println("人可以吃饭");
    }
    
    public void sleep(){
        System.out.println("人可以睡觉");
    }
    
    public void talk(String language){
        System.out.println("人可以说话，使用的是：" + language);
    }
    
}
```

