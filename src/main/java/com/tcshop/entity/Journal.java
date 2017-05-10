package com.tcshop.entity;

import java.util.Date;
import javax.persistence.*;

public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 交易对象类型：0，店铺；1，会员；
     */
    private String objecttype;

    /**
     * 交易对象（店铺编码，店铺用户账号），0表示平台
     */
    private Integer objectid;

    /**
     * 交易时间
     */
    private Date journaltime;

    /**
     * 交易金额，如果为服务则为总工时费+总商品费用（含运费）（单位分）
     */
    private Long journalmoney;

    /**
     * 交易类型 0：订单；1：退款；2：充值；3：提现；4：满赠；5：平台佣金
     */
    private String tradetype;

    /**
     * 支付方式 0：储值卡；1:现金或银行卡；2：支付宝；3：微信支付；4：优惠券
     */
    private String paytype;

    /**
     * 流水类别 0：收入；1：支出；2：预收；3：赠送待定
     */
    private String journaltype;

    /**
     * 交易状态 0：交易成功；1：交易失败
     */
    private String dealstatus;

    /**
     * 当前交易后用户账户余额（冗余，否则要做统计。当前custormrid不为空时此字段必填）
     */
    private Long userbalance;

    /**
     * 凭证id（订单id,充值记录id）
     */
    private Integer credentialsid;

    /**
     * 凭证类型：0，订单；1，充值
     */
    private String credentialstype;

    /**
     * objecttype=0时使用 店铺ID
     */
    private Integer shopid;

    /**
     * objecttype=1时使用 会员ID
     */
    private Integer custormerid;

    /**
     * 制单人名字(id:名称)
     */
    private String user;

    /**
     * 交易详情
     */
    private String details;

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
     * 获取交易对象类型：0，店铺；1，会员；
     *
     * @return objecttype - 交易对象类型：0，店铺；1，会员；
     */
    public String getObjecttype() {
        return objecttype;
    }

    /**
     * 设置交易对象类型：0，店铺；1，会员；
     *
     * @param objecttype 交易对象类型：0，店铺；1，会员；
     */
    public void setObjecttype(String objecttype) {
        this.objecttype = objecttype;
    }

    /**
     * 获取交易对象（店铺编码，店铺用户账号），0表示平台
     *
     * @return objectid - 交易对象（店铺编码，店铺用户账号），0表示平台
     */
    public Integer getObjectid() {
        return objectid;
    }

    /**
     * 设置交易对象（店铺编码，店铺用户账号），0表示平台
     *
     * @param objectid 交易对象（店铺编码，店铺用户账号），0表示平台
     */
    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    /**
     * 获取交易时间
     *
     * @return journaltime - 交易时间
     */
    public Date getJournaltime() {
        return journaltime;
    }

    /**
     * 设置交易时间
     *
     * @param journaltime 交易时间
     */
    public void setJournaltime(Date journaltime) {
        this.journaltime = journaltime;
    }

    /**
     * 获取交易金额，如果为服务则为总工时费+总商品费用（含运费）（单位分）
     *
     * @return journalmoney - 交易金额，如果为服务则为总工时费+总商品费用（含运费）（单位分）
     */
    public Long getJournalmoney() {
        return journalmoney;
    }

    /**
     * 设置交易金额，如果为服务则为总工时费+总商品费用（含运费）（单位分）
     *
     * @param journalmoney 交易金额，如果为服务则为总工时费+总商品费用（含运费）（单位分）
     */
    public void setJournalmoney(Long journalmoney) {
        this.journalmoney = journalmoney;
    }

    /**
     * 获取交易类型 0：订单；1：退款；2：充值；3：提现；4：满赠；5：平台佣金
     *
     * @return tradetype - 交易类型 0：订单；1：退款；2：充值；3：提现；4：满赠；5：平台佣金
     */
    public String getTradetype() {
        return tradetype;
    }

    /**
     * 设置交易类型 0：订单；1：退款；2：充值；3：提现；4：满赠；5：平台佣金
     *
     * @param tradetype 交易类型 0：订单；1：退款；2：充值；3：提现；4：满赠；5：平台佣金
     */
    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }

    /**
     * 获取支付方式 0：储值卡；1:现金或银行卡；2：支付宝；3：微信支付；4：优惠券
     *
     * @return paytype - 支付方式 0：储值卡；1:现金或银行卡；2：支付宝；3：微信支付；4：优惠券
     */
    public String getPaytype() {
        return paytype;
    }

    /**
     * 设置支付方式 0：储值卡；1:现金或银行卡；2：支付宝；3：微信支付；4：优惠券
     *
     * @param paytype 支付方式 0：储值卡；1:现金或银行卡；2：支付宝；3：微信支付；4：优惠券
     */
    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    /**
     * 获取流水类别 0：收入；1：支出；2：预收；3：赠送待定
     *
     * @return journaltype - 流水类别 0：收入；1：支出；2：预收；3：赠送待定
     */
    public String getJournaltype() {
        return journaltype;
    }

    /**
     * 设置流水类别 0：收入；1：支出；2：预收；3：赠送待定
     *
     * @param journaltype 流水类别 0：收入；1：支出；2：预收；3：赠送待定
     */
    public void setJournaltype(String journaltype) {
        this.journaltype = journaltype;
    }

    /**
     * 获取交易状态 0：交易成功；1：交易失败
     *
     * @return dealstatus - 交易状态 0：交易成功；1：交易失败
     */
    public String getDealstatus() {
        return dealstatus;
    }

    /**
     * 设置交易状态 0：交易成功；1：交易失败
     *
     * @param dealstatus 交易状态 0：交易成功；1：交易失败
     */
    public void setDealstatus(String dealstatus) {
        this.dealstatus = dealstatus;
    }

    /**
     * 获取当前交易后用户账户余额（冗余，否则要做统计。当前custormrid不为空时此字段必填）
     *
     * @return userbalance - 当前交易后用户账户余额（冗余，否则要做统计。当前custormrid不为空时此字段必填）
     */
    public Long getUserbalance() {
        return userbalance;
    }

    /**
     * 设置当前交易后用户账户余额（冗余，否则要做统计。当前custormrid不为空时此字段必填）
     *
     * @param userbalance 当前交易后用户账户余额（冗余，否则要做统计。当前custormrid不为空时此字段必填）
     */
    public void setUserbalance(Long userbalance) {
        this.userbalance = userbalance;
    }

    /**
     * 获取凭证id（订单id,充值记录id）
     *
     * @return credentialsid - 凭证id（订单id,充值记录id）
     */
    public Integer getCredentialsid() {
        return credentialsid;
    }

    /**
     * 设置凭证id（订单id,充值记录id）
     *
     * @param credentialsid 凭证id（订单id,充值记录id）
     */
    public void setCredentialsid(Integer credentialsid) {
        this.credentialsid = credentialsid;
    }

    /**
     * 获取凭证类型：0，订单；1，充值
     *
     * @return credentialstype - 凭证类型：0，订单；1，充值
     */
    public String getCredentialstype() {
        return credentialstype;
    }

    /**
     * 设置凭证类型：0，订单；1，充值
     *
     * @param credentialstype 凭证类型：0，订单；1，充值
     */
    public void setCredentialstype(String credentialstype) {
        this.credentialstype = credentialstype;
    }

    /**
     * 获取objecttype=0时使用 店铺ID
     *
     * @return shopid - objecttype=0时使用 店铺ID
     */
    public Integer getShopid() {
        return shopid;
    }

    /**
     * 设置objecttype=0时使用 店铺ID
     *
     * @param shopid objecttype=0时使用 店铺ID
     */
    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    /**
     * 获取objecttype=1时使用 会员ID
     *
     * @return custormerid - objecttype=1时使用 会员ID
     */
    public Integer getCustormerid() {
        return custormerid;
    }

    /**
     * 设置objecttype=1时使用 会员ID
     *
     * @param custormerid objecttype=1时使用 会员ID
     */
    public void setCustormerid(Integer custormerid) {
        this.custormerid = custormerid;
    }

    /**
     * 获取制单人名字(id:名称)
     *
     * @return user - 制单人名字(id:名称)
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置制单人名字(id:名称)
     *
     * @param user 制单人名字(id:名称)
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 获取交易详情
     *
     * @return details - 交易详情
     */
    public String getDetails() {
        return details;
    }

    /**
     * 设置交易详情
     *
     * @param details 交易详情
     */
    public void setDetails(String details) {
        this.details = details;
    }
}