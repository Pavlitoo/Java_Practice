package practice2;

public class BinaryCount {
    
    /**
     * Метод для підрахунку кількості повних тетрад у двійковому поданні числа.
     * @param n Десяткове число
     * @return Кількість повних тетрад
     */
    public static int countFullBytes(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count / 8; // кількість повних тетрад
    }
}

