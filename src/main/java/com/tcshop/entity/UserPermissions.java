package com.tcshop.entity;

import javax.persistence.*;

@Table(name = "user_permissions")
public class UserPermissions {
    @Id
    private Integer users;

    @Id
    private Integer permissions;

    /**
     * @return users
     */
    public Integer getUsers() {
        return users;
    }

    /**
     * @param users
     */
    public void setUsers(Integer users) {
        this.users = users;
    }

    /**
     * @return permissions
     */
    public Integer getPermissions() {
        return permissions;
    }

    /**
     * @param permissions
     */
    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }
}