package com.jetco.core.basic.util.excel.exportdata;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 * HSSF方式导出，导出数据速度快，但最多支持65536条数据导出，超过这个条数会报错
 * office2003专用格式
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-06
 */
@Slf4j
public class HssfPoiTest {

    public static String Path = "/Users/liuhongwei/test/";

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // 创建一个工作薄
        Workbook workbook = new HSSFWorkbook();
        // 创建表
        Sheet sheet = workbook.createSheet();
        // 写入数据
        for (int i = 0, rowNum = sheet.getPhysicalNumberOfRows(); i < rowNum; i++) {
            // 创建行
            Row row = sheet.createRow(i);
            for (int j = 0, cellNum = row.getPhysicalNumberOfCells(); j < cellNum; j++) {
                // 创建列
                Cell cell = row.createCell(j);
                cell.setCellValue(j);
            }
        }
        log.info("export finish！");
        FileOutputStream fos = new FileOutputStream(Path + "test.xls");
        workbook.write(fos);
        fos.close();
        log.info("导出耗时：{} ms", (double)((System.currentTimeMillis() - start) / 1000));
    }
}
