package com.epam.courses.JavaFundamentals.MainTasks;


import java.util.Scanner;

public class MainTask3 {

    public static void main(String[] args){

        System.out.println("3.Вывести заданное количество случайных чисел с переходом и без перехода на новую строку");

        System.out.print("Введите количество случайных чисел: ");
        Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();

        int[] array = new int[N];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = 0 + (int) (Math.random() * 50);
        }

        System.out.println("\tБез перехода на новую строку: ");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "  ");
        }

        System.out.println();
        System.out.println("\tС переходом на новую строку: ");
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }

}
