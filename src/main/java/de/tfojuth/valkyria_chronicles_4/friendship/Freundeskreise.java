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

        var freundeskreiseOhneÜberschneidungen = freundeskreise
                .stream()
                .filter(f -> f.hatKeineÜberschneidungMit(neuerFreundeskreis))
                .toList();

        var neuerKombinierterFreundeskreis = freundeskreise
                .stream()
                .filter(f -> f.hatÜberschneidungMit(neuerFreundeskreis))
                .reduce(neuerFreundeskreis, Freundeskreis::fügeHinzu);

        freundeskreise.clear();
        freundeskreise.addAll(freundeskreiseOhneÜberschneidungen);
        freundeskreise.add(neuerKombinierterFreundeskreis);
        log.debug(freundeskreise);
    }

    @Override
    public String toString() {
        return "Freundeskreise(" + freundeskreise.size() + "):\n " +
                "===============\n" +
                freundeskreise.stream()
                        .map(Freundeskreis::toString)
                        .map(line -> "\t" + line)
                        .collect(joining("\n"));
    }
}
