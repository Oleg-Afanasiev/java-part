package com.academy.lesson12.queue;

public class QueueImpl<T> implements Queue<T> {

    private T[] arr;
    private int pointer = -1;
    private int firstElIndx = 0;
    private T el;

    public QueueImpl(T[] array) {
        this.arr = array;
    }

    public boolean add(T element){
        if(pointer == arr.length - 1){
            System.out.println("Element can't be added. Queue is full.");
            return false;
        }
        else{
            pointer++;
            arr[pointer] = element;
            System.out.println("Element is added successfully");
            return true;
        }
    }

    public T poll() { // достает и удаляет элемент из очереди, который зашел самым первым Если очередь пуста - возвращает null

        if(pointer == -1){
            System.out.println("Queue is empty");
            return null;
        } else {
            el = arr[firstElIndx];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i + 1];
            }
            return el;
        }
    }

    public T remove() /*throws NoSuchElementException*/ {// достает и удаляет элемент из очереди, который зашел самым первым.Если очередь пуста - бросает NoSuchElementException
        if(pointer == -1){
            System.out.println("Queue is empty");
            //throw new NoSuchElementException();
            return null;
        } else {
            el = arr[firstElIndx];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i + 1];
            }
            return el;
        }
    }

    public T peek() {  // выдает первый элемент на очереди, но не удаляет егоЕсли очередь пуста - возвращает null

        if(pointer == -1){
            System.out.println("Queue is empty");
            return null;
        }
        else
            return arr[firstElIndx];
    }

    public T element()/*throws NoSuchElementException*/{

        if(pointer == -1){
            //throw new NoSuchElementException();
            return null;
        }
        else
            return arr[firstElIndx];
    }
}
