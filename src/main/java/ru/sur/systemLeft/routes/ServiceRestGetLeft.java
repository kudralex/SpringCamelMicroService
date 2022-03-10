package ru.sur.systemLeft.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceRestGetLeft extends RouteBuilder {
    private final static String ENDPOINTGET = "rest:get:/sLeft/test";


    @Value("${service.rest.host}")
    private String host;

    @Value("${service.rest.port}")
    private Integer port;

    @Value("${service.rest.context_path}")
    private String context_path;

    @Override
    public void configure() throws Exception {
        restConfiguration().component("netty4-http").host(host).port(port).contextPath(context_path);
        from(ENDPOINTGET).routeId(this.getClass().getSimpleName())
                .setBody(constant("Hello world get sLeft"))
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .log("log test");



    }
}
