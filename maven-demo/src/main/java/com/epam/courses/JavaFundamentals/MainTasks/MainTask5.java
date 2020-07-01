package com.epam.courses.JavaFundamentals.MainTasks;

import java.util.Scanner;

public class MainTask5 {

    public static void main(String[] args){

        System.out.println("5.Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. " +
                "Осуществить проверку корректности ввода чисел.");

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String[] monthNames = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" };
        while(!exit)
        {
            System.out.print("Введите число от 1 до 12: ");
            Integer number = scanner.nextInt();
            if (number instanceof Integer && number >= 1 && number <= 12) {
                for (int i = 1; i < monthNames.length; i++) {
                    if (number == i)
                        System.out.println(monthNames[i - 1]);
                }
                exit = true;
            } else {
                System.out.println("Некоррекный ввод");
            }
        }


    }
}
