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

    public void fügeHinzu(Freundeskreis andererFreundeskreis) {
        log.debug("integriere Freundeskreis: " + andererFreundeskreis);
        this.freunde.addAll(andererFreundeskreis.freunde);
        log.debug("Ergebnis der Integration :" + this);
    }

    public void fügeHinzu(Einheit freund) {
        log.debug("integriere Freund: " + freund);
        this.freunde.add(freund);
        log.debug("Ergebnis der Integration: " + this);
    }

    @Override
    public String toString() {
        return "[" + freunde.stream().map(Einheit::name).collect(joining(",")) + "]";
    }

    public boolean hatÜberschneidungMit(Freundeskreis andererFreundeskreis) {
        log.debug("prüfe auf Überschneidungen: " + this + " | " + andererFreundeskreis);
        boolean result = !disjoint(freunde, andererFreundeskreis.freunde);
        log.debug("Überschneidung gefunden: " + result);
        return result;
    }
}
