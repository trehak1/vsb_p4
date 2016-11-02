package cz.vsb.p4.testapp;

/**
 * Created by trehak on 10.10.2016.
 */
public class CounterValue {

    private final String key;
    private final Strom strom;

    public CounterValue(String key, Strom strom) {
        this.key = key;
        this.strom = strom;
    }


    public String getKey() {
        return key;
    }

    public Long getStrom() {
        return strom;
    }

}
