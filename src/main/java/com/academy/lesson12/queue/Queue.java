package com.academy.lesson12.queue;

public interface Queue<T> {
    boolean add(T element);
    T poll(); // достает и удаляет элемент из очереди, который зашел самым первым Если очередь пуста - возвращает null
    T remove();// достает и удаляет элемент из очереди, который зашел самым первым.Если очередь пуста - бросает NoSuchElementException
    T peek();  // выдает первый элемент на очереди, но не удаляет егоЕсли очередь пуста - возвращает null
    T element();  // выдает первый элемент на очереди, но не удаляет его.Если очередь пуста - бросает NoSuchElementException
}
