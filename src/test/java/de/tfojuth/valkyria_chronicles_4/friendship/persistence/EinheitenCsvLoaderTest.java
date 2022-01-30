package de.tfojuth.valkyria_chronicles_4.friendship.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EinheitenCsvLoaderTest {

    private EinheitenCsvLoader cut;

    @BeforeEach
    void setUp() {
        cut = new EinheitenCsvLoader();
    }

    @Test
    void soll_AlleEinheitenAusDemCSVLaden() {

        // when
        var result = cut.alle();
        // then
        System.out.println(result);
        assertEquals(11, result.anzahl());

    }
}