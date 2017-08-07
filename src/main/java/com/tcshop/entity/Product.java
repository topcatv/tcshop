package com.tcshop.entity;

import javax.persistence.*;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand_id")
    private Integer brandId;

    /**
     * 商品类型：
     * 1.实物商品
     * 2.虚拟商品
     */
    private String type;

    /**
     * 商品编码
     */
    private String code;

    private String name;

    private String pics;

    private String tags;

    private Long price;

    private Integer stock;

    /**
     * 运费
     */
    private Long freightage;

    private String description;

    @Column(name = "category_id")
    private Integer categoryId;

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
     * @return brand_id
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * @param brandId
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取商品类型：
     * 1.实物商品
     * 2.虚拟商品
     *
     * @return type - 商品类型：
     * 1.实物商品
     * 2.虚拟商品
     */
    public String getType() {
        return type;
    }

    /**
     * 设置商品类型：
     * 1.实物商品
     * 2.虚拟商品
     *
     * @param type 商品类型：
     *             1.实物商品
     *             2.虚拟商品
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取商品编码
     *
     * @return code - 商品编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置商品编码
     *
     * @param code 商品编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return pics
     */
    public String getPics() {
        return pics;
    }

    /**
     * @param pics
     */
    public void setPics(String pics) {
        this.pics = pics;
    }

    /**
     * @return tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * @return price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取运费
     *
     * @return freightage - 运费
     */
    public Long getFreightage() {
        return freightage;
    }

    /**
     * 设置运费
     *
     * @param freightage 运费
     */
    public void setFreightage(Long freightage) {
        this.freightage = freightage;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}