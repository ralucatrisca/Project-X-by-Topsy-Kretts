package jsonfields;

/**
 * Created by ROL5CLJ on 20.07.2016.
 */
public enum Common {
    TIME("time"),
    ID("id"),
    GW_ID("gw_id"),
    TYPE("type");

    private String commonAttribute;

    Common(final String commonAttribute){this.commonAttribute=commonAttribute;}

    public String getCommonAttribute(){return commonAttribute;}
}
