package format.json;

import jsonfields.*;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ROL5CLJ on 15.07.2016.
 */
public class JSONDataFormatter {

    public String[] convertToType(String toBeConverted) {
        JSONDataFormatter JSONDataFormatter = new JSONDataFormatter();
        JsonArray jSONDataJSON = JSONDataFormatter.stringToJSONConverter(toBeConverted);
        JsonArray jSONDataFormatted = JSONDataFormatter.formatJSONArray(jSONDataJSON);

        return fromJsonArrayToStringArray(jSONDataFormatted);
    }

    private JsonArray stringToJSONConverter(String jSONData) {
        JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(jSONData);

        return tradeElement.getAsJsonArray();
    }

    private JsonArray formatJSONArray(JsonArray nonFormattedJsonArray) {
        JsonArray formattedJsonArray = new JsonArray();

        for (JsonElement jsonElement : nonFormattedJsonArray) {
            JsonObject temporaryObject = jsonElement.getAsJsonObject();
            String type = typeCheck(temporaryObject);

            if (type.equals(FileType.CONFIGURATION.getFileType())){
                temporaryObject.addProperty(Common.TYPE.getCommonAttribute(),type);
                formattedJsonArray.add(temporaryObject);
            }else {
                if (type.equals(FileType.MIXED.getFileType())) {
                    JsonObject inertialJSON = buildMixedType(temporaryObject);
                    JsonObject environmentalJSON = buildMixedType(temporaryObject);
                    inertialJSON = addInertialProperties(inertialJSON, temporaryObject);
                    environmentalJSON = addEnvironmentalProperties(environmentalJSON, temporaryObject);
                    formattedJsonArray.add(inertialJSON);
                    formattedJsonArray.add(environmentalJSON);
                } else {
                    temporaryObject.addProperty(Common.TYPE.getCommonAttribute(), type);
                    formattedJsonArray.add(this.convertJSONFieldsToNumber(temporaryObject));
                }
            }
        }

        return formattedJsonArray;
    }

    private String typeCheck(JsonObject jsonObject) {
        boolean isInertial = Inertial.isInertialType(jsonObject);
        boolean isEnvironmental = Environmental.isEnvType(jsonObject);
        boolean isConfig = Config.isConfigType(jsonObject);

        if (isConfig){
            return FileType.CONFIGURATION.getFileType();
        }else {
            if (isEnvironmental && isInertial) {
                return FileType.MIXED.getFileType();
            } else {
                return isEnvironmental ? FileType.ENVIRONMENTAL.getFileType() : FileType.INERTIAL.getFileType();
            }
        }
    }

    private JsonObject buildMixedType(JsonObject jsonObject) {
        JsonObject mixedJSON = new JsonObject();

        mixedJSON.add(Common.TIME.getCommonAttribute(), jsonObject.get(Common.TIME.getCommonAttribute()));
        mixedJSON.add(Common.ID.getCommonAttribute(), jsonObject.get(Common.ID.getCommonAttribute()));
        mixedJSON.add(Common.GW_ID.getCommonAttribute(), jsonObject.get(Common.GW_ID.getCommonAttribute()));

        return mixedJSON;
    }

    private JsonObject addInertialProperties(JsonObject rootJson, JsonObject mixedJson) {
        JsonObject inertialJSON = rootJson;

        for (final Inertial inertial : Inertial.values()) {
            if (mixedJson.has(inertial.getInertialField())) {
                try {
                    inertialJSON.addProperty(inertial.getInertialField(), Float.parseFloat(mixedJson.get(inertial.getInertialField()).toString().replace("\"", "")));
                } catch (NumberFormatException e) {
                    inertialJSON.add(inertial.getInertialField(), mixedJson.get(inertial.getInertialField()));
                }
                //inertialJSON.add(inertial.getInertialField(), mixedJson.get(inertial.getInertialField()));
            }
        }

        inertialJSON.addProperty(Common.TYPE.getCommonAttribute(), FileType.INERTIAL.getFileType());

        return inertialJSON;
    }

    private JsonObject addEnvironmentalProperties(JsonObject rootJson, JsonObject mixedJson) {
        JsonObject environmentalJSON = rootJson;

        for (final Environmental environmental : Environmental.values()) {
            if (mixedJson.has(environmental.getEnvironmentalField())) {
                try {
                    environmentalJSON.addProperty(environmental.getEnvironmentalField(), Float.parseFloat(mixedJson.get(environmental.getEnvironmentalField()).toString().replace("\"", "")));
                } catch (NumberFormatException e) {
                    environmentalJSON.add(environmental.getEnvironmentalField(), mixedJson.get(environmental.getEnvironmentalField()));
                }
                //environmentalJSON.add(environmental.getEnvironmentalField(), mixedJson.get(environmental.getEnvironmentalField()));
            }
        }

        environmentalJSON.addProperty(Common.TYPE.getCommonAttribute(), FileType.ENVIRONMENTAL.getFileType());

        return environmentalJSON;
    }

    private String[] fromJsonArrayToStringArray(JsonArray jsonArray) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.get(i).toString());
        }
        return list.toArray(new String[0]);
    }

    private JsonObject convertJSONFieldsToNumber(JsonObject jSONWithStringFieldsForNumbers) {
        JsonObject formattedJsonObject = this.buildMixedType(jSONWithStringFieldsForNumbers);

        for (NumberField numField : NumberField.values()) {
            if (jSONWithStringFieldsForNumbers.has(numField.getNumberField())) {
                try {
                    formattedJsonObject.addProperty(numField.getNumberField(), Float.parseFloat(jSONWithStringFieldsForNumbers.get(numField.getNumberField()).toString().replace("\"", "")));
                } catch (NumberFormatException e) {
                    formattedJsonObject.add(numField.getNumberField(), jSONWithStringFieldsForNumbers.get(numField.getNumberField()));
                }
            }
        }

        formattedJsonObject.add(Common.TYPE.getCommonAttribute(), jSONWithStringFieldsForNumbers.get(Common.TYPE.getCommonAttribute()));

        return formattedJsonObject;
    }
}
