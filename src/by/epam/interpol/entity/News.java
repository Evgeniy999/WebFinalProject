package by.epam.interpol.entity;

import java.sql.Date;

public class News {
    private int newsId;
    private String topic;
    private String information;
    private String country;
    private Date time;

    public News(int newsId, String topic, String information, String country, Date time) {
        this.newsId = newsId;
        this.topic = topic;
        this.information = information;
        this.country = country;
        this.time = time;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
