package homework.lesson3.task1;

public class Stack<T> {
    private T[] stack;
    private int top;

    public Stack(int size) {
        this.stack = (T[]) new Object[size];
        this.top = 0;
    }

    public void push(T item) {
        stack[top++] = item;
    }

    public T pop() {
        return stack[--top];
    }

    public boolean isEmty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == stack.length;
    }
}
