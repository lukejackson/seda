package com.eclipseoptions.seda.transaction;

/**
 * @author ljackson
 */
public interface Transaction {
    void addResource(TransactionResource resource);
    void commit();
    void rollback();
}
