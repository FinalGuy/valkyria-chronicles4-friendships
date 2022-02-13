package de.tfojuth.valkyria_chronicles_4.friendship;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Truppengeschichte {

    private final Titel titel;
    private final Trio trio;

    @Override
    public String toString() {
        return titel + ": " + trio;
    }
}
