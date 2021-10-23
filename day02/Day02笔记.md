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
}
```

