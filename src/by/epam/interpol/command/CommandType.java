package by.epam.interpol.command;


import by.epam.interpol.command.impl.admin.RemoveUserCommand;
import by.epam.interpol.command.impl.manager.*;
import by.epam.interpol.command.impl.news.OutNewsCommand;
import by.epam.interpol.command.impl.user.*;

public enum CommandType {

    LOGIN(new LoginCommand()),
    TO_CHANGE_PASS_PAGE(new ToChangePasswordCommand()),
    CHANGE_PASS(new ChangePasswordCommand()),
    REGISTRATION(new RegistrationCommand()),
    CHANGE_LANG(new ChangeLangCommand()),
    LOGOUT(new LogoutCommand()),
    NEWS_OUT(new OutNewsCommand()),
    MANAGE_USER(new ManageUserCommand()),
    LOGIN_PAGE(new ToLoginPage()),
    REMOVE_USER(new RemoveUserCommand()),
    PAGE_APPLIC(new ApplicationPageCommand()),
    ADD_APPLIC(new AddApplicationCommand()),
    MANAGE_DOC(new ManageDocCommand());

    private ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }
    public ActionCommand getCommand() {
        return command;
    }

}