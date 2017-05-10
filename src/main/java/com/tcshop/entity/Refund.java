package com.tcshop.entity;

import java.util.Date;
import javax.persistence.*;

public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "orders_id")
    private Integer ordersId;

    @Id
    @Column(name = "custormer_id")
    private Integer custormerId;

    @Id
    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    /**
     * 原因
     */
    private String reason;

    /**
     * 维权申请编号
     */
    private String code;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 处理方式
1.退款
2.补货
3.退货退款
     */
    private String type;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 申请状态
1.同意
2.拒绝
     */
    private String status;

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
     * @return order_detail_id
     */
    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * @param orderDetailId
     */
    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
     * 获取原因
     *
     * @return reason - 原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置原因
     *
     * @param reason 原因
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取维权申请编号
     *
     * @return code - 维权申请编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置维权申请编号
     *
     * @param code 维权申请编号
     */
    public void setCode(String code) {
        this.code = code;
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
     * 获取处理方式
1.退款
2.补货
3.退货退款
     *
     * @return type - 处理方式
1.退款
2.补货
3.退货退款
     */
    public String getType() {
        return type;
    }

    /**
     * 设置处理方式
1.退款
2.补货
3.退货退款
     *
     * @param type 处理方式
1.退款
2.补货
3.退货退款
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取联系电话
     *
     * @return mobile - 联系电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置联系电话
     *
     * @param mobile 联系电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取申请状态
1.同意
2.拒绝
     *
     * @return status - 申请状态
1.同意
2.拒绝
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置申请状态
1.同意
2.拒绝
     *
     * @param status 申请状态
1.同意
2.拒绝
     */
    public void setStatus(String status) {
        this.status = status;
    }
}