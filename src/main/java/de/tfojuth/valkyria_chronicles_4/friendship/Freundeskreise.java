package de.tfojuth.valkyria_chronicles_4.friendship;

import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.HashSet;

import static java.util.stream.Collectors.joining;

@Log4j2
public final class Freundeskreise {

    private final Collection<Freundeskreis> freundeskreise = new HashSet<>();

    public void neuerFreundeskreis(Freundeskreis neuerFreundeskreis) {
        log.debug("Füge neuen Freundeskreis hinzu: " + neuerFreundeskreis);
        freundeskreise
                .stream()
                .filter(f -> f.hatÜberschneidungMit(neuerFreundeskreis))
                .peek(f -> log.debug("Treffer für Freundeskreis: " + f))
                .findFirst()
                .ifPresentOrElse(
                        passenderFreundeskreis -> passenderFreundeskreis.fügeHinzu(neuerFreundeskreis),
                        () -> freundeskreise.add(neuerFreundeskreis)
                );
    }

    @Override
    public String toString() {
        return "Freundeskreise:\n" +
                freundeskreise.stream().map(Freundeskreis::toString).collect(joining("\n"));
    }
}
