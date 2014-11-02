package com.eclipseoptions.seda.dispatch;

import com.eclipseoptions.seda.event.Event;
import com.eclipseoptions.seda.event.EventHandler;

/**
 * @author ljackson
 */
public class CallerRunsDispatcher implements Dispatcher {
    @Override
    public void dispatch(Event event, EventHandler eventHandler) {
        try {
            eventHandler.handleEvent(event);
        } catch (RuntimeException e) {
            // todo: log
        }
    }
}
