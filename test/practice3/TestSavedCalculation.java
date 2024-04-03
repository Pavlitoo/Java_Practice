package test.practice3;

import practice3.*;

// test/TestSavedCalculation.java
public class TestSavedCalculation {
    public static void main(String[] args) {
        testAdd();
        testGetResult();
    }

    public static void testAdd() {
        SavedCalculation savedCalc = new SavedCalculation();
        int result = savedCalc.add(5, 3);
        if (result == 8) {
            System.out.println("Тест add() успішно пройдений");
        } else {
            System.out.println("Тест add() не пройдено");
        }
    }

    public static void testGetResult() {
        SavedCalculation savedCalc = new SavedCalculation();
        savedCalc.add(5, 3);
        int result = savedCalc.getResult("addition");
        if (result == 8) {
            System.out.println("Тест getResult() успішно пройдений");
        } else {
            System.out.println("Тест getResult() не пройдено");
        }
    }
}


