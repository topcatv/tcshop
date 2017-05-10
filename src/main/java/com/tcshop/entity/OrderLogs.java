package com.tcshop.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "order_logs")
public class OrderLogs {
    @Id
    @Column(name = "orders_id")
    private Integer ordersId;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 日志内容
     */
    private String content;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 获取日志内容
     *
     * @return content - 日志内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置日志内容
     *
     * @param content 日志内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}