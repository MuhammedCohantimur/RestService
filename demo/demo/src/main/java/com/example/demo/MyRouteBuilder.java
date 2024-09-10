package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // REST konfigurasyonu
        restConfiguration().component("netty-http").host("localhost").port(8080);

        // REST endpoint tanımı
        rest("/api")
                .get("/hello")
                .to("direct:hello");

        // İşleme rotası
        from("direct:hello")
                .setBody(constant("Hello, World!"));

    }
}