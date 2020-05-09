package org.itstep.msk.app.entity.modelFormApplication;

import javax.persistence.*;

@Entity
@Table(name = "model_form_passports")
public class ModelFormPassport {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * фамилия
     */
    @Column(name = "surnames")
    private String surname;


    /**
     * имя
     */
    @Column(name = "names")
    private String name;

    /**
     * отчество
     */
    @Column(name = "patronymics")
    private String patronymic;

    /**
     * телефоны
     */
    @Column(name = "telephones")
    private String telephone;

    /**
     * имейлы
     */
    @Column(name = "mails")
    private String mail;

    /**
     * серия
     */
    @Column(name = "series")
    private int series;

    /**
     * номер
     */
    @Column(name = "numbers")
    private int number;

    /**
     * дата рождения
     */

    @Column(name = "date_births")
    private String dateBirth;

    /**
     *место рождения
     */
    @Column(name = "place_births")
    private String placeBirth;

    /**
     * код подразделения
     */
    @Column(name = "division_codes")
    private int divisionCode;

    /**
     * дата выдачи
     */
    @Column(name = "date_issues")
    private String dateIssue;

    /**
     * кем выдан
     */
    @Column(name = "who_issued")
    private String whoIssued;

    /**
     *индекс
     */
    @Column(name = "indexes")
    private int index;

    /**
     *регион
     */
    @Column(name = "regions")
    private String region;

    /**
     *город, село , деревня
     */
    @Column(name = "city")
    private String city;

    /**
     *улица
     */
    @Column(name = "streets")
    private String street;

    /**
     *дом
     */
    @Column(name = "houses")
    private String house;

    /**
     *корпус
     */
    @Column(name = "building")
    private String building;

    /**
     *квартира
     */
    @Column(name = "apartments")
    private String apartment;

    /**
     * статус заявки если false то еще не обработана
     */
    @Column(name = "status_applications")
    private Boolean statusApplication = false;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPlaceBirth() {
        return placeBirth;
    }

    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }

    public int getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(int divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(String dateIssue) {
        this.dateIssue = dateIssue;
    }

    public String getWhoIssued() {
        return whoIssued;
    }

    public void setWhoIssued(String whoIssued) {
        this.whoIssued = whoIssued;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Boolean getStatusApplication() {
        return statusApplication;
    }

    public void setStatusApplication(Boolean statusApplication) {
        this.statusApplication = statusApplication;
    }
}
