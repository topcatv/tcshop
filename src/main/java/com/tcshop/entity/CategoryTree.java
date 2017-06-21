package com.tcshop.entity;

import java.util.List;

/**
 * Created by DELL on 2017/6/20.
 */
public class CategoryTree {

    private String key;

    private String value;

    private String label;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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

    public void setKey(String key) {
        this.key = key;
    }

    private List<CategoryTree> children;
}
