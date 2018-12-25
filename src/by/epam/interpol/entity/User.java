package by.epam.interpol.entity;


import java.sql.Date;

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

    public User() {
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
