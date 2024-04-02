package practice2;

/**
 * Клас для тестування коректності результатів обчислень.
 */
public class CalculationTester {

    /**
     * Метод для перевірки правильності результату обчислень.
     * @param result Очікуваний результат
     * @param actual Фактичний результат
     * @return true, якщо результати співпадають; false, якщо ні
     */
    public static boolean testCalculationResult(double result, double actual) {
        return result == actual;
    }
}

