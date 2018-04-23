package com.derivedmed.proj.util;

public class UserValidator {
    private static UserValidator ourInstance = new UserValidator();

    public static UserValidator getInstance() {
        return ourInstance;
    }

    private UserValidator() {
    }
}
