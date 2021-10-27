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

