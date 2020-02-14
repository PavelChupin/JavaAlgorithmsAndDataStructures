package homework.lesson3.task3;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Deque<T> {
    private int maxSize;
    private T[] deque;
    private int front;
    private int rear;
    private int items;

    public Deque(int s) {
        maxSize = s;
        deque = (T[]) new Object[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insertRight(T i) {
        if (isFull()){
            throw new RuntimeException("В очереди нет места");
        }
        deque[++rear] = i;
        items++;
    }

    public void insertLeft(T i) {
        if (isFull()){
            throw new RuntimeException("В очереди нет места");
        }

        for (int j = ++rear; j > 0; j--) {
            this.deque[j] = this.deque[j - 1];
        }
        deque[front] = i;
        items++;
    }

    public T removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("В очереди нет элементов");
        }

        T temp = deque[front];

        for (int i = front; i < rear; i++) {
            deque[i] = deque[i + 1];
        }
        deque[rear--] = null;
        items--;
        return temp;
    }

    public T removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("В очереди нет элементов");
        }

        T temp = deque[rear];
        items--;
        deque[rear--] = null;
        return temp;
    }

    public T getFirst() {
        return deque[front];
    }

    public T getLast() {
        return deque[rear];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    @Override
    public String toString() {
        return "Deque{" +
                "deque=" + Arrays.toString(deque) +
                '}';
    }
}
