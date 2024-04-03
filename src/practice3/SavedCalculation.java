package practice3;

import java.util.HashMap;

public class SavedCalculation extends Calculation {
    private HashMap<String, Integer> results;

    public SavedCalculation() {
        results = new HashMap<>();
    }

    @Override
    public int add(int a, int b) {
        int result = super.add(a, b);
        results.put("addition", result);
        return result;
    }

    public int getResult(String operation) {
        return results.getOrDefault(operation, 0);
    }
}

