package top.lep101.java;

public class Man extends Person{

    boolean isSmoking;
    int id = 1002;

    @Override
    public void walk() {
        System.out.println("handsome walking");
    }

    @Override
    public void eat() {
        System.out.println("eat more");
    }

    public void earnMoney(){
        System.out.println("earning Money");
    }

    public void show() {
        System.out.println(this.id +" "+ super.id);
    }

}
