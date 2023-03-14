package com.alibaba.easyexcel.test.demo.write;


import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fate
 * @version 1.0
 * @date 2023/3/9 0009 17:58
 * @className:GenderTypeConverter
 * @description 性别类型转换器
 */
@Slf4j
public class GenderTypeConverter implements Converter<SexEnum> {

    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    /*@Override
    public SexEnum convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        // 导入的时候直接导入数字即可 不用操作
        if (cellData.toString().equals("1")) {
            return SexEnum.MAN;
        } else {
            return SexEnum.WOMEN;
        }
    }*/

    /**
     * 将从数据库中查到的数据转换为 Excel 展示的数据
     *
     * @param value 枚举对象
     */
    /*@Override
    public WriteCellData<?> convertToExcelData(SexEnum value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        // 将枚举类型按照 key 传值
        CellData data = new CellData();
        data.setStringValue(value.getName());
        return (WriteCellData<?>) data;
    }*/

    /**
     * Convert Java objects to excel objects
     *
     * @param value               Java Data.NotNull.
     * @param contentProperty     Content property.Nullable.
     * @param globalConfiguration Global configuration.NotNull.
     * @return Data to put into a Excel
     * @throws Exception Exception.
     */
    @Override
    public WriteCellData<?> convertToExcelData(SexEnum value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        WriteCellData<Object> data = new WriteCellData<>();
        data.setStringValue(value.getName());
        //https://www.cnblogs.com/aypls/p/16692796.html
        //this(CellDataTypeEnum.STRING, stringValue); 要设置String类型
        return new WriteCellData<>(String.valueOf(value.getName()));
    }
}
