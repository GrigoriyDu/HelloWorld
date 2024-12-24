package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CustomContainerTest {

    private CustomContainer<Integer> customContainer;

    @BeforeEach
    void setUp() {
        customContainer = new CustomContainer<>();
    }

    @Test
    void insert() {
        customContainer.insert(10);
        customContainer.insert(20);
        customContainer.insert(30);

        assertEquals(3, customContainer.getSize());
        assertEquals(10, customContainer.retrieve(0));
        assertEquals(20, customContainer.retrieve(1));
        assertEquals(30, customContainer.retrieve(2));
    }

    @Test
    void retrieve() {
        customContainer.insert(10);
        customContainer.insert(20);
        customContainer.insert(30);

        assertEquals(10, customContainer.retrieve(0));
        assertEquals(20, customContainer.retrieve(1));
        assertEquals(30, customContainer.retrieve(2));

        assertThrows(IndexOutOfBoundsException.class, () -> customContainer.retrieve(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customContainer.retrieve(-1));
    }

    @Test
    void delete() {
        customContainer.insert(10);
        customContainer.insert(20);
        customContainer.insert(30);

        customContainer.delete(1);

        assertEquals(2, customContainer.getSize());
        assertEquals(10, customContainer.retrieve(0));
        assertEquals(30, customContainer.retrieve(1));

        assertThrows(IndexOutOfBoundsException.class, () -> customContainer.delete(2));
        assertThrows(IndexOutOfBoundsException.class, () -> customContainer.delete(-1));
    }

    @Test
    void getSize() {
        assertEquals(0, customContainer.getSize());

        customContainer.insert(10);
        assertEquals(1, customContainer.getSize());

        customContainer.insert(20);
        assertEquals(2, customContainer.getSize());

        customContainer.delete(0);
        assertEquals(1, customContainer.getSize());
    }

    @Test
    void displayElements() {
        customContainer.insert(10);
        customContainer.insert(20);
        customContainer.insert(30);

        // Перехват консольного вывода, чтобы убедиться, что элементы печатаются правильно
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        customContainer.displayElements();

        // Проверка вывода
        assertEquals("Элементы контейнера: 10 20 30 \r\n", outContent.toString(), "Вывод должен содержать все элементы");

        // Восстановление стандартного вывода
        System.setOut(System.out);
    }
}