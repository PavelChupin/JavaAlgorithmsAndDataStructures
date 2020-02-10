package homework.lesson2;

import java.util.Arrays;
import java.util.Random;

public class Array {
    public static final int SIZE = 50000;
    public static int[] arr = new int[SIZE];

    public static void main(String[] args) {
        //Генерируем массив
        generateMass();
        printArr();

        //Добавляем элемент
        add(6, 5);
        printArr();

        //Удаляем элемент
        del(4);
        printArr();

        //Поиск элемента
        System.out.println(find(3));
        System.out.println();

        //Пузырек
        generateMass();
        printArr();
        long timeStart = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println("BubbleSort " + (System.currentTimeMillis() - timeStart) + " millisecond");
        printArr();
        System.out.println();

        //Выбором
        generateMass();
        printArr();
        timeStart = System.currentTimeMillis();
        selectionSort(arr);
        System.out.println("SelectionSort " + (System.currentTimeMillis() - timeStart) + " millisecond");
        printArr();
        System.out.println();

        //Вставками
        generateMass();
        printArr();
        timeStart = System.currentTimeMillis();
        insertionSort(arr);
        System.out.println("InsertionSort " + (System.currentTimeMillis() - timeStart) + " millisecond");
        printArr();
        System.out.println();

        //Слиянием
        generateMass();
        printArr();
        timeStart = System.currentTimeMillis();
        mergeSort(arr);
        System.out.println("MergeSort " + (System.currentTimeMillis() - timeStart) + " millisecond");
        printArr();
        System.out.println();

        //Непомню название, но очень часто использую. Реализовываю для сравнения времени исполнения
        generateMass();
        printArr();
        timeStart = System.currentTimeMillis();
        sortOther(arr);
        System.out.println("SortOther " + (System.currentTimeMillis() - timeStart) + " millisecond");
        printArr();
        System.out.println();
    }

    private static void sortOther(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
        }
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
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIx]) {
                    minIx = j;
                }
            }
            swap(arr,i, minIx);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }

    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSortInt(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSortInt(int[] arr, int[] tmp, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSortInt(arr, tmp, lo, mid);
        mergeSortInt(arr, tmp, mid + 1, hi);
        merge(arr, tmp, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] tmp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            tmp[k] = arr[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = tmp[j++];
            } else if (j > hi) {
                arr[k] = tmp[i++];
            }else if (tmp[j] < tmp[i]){
                arr[k] = tmp[j++];
            }else {
                arr[k] = tmp[i++];
            }


        }
    }
}
