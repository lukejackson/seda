package com.eclipseoptions.seda.stage;

/**
 * @author ljackson
 */
public interface StageProvider {
    String getName();
    Stage getStage(String name);
}
