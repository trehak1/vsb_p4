package cz.vsb.p4.testapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by ruz76 on 12.10.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class RESTResourceTest {


    @Test
    public void shouldCallGetAndIncrementOnCounterService() {
        CounterService counterService = Mockito.mock(CounterService.class);

        RESTResource resource = new RESTResource(counterService);
        resource.getAndIncrementCounterValue();

        Mockito.verify(counterService, Mockito.times(1)).getAndIncrement();
        Mockito.verifyNoMoreInteractions(counterService);
    }

}