package dz.sundev.service;

import dz.sundev.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

@Service
public class UserService {
    private ArrayList<User> users = new ArrayList<>() {{
       add(new User("1", "user1"));
       add(new User("2", "user2"));
       add(new User("3", "user3"));
       add(new User("4", "user4"));
       add(new User("5", "user5"));
    }};

    public User getUser(String id) {
        return users
                .stream()
                .filter(item -> item.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public int getUserIndex(String id) {
        try {
            return IntStream.range(0, users.size())
                    .filter(index -> users.get(index).getId().equalsIgnoreCase(id))
                    .findFirst()
                    .getAsInt();
        } catch (NoSuchElementException e) {
            return -1;
        }
    }

    public void updateUser(User user) {
        int index = getUserIndex(user.getId());
        if (index == -1) {
            return;
        }

        users.set(index, user);
    }
}
