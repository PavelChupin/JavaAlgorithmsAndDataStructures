package homework.lesson1;

import java.util.*;

public class Task1 {
    public static int[] arr = new int[10];

    static {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i - 5;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        List<String> integers = null;
        Date dateStart = new Date();
        //Первый вариант когда ранее проверенные чяисла уже не участвуют в сравнении
        integers = getList1();
        Date dateEnd = new Date();
        print(integers, dateStart, dateEnd);

        dateStart = new Date();
        //Второй вариант когда все ранее пройденные числа так же участвуют в сравнении
        integers = getList2();
        dateEnd = new Date();
        print(integers, dateStart, dateEnd);
    }

    private static void print(List<String> integers, Date dateStart, Date dateEnd) {
        System.out.println("Operation executed " + (dateEnd.getTime() - dateStart.getTime()) + " millsecond.");
        System.out.println("Сложность алгоритма cubic");
        integers.forEach((o)->{
            System.out.println(o);
        });
    }

    private static List<String> getList1() {
        List<String> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0){
                        integers.add(arr[i] + " " + arr[j] + " " + arr[k] + " = 0");
                    }
                }
            }
        }
        return integers;
    }

    private static List<String> getList2() {
        List<String> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0){
                        integers.add(arr[i] + " " + arr[j] + " " + arr[k] + " = 0");
                    }
                }
            }
        }
        return integers;
    }
}
