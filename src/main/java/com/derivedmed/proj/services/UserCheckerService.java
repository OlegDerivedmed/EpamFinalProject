package com.derivedmed.proj.services;

import com.derivedmed.proj.model.User;

public interface UserCheckerService extends Service {
    boolean checkUser(User user);
}
