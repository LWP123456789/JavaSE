# Day02笔记

## 变量

```
class VariableTest {
	public static void main(String[] args) {
	//变量的定义
	int myAge = 12;
	//变量的使用
	System.out.println(myAge);
	
	//变量的声明
	int myNumber;
	//变量的赋值
	myNumber = 1001;
	
	System.out.println(myNumber);
	}
}
```

> **使用变量注意：**
>
> Java中每个变量必须先声明，后使用
>
> 使用变量名来访问这块区域的数据
>
> 变量的作用域：其定义所在的一对{ }内 
>
> 变量只有在其作用域内才有效
>
> 同一个作用域内，不能定义重名的变量

![image-20211023091417288](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20211023091417288.png)

`byte:1字节=8bit位 范围 -128~127`

> https://blog.csdn.net/qq_23418393/article/details/57421688

```java
class VariableTest1 {
	//byte范围：-128~127
    byte b1 = 12;
    byte b2 = -128;
    //b2 = 128;//编译不通过
    System.out.println(b1);
    System.out.println(b2);
    //声明long型变量，必须以"1"或"L"结尾
    short s1 = 128;
    int i1 = 1234;
    long l1 = 3414234324L;
    System.out.println(l1);
    
    //浮点型
    //表示带小数点的数值
    //float表示数值的范围比long还大
    
    double d1 = 123.3;
    System.out.println(d1 + 1);
    //定义float类型变量时，变量要以"f"或"F"结尾
    float f1 = 12.3F;
    System.out.println(f1);
    //通常，定义浮点型变量时，选用double
    
    //字符型
    //定义char型变量，通常使用一对''，内部只能写一个字符
    char c1 = 'a';
    System.out.println(c1);
    
    //表示方法：1、声明一个字符 2、转义字符
    char c5 = '\n';//换行符
    // c5 = '\t' //制表符
    System.out.print("Hello"+c5);
    System.out.println("world")
        
    //布尔型：boolean
    //只能取两个值之一：true、false
    //常常在条件判断、循环结构中使用
    boolean bb1 = true;
    System.out.println(bb1);
    
    boolean isMarried = true;
    if(isMarried){
        System.out.println("祝你有一个温暖的家庭");
    }else{
        System.out.println("找个女朋友!");
    }
}
```

### 基本数据类型之间的运算规则：

前提：这里讨论的只是7种基本数据类型变量间的运算。不包含boolean类型的

1.自动类型提升：

结论：当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型

`byte 、 char 、 short --> int --> long --> float --> double`

> 特别的：当byte、char、short三种类型的变量做运算时，结果为int型

```java
class VariableTest2 {
	public static void main(String[] args){
        byte b1 = 2;
        int i1 = 129;
        //编译不通过
        //byte b2 = b1 + i1;
        int i2 = b1 + i1;
        long l1 = b1 + i1;
        System.out.println(i2);
        
        float f = b1 + i1;
        System.out.println(f);
       
        char c1 = 'a';
        int i3 = 10;
        int i4 = c1 + i3;
        System.out.println(i4);
        
        short s2 = 10;
        //char c2 = c1 + s2;//编译不通过
        
        
    }
}
```

2.强制类型转换：

自动类型提升运算的逆运算

1.需要使用强转符：()

2.注意点：强制类型转换，可能导致精度损失。

```java
class VariableTest3 {
	public static void main(String[] args){
        
        double d1 = 12.3;
        
        int i1 = (int)d1;//截断操作
        System.out.println(i1);
        
        //没有精度损失
        long l1 = 123;
        short s2 = (short)l1;
        
        //精度损失举例2
        int i2 = 128;
        byte b = (byte)i2;
        System.out.println(b); //-128
    }
}
```

### 一些注意点：

```java
class VariableTest4 {
	public static void main(String[] args){
        
        //编码情况：
        long l = 123213;
        System.out.println(l);//编译通过,因为此时的l默认为int型
        
     	//编译失败：过大的整数
        //long l1 = 21332423235234123
        long l1 = 21332423235234123L;
        
        //编译失败
        //float f1 = 12.3;
        
        //2.编码情况2：
        //整型常量，默认类型为int型
        //浮点型常量，默认类型为double型
        byte b = 12;
        //byte b1 = b + 1;//编译失败
        
        //float f1 = b + 12.3;//编译失败 高精度不能直接转换为低精度
    }
}
```

### String类型变量的使用

1.`String`属于引用数据类型,翻译为：字符串

2.声明String类型变量时，使用一对""

3.`String`可以和8种基本数据类型变量做运算，且运算只能是连接运算 :+

4.运算的结果仍然是String类型

```java
class StringTest {
    public static void main(String[] args) {
    
        String s1 = "Hello World!";
        
        System.out.println(s1);
        
        String s2 = "a";
        String s3 = "";
        
        //char c = '';//编译不通过，至少放个空格
        
        int number = 1001;
        String numberStr = "学号：";
        String info = numberStr + number;// +：连接运算
        boolean b1 = true;
        String info1 = info + b1;
        System.out.println(info1);
        
        //练习1
        char c = 'a'; //97
        int num = 10;
        String str = "hello";
        System.out.println(c + num + str);//107hello
        System.out.println(c + str + num);//ahello10
        System.out.println(c + (num + str));//a10hello
        System.out.println((c + num) + str);//107hello
        System.out.println(str + num + c);//hello10a
        
        //练习2
        //* *
        System.out.println("*   *");
        System.out.println('*' + "\t" + '*');
        System.out.println('*' + ('\t' + "*"));
    }
}
```

