package com.example.demo;

/**
 * ResultBean
 */
public class ResultBean {
    private String data;

    public ResultBean(String data) {
        this.setData(data);
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
}