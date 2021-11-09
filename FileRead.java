package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("students.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray studentList = (JSONArray) obj;
            System.out.println(studentList);

            //Iterate over student array
            studentList.forEach(emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployeeObject(JSONObject student)
    {
        //Get student object within list
        JSONObject studentObject = (JSONObject) student.get("student");

        //Get student first name
        String firstName = (String) studentObject.get("firstName");
        System.out.println(firstName);

        //Get student last name
        String lastName = (String) studentObject.get("lastName");
        System.out.println(lastName);


    }
}

