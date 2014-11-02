package com.eclipseoptions.seda.transaction;

/**
 * @author ljackson
 */
public class TransactionResourceAdapter implements TransactionResource {
    @Override
    public void postCommit() {}

    @Override
    public void postRollback() {}
}
