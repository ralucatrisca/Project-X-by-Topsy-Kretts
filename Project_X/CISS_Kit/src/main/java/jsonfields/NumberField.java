package jsonfields;

/**
 * Created by ROL5CLJ on 26.07.2016.
 */
public enum NumberField{
    AX("ax"),
    AY("ay"),
    AZ("az"),
    GX("gx"),
    GY("gy"),
    GZ("gz"),
    MX("mx"),
    MY("my"),
    MZ("mz"),
    T("t"),
    RHW("rhw"),
    P("p"),
    L("l"),
    N("n");

    private String numberField;

    NumberField(final String environmentalField) {
        this.numberField = environmentalField;
    }

    public String getNumberField() {
        return numberField;
    }
}
