package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;


public class ReadJsonData {

    public static JSONObject getJsonData() throws ParseException, IOException {

        File filename = new File("D:\\AutomationFrameworks\\Web Test Automation ebay Task\\src\\main\\resources\\testData.json");
        String jsonTestData = FileUtils.readFileToString(filename, "UTF-8");
        Object obj = new JSONParser().parse(jsonTestData);
        return (JSONObject) obj;
    }

    public static String getTestData(String input) throws IOException, ParseException {
        return (String) getJsonData().get(input);
    }
}
