package cz.vsb.p4.testapp;

import com.google.common.util.concurrent.AtomicLongMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by trehak on 10.10.2016.
 */
@Service
public class CounterService {

    private final AtomicLongMap<String> counter = AtomicLongMap.create();

    public CounterService() {
        System.out.println("Created CounterService " + this);
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
