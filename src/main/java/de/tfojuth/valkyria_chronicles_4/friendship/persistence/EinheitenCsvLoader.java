package de.tfojuth.valkyria_chronicles_4.friendship.persistence;

import de.tfojuth.valkyria_chronicles_4.friendship.Einheiten;
import de.tfojuth.valkyria_chronicles_4.friendship.EinheitenLaden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static java.util.stream.Collectors.toMap;

public class EinheitenCsvLoader implements EinheitenLaden {

    private static final String FILE = "friendships.csv";

    @Override
    public Einheiten alle() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(csvStream()))) {
            return new Einheiten(bufferedReader
                    .lines()
                    .map(EinheitCsvZeile::new)
                    .collect(toMap(EinheitCsvZeile::einheit, EinheitCsvZeile::freunde))
            );
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private InputStream csvStream() {
        InputStream csvStream = getSystemResourceAsStream(FILE);
        if (csvStream == null) {
            throw new IllegalStateException("Konnte CSV Datei " + FILE + " nicht finden bzw. öffnen");
        }
        return csvStream;
    }
}
