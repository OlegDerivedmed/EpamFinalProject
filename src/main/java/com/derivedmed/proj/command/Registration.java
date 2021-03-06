package com.derivedmed.proj.command;

import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.Role;
import com.derivedmed.proj.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements ICommand {

    private static Logger LOGGER = LogManager.getLogger(Registration.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User();
        user.setLogin(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setRole(Role.USER);
        int id = ServiceFactory.getUserService().createUser(user);
        if (id != 0) {
            user.setId(id);
            req.getSession().setAttribute("user", user);
            return "pages/main.jsp";
        }
        req.setAttribute("message", "sorry,current login already taken");
        return "pages/registration.jsp";
    }
}
