package de.tfojuth.valkyria_chronicles_4.friendship;

public final class Titel {

    private final String value;

    public Titel(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "'" + value + "'";
    }
}
