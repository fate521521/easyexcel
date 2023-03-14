package com.alibaba.easyexcel.test.demo.write;

import com.alibaba.excel.util.BooleanUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import org.apache.poi.ss.usermodel.*;

/**
 * @author fate
 * @version 1.0
 * @date 2023/3/14 0014 14:46
 * @className:FateCustomCellWriteHandler
 * @description fate测试的CustomCellWriteHandler
 */
public class FateStatusCustomCellWriteHandler implements CellWriteHandler {

    /**
     * 测试第六列，给其状态值 异常设置为红色
     */
    private static final Integer COLUMN_INDEX = 5;
    /**
     * 有效期的区间数字_60
     */
    private static final String NUMBER_60 = "异常";


    /**
     * 需求描述导出的Excel文档中,存在一列有效期(为Int类型),需要根据数值的大小来确定导出Excel的文本的颜色----记录过程
     * @param context
     */
    @Override
    public void afterCellDispose(CellWriteHandlerContext context) {
        if (BooleanUtils.isNotTrue(context.getHead())) {
            Cell cell = context.getCell();
            Workbook workbook = context.getWriteWorkbookHolder().getWorkbook();
            // 这里千万记住 想办法能复用的地方把他缓存起来 一个表格最多创建6W个样式
            // 不同单元格尽量传同一个 cellStyle
            /**
             * createCellStyle()
             * 创建新的单元格样式并将其添加到工作簿的样式表中
             * 返回：
             * 新的单元格样式对象
             * 抛出：
             * IllegalStateException – 如果单元格样式的数量超过了此类工作簿的限制。
             */
            CellStyle cellStyle = workbook.createCellStyle();
            int columnIndex = cell.getColumnIndex();
            if (cell.getColumnIndex() == COLUMN_INDEX ) {
                //以字符串形式获取单元格的值
                String stringCellValue = cell.getStringCellValue();

                Font writeFont = workbook.createFont();
                if (stringCellValue.equals(NUMBER_60)){
                    writeFont.setColor(IndexedColors.RED.getIndex());
                }else {
                    writeFont.setColor(IndexedColors.GREY_25_PERCENT.getIndex());
                }
                cellStyle.setBorderLeft(BorderStyle.THIN);
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setBorderBottom(BorderStyle.THIN);
//                cell.setCellValue(count+"天");
                //设置单元格背景色
//                  cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                cellStyle.setFont(writeFont);
                // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellStyle(cellStyle);
                // 由于这里没有指定dataformat 最后展示的数据 格式可能会不太正确
                // 这里要把 WriteCellData的样式清空， 不然后面还有一个拦截器 FillStyleCellWriteHandler 默认会将 WriteCellStyle 设置到
                // cell里面去 会导致自己设置的不一样
                context.getFirstCellData().setWriteCellStyle(null);

            }
        }
    }
}
