package test.practice2;

import practice2.CalculationTester;

/**
 * Клас для тестування класу CalculationTester.
 */
public class CalculationTesterTest {

    /**
     * Головний метод для запуску тестів.
     * @param args Аргументи командного рядка
     */
    public static void main(String[] args) {
        testCalculationResult();
    }

    /**
     * Метод для тестування методу testCalculationResult класу CalculationTester.
     */
    public static void testCalculationResult() {
        double expectedResult = 30.0;
        double actualResult = 30.0;
        if (CalculationTester.testCalculationResult(expectedResult, actualResult)) {
            System.out.println("Тест для перевірки коректності результату обчислень пройшов успішно.");
        } else {
            System.out.println("Тест для перевірки коректності результату обчислень не пройшов.");
        }
    }
}

