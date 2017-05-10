package com.tcshop.entity;

import java.util.Date;
import javax.persistence.*;

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "custormer_id")
    private Integer custormerId;

    @Id
    @Column(name = "product_sku_id")
    private Integer productSkuId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取商品数量
     *
     * @return num - 商品数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置商品数量
     *
     * @param num 商品数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }
}