package com.eclipseoptions.seda.event;

import com.eclipseoptions.seda.stage.Stage;
import com.eclipseoptions.seda.transaction.Transaction;

/**
 * @author ljackson
 */
public interface EventContext {
    Stage getStage();

    String getDispatchCode();

    Event getEvent();

    Transaction getTransaction();
}
