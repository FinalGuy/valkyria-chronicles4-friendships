package de.tfojuth.valkyria_chronicles_4.friendship;

import de.tfojuth.valkyria_chronicles_4.friendship.persistence.EinheitenCsvLoader;

public class Main {

    public static void main(String[] arguments) {
        Freundeskreise freundeskreise = new EinheitenCsvLoader().alle().freundeskreise();
        System.out.println(freundeskreise);
    }

}
