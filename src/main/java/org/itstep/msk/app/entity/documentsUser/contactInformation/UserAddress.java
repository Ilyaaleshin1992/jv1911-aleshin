package org.itstep.msk.app.entity.documentsUser.contactInformation;

import org.itstep.msk.app.entity.documentsUser.contactInformation.ContactInformation;
import org.itstep.msk.app.entity.enums.StatusAddress;

import javax.persistence.*;

@Entity@Table(name = "user_address")
public class UserAddress {

    @Id@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * имел хозяина
     */
    @Column(name = "owner_mail")
    private String ownerMail;

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
     * статус адреса :
     * прописка REGISTRATION, выписка DISCHARGED, фактическое проживание THE_ACTUAL,
     * не актуальное проживание NO_LONGER_RELEVANT
     */
    @Column(name = "status_address")
    @Enumerated(EnumType.STRING)
    private StatusAddress statusAddress;

    /**
     * хозяин адреса
     */
    @ManyToOne(targetEntity = ContactInformation.class)
    @JoinColumn(name = "contact_information_id", referencedColumnName = "id")
    private ContactInformation contactInformation;

    public Integer getId() {
        return id;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail;
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

    public StatusAddress getStatusAddress() {
        return statusAddress;
    }

    public void setStatusAddress(StatusAddress statusAddress) {
        this.statusAddress = statusAddress;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }
}
