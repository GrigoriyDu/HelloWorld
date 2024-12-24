package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        CustomContainer<Integer> customContainer = new CustomContainer<>();
        customContainer.insert(10);
        System.out.println(customContainer.retrieve(0));
    }
}
