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
