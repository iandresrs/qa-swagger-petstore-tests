package io.petstore.swagger.enums;

public enum Constant {

    PATH_FILE_EXCEL("src/test/resources/data/Data.xlsx"),
    NAME_SHEET_EXCEL("Post_Pet"),
    STRUCTURE_POST_PET("src/test/resources/template/post_pet.json"),
    CONTENT_TYPE_NAME("Content-Type"),
    CONTENT_TYPE_VALUE("application/json"),
    EXPECTED_PET_NAME_KEY("expectedPetName");

    private String constant;

    private Constant(String constant) {
        this.constant = constant;
    }

    public String getValue() {
        return constant;
    }

}
