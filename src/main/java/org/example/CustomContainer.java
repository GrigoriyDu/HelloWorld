package org.example;

/**
 * Класс CustomContainer представляет собой обобщенный контейнер для хранения элементов.
 * Контейнер автоматически увеличивает свою емкость при добавлении новых элементов, если текущая емкость исчерпана.
 * Контейнер позволяет позволять добавлять, извлекать по индексу, удалять элементы
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

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index Индекс элемента, который нужно получить.
     * @return Элемент по указанному индексу.
     * @throws IndexOutOfBoundsException Если индекс вне допустимого диапазона.
     */
    @SuppressWarnings("unchecked")
    public T retrieve(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        return (T) elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index Индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException Если индекс вне допустимого диапазона.
     */
    public void delete(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        for (int i = index; i < currentSize - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[currentSize - 1] = null;
        currentSize--;
    }

    /**
     * Возвращает текущий размер контейнера (количество элементов в контейнере).
     *
     * @return Текущий размер контейнера.
     */
    public int getSize() {
        return currentSize;
    }

    /**
     * Отображает все элементы контейнера в консоли.
     */
    public void displayElements() {
        System.out.print("Элементы контейнера: ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
