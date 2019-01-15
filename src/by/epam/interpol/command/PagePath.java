package by.epam.interpol.command;

/**
 * The enum Page path.
 */
public enum PagePath {
    /**
     * Index page page path.
     */
    INDEX_PAGE("/index.jsp"),
    /**
     * Login page page path.
     */
    LOGIN_PAGE("/jsp/login/login.jsp"),
    /**
     * Password page admin page path.
     */
    PASSWORD_PAGE_ADMIN("/jsp/main/admin/manage/password.jsp"),
    /**
     * Password page user page path.
     */
    PASSWORD_PAGE_USER("/jsp/main/user/manage/password.jsp"),
    /**
     * Change prof page admin page path.
     */
    CHANGE_PROF_PAGE_ADMIN("/jsp/main/admin/manage/change_prof.jsp"),
    /**
     * Change prof page user page path.
     */
    CHANGE_PROF_PAGE_USER("/jsp/main/user/manage/change_prof.jsp"),
    /**
     * Registration page page path.
     */
    REGISTRATION_PAGE("/jsp/registration/registration.jsp"),
    /**
     * Approve page page path.
     */
    APPROVE_PAGE("/jsp/main/admin/manage/approve_application.jsp"),
    /**
     * News page page path.
     */
    NEWS_PAGE("/jsp/main/admin/manage/news_table.jsp"),
    /**
     * News add page page path.
     */
    NEWS_ADD_PAGE("/jsp/main/admin/manage/add_news.jsp"),
    /**
     * Main page page path.
     */
    MAIN_PAGE("/jsp/main/main.jsp"),
    /**
     * Users table page path.
     */
    USERS_TABLE("/jsp/main/admin/manage/user_table.jsp"),
    /**
     * Error page page path.
     */
    ERROR_PAGE("/jsp/error/error.jsp"),
    /**
     * Application page page path.
     */
    APPLICATION_PAGE("/jsp/main/user/manage/add_application.jsp"),
    /**
     * Docs table page path.
     */
    DOCS_TABLE("/jsp/main/admin/manage/doc_table.jsp"),
    /**
     * Wanted table page path.
     */
    WANTED_TABLE("/jsp/main/common/wanted_table.jsp"),
    /**
     * Missing table page path.
     */
    MISSING_TABLE("/jsp/main/common/missing_table.jsp");

    /**
     * The Jsp path.
     */
    String jspPath;

    PagePath(String jspPath) {
        this.jspPath = jspPath;
    }

    /**
     * Gets jsp path.
     *
     * @return the jsp path
     */
    public String getJspPath() {
        return jspPath;
    }

}
