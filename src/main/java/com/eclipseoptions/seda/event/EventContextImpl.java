package com.eclipseoptions.seda.event;

import com.eclipseoptions.seda.stage.Stage;
import com.eclipseoptions.seda.transaction.Transaction;
import com.eclipseoptions.seda.transaction.TransactionResourceAdapter;

/**
 * @author ljackson
 */
public class EventContextImpl implements EventContext {
    private final Stage stage;
    private final String dispatchCode;
    private final Event event;
    private final Transaction transaction;

    public EventContextImpl(Stage stage, String dispatchCode, Event event, Transaction transaction) {
        this.stage = stage;
        this.dispatchCode = dispatchCode;
        this.event = event;
        this.transaction = transaction;
    }

    public Stage getStage() {
        return stage;
    }

    public String getDispatchCode() {
        return dispatchCode;
    }

    public Event getEvent() {
        return event;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public <T> void reply(final T payload) {
        // todo: move addition of txn resource to stage.send()
        final Stage source = event.getSource();
        if (source == null) {
            throw new IllegalStateException("Cannot reply to event with no source. Event: " + event + ", reply: " + payload);
        }
        transaction.addResource(new TransactionResourceAdapter() {
            @Override
            public void postCommit() {
                // todo: generate headers from payload
                source.send(new DefaultEvent<Object>(stage, null, payload));
            }
        });
    }

    @Override
    // todo: lookup event bus internally to avoid exposing to business logic?
    public <T> void publish(final EventBus<T> eventBus, final T payload) {
        transaction.addResource(new TransactionResourceAdapter() {
            @Override
            public void postCommit() {
                // todo: generate headers from payload
                eventBus.publish(new DefaultEvent<T>(null, null, payload));
            }
        });
    }
}
