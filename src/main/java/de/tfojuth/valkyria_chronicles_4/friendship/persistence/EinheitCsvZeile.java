package de.tfojuth.valkyria_chronicles_4.friendship.persistence;

import de.tfojuth.valkyria_chronicles_4.friendship.Einheit;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;

import static java.util.Arrays.stream;
import static java.util.Collections.emptySet;

public class EinheitCsvZeile {

    private final String name;
    private final String freundeKonkateniert;

    public EinheitCsvZeile(String zeile) {
        String[] spalten = zeile.split(",");
        this.name = spalten[0].trim();
        this.freundeKonkateniert = spalten.length > 1 ? spalten[1] : "";
    }

    public Einheit einheit() {
        return new Einheit(name);
    }

    public Collection<Einheit> freunde() {
        if (StringUtils.isBlank(freundeKonkateniert)) {
            return emptySet();
        }
        return stream(freundeKonkateniert.split("\\+"))
                .map(Einheit::new)
                .toList();
    }
}
