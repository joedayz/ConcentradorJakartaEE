package pe.farmaciasperuanas.concentrador.controller;

import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;


@RequestScoped
@Path("/todos")
public class TodoResource {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(
            value = {
                @APIResponse(
                        responseCode = "404",
                        description = "We could not find the Hello message ",
                        content = @Content(mediaType = "text/plain"))
                ,
        @APIResponse(
                        responseCode = "200",
                        description = "We found the Hello message",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Properties.class)))})
    @Operation(summary = "Outputs Hello Message",
            description = "This method outputs Hello message")
    public Response sayHello() {
        return Response.ok("Hello").build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get Todo by id",
        description = "This method gets a single todo by id")
    @APIResponse(responseCode = "200", description = "Everything went ok, we found TODO by id")    
    @APIResponse(responseCode = "404", description = "Todo not found")
    public Response getTodoById(@Parameter(description = "Get a specific Todo by id", required = true) @PathParam("id") Long id) {
        return Response.ok("").build();
    }

}
