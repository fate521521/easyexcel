package com.alibaba.easyexcel.test.demo.write;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.HashMap;

/**
 * @author fate
 * @version 1.0
 * @date 2023/3/9 0009 17:41
 * @className:SexEnum
 * @description
 */
@AllArgsConstructor
public enum SexEnum {

    MAN(1,"男"),
    WOMEN(2,"女")
    ;

    @EnumValue
    private final Integer value;
    @JsonValue
    private final String name;

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public final static HashMap<Integer,String> map = new HashMap<>();

    static {
        for (SexEnum fileTypeEnum : SexEnum.values()) {
            map.put(fileTypeEnum.getValue(),fileTypeEnum.getName());
        }
    }
}
