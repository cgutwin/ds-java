package ca.cgutwin.datastructures.stack;

import java.util.NoSuchElementException;
import java.util.Vector;

public class VectorStack<T> implements Stack<T> {
    private Vector<T> stack;

    public VectorStack() {
        stack = new Vector<>();
    }

    @Override
    public void push(T element) {
        stack.add(element);
    }

    @Override
    public T pop() {
        if (stack.isEmpty()) throw new NoSuchElementException("Stack is empty.");
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (stack.isEmpty()) throw new NoSuchElementException("Stack is empty.");
        return stack.lastElement();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    @Override
    public void clear() {
        stack = new Vector<>();
    }
}
