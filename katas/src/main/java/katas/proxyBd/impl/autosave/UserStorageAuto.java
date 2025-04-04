package katas.proxyBd.impl.autosave;

import java.util.List;
import java.util.stream.Collectors;

import katas.proxyBd.User;
import katas.proxyBd.UserStorage;

public class UserStorageAuto implements UserStorage {

    private UserStorage storage;

    public UserStorageAuto(UserStorage storage) {
        this.storage = storage;
    }


    @Override
    public List<User> findAll() {
        return storage.findAll().stream().map(u -> new UserAutoSaveBd(u, this)).collect(Collectors.toList());
    }

    @Override
    public User upsert(User u) {
        return new UserAutoSaveBd(storage.upsert(u), this);
    }

    @Override
    public User find(int id) {
        User match = storage.find(id);
        return match != null ? new UserAutoSaveBd(match, this) : null;
    }

}
