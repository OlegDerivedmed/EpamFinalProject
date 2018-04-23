package com.derivedmed.proj.util;

import java.util.HashSet;
import java.util.UUID;

public class IdGenerator {
    private static volatile HashSet<Integer> ids = new HashSet();
    private static IdGenerator ourInstance = new IdGenerator();

    public static IdGenerator getInstance() {
        return ourInstance;
    }

    private IdGenerator() {
    }

    public static synchronized int generateID() {
        int i = idGen();
        if (i < 0) {
            i = -i;
        }
        if (ids.contains(i)) {
            generateID();
        }
        ids.add(i);
        return i;
    }

    private static int idGen() {
        return UUID.randomUUID().hashCode();
    }
}
