package com.epam.courses.JavaFundamentals.MainTasks;

public class MainTask4 {

    public static void main(String[] args){

        System.out.println("4.Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и " +
                "вывести результат на консоль.");

        int sumResult = 0;
        int multiplyResult = 1;

        for (int i = 0; i < args.length; i++)
        {
            sumResult = sumResult + Integer.parseInt(args[i]);

            multiplyResult = multiplyResult * Integer.parseInt(args[i]);

        }
        System.out.println("Сумма = " + sumResult);
        System.out.println("Произведение = " + multiplyResult);

    }

}
