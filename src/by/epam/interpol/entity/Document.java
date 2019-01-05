package by.epam.interpol.entity;


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

    public Document(int docId, String statement, Date time, double reward, String information, Date leadTime, String name, String lastName) {
        this.docId = docId;
        this.statement = statement;
        this.time = time;
        this.reward = reward;
        this.information = information;
        this.leadTime = leadTime;
        this.name = name;
        this.lastName = lastName;
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
}
