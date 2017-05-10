package com.tcshop.entity;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "custormer_id")
    private Integer custormerId;

    @Id
    @Column(name = "orders_id")
    private Integer ordersId;

    @Column(name = "comment_time")
    private Date commentTime;

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
     * @return comment_time
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * @param commentTime
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
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