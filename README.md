### Використання командного рядка Java

Цей простий Java застосунок здатний приймати аргументи через командний рядок та виводити їх на екран.

#### Компіляція та виконання

1. **Компіляція програми:**
   ```bash
   javac Main.java
    ```

2. **Виконання програми з передачею аргументів командного рядка:**

    ```bash
        java Main Hello World! Pavlito
    ```

## Приклад використання:$ java Main Hello World! Zhenya

3. **Передані аргументи командного рядка:**

    ```bash
    Аргумент 1: Hello
    Аргумент 2: World!
    Аргумент 3: Pavlito
    ```

4. **Якщо жодного аргументу не передано, буде виведено повідомлення:**

    ```bash
    $ java Main
    Немає переданих аргументів командного рядка.
    ```
## Main.java
```bash
package Pr;

public class Main {
    public static void main(String[] args) {
        // Перевірка, чи є аргументи командного рядка
        if (args.length == 0) {
            System.out.println("Немає переданих аргументів командного рядка.");
        } else {
            System.out.println("Передані аргументи командного рядка:");
            // Виведення переданих аргументів командного рядка
            for (int i = 0; i < args.length; i++) {
                System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
            }
        }
    }
}
```



## MainTest.java
```bash
package Test;
import Pr.Main;

public class MainTest {

    public static void main(String[] args) {
        MainTest tester = new MainTest(); // Створюємо об'єкт класу MainTest
        // Викликаємо методи для тестування
        tester.testNoArguments();
        tester.testWithArguments();
    }

    public void testNoArguments() {
        String[] args = {};
        Main.main(args); // Викликаємо метод main з класу Main
    }

    public void testWithArguments() {
        String[] args = {"Hello", "World!", "Pavlito"};
        Main.main(args); // Викликаємо метод main з класу Main
    }
}
```
### Ось результат ↓

![Результат](/screenshot/pr1.jpg)




