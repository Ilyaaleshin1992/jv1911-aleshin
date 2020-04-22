package org.itstep.msk.app.entity;

import javax.persistence.*;

/**
 * карта, ноа привязывается к счету
 */
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    /**
     * номнр карты (логика еще не реализована)
     */
    @Column (name = "number_cart")
    private int numberCart;

    /**
     * родитель карты
     */
    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "numbers")
    private Account owner;

    public int getId() {
        return id;
    }

    public int getNumberCart() {
        return numberCart;
    }

    public void setNumberCart(int numberCart) {
        this.numberCart = numberCart;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
