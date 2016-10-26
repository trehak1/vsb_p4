package cz.vsb.p4.testapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by ruz76 on 12.10.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CounterServiceTest {

    private static final String KEY = "test_key";
    private static final Integer INIT_VAL = 0;
    private CounterService counterService;
    @Mock
    private CounterDAO dao;

    @Before
    public void setup() {
        this.counterService = new CounterService(dao);
    }

    @Test
    public void shouldReturnInitValueOnFirstCall() {
        CounterValue value = counterService.getAndIncrement(KEY);
        Assert.assertEquals(INIT_VAL, value.getValue());
        Assert.assertEquals(KEY, value.getKey());
    }

    @Test
    public void shouldReturnInitPlusOneValueOnSecondCall() {
        Integer expectedValue = new Integer(INIT_VAL + 1);
        counterService.getAndIncrement(KEY);
        CounterValue value = counterService.getAndIncrement(KEY);
        Assert.assertEquals(expectedValue, value.getValue());
        Assert.assertEquals(KEY, value.getKey());
    }

}