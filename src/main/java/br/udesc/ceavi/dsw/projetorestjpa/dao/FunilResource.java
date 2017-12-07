/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.projetorestjpa.dao;
import br.udesc.ceavi.dsw.projetorestjpa.models.Funil;
import br.udesc.ceavi.dsw.projetorestjpa.services.JWTAutenticarTokenInterface;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author luisr
 */
@Path("funil")
@Produces({"application/json"})
@Consumes({"application/json"})
public class FunilResource {
    
    @Context
    private UriInfo uriInfo;

    public FunilResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Funil getFunil() {
        System.out.println("get Funils...");
        Dao d = new Dao();
        return (Funil) d.lerId(Funil.class, 1);
    }

    @GET
    @JWTAutenticarTokenInterface
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idFunil}")
    public Funil getFunil(@PathParam("idFunil") String id) {
        System.out.println("get funil..." + id);
        Dao d = new Dao();
        return (Funil) d.lerId(Funil.class, Long.parseLong(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idFunil}")
    public Funil updateFunil(@PathParam("idFunil") String id, Funil funil) {
        funil.setID(Long.parseLong(id));
        System.out.println("" + id);
        System.out.println("PUT funil..." + funil.toString());
        Dao d = new Dao();
        d.updateId(Funil.class, Long.parseLong(id), funil);
        return funil;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idFunil}")
    public Funil deleteFunil(@PathParam("idFunil") String id) {
        System.out.println("DELETE funil..." + id);
        Dao d = new Dao();
        Funil funil = (Funil) d.deleteId(Funil.class, Long.parseLong(id));
        return funil;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Funil addFunil(Funil funil) {
        System.out.println("POST Funil: " + funil.toString());
        Dao d = new Dao();
        d.salvar(funil);
        return funil;
    }
    
}
