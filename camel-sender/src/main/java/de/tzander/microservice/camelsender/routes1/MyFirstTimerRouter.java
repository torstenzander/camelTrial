package de.tzander.microservice.camelsender.routes1;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        for (int i = 0; i < 5; i++) {
            from("timer:first-timer?period=10000")
                    .threads(5)
                    .transform().constant("Schleife: " + i + " Zeit: " + LocalDateTime.now())
                    .to("log:first-timer");
        }
    }
}
