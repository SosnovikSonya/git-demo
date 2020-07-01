package com.epam.courses.JavaFundamentals.OptionalTasks;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionalTask1 {

    public static void main(String[] args) {

        System.out.println("Введите числа через пробел: ");
        Scanner scanner = new Scanner(System.in);
        String scString = scanner.nextLine();
        String[] scStrings = scString.split(" ");

        FirstTask(scStrings);
        SecondTask(scStrings);
        ThirdTask(scStrings);
        ForthTask(scStrings);
        FifthTask(scStrings);
        SixthTask(scStrings);
        SeventhTask(scStrings);

    }


    public static void FirstTask(String[] scStrings) {
        System.out.println("1.Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");

        String shortest = FindShortestNumber(scStrings);
        String longest = FindLongestNumber(scStrings);

        System.out.println("\t Самое короткое число: " + shortest + ".   Его длина: " + shortest.length());
        System.out.println("\t Самое длинное число: " + longest + ".   Его длина: " + longest.length());
    }

    public static void SecondTask(String[] scStrings) {
        System.out.println("2.Вывести числа в порядке возрастания (убывания) значений их длины.");

        String[] ascendingNumbers = new String[scStrings.length];
        String[] descendingNumbers = new String[scStrings.length];
        String ascending = "";
        String descending = "";

        String longest = FindLongestNumber(scStrings);

        for (int length = 1; length <= longest.length(); length++) {
            for (int i = 0; i < scStrings.length; i++) {
                if (scStrings[i].length() == length) {
                    ascendingNumbers[i] = scStrings[i];
                    ascending += ascendingNumbers[i] + " ";
                }
            }
        }

        for (int length = longest.length(); length > 0; length--) {
            for (int i = 0; i < scStrings.length; i++) {

                if (scStrings[i].length() == length) {
                    descendingNumbers[i] = scStrings[i];
                    descending += descendingNumbers[i] + " ";
                }
            }
        }

        System.out.println("\t" + ascending);
        System.out.println("\t" + descending);

    }

    public static void ThirdTask(String[] scStrings) {
        System.out.println("3.Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.");

        String longest = FindLongestNumber(scStrings);

        int MiddleLength = (int) Math.round((double) longest.length() / 2);
        System.out.println("\tСредняя длина: " + MiddleLength);

        String[] lessNumbers = new String[scStrings.length];
        String lessNumbersResult = "";
        String[] moreNumbers = new String[scStrings.length];
        String moreNumbersResult = "";


        for (int i = 0; i < scStrings.length; i++) {
            if (scStrings[i].length() <= MiddleLength) {
                lessNumbers[i] = scStrings[i];
                lessNumbersResult += lessNumbers[i] + " ";
            } else {
                moreNumbers[i] = scStrings[i];
                moreNumbersResult += moreNumbers[i] + " ";
            }
        }
        System.out.println("\t  <= " + MiddleLength + " :  " + lessNumbersResult);
        System.out.println("\t  >  " + MiddleLength + " :  " + moreNumbersResult);

    }

    public static void ForthTask(String[] scStrings) {
        System.out.println("4.Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.");

        int flag = CountUniqueNumberSymbols(scStrings[0]);
        int index = 0;
        for (int i = 1; i < scStrings.length; i++)
        {
            if(CountUniqueNumberSymbols(scStrings[i]) < flag)
            {
                flag = CountUniqueNumberSymbols(scStrings[i]);
                index = i;
            }
        }
        System.out.println("\t" + scStrings[index]);


    }

    public static void FifthTask(String[] scStrings) {
        System.out.println("5.Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.");

        int onlyEvenResult = 0;
        int evenEqualOddResult = 0;

        for (int i = 0; i < scStrings.length; i++) {
            if (CountEvenNumbers(scStrings[i]) == scStrings[i].length()) {
                onlyEvenResult++;
            }

            if (CountEvenNumbers(scStrings[i]) == CountOddNumbers(scStrings[i])) {
                evenEqualOddResult++;
            }
        }

        System.out.println("\tТолько с четными цифрами: " + onlyEvenResult + " чисел");
        System.out.println("\tС равным количеством четных и нечетных цифр: " + evenEqualOddResult + " чисел");


    }

    public static void SixthTask(String[] scStrings) {
        System.out.println("6.Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.");

        int flag = 0;

        for (int i = 0; i < scStrings.length; i++)
        {
            if (isNumberSymbolsInAsc(scStrings[i]))
            {
                flag = i;
                break;
            }
        }

        if(flag == 0)
        {
            System.out.println("\tТакого числа нет");
        }
        else
        {
            System.out.println("\t" + scStrings[flag]);
        }
    }

    public static void SeventhTask(String[] scStrings) {
        System.out.println("7.Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.");

        int flag = 0;

        for (int i = 0; i < scStrings.length; i++)
        {
            if (CountUniqueNumberSymbols(scStrings[i]) == scStrings[i].length())
            {
                System.out.println("\t" + scStrings[i]);
                flag = 1;
                break;
            }
        }

        if(flag == 0)
        {
            System.out.println("\tТакого числа нет");
        }
    }



    public static String FindLongestNumber(String[] scStrings) {
        String longest = scStrings[0];

        for (int i = 1; i < scStrings.length; i++) {
            if (longest.length() < scStrings[i].length()) {
                longest = scStrings[i];
            }
        }
        return longest;
    }

    public static String FindShortestNumber(String[] scStrings) {
        String shortest = scStrings[0];

        for (int i = 1; i < scStrings.length; i++) {
            if (shortest.length() > scStrings[i].length()) {
                shortest = scStrings[i];
            }
        }
        return shortest;
    }

    //считает количество четных цифр в числе
    public static int CountEvenNumbers(String number) {
        char[] numberAsCharArray = number.toCharArray();
        int result = 0;

        for (int i = 0; i < numberAsCharArray.length; i++) {
            if (Character.getNumericValue(numberAsCharArray[i]) % 2 == 0) {
                result++;
            }
        }

        return result;
    }

    //считает количество нечетных цифр в числе
    public static int CountOddNumbers(String number) {
        char[] numberAsCharArray = number.toCharArray();
        int result = 0;

        for (int i = 0; i < numberAsCharArray.length; i++) {
            if (Character.getNumericValue(numberAsCharArray[i]) % 2 != 0) {
                result++;
            }
        }

        return result;
    }

    public static boolean isNumberSymbolsInAsc(String number) {

        char[] numberAsCharArray = number.toCharArray();
        for (int i = 0; i < numberAsCharArray.length - 1; i++) {
            if (Character.getNumericValue(numberAsCharArray[i]) <= Character.getNumericValue(numberAsCharArray[i + 1]) &&
                    Character.getNumericValue(numberAsCharArray[numberAsCharArray.length - 1]) >= Character.getNumericValue(numberAsCharArray[numberAsCharArray.length - 2])) {
                return true;
            }
        }

        return false;
    }

    public static int CountUniqueNumberSymbols (String number) {

        char[] numberAsCharArray = number.toCharArray();
        ArrayList<Integer> numberAsArrayList = new ArrayList<>();
        ArrayList<Integer> asd = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < 10; i++) {
            asd.add(i);
        }

        for (int i = 0; i < numberAsCharArray.length; i++) {
            numberAsArrayList.add(Character.getNumericValue(numberAsCharArray[i]));
        }
        for (int i = 0; i < numberAsArrayList.size(); i++) {
            for (int j = 0; j < asd.size(); j++) {
                if(numberAsArrayList.get(i) == asd.get(j))
                {
                    result++;
                    asd.remove(j);
                }
            }
        }

        return result;
    }
}
