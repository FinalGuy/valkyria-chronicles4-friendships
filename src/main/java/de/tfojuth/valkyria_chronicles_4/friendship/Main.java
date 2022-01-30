package de.tfojuth.valkyria_chronicles_4.friendship;

import de.tfojuth.valkyria_chronicles_4.friendship.persistence.EinheitenCsvLoader;

public class Main {

    public static void main(String[] arguments) {
        Einheiten alleEinheiten = new EinheitenCsvLoader().alle();
        System.out.println(alleEinheiten + "\n");
        Freundeskreise freundeskreise = alleEinheiten.freundeskreise();
        System.out.println(freundeskreise);
    }

}
