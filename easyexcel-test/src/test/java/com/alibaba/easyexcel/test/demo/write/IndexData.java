package com.alibaba.easyexcel.test.demo.write;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;

import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
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
public class IndexData {

    /**
     * 注意: @ColumnWidth设置列宽，在model对应的属性添加注解(局部)或直接在model上添加注解(全局)
     */
    @ColumnWidth(value = 25)
    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.TOP)
    @ExcelProperty(value = "字符串标题", index = 0)
    private String string;
    @ColumnWidth(value = 55)
    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.CENTER)
    @ExcelProperty(value = "日期标题", index = 1)
    private Date date;
    /**
     * 这里设置3 会导致第二列空的
     */
    @ExcelProperty(value = "数字标题", index = 2)
    private Double doubleData;

    @ExcelProperty(value = "性别（0：女，1：男）", converter = GenderTypeConverter.class,index = 3)
    private SexEnum sexEnum = MAN;

    private String test;
}
