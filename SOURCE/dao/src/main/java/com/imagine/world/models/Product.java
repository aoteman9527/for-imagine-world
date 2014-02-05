package com.imagine.world.models;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by letuan on 2/5/14.
 */
@Entity
@Table(name = "PRODUCT", schema = "", catalog = "imagine_world")
public class Product {
    private int idProduct;
    private String name;
    private String description;
    private String price;
    private String productCode;
    private Integer productAmount;
    private Date lastUpdateDate;
    private List<ProductTag> tags;

    @Id
    @Column(name = "id_product", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 45, precision = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 65535, precision = 0, columnDefinition= "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true, length = 45, precision = 0)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "product_code", nullable = true, insertable = true, updatable = true, length = 45, precision = 0)
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "product_amount", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    @Basic
    @Column(name = "last_update_date", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (idProduct != product.idProduct) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(product.lastUpdateDate) : product.lastUpdateDate != null)
            return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (productAmount != null ? !productAmount.equals(product.productAmount) : product.productAmount != null)
            return false;
        if (productCode != null ? !productCode.equals(product.productCode) : product.productCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduct;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productAmount != null ? productAmount.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "product")
    public List<ProductTag> getTags() {
        return tags;
    }

    public void setTags(List<ProductTag> tags) {
        this.tags = tags;
    }
}
