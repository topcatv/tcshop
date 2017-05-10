package com.tcshop.entity;

import javax.persistence.*;

@Table(name = "category_product")
public class CategoryProduct {
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    @Id
    @Column(name = "product_id")
    private Integer productId;

    /**
     * @return category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}