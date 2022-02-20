package de.tfojuth.valkyria_chronicles_4.friendship;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
public class Truppengeschichten {

    private final Collection<Truppengeschichte> truppengeschichten;

    public Collection<Einheit> teilEinerTruppengeschichte() {
        return truppengeschichten.stream()
                .map(Truppengeschichte::beteiligteEinheiten)
                .flatMap(Collection::stream)
                .toList();
    }

    @Override
    public String toString() {
        return "Truppengeschichten (" + truppengeschichten.size() + "):\n" +
                "=================\n" +
                truppengeschichten.stream()
                        .map(Truppengeschichte::toString)
                        .map(line -> "\t" + line)
                        .collect(joining("\n"));
    }

}
