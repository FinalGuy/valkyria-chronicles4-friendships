package de.tfojuth.valkyria_chronicles_4.friendship;

import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.TreeSet;

import static java.util.Collections.disjoint;
import static java.util.stream.Collectors.joining;

@Log4j2
public final class Freundeskreis {

    private final Collection<Einheit> freunde = new TreeSet<>();

    public Freundeskreis(Collection<Einheit> initialeFreunde) {
        this.freunde.addAll(initialeFreunde);
    }

    public Freundeskreis fügeHinzu(Freundeskreis andererFreundeskreis) {
        this.freunde.addAll(andererFreundeskreis.freunde);
        return this;
    }

    public Freundeskreis fügeHinzu(Einheit freund) {
        this.freunde.add(freund);
        return this;
    }

    public boolean hatÜberschneidungMit(Freundeskreis andererFreundeskreis) {
        return !disjoint(freunde, andererFreundeskreis.freunde);
    }

    public boolean hatKeineÜberschneidungMit(Freundeskreis freundeskreis) {
        return !hatÜberschneidungMit(freundeskreis);
    }

    @Override
    public String toString() {
        return "[" + freunde.stream().map(Einheit::name).collect(joining(",")) + "]" + "(" + freunde.size() + ")";
    }
}
