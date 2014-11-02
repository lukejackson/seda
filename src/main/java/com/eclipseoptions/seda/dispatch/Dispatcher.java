package com.eclipseoptions.seda.dispatch;

import com.eclipseoptions.seda.event.Event;
import com.eclipseoptions.seda.event.EventHandler;

/**
 * @author ljackson
 */
public interface Dispatcher {
    void dispatch(Event event, EventHandler eventHandler);
}
