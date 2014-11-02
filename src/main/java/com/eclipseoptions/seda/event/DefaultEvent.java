package com.eclipseoptions.seda.event;

import com.eclipseoptions.seda.stage.Stage;

/**
 * @author ljackson
 */
public class DefaultEvent<T> implements Event<T> {
    private final Stage source;
    private final EventHeaders headers;
    private final T payload;

    public DefaultEvent(Stage source, EventHeaders headers, T payload) {
        this.source = source;
        this.headers = headers;
        this.payload = payload;
    }

    @Override
    public Stage getSource() {
        return source;
    }

    @Override
    public EventHeaders getHeaders() {
        return headers;
    }

    @Override
    public T extractPayload() {
        return payload;
    }
}
