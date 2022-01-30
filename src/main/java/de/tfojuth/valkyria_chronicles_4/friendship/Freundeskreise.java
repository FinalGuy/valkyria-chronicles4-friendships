package de.tfojuth.valkyria_chronicles_4.friendship;

import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import static java.util.stream.Collectors.joining;

@Log4j2
public final class Freundeskreise {

    private final Collection<Freundeskreis> freundeskreise = new HashSet<>();

    public Freundeskreis freundeskreisVon(Einheit einheit) {
        return freundeskreise
                .stream()
                .filter(f -> f.zähltDazu(einheit))
                .peek(System.out::println)
                .findFirst()
                .orElseGet(() -> neuerFreundeskreisBeginnendMit(einheit)); // side effect here!
    }

    private Freundeskreis neuerFreundeskreisBeginnendMit(Einheit einheit) {
        log.info("erstelle neuen Freundeskreis für " + einheit);
        var neuerFreundeskreis = new Freundeskreis(Collections.singleton(einheit));
        freundeskreise.add(neuerFreundeskreis);
        return neuerFreundeskreis;
    }

    @Override
    public String toString() {
        return "Freundeskreise:\n" +
                freundeskreise.stream().map(Freundeskreis::toString).collect(joining("\n"));
    }
}
