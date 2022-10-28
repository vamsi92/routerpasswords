package com.routerpasswords.utils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static final String excelFile = "./src/test/resources/output.xls";
    private static final String manufacturerListFile= "./src/test/resources/manufacturer.xls";

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

    public static void createManufacturerList(List<String> list) throws IOException {
        Workbook wb=null;
        Sheet sheet=null;
        File file=new File(manufacturerListFile);

        if(!file.exists()){

            wb = new HSSFWorkbook();
            sheet=wb.createSheet();
            Row rowhead=sheet.createRow(0);
            Cell urlHeading = rowhead.createCell(0);
            Cell statusHeading = rowhead.createCell(1);
            urlHeading.setCellValue("URL");
            statusHeading.setCellValue("Status");
            int rowCount = sheet.getLastRowNum();

            for (int i =0; i <list.size(); i++) {
                Row row=sheet.createRow(++rowCount);
                Cell cell1 = row.createCell(0);
                Cell cell2 = row.createCell(1);
                cell1.setCellValue(list.get(i));
                cell2.setCellValue("false");
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            wb.write(outputStream);
            wb.close();
            outputStream.close();
        }

    }

    public static void updateManufacturerList(String url) throws IOException {
        Workbook wb=null;
        FileInputStream fileInputStream=null;
        Sheet sheet=null;
        File file=new File(manufacturerListFile);

        if(file.exists()){
            fileInputStream=new FileInputStream(new File(manufacturerListFile));
            wb = WorkbookFactory.create(fileInputStream);
            sheet= wb.getSheetAt(0);

            int rowCount = sheet.getLastRowNum();
            for (int i =1; i <rowCount; i++) {
                Row row=sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                if(cell1.getStringCellValue().equals(url)) {
                    cell2.setCellValue("true");
                }
            }
            fileInputStream.close();
            FileOutputStream outputStream = new FileOutputStream(manufacturerListFile);
            wb.write(outputStream);
            wb.close();
            outputStream.close();
        }

    }

    public static List<String> getManufacturerListForIncompleteStatus() throws IOException {
        List<String> manufacturerList=new ArrayList<String>();
        Workbook wb=null;
        FileInputStream fileInputStream=null;
        Sheet sheet=null;
        File file=new File(manufacturerListFile);

        if(file.exists()){
            fileInputStream=new FileInputStream(new File(manufacturerListFile));
            wb = WorkbookFactory.create(fileInputStream);
            sheet= wb.getSheetAt(0);

            int rowCount = sheet.getLastRowNum();
            for (int i =1; i <rowCount; i++) {
                Row row=sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                if(cell2.getStringCellValue().equals("false")) {
                   manufacturerList.add(cell1.getStringCellValue());
                }
            }
            fileInputStream.close();
            FileOutputStream outputStream = new FileOutputStream(manufacturerListFile);
            wb.write(outputStream);
            wb.close();
            outputStream.close();
        }
        return manufacturerList;
    }
}
