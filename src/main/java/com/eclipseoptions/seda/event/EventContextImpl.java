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

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public String getDispatchCode() {
        return dispatchCode;
    }

    @Override
    public Event getEvent() {
        return event;
    }

    @Override
    public Transaction getTransaction() {
        return transaction;
    }
}
