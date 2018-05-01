package com.derivedmed.proj.services;

import com.derivedmed.proj.util.annotations.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ConfService extends Service {
    @Transactional
    void createConf(HttpServletRequest req, HttpServletResponse resp);
}
