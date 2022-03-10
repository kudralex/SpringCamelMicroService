package ru.sur.systemRight.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceRestPostRight extends RouteBuilder {

    private final static String ENDPOINTPOST = "rest:post:/sRight/test";

    @Value("${service.rest.host}")
    private String host;

    @Value("${service.rest.port}")
    private Integer port;

    @Value("${service.rest.context_path}")
    private String context_path;

    @Override
    public void configure() throws Exception {

        restConfiguration().component("netty4-http").host(host).port(port).contextPath(context_path);
        from(ENDPOINTPOST).routeId(this.getClass().getSimpleName())
                .setBody(constant("Hello world post sRight"))
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
    }
}
