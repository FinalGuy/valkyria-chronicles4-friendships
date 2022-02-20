package de.tfojuth.valkyria_chronicles_4.friendship.view;

import de.tfojuth.valkyria_chronicles_4.friendship.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Konsolenausgabe {

    private final Einheiten alleEinheiten;
    private final Freundeskreise freundeskreise;
    private final EngeFreundeskreise engeFreundeskreise;
    private final Truppengeschichten alleBekanntenTruppengeschichten;
    private final VermuteteTruppengeschichten vermuteteTruppengeschichten;

    public void anzeigen() {
        System.out.println(alleEinheiten);
        System.out.println("\n");
        System.out.println(freundeskreise);
        System.out.println("\n");
        System.out.println(engeFreundeskreise);
        System.out.println("\n");
        System.out.println(alleBekanntenTruppengeschichten);
        System.out.println("\n");
        System.out.println(vermuteteTruppengeschichten);
    }
}
