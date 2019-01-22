package by.epam.interpol.entity;

import java.sql.Blob;
import java.sql.Date;

/**
 * The type Person.
 */
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


    /**
     * Instantiates a new Person.
     *
     * @param personId        the person id
     * @param name            the name
     * @param lastName        the last name
     * @param status          the status
     * @param weight          the weight
     * @param height          the height
     * @param colorOfHair     the color of hair
     * @param nationality     the nationality
     * @param characteristics the characteristics
     * @param birthday        the birthday
     * @param sex             the sex
     * @param encodedPhoto    the encoded photo
     * @param photo           the photo
     */
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

    /**
     * Gets person id.
     *
     * @return the person id
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * Sets person id.
     *
     * @param personId the person id
     */
    public void setPersonId(int personId) {
        this.personId = personId;
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
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets color of hair.
     *
     * @return the color of hair
     */
    public String getColorOfHair() {
        return colorOfHair;
    }

    /**
     * Sets color of hair.
     *
     * @param colorOfHair the color of hair
     */
    public void setColorOfHair(String colorOfHair) {
        this.colorOfHair = colorOfHair;
    }

    /**
     * Gets nationality.
     *
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets nationality.
     *
     * @param nationality the nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets characteristics.
     *
     * @return the characteristics
     */
    public String getCharacteristics() {
        return characteristics;
    }

    /**
     * Sets characteristics.
     *
     * @param characteristics the characteristics
     */
    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(String sex) {
        this.sex = sex;
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
