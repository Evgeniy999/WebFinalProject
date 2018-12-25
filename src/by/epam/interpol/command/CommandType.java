package by.epam.interpol.command;


import by.epam.interpol.command.impl.*;

public enum CommandType {

    SEARCH(new UserSearchCommand()),
    LOGIN(new LoginCommand()),
    REGISTRATION(new RegistrationCommand()),
    CHANGE_LANG(new ChangeLangCommand()),
    LOGOUT(new LogoutCommand());


    private ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }
    public ActionCommand getCommand() {
        return command;
    }

}