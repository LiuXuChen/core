package com.jetco.core.basic.util.excel.exportdata;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 * SXSSF方式导出，是XSSF方式的一种延伸，
 * 主要特点是低内存导出的时候，先将数据写入磁盘再导出，避免报内存不足，导致程序运行异常，缺点是运行很慢
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-06
 */
@Slf4j
public class SxssfPoiTest {

    public static String Path = "/Users/liuhongwei/test/";

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
       // 创建一个工作薄
        try(Workbook workbook = new SXSSFWorkbook()) {
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
