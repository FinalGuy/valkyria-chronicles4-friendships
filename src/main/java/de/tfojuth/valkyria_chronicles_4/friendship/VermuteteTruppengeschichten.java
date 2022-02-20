package de.tfojuth.valkyria_chronicles_4.friendship;

import java.util.Collection;
import java.util.HashSet;

import static java.util.stream.Collectors.joining;

public class VermuteteTruppengeschichten {

    private final Collection<Freundeskreis> vermuteteTruppengeschichten = new HashSet<>();

    public VermuteteTruppengeschichten(Truppengeschichten bereitsBekannteTruppengeschichten,
                                       EngeFreundeskreise engeFreundeskreise) {
        var einheitenBereitsTeilEinerTruppengeschichte = bereitsBekannteTruppengeschichten
                .teilEinerTruppengeschichte();
        engeFreundeskreise
                .alsStream()
                .filter(freundeskreis -> freundeskreis.enthältNiemandenAus(einheitenBereitsTeilEinerTruppengeschichte))
                .filter(freundeskreis -> freundeskreis.anzahlEinheitenBeträgtMindestens(3))
                .forEach(vermuteteTruppengeschichten::add);
    }

    @Override
    public String toString() {
        return "Vermute weitere Truppengeschichten in folgenden engen Freundeskreisen(" + vermuteteTruppengeschichten.size() + "):\n" +
                "====================================================================\n" +
                vermuteteTruppengeschichten.stream()
                        .map(Freundeskreis::toString)
                        .map(line -> "\t" + line)
                        .collect(joining("\n"));
    }
}
