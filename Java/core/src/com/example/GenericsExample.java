package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/**
 * PECS - Producer Extends Consumer Super
 */
public class GenericsExample {
    static class A {
        public int num;

        public A() {
        }

        public void print() {
            System.out.println("A");
        }
    }
    static class B extends A {
        public B() {
        }

        @Override
        public void print() {
            System.out.println("B");;
        }
    }
    static class C extends B {
        public C() {
        }

        @Override
        public void print() {
            System.out.println("C");;
        }
    }

    static class MyCollection<T, F> {
        private final Collection<T> collection;

        public MyCollection(Collection<T> collection) {
            this.collection = collection;
        }

        public boolean removeIf(Predicate<? super T> filter) {
            return collection.removeIf(filter);
        }
    }

    static interface Immutable {}

    static class MyString implements Immutable {
        private String str;

        public MyString(String str) {
            this.str = str;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyString myString = (MyString) o;
            return Objects.equals(str, myString.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(str);
        }
    }

    static interface MyImmMap<K extends Immutable, V> extends Map<K, V> {

    }

    static interface StringImmMap<V> extends MyImmMap<MyString, V> {

    }

    static class StringImmMapImpl<V> extends HashMap<MyString,V> implements StringImmMap<V> { }

    public static void main(String[] args) {
        Collection<B> collection = new ArrayList<B>() {{
            add(new B());
        }};

        Predicate<C> predicateC = x -> x.num < 0;
        Predicate<B> predicateB = x -> x.num == 0;
        Predicate<A> predicateA = x -> x.num > 0;
        collection.removeIf(predicateA);
//
////        collection.addAll(Set.of(new A()));
//        collection.addAll(Set.of(new B()));
//        collection.addAll(Set.of(new C()));
//
//        MyCollection<B> myCollection = new MyCollection<B>(collection);
//        myCollection.removeIf(predicateA);

        MyString myString = new MyString("mystr");
        MyImmMap<MyString, Object> map = new StringImmMapImpl<>();
        map.put(myString, new Object());
        System.out.println(map);
    }
}
