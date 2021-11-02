# Day09笔记

## toString()

```java
/*
Object类中toString()的使用

1.当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
2.Object类中toString()的定义：
	public String toString() {
		return getClass().getName() + "@" + Integer.toHexString(hashCode());
	}
3.像String、Date、File、包装类等都重写了Object类中的toString()方法
  使得在调用对象的toString()时，返回"实体内容"信息
  
4.自定义类也可以重写toString()方法，当调用此方法时，返回对象的"实体内容"
*/
public class ToStringTest {
	public static void main(String[] args) {
        
        Customer cust1 = new Customer("Tom",21);
        System.out.println(cust1.toString());
        System.out.println(cust1);
        
        String str = new String("LWP");
        System.out.println(str);//LWP
        
		Date date = new Date(4534534534543L);
        System.out.println(date.toString());//Mon Sep 11 08:55:34 GMT+08:00......
    }
}
```

测试练习

```java
package top.lep101.java3;

/**
 * 写一个测试类，创建两个Circle对象，判断其颜色是否相等;
 */
public class CircleTest {
    public static void main(String[] args) {

        Circle circle1 = new Circle(2.3);
        Circle circle2 = new Circle(new String("white"),2.0,3.3);

        System.out.println("颜色是否相等：" + circle1.getColor().equals(circle2.getColor()));

        System.out.println("半径是否相等：" + circle1.equals(circle2));

        System.out.println(circle1);
        System.out.println(circle2.toString());
    }
}

package top.lep101.java3;

public class Circle extends GeometricObject {

    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //求圆的面积
    public double findArea(){
        return 3.14 * radius * radius;
    }

    //比较两个圆的半径是否相等，如相等，返回true

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Circle){
            Circle c = (Circle) obj;
            return this.radius == c.radius;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}

package top.lep101.java3;

public class GeometricObject {

    protected String color;
    protected double weight;

    public GeometricObject() {
        this.color = "white";
        this.weight = 1.0;
    }

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

```

> `Java`中的JUnit单元测试
>
> 步骤：
>
> 1.选中当前工程 - 右键选择： build path - add libraries - JUnit4 - 下一步
>
> 2.创建Java类，进行单元测试。
>
> 此时的Java类要求：①此类是public的 ②此类提供公共的无参的构造器
>
> 3.此类中声明单元测试方法。
>
> 此时的单元测试方法：**方法的权限是public，没有返回值类型，没有形参**
>
> 4.此单元测试方法上需要声明注解：@Test，并在单元测试类中导入：import org.junit.Test;
>
> 5.声明好单元测试方法以后，就可以在方法体内测试相关的代码。
>
> 6.写完代码以后，测试

```java
public class JUnitTest {
    
    @Test
    public void testEquals(){
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));
    }
}
```

## 包装类

针对八种基本数据类型定义相应的引用类型—包装类（封装类）

有了类的特点，就可以调用类中的方法，Java才是真正的面向对象

![](E:\CSDN\JAVA\包装类.png)

基本类型、包装类与String类间的转换

![](E:\CSDN\JAVA\基本数据类型_包装类_String类之间的关系.png)

```java
/*
包装类的使用:
1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征

2.掌握的：基本数据类型、包装类、String三者之间的相互转换
*/
public class WrapperTest {
    
    //基本数据类型 --->包装类：调用包装类的构造器
    @Test
    public void test(){
        int num1 = 10;
        //System.out.println(num1.toString());
        Integer in1 = new Integer(num1);
        System.out.println(in1.toString());
        
        Integer in2 = new Integer("123");
        System.out.println(in2.toString());
        
        //报异常
        //Integer in3 = new Integer("123abc");
        //System.out.println(in3.toString());        
        
        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3");
        System.out.println(f1);
        System.out.println(f2);
        
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        System.out.println(b2);//true
        Boolean b3 = new Boolean("true123");
        System.out.println(b3);//false
    }
    
    //包装类 --->基本数据类型：调用包装类的xxxValue()
    @Test
    public void test2(){
        Integer in1 = new Integer(12);
        
        int i1 = in1.intValue();
        System.out.println(i1 + 1);
        
        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2 + 1);
    }
    
    /*
    JDK5.0新特性：自动装箱与自动拆箱
    */
    @Test
    public void test3(){
        int num1 = 10;
        //基本数据类型 --> 包装类的对象
        method(num1);//
        
        //自动装箱：
        int num2 = 10;
        Integer in1 = num2;//自动装箱
        
        boolean b1 = true;
        Boolean b2 = b1;//自动装箱
        
        //自动拆箱：包装类 --> 基本数据类型
        System.out.println(in1.toString());
        
        int num3 = in1;//自动拆箱
    }
    
    public void method(Object obj){
        System.out.println(obj);
    }
    
    //基本数据类型、包装类 --> String类型
    @Test
    public void test4(){
        
        int num1 = 10;
        //方式1：连接运算
        String str1 = num1 + "";
        //方式2：
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);//"12.3"
        //以下例子体现了自动拆箱
        Double d1 = new Double(12.4);
        String str3 = String.valueOf(d1);
        System.out.println(str2);
        System.out.println(str3);
    }
    
    //String类型 --> 基本数据类型、包装类:调用包装类的parseXxx()
    @Test
    public void test5(){
        String str1 = "123";
        //错误的情况：
        //int num1 = (int)str1;
        //Integer in1 = (Integer)str1;
        
        int num2 = Integer.parseInt(str1);
        System.out.println(num2 + 1);
        
        String str2 = "true";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);
    }
}
```

面试题

```java
public class InterviewTest {
    @Test
    public void test1() {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        //三元运算符两表达式为同种类型
        //三元运算符会进行自动类型提升
        System.out.println(o1);//1.0
        //自动拆箱
        //包装类重写了toString()方法输出实体内容而不是地址
    }
    @Test
    public void test2(){
        Object o2;
        if(true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);//1
    }
    
    @Test
    public void test3() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false 比的是地址
        
        //Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
        //保存了从-128~127范围的整数，如果我们使用自动装箱的方式，给Integer赋值的范围在
        //-128~127范围内时，可以直接使用数组中的元素。不用再去new了。
        
        Integer m = 1;
        Integer n = 1;
        System.our.println(m == n);//true
        
        Integer x = 128;//相当于new了一个Integer对象
        Integer y = 128;//相当于new了一个Integer对象
        System.out.println(x == y);//false
    }
}
```

测试练习

```java
package top.lep101.java3;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        //1.实例化Scanner，用于从键盘获取学生成绩
        Scanner scan = new Scanner(System.in);
        //2.创建Vector对象，Vector v = new Vector();相当于原来的数组
        Vector v = new Vector();
        //3.通过for(;;)或while(true)方式，给Vector中添加数组
        int maxScore = 0;
        for (;;){
            System.out.println("请输入学生成绩（以负数代表输入结束）");
            int score = scan.nextInt();
            //3.2当输入是负数时，跳出循环
            if (score < 0) {
                break;
            }
            if (score > 100){
                System.out.println("输入的数据非法，请重新输入");
                continue;
            }
            //3.1添加操作：v.addElement(Object obj)
            /*jdk5.0之前：
            Integer inScore = new Integer(score);
            v.addElement(inScore);//多态*/
            //jdk5.0之后:
            v.addElement(score);//自动装箱
            //4.获取学生成绩的最大值
            if (maxScore < score){
                maxScore = score;
            }
        }
        char level;
        //5.遍历Vector,得到每个学生的成绩，并于最大成绩比较，得到每个学生的等级。
        for (int i = 0; i < v.size(); i++){
            Object obj = v.elementAt(i);
            //jdk5.0后
            int score = (int)obj;

            if (maxScore - score <= 10){
                level = 'A';
            }else if (maxScore - score <= 20) {
                level = 'B';
            }else if (maxScore - score <= 30) {
                level = 'C';
            }else{
                level = 'D';
            }

            System.out.println("student-" + i + " score is " + score+ ",level is " + level);
        }
    }
}
```

