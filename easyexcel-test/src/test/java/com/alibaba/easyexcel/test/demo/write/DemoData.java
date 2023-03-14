package com.alibaba.easyexcel.test.demo.write;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static com.alibaba.easyexcel.test.demo.write.SexEnum.MAN;

/**
 * 基础数据类
 *
 * @author Jiaju Zhuang
 **/
@Getter
@Setter
@EqualsAndHashCode

//@ContentRowHeight(30) //设置内容高度
//@HeadRowHeight(50)    //设置标题高度
//@ColumnWidth(25)      //设置列宽
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
    @ExcelProperty(value = "性别（0：女，1：男）", converter = GenderTypeConverter.class)
    private SexEnum sexEnum = MAN;

    private String test;
    @ExcelProperty("状态")
    private String status;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
