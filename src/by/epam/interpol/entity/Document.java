package by.epam.interpol.entity;


import java.sql.Blob;
import java.sql.Date;

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

    public Document() {

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

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }


    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Date leadTime) {
        this.leadTime = leadTime;
    }

    public String getEncodedPhoto() {
        return encodedPhoto;
    }

    public void setEncodedPhoto(String encodedPhoto) {
        this.encodedPhoto = encodedPhoto;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }
}
