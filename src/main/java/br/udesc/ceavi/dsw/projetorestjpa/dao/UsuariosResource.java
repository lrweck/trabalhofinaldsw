package br.udesc.ceavi.dsw.projetorestjpa.dao;

import br.udesc.ceavi.dsw.projetorestjpa.models.Usuario;
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
@Path("usuarios")
@Produces({"application/json"})
@Consumes({"application/json"})
public class UsuariosResource {

    @Context
    private UriInfo uriInfo;

    public UsuariosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario getUsuarios() {
        System.out.println("get Usuarios...");
        Dao d = new Dao();
        return (Usuario) d.lerId(Usuario.class, 1);
    }

    @GET
    /* Para testar a autenticação, é necessário comentar o @ abaixo */
    @JWTAutenticarTokenInterface
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idUsuario}")
    public Usuario getUsuario(@PathParam("idUsuario") String id) {
        System.out.println("get usuario..." + id);
        Dao d = new Dao();
        return (Usuario) d.lerId(Usuario.class, Long.parseLong(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idUsuario}")
    public Usuario updateUsuario(@PathParam("idUsuario") String id, Usuario usuario) {
        usuario.setID(Long.parseLong(id));
        System.out.println("PUT usuario..." + usuario.toString());
        Dao d = new Dao();
        d.updateId(Usuario.class, Long.parseLong(id), usuario);
        return usuario;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idUsuario}")
    public Usuario deleteUsuario(@PathParam("idUsuario") String id) {
        System.out.println("DELETE usuario..." + id);
        Dao d = new Dao();
        Usuario usuario = (Usuario) d.deleteId(Usuario.class, Long.parseLong(id));
        return usuario;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario addUsuario(Usuario usuario) {
        System.out.println("POST Usuario: " + usuario.toString());
        Dao d = new Dao();
        d.salvar(usuario);
        return usuario;
    }
}
