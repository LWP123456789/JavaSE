package top.lep101.java1;

/**
 * 面试题： == 和 equals() 区别
 *
 * 一、回顾 == 的使用
 * ==：运算符
 * 1.可以使用在基本数据类型变量和引用数据类型变量中
 * 2.如果比较的基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
 *   如果比较的引用数据类型变量：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
 *
 * 二、equals()方法的使用
 * 1.是一个方法，而非运算符
 * 2.只能使用于引用数据类型
 * 3.Object类中equals()的定义：
 *      public boolean equals(Object obj) {
 *          return (this == obj);
 *      }
 *      说明：Object类中定义的equals()和==的作用是相同的；比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
 * 4.像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是两个引用的地址是否相同，而是比较两个对象的"实体内容"是否相同
 * 5.通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们就需要对Object类中的equals()进行重写。
 *   重写的原则：比较两个对象的实体内容是否相同
 */
public class EqualsTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(j == i);
        System.out.println(i == d);

        char c = 10;
        System.out.println(i == c);


    }
}
