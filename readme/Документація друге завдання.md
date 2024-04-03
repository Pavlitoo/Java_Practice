# Завдання 2 - Класи та об'єкти  

### Завдання 1

- Розробити клас, що серіалізується, для зберігання параметрів і результатів
обчислень.

### Calculator.java

```java
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
```

### Calculation.java

```java
package practice2;

import java.io.Serializable;

/**
 * Клас, що представляє обчислення і може бути серіалізованим.
 */
public class Calculation implements Serializable {
    private static final long serialVersionUID = 1L; // Ідентифікатор версії для контролю серіалізації

    // Параметри обчислення
    private double parameter1;
    private double parameter2;

    // Результат обчислення
    private double result;

    /**
     * Конструктор класу Calculation.
     * @param parameter1 Параметр 1
     * @param parameter2 Параметр 2
     */
    public Calculation(double parameter1, double parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }

    /**
     * Метод для виконання обчислення.
     * Наприклад, обчислення суми параметрів.
     */
    public void calculate() {
        result = parameter1 + parameter2;
    }

    /**
     * Метод для отримання результату обчислення.
     * @return Результат обчислення
     */
    public double getResult() {
        return result;
    }
}
```

### MainTest.java

```java
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
```

![task2.1](/img/practice2.1.jpg)

### Завдання 2
- Розробити клас для демонстрації в діалоговому режимі збереження та
відновлення стану об'єкта, використовуючи серіалізацію. Показати особливості
використання transient полів. 

### ObjectSerializationDemo.java


```java
package practice2;

import java.io.*;

public class ObjectSerializationDemo {

    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;
        private transient int age; // Поле age буде ігноруватися при серіалізації

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Створюємо об'єкт для серіалізації
        Person person = new Person("John", 30);

        // Серіалізуємо об'єкт
        serializeObject(person);

        // Відновлюємо об'єкт з файлу
        Person deserializedPerson = deserializeObject();

        // Виводимо відновлений об'єкт
        System.out.println("Відновлений об'єкт: " + deserializedPerson);
    }

    public static void serializeObject(Person person) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            outputStream.writeObject(person);
            System.out.println("Об'єкт був серіалізований.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deserializeObject() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person.ser"))) {
            return (Person) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

### ObjectSerializationDemoTest.java

```java
package practice2;

public class ObjectSerializationDemoTest {

    public static void main(String[] args) {
        testSerialization();
    }

    public static void testSerialization() {
        ObjectSerializationDemo.Person person = new ObjectSerializationDemo.Person("Alice", 25);

        // Серіалізуємо об'єкт
        ObjectSerializationDemo.serializeObject(person);

        // Відновлюємо об'єкт з файлу
        ObjectSerializationDemo.Person deserializedPerson = ObjectSerializationDemo.deserializeObject();

        // Перевіряємо, чи об'єкти мають однакові поля name
        if (person.toString().equals(deserializedPerson.toString())) {
            System.out.println("Тестування серіалізації пройшло успішно.");
        } else {
            System.out.println("Тестування серіалізації не пройшло успішно.");
        }
    }
}
```

![task2.2](/img/practice2.2.jpg)

### Завдання 3
- Розробити клас для тестування коректності результатів обчислень та
серіалізації/десеріалізації.
Використовувати докладні коментарі для автоматичної генерації
документації засобами javadoc.

### CalculationTester

```java
package practice2;

/**
 * Клас для тестування коректності результатів обчислень.
 */
public class CalculationTester {

    /**
     * Метод для перевірки правильності результату обчислень.
     * @param result Очікуваний результат
     * @param actual Фактичний результат
     * @return true, якщо результати співпадають; false, якщо ні
     */
    public static boolean testCalculationResult(double result, double actual) {
        return result == actual;
    }
}
```

### CalculationTesterTest

```java
package test;

import practice2.CalculationTester;

/**
 * Клас для тестування класу CalculationTester.
 */
public class CalculationTesterTest {

    /**
     * Головний метод для запуску тестів.
     * @param args Аргументи командного рядка
     */
    public static void main(String[] args) {
        testCalculationResult();
    }

    /**
     * Метод для тестування методу testCalculationResult класу CalculationTester.
     */
    public static void testCalculationResult() {
        double expectedResult = 30.0;
        double actualResult = 30.0;
        if (CalculationTester.testCalculationResult(expectedResult, actualResult)) {
            System.out.println("Тест для перевірки коректності результату обчислень пройшов успішно.");
        } else {
            System.out.println("Тест для перевірки коректності результату обчислень не пройшов.");
        }
    }
}
```

### ObjectSerializationTester

```java
package practice2;

import java.io.*;

/**
 * Клас для тестування коректності серіалізації та десеріалізації об'єктів.
 */
public class ObjectSerializationTester {

    /**
     * Метод для перевірки коректності серіалізації та десеріалізації об'єктів.
     * @param originalObject Оригінальний об'єкт
     * @return true, якщо об'єкт був коректно серіалізований та десеріалізований; false, якщо ні
     */
    public static boolean testSerialization(Object originalObject) {
        try {
            // Серіалізуємо об'єкт
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(originalObject);
            objectOutputStream.close();
            
            // Десеріалізуємо об'єкт
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Object deserializedObject = objectInputStream.readObject();
            objectInputStream.close();
            
            // Перевіряємо, чи об'єкти співпадають
            return originalObject.equals(deserializedObject);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
```

### ObjectSerializationTesterTest

```java
package test;

import practice2.ObjectSerializationTester;

/**
 * Клас для тестування класу ObjectSerializationTester.
 */
public class ObjectSerializationTesterTest {

    /**
     * Головний метод для запуску тестів.
     * @param args Аргументи командного рядка
     */
    public static void main(String[] args) {
        testSerialization();
    }

    /**
     * Метод для тестування методу testSerialization класу ObjectSerializationTester.
     */
    public static void testSerialization() {
        // Створюємо об'єкт для серіалізації
        Object object = new Object();

        if (ObjectSerializationTester.testSerialization(object)) {
            System.out.println("Тест для перевірки коректності серіалізації та десеріалізації об'єктів пройшов успішно.");
        } else {
            System.out.println("Тест для перевірки коректності серіалізації та десеріалізації об'єктів не пройшов.");
        }
    }
}
```

![task2.3](/img/practice2.3.jpg)

![task2.3](/img/practice2.3calc.jpg)


### Завдання 4
- 11. Підрахувати кількість повних тетрад у двійковому поданні заданого
десяткового числа.

### BinaryCount

```java
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
```

### BinaryCountTest

```java
package test;

import practice2.BinaryCount;

public class BinaryCountTest {
    
    public static void main(String[] args) {
        testCountFullBytes();
    }

    public static void testCountFullBytes() {
        // Тестування на випадковому числі
        int number = 135; // Вхідне десяткове число
        int expectedFullBytes = 1; // Очікувана кількість повних тетрад
        int fullBytes = BinaryCount.countFullBytes(number);
        if (fullBytes == expectedFullBytes) {
            System.out.println("Тест пройшов успішно: " + fullBytes + " повних тетрад у числа " + number);
        } else {
            System.out.println("Тест не пройшов: " + fullBytes + " повних тетрад замість " + expectedFullBytes);
        }
    }
}
```

![task2.4](/img/practice2.4.jpg)


## Мій GitHub

![Static Badge](https://img.shields.io/badge/GitHub-181717?style=plastic&logo=GitHub&labelColor=black&color=white&link=https%3A%2F%2Fgithub.com%2FPavlitoo)


*Автор роботи: Луговий Павло 34  PPC NTU "KhPI"*