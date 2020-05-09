package org.itstep.msk.app.entity.documentsUser;

import org.itstep.msk.app.entity.User;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;


@Entity
@Table(name = "passports")
public class Passport {
    /**
     * id
     */
    @Id@Column@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    private Date dateBirth;

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
    private Date dateIssue;

    /**
     * кем выдан
     */
    @Column(name = "who_issued")
    private String whoIssued;


    /**
     * хозяин паспорта
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    private User user;

    @ManyToOne(targetEntity = Passport.class)
    @JoinColumn(name = "owner_passport_id" , referencedColumnName = "id")
    private Passport previouslyIssuedPassport;

    public Integer getId() {
        return id;
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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
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

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public String getWhoIssued() {
        return whoIssued;
    }

    public void setWhoIssued(String whoIssued) {
        this.whoIssued = whoIssued;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Passport getPreviouslyIssuedPassport() {
        return previouslyIssuedPassport;
    }

    public void setPreviouslyIssuedPassport(Passport previouslyIssuedPassport) {
        this.previouslyIssuedPassport = previouslyIssuedPassport;
    }
}
