package katas.proxyBd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import katas.proxyBd.impl.UserStorageMemory;
import katas.proxyBd.impl.autosave.UserStorageAuto;

public class StorageDataTest {

    @Test
    public void tetSaveData() {
        UserStorage toTest = new UserStorageAuto(new UserStorageMemory());
        List<User> all = toTest.findAll();
        assertEquals(2, all.size());
        User fueraBd = new User(null, "nuevo");
        User enBd = toTest.upsert(fueraBd);
        fueraBd.setName("algo");
        assertEquals("algo", fueraBd.getName());
        enBd.setName("test1");
        assertEquals("test1", enBd.getName());
        User three = toTest.find(3);
        assertEquals("test1", three.getName());
        assertNotEquals(enBd, three);

        three.setName("una cosa ya muy diferente");
        assertEquals("una cosa ya muy diferente", toTest.find(3).getName());
        assertNull(toTest.find(12345));
        assertEquals(4, toTest.upsert(new User(123, "no importa")).getId().intValue());
    }

}
