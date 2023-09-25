package com.technomad.rest;

import com.technomad.model.Article;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class RestServiceVerticle  extends AbstractVerticle {
    @Override
    public void start(Promise<Void> future) {

        Router router = Router.router(vertx);
        router.get("/api/baeldung/articles/article/:id")
                .handler(this::getArticles);

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8888)
                .onSuccess(server -> {
                    startPromise.complete();
                    System.out.println("HTTP server started on port " + server.actualPort());
                })
                .onFailure(event -> {
                    startPromise.fail(event);
                    System.out.println("Failed to start HTTP server:" + event.getMessage());
                });
    }

    private void getArticles(RoutingContext routingContext) {
        String articleId = routingContext.request()
                .getParam("id");
        Article article = new Article(articleId, "This is an intro to vertx", "baeldung", "01-02-2017", 1578);

        routingContext.response()
                .putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end(Json.encodePrettily(article));
    }
}
