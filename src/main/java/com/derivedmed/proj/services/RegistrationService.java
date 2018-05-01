package com.derivedmed.proj.services;

import com.derivedmed.proj.model.User;
import com.derivedmed.proj.util.annotations.Transactional;

public interface RegistrationService extends Service {
    @Transactional
    boolean Register(User user);
}
