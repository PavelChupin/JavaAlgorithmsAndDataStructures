package homework.lesson2;

import java.util.Random;

public class Array {
    public static final int SIZE = 9;
    public static int[] arr = new int[SIZE];

    public static void main(String[] args) {
        //Генерируем массив
        generateMass();
        printArr();

        //Добавляем элемент
        add(3,5);
        printArr();

        //Удаляем элемент
        del(4);
        printArr();

        //Поиск элемента
        System.out.println(find(3));
    }

    private static void generateMass() {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
    }

    public static void add(int index, int element) {
        int[] arrTemp = new int[arr.length + 1];
        System.arraycopy(arr, 0, arrTemp, 0, index);
        arrTemp[index] = element;
        System.arraycopy(arr, index, arrTemp, index + 1, arr.length - index);
        arr = arrTemp;
    }

    public static void del(int index) {
        int[] arrTemp = new int[arr.length - 1];
        System.arraycopy(arr, 0, arrTemp, 0, index - 1);
        System.arraycopy(arr, index, arrTemp, index - 1, arr.length - index);
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
