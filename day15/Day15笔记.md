# Day15笔记

## 异常处理

1.编译时异常（编译时不报错）

2.运行时异常

面试题：常见的异常都有哪些？举例说明

```java
public class ExceptionTest {

    //******************以下是编译时异常***********************
    //IOException
    @Test
    public void test7(){
        
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);
        
        int data = fis.read();
        while(data != -1){ //读到-1说明文件读完
            System.out.println((char)data);
            data = fis.read();
        }
        
        fis.close();
        
    }
    
    //******************以下是运行时异常***********************
    //ArithmeticException
    @Test
    public void test6(){
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }
    
    //InputMismatchException
    @Test
    public void test5(){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);
        
        scanner.close();
    }
    
    //NumberFormatException
    @Test
    public void test4(){
        
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
        
    }
    
    //ClassCastException
    @Test
    public void test3(){
        Object obj = new Date();
        String str = (String)obj;
    }
    
    //ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        
        int[] arr = new int[10];
        System.out.println(arr[10]);
        
        //StringIndexOutOfBoundsException
        String str = "abc";
        System.out.println(str.charAt(3));
        
    }
    
    //NullPointerException：空指针异常
    @Test
    public void test1(){
        
        int[] arr = null;
        System.out.println(arr[3]);
        
        String str = "abc";
        str = null
        System.out.println(str.charAt(0));
        
    }
}
```

### 使用**try-catch-finally**解决**编译时异常**

```java
    @Test
    public void test7(){
        try{
        	File file = new File("hello.txt");
        	FileInputStream fis = new FileInputStream(file);
        
       	 	int data = fis.read();
        	while(data != -1){ //读到-1说明文件读完
            	System.out.println((char)data);
            	data = fis.read();
        	}
        
        	fis.close();    
        }catch(FileNotFoundException e){
            e.printStaceTrace();
        }catch(IOException e){
            e.printStaceTrace();
        }
       
    }
```

> ```
> 体会：使用try-catch-finally处理编译时异常，使得程序在编译时就不再报错，但是运行时仍可能报错。
> 相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现
> ```

```
try-catch-finally中finally的使用
 1.finally是可选的
 2.finally中声明的是一定会被执行的代码。即使catch中又出现异常了，try中有return语句，catch中有return语句等情况。
 3.像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动地回收的，我们需要自己手动的进行资源的释放。此时的资源释放，就需要声明在finally中。
```

```java
    @Test
    public void test2() {
        FileInputStream fis = null;

        try {
            File file = new File("day15/hello1.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while (data != -1){
                System.out.print((char)data);
                data = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
```

> 开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常编写try-catch-finally了。针对于编译时异常，我们说一定要考虑异常的处理。

### 使用throws解决异常

```java
public class ExceptionTest2 {

    public static void main(String[] args) {

        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void method2() throws FileNotFoundException, IOException{
        method1();
    }

    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){ //读到-1说明文件读完
            System.out.println((char)data);
            data = fis.read();
        }

        fis.close();
    }

}
```



```
1."throws + 异常类型"写在方法的声明处。指明此方法执行时，可能会抛出的异常类型。
  一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象。
2.体会：try-catch-finally：真正的将异常给处理掉了
       throws的方式只是将异常抛给了方法的调用者。   并没有真正将异常处理掉
```

### 手动抛出异常

Java异常类对象除在程序执行过程中出现异常时由系统自动生成并

抛出，也可根据需要使用人工创建并抛出。 

- 首先要生成异常类对象，然后通过throw语句实现抛出操作(提交给Java运

行环境)。

> 
>
> ```java
> IOException e = new IOException();
> 
> throw e;
> ```
>
> 

- 可以抛出的异常必须是`Throwable`或其子类的实例。下面的语句在编译时将

会产生语法错误：

> ```java
> throw new String("want to throw");
> ```

### 用户自定义异常类

- 一般地，用户自定义异常类都是RuntimeException的子类。

- 自定义异常类通常需要编写几个重载的构造器。 

- 自定义异常需要提供serialVersionUID

- 自定义的异常通过throw抛出。 

- 自定义异常最重要的是异常类的名字，当异常出现时，可以根据名字判断异常类型。

#### 练习

编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算

两数相除。

对 数 据 类 型 不 一 致 (NumberFormatException) 、 缺 少 命 令 行 参 数

(ArrayIndexOutOfBoundsException、 

除0(ArithmeticException)及输入负数(EcDef 自定义的异常)进行异常处理。 

提示：

(1)在主类(EcmDef)中定义异常方法(ecm)完成两数相除功能。 

(2)在main()方法中使用异常处理语句进行异常处理。 

(3)在程序中，自定义对应输入负数的异常类(EcDef)。 

(4)运行时接受参数 java EcmDef 20 10 //args[0]=“20” args[1]=“10” 

(5)Interger类的static方法parseInt(String s)将s转换成对应的int值。 

如：int a=Interger.parseInt(“314”); 

//a=314;

```java
public class EcmDef {
    public static void main(String[] args) {
        
        try{
            int i = Integer.parseInt(args[0]);
        	int j = Integer.parseInt(args[1]);
        
        	int result = ecm(i,j);
        
        	System.out.println(result);
        }catch(NumberFormatException e){
            System.out.println("数据类型不一致");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch(ArithmeticException e){
            System.out.println("除0");
        }catch(EcDef e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static int ecm(int i,int j){
        if(i < 0 || j < 0){
            throw new EcDef("分子或分母为负数了！");
        }
        return i / j;
    }
}

//自定义异常类
public class EcDef extends Exception {
    static final long serialVersionUID = -31230732189L;
    
    public EcDef() {
        
    }
    
    public EcDef(String msg) {
        super(msg);
    }
}
```

### 总结

![](D:\Image\异常.png)