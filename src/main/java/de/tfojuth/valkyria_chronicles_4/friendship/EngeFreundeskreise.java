package de.tfojuth.valkyria_chronicles_4.friendship;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class EngeFreundeskreise {

    private final Collection<Freundeskreis> engeFreundekreise = new HashSet<>();

    public void fügeHinzu(Freundeskreis engerFreundeskreis) {
        this.engeFreundekreise.add(engerFreundeskreis);
    }

    public Stream<Freundeskreis> alsStream(){
        return engeFreundekreise.stream();
    }

    @Override
    public String toString() {
        return "Enge Freundeskreise(" + engeFreundekreise.size() + "):\n" +
                "===================\n" +
                engeFreundekreise.stream()
                        .map(Freundeskreis::toString)
                        .map(line -> "\t" + line)
                        .collect(joining("\n"));
    }
}
