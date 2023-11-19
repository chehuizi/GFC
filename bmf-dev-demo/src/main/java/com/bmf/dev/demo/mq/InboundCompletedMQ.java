package com.bmf.dev.demo.mq;


import com.bmf.dev.annotations.DomainEvent;

@DomainEvent(eventCode = 100010, eventAlias = "inbound_completed_event")
public class InboundCompletedMQ {
}
