package org.itstep.msk.app.entity;

import org.itstep.msk.app.entity.documentsUser.contactInformation.ContactInformation;
import org.itstep.msk.app.entity.enums.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * логин
     */
    @Column(length = 100, unique = true)
    private String username;
    /**
     * пароль
     */
    @Column(length = 100)
    private String password;

    /**
     * список ролей пользовотеля
     */
    @ElementCollection(targetClass = Role.class)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    nullable = false,
                    columnDefinition = "INT UNSIGNED",
                    referencedColumnName = "id"
            )
    )
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    /**
     * счета пользователя
     */
    @OneToMany(targetEntity = Account.class, mappedBy = "owner")
    private Set<Account> accounts = new HashSet<>();

    @OneToOne(targetEntity = ContactInformation.class)
    @JoinColumn(name = "contact_informations", referencedColumnName = "id")
    private ContactInformation contactInformation;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }
}
