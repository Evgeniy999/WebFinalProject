package by.epam.interpol.entity;

import java.sql.Blob;
import java.sql.Date;

/**
 * The type News.
 */
public class News {
    private int newsId;
    private String topic;
    private String information;
    private String country;
    private Date time;
    private String encodedPhoto;
    private Blob photo;

    /**
     * Instantiates a new News.
     *
     * @param newsId       the news id
     * @param topic        the topic
     * @param information  the information
     * @param country      the country
     * @param time         the time
     * @param photo        the photo
     * @param encodedPhoto the encoded photo
     */
    public News(int newsId, String topic, String information, String country, Date time, Blob photo, String encodedPhoto) {
        this.newsId = newsId;
        this.topic = topic;
        this.information = information;
        this.country = country;
        this.time = time;
        this.encodedPhoto = encodedPhoto;
        this.photo = photo;
    }

    /**
     * Gets news id.
     *
     * @return the news id
     */
    public int getNewsId() {
        return newsId;
    }

    /**
     * Sets news id.
     *
     * @param newsId the news id
     */
    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    /**
     * Gets topic.
     *
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Sets topic.
     *
     * @param topic the topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets information.
     *
     * @return the information
     */
    public String getInformation() {
        return information;
    }

    /**
     * Sets information.
     *
     * @param information the information
     */
    public void setInformation(String information) {
        this.information = information;
    }

    /**
     * Gets encoded photo.
     *
     * @return the encoded photo
     */
    public String getEncodedPhoto() {
        return encodedPhoto;
    }

    /**
     * Sets encoded photo.
     *
     * @param encodedPhoto the encoded photo
     */
    public void setEncodedPhoto(String encodedPhoto) {
        this.encodedPhoto = encodedPhoto;
    }

    /**
     * Gets photo.
     *
     * @return the photo
     */
    public Blob getPhoto() {
        return photo;
    }

    /**
     * Sets photo.
     *
     * @param photo the photo
     */
    public void setPhoto(Blob photo) {
        this.photo = photo;
    }
}
