package by.epam.interpol.command;

public enum PagePath {
    INDEX_PAGE("index.jsp"),
    LOGIN_PAGE("jsp/login/login.jsp"),
    REGISTRATION_PAGE("jsp/registration/registration.jsp"),
    MAIN_PAGE("jsp/main/main.jsp"),
    USERS_TABLE("jsp/main/admin/manage/user_table.jsp"),
    ERROR_PAGE("/jsp/error/error.jsp"),
    DOCS_TABLE("jsp/main/admin/manage/doc_table.jsp");

    String jspPath; 

    PagePath(String jspPath) {
        this.jspPath = jspPath;
    }
    public String getJspPath() {
        return jspPath;
    }

}
