package homework.lesson2;

import java.util.Random;

public class Array {
    public static final int SIZE = 10;
    public static int[] arr = new int[SIZE];

    public static void main(String[] args) {
        //Генерируем массив
        generateMass();
        printArr();

        //Добавляем элемент
        add(5);
        printArr();

        //Удаляем элемент
        del(4);
        printArr();

        //Поиск элемента
        System.out.println(find(arr.length/2));
    }

    private static void generateMass() {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
    }

    public static void add(int element) {
        int[] arrTemp = new int[arr.length + 1];
        System.arraycopy(arr, 0, arrTemp, 0, arr.length);
        arrTemp[arr.length] = element;
        arr = arrTemp;
    }

    public static void del(int index) {
        int[] arrTemp = new int[arr.length - 1];
        for (int i = 0; i < arrTemp.length; i++) {
            if (i >= index) {
                arrTemp[i] = arr[i + 1];
            } else {
                arrTemp[i] = arr[i];
            }
        }
        arr = arrTemp;
    }


    public static int find(int index) {
        return arr[index];
    }

    public static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
