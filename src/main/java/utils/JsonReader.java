package utils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

    public static JSONObject getJson(String fileName){
        JSONParser parser = new JSONParser();
        Object obj = null;

        try {
            obj = parser.parse(new FileReader("src/test/java/payload/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject ans = (JSONObject) obj;

        return ans;
    }

    public static String getValueFromResponse(String key, String fileName) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            //Parsing the contents of the JSON file
            jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/test/java/payload/" + fileName));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (String) jsonObject.get(key);
    }
}
