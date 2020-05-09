package org.itstep.msk.app.entity.documentsUser.contactInformation;

import javax.persistence.*;

@Entity@Table(name = "user_mails")
public class UserMail {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * название имейла
     */
    @Column(name = "names")
    private String nameMail;

    @ManyToOne(targetEntity = ContactInformation.class)
    @JoinColumn(name = "contact_information_id", referencedColumnName = "id")
    private ContactInformation contactInformation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNameMail(String nameMail) {
        this.nameMail = nameMail;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }
}
