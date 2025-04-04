package katas.proxyBd.impl.autosave;

import katas.proxyBd.User;
import katas.proxyBd.UserStorage;

public class UserAutoSaveBd extends User {

    private UserStorage bd;

    public UserAutoSaveBd(int id, String name) {
        super(id, name);
    }

    public UserAutoSaveBd(User u, UserStorage bd) {
        super(u.getId(), u.getName());
        this.bd = bd;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        if (bd != null)
            bd.upsert(this);
    }

}
