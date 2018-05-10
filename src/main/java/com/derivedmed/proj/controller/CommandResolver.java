package com.derivedmed.proj.controller;

import com.derivedmed.proj.command.Authorization;
import com.derivedmed.proj.command.ICommand;
import com.derivedmed.proj.command.LogOut;
import com.derivedmed.proj.command.RegisterToReport;
import com.derivedmed.proj.command.Registration;
import com.derivedmed.proj.command.UpcomingConfs;
import com.derivedmed.proj.command.WrongCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CommandResolver {

    private static final HashMap<String, ICommand> commands = new HashMap();
    private static CommandResolver instance = new CommandResolver();

    private CommandResolver() {
        commands.put("registration", new Registration());
        commands.put("wrong", new WrongCommand());
        commands.put("upcoming", new UpcomingConfs());
        commands.put("auth",new Authorization());
        commands.put("regToRep",new RegisterToReport());
        commands.put("logOut",new LogOut());
    }

    public static CommandResolver getInstance() {
        return instance;
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = commands.get("wrong");
        }
        return command;
    }
}
