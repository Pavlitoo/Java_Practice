package practice3;


public class AdvancedAdditionOperation implements AdditionOperation, Displayable {
    @Override
    public int perform(int a, int b) {
        return a + b + 10;
    }

    @Override
    public void displayResult(int result) {
        System.out.println("Результат складного додавання: " + result);
    }
}


