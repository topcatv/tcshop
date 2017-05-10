package com.tcshop.entity;

import javax.persistence.*;

@Table(name = "wx_replay")
public class WxReplay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "shop_config_id")
    private Integer shopConfigId;

    @Id
    @Column(name = "media_id")
    private Integer mediaId;

    /**
     * 回复规则名
     */
    private String name;

    /**
     * 触发事件
1.自动回复
2.关注回复
     */
    private String event;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 回复类型
1.文本消息
2.图文消息
     */
    @Column(name = "re_type")
    private String reType;

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
     * 获取回复规则名
     *
     * @return name - 回复规则名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置回复规则名
     *
     * @param name 回复规则名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取触发事件
1.自动回复
2.关注回复
     *
     * @return event - 触发事件
1.自动回复
2.关注回复
     */
    public String getEvent() {
        return event;
    }

    /**
     * 设置触发事件
1.自动回复
2.关注回复
     *
     * @param event 触发事件
1.自动回复
2.关注回复
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * 获取关键字
     *
     * @return keywords - 关键字
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 设置关键字
     *
     * @param keywords 关键字
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 获取回复类型
1.文本消息
2.图文消息
     *
     * @return re_type - 回复类型
1.文本消息
2.图文消息
     */
    public String getReType() {
        return reType;
    }

    /**
     * 设置回复类型
1.文本消息
2.图文消息
     *
     * @param reType 回复类型
1.文本消息
2.图文消息
     */
    public void setReType(String reType) {
        this.reType = reType;
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