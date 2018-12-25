package by.epam.interpol.entity;


import java.sql.Date;

public class Document {

    private String statement;
    private Date time;
    private Date leadTime;
    private String information;
    private double reward;

    public Document(String statement, Date time, Date leadTime, String information, double reward) {
        this.statement = statement;
        this.time = time;
        this.leadTime = leadTime;
        this.information = information;
        this.reward = reward;
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
