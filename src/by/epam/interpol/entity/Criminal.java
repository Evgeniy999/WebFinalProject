package by.epam.interpol.entity;

import java.sql.Date;
import java.time.LocalDate;


public class Criminal {
    private String name;
    private String lastName;
    private String reason;
    private Date birthday;
    private Date termOfImp;

    public Criminal(String name, String lastName, String reason, Date birthday, Date termOfImp) {
        this.name = name;
        this.lastName = lastName;
        this.reason = reason;
        this.birthday = birthday;
        this.termOfImp = termOfImp;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getTermOfImp() {
        return termOfImp;
    }

    public void setTermOfImp(Date termOfImp) {
        this.termOfImp = termOfImp;
    }
}
