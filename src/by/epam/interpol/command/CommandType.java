package by.epam.interpol.command;


import by.epam.interpol.command.impl.manager.ChangeLangCommand;
import by.epam.interpol.command.impl.manager.ManageDocCommand;
import by.epam.interpol.command.impl.manager.ManageUserCommand;
import by.epam.interpol.command.impl.news.OutNewsCommand;
import by.epam.interpol.command.impl.user.LoginCommand;
import by.epam.interpol.command.impl.user.LogoutCommand;
import by.epam.interpol.command.impl.user.RegistrationCommand;
import by.epam.interpol.command.impl.user.UserSearchCommand;

public enum CommandType {

    SEARCH(new UserSearchCommand()),
    LOGIN(new LoginCommand()),
    REGISTRATION(new RegistrationCommand()),
    CHANGE_LANG(new ChangeLangCommand()),
    LOGOUT(new LogoutCommand()),
    NEWS_OUT(new OutNewsCommand()),
    MANAGE_USER(new ManageUserCommand()),
    MANAGE_DOC(new ManageDocCommand());

    private ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }
    public ActionCommand getCommand() {
        return command;
    }

}