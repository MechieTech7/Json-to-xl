package json;

import java.util.ArrayList;
import java.util.List;

class ExcelWriter {
    private List<String> sheetHeader = new ArrayList<>();
    private List<String> firstnameOfTheStudent = new ArrayList<>();
    private List<String> lastOfTheStudent = new ArrayList<>();


    public List<String> getSheetHeader() {
        return sheetHeader;
    }

    public void setSheetHeader(List<String> sheetHeader) {
        this.sheetHeader = sheetHeader;
    }

    public List<String> getNameOfTheStudent() {
        return firstnameOfTheStudent;
    }

    public void setNameOfTheStudent(List<String> nameOfTheStudent) {
        this.firstnameOfTheStudent = nameOfTheStudent;
    }

    public List<String> getLastOfTheStudent() {
        return lastOfTheStudent;
    }

    public void setAgeOfTheStudent(List<String> lastOfTheStudent) {
        this.lastOfTheStudent = lastOfTheStudent;
    }


}

