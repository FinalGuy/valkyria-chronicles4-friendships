package de.tfojuth.valkyria_chronicles_4.friendship;

import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public class Truppengeschichte {

    private final Titel titel;
    private final Trio trio;

    public Collection<Einheit> beteiligteEinheiten(){
        return trio.alsListe();
    }

    @Override
    public String toString() {
        return titel + ": " + trio;
    }
}
