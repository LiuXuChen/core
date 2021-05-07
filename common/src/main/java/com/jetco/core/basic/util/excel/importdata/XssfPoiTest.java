package com.jetco.core.basic.util.excel.importdata;

import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Date;

/**
 * <p>
 * XSSF方式导入
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-10
 */
@Slf4j
public class XssfPoiTest {

    public static String PATH = "/Users/liuhongwei/test/";

    public static void main(String[] args) throws Exception {
        // 获取文件流
        FileInputStream fis = new FileInputStream(PATH + "test.xlsx");
        // 创建工作薄
        Workbook workbook = new XSSFWorkbook(fis);
        // 得到表
        Sheet sheet = workbook.getSheetAt(0);
        // 得到行
        Row row = sheet.getRow(0);
        // 得到列
        Cell cell = row.getCell(0);
        String value = getValue(cell);
        log.info("导入第一行第一列数据为：[{}]", value);
        fis.close();
    }

    private static String getValue(Cell cell) {
        String cellValue = "";
        // 匹配类型数据
        if (cell != null) {
            CellType cellType = cell.getCellType();
            switch (cellType) {
                case STRING:
                    log.info("[{}]", "String类型");
                    cellValue = cell.getStringCellValue();
                    break;
                case BOOLEAN:
                    log.info("[{}]", "boolean类型");
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    log.info("[{}]", "BLANK类型");
                    break;
                // 数字（日期、普通数字）
                case NUMERIC:
                    log.info("[{}]", "NUMERIC类型");
                    if(HSSFDateUtil.isCellDateFormatted(cell)) {
                        log.info("[{}]", "日期类型");
                        Date date = cell.getDateCellValue();
                        cellValue = new DateTime(date).toString("yyyy-MM-dd");
                    } else {
                        // 不是日期格式，防止数字过长
                        log.info("[{}]", "转换为字符串输出");
                        cell.setCellType(CellType.STRING);
                        cellValue = cell.toString();
                    }
                    break;
                case ERROR:
                    log.info("[{}]", "数据类型错误");
                    break;
                default :
                    break;
            }
        }
        return cellValue;
    }
}
