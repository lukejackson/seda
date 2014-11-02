package com.eclipseoptions.seda.event;

import com.eclipseoptions.seda.stage.Stage;

/**
 * @author ljackson
 */
public interface EventBus<T> {
    void publish(Event<T> event);

    // todo: subscription classifiers?
    void subscribe(Stage stage);
    void unsubscribe(Stage stage);
}
