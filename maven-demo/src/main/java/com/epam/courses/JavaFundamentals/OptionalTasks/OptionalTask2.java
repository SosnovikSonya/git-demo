package com.epam.courses.JavaFundamentals.OptionalTasks;

import java.util.*;

public class OptionalTask2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Введите N - размерность матрицы: ");
        String nAsString = scanner.nextLine();
        int N = Integer.parseInt(nAsString);

        System.out.println("Введите M - интервал значений матрицы: ");
        String mAsString = scanner.nextLine();
        int M = Integer.parseInt(mAsString);

        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                array[i][j] = (int) (Math.random()*2*M - M);
            }
        }


        System.out.println("\tМатрица: \n");

        PrintArray(array);

        System.out.println();

        FirstTask(N,array);
        SecondTask(array);
        ThirdTask(array);
        ForthTask(N, array);


    }

    public static void FirstTask(int N, int[][] array)
    {
        System.out.println("1.Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).");

        boolean flag = true;
        int k = 0;
        while(flag)
        {
            System.out.println("\tВведите k - номер строки (столбца): ");
            k = Integer.parseInt(scanner.nextLine());

            if (k <= 1 || k > N)
            {
                System.out.println("\tВ матрице нет такой строки (столбца)");
            }
            else
            {
                flag = false;
            }
        }

        int[] row = new int[N];
        int[][] rowSortArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rowSortArray[i][j] = array[i][j];
            }
        }

        for (int j = 0; j < N; j++)
        {
            row[j] = rowSortArray[k-1][j];
        }
        Arrays.sort(row);
        for (int j = 0; j < N; j++)
        {
            rowSortArray[k-1][j] = row[j];
        }

        System.out.println("\tВ порядке возрастания k строки: ");
        PrintArray(rowSortArray);


        int[] column = new int[N];
        int[][] columnSortArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                columnSortArray[i][j] = array[i][j];
            }
        }

        for (int i = 0; i < N; i++)
        {
            column[i] = columnSortArray[i][k-1];
        }
        Arrays.sort(column);
        for (int i = 0; i < N; i++)
        {
            columnSortArray[i][k-1] = column[i];
        }

        System.out.println("\tВ порядке возрастания k столбца: ");
        PrintArray(columnSortArray);

    }

    public static void SecondTask(int[][] array)
    {
        System.out.println("2.Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.");

        int result = 0;
        int flag = 1;
        int[] asd = new int[array.length*array.length];
        int index = 0;

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                asd[index] = array[i][j];
                index++;
            }
        }

        for (int i = 1; i < asd.length; i++)
        {
            if(asd[i] >= asd[i-1])
            {
                flag++;
            }
            else
            {
                if(flag > result) result = flag;
                flag = 1;
            }
        }
        System.out.println("\tНаибольшее число возрастающих элементов: " + result);

        result = 0;
        flag = 1;
        for (int i = 1; i < asd.length; i++)
        {
            if(asd[i] <= asd[i-1])
            {
                flag++;
            }
            else
            {
                if(flag > result) result = flag;
                flag = 1;
            }
        }
        System.out.println("\tНаибольшее число убывающих элементов: " + result);

    }

    public static void ThirdTask(int[][] array)
    {
        System.out.println("3.Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки");

        int result = 0;
        for (int i = 0; i < array.length; i++)
        {
            result = result + GetSum(array[i]);
        }

        System.out.println("\tСумма: " + result);

    }

    public static void ForthTask(int N, int[][] array)
    {
        System.out.println("4.Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие");

        int maxElement = 0;
        ArrayList<Integer> rowsToDelete = new ArrayList<>();
        ArrayList<Integer> columnsToDelete = new ArrayList<>();

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (array[i][j] >= maxElement)
                    maxElement = array[i][j];
            }
        }

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (array[i][j] == maxElement)
                {
                    rowsToDelete.add(i);
                    columnsToDelete.add(j);
                }
            }
        }
        System.out.println("\tМаксимальный элемент: " + maxElement);


        PrintArray(DeleteColumns(columnsToDelete, DeleteRow(rowsToDelete, array)));
    }



    public static void PrintArray(int[][] array)
    {

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[0].length; j++)
            {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] DeleteRow(ArrayList<Integer> rowsToDelete, int[][] array)
    {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(rowsToDelete);
        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);

        int[][] newArray = new int[array.length - listWithoutDuplicates.size()][];
        int index = 0;


        for (int i = 0; i < array.length; i++)
        {
            if(!listWithoutDuplicates.contains(i))
            {
                newArray[index] = array[i];
                index++;
            }
        }
        return newArray;
    }

    public static int[][] DeleteColumns(ArrayList<Integer> columnsToDelete, int[][] array)
    {

        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(columnsToDelete);
        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);

        int[][] newArray = new int[array.length][array[0].length - listWithoutDuplicates.size()];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            index = 0;
            for (int j = 0; j < array[0].length; j++) {
                if (!listWithoutDuplicates.contains(j)) {
                    newArray[i][index] = array[i][j];
                    index++;
                }
            }
        }

        return newArray;
    }

    public static int GetSum(int[] array)
    {

        int result = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        int flag = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] > 0 && flag == 0)
            {
                firstIndex = i;
                flag = 1;
                i++;
            }

            if(array[i] > 0 && flag == 1)
            {
                secondIndex = i;
                flag = 2;
            }
        }

        for (int i = 0; i < array.length; i++)
        {
            if(i > firstIndex && i < secondIndex )
            {
                result = result + array[i];
            }
        }
        return result;
    }

}
