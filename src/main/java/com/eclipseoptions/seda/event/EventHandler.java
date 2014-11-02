package com.eclipseoptions.seda.event;

/**
 * @author ljackson
 */
public interface EventHandler<T> {
    void handleEvent(Event<T> event);
    // todo: health status (of servers for clients)
}
