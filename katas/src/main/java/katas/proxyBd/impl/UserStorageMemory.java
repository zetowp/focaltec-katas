package katas.proxyBd.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import katas.proxyBd.User;
import katas.proxyBd.UserStorage;

public class UserStorageMemory implements UserStorage {

    private final List<User> users = this.init();

    private List<User> init() {
        final List<User> u = new ArrayList<>();
        u.addAll(Arrays.asList(new User(1, "hola"), new User(2, "mundo")));
        return u;
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public User upsert(final User u) {
        if (u.getId() == null) {
            final OptionalInt preNext = this.findAll().stream().mapToInt(User::getId).max();
            u.setId(preNext.isPresent() ? preNext.getAsInt() + 1 : 1);
            this.users.add(u);
            return u;
        } else {
            final Optional<User> toUpdate = this.users.stream().filter(us -> us.getId().equals(u.getId())).findFirst();
            if (!toUpdate.isPresent()) {
                u.setId(null);
                return this.upsert(u);
            } else {
                toUpdate.get().setName(u.getName());
                return toUpdate.get();
            }
        }

    }

    @Override
    public User find(final int id) {
        final Optional<User> match = this.users.stream().filter(us -> us.getId().equals(id)).findFirst();
        return match.isPresent() ? match.get() : null;
    }

}
