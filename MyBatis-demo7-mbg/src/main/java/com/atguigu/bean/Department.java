package com.atguigu.bean;

public class Department {
    private Integer deId;

    private String deName;

    public Integer getDeId() {
        return deId;
    }

    public void setDeId(Integer deId) {
        this.deId = deId;
    }

    public String getDeName() {
        return deName;
    }

    public void setDeName(String deName) {
        this.deName = deName == null ? null : deName.trim();
    }
}