package katas.proxyBd;

import java.util.List;

public interface UserStorage {

    List<User> findAll();

    User upsert(User u);

    User find(int id);

}
