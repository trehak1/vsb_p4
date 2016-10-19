package cz.vsb.p4.testapp;

import com.google.common.util.concurrent.AtomicLongMap;
import org.springframework.stereotype.Service;

/**
 * Created by trehak on 10.10.2016.
 */
@Service
public class CounterService {

    private final AtomicLongMap counter = AtomicLongMap.create();

    public CounterService() {
    }

    public void set(String key, long val) {
        counter.put(key, val);
    }

    public CounterValue getAndIncrement(String key) {
        return new CounterValue(key, counter.getAndIncrement(key));
    }

    public CounterValue get(String key) {
        return new CounterValue(key, counter.get(key));
    }
}
