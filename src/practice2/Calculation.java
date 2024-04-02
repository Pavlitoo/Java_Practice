package practice2;

import java.io.Serializable;

/**
 * Клас, що представляє обчислення і може бути серіалізованим.
 */
public class Calculation implements Serializable {
    private static final long serialVersionUID = 1L; // Ідентифікатор версії для контролю серіалізації

    // Параметри обчислення
    private double parameter1;
    private double parameter2;

    // Результат обчислення
    private double result;

    /**
     * Конструктор класу Calculation.
     * @param parameter1 Параметр 1
     * @param parameter2 Параметр 2
     */
    public Calculation(double parameter1, double parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }

    /**
     * Метод для виконання обчислення.
     * Наприклад, обчислення суми параметрів.
     */
    public void calculate() {
        result = parameter1 + parameter2;
    }

    /**
     * Метод для отримання результату обчислення.
     * @return Результат обчислення
     */
    public double getResult() {
        return result;
    }
}

