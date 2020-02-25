package homework.lesson5;

public class Exp {
    public static long expRecursiy(long num, int s) {
        if (s == 0) {
            return 1;
        } else if (s == 1) {
            return num;
        }
        return expRecursiy(num, --s) * num;

    }

    public static long exp(long num, int s) {
        if (s == 0) {
            return 1;
        } else if (s == 1) {
            return num;
        }

        long res = num;
        for (int i = 1; i < s; i++) {
            res *= num;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.print(expRecursiy(2, 0) + " ");
        System.out.print(expRecursiy(2, 1) + " ");
        System.out.print(expRecursiy(2, 2) + " ");
        System.out.print(expRecursiy(2, 3) + " ");
        System.out.print(expRecursiy(2, 4) + " ");
        System.out.print(expRecursiy(2, 5) + " ");

        System.out.println();
        System.out.print(exp(2, 0) + " ");
        System.out.print(exp(2, 1) + " ");
        System.out.print(exp(2, 2) + " ");
        System.out.print(exp(2, 3) + " ");
        System.out.print(exp(2, 4) + " ");
        System.out.print(exp(2, 5) + " ");
    }

}
