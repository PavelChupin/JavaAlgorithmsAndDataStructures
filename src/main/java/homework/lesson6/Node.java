package homework.lesson6;

public class Node<T> {
    public T value;
    public int level;
    public Node<T> leftChild;
    public Node<T> rightChild;


    public void display(){
        System.out.println("value: "+ value);
    }

}
