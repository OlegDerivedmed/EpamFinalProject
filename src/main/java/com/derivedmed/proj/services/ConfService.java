package com.derivedmed.proj.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ConfService extends Service {

    void createConf(HttpServletRequest req, HttpServletResponse resp);
}
