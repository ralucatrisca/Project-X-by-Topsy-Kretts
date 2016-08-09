package jsonfields;

import com.google.gson.JsonObject;

/**
 * Created by ROL5CLJ on 27.07.2016.
 */
public enum Config {
    LINE("line"),
    FACTORY("factory"),
    MACHINE("machine_id");

    private String configField;

    Config(final String configField) {
        this.configField = configField;
    }

    public String getConfigField() {
        return configField;
    }

    public static boolean isConfigType(JsonObject jsonObject) {
        boolean isConfig = false;

        for (Config conf : Config.values()) {
            if (jsonObject.has(conf.getConfigField())) {
                isConfig = true;
                break;
            }
        }

        return isConfig;
    }
}
