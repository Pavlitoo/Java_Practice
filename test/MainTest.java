package test;

import practice2.Calculation;
import practice2.Calculator;

public class MainTest {
    public static void main(String[] args) {
        // Створюємо об'єкт класу Calculation для обчислення суми
        Calculation calculation = new Calculation(10.5, 20.3);

        // Створюємо об'єкт класу Calculator для виконання обчислень
        Calculator calculator = new Calculator(calculation);

        // Виконуємо обчислення
        calculator.performCalculation();

        // Отримуємо результат обчислення
        double result = calculator.getResult();
        System.out.println("Результат обчислення: " + result);
    }
}

