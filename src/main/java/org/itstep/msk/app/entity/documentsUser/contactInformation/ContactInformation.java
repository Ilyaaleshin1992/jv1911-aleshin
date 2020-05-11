package org.itstep.msk.app.entity.documentsUser.contactInformation;

import org.itstep.msk.app.entity.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contact_informations")
public class ContactInformation {
    @Id@Column
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
    @OneToMany(targetEntity = UserTelephone.class ,mappedBy = "contactInformation")
    private Set<UserTelephone> telephone;

    /**
     * имейлы
     */
    @OneToMany(targetEntity = UserMail.class, mappedBy = "contactInformation")
    private Set<UserMail> mail;

    /**
     * адреса
     */
    @OneToMany(targetEntity = UserAddress.class, mappedBy = "contactInformation")
    private Set<UserAddress> addresses;

    @OneToOne(mappedBy = "contactInformation")
    private User user;

    public Integer getId() {
        return id;
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

    public Set<UserTelephone> getTelephone() {
        return telephone;
    }

    public void setTelephone(Set<UserTelephone> telephone) {
        this.telephone = telephone;
    }

    public Set<UserMail> getMail() {
        return mail;
    }

    public void setMail(Set<UserMail> mail) {
        this.mail = mail;
    }

    public Set<UserAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<UserAddress> addresses) {
        this.addresses = addresses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
