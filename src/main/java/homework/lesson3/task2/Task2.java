package homework.lesson3.task2;

import homework.lesson3.task1.Stack;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        Stack<Character> stac = new Stack<>(100);
        int c;
        StringBuffer sb = new StringBuffer();
        String s = "";
        while ((c = in.read()) > 0 && !((char) c == '\n')) {
            //1-й вариант
            stac.push((char) c);
            //2-й вариант
            sb.append((char) c);
            //3-й вариант
            s += (char) c;
        }

        while (!stac.isEmty()) {
            System.out.print(stac.pop());
        }
        System.out.println();

        //Вариант 2
        System.out.println(sb.reverse());

        //Вариант 3
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
        System.out.println();
        in.close();
    }

}
