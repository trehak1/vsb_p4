package cz.vsb.p4.testapp;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by ruz76 on 26.10.2016.
 */
@Service
public class CounterDAO {

    public CounterDAO() {

    }

    /**
     * Store key value to database
     * @param key key name
     * @param value key value
     */
    public void storeKeyValue(String key, long value) {

    }

    /**
     * Load all key values from database to memory
     * @return map of key -> value
     */
    public Map<String, Long> loadKeyValues() {

    }

}
