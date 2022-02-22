package com.fbmachine.qa.util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class XLSReader {
    public String path;
    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;

    public XLSReader(String path) {
        this.path = path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // returns the data from a cell
    public String getCellData(String sheetName, int rowNum, String colName) {
        int colNum = -1;
        try {
            int index = workbook.getSheetIndex(sheetName);
            if (rowNum <= 0 || index == -1) return "";

            sheet = workbook.getSheetAt(index);

            // get the table column names
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    colNum = i;
            }
            if (colNum == -1) return "";
            return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colName + " does not exist  in xls";
        }
    }

}


