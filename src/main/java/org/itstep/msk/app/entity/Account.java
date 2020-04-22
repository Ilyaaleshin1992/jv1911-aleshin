package org.itstep.msk.app.entity;

import javax.persistence.*;
import java.util.Set;


/**
 * счёт
 */
@Entity
@Table(name = "account")
public class Account {
    /**
     * номер счёта
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numbers")
    private int number;

    /**
     * хозяин счёта
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    /**
     * карты привязанные к счету
     */
    @OneToMany(targetEntity = Cart.class, mappedBy = "owner")
    private Set<Cart> carts;

    public int getNumber() {
        return number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }
}
