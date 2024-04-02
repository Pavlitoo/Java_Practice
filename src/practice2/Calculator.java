package practice2;

import java.io.Serializable;

/**
 * Клас, що використовує агрегування для здійснення обчислень за допомогою класу Calculation.
 */
public class Calculator implements Serializable {
    private static final long serialVersionUID = 1L; // Ідентифікатор версії для контролю серіалізації

    // Поле для зберігання обчислення
    private Calculation calculation;

    /**
     * Конструктор класу Calculator.
     * @param calculation Обчислення, яке буде виконуватися
     */
    public Calculator(Calculation calculation) {
        this.calculation = calculation;
    }

    /**
     * Метод для виконання обчислення.
     */
    public void performCalculation() {
        calculation.calculate();
    }

    /**
     * Метод для отримання результату обчислення.
     * @return Результат обчислення
     */
    public double getResult() {
        return calculation.getResult();
    }
}

