package cz.vsb.p4.testapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.MediaSize;

import static org.junit.Assert.*;

/**
 * Created by ruz76 on 2.11.2016.
 */
public class StromTest {

    private static final String NAZEV = "testovaci strom";
    private static final Integer DEN_FAZE = 123;
    private Strom strom;

    @Before
    public void setup() {
        strom = new Strom(NAZEV);
    }

    @Test
    public void shouldSetName() {
        Assert.assertEquals(NAZEV, strom.getNazev());
    }

    @Test
    public void shouldAddFaze() {
        strom.pridejFazi(DEN_FAZE, Faze.RASENI);
        Assert.assertEquals(DEN_FAZE, strom.dejCasFaze(Faze.RASENI));
    }

    @Test
    public void shouldRemoveFaze() {
        strom.pridejFazi(DEN_FAZE, Faze.RASENI);
        strom.odstranFazi(Faze.RASENI);
        Assert.assertTrue(strom.vratFaze().isEmpty());
    }

}