package com.keith.handleobject;

/**
 * Created by Keith on 2015/10/5.
 */
public class Singleton {
    public static void main (String args[]) {

    }
}

//Singleton with public final field
class SingletonOld1 {
    public static final SingletonOld1 INSTANCE= new SingletonOld1();
    private SingletonOld1() {}
}

//Singleton with static factory
/*
    advantage
    1.easy to change
    2.generic
 */
class SingletonOld2 {
    private static final SingletonOld2 INSTANCE = new SingletonOld2();
    private SingletonOld2 () {}
    private static SingletonOld2 getInstance () {
        return INSTANCE;
    }
}

enum SingletonEnum {
    INSTANCE;
}
