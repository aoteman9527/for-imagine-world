package com.imagine.world.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by letuan on 2/5/14.
 */
public class ProductTagPK implements Serializable {
    private int idProduct;
    private int idTag;

    @Column(name = "id_product")
    @Id
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Column(name = "id_tag")
    @Id
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductTagPK that = (ProductTagPK) o;

        if (idProduct != that.idProduct) return false;
        if (idTag != that.idTag) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduct;
        result = 31 * result + idTag;
        return result;
    }
}
