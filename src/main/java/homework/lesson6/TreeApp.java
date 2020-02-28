package homework.lesson6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeApp {
    public static void main(String[] args) throws IOException {

        System.out.println(Math.pow(2,6));
        int value;
        List<Tree<Integer>> trees = new ArrayList<>();
        int countMaxElement = (int) Math.pow(2,6);
        for (int i = 0; i < 20; i++) {
            Tree<Integer> tree = new Tree<>();

            for (int j = 0; j < countMaxElement; j++) {
                Random r = new Random();
                int temp = r.nextInt(100);
                tree.insert(temp);
                //Проверяем добавился элемент на глубину 7 - го уровня. Если добавился удалим его, 6 уровней были заполнены.
                if (isCheckLevel(tree,temp)){
                    tree.delete(temp);
                    break;
                }
            }
            trees.add(tree);
            //tree.displayTree();
        }
    }

    private static boolean isCheckLevel(Tree<Integer> tree, int temp) {
        //Смотрим сколько уровней от добавленного элеманта до головы дерева
        return tree.find(temp).level >= 7;
    }
}

