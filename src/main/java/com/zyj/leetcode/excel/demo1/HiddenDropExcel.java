package com.zyj.leetcode.excel.demo1;


import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * @ProjectName: leetCode
 * @Package: com.zyj.leetcode.excel.demo1
 * @ClassName: HiddenDropExcel
 * @Author: honor
 * @Description:
 * @Date: 2023/10/31 17:11
 * @Version: 1.0
 */
public class HiddenDropExcel {

    public static void main(String[] args) {
        final XSSFWorkbook workbook = new XSSFWorkbook();
        final XSSFSheet sheet = workbook.createSheet("sheet");
        final XSSFSheet hidden = workbook.createSheet("hidden");
        workbook.setSheetHidden(workbook.getSheetIndex(hidden), true);

        final XSSFRow row = hidden.createRow(0);
        final XSSFCell cell = row.createCell(0);
        cell.setCellValue("选1");

        final XSSFRow row2 = hidden.createRow(1);
        final XSSFCell cell2 = row.createCell(0);
        cell2.setCellValue("选2");

        final DataValidationHelper helper = sheet.getDataValidationHelper();
        final CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(0, 0, 0, 0);
        final DataValidationConstraint constraint = helper.createFormulaListConstraint("hidden!$A$1:$A$2");
        final DataValidation validation = helper.createValidation(constraint, cellRangeAddressList);
        sheet.addValidationData(validation);

        try (FileOutputStream fileOutputStream = new FileOutputStream("D:\\test\\droP.xlsx")) {
          workbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
