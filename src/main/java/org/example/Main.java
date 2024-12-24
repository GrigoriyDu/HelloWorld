package org.example;

/**
 * Класс MainClass демонстрирует использование класса CustomContainer.
 */
public class Main {
    public static void main(String[] args) {
        // Создание экземпляра контейнера
        CustomContainer<Integer> customContainer = new CustomContainer<>();
        // Добавление элементов в контейнер
        customContainer.insert(111);
        customContainer.insert(666);
        customContainer.insert(1234);
        // Отображение текущего размера контейнера
        System.out.println("Размер контейнера: " + customContainer.getSize());
        // Отображение всех элементов контейнера
        customContainer.displayElements();
        // Получение элемента по индексу
        System.out.println("Элемент по индексу 1: " + customContainer.retrieve(1));
        // Удаление элемента по индексу
        System.out.println("--------------------------");
        customContainer.delete(1);
        // Отображение всех элементов контейнера после удаления
        customContainer.displayElements();
        // Отображение текущего размера контейнера после удаления
        System.out.println("Размер контейнера после удаления: " + customContainer.getSize());
        // Получение элемента по индексу после удаления
        System.out.println("Элемент по индексу 1 после удаления: " + customContainer.retrieve(1));
    }
}