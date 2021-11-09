package json;

public class CodeRun {
    public static void main(String[] args) {
        Interface run = new ExcelCreator();
        run.readTheJsonFile();
        run.generateTheExcelFile();
    }
}
