package com.derivedmed.proj.services;

import com.derivedmed.proj.model.User;

public interface RegistrationService extends Service {

    int register(User user);
}
