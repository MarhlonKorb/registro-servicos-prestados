package org.korb.cliente;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {
    private final ClienteRepository clienteRepository;

    public ClienteResource(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GET
    public List<Cliente> list() {
        return clienteRepository.listAll();
    }

    @POST
    @Transactional
    public Response create(ClienteDto cliente) {
        clienteRepository.persist(ClienteDto.convertToEntity(cliente));
        return Response.ok()
                .status(Response.Status.CREATED)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id")Long id) {
        Cliente entity = clienteRepository.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        clienteRepository.delete(entity);
        return Response.status(Response.Status.OK).build();
    }
}

