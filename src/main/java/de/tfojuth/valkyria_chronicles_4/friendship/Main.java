package de.tfojuth.valkyria_chronicles_4.friendship;

import de.tfojuth.valkyria_chronicles_4.friendship.persistence.EinheitenCsvLoader;
import de.tfojuth.valkyria_chronicles_4.friendship.persistence.TruppengeschichtenCsvLoader;

import java.util.Collection;

public class Main {

    public static void main(String[] arguments) {
        Einheiten alleEinheiten = new EinheitenCsvLoader().alle();
        System.out.println(alleEinheiten + "\n");
        Freundeskreise freundeskreise = alleEinheiten.freundeskreise();
        System.out.println(freundeskreise + "\n");
        EngeFreundeskreise engeFreundeskreise = alleEinheiten.engeFreundeskreise();
        System.out.println(engeFreundeskreise + "\n");
        Truppengeschichten alleTruppengeschichten = new TruppengeschichtenCsvLoader().alle();
        System.out.println(alleTruppengeschichten);
    }

}
