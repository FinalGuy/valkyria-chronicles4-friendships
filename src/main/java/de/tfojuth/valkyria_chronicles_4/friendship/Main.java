package de.tfojuth.valkyria_chronicles_4.friendship;

import de.tfojuth.valkyria_chronicles_4.friendship.persistence.EinheitenCsvLoader;
import de.tfojuth.valkyria_chronicles_4.friendship.persistence.TruppengeschichtenCsvLoader;
import de.tfojuth.valkyria_chronicles_4.friendship.view.Konsolenausgabe;

import java.util.Collection;

public class Main {

    public static void main(String[] arguments) {
        Einheiten alleEinheiten = new EinheitenCsvLoader().alle();
        Freundeskreise freundeskreise = alleEinheiten.freundeskreise();
        EngeFreundeskreise engeFreundeskreise = alleEinheiten.engeFreundeskreise();
        var alleBekanntenTruppengeschichten = new TruppengeschichtenCsvLoader().alle();
        var vermuteteTruppengeschichten = new VermuteteTruppengeschichten(alleBekanntenTruppengeschichten, engeFreundeskreise);

        var konsolenausgabe = new Konsolenausgabe(
                alleEinheiten,
                freundeskreise,
                engeFreundeskreise,
                alleBekanntenTruppengeschichten,
                vermuteteTruppengeschichten
        );
        konsolenausgabe.anzeigen();
    }

}
