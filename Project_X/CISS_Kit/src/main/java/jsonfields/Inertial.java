package jsonfields;

import com.google.gson.JsonObject;

/**
 * Created by ROL5CLJ on 18.07.2016.
 */
public enum Inertial {
    AX("ax"),
    AY("ay"),
    AZ("az"),
    GX("gx"),
    GY("gy"),
    GZ("gz"),
    MX("mx"),
    MY("my"),
    MZ("mz");

    private String inertialField;

    Inertial(final String inertialField) {
        this.inertialField = inertialField;
    }

    public String getInertialField() {
        return inertialField;
    }

    public static boolean isInertialType(JsonObject jsonObject) {
        boolean isInertial = false;

        for (Inertial ine : Inertial.values()) {
            if (jsonObject.has(ine.getInertialField())) {
                isInertial = true;
                break;
            }
        }

        return isInertial;
    }
}
