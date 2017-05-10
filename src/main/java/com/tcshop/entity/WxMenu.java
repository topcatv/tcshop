package com.tcshop.entity;

import javax.persistence.*;

@Table(name = "wx_menu")
public class WxMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "parent_id")
    private Integer parentId;

    @Id
    @Column(name = "shop_config_id")
    private Integer shopConfigId;

    @Id
    @Column(name = "media_id")
    private Integer mediaId;

    private String name;

    /**
     * 菜单动作
1.跳转链接
2.发送消息
     */
    @Column(name = "act_type")
    private String actType;

    @Column(name = "link_url")
    private String linkUrl;

    private String content;

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
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
     * @return media_id
     */
    public Integer getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId
     */
    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
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
     * 获取菜单动作
1.跳转链接
2.发送消息
     *
     * @return act_type - 菜单动作
1.跳转链接
2.发送消息
     */
    public String getActType() {
        return actType;
    }

    /**
     * 设置菜单动作
1.跳转链接
2.发送消息
     *
     * @param actType 菜单动作
1.跳转链接
2.发送消息
     */
    public void setActType(String actType) {
        this.actType = actType;
    }

    /**
     * @return link_url
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * @param linkUrl
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}