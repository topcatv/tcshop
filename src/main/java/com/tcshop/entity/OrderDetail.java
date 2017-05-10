package com.tcshop.entity;

import javax.persistence.*;

@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "orders_id")
    private Integer ordersId;

    @Id
    @Column(name = "product_sku_id")
    private Integer productSkuId;

    private Integer num;

    private Long amount;

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
     * @return orders_id
     */
    public Integer getOrdersId() {
        return ordersId;
    }

    /**
     * @param ordersId
     */
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
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
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return amount
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }
}