package homework.lesson3.task1;

public class Queue<T> {
    private int maxSize;
    private T[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int s){
        maxSize = s;
        queue = (T[]) new Object[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }
    public void insert(T i){
        if(rear == maxSize-1)
            rear = -1;
        queue[++rear] = i;
        items++;
    }

    public T remove(){
        T temp = queue[front++];
        if(front == maxSize)
            front = 0;
        items--;
        return temp;
    }

    public T peek(){
        return queue[front];
    }
    public boolean isEmpty(){
        return (items==0);
    }

    public boolean isFull(){
        return (items==maxSize);
    }

    public int size(){
        return items;
    }
}
