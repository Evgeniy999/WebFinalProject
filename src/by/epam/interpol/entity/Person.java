package by.epam.interpol.entity;

import java.sql.Blob;
import java.sql.Date;


public class Person {
    private int personId;
    private String name;
    private String lastName;
    private String status;
    private int weight;
    private int height;
    private String colorOfHair;
    private String nationality;
    private String characteristics;
    private Date birthday;
    private String sex;
    private String encodedPhoto;
    private Blob photo;


    public Person(int personId, String name, String lastName, String status, int weight, int height,
                  String colorOfHair, String nationality, String characteristics, Date birthday,
                  String sex, String encodedPhoto, Blob photo) {
        this.personId = personId;
        this.name = name;
        this.lastName = lastName;
        this.status = status;
        this.weight = weight;
        this.height = height;
        this.colorOfHair = colorOfHair;
        this.nationality = nationality;
        this.characteristics = characteristics;
        this.birthday = birthday;
        this.sex = sex;
        this.encodedPhoto = encodedPhoto;
        this.photo = photo;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColorOfHair() {
        return colorOfHair;
    }

    public void setColorOfHair(String colorOfHair) {
        this.colorOfHair = colorOfHair;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
