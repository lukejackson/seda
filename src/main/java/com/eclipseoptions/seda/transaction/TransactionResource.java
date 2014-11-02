package com.eclipseoptions.seda.transaction;

/**
 * @author ljackson
 */
public interface TransactionResource {
    void postCommit();
    void postRollback();
}
