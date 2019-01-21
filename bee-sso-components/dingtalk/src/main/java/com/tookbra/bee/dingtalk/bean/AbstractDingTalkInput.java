package com.tookbra.bee.dingtalk.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tookbra.bee.dingtalk.bean.output.DingTalkOutput;
import com.tookbra.bee.sso.core.utils.DateUtil;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tookbra
 * @date 2019/1/14
 * @description
 */
@Data
public abstract class AbstractDingTalkInput<T extends DingTalkOutput> implements DingTalkInput<T>, Serializable {

    /**
     * 支持分页查询，与size参数同时设置时才生效，此参数代表偏移量
     */
    private long offset = 0;
    /**
     * 支持分页查询，与offset参数同时设置时才生效，此参数代表分页大小，最大100
     */
    private int size = 100;
    /**
     * 排序规则
     */
    private String order;

    /**
     *
     * @return
     */
    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(16);
        List<Field> fields = this.getFields();
        fields.forEach(t -> {
            t.setAccessible(true);
            String key;
            JsonProperty jsonProperty = t.getAnnotation(JsonProperty.class);
            if(jsonProperty != null) {
                key = jsonProperty.value();
            } else {
                key = t.getName();
            }
            try {
                map.put(key, convertToString(t.get(this)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        map.put("offset", String.valueOf(this.getOffset()));
        map.put("size", String.valueOf(this.getSize()));
        return map;
    }

    private List<Field> getFields() {
        return Arrays.stream(this.getClass().getDeclaredFields())
                .filter(f -> !f.getName().equals("serialVersionUID"))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param value
     * @return
     */
    public String convertToString(Object value) {
       String val;
       if(value == null) {
           val = null;
       } else if (value instanceof String) {
           val = (String)value;
       } else if (value instanceof Integer) {
           val = ((Integer) value).toString();
       } else if (value instanceof Long) {
           val = ((Long) value).toString();
       } else if (value instanceof Float) {
           val = ((Float) value).toString();
       } else if (value instanceof Double) {
           val = ((Double) value).toString();
       } else if (value instanceof Boolean) {
           val = ((Boolean) value).toString();
       } else if (value instanceof Date) {
           val = DateUtil.formatDateTime((Date) value);
       } else {
           val = value.toString();
       }
       return val;
    }
}
