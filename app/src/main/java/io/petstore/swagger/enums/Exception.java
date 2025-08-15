package io.petstore.swagger.enums;

public enum Exception {

    STATUS_CODE_ERROR("The service response code is not as expected."),
    ERROR_PET_NAME_MISMATCH("The pet name in the response does not match the expected name"),
    JSON_TEMPLATE_READ_ERROR("Error reading JSON template from path '%s'. \" +\r\n" +
            "                        \"Possible causes: file not found, insufficient permissions, or invalid format.\"");

    private String exceptionText;

    private Exception(String exceptionText) {
        this.exceptionText = exceptionText;
    }

    public String getExceptionText() {
        return exceptionText;
    }

}
