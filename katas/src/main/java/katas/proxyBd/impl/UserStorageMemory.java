package katas.proxyBd.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import katas.proxyBd.User;
import katas.proxyBd.UserStorage;

public class UserStorageMemory implements UserStorage {

    private List<User> users = init();

    private List<User> init() {
        List<User> u = new ArrayList<>();
        u.addAll(Arrays.asList(new User(1, "hola"), new User(2, "mundo")));
        return u;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User upsert(User u) {
        if (u.getId() == null) {
            OptionalInt preNext = findAll().stream().mapToInt(User::getId).max();
            u.setId(preNext.isPresent() ? preNext.getAsInt() + 1 : 1);
            users.add(u);
            return u;
        } else {
            Optional<User> toUpdate = users.stream().filter(us -> us.getId().equals(u.getId())).findFirst();
            if (toUpdate.isEmpty()) {
                u.setId(null);
                return upsert(u);
            } else {
                toUpdate.get().setName(u.getName());
                return toUpdate.get();
            }
        }

    }

    @Override
    public User find(int id) {
        Optional<User> match = users.stream().filter(us -> us.getId().equals(id)).findFirst();
        return match.isPresent() ? match.get() : null;
    }

}
