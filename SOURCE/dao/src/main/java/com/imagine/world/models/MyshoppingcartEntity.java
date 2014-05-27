package com.imagine.world.models;

import javax.persistence.*;

/**
 * Created by letuan on 5/27/14.
 */
@Entity
@Table(name = "MYSHOPPINGCART", schema = "", catalog = "imagine_world")
public class MyshoppingcartEntity {
    private int cartId;
    private int itemId;
    private int userId;
    private int quantity;

    @Id
    @Column(name = "cart_id")
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Basic
    @Column(name = "item_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyshoppingcartEntity that = (MyshoppingcartEntity) o;

        if (cartId != that.cartId) return false;
        if (itemId != that.itemId) return false;
        if (quantity != that.quantity) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + itemId;
        result = 31 * result + userId;
        result = 31 * result + quantity;
        return result;
    }
}
