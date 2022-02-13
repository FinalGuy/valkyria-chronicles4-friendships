package de.tfojuth.valkyria_chronicles_4.friendship;

import lombok.RequiredArgsConstructor;

import java.util.Collection;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
public class Truppengeschichten {

    private final Collection<Truppengeschichte> truppengeschichten;

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
