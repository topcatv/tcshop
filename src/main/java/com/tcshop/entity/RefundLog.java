package com.tcshop.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "refund_log")
public class RefundLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "refund_id")
    private Integer refundId;

    private String content;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return refund_id
     */
    public Integer getRefundId() {
        return refundId;
    }

    /**
     * @param refundId
     */
    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
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
}