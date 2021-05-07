package com.jetco.core.basic.util.excel.importdata;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * SXSSF方式导入
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-10
 */
@Slf4j
public class SxssfPoiTest {

    public static String PATH = "/Users/liuhongwei/test/";

    public static void main(String[] args) throws Exception {
        // 获取文件流
        OPCPackage opcPackage = OPCPackage.open(PATH + "test.xlsx");

        // 创建工作薄
        XSSFReader xssfReader = new XSSFReader(opcPackage);
        StylesTable stylesTable = xssfReader.getStylesTable();
        ReadOnlySharedStringsTable sharedStringsTable = new ReadOnlySharedStringsTable(opcPackage);

        // 创建XMLReader，设置ContentHandler
        XMLReader xmlReader = SAXHelper.newXMLReader();
        xmlReader.setContentHandler(new XSSFSheetXMLHandler(stylesTable, sharedStringsTable, new SimpleSheetContentHandler(), false));
        // 解析每个sheet数据
        Iterator<InputStream> sheetsData = xssfReader.getSheetsData();
        while (sheetsData.hasNext()) {
            try(InputStream is = sheetsData.next()) {
                xmlReader.parse(new InputSource(is));
            }
        }
    }

    /**
     * 内容处理器
     */
    static class SimpleSheetContentHandler implements XSSFSheetXMLHandler.SheetContentsHandler {

        protected List<String> rows;

        @Override
        public void startRow(int rowNum) {
            rows = new ArrayList<>();
        }

        @Override
        public void endRow(int rowNum) {
            if(rows.isEmpty()) {
                return;
            }
            // 处理数据
            String data = rows.stream().collect(Collectors.joining("    "));
            log.info("处理后的数据为：{}", data);
        }

        @Override
        public void cell(String cellReference, String formattedValue, XSSFComment xssfComment) {
            rows.add(formattedValue);
        }

        @Override
        public void headerFooter(String text, boolean isHeader, String tagName) {

        }

        @Override
        public void endSheet() {

        }
    }

}
