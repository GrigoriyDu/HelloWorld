package org.example;

/**
 * Класс CustomContainer представляет собой обобщенный контейнер для хранения элементов.
 * Контейнер автоматически увеличивает свою емкость при добавлении новых элементов, если текущая емкость исчерпана.
 * Контейнер позволяет позволять добавлять, извлекать, удалять элементы
 *
 * @param <T> Тип элементов, хранящихся в контейнере.
 */
public class CustomContainer<T> {
    private Object[] elements;
    private int currentSize;
    private int maxCapacity;
    /**
     * Конструктор по умолчанию, инициализирующий контейнер с начальной емкостью 10 элементов.
     */
    public CustomContainer(){
        maxCapacity = 10;
        elements = new Object[maxCapacity];
        currentSize = 0;
    }
    /**
     * Добавляет элемент в контейнер. Если текущая емкость исчерпана, емкость контейнера увеличивается.
     *
     * @param item Элемент, который нужно добавить в контейнер.
     */
    public void insert(T item) {
        if (currentSize == maxCapacity) {
            expandCapacity();
        }
        elements[currentSize] = item;
        currentSize++;
    }
    /**
     * Увеличивает емкость контейнера в два раза.
     */
    private void expandCapacity() {
        maxCapacity *= 2;
        Object[] newElements = new Object[maxCapacity];
        System.arraycopy(elements, 0, newElements, 0, currentSize);
        elements = newElements;
    }
}
