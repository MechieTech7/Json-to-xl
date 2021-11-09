package json;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ExcelCreator extends ExcelWriter implements Interface {
    String userDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    String filePath = userDirectory + pathSeparator + "src" + pathSeparator + "students" ;
    String excelFilePath = filePath + "xlsx";
    String jsonFilePath = filePath + "json";

    public void readTheJsonFile() {
        List<String> sheetHeader = new ArrayList<>();
        List<String> nameOfTheStudent = new ArrayList<>();
        List<String> lastOfTheStudent = new ArrayList<>();

        String columnOne = "Name";
        String columnTwo = "LastName";

        sheetHeader.add(columnOne);
        sheetHeader.add(columnTwo);

        try {
            System.out.println("Reading JSON file");
            JSONParser parser = new JSONParser();
            FileReader fileReader = new FileReader(jsonFilePath);
            Object object = parser.parse(fileReader);
            JSONArray studentRecords = (JSONArray) object;
            for (Object recordObjects : studentRecords) {
                JSONObject student = (JSONObject) recordObjects;
                String name = (String) student.get(columnOne);
                nameOfTheStudent.add(name);
                String last = (String) student.get(columnTwo);
                lastOfTheStudent.add(last);

            }
            setSheetHeader(sheetHeader);
            setNameOfTheStudent(nameOfTheStudent);
            setAgeOfTheStudent(lastOfTheStudent);


        } catch (FileNotFoundException exception) {
            System.out.println("Check, the filepath!");
        } catch (IOException | ParseException exception) {
            System.out.println("Check the file in the specified path.");
        }
    }

    public void generateTheExcelFile() {

        try {
            System.out.println("Generating the Excel file....");
            File fileObject = new File(excelFilePath);
            FileOutputStream writerObject = new FileOutputStream(fileObject);
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("Students");
            int numberOfRows = getNameOfTheStudent().size()+1;
            int numberOfColumns = getSheetHeader().size();
            Row sheetHeader = sheet.createRow(0);
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                if (columnIndex == 0) {
                    Cell cellData = sheetHeader.createCell(columnIndex);
                    cellData.setCellValue(getSheetHeader().get(columnIndex));
                } else if (columnIndex == 1) {
                    Cell cellData = sheetHeader.createCell(columnIndex);
                    cellData.setCellValue(getSheetHeader().get(columnIndex));
                } else if (columnIndex == 2) {
                    Cell cellData = sheetHeader.createCell(columnIndex);
                    cellData.setCellValue(getSheetHeader().get(columnIndex));
                }
            }
            for (int rowIndex = 1; rowIndex < numberOfRows; rowIndex++) {
                Row rowData = sheet.createRow(rowIndex);
                for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                    if (columnIndex == 0) {
                        Cell columnOne = rowData.createCell(columnIndex);
                        columnOne.setCellValue(getNameOfTheStudent().get(rowIndex-1));
                    } else if (columnIndex == 1) {
                        Cell columnTwo = rowData.createCell(columnIndex);
                        columnTwo.setCellValue(getLastOfTheStudent().get(rowIndex-1));
                    }
                }
            }
            workBook.write(writerObject);
            System.out.println("Excel sheet Outcomes");
        } catch (IOException exception) {
            System.out.println("Check the file in the specified path.");
        }
    }
}
