package by.epam.interpol.command;

public class Router {

    public enum RouteType {FORWARD, REDIRECT}

    private String pagePath;
    private RouteType routeType = RouteType.FORWARD;

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getPagePath() {
        return pagePath;
    }


    public RouteType getRoute() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        if (routeType != null) {
            this.routeType = routeType;
        }
    }

    public boolean isForward() {
        return routeType.getClass() == RouteType.FORWARD.getClass();
    }

}