package cz.vsb.p4.testapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.MediaSize;

import static org.junit.Assert.*;

/**
 * Created by ruz76 on 2.11.2016.
 */
public class StromRepositoryTest {

    private static final String NAZEV = "Testovaci strom";
    private static final Strom STROM = new Strom(NAZEV);
    private StromRepository repository;

    @Before
    public void setup() {
        repository = new StromRepository();
    }

    @Test
    public void shouldSaveAndRetrieve() {
        repository.saveStrom(STROM);
        Strom strom = repository.getStrom(NAZEV);

        Assert.assertEquals(STROM, strom);
    }

    @Test
    public void shouldSaveAndDelete() {
        repository.saveStrom(STROM);
        repository.deleteStrom(NAZEV);
        Strom strom = repository.getStrom(NAZEV);
        Assert.assertNull(strom);
    }

    @Test
    public void shouldReplaceStrom() {
        repository.saveStrom(STROM);
        Strom retrieved = repository.getStrom(NAZEV);
        Assert.assertTrue(retrieved.vratFaze().isEmpty());
        Assert.assertEquals(STROM, retrieved);

        Strom strom2 = new Strom(NAZEV);
        strom2.pridejFazi(1, Faze.RASENI);
        repository.saveStrom(strom2);
        Strom retrieved2 = repository.getStrom(NAZEV);

        Assert.assertFalse(retrieved2.vratFaze().isEmpty());
        Assert.assertTrue(1 == retrieved2.dejCasFaze(Faze.RASENI));
        Assert.assertEquals(strom2, retrieved2);
    }


}