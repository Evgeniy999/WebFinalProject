package by.epam.interpol.entity;


import java.sql.Blob;
import java.sql.Date;

/**
 * The type Document.
 */
public class Document {

    private int docId;
    private String statement;
    private Date time;
    private double reward;
    private String information;
    private Date leadTime;
    private String name;
    private String lastName;
    private String encodedPhoto;
    private Blob photo;

    /**
     * Instantiates a new Document.
     *
     * @param docId        the doc id
     * @param statement    the statement
     * @param time         the time
     * @param reward       the reward
     * @param information  the information
     * @param leadTime     the lead time
     * @param name         the name
     * @param lastName     the last name
     * @param photo        the photo
     * @param encodedPhoto the encoded photo
     */
    public Document(int docId, String statement, Date time, double reward, String information, Date leadTime,
                    String name, String lastName, Blob photo, String encodedPhoto) {
        this.docId = docId;
        this.statement = statement;
        this.time = time;
        this.reward = reward;
        this.information = information;
        this.leadTime = leadTime;
        this.name = name;
        this.lastName = lastName;
        this.encodedPhoto = encodedPhoto;
        this.photo = photo;
    }

    /**
     * Instantiates a new Document.
     */
    public Document() {

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
     * Gets doc id.
     *
     * @return the doc id
     */
    public int getDocId() {
        return docId;
    }

    /**
     * Sets doc id.
     *
     * @param docId the doc id
     */
    public void setDocId(int docId) {
        this.docId = docId;
    }

    /**
     * Gets statement.
     *
     * @return the statement
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Sets statement.
     *
     * @param statement the statement
     */
    public void setStatement(String statement) {
        this.statement = statement;
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
     * Gets reward.
     *
     * @return the reward
     */
    public double getReward() {
        return reward;
    }

    /**
     * Sets reward.
     *
     * @param reward the reward
     */
    public void setReward(double reward) {
        this.reward = reward;
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
     * Gets lead time.
     *
     * @return the lead time
     */
    public Date getLeadTime() {
        return leadTime;
    }

    /**
     * Sets lead time.
     *
     * @param leadTime the lead time
     */
    public void setLeadTime(Date leadTime) {
        this.leadTime = leadTime;
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
