package com.tcshop.entity;

import java.util.Date;
import javax.persistence.*;

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "custormer_id")
    private Integer custormerId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 订单总计
     */
    private Long amount;

    /**
     * 优惠金额
     */
    private Long discount;

    /**
     * 实际金额
     */
    @Column(name = "actual_amount")
    private Long actualAmount;

    /**
     * 商品总数
     */
    @Column(name = "sku_num")
    private Integer skuNum;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 物流费
     */
    private Long freightage;

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
     * 获取订单总计
     *
     * @return amount - 订单总计
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置订单总计
     *
     * @param amount 订单总计
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取优惠金额
     *
     * @return discount - 优惠金额
     */
    public Long getDiscount() {
        return discount;
    }

    /**
     * 设置优惠金额
     *
     * @param discount 优惠金额
     */
    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    /**
     * 获取实际金额
     *
     * @return actual_amount - 实际金额
     */
    public Long getActualAmount() {
        return actualAmount;
    }

    /**
     * 设置实际金额
     *
     * @param actualAmount 实际金额
     */
    public void setActualAmount(Long actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * 获取商品总数
     *
     * @return sku_num - 商品总数
     */
    public Integer getSkuNum() {
        return skuNum;
    }

    /**
     * 设置商品总数
     *
     * @param skuNum 商品总数
     */
    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    /**
     * 获取订单编号
     *
     * @return code - 订单编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置订单编号
     *
     * @param code 订单编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取物流费
     *
     * @return freightage - 物流费
     */
    public Long getFreightage() {
        return freightage;
    }

    /**
     * 设置物流费
     *
     * @param freightage 物流费
     */
    public void setFreightage(Long freightage) {
        this.freightage = freightage;
    }
}