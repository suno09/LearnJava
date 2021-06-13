package custom_serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientExample {

    public static void main(String[] args) throws Exception {
        User user = new User();

        System.out.println("Before serialization : Username : " + user.userName
                + ", Password : " + user.password);
        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User readUser = (User) ois.readObject();

        System.out.println("After serialization and deserialization : Username : " +
                readUser.userName +
                ", Password : " + readUser.password);
    }
}
