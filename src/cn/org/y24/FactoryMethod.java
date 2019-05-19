/*
 * Copyright (c) 2019.
 * Author: Y24
 * Github: https://github.com/y24/designPattern
 */

package cn.org.y24;

import java.lang.reflect.InvocationTargetException;

abstract class AbstractProduct {

    public void RealMethod() {

    }

    public abstract void AbstractMethod();
}

class RealProduct1 extends AbstractProduct {

    @Override
    public void AbstractMethod() {
        System.out.println("Real Product 1");
    }
}

class RealProduct2 extends AbstractProduct {

    @Override
    public void AbstractMethod() {
        System.out.println("Real Product 2");
    }
}

abstract class AbstractFactory {

    /*
     * T can be one of the following types:
     * String
     * Enum
     * Class
     * */
    public abstract <T extends AbstractProduct> T createProduct(Class<T> c);
}

public class FactoryMethod extends AbstractFactory {

    @Override
    public <T extends AbstractProduct> T createProduct(Class<T> c) {
        AbstractProduct product = null;
        try {
            //Note: using the first constructor to get a new instance.
            product = (AbstractProduct) Class.forName(c.getName()).getConstructors()[0].newInstance();
        } catch (InstantiationException e) {
            System.err.println("new InstantiationException occurs!");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("new IllegalAccessException occurs!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("new ClassNotFoundException occurs!");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.err.println("new InvocationTargetException occurs!");
            e.printStackTrace();
        }
        return (T) product;
    }
}
