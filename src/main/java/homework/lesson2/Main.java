package homework.lesson2;

import java.util.Random;

public class Main {
    public static int[] arr = new int[1000000];

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
    }

    public static void add(){

    }

    public static void del(){

    }

    public static int find(int element){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element){
               return i;
            }
        }
        return 0;
    }
}
