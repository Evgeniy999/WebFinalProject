package by.epam.interpol.command;

/**
 * The type Router.
 */
public class Router {

    /**
     * The enum Route type.
     */
    public enum RouteType {/**
     * Forward route type.
     */
    FORWARD,
        /**
         * Redirect route type.
         */
        REDIRECT}

    private String pagePath;
    private RouteType routeType = RouteType.FORWARD;

    /**
     * Sets page path.
     *
     * @param pagePath the page path
     */
    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    /**
     * Gets page path.
     *
     * @return the page path
     */
    public String getPagePath() {
        return pagePath;
    }


    /**
     * Gets route.
     *
     * @return the route
     */
    public RouteType getRoute() {
        return routeType;
    }

    /**
     * Sets route type.
     *
     * @param routeType the route type
     */
    public void setRouteType(RouteType routeType) {
        if (routeType != null) {
            this.routeType = routeType;
        }
    }

    /**
     * Is forward boolean.
     *
     * @return the boolean
     */
    public boolean isForward() {
        return routeType.getClass() == RouteType.FORWARD.getClass();
    }

}