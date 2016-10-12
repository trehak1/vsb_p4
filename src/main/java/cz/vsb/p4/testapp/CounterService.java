package cz.vsb.p4.testapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by trehak on 10.10.2016.
 */
@Service
public class CounterService {

    private final AtomicInteger counter = new AtomicInteger(0);

    public CounterService(@Value("${counter.init.value}") int initialValue) {
        counter.set(initialValue);
    }

    public CounterValue getAndIncrement() {
        return new CounterValue(counter.getAndIncrement());
    }
}
