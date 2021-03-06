package com.tcshop.controller.data;

import java.util.HashMap;

public class ResultData extends HashMap {

    public static ResultData ok() {
        return new ResultData();
    }

    public ResultData() {
        this.setStatus(200);
        this.setData("");
    }

    public ResultData(Object data) {
        this.setData(data);
        this.setStatus(200);
    }

    public ResultData(Object data, Long totalCount) {
        this.init(data, totalCount,200);
    }

    public ResultData(Object data, Long totalCount, int status) {
        this.init(data, totalCount, status);
    }

    private void init(Object data, Long total, int status) {
        this.setData(data);
        this.setTotal(total);
        this.setStatus(status);
    }

    public void setData(Object data) {
        this.put("data", data);
    }

    public void setTotal(Long total) {
        this.put("total", total);
    }

    public void setStatus(int status) {
        this.put("status", status);
    }

    public void setError(String error) {
        this.put("error", error);
    }

}
