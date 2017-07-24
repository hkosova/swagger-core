package io.swagger.jaxrs2.integration.listing;

import javax.servlet.ServletConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/openApi.{type:json|yaml}")
public class OpenApiListingResource extends BaseOpenApiListingResource {
    @Context
    ServletConfig config;

    @Context
    Application app;

    @GET
    @Produces({MediaType.APPLICATION_JSON, "application/yaml"})
    public Response getOpenApi( @Context HttpHeaders headers,
                                @Context UriInfo uriInfo,
                                @PathParam("type") String type) throws Exception {

        return super.getOpenApi(headers, config, app, uriInfo, type);
    }
}
