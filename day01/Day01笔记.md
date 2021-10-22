# Day01笔记

> Java语言环境的关系(JDK、JRE、JVM关系)
>
> JDK = JRE + 开发工具集(例如Javac编译工具等)
>
> JRE = JVM + Java SE标准类库

## HelloWorld程序

```
class HelloChina {

	public static void main(String[] args){
		System.out.println("Hello World!");
	}

}
```

使用`javac HelloWorld.java`编译，使用`java HelloChina`执行字节码文件

public后的类名和文件名必须一致

> 在一个java源文件中可以声明多个class。但是，只能最多有一个类声明为public的。
>
> **而且要求声明为public的类的类名必须与源文件名相同**

> 程序的入口是main()方法，格式是固定的。



## 关键字与保留字

定义：被Java语言赋予了特殊含义,用做专门用途的字符串(单词)

特点：关键字中所有字母都为小写

## 标识符

Java对各种变量、方法和类等要素命名时使用的字符序列称为标识符

技巧：凡是自己可以起名字的地方都叫标识符

定义合法标识符规则：

由26个英文字母大小写，0-9 ，_或 **$** **组成**

**数字不可以开头。**

**不可以使用关键字和保留字，但能包含关键字和保留字。**

Java中严格区分大小写，长度无限制。

**标识符不能包含空格。**

### Java中的名称命名规范

包名：多单词组成时所有字母都小写: xxxyyyzzz

类名、接口名：多单词组成时，所有单词的首字母大写：XxxYyyZzz(驼峰式)

变量名、方法名：多单词组成时，第一个单词首字母小写，第二个单词开始每个单词首字母大写：xxxYyyZzz

常量名：所有字母都大写。多单词时每个单词用下划线连接：XXX_YYY_ZZZ

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