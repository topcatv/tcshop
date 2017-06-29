package com.tcshop.controller.data;

import com.tcshop.entity.Product;

/**
 * Created by topcat on 2017/6/29.
 */
public class Goods extends Product {

    /**
     * 规格名
     */
    private String[] goodsName;

    private Long[] goodsPrice;

    private Integer[] goodsStock;

    public String[] getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String[] goodsName) {
        this.goodsName = goodsName;
    }

    public Long[] getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long[] goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer[] getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer[] goodsStock) {
        this.goodsStock = goodsStock;
    }
}
