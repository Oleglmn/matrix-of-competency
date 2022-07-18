package com.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Random;

public class QueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Random rnd = new Random();
        for (int i = 10; i > 0; i--) {
            pq.add(i);
        }
        System.out.println(pq);
        //correct
        for (int i = 0; i < 6; i++) {
            System.out.println("Element of i=" + i + " is " + pq.poll());
        }
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    }
}
