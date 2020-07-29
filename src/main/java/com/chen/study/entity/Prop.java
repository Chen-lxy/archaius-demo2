package com.chen.study.entity;

public class Prop {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Prop() {
    }

    public Prop(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Prop{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
