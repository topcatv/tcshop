package com.tcshop.entity;

import javax.persistence.*;

public class Favorite {
    @Id
    @Column(name = "custormer_id")
    private Integer custormerId;

    @Id
    @Column(name = "product_sku_id")
    private Integer productSkuId;

    /**
     * @return custormer_id
     */
    public Integer getCustormerId() {
        return custormerId;
    }

    /**
     * @param custormerId
     */
    public void setCustormerId(Integer custormerId) {
        this.custormerId = custormerId;
    }

    /**
     * @return product_sku_id
     */
    public Integer getProductSkuId() {
        return productSkuId;
    }

    /**
     * @param productSkuId
     */
    public void setProductSkuId(Integer productSkuId) {
        this.productSkuId = productSkuId;
    }
}