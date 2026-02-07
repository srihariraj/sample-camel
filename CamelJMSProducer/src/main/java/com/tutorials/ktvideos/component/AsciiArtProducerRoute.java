package com.tutorials.ktvideos.component;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AsciiArtProducerRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:sendToQueue")
				.to("jms:queue:ascii.message.queue");
    }
}
