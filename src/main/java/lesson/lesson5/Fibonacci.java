package lesson.lesson5;

/*
* F(n) = F(n - 1) + F(n - 2);
* F(0) = 0;
* F(1) = 1;
* Example: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
* */

public class Fibonacci {
    public static int fibonacciRecursuion(int num){
        if (num == 0 ) return 0;
        if (num == 1 ) return 1;


        return fibonacciRecursuion(num - 1) + fibonacciRecursuion(num - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciRecursuion(11));
    }

}
