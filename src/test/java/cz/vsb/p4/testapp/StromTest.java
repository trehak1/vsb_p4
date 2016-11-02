package cz.vsb.p4.testapp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ruz76 on 2.11.2016.
 */
public class StromTest {

    private static final String NAZEV = "testovaci strom";
    private static final Integer DEN_FAZE = 123;

    @Test
    public void shouldSetName() {
        Strom strom = new Strom(NAZEV);
        Assert.assertEquals(NAZEV, strom.getNazev());
    }

    @Test
    public void shouldAddFaze() {
        Strom strom = new Strom(NAZEV);
        strom.pridejFazi(DEN_FAZE, Faze.RASENI);
        Assert.assertEquals(Faze.RASENI, strom.vratFaze().get(DEN_FAZE));
    }

}