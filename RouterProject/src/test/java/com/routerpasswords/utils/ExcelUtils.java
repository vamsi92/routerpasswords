package com.routerpasswords.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelUtils {
    private static final String excelFile = "./src/test/resources/";

    public static void writeData(List<RouterDefaultPasswords> list) throws Exception {
        PropertiesFileReader propertiesInstance = PropertiesFileReader.getInstance();
        String manufacturer=propertiesInstance.getProperty("manufacturer");

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet(manufacturer);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        HSSFRow rowhead=sheet.createRow(0);
        HSSFCell modelHeading = rowhead.createCell(0);
        HSSFCell usernameHeading = rowhead.createCell(1);
        modelHeading.setCellValue("Model");
        usernameHeading.setCellValue("Username");

        for (int i =0; i <list.size(); i++) {
            HSSFRow rows=sheet.createRow(rowCount+1+i);
            HSSFCell cell1 = rows.createCell(0);
            HSSFCell cell2 = rows.createCell(1);
            cell1.setCellValue(list.get(i).getModelName());
            cell2.setCellValue(list.get(i).getUsername());
        }
        FileOutputStream outputStream = new FileOutputStream(excelFile+manufacturer+".xls");
        wb.write(outputStream);
        outputStream.close();
        wb.close();
    }
}
