package by.epam.interpol.command;

public enum PagePath {
    INDEX_PAGE("/index.jsp"),
    LOGIN_PAGE("/jsp/login/login.jsp"),
    PASSWORD_PAGE("/jsp/login/password.jsp"),
    REGISTRATION_PAGE("/jsp/registration/registration.jsp"),
    APPROVE_PAGE("/jsp/main/admin/manage/approve_application.jsp"),
    NEWS_PAGE("/jsp/main/admin/manage/news_table.jsp"),
    NEWS_ADD_PAGE("/jsp/main/admin/manage/add_news.jsp"),
    MAIN_PAGE("/jsp/main/main.jsp"),
    USERS_TABLE("/jsp/main/admin/manage/user_table.jsp"),
    ERROR_PAGE("/jsp/error/error.jsp"),
    APPLICATION_PAGE("/jsp/main/user/manage/add_application.jsp"),
    DOCS_TABLE("/jsp/main/admin/manage/doc_table.jsp");

    String jspPath; 

    PagePath(String jspPath) {
        this.jspPath = jspPath;
    }
    public String getJspPath() {
        return jspPath;
    }

}
