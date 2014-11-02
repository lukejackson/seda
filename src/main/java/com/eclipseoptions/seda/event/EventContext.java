package com.eclipseoptions.seda.event;

/**
 * Thread local context
 *
 * @author ljackson
 */
public interface EventContext {
    void reply(String requestId, Object response);
    void publish(Object event);
}
