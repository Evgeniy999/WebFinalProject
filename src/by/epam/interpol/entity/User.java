package by.epam.interpol.entity;

import java.sql.Date;

/**
 * The type User.
 */
public class User {
    private int userId;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private Date birthday;
    private long telephone;
    private String address;
    private boolean type;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userId    the user id
     * @param login     the login
     * @param password  the password
     * @param name      the name
     * @param lastName  the last name
     * @param birthday  the birthday
     * @param telephone the telephone
     * @param address   the address
     * @param type      the type
     */
    public User(int userId, String login,String password,String name, String lastName,
                Date birthday, long telephone, String address, boolean type) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.telephone = telephone;
        this.address = address;
        this.type = type;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Is type boolean.
     *
     * @return the boolean
     */
    public boolean isType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     * Gets telephone.
     *
     * @return the telephone
     */
    public long getTelephone() {
        return telephone;
    }

    /**
     * Sets telephone.
     *
     * @param telephone the telephone
     */
    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
