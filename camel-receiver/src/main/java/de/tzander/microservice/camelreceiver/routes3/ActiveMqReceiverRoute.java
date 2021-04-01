package de.tzander.microservice.camelreceiver.routes3;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ActiveMqReceiverRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
                .transform().constant("Zeit: " + LocalDateTime.now())
                .to("log:received-message-from-atvicemq");
    }
}
