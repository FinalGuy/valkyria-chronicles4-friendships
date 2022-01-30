package de.tfojuth.valkyria_chronicles_4.friendship;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class Einheiten {

    private final Map<Einheit, Collection<Einheit>> einheitZuFreunden = new HashMap<>();

    public Einheiten(Map<Einheit, Collection<Einheit>> einheitZuFreunden) {
        this.einheitZuFreunden.putAll(einheitZuFreunden);
    }

    public Freundeskreise freundeskreise() {
        Freundeskreise freundeskreise = new Freundeskreise();
        einheitZuFreunden.forEach((einheit, freunde) -> {
            Freundeskreis freundeskreis = freundeskreise.freundeskreisVon(einheit);
            freundeskreis.fügeHinzu(freunde);
        });
        return freundeskreise;
    }

    public int anzahl() {
        return einheitZuFreunden.size();
    }

    @Override
    public String toString() {
        return "Einheiten:\n" +
                einheitZuFreunden.entrySet()
                        .parallelStream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(this::zeileProEinheit)
                        .collect(joining("\n"));
    }

    private String zeileProEinheit(Map.Entry<Einheit, Collection<Einheit>> entry) {
        return "\t" + entry.getKey().name() + " -> " + entry.getValue().stream().map(Einheit::name).collect(joining(","));
    }
}
