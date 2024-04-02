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

