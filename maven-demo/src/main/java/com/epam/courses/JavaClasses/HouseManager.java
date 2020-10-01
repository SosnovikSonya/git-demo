package com.epam.courses.JavaClasses;

import java.util.Scanner;

public class HouseManager {

    private House[] houses;

    public HouseManager(House[] houses)
    {
        this.houses = houses;
    }

    public void SearchByRoomNumbers()
    {
        System.out.println("\tВведите число комнат: ");
        int roomNumbers = checkIntIsPositive();
        int flag = 0;
        for (int i = 0; i < houses.length; i++)
        {
            if(houses[i].getRoomNumbers() == roomNumbers)
            {
                System.out.println(houses[i].toString());
                flag++;
            }

        }
        if(flag == 0)
        {
            System.out.println("\tТаких квартир нет");

        }

    }

    public void SearchByRoomNumbersAndFloor()
    {
        System.out.println("\tВведите число комнат: ");
        int roomNumbers = checkIntIsPositive();

        System.out.println("\tВведите интервал этажей: ");
        System.out.println("\tот: ");
        int floorFrom = checkIntIsPositive();

        System.out.println("\tдо: ");
        int floorTo = checkIntIsPositive();

        int flag = 0;
        for (int i = 0; i < houses.length; i++)
        {
            if(houses[i].getRoomNumbers() == roomNumbers && houses[i].getFloor() >= floorFrom && houses[i].getFloor() <= floorTo)
            {
                System.out.println(houses[i].toString());
                flag++;
            }

        }
        if(flag == 0)
        {
            System.out.println("\tТаких квартир нет");

        }
    }


    public void SearchByArea()
    {
        System.out.println("\tВведите площадь: ");
        int area = checkIntIsPositive();

        int flag = 0;
        for (int i = 0; i < houses.length; i++)
        {
            if(houses[i].getArea() >= area)
            {
                System.out.println(houses[i].toString());
                flag++;
            }

        }
        if(flag == 0)
        {
            System.out.println("\tТаких квартир нет");

        }
    }


    public int checkIntIsPositive()
    {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        Integer number = null;
        while(!flag)
        {
            number = scanner.nextInt();
            if (number >= 1)
            {
                flag = true;
            }
            else
            {
                System.out.println("Некоррекный ввод. Введите еще раз: ");

            }
        }

        return number;
    }
}
