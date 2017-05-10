package com.tcshop.entity;

import javax.persistence.*;

@Table(name = "user_permission")
public class UserPermission {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

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
     * @return permission_id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}