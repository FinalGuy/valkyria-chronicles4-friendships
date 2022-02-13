package de.tfojuth.valkyria_chronicles_4.friendship.persistence;

import de.tfojuth.valkyria_chronicles_4.friendship.Truppengeschichten;
import de.tfojuth.valkyria_chronicles_4.friendship.TruppengeschichtenLaden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class TruppengeschichtenCsvLoader implements TruppengeschichtenLaden {

    private static final String FILE = "Truppengeschichten.csv";

    @Override
    public Truppengeschichten alle() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(csvStream()))) {
            return new Truppengeschichten(bufferedReader
                    .lines()
                    .map(TruppengeschichteCsvZeile::new)
                    .map(TruppengeschichteCsvZeile::zuTruppengeschichte)
                    .toList());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    // TODO: Common code can be extracted ...
    private InputStream csvStream() {
        InputStream csvStream = getSystemResourceAsStream(FILE);
        if (csvStream == null) {
            throw new IllegalStateException("Konnte CSV Datei " + FILE + " nicht finden bzw. öffnen");
        }
        return csvStream;
    }
}
