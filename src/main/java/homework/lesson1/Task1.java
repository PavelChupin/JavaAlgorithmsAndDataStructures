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
        long dateStart = System.currentTimeMillis();
        //Первый вариант когда ранее проверенные чяисла уже не участвуют в сравнении
        integers = getList1();
        long dateEnd = System.currentTimeMillis();
        print(integers, dateEnd - dateStart);

        dateStart = System.currentTimeMillis();
        //Второй вариант когда все ранее пройденные числа так же участвуют в сравнении
        integers = getList2();
        dateEnd = System.currentTimeMillis();
        print(integers, dateEnd - dateStart);
    }

    private static void print(List<String> integers, long deltaTime) {
        System.out.println("Operation executed " + deltaTime + " millsecond.");
        System.out.println("Сложность алгоритма cubic");
        integers.forEach(System.out::println);
    }

    private static List<String> getList1() {
        List<String> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
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
                if (j == i){continue;}
                for (int k = 0; k < arr.length; k++) {
                    if (k == i || k == j){continue;}
                    if (arr[i] + arr[j] + arr[k] == 0){
                        integers.add(arr[i] + " " + arr[j] + " " + arr[k] + " = 0");
                    }
                }
            }
        }
        return integers;
    }
}
