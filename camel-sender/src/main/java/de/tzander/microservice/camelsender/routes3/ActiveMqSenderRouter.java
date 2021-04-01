package de.tzander.microservice.camelsender.routes3;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:active-mq-timer?period=1")
                .transform().constant("My message to ActiveMQ")
                .threads(10)
                .log("${body}")
                .to("activemq:my-activemq-queue");
    }
}
