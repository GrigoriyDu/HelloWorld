package org.example;

public class CustomContainer<T> {
    private Object[] elements;
    private int currentSize;
    private int maxCapacity;

    public CustomContainer(){
        maxCapacity = 10;
        elements = new Object[maxCapacity];
        currentSize = 0;
    }
}
