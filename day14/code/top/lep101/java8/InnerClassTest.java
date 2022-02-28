package top.lep101.java8;

public class InnerClassTest {
    public static void main(String[] args) {
        //创建Dog实例（静态的成员内部类）
        Person.Dog dog = new Person.Dog();
        dog.show();
        //创建Bird实例（非静态的成员内部类）
        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.sing();
        bird.display("lep101");
    }
}

class Person{

    String name = "伟培";
    int age;

    public void eat(){
        System.out.println("人：吃饭");
    }

    //静态成员内部类
    static class Dog{
        String name;
        int age;

        public void show(){
            System.out.println("卡拉是条狗");
        }
    }

    //非静态成员内部类
    class Bird{
        String name = "乌鸦";

        public void sing(){
            System.out.println("我是一只小小小小鸟");
            Person.this.eat();
        }

        public void display(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }
    }

    public void method() {
        //局部内部类
        class AA {

        }
    }
    {
        //局部内部类
        class BB {

        }
    }
    public Person(){
        //局部内部类
        class CC {

        }
    }
}