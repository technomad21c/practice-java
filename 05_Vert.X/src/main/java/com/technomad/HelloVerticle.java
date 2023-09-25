package com.technomad;

import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class HelloVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloVerticle.class);

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new HelloVerticle());
    }

    @Override
    public void start(Promise<Void> future) {
        LOGGER.info("Welcome to Vertx");
    }

    @Override
    public void stop() {
        LOGGER.info("Shutting down application");
    }
}
