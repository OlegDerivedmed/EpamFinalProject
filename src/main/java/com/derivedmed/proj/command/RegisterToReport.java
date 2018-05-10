package com.derivedmed.proj.command;

import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.Conf;
import com.derivedmed.proj.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RegisterToReport implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute("user");
        int user_id = user.getId();
        int report_id = Integer.parseInt(req.getParameter("reportId"));
        if (ServiceFactory.getUserService().registerUserToReport(user_id,report_id)) {
            List<Conf> confs = ServiceFactory.getConfService().getAll();
            req.setAttribute("confs",confs);
            return "pages/main.jsp";
        }
        return "pages/wrong.jsp";
    }
}
