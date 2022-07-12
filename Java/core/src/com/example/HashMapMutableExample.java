package com.example;

import java.util.HashSet;
import java.util.Objects;

/**
 * Иллюстрация некорректной работы HashSet, если в качестве ключа использован mutable class
 */
public class HashMapMutableExample {

    public static void main(String[] args) {
        final int initialCapacity = 10;
        var set = new HashSet<MutableKey>(initialCapacity);
        var firstElem = new MutableKey(0);
        var secondElem = new MutableKey(1);
        set.add(firstElem);
        set.add(secondElem);
        for (int i = 2; i < initialCapacity; i++) {
            set.add(new MutableKey(i));
        }
        System.out.printf("Contains %d: %b\n", 0, set.contains(new MutableKey(0)));
        firstElem.setNum(1);
        System.out.printf("Contains %d: %b\n", 0, set.contains(new MutableKey(0)));
        firstElem.setNum(0);
        System.out.printf("Contains %d: %b\n", 0, set.contains(new MutableKey(0)));
        set.remove(secondElem);
        System.out.printf("Contains %d: %b\n", 1, set.contains(new MutableKey(1)));
        firstElem.setNum(1);
        System.out.printf("Contains %d: %b\n", 1, set.contains(new MutableKey(1)));
        set.add(firstElem);
        System.out.printf("Contains %d: %b\n", 1, set.contains(new MutableKey(1)));
        set.add(firstElem);
        System.out.printf("Contains %d: %b\n", 0, set.contains(new MutableKey(0)));
    }

    private static class MutableKey {
        private int num;

        public MutableKey(int num) {
            this.num = num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MutableKey cat = (MutableKey) o;
            return Objects.equals(num, cat.num);
        }

        @Override
        public int hashCode() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
}