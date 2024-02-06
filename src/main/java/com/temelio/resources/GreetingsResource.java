package com.temelio.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/greet")
public class GreetingsResource {
    @GET
    public String get() {
        return "Greetings";
    }
}
