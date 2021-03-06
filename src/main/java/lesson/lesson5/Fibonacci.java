package lesson.lesson5;

/*
* F(n) = F(n - 1) + F(n - 2);
* F(0) = 0;
* F(1) = 1;
* Example: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
* */

public class Fibonacci {
    static  long count;

    public static long fibonacciRecursuion(int num){
        count++;
        if (num == 0 ) return 0;
        if (num == 1 ) return 1;


        return fibonacciRecursuion(num - 1) + fibonacciRecursuion(num - 2);
    }

    public static long fibonacci(int num){
        long[] mem = new long[num + 1];
        mem[0] = 0;
        mem[1] = 1;

        for (int i = 2; i <= num ; i++) {
            count++;
            mem[i] = mem[i-1] + mem[i-2];
        }

        return mem[num];
    }

    public static void main(String[] args) {
        count = 0;
        System.out.println(fibonacciRecursuion(30));
        System.out.println(count);

        count = 0;
        System.out.println(fibonacci(30));
        System.out.println(count);
    }

}
