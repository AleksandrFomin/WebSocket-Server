package rest;

import database.DBOperations;
import database.User;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by sasha on 30.10.17.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class restservice {

    DBOperations dbOperations=new DBOperations();

    @GET
    @Path("/addUser")
    @Produces("text/plain")
    public String addUser() {
        dbOperations.addUser(new User("qwerty","12345"));
        return "Hello World";
    }
}
