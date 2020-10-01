package com.epam.courses.JavaClasses;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        House[] houses = new House[5];

        houses[0] = new House(1, 56, (float) 72.5, 3, 3, "Волоха", "кирпичное", 7);
        houses[1] = new House(2, 111, (float) 55.0, 1, 2, "Либкнехта", "панельное", (float) 15.5);
        houses[2] = new House(3, 12, (float) 62.5, 7, 2, "Независимости", "панельное", 8);
        houses[3] = new House(4, 46, (float) 92.5, 12, 4, "Дзержинского", "кирпичное", (float) 10.5);
        houses[4] = new House(5, 29, (float) 56.0, 9, 3, "Волоха", "кирпичное", 10);

        HouseManager houseManager = new HouseManager(houses);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit)
        {
            System.out.println("\n1. Вывести список квартир, имеющих заданное число комнат");
            System.out.println("2. Вывести список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке");
            System.out.println("3. Вывести список квартир, имеющих площадь, превосходящую заданную");
            System.out.println("4. Выход");

            boolean flag = false;
            Integer choice = 1;
            while(!flag)
            {
                System.out.println("\tВыберите действие: ");
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4)
                {

                    flag = true;
                }
                else {
                    System.out.println("\tНекоррекный ввод");
                }
            }

            switch (choice)
            {
                case 1:
                    houseManager.SearchByRoomNumbers();
                    break;

                case 2:
                    houseManager.SearchByRoomNumbersAndFloor();
                    break;

                case 3:
                    houseManager.SearchByArea();
                    break;

                case 4:
                    exit = true;
                    break;

            }
        }



    }
}
