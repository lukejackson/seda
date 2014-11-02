package com.eclipseoptions.seda.stage;

import com.eclipseoptions.seda.event.Event;

/**
 * @author ljackson
 */
public interface Stage {
    StageProvider getProvider();
    String getName();
    <T> void send(Event<T> event);
}

/*

e.g.

Stage oms = defaultStageProvider.getStage("oms");

oms.send(new ClientOrderCancelRequest(orderTag));

Stage sender = request.getSender();

-or-

Stage sender = omsClientStageProvider.getStage(order.getReplyTo());

sender.send(new ClientOrderCancelResponse(true, "OK; order cancelled"));

orderBus.publish(new Order(orderTag, BuySell.Buy, 400, Market.HKSE, "5", 80));

 */
