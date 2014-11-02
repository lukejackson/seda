package com.eclipseoptions.seda.dispatch;

import com.eclipseoptions.seda.event.Event;
import com.eclipseoptions.seda.event.EventHandler;
import com.eclipseoptions.seda.event.EventHeaders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ljackson
 */
public abstract class CodeBasedDispatcher implements Dispatcher {
    private final List<String> codeHeaderKeys;

    protected CodeBasedDispatcher(String... codeHeaderKeys) {
        this.codeHeaderKeys = new ArrayList<String>(Arrays.asList(codeHeaderKeys));
    }

    protected abstract <T> void dispatch(Event<T> event, String[] codes, EventHandler<T> handler);

    private List<String> extractValuesFromHeaders(EventHeaders eventHeaders) {
        List<String> headerCodes = new ArrayList<String>(codeHeaderKeys.size());

        for (String codeHeaderKey : codeHeaderKeys) {
            Object headerCode = eventHeaders.getHeader(codeHeaderKey);
            if (headerCode == null) {
                throw new IllegalArgumentException("Event headers " + eventHeaders + " does not contain header " + codeHeaderKey + " required for dispatching");
            }
            headerCodes.add(String.valueOf(headerCode));
        }

        return headerCodes;
    }

    @Override
    public void dispatch(Event event, EventHandler eventHandler) {
        dispatch(event, extractValuesFromHeaders(event.getHeaders()), eventHandler);
    }
}
