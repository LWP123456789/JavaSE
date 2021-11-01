package top.lep101.java;

import java.sql.SQLOutput;

public class Woman extends Person{

    boolean isBeauty;

    public void goShopping(){
        System.out.println("goShopping");
    }

    @Override
    public void eat() {
        System.out.println("eat less");
    }

    @Override
    public void walk() {
        System.out.println("beautifully walk");
    }
}
