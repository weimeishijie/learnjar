package com.studyjar.eventBus;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;

import java.util.List;

/**
 * Created by mj on 2017/12/27.
 * 事件总线变化记录仪
 */
public class EventBusChangeRecoder extends SuperTest {

    private List<String> events = Lists.newArrayList();
    private List<Integer> event = Lists.newArrayList();

    @Subscribe
    public void recordCustomerChange(String string){
        if(string.equals("")){
            return;
        }
        System.out.println(string);
        events.add(string);
    }

    @Subscribe
    public void testSubscribe(Integer i){
        System.out.println(i);
        event.add(i);
    }

    public List<String> getEvents(){
        return events;
    }

}
