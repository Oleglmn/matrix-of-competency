package com.example.classes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnonymousInnerClassExample {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("\n\n***********Anonymous Inner Class*************");
        //by doing the following you are making an anonymous class which is overriding its parent class methods
        Person man = new Person() {

            @Override
            public void eat() {
                System.out.println("Man is eating.");
            }

            @Override
            public void run() {
                System.out.println("Man is running.");
            }
        };

        IList list = new IList() {
            private int element;

            @Override
            public void add(int a) {
                element = a;
            }

            @Override
            public int get() {
                return element;
            }

            public void newFunc() {
                System.out.println("New func");
            }
        };
        list.add(1);
//        IList.class.getMethod("newFunc").invoke(list); // dont work
        list.getClass().getMethod("newFunc").invoke(list);
        System.out.println("Anonymous Inner Class Get Element: "+list.get());

        //above code is equivalent to
        // class Main.$1 extends Person{
        //        @Override
        //        public void eat() {
        //            System.out.println("Man is eating.");
        //        }
        //
        //        @Override
        //        public void run() {
        //            System.out.println("Man is running.");
        //        }
        //}
        System.out.println("An object of anonymous class is created that is referred as man of Person Type");
        // This anonymous class is added as ClassFromWhichItIsBeingCalled$1 Main.$2, Main$3 and so on.
        man.eat();
        man.run();

        //Overriding only 1 method, the other one will be called from Person's class
        Person monkey = new Person() {
            @Override
            public void eat() {
                System.out.println("monkey is eating.");
            }
        };
        monkey.eat();
        monkey.run();

        //anonymous inner class with method defined inside which
        //does not override anything
        Object o = new Object()
        {
            public int test = 5;
            public void sayHello()
            {
                System.out.println("Hello World");
            }
        };

        //o.sayHello();//Does not work

        try
        {
            Method m = o.getClass().getMethod("sayHello");
            Field f = o.getClass().getField("test");
            System.out.println(f.getInt(o));
            m.invoke(o);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("------------------------------------------------------");
    }
}

interface IList {
    void add(int a);
    int get();
}

abstract class Person {
    public abstract void eat();
    public void run(){
        System.out.println("Person is Running.");
    }
}