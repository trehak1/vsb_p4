package cz.vsb.p4.testapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by ruz76 on 12.10.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CounterServiceTest {

    private static final String KEY = "test_key";
    private static final Long INIT_VAL = 0L;
    private CounterService counterService;
    @Mock
    private CounterDAO dao;

    @Before
    public void setup() {
        this.counterService = new CounterService(dao);
    }

    @Test
    public void shouldReturnInitValueOnFirstCall() throws Exception {
        CounterValue value = counterService.getAndIncrement(KEY);

        verify(dao, times(1)).storeKeyValue(KEY, INIT_VAL);
        verifyNoMoreInteractions(dao);

        Assert.assertEquals(INIT_VAL, value.getValue());
        Assert.assertEquals(KEY, value.getKey());
    }

    @Test
    public void shouldReturnInitPlusOneValueOnSecondCall() throws Exception {
        Long expectedValue = new Long(INIT_VAL + 1);
        counterService.getAndIncrement(KEY);
        CounterValue value = counterService.getAndIncrement(KEY);

        verify(dao, times(1)).storeKeyValue(KEY, INIT_VAL);
        verify(dao, times(1)).storeKeyValue(KEY, INIT_VAL + 1);
        verifyNoMoreInteractions(dao);

        Assert.assertEquals(expectedValue, value.getValue());
        Assert.assertEquals(KEY, value.getKey());
    }

}