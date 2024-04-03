package test.practice3;

import practice3.*;

public class Main {
    public static void main(String[] args) {
        AdditionOperationFactory factory = new AdditionOperationFactory();

        // Створюємо об'єкт простого додавання
        AdditionOperation simpleAddition = factory.createAdditionOperation("simple");
        int simpleResult = simpleAddition.perform(15, 7);
        simpleAddition.displayResult(simpleResult);

        // Створюємо об'єкт складного додавання
        AdditionOperation advancedAddition = factory.createAdditionOperation("advanced");
        int advancedResult = advancedAddition.perform(15, 7);
        advancedAddition.displayResult(advancedResult);
    }
}


