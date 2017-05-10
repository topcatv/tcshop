package com.tcshop.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "shop_config")
public class ShopConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String logo;

    @Column(name = "link_man")
    private String linkMan;

    @Column(name = "link_mobile")
    private String linkMobile;

    private String address;

    private String description;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 公众号原始ID
     */
    @Column(name = "wx_oid")
    private String wxOid;

    /**
     * 公众号APPID
     */
    @Column(name = "wx_appid")
    private String wxAppid;

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
     * @return logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return link_man
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * @param linkMan
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    /**
     * @return link_mobile
     */
    public String getLinkMobile() {
        return linkMobile;
    }

    /**
     * @param linkMobile
     */
    public void setLinkMobile(String linkMobile) {
        this.linkMobile = linkMobile;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
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
     * 获取公众号原始ID
     *
     * @return wx_oid - 公众号原始ID
     */
    public String getWxOid() {
        return wxOid;
    }

    /**
     * 设置公众号原始ID
     *
     * @param wxOid 公众号原始ID
     */
    public void setWxOid(String wxOid) {
        this.wxOid = wxOid;
    }

    /**
     * 获取公众号APPID
     *
     * @return wx_appid - 公众号APPID
     */
    public String getWxAppid() {
        return wxAppid;
    }

    /**
     * 设置公众号APPID
     *
     * @param wxAppid 公众号APPID
     */
    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }
}