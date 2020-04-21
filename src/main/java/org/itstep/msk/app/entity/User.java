package org.itstep.msk.app.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    @ManyToOne(targetEntity = Role.class)
    @JoinTable(name = "user_roles",
            joinColumns={@JoinColumn (name = "user_id" , referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    /**
     * счета
     */
    @OneToMany(targetEntity = Account.class, mappedBy = "owner")
    private Set<Account> accounts;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public int getId() {
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
}
