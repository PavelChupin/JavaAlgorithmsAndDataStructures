package homework.lesson3.task1;

public class Stack<T> {
    private T[] stack;
    private int top;
    private int maxSize;

    public Stack(int size) {
        this.maxSize = size;
        this.stack = (T[]) new Object[maxSize];
        this.top = -1;

    }

    public void push(T item) {
        this.stack[++this.top] = item;
    }

    public T pop() {
        return this.stack[this.top--];
    }

    public T peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }
}
