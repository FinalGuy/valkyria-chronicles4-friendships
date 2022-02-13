package de.tfojuth.valkyria_chronicles_4.friendship.persistence;

import de.tfojuth.valkyria_chronicles_4.friendship.Einheit;
import de.tfojuth.valkyria_chronicles_4.friendship.Titel;
import de.tfojuth.valkyria_chronicles_4.friendship.Trio;
import de.tfojuth.valkyria_chronicles_4.friendship.Truppengeschichte;

import java.util.Arrays;
import java.util.List;

public class TruppengeschichteCsvZeile {

    private final String titel;
    private final String protagonistenKonkateniert;

    public TruppengeschichteCsvZeile(String zeile) {
        String[] spalten = zeile.split(",");
        this.titel = spalten[0].trim();
        this.protagonistenKonkateniert = spalten[1];
    }

    public Truppengeschichte zuTruppengeschichte() {
        return new Truppengeschichte(titel(), trio());
    }

    private Titel titel() {
        return new Titel(titel);
    }

    private Trio trio() {
        List<Einheit> einheiten = Arrays.stream(protagonistenKonkateniert.split("\\+")).map(Einheit::new).toList();
        return Trio.ausListe(einheiten);
    }
}
