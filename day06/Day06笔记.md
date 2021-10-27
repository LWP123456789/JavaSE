# Day06笔记

## 面向对象的封装性

```java
/*
 * 面向对象的特征一：封装与隐藏     3W:what? why? how?
 * 一、问题的引入：
 *  当我们创建一个类的对象以后，我们可以通过"对象.属性"的方式，对对象的属性进行赋值。这里，赋值操作要受到
 *  属性的数据类型和存储范围的制约。除此之外，没有其他制约条件。但是，在实际问题中，我们往往需要给属性赋值
 *  加入额外的限制条件。这个条件就不能在属性声明时体现，我们只能通过方法进行限制条件的添加。（比如：setLegs()）
 *  同时，我们需要避免用户再使用"对象.属性"的方式对属性进行赋值。则需要将属性声明为私有的(private).
 *  -->此时，针对于属性就体现了封装性。
 * 
 * 二、封装性的体现：
 * 我们将类的属性xxx私有化(private),同时，提供公共的(public)方法来获取(getXxx)和设置(setXxx)此属性的值
 * 
 *  拓展：封装性的体现：① 如上  ② 不对外暴露的私有的方法  ③ 单例模式   ...
 *  
 * 
 * 三、封装性的体现，需要权限修饰符来配合。
 * 1.Java规定的4种权限（从小到大排列）：private、缺省、protected 、public 
 * 2.4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
 * 3.具体的，4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类
 *        修饰类的话，只能使用：缺省、public
 * 
 * 总结封装性：Java提供了4种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在被调用时的可见性的大小。
 * 
 */
public class AnimalTest {
	public static void main(String[] args) {
		
		Animal a = new Animal();
		a.name = "大黄";
//		a.age = 1;
//		a.legs = 4;//The field Animal.legs is not visible
		
		a.show();
		
//		a.legs = -4;
//		a.setLegs(6);
		a.setLegs(-6);
		
//		a.legs = -4;//The field Animal.legs is not visible
		a.show();
		
		System.out.println(a.name);
		
	}
}


class Animal{
	
	String name;
	private int age;
	private int legs;//腿的个数
	
	//对属性的设置
	public void setLegs(int l){
		if(l >= 0 && l % 2 == 0){
			legs = l;
		}else{
			legs = 0;
//			抛出一个异常（暂时没有讲）
		}
	}
	
	//对属性的获取
	public int getLegs(){
		return legs;
	}
	
	
	public void eat(){
		System.out.println("动物进食");
	}
	
	public void show(){
		System.out.println("name = " + name + ",age = " + age + ",legs = " + legs);
	}
	
	//提供关于属性age的get和set方法
	public int getAge(){
		return age;
	}
	public void setAge(int a){
		age = a;
	}
	
}

//private class Dog{
//	
//}
```

四种权限修饰符：

![](E:\CSDN\JAVA\四种权限修饰符.png)

```java
public class Person {
    
    private int age;
    
    public void setAge(int a){
        if(a < 0 || a > 130){
            //throw new RuntimeException("传入的数据非法!");
            System.out.println("传入的数据非法!");
        }else{
            age = a;
        }
    }
    
    public int getAge(){
    	return age;
    }
}

/*
	在PersonTest类中实例化Person类的对象b,
	调用setAge()和getAge()方法，体会Java的封装性。
*/
public class PersonTest {
    public static void main(String[] args) {
        
        Person p1 = new Person();
        //p1.age = 1;编译不通过
        p1.setAge(12);
        
        System.out.println("年龄为：" + p1.getAge());
    }
}
```

## 构造器

类的结构之三：构造器（或构造方法、constructor）的使用

> 如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器

```java
/*
 * 类的结构之三：构造器（或构造方法、constructor）的使用
 * construct：建设、建造。  construction:CCB    constructor:建设者
 * 
 * 一、构造器的作用：
 * 1.创建对象
 * 2.初始化对象的信息
 * 
 * 二、说明：
 * 1.如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器
 * 2.定义构造器的格式：权限修饰符  类名(形参列表){}
 * 3.一个类中定义的多个构造器，彼此构成重载
 * 4.一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器
 * 5.一个类中，至少会有一个构造器。
 */
public class PersonTest {
	public static void main(String[] args) {
		//创建类的对象:new + 构造器
		Person p = new Person();
		
		p.eat();
		
		Person p1 = new Person("Tom");
		
		System.out.println(p1.name);
		
		
	}
}

class Person{
	//属性
	String name;
	int age;
	
	//构造器
	public Person(){
		System.out.println("Person().....");
	}
	
	public Person(String n){
		name = n;
		
	}
//	
	public Person(String n,int a){
		name = n;
		age = a;
	}

	
	//方法
	public void eat(){
		System.out.println("人吃饭");
	}
	
	public void study(){
		System.out.println("人可以学习");
	}
	
}
```

构造器三角形练习题：

```java
public class TriAngle {
    private double base;//底边长
    private double height;//高
    
    public TriAngle(){
        
    }
    
    public TriAngle(double b,double h){
        base = b;
        height = h;
    }
    
    public void setBase(double b){
        base b;
    }
    
    public double getBase(){
        return base;
    }
    
    public void setHeight(double h){
        height = h;
    }
    
    public double getHeight(){
        return height;
    }
    
}

public class TriAngleTest {
    public static void main(String[] args) {
        
        TriAngle t1 = new TriAngle();
        t1.setBase(2.0);
        t1.setHeight(2.4);
        //t1.base = 2.5;//The field TriAngle.base is not visible
        System.out.println("base : " + t1.getBase() + ",height : " + t1.getHeight());
        
    }
}
```

对赋值顺序验证

```java
/*
 * 总结：属性赋值的先后顺序
 * 
 * 
 * ① 默认初始化
 * ② 显式初始化
 * ③ 构造器中初始化
 * 
 * ④ 通过"对象.方法" 或 "对象.属性"的方式，赋值
 * 
 * 以上操作的先后顺序：① - ② - ③ - ④  
 * 
 */
public class UserTest {
	public static void main(String[] args) {
		User u = new User();
		
		System.out.println(u.age);
		
		User u1 = new User(2);
		
		u1.setAge(3);
		u1.setAge(5);
		
		System.out.println(u1.age);
	}
}

class User{
	String name;
	int age = 1;
	
	public User(){
		
	}
	
	public User(int a){
		age = a;
	}
	
	public void setAge(int a){
		age = a;
	}
	
}
```

**`JavaBean`**

`JavaBean`是一种Java语言写成的可重用组件。

```java
/*
所谓JavaBean，是指符合如下标准的Java类
 >类是公共的
 >有一个无参的公共的构造器
 >有属性，且有对应的get、set方法
*/
public class Customer {
    
    private int id;
    private String name;
    
    public Customer(){
        
    }
    
    public void setId(int i){
        id = i;
    }
    public int getId(){
        return id;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
}
```

**this**

1.`this`可以用来修饰：属性、方法、构造器

2.`this`修饰属性和方法

this理解为：当前对象 或 当前正在创建的对象(构造器中)

在类的方法中，我们可以使用"this.属性"或"this.方法"的方式，调用当前对象或当前正在创建的对象的属性或方法。但是，通常情况下，我们都选择省略"this."。

特殊情况下，如果方法的形参和类的属性同名时，我们必须显式地使用"this.变量"的方式，表面此变量是属性，而非形参。

3.`this`调用构造器

①我们在类的构造器中，可以显式地使用"this(形参列表)"方式，调用本类中的其他构造器

②构造器中不能通过"this(形参列表)"方式调用自己

③如果一个类中有n个构造器，则最多有n-1构造器中使用了"this(形参列表)"

④规定："this(形参列表)"必须声明在当前构造器的首行

⑤构造器内部，最多只能声明一个"this(形参列表)"，用来调用其他的构造器

```java
public class PersonTest {
    public static void main(String[] args) {
        
        Person p1 = new Person();
        
        p1.setAge(1);
        System.out.println(p1.getAge());
        
        p1.eat();
    }
}

class Person {
    
    private String name;
    private int age;
    
    public Person(){
        
    }
    
    public Person(String name){
        this.name = name;
    }
    
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    
    public void eat(){
        System.out.println("人吃饭");
        this.study();
    }

    public void study(){
        System.out.println("人学习");
    }
}
```

练习

```java
public class Boy {
    private String name;
    private int age;
    
    public Boy() {
        
    }
    
    public Boy(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void marry(Girl girl){
        System.out.println("我想娶" + girl.getName());
    }
    
    public void shout(){
        if(this.age >= 22){
            System.out.println("你可以去合法登记结婚了!");
        }else{
            System.out.println("先多谈谈恋爱~");
        }
    }
}

public class Girl{
    
    private String name;
    private int age;
    
    public Girl(String name,int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void marry(Boy boy){
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);//this代表当前对象，也就是girl这个对象.
    }
    
    /*
    @Description 比较两个对象的大小
    */
    public int compare(Gril girl){
        //if(this.age > girl.age){
        //    return 1;
        //}else if(this.age < girl.age){
        //    return -1;
        //}else{
        //    return 0;
        //}
        
        return this.age - girl.age;
    }
}

public class BoyGirlTest {
    public static void main(String[] args) {
        
        Boy boy = new Boy("乐培",21);
        boy.shout();
        
        Girl girl = new Girl("nana",18);
        girl.marry(boy);
        
        Girl1 girl1 = new Girl("lili",19);
        int compare = girl.compare(girl1);
        if(compare > 0){
            System.out.println(girl.getName() + "大");
        }else if(compare  < 0){
            System.out.println(girl1.getName() + "大");
        }else{
            System.out.println("一样大");
        }
    }
}
```

