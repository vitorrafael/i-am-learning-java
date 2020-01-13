package com.vitorrafael.javamarathon.oop.enumerators.classes;

public enum ClientType {
    // Enumerators can be classes
    PRIVATE_INDIVIDUAL(1, "PI"), JURIDIC_ENTITY(2, "JE"){
        // Open the variant as a constructor and write the methods within it
        public String getId() {
            return "B";
        }
    };
    // Variant(Variables used to name it)
    // It's possible to use variables to enumerate the variants
    private int type;
    private String name;

    ClientType(int type, String name) {
        this.type =  type;
        this.name = name;
    }

    // Constant Specific Class Body -> Override methods in a variant
    public String getId() {
        return "A";
    }


    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
