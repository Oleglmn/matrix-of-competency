package com.example;

import java.util.HashMap;

public class StaticAndFinalExample {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Main start");
//        Class<SomeClass> someClassClass = (Class<SomeClass>) StaticAndFinalExample.class.getClassLoader().loadClass("com.example.AnotherClass");
//        Class.forName("com.example.SomeClass");
//        Class.forName("com.example.AnotherClass");
//        System.out.println(new SomeClass());
//        System.out.println(SomeClass.instancePublic);
////        System.out.println(SomeClass.instancePrivate);
//        System.out.println(SomeClass.SomeStaticNestedClass.getInstancePrivate());
//
        SomeClass someClass = new AnotherClass();
        System.out.println(someClass.abacaba);

        new HashMap<>() {{
            put("key", "value");
        }};
        System.out.println("correct");
    }
}

class SomeClass {
//    public final static SomeClass instancePublic = new SomeClass("instance");
//    private static SomeClass instancePrivate = new AnotherClass("instancePrivate1");

    public String abacaba = "SomeClass";

    /**
     * First of all class loading is different than class initialization. For anyone looking for explanation from Java Language Specification, when is static block executed - here it is.
     *
     * The JLS §8.7 says that :
     *
     * A static initializer declared in a class is executed when the class is initialized (§12.4.2).
     *
     * So what does the initialization mean? Let's refer to JLS §12.4.2. This describes detailed initialization procedure. However point JLS §12.4.1 might be more appropriate here. It says that :
     *
     * A class or interface type T will be initialized immediately before the first occurrence of any one of the following:
     * T is a class and an instance of T is created.
     * T is a class and a static method declared by T is invoked.
     * A static field declared by T is assigned.
     * A static field declared by T is used and the field is not a constant variable (§4.12.4).
     * T is a top level class (§7.6), and an assert statement (§14.10) lexically nested within T (§8.1.3) is executed.
     * So to make the static initializer block to be executed automatically, you have to force one of those options to happen.
     * @link{ https://stackoverflow.com/questions/9130461/when-is-the-static-block-of-a-class-executed }
     */
    static {
        System.out.printf("%s static init block\n", SomeClass.class.getName());
    }

    {
        System.out.printf("%s init block\n", SomeClass.class.getName());
    }

    public SomeClass() {
        System.out.printf("%s constructor\n", SomeClass.class.getName());
    }

    public SomeClass(String message) {
        System.out.printf("%s constructor with message: %s\n", SomeClass.class.getName(), message);
    }
//
//    public static final class SomeStaticNestedClass{
//        public static SomeClass getInstancePrivate() {
//            return SomeClass.instancePrivate;
//        }
//    }
}

// Compilation Error!
class AnotherClass extends SomeClass {
//    private static SomeClass instancePrivate = new SomeClass("instancePrivate2");

    public String abacaba = "AnotherClass";

    static {
        int i = 1 / 0;
        System.out.printf("%s static init block\n", AnotherClass.class.getName());
    }

    {
        System.out.printf("%s init block\n", AnotherClass.class.getName());
    }

    public AnotherClass() {
        System.out.printf("%s constructor\n", AnotherClass.class.getName());
    }

    public AnotherClass(String message) {
        System.out.printf("%s constructor with message: %s\n", AnotherClass.class.getName(), message);
    }
}

