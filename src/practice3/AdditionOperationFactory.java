package practice3;

public class AdditionOperationFactory {
    public AdditionOperation createAdditionOperation(String type) {
        switch (type) {
            case "simple":
                return new SimpleAdditionOperation();
            case "advanced":
                return new AdvancedAdditionOperation();
            default:
                throw new IllegalArgumentException("Невідомий тип операції додавання: " + type);
        }
    }
}


