package com.tcshop.entity;

import javax.persistence.*;

public class Wxpay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "shop_config_id")
    private Integer shopConfigId;

    /**
     * 支付方式：
1.扫码支付
2.公众号支付
     */
    private String type;

    private String appid;

    /**
     * 支付回调地址
     */
    @Column(name = "callback_url")
    private String callbackUrl;

    /**
     * api密钥
     */
    private String apikey;

    /**
     * 商户号
     */
    @Column(name = "vendor_id")
    private String vendorId;

    /**
     * 商户证书
     */
    @Column(name = "vendor_cert")
    private String vendorCert;

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
     * 获取支付方式：
1.扫码支付
2.公众号支付
     *
     * @return type - 支付方式：
1.扫码支付
2.公众号支付
     */
    public String getType() {
        return type;
    }

    /**
     * 设置支付方式：
1.扫码支付
2.公众号支付
     *
     * @param type 支付方式：
1.扫码支付
2.公众号支付
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * 获取支付回调地址
     *
     * @return callback_url - 支付回调地址
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * 设置支付回调地址
     *
     * @param callbackUrl 支付回调地址
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * 获取api密钥
     *
     * @return apikey - api密钥
     */
    public String getApikey() {
        return apikey;
    }

    /**
     * 设置api密钥
     *
     * @param apikey api密钥
     */
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    /**
     * 获取商户号
     *
     * @return vendor_id - 商户号
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * 设置商户号
     *
     * @param vendorId 商户号
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * 获取商户证书
     *
     * @return vendor_cert - 商户证书
     */
    public String getVendorCert() {
        return vendorCert;
    }

    /**
     * 设置商户证书
     *
     * @param vendorCert 商户证书
     */
    public void setVendorCert(String vendorCert) {
        this.vendorCert = vendorCert;
    }
}