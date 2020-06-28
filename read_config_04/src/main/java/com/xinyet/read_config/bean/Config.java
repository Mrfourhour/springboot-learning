package com.xinyet.read_config.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * @description //TODO
  * @date 2020/6/28 14:31
  * @author Administrator
  */
@Component
@ConfigurationProperties(prefix = "config-attributes")
public class Config {
    private String value;
    private String[] valueArray;
    private List<String> valueList;
    private HashMap<String, String> valueMap;
    private List<Map<String, String>> valueMapList;


    @Override
    public String toString() {
        return "Config{" +
                "value='" + value + '\'' +
                ", valueArray=" + Arrays.toString(valueArray) +
                ", valueList=" + valueList +
                ", valueMap=" + valueMap +
                ", valueMapList=" + valueMapList +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String[] getValueArray() {
        return valueArray;
    }

    public void setValueArray(String[] valueArray) {
        this.valueArray = valueArray;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

    public HashMap<String, String> getValueMap() {
        return valueMap;
    }

    public void setValueMap(HashMap<String, String> valueMap) {
        this.valueMap = valueMap;
    }

    public List<Map<String, String>> getValueMapList() {
        return valueMapList;
    }

    public void setValueMapList(List<Map<String, String>> valueMapList) {
        this.valueMapList = valueMapList;
    }
}
