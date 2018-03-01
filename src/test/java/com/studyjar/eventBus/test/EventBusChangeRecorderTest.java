package com.studyjar.eventBus.test;

import com.google.common.eventbus.EventBus;
import com.studyjar.eventBus.EventBusChangeRecoder;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by mj on 2017/12/27.
 */
public class EventBusChangeRecorderTest extends TestCase {

    private static final String EVENT = "Hello";
    private static final String BUS_IDENTIFIER = "test-bus";

    private EventBus bus;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        bus = new EventBus(BUS_IDENTIFIER);
    }

    public void testBasicCatcherDistribution(){
        EventBusChangeRecoder recoder = new EventBusChangeRecoder();
        bus.register(recoder);
        bus.post(EVENT);

        List<String> events = recoder.getEvents();
        assertEquals("Only one event should be delivered.", 1, events.size());
        assertEquals("Correct string should be delivered.", EVENT, events.get(0));
    }

    public void testSubscribe(){
        EventBusChangeRecoder recoder = new EventBusChangeRecoder();
        bus.register(recoder);
        bus.post(12);
    }


}
