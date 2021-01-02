package custom_serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
    static int field1 = 1;
    final int field2 = 2;
    private final int field3 = 3;
    transient int field4 = 4;
    transient final int field5 = 5;

    String userName = "admin";
    transient String password = "password";

    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();
        String encryptPassword = encrypt(password);
        oos.writeObject(encryptPassword);
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();
        password = decrypt((String)ois.readObject());
    }
    
    private String encrypt(String value) {
        return new StringBuilder(value).reverse().toString();
    }

    private String decrypt(String value) {
        return new StringBuilder(value).reverse().toString();
    }
}
