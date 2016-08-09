package format.json;

import jsonfields.Common;
import jsonfields.Config;
import jsonfields.FileType;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ROL5CLJ on 27.07.2016.
 */
public class JSONConfigFileHelper {


    public static void main(String args[]) {
        JSONConfigFileHelper jcfh = new JSONConfigFileHelper();
        JSONDataFormatter jdf = new JSONDataFormatter();
        String jSONDataString = jcfh.readJSONFile();
        String[] res = jdf.convertToType(jSONDataString);
        String conf = jcfh.getConfigString(res);
        boolean result=jcfh.validateConfigJSON("");
        String line = jcfh.getFieldFromJSONString(conf, Config.LINE.getConfigField());
        String factory = jcfh.getFieldFromJSONString(conf, Config.FACTORY.getConfigField());
        String machine = jcfh.getFieldFromJSONString(conf, Config.MACHINE.getConfigField());
        String code= jcfh.getHashKeyForConfigurationString(conf);
        String value= jcfh.getHashValueForConfigurationString(conf);
        System.out.println("Done");
    }

    public static String readJSONFile() {

        StringBuilder jSONData = new StringBuilder();
        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader("C:\\Users\\POF4CLJ\\Desktop\\SENSORS.txt"));

            while ((line = br.readLine()) != null) {
                jSONData.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return jSONData.toString();
    }

    private boolean isConfigFile(String[] jSonArray) {
        for (String jSonString : jSonArray) {
            if (jSonString.contains(FileType.CONFIGURATION.getFileType())) {
                return true;
            }
        }
        return false;
    }

    public String getConfigString(String[] jSonArray) {
        String jSonConfigurationString = "";

        if (isConfigFile(jSonArray)) {
            for (String jSonConfigCandidate : jSonArray) {
                if (jSonConfigCandidate.contains(FileType.CONFIGURATION.getFileType())) {
                    jSonConfigurationString = jSonConfigCandidate;
                }
            }
        }

        return jSonConfigurationString;
    }

    public boolean validateConfigJSON(String configJSON) {
        JsonParser jsonParser = new JsonParser();
        boolean result = true;

        if (configJSON == null || configJSON.equals("")) {
            result = false;
        }else{
            JsonObject jsonObjectFromString = (JsonObject) jsonParser.parse(configJSON);

            for (Config confField : Config.values()) {
                if (!jsonObjectFromString.has(confField.getConfigField())) {
                    result = false;
                }
            }

            for (Common comAtt : Common.values()) {
                if (!jsonObjectFromString.has(comAtt.getCommonAttribute())) {
                    result = false;
                }
            }

        }

        return result;
    }

    public String getFieldFromJSONString(String jSonString, String field) {
        JsonParser jsonParser = new JsonParser();

        if (jSonString != null || jSonString != "") {
            JsonObject jsonObjectFromString = (JsonObject) jsonParser.parse(jSonString);

            if (jsonObjectFromString.has(field)) {
                return jsonObjectFromString.get(field).toString();
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    public String getHashKeyForConfigurationString(String configString){
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObjectFromString = (JsonObject) jsonParser.parse(configString);

        return jsonObjectFromString.get(Common.GW_ID.getCommonAttribute()).toString().trim().replace("\"", "").concat(
               jsonObjectFromString.get(Common.ID.getCommonAttribute()).toString().trim().replace("\"", "")
               );
    }

    public String getHashValueForConfigurationString(String configString){
        JsonParser jsonParser = new JsonParser();
        JsonObject hashValueJson= new JsonObject();
        JsonObject jsonObjectFromString = (JsonObject) jsonParser.parse(configString);

        for (Config confField : Config.values()){
            hashValueJson.addProperty(confField.getConfigField(),jsonObjectFromString.get(confField.getConfigField()).toString().replace("\"", ""));
        }

        return hashValueJson.toString();
    }


}
