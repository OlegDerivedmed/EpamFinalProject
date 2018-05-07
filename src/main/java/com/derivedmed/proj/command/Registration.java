package com.derivedmed.proj.command;

import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements ICommand {

    private static Logger LOGGER = LogManager.getLogger(Registration.class);

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User();
        user.setEmail(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setRole_id(4);
        int id = ServiceFactory.getUserService().createUser(user);
        if (id!=0){
            user.setId(id);
            req.getSession().setAttribute("user",user);
            try {
                req.getRequestDispatcher("WEB-INF/pages/main.jsp").forward(req,resp);
            } catch (Exception e) {
                LOGGER.error("404",e);
            }
            return true;
        }
        try{
            req.getRequestDispatcher("WEB_INF/pages/alreadyexist.jsp").forward(req,resp);
        }catch (Exception e){
            LOGGER.error("404",e);
        }
        return false;
    }
}
