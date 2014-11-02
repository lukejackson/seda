package com.eclipseoptions.seda.stage;

import com.eclipseoptions.seda.dispatch.Dispatcher;
import com.eclipseoptions.seda.event.Event;
import com.eclipseoptions.seda.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljackson
 */
public class DefaultStage implements Stage {
    private static final Logger logger = LoggerFactory.getLogger(DefaultStage.class);

    private final StageProvider provider;
    private final String name;
    private final Dispatcher dispatcher;
    private final Map<Class<?>, EventHandler<?>> handlers;

    public DefaultStage(StageProvider provider, String name, Dispatcher dispatcher, Map<Class<?>, EventHandler<?>> handlers) {
        this.provider = provider;
        this.name = name;
        this.dispatcher = dispatcher;
        this.handlers = new HashMap<Class<?>, EventHandler<?>>(handlers);
    }

    @Override
    public StageProvider getProvider() {
        return provider;
    }

    @Override
    public String getName() {
        return name;
    }

    @SuppressWarnings("unchecked")
    private <T> EventHandler<T> lookupMessageHandler(T payload) {
        return (EventHandler<T>)handlers.get(payload.getClass());
    }

    @Override
    public <T> void send(final Event<T> event) {
        // todo: assume in transaction, or check and add resource?
        dispatcher.dispatch(event, new EventHandler<T>() {
            @Override
            public void handleEvent(Event<T> event) {
                T payload = event.extractPayload();
                EventHandler<T> handler = lookupMessageHandler(payload);
                if (handler == null) {
                    logger.warn("No handler registered for payload type {}, ignoring. Message: {}", payload.getClass(), event);
                    return;
                }
                try {
                    handler.handleEvent(event);
                } catch (RuntimeException e) {
                    logger.error("Unhandled exception handling message {}", e);
                }
            }
        });
    }
}
