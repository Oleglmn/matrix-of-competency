package com.example;

import java.util.HashMap;

class Recursion {
    private static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fib(1500));
    }

    public static int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n <= 1) return n;
        int res = fib(n - 2) + fib(n - 1);
        cache.put(n, res);
        return res;
    }
}
