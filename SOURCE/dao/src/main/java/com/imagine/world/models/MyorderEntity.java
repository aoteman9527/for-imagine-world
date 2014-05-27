package com.imagine.world.models;

import javax.persistence.*;

/**
 * Created by letuan on 5/27/14.
 */
@Entity
@Table(name = "MYORDER", schema = "", catalog = "imagine_world")
public class MyorderEntity {
    private int orderId;
    private int userId;
    private double totalprice;
    private int date;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
    @Column(name = "totalprice")
    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Basic
    @Column(name = "date")
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyorderEntity that = (MyorderEntity) o;

        if (date != that.date) return false;
        if (orderId != that.orderId) return false;
        if (Double.compare(that.totalprice, totalprice) != 0) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderId;
        result = 31 * result + userId;
        temp = Double.doubleToLongBits(totalprice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + date;
        return result;
    }
}
