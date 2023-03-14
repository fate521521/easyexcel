package com.alibaba.easyexcel.test.demo.write;

import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import org.apache.poi.ss.usermodel.*;

/**
 * des:
 *
 * @author jgybzx
 * @date 2021/6/29 9:43
 */
public class EasyExcelUtils {
    private EasyExcelUtils() {
    }

    /**
     * 设置表头的样式
     *
     * @return com.alibaba.excel.write.metadata.style.WriteCellStyle
     * @author jgybzx
     * @date 2021/6/29 14:02
     */
    public static WriteCellStyle getHeadStyle() {
        // 头的样式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景颜色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        //填充模式类型
        headWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);

        // 字体(字体名字，字体大小，字体是否加粗)
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontName("宋体");
        headWriteFont.setFontHeightInPoints((short) 14);
        headWriteFont.setBold(true);
        headWriteCellStyle.setWriteFont(headWriteFont);
        // 边框样式
        //下边框
        headWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        //底部边框颜色
        headWriteCellStyle.setBottomBorderColor((short) 0);
        //左边界
        headWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色
        headWriteCellStyle.setLeftBorderColor((short) 0);
        //右边框、右边界
        headWriteCellStyle.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色
        headWriteCellStyle.setRightBorderColor((short) 0);
        //上边框
        headWriteCellStyle.setBorderTop(BorderStyle.THIN);
        //上边框颜色
        headWriteCellStyle.setTopBorderColor((short) 0);
        // 自动换行
        headWriteCellStyle.setWrapped(true);
        // 水平、垂直居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        headWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return headWriteCellStyle;
    }

    /**
     * 设置内容的样式
     *
     * @return com.alibaba.excel.write.metadata.style.WriteCellStyle
     * @author jgybzx
     * @date 2021/6/29 14:05
     */
    public static WriteCellStyle getContentStyle() {
        // 内容的样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 背景绿色
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        // 前景色填充
        contentWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        // 填充模式类型
        contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 设置字体（字体大小，字体名字）
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short) 12);
        contentWriteFont.setFontName("宋体");
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        // 边框样式
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        contentWriteCellStyle.setBottomBorderColor((short) 0);
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        contentWriteCellStyle.setLeftBorderColor((short) 0);
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        contentWriteCellStyle.setRightBorderColor((short) 0);
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        contentWriteCellStyle.setTopBorderColor((short) 0);
        // 水平、垂直居中对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentWriteCellStyle.setWrapped(true);
        //设置单元格格式是：文本格式，方式长数字文本科学计数法
        return contentWriteCellStyle;
    }

}
