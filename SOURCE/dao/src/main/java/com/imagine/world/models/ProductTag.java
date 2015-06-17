package com.imagine.world.models;

import javax.persistence.*;

/**
 * Created by letuan on 2/5/14.
 */
@Entity
@Table(name = "PRODUCT_TAG", schema = "", catalog = "imagine_world")
@IdClass(ProductTagPK.class)
public class ProductTag {
    private int idProduct;
    private int idTag;
    private Product product;

    @Id
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Id
    @Column(name = "id_tag")
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

        ProductTag that = (ProductTag) o;

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

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
