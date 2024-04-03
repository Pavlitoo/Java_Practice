package practice3;

public class SimpleAdditionOperation implements AdditionOperation, Displayable {
    @Override
    public int perform(int a, int b) {
        return a + b;
    }

    @Override
    public void displayResult(int result) {
        System.out.println("Результат простого додавання: " + result);
    }
}


