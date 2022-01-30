package de.tfojuth.valkyria_chronicles_4.friendship;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public final class Einheit implements Comparable<Einheit> {

    private final String name;

    public Einheit(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public int compareTo(Einheit andereEinheit) {
        return this.name.compareTo(andereEinheit.name);
    }

    public boolean istBefreundedMit(Einheit einheit) {
        return false;
    }
}
