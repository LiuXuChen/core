package com.jetco.core.basic.util.excel.exportdata;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 * XSSF方式导出，支持大批量数据导出，所有的数据先写入内存再导出，容易出现内存溢出。
 * office2007专用格式，导出数据不受行数限制，但导出速度慢
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-06
 */
@Slf4j
public class XssfPoiTest {

    public static String Path = "/Users/liuhongwei/test/";

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
       // 创建一个工作薄
        try(Workbook workbook = new XSSFWorkbook()) {
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
            FileOutputStream fos = new FileOutputStream(Path + "test.xlsx");
            workbook.write(fos);
            fos.close();
            log.info("导出耗时：{} ms", (double)((System.currentTimeMillis() - start) / 1000));
        }

    }
}
