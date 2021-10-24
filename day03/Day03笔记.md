# Day03笔记

## 算法

判断素数算法(优化后)：

```java
class PrimeNumberTest {
    public static void main(String[] args) {
        
        boolean isFlag = true;
        
        //获取当前时间距离的毫秒数
        long start = System.currentTimeMillis();
        //优化二：对本身是质数的自然数是有效的。
        for(int j = 2; j <= Math.sqrt(i); j++) {
            
            if(i % j == 0){
                isFlag = false;
                break;//优化一：只对本身非素数的自然数是有效的。
            }
            
        }
        
        if(isFlag == true){
            System.out.println(i);
        }
        //重置isFlag
        isFlag = true;
        
    }
    //获取当前时间距离的毫秒数
    long end = System.currentTimeMillis();
    
    System.out.println("所花费的时间: " + （end - start));
}
```

## break和continue

break：结束当前循环，默认跳出包裹此关键字最近的一层循环

continue：结束当次循环

## 数组

概述：

1.数组的理解：数组（Array），是多个相同类型数据按一定顺序排列的集合，并使用一个名字命名，并通过编号的方式对这些数据进行统一管理

2.数据相关的概念：

> 数组名、元素、角标(下标、索引)

3.数组的特点：

1）.数组是有序排列的

2）.数组属于引用数据类型的变量。数组的元素，既可以是基本数据类型，也可以是引用数据类型

3）.创建数组对象会在内存中开辟一整块连续的空间

4）.数据的长度一旦确定，就不能修改

4.数组的分类： 

按照维度：一维数组、二维数组、三维数组、… 

按照元素的数据类型分：基本数据类型元素的数组、引用数据类型元素的数组(即对象数组)

5.一维数组的使用

①一维数组的声明和初始化

②如何调用数组的指定位置的元素

③如何获取数组的长度

④如何遍历数组

⑤数组元素的默认初始化值

⑥数组的内存解析

```java
public class ArrayTest {
    
    public static void main(String[] args){
        
        //1.一维数组的声明和初始化
        int num;//声明
        num = 10;//初始化
        int id = 1001; //声明 + 初始化
        
        int[] ids; //声明
        //1.1静态初始化:数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{1001,1002,1003,1004};
        //1.2动态初始化:数组的初始化和数组元素的赋值操作分开进行
        String[] names = new String[5];
        
        //错误的写法：
        //int[] arr1 = new int[];
        //int[5] arr2 = new int[5];
        //int[] arr3 = new int[3]{1,2,3};
        
        //总结：数组一旦初始化完成，其长度就确定了。
        
        //2.如何调用数组的指定位置的元素:通过角标的方式调用。
        //数组的索引从0开始的，到数组的长度-1结束
        names[0] = "乐培";
        names[1] = "伟培";    
        names[2] = "学友";
        names[3] = "德华";
        names[4] = "子丹";
        //再names[5]就下标越界了
        
        //3.如何获取数组的长度
        //属性：length
        System.out.println(names.length);//5
        System.out.println(ids.length);//4
        
        //4.如何遍历数组
        for(int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }
        
        //5.数组元素的默认初始化值
        int[] arr = new int[4];
        for(int i = 0; i <　arr.length; i++){
            System.out.println(arr[i]);
        }
        
        //6.数组的内存解析
        //栈（stack）：存放局部变量
        //堆（heap）：new出来的结构：对象、数组
        //方法区：有常量池和静态域
    }
    
}
```

![image-20211024112604974](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20211024112604974.png)

二维数组的使用

1.理解：

对于二维数组的理解，我们可以看成是一维数组array1又作为另一个一维数组array2的元素而存在。

其实，从数组底层的运行机制来看，其实没有多维数组

2.二维数组的使用

①二维数组的声明和初始化

②如何调用数组的指定位置的元素

③如何获取数组的长度

④如何遍历数组

⑤数组元素的默认初始化值

⑥数组的内存解析

```java
public class ArrayTest2 {
    public static void main(String[] args) {
        //1.二维数组的声明和初始化
        int[] arr = new int[]{1,2,3};//一维数组
        //也是正确写法：
        int[] arr5 = {1,2,3,4,5};//类型推断
        //静态初始化
        int[][] arr1 = new int[][]{{1,2,3},{4,5},{6,7,8}};
        //动态初始化1
        String[][] arr2 = new String[3][2];//声明一个三行两列的数组
        //动态初始化2
        String[][] arr3 = new String[3][];
        //错误的情况
        //String[][] arr4 = new String[][4];
        
        //正确：
        int[] arr4[] = new int[][]{{1,2,3},{4,5},{6,7,8}};
        
        //2.下标
        
        //3.获取数组的长度
        System.out.println(arr4.length);//3
        System.out.println(arr4[0].length);//3
        System.out.println(arr4[1].length);//2
        
        //4.如何遍历二维数组
        for(int i = 0; i < arr4.length; i++) {
            
            for(int j = 0;j < arr4[i].length; j++){
                System.out.println(arr4[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
```



```java
//数组元素的默认初始化值
public class ArrayTest3 {
    public static void main(String[] args) {
        int[][] arr = new int[4][3];
        System.out.println(arr[0]);//地址值
        System.out.println(arr[0][0]);//0
        
        System.out.println("***************");
        float[][] arr1 = new float[4][3];
        System.out.println(arr1[0]);//地址值;
        System.out.println(arr1[0][0]);//0.0
        
        System.out.println("***************");
        
        String[][] arr2 = new String[4][2];
        System.out.println(arr2[1]);//地址值
        System.out.println(arr2[1][1]);//null
        
        System.out.println("***************");
        String[][] arr3 = new String[4][];
        System.out.println(arr3[1]);//null
        System.out.println(arr3[1][0]);//报错 空指针异常
    }
}
```

杨辉三角

```java
1.第一行有1个元素，第n行有n个元素
2.每一行的第一个元素和最后一个元素都是1
3.从第三行开始，对于非第一个元素和最后一个元素的元素。即：
    yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];

public class YangHuiTest {
    public static void main(String[] args) {
        //1.声明并初始化二维数组
        int[][] yangHui = new int[10][];
        
        //2.给数组的元素赋值
        for(int i = 0; i < yangHui.length; i++) {
            yangHui[i] = new int[i + 1];
            
            //2.1给首末元素赋值
            yangHui[i][0] = yangHui[i][i] = 1;
            //2.2给每行的非首末元素赋值
            if(i > 1){
                for (int j = 1; j < yangHui[i].length-1;j++){
                    yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j];
                }
            }
        }
        
        //3.遍历二维数组
        for(int i = 0; i < yangHui.length; i++) {
            for(int j = 0; j < yangHui[i].length; j++){
                System.out.println(yangHui[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

数组的复制

```java
/*
 * 使用简单数组
 * 拓展：修改题目，实现array2对array1数组的复制
 */
public class ArrayExer3 {
	public static void main(String[] args) {  //alt + /
		int[] array1,array2;
		
		array1 = new int[]{2,3,5,7,11,13,17,19};
		
		//显示array1的内容
		for(int i = 0;i < array1.length;i++){
			System.out.print(array1[i] + "\t");
		}
		
		//数组的复制:
		array2 = new int[array1.length];
		for(int i = 0;i < array2.length;i++){
			array2[i] = array1[i];
		}

		
		//修改array2中的偶索引元素，使其等于索引值(如array[0]=0,array[2]=2)
		for(int i = 0;i < array2.length;i++){
			if(i % 2 == 0){
				array2[i] = i;
			}
			
		}
		System.out.println();
		//打印出array1
		for(int i = 0;i < array1.length;i++){
			System.out.print(array1[i] + "\t");
		}
	}
}

```

数组的反转

```java
public class ArrayTest2 {
    
    public static void main(String[] args) {
        String[] arr = new String[]{"JJ","DD","MM","BB","GG","AA"};
        
        //数组的反转
        //方法一：
        for(int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        
        //方法二：
        for(int i = 0,j = arr.length - 1; i < j; i++,j--) {
            String temp = arr[i];
			arr[i] = arr[i];
            arr[j] = temp;
        }
    } 
    
    //线性查找：
    String dest = "BB";
    
    boolean isFlag = true;
    
    for(int i = 0; i < arr.length; i++){
        
        if(dest.equals(arr[i])){
            System.out.println("找到了指定的元素，位置为：" + i);
            isFlag = false;
            break;
        }
    }
    if(isFlag) {
        System.out.println("很遗憾，没有找到哦！");
    }
	
    //二分法查找：
    //前提：所要查找的数组必须有序。
    int[] arr2 = new int[]{-98,-34,2,34,54,66,79,105,210,333};
    
    int dest1 = -32;
    int head = 0;//初始的首索引
    int end = arr2.length - 1;//初始的末索引
    boolean isFlag1 = true;
    while(head <= end){
        int middle = (head + end)/2;
        
        if(dest1 == arr2[middle]){
            System.out.println("找到了指定的元素，位置为： " + i);
            isFlag1 = false;
            break;
        }else if(arr2[middle] > dest1){
            end = middle - 1;
        }else{
            head = middle + 1;
        }
    }
    
    if(isFlag1){
        System.out.println("没有找到")
    }
}
```

