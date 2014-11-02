package com.eclipseoptions.seda.event;

/**
 * @author ljackson
 */
public interface SourceStatusListener {
    void statusChanged(SourceStatus previousStatus, SourceStatus newStatus);
}
