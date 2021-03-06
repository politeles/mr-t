/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.decsai.excel2sql;

import es.ugr.decsai.excel2sql.sql.SqlDatatypes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * class to read an excel file
 *
 * @author Jose
 */
public class ExcelReader {

    Workbook wb;
    private int MAX_ITER = 10;
    private static final String EMPTY_STRING = "";

    /**
     * Open an excel file
     *
     * @param fileName
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidFormatException
     */
    public ExcelReader(String fileName) throws FileNotFoundException, IOException, InvalidFormatException {

        InputStream is = new FileInputStream(fileName);
        wb = WorkbookFactory.create(is);

    }

    public void ShowFields() {

        Sheet sheet = wb.getSheetAt(0);
        // no iterations at row level:
        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);
        Iterator<Cell> cellIterator = row.cellIterator();

        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
//                    if (DateUtil.isCellDateFormatted(cell)) {
//                        System.out.println(cell.getDateCellValue());
//                    } else {
                    System.out.println(cell.getNumericCellValue());
//                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    System.out.println(cell.getCellFormula());
                    break;
                default:
                    System.out.println();
            }

        }

    }

    public List<String> getFieldList() {
        List<String> fieldList = new ArrayList<String>();
        Sheet sheet = wb.getSheetAt(0);
        // no iterations at row level:
        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            fieldList.add(cell.getRichStringCellValue().getString());
        }
        return fieldList;
    }

    public List<SqlDatatypes> heuristicHibernateTypes() {
        List<SqlDatatypes> typeList = new ArrayList<SqlDatatypes>();
        Sheet s = wb.getSheetAt(0);
        Row row = s.getRow(0);

        Iterator<Cell> cellIterator = row.cellIterator();
        int j = 0;
        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();
            String fieldName = cell.getRichStringCellValue().getString();

            // for a list of rows of this cell, 
            int candidateInt = 0, candidateDouble = 0, candidateString = 0;
            for (int i = 1; i < MAX_ITER; i++) {
                Row row1 = s.getRow(i);
                Cell cell2 = row1.getCell(j);



                try {
                    if (cell2.getCellType() != Cell.CELL_TYPE_BLANK) {
                        String content = cell2.getRichStringCellValue().getString();
                        if (content.trim().compareTo(EMPTY_STRING) != 0) {
                            candidateString++;
                            new Integer(content);
                            candidateInt++;
                            new Double(content);
                            candidateDouble++;
                        }
                    }

                } catch (Exception ex) {
                } finally {
                }

            }
            //check the max:


            if (candidateInt >= candidateDouble && candidateInt >= candidateString) {
                typeList.add(SqlDatatypes.INTEGER);
            } else if (candidateDouble >= candidateString) {
                typeList.add(SqlDatatypes.DOUBLE);
            } else {
                typeList.add(SqlDatatypes.STRING);
            }



            j++;
        }
        return typeList;
    }

    public List<String> getRowContents(int index) {
        List<String> valueList = new ArrayList<String>();
        Sheet s = wb.getSheetAt(0);
        Row row = s.getRow(index);

        Iterator<Cell> cellIterator = row.cellIterator();

        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();
            String content = cell.getRichStringCellValue().getString();
            valueList.add(content);
        }
        return valueList;
    }

    public int getRows() {
        Sheet s = wb.getSheetAt(0);
        return s.getLastRowNum();
    }
}
