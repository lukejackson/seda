package com.eclipseoptions.seda.dispatch;

import com.eclipseoptions.seda.event.Event;
import com.eclipseoptions.seda.event.EventHandler;

/**
 * @author ljackson
 */
public class HawtDispatcher extends CodeBasedDispatcher {

    @Override
    protected <T> void dispatch(Event<T> event, String[] codes, EventHandler<T> handler) {

    }
}
