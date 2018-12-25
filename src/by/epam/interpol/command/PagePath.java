package by.epam.interpol.command;

public enum PagePath {
    INDEX_PAGE("index.jsp"),
    LOGIN_PAGE("jsp/login/login.jsp"),
    REGISTRATION_PAGE("jsp/registration/registration.jsp"),
    MAIN_PAGE("jsp/main/main.jsp");

    String jspPath; 

    PagePath(String jspPath) {
        this.jspPath = jspPath;
    }
    public String getJspPath() {
        return jspPath;
    }

}
