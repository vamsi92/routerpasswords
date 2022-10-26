package com.routerpasswords.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.List;

public class ExcelUtils {
    private static final String excelFile = "./src/test/resources/output.xls";

    //Deprecated/not used
    /*public static void writeData(List<RouterDefaultPasswords> list) throws Exception {

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("Sheet1");
        int rowCount = sheet.getLastRowNum();
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
        FileOutputStream outputStream = new FileOutputStream(excelFile);
        wb.write(outputStream);
        outputStream.close();
        wb.close();
    }*/

    public static void writeAllDataInSingleFile(List<RouterDefaultPasswords> list) throws Exception {
        Workbook wb=null;
        FileInputStream fileInputStream=null;
        Sheet sheet=null;
        File file=new File(excelFile);

        if(file.exists()){
             fileInputStream=new FileInputStream(new File(excelFile));
             wb = WorkbookFactory.create(fileInputStream);
             sheet= wb.getSheetAt(0);

            Row rowhead=sheet.createRow(0);
            Cell modelHeading = rowhead.createCell(0);
            Cell usernameHeading = rowhead.createCell(1);
            modelHeading.setCellValue("Model");
            usernameHeading.setCellValue("Username");
            int rowCount = sheet.getLastRowNum();

            for (int i =0; i <list.size(); i++) {
                Row row=sheet.createRow(++rowCount);
                Cell cell1 = row.createCell(0);
                Cell cell2 = row.createCell(1);
                cell1.setCellValue(list.get(i).getModelName());
                cell2.setCellValue(list.get(i).getUsername());
            }
            fileInputStream.close();
        }
        else{
            wb = new HSSFWorkbook();
            sheet=wb.createSheet();

            Row rowhead=sheet.createRow(0);
            Cell modelHeading = rowhead.createCell(0);
            Cell usernameHeading = rowhead.createCell(1);
            modelHeading.setCellValue("Model");
            usernameHeading.setCellValue("Username");
            int rowCount = sheet.getLastRowNum();

            for (int i =0; i <list.size(); i++) {
                Row row=sheet.createRow(++rowCount);
                Cell cell1 = row.createCell(0);
                Cell cell2 = row.createCell(1);
                cell1.setCellValue(list.get(i).getModelName());
                cell2.setCellValue(list.get(i).getUsername());
            }
        }
        FileOutputStream outputStream = new FileOutputStream(excelFile);
        wb.write(outputStream);
        wb.close();
        outputStream.close();
    }
}
