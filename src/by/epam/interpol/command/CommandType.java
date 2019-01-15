package by.epam.interpol.command;


import by.epam.interpol.command.impl.admin.*;
import by.epam.interpol.command.impl.guest.LoginCommand;
import by.epam.interpol.command.impl.guest.RegistrationCommand;
import by.epam.interpol.command.impl.manager.*;
import by.epam.interpol.command.impl.news.ToNewsPageCommand;
import by.epam.interpol.command.impl.user.*;

/**
 * The enum Command type.
 */
public enum CommandType {

    /**
     * The Login.
     */
    LOGIN(new LoginCommand()),
    /**
     * The To change pass page.
     */
    TO_CHANGE_PASS_PAGE(new ToPageChangePasswordCommand()),
    /**
     * The To change prof page.
     */
    TO_CHANGE_PROF_PAGE(new ToPageChangeProfCommand()),
    /**
     * The Change pass.
     */
    CHANGE_PASS(new ChangePasswordCommand()),
    /**
     * The Change prof.
     */
    CHANGE_PROF(new ChangeProfCommand()),
    /**
     * The Registration.
     */
    REGISTRATION(new RegistrationCommand()),
    /**
     * The Change lang.
     */
    CHANGE_LANG(new ChangeLangCommand()),
    /**
     * The Logout.
     */
    LOGOUT(new LogoutCommand()),
    /**
     * The Approve page.
     */
    APPROVE_PAGE(new ApprovePageCommand()),
    /**
     * The Approve applic.
     */
    APPROVE_APPLIC(new ApproveApplicationCommand()),
    /**
     * The Manage user.
     */
    MANAGE_USER(new ManageUserCommand()),
    /**
     * The Login page.
     */
    LOGIN_PAGE(new ToLoginPage()),
    /**
     * The Remove user.
     */
    REMOVE_USER(new RemoveUserCommand()),
    /**
     * The Remove doc.
     */
    REMOVE_DOC(new RemoveDocCommand()),
    /**
     * The News page.
     */
    NEWS_PAGE(new ToNewsPageCommand()),
    /**
     * The News add page.
     */
    NEWS_ADD_PAGE(new ManageNewsCommand()),
    /**
     * The Add news.
     */
    ADD_NEWS(new NewsAddCommand()),
    /**
     * The Page applic.
     */
    PAGE_APPLIC(new ApplicationPageCommand()),
    /**
     * The Add applic.
     */
    ADD_APPLIC(new AddApplicationCommand()),
    /**
     * The Wanted page.
     */
    WANTED_PAGE(new WantedPageCommand()),
    /**
     * The Remove person.
     */
    REMOVE_PERSON(new RemovePersonCommand()),
    /**
     * The Missing page.
     */
    MISSING_PAGE(new MissingPageCommand()),
    /**
     * The Manage doc.
     */
    MANAGE_DOC(new ManageDocCommand());

    private ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    /**
     * Gets command.
     *
     * @return the command
     */
    public ActionCommand getCommand() {
        return command;
    }

}