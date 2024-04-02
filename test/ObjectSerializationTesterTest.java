package test;

import practice2.ObjectSerializationTester;

/**
 * Клас для тестування класу ObjectSerializationTester.
 */
public class ObjectSerializationTesterTest {

    /**
     * Головний метод для запуску тестів.
     * @param args Аргументи командного рядка
     */
    public static void main(String[] args) {
        testSerialization();
    }

    /**
     * Метод для тестування методу testSerialization класу ObjectSerializationTester.
     */
    public static void testSerialization() {
        // Створюємо об'єкт для серіалізації
        Object object = new Object();

        if (ObjectSerializationTester.testSerialization(object)) {
            System.out.println("Тест для перевірки коректності серіалізації та десеріалізації об'єктів пройшов успішно.");
        } else {
            System.out.println("Тест для перевірки коректності серіалізації та десеріалізації об'єктів не пройшов.");
        }
    }
}

