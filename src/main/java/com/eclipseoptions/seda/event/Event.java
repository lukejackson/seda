package com.eclipseoptions.seda.event;

import com.eclipseoptions.seda.stage.Stage;

/**
 * @author ljackson
 */
public interface Event<T> {
    Stage getSource();
    EventHeaders getHeaders();
    T extractPayload();
}
