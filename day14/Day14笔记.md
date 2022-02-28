# Day14笔记

## Java8中关于接口的改进

​	Java 8中，你可以为接口添加静态方法和默认方法。从技术角度来说，这是完

全合法的，只是它看起来违反了接口作为一个抽象定义的理念。

​	**静态方法：**使用 static 关键字修饰。可以通过接口直接调用静态方法，并执行

其方法体。我们经常在相互一起使用的类中使用静态方法。你可以在标准库中

找到像Collection/Collections或者Path/Paths这样成对的接口和类。

​	**默认方法：**默认方法使用 default 关键字修饰。可以通过实现类对象来调用。

我们在已有的接口中提供新方法的同时，还保持了与旧版本代码的兼容性。

比如：java 8 API中对Collection、List、Comparator等接口提供了丰富的默认

方法。

> 知识点1：接口中定义的静态方法，只能通过接口来调用
>
> 知识点2：通过实现类的对象，可以调用接口中的默认方法。
>
> 如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
>
> 知识点3：如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法，那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。 --->**类优先原则** (区别属性纠错)
>
> 知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没有重写此方法的情况下，报错。 --->**接口冲突**
>
> 知识点5：如何在子类（或实现类）的方法中调用父类、接口中被重写的方法

```java
public void myMethod() {
    method3();//调用自己定义的重写方法
    super.method3();//调用的是父类中声明的
    //调用接口中的默认方法
    CompareA.super.method3();
    CompareB.super.method3();
}
```



## 接口中的默认方法

**接口中的默认方法**

若一个接口中定义了一个默认方法，而另外一个接口中也定义了一个同名同

参数的方法（不管此方法是否是默认方法），在实现类同时实现了这两个接

口时，会出现：**接口冲突。**

**解决办法**：实现类必须覆盖接口中同名同参数的方法，来解决冲突。

若一个接口中定义了一个默认方法，而父类中也定义了一个同名同参数的非

抽象方法，则不会出现冲突问题。因为此时遵守：**类优先原则。**接口中具有

相同名称和参数的默认方法会被忽略。

## 内部类

1. Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类

2. 内部类的分类：成员内部类（静态、非静态） vs 局部内部类（方法内、代码块内、构造器内）

3. 成员内部类：

   ​	一方面，作为外部类的成员：

   ​		> 调用外部类的结构

   ​		> 可以被static修饰

   ​		> 可以被4种不同的权限修饰

   ​	另一方面，作为一个类：

   ​		> 类内可以定义属性、方法、构造器等

   ​		> 可以被final修饰，表示此类不能被继承。言外之意，不使用final，就可以被继承

   ​		> 可以被abstract修饰，表示该类不能被实例化



```java
public class InnerClassTest {
    
}

class Person{
    
    String name;
    int age;
    
    public void eat(){
        System.out.println("人：吃饭");
    }
    
    //静态成员内部类
    static class Dog{
        String name;
        int age;
        
        public void show(){
            System.out.println("卡拉是条狗");
        }
    }
    
    //非静态成员内部类
    class Bird{
        String name;
        
        public void sing(){
            System.out.println("我是一只小小小小鸟");
            Person.this.eat();
        }
    }
    
    public void method() {
        //局部内部类
        class AA {
            
        }
    }
    {
        //局部内部类
        class BB {
            
        }
    }
    public Person(){
        //局部内部类        
        class CC {
            
        }
    }
}
```

### 关注如下的3个问题

1.如何实例化成员内部类的对象

2.如何在成员内部类中区分调用外部类的结构

3.开发当中局部内部类的使用

```java
package top.lep101.java8;

public class InnerClassTest {
    public static void main(String[] args) {
        //创建Dog实例（静态的成员内部类）
        Person.Dog dog = new Person.Dog();
        dog.show();
        //创建Bird实例（非静态的成员内部类）
        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.sing();
    }
}

class Person{

    String name;
    int age;

    public void eat(){
        System.out.println("人：吃饭");
    }

    //静态成员内部类
    static class Dog{
        String name;
        int age;

        public void show(){
            System.out.println("卡拉是条狗");
        }
    }

    //非静态成员内部类
    class Bird{
        String name;

        public void sing(){
            System.out.println("我是一只小小小小鸟");
            Person.this.eat();
        }
    }

    public void method() {
        //局部内部类
        class AA {

        }
    }
    {
        //局部内部类
        class BB {

        }
    }
    public Person(){
        //局部内部类
        class CC {

        }
    }
}
```

```java
package top.lep101.java8;

public class InnerClassTest {
    public static void main(String[] args) {
        //创建Dog实例（静态的成员内部类）
        Person.Dog dog = new Person.Dog();
        dog.show();
        //创建Bird实例（非静态的成员内部类）
        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.sing();
        bird.display("lep101");
    }
}

class Person{

    String name = "伟培";
    int age;

    public void eat(){
        System.out.println("人：吃饭");
    }

    //静态成员内部类
    static class Dog{
        String name;
        int age;

        public void show(){
            System.out.println("卡拉是条狗");
        }
    }

    //非静态成员内部类
    class Bird{
        String name = "乌鸦";

        public void sing(){
            System.out.println("我是一只小小小小鸟");
            Person.this.eat();
        }

        public void display(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }
    }

    public void method() {
        //局部内部类
        class AA {

        }
    }
    {
        //局部内部类
        class BB {

        }
    }
    public Person(){
        //局部内部类
        class CC {

        }
    }
}
```

```java
package top.lep101.java8;

public class InnerClassTest1 {

    //开发中很少见
    public void method() {
        //局部内部类
        class AA {

        }
    }

    //返回一个实现了Comparable接口的类的对象
    public Comparable getComparable() {

        //创建一个实现了Comparable接口的类 : 局部内部类
        //方式一：创建一个有名实现类的匿名对象
//        class MyComparable implements Comparable {
//
//            @Override
//            public int compareTo(Object o) {
//
//                return 0;
//
//            }
//        }
//
//        return new MyComparable();
        
        //方式二：创建一个匿名实现类的匿名对象
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

}
```

注意点：

在局部内部类的方法中，如果调用局部内部类所声明的方法中的局部变量的话，要求此局部变量声明为final的。（编译为字节码文件时是两个文件）

> jdk 7 及之前版本：要求此局部变量显式地声明为final的
>
> jdk 8及之后的版本：可以省略final的声明

```java
public void method(){
	//局部变量
	int num = 10;
	
	class AA {
		
		public void show() {
		 	System.out.println(num);
		}
		
	}
}
```



## 复习

1.**abstact**能修饰哪些结构？ 修饰以后，有什么特点？

类、方法

类不能实例化，一般**提供子类**让子类去实例化（可被继承）

抽象方法，只定义了一种功能的标准。具体的执行，需要子类去实现

2.接口是否能继承接口？抽象类是否能实现（implements）接口？抽象类是否能继承非抽象的类？

能 能 能

3.**抽象类和接口有哪些共同点和区别？**

相同点：不能实例化，都可以被继承，并列结构

不同点：抽象类有构造器。 接口不能声明构造器

多继承 vs 单继承

