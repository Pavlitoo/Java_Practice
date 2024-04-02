package test;

import practice2.BinaryCount;

public class BinaryCountTest {
    
    public static void main(String[] args) {
        testCountFullBytes();
    }

    public static void testCountFullBytes() {
        // Тестування на випадковому числі
        int number = 135; // Вхідне десяткове число
        int expectedFullBytes = 1; // Очікувана кількість повних тетрад
        int fullBytes = BinaryCount.countFullBytes(number);
        if (fullBytes == expectedFullBytes) {
            System.out.println("Тест пройшов успішно: " + fullBytes + " повних тетрад у числа " + number);
        } else {
            System.out.println("Тест не пройшов: " + fullBytes + " повних тетрад замість " + expectedFullBytes);
        }
    }
}

