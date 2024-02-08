package com.temelio.resources;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Api()
@Path("/")
public class HelloWorldResource {
    @GET
    public String get() {
        return "Hello World";
    }
}
