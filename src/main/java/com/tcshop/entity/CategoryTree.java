package com.tcshop.entity;

import java.util.List;

/**
 * Created by DELL on 2017/6/20.
 */
public class CategoryTree {

    private Integer key;

    private Integer value;

    private String label;

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<CategoryTree> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryTree> children) {
        this.children = children;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    private List<CategoryTree> children;
}
