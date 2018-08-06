package com.academy.lesson12;

public class StackImpl<T> implements Stack<T> {

    private T[] array;
    private int pointer = -1;

    public StackImpl(T[] array) {
        this.array = array;
    }

    @Override
    public void push(T element) throws FullStackException {
        if (pointer == array.length-1)
            throw new FullStackException("To large pointer: " + pointer);

        // pointer++;
        array[++pointer] = element;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (pointer == -1)
            throw new EmptyStackException();

        return array[pointer--];
    }

    @Override
    public T peek() throws EmptyStackException {
        if (pointer == -1)
            throw new EmptyStackException();

        return array[pointer];
    }
}
