package homework.lesson3.task2;

import homework.lesson3.task1.Queue;
import homework.lesson3.task1.Stack;

import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        Stack<Character> stac = new Stack<>(100);
        Queue<Character> qu = new Queue<>(100);
        int c;
        StringBuffer sb = new StringBuffer();
        String s = "";
        while ((c = in.read()) > 0 && !((char) c == '\n')) {
            //1-й вариант Stack
            if (stac.isFull()){
                throw new StackOverflowError();
            }
            stac.push((char) c);
            //2-й вариант
            sb.append((char) c);
            //3-й вариант
            s += (char) c;

            //4-й вариант очередь
            qu.insert((char) c);
        }

        System.out.print("Вариант 1 через стек: ");
        while (!stac.isEmpty()) {
            System.out.print(stac.pop());
        }
        System.out.println();

        //Вариант 2
        System.out.println("Вариант 2 через StringBuffer: " +  sb.reverse());

        //Вариант 3
        char[] arr = s.toCharArray();
        System.out.print("Вариант 3 через обратный цикл: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
        System.out.println();

        //Вариант 4
        String t = "";
        System.out.print("Вариант 4 через очередь: ");
        Character[] ch = new Character[qu.size()];
        for (int i = qu.size() - 1; i >= 0 ; i--) {
            ch[i] = qu.remove();
        }
        for (Character c1 : ch) {
            System.out.print(c1);
        }
        System.out.println();

        in.close();
    }

}
