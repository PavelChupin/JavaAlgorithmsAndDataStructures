package lesson.lesson5;


public class Factorial {

    public static long factorialRecursive(int num) {
        if (num == 0) {
            return 1;
        }
        return factorialRecursive(num - 1) * num;
    }

    public static long factorialLoop(int num) {
        if (num == 0) {
            return 1;
        }

        long res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(factorialRecursive(2));
        System.out.println(factorialLoop(2));
    }
}
