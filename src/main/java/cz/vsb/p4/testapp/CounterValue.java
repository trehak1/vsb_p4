package cz.vsb.p4.testapp;

/**
 * Created by trehak on 10.10.2016.
 */
public class CounterValue {

    private final String key;
    private final Long value;

    public CounterValue(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }

}
