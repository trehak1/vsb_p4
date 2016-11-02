package cz.vsb.p4.testapp;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by ruz76 on 2.11.2016.
 */
@Service
public class StromRepository {

    private final Map<String, Strom> stromy = Maps.newHashMap();

    public Strom getStrom(String nazev) {
        return stromy.get(nazev);
    }

    public void deleteStrom(String nazev) {
        stromy.remove(nazev);
    }

    public void saveStrom(Strom strom) {
        stromy.put(strom.getNazev(), strom);
    }

    public Map<String, Strom> getAll() {
        return stromy;
    }
}
