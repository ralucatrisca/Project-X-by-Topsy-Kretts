package jsonfields;

/**
 * Created by ROL5CLJ on 18.07.2016.
 */
public enum FileType {
    MIXED("Mixed"),
    INERTIAL("Inertial"),
    ENVIRONMENTAL("Environmental"),
    CONFIGURATION("Configuration");

    private String fileType;

    FileType(final String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}
