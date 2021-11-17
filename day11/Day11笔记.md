# Day11笔记

## 单例设计模式

/*
 * 单例设计模式：

 * 1. 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例。

 * 

 * 2. 如何实现？

 * ​        饿汉式  vs 懒汉式

 * 

 * 3. 区分饿汉式 和 懒汉式

 * 饿汉式：	

 * 坏处：对象加载时间过长。（浪费内存）

 * 好处：饿汉式是线程安全的

 * 

 * 懒汉式：好处：延迟对象的创建。（节省内存空间）

 * 目前的写法坏处：线程不安全。--->到多线程内容时，再修改

 * 

 * ```java
  * */
    public class SingletonTest1 {
	   public static void main(String[] args) {
    //		Bank bank1 = new Bank();
    //		Bank bank2 = new Bank();
	   	
	
	   	Bank bank1 = Bank.getInstance();
	   	Bank bank2 = Bank.getInstance();
	   	
	   	System.out.println(bank1 == bank2); //true
 
    }
    }
 
 //饿汉式
 class Bank{
 	
 
 	//1.私有化类的构造器
 	private Bank(){
 		
 	}
 	
 	//2.内部创建类的对象
 	//4.要求此对象也必须声明为静态的
 	private static Bank instance = new Bank();
 	
 	//3.提供公共的静态的方法，返回类的对象
 	public static Bank getInstance(){
 		return instance;
 	}
 
 }
 ```
 
 ```java
 /*
  * 单例模式的懒汉式实现
  * 
  */
 public class SingletonTest2 {
 	public static void main(String[] args) {
 		
 		Order order1 = Order.getInstance();
 		Order order2 = Order.getInstance();
 		
 		System.out.println(order1 == order2);
 		
 	}
 }
 
 
 class Order{
 	
 	//1.私有化类的构造器
 	private Order(){
 		
 	}
 	
 	//2.声明当前类对象，没有初始化
 	//4.此对象也必须声明为static的
 	private static Order instance = null;
 	
 	//3.声明public、static的返回当前类对象的方法
 	public static Order getInstance(){
 		
 		if(instance == null){
 			
 			instance = new Order();
 			
 		}
 		return instance;
 	}
 	
 }
 ```
 
 >
 > 总结：饿汉式单例设计模式直接new，而懒汉式多了个条件，当满足条件时才new。

**单例(Singleton)设计模式**-**应用场景**

 网站的计数器，一般也是单例模式实现，否则难以同步。

 应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志

文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。

 数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库

资源。 

 项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置

文件数据，都生成一个对象去读取。 

 Application 也是单例的典型应用

 Windows的Task Manager (任务管理器)就是很典型的单例模式

 Windows的Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程

中，回收站一直维护着仅有的一个实例。