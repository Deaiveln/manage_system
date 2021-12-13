package com.zxh.manage.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zxh
 * @create 2021-11-21-13:23
 * @statement Json字符串和对象相互转换的工具类
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将对象序列化为json字符串
     */
    public static String objToJson(Object obj){
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //忽略为null的字段
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * 将json反序列化为java对象
     */
    public static <T> T jsonToObj(String jsonStr,Class<T> clazz){
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T t = null;
        try {
            t = objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }
}
