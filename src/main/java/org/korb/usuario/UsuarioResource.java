package org.korb.usuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @POST
    public Response create(UsuarioInputResouce usuarioInputResouce){
        try {
        usuarioService.create(usuarioInputResouce);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return Response.ok().build();
    }
}

