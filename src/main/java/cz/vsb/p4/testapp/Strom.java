package cz.vsb.p4.testapp;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by ruz76 on 2.11.2016.
 */
public class Strom {

    private String nazev;
    private Map<Integer, Faze> faze = Maps.newHashMap();

    public Strom(String nazev) {
        this.nazev = nazev;
    }

    public void pridejFazi(Integer kdy, Faze faze) {
        this.faze.put(kdy, faze);
    }

    public void odstranFazi(Integer kdy) {
        this.faze.remove(kdy);
    }

    public Map<Integer, Faze> vratFaze() {
        return faze;
    }


}
