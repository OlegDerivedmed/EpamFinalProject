package com.derivedmed.proj.command;

import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.Conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UpcomingConfs implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Conf> confs = ServiceFactory.getConfService().getAll();
        req.setAttribute("confs",confs);
        return "pages/main.jsp";
    }
}
