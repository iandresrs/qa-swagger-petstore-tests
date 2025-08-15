package io.petstore.swagger.enums;

public enum Actors {

    ACTOR("pet");

    private String nameActor;

    private Actors(String nameActor) {
        this.nameActor = nameActor;
    }

    public String getNameActor() {
        return nameActor;
    }

}
