
/*
 * Copyright (c) 2019.
 * Author: Y24
 * Github: https://github.com/y24/designPattern
 */

package cn.org.y24;

public class SingletonPattern {
    private static final SingletonPattern singletonPattern = new SingletonPattern();

    private SingletonPattern() {
    }

    public static SingletonPattern getSingletonPattern() {
        return singletonPattern;
    }

    //The public interface should try to static as possible.
    public static void doSomething() {

    }
}