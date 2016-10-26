package cz.vsb.p4.testapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;

/**
 * Created by ruz76 on 12.10.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class RESTResourceTest {


    private static final String KEY = "test-key";

    @Test
    public void shouldCallGetAndIncrementOnCounterService() throws Exception {
        CounterService counterService = Mockito.mock(CounterService.class);

        RESTResource resource = new RESTResource(counterService);
        resource.getAndIncrementCounterValue(KEY);

        Mockito.verify(counterService, Mockito.times(1)).getAndIncrement(eq(KEY));
        Mockito.verifyNoMoreInteractions(counterService);
    }

}