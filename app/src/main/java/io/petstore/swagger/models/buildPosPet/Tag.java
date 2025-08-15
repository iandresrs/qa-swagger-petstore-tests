package io.petstore.swagger.models.buildPosPet;

public class Tag {

    private Long id;
    private String name;

    public Tag() {
    }

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("\n    {\n    \"id\": %s,\n    \"name\": \"%s\"\n    } \n", id, name);
    }

}
