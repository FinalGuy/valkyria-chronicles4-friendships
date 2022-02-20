package de.tfojuth.valkyria_chronicles_4.friendship;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
public class Trio {

    private final Einheit eins;
    private final Einheit zwei;
    private final Einheit drei;

    public static Trio ausListe(List<Einheit> einheiten) {
        if (einheiten.size() != 3) {
            throw new IllegalArgumentException("Erwartete Einheitenliste mit exakt drei Einheiten. Erhielt: " + einheiten);
        }
        return new Trio(einheiten.get(0), einheiten.get(1), einheiten.get(2));
    }

    public List<Einheit> alsListe() {
        return List.of(eins, zwei, drei);
    }

    @Override
    public String toString() {
        return "[" + Stream.of(eins, zwei, drei).map(Einheit::name).collect(joining(",")) + "]";
    }
}
