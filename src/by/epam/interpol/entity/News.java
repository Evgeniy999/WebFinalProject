package by.epam.interpol.entity;

import java.sql.Date;

public class News {
    private Date time;
    private String information;
    private String country;


    public News(Date time, String information, String country) {
        this.time = time;
        this.information = information;
        this.country = country;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
