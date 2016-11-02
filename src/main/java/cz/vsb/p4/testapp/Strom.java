package cz.vsb.p4.testapp;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by ruz76 on 2.11.2016.
 */
public class Strom {

    private String nazev;
    private Map<Faze, Integer> faze = Maps.newHashMap();

    public Strom(String nazev) {
        this.nazev = nazev;
    }

    public void pridejFazi(Integer kdy, Faze faze) {
        this.faze.put(faze, kdy);
    }

    public void odstranFazi(Faze faze) {
        this.faze.remove(faze);
    }

    public Map<Faze, Integer> vratFaze() {
        return faze;
    }

    public String getNazev() {
        return nazev;
    }
}
