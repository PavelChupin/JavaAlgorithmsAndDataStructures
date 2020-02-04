package homework.lesson1;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Task2 {
    public static int[] arr = new int[20];

    static {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        Date dateStart = new Date();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                if (max1 <= max2) {
                    max1 = arr[i];
                } else if (max1 > max2) {
                    max2 = arr[i];
                }
            } else if (arr[i] > max2) {
                if (max2 <= max1) {
                    max2 = arr[i];
                } else if (max2 > max1) {
                    max1 = arr[i];
                }
            }
        }
        Date dateEnd = new Date();

        System.out.println("Operation executed " + (dateEnd.getTime() - dateStart.getTime()) + " millsecond.");
        System.out.println("Сложность алгоритма N linear");
        System.out.println("MAX1 = " + max1 + ". MAX2 = " + max2);
    }
}
