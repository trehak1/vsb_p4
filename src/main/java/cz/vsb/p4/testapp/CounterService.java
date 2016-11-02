package cz.vsb.p4.testapp;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AtomicLongMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by trehak on 10.10.2016.
 */
@Service
public class CounterService {

    private final AtomicLongMap<String> counter = AtomicLongMap.create();
    private final Map<String,Strom> strom = Maps.newHashMap();
    private final CounterDAO dao;

    @Autowired
    public CounterService(CounterDAO dao) {
        System.out.println("Created CounterService " + this);
        this.dao = dao;
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        Map<String, Long> vals = dao.loadKeyValues();
//        vals.entrySet().forEach(entry -> counter.put(entry.getKey(), entry.getValue()));
        for (Map.Entry<String, Long> entry : vals.entrySet()) {
            counter.put(entry.getKey(), entry.getValue());
        }
    }

    public void set(String key, long val) throws Exception {
        dao.storeKeyValue(key, val);
        counter.put(key, val);
    }

    public void setKvet(String key, String kvet) throws Exception {
        kvetmap.put(key, kvet);
    }

    public CounterValue getAndIncrement(String key) throws Exception {
        long val = counter.getAndIncrement(key);
        dao.storeKeyValue(key, val + 1);
        return new CounterValue(key, val, kvetmap.get(key));
    }

    public CounterValue get(String key) {
        return new CounterValue(key, counter.get(key), kvetmap.get(key));
    }

}
