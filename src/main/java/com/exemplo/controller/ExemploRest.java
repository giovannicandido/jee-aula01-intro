package com.exemplo.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.exemplo.domain.Pessoa;

@Path("/pessoa")
public class ExemploRest {
    @Context UriInfo ui;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> helloWorld() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Fulano", 20));
        pessoas.add(new Pessoa("Ciclano", 34));
        return pessoas;
    }

    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response addPessoa(Pessoa pessoa) {
		//  return service.insertPessoa(pessoa);

        UriBuilder ub = ui.getRequestUriBuilder();
        URI widgetURI = ub
            .path(ExemploRest.class, "getPessoa")
            .build(1);
      return Response.created(widgetURI).build();
		
	}
	
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa  getPessoa(@PathParam("id") int id) throws SQLException {
		// return service.getPessoaById(id);
      return new Pessoa("fulano", 20);
		
	}
	

	
	@Path("/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Pessoa updatePessoa(@PathParam("id") int id, Pessoa pessoa) {
		//  return service.update(id, pessoa);
      return pessoa;
		
	}
	
	@Path("/{id}")
	@DELETE
	public int deletePessoa(@PathParam("id") int id) {
		// return service.deletetPessoa(id);
      return 1;
		
	}
}
