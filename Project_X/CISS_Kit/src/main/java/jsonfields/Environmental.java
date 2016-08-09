package jsonfields;

import com.google.gson.JsonObject;

/**
 * Created by ROL5CLJ on 18.07.2016.
 */
public enum Environmental {
    T("t"),
    RHW("rhw"),
    P("p"),
    L("l"),
    N("n");

    private String environmentalField;

    Environmental(final String environmentalField) {
        this.environmentalField = environmentalField;
    }

    public String getEnvironmentalField() {
        return environmentalField;
    }

    public static boolean isEnvType(JsonObject jsonObject) {
        boolean isEnvironmental = false;

        for (Environmental env : Environmental.values()) {
            if (jsonObject.has(env.getEnvironmentalField())) {
                isEnvironmental = true;
                break;
            }
        }

        return isEnvironmental;
    }
}


