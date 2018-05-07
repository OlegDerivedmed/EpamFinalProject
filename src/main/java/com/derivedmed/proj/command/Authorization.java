package com.derivedmed.proj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authorization implements ICommand {
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse resp) {
        return false;
    }
}
