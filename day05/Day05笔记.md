# Day05笔记

```java
//如果创建了一个类的多个对象，则每个对象都独立的拥有一套类的属性。（非static的）
//意味着：如果我们修改一个对象的属性a，则不影响另外一个对象属性a的值
```

```java
//对象的内存解析
//堆：此内存区域的唯一目的就是存放对象实例，几乎所有的对象实例都在这里分配内存
//栈：虚拟机栈。存储局部变量等
//方法区:存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据

//类中属性的使用
/*
属性（成员变量） vs 局部变量
1.相同点：
	1.1定义变量的格式：数据类型 变量名  = 变量值
	1.2先声明，后使用
	1.3变量都有其对应的作用域

2.不同点：
	2.1在类中声明的位置的不同
	属性：直接定义在类的一对{}内
	局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量
	
	2.2关于权限修饰符的不同
	属性：可以在声明属性时，指明其权限，使用权限修饰符。
	常用的权限修饰符：private、public、缺省、protected --->封装性
	局部变量：不可以使用权限修饰符.
	
	2.3默认初始化值ed情况：
	属性：类的属性，根据其类型，都有默认初始化值。
		整形（byte、short、int、long）:0
		浮点型（float、double）：0.0
		字符型（char）：0（或'\u0000'）
		布尔型（boolean）：false
		
		引用数据类型（类、数组、接口）：null
		
	局部变量：没有默认初始化值。
		意味着，我们在调用局部变量之前，一定要显式赋值。
		特别地，形参在调用时，我们赋值即可。
	
	2.4在内存中加载的位置：
	属性：加载到堆空间中（非static）
	局部变量：加载到栈空间

public class UserTest {
	public static void main(String[] args) {
		User u1 = new User();
		System.out.println(u1.name);
		System.out.println(u1.age);		
		System.out.println(u1.isMale);
        
        u1.talk("日语");
     
	}
}

class User {
	//属性（或成员变量）
	String name;
	int age;
	boolean isMale;
	
	public void talk(String language){//language：形参，也是局部变量
		System.out.println("使用" + language + "进行交流");
	}
	
	public void eat(){
		String food = "玫瑰饼";//局部变量
		System.out.println("云南人喜欢吃：" + food);
	}
}

*/
```

```java
/*
	类中方法的声明和使用
	
	方法：描述类应该具有的功能。
	
	1.方法的声明：(一定有下面的部分)
	权限修饰符 返回值类型 方法名（形参列表）{
		方法体
	}
	2.说明：
		2.1关于权限修饰符：默认方法的权限修饰符先都使用public
			Java规定的4种权限修饰符：private、public、缺省、protected --封装性细说
			
		2.2返回值类型：有返回值 vs 无返回值
			2.2.1 如果方法有返回值，则必须在方法声明时，指定返回值的类型。同时，方法中，需要使				  用return关键字来返回指定类型的变量或常量.
			2.2.2 如果方法无返回值，则方法声明时，使用void来表示，通常，没有返回值的方法中，				   就不使用return.但是，如果使用的话，只能"return;"表示结束此方法的意思。
		2.3方法名：属于标识符，遵循标识符的规则好规范，“见名知意”
		2.4形参列表：方法可以声明0个，1,个，或多个形参。
		2.5方法体：方法功能的体现
	
	3.return关键字的使用：
		1.适用范围：使用在方法体中
		2.作用：①结束方法
			   ②针对于有返回值的方法，使用"return 数据"方法返回所要的数据
		3.注意点：return关键字后面不可以声明执行语句
	
public class CustomerTest {
	public static void main(String[] args){
		Customer cust1 = new Customer();
		
		cust1.eat();
	}
}

//客户类
class Customer{

	//属性
	String name;
	int age;
	boolean isMale;
	
	//方法
	public void eat(){
		System.out.println("客户吃饭");
	}
	
	public void sleep(int hour){
		System.out.println("休息了" + hour + "个小时");
	}
	
	public String getName(){
		if(age > 18){
			return name;
		}else{
			return "Tom";
		}
	}
	
	public String getNation(String nation) {
		String info = "我的国际是：" + nation;
		return info;
	}
}
*/
```

```java
//求圆的面积
//测试类
public class CircleTest {
    public static void main(String[] arg) {
        
        Circle c1 = new Circle();
        
        System.out.println(c1.findArea());
    }
}

class Circle {
    //属性
    double radius;
    
    //求圆的面积
    public double findArea(){
        double area = Math.PI * radius *radius;
        return area;
    }
}
```

```java
//对象数组
public class StudentTest {
    public static void main(String[] args) {
        //声明Student类型的数组
        Student[] stus = new Student[20];
        
        for(int i = 0; i < stus.length; i++){
            //给数组元素赋值
            stus[i] = new Student();
            //给Student对象的属性赋值
            stus[i].number = (i + 1);
            stus[i].state = Math.random() * (6 - 1 + 1) + 1;
            //年纪[1,6]
            //随机数a~b公式：int value = （int)(Math.random() * (b - a + 1) + a)
            //成绩[0,100]
            stus[i].score = (int)(Math.random() * (100 - 0 + 1));
        }
        
        //遍历学生数组
        for(int i = 0; i < stus.length; i++) {
            //System.out,println(stus[i].number + "," + stus[i].state
            //                   + "," + stus[i].score);
            System.out.println(stus[i].info());
        }
    }
}

class Student{
    int number;//学号
    int state;//年级
    int score;//成绩
    
    //显示学生信息的方法
    public String info(){
        return "学号：" + number + ",年纪：" + state + "，成绩：" + score;
    }
}
```

Math.random()方法的补充说明：

> Java中Math类的random()方法可以生成[0,1)之间的随机浮点数。而double类型数据强制转换成int类型，整数部分赋值给int类型变量，小数点之后的小数部分将会丢失。
>
> 如果要生成[0,n]的随机整数的话，只需要Math.random()乘以n+1，生成[0,n+1)的浮点数，再强制类型转换为int类型，只取其整数部分，即可得到[0,n]的整数。
>
> **生成的[m,n]之间的随机整数的方法：先生成[0,n-m]的随机整数，然后再加上m,即可得到[m,n]之间的随机整数。**
