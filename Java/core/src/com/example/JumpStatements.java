package com.example;

public class JumpStatements {

    public static void main(String[] args) {
        //breakExample();
        continueExample();
    }

    private static void breakExample() {
        System.out.println("Before outer label");
        outer:
        {
            for (int i = 0; i < 3; i++) {
                System.out.print("Итерация " + i + ": ");
                for (int j = 0; j < 100; j++) {
                    if (j == 10) {
                        System.out.println();
                        break outer; // выйти из обоих циклов
                    }
                    System.out.print(j + " ");
                }
                System.out.println("Эта строка никогда не будет выведена");
            }

        }
        System.out.println("After outer label");
    }

    private static void continueExample() {
        System.out.println("Before outer block");
        outer: //label for continue must have loop inside
        for (int i = 0; i < 10; i++) {
            System.out.println("In iteration of i: " + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("In iteration of j: " + j);
                if (j > i) {
                    System.out.println();
                    continue outer;
                }
                //System.out.print(" " + (i * j));
            }
        }
        System.out.println("After outer block");
    }
}
