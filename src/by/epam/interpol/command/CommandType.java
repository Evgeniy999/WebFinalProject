package by.epam.interpol.command;


import by.epam.interpol.command.impl.admin.ApproveApplicationCommand;
import by.epam.interpol.command.impl.admin.NewsAddCommand;
import by.epam.interpol.command.impl.admin.RemoveDocCommand;
import by.epam.interpol.command.impl.admin.RemoveUserCommand;
import by.epam.interpol.command.impl.guest.LoginCommand;
import by.epam.interpol.command.impl.guest.RegistrationCommand;
import by.epam.interpol.command.impl.manager.*;
import by.epam.interpol.command.impl.news.ToNewsPageCommand;
import by.epam.interpol.command.impl.user.*;

public enum CommandType {

    LOGIN(new LoginCommand()),
    TO_CHANGE_PASS_PAGE(new ToPageChangePasswordCommand()),
    TO_CHANGE_PROF_PAGE(new ToPageChangeProfCommand()),
    CHANGE_PASS(new ChangePasswordCommand()),
    CHANGE_PROF(new ChangeProfCommand()),
    REGISTRATION(new RegistrationCommand()),
    CHANGE_LANG(new ChangeLangCommand()),
    LOGOUT(new LogoutCommand()),
    APPROVE_PAGE(new ApprovePageCommand()),
    APPROVE_APPLIC(new ApproveApplicationCommand()),
    MANAGE_USER(new ManageUserCommand()),
    LOGIN_PAGE(new ToLoginPage()),
    REMOVE_USER(new RemoveUserCommand()),
    REMOVE_DOC(new RemoveDocCommand()),
    NEWS_PAGE(new ToNewsPageCommand()),
    NEWS_ADD_PAGE(new ManageNewsCommand()),
    ADD_NEWS(new NewsAddCommand()),
    PAGE_APPLIC(new ApplicationPageCommand()),
    ADD_APPLIC(new AddApplicationCommand()),
    WANTED_PAGE(new WantedPageCommand()),
    MISSING_PAGE(new MissingPageCommand()),
    MANAGE_DOC(new ManageDocCommand());

    private ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }
    public ActionCommand getCommand() {
        return command;
    }

}