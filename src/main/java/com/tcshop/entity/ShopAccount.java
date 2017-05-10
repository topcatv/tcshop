package com.tcshop.entity;

import javax.persistence.*;

@Table(name = "shop_account")
public class ShopAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "shop_config_id")
    private Integer shopConfigId;

    private Long balance;

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
     * @return shop_config_id
     */
    public Integer getShopConfigId() {
        return shopConfigId;
    }

    /**
     * @param shopConfigId
     */
    public void setShopConfigId(Integer shopConfigId) {
        this.shopConfigId = shopConfigId;
    }

    /**
     * @return balance
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * @param balance
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }
}