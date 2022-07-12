package com.example;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

interface Closure {
    void apply();
}

public class TryCatchExample {
    public static void main(String[] args) {
        exampleWrapper("example1", TryCatchExample::example1);
        exampleWrapper("example2", TryCatchExample::example2);
        exampleWrapper("example3", TryCatchExample::example3);
        exampleWrapper("example4", TryCatchExample::example4);
        exampleWrapper("example5", 5, TryCatchExample::example5);
        exampleWrapper("example6", 0, TryCatchExample::example5);
        exampleWrapper("example7", -1, TryCatchExample::example5);
    }

    static void exampleWrapper(String name, Closure closure) {
        System.out.println(name);
        try {
            closure.apply();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println();
    }

    static <T> T exampleWrapper(String name, Supplier<? extends T> supplier) {
        System.out.println(name);
        T res = null;
        try {
            res = supplier.get();
            System.out.printf("Result: %s\n", res.toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println();
        return res;
    }

    static <T> void exampleWrapper(String name, T arg, Consumer<? super T> consumer) {
        System.out.println(name);
        try {
            consumer.accept(arg);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println();
    }

    static <T, F> F exampleWrapper(String name, T arg, Function<? super T, ? extends F> function) {
        System.out.println(name);
        F res = null;
        try {
            res = function.apply(arg);
            System.out.printf("Result: %s\n", res.toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println();
        return res;
    }

    static void example1() {
        try {
            System.out.println("try start");
            var list = List.of(1);
            list.set(0, 1);
        } catch (UnsupportedOperationException e) {
            System.out.println("exception processing");
        } finally {
            System.out.println("finally");
        }
    }

    static void example2() {
        try {
            System.out.println("try start");
        } catch (UnsupportedOperationException e) {
            System.out.println("exception processing");
        } finally {
            System.out.println("finally");
        }
    }

    static void example3() {
        try(var res = new Resource()) {
            System.out.println("try start");
            res.read();
            System.out.println("after read");
        } catch (IOException e) {
            System.out.println("exception processing");
        } finally {
            System.out.println("finally");
        }
    }

    static void example4() {
        try {
            System.out.println("try start");
            var list = List.of(1);
            list.set(0, 1);
        } catch (UnsupportedOperationException e) {
            throw exceptionHandling();
        } finally {
            System.out.println("finally");
        }
    }

    private static NullPointerException exceptionHandling() {
        System.out.println("exception processing");
        return new NullPointerException();
    }

    static int example5(int d) {
        var list = List.of(1, 2, 3);
        int c = 0;
        try {
            System.out.println("try start");
            return list.get(d - 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("exception processing");
            c = Integer.MAX_VALUE / d;
            System.out.println("after division");
//            list.get(100);
//            System.out.println("after get");
            return logNum(-c);
        } finally {
            System.out.println("finally");
        }
    }

    static int logNum(int c) {
        System.out.println(c);
        return c;
    }
}

class Resource implements Closeable {

    public void read() throws IOException {
        throw new IOException();
    }

    @Override
    public void close() throws IOException {
        System.out.println("Close call");
    }
}
