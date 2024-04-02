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

