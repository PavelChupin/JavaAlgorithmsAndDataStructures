package homework.lesson6;

public class Node<T> {
    public T value;
    public Node leftChild;
    public Node rightChild;


    public void display(){
        System.out.println("value: "+ value);
    }

}
