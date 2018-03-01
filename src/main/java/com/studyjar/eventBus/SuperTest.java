package com.studyjar.eventBus;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;

import java.util.List;

/**
 * Created by mj on 2017/12/27.
 *
 */
public class SuperTest {

    private List<Integer> events = Lists.newArrayList();

    @Subscribe
    public void testSuperTest(Integer integer){
        System.out.println(integer);
        events.add(integer);
    }

}
