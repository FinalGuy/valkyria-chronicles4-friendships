package de.tfojuth.valkyria_chronicles_4.friendship;

import java.util.Collection;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public final class Freundeskreis {

    private final Collection<Einheit> freunde = new TreeSet<>();

    public Freundeskreis(Collection<Einheit> initialeFreunde) {
        this.freunde.addAll(initialeFreunde);
    }

    public void fügeHinzu(Collection<Einheit> freunde) {
        this.freunde.addAll(freunde);
    }

    public boolean zähltDazu(Einheit einheit) {
        return freunde.contains(einheit);
    }

    @Override
    public String toString() {
        return "[" + freunde.stream().map(Einheit::name).collect(joining(",")) + "]";
    }
}
