package br.udesc.ceavi.dsw.projetorestjpa.dao;

import br.udesc.ceavi.dsw.projetorestjpa.models.Produto;
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

@Path("produtos")
@Produces({"application/json"})
@Consumes({"application/json"})
public class ProdutosResource {

    @Context
    private UriInfo context;

    public ProdutosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Produto getProdutos() {
        System.out.println("get produtos...");
        Dao d = new Dao();
        return (Produto) d.lerId(Produto.class, 1);
    }

    @GET
    @JWTAutenticarTokenInterface
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idProduto}")
    public Produto getProduto(@PathParam("idProduto") String id) {
        System.out.println("get produto..." + id);
        Dao d = new Dao();
        return (Produto) d.lerId(Produto.class, Long.parseLong(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idProduto}")
    public Produto updateProduto(@PathParam("idProduto") String id, Produto produto) {
        produto.setID(Long.parseLong(id));
        System.out.println("" + id);
        System.out.println("PUT produto..." + produto.toString());
        Dao d = new Dao();
        d.updateId(Produto.class, Long.parseLong(id), produto);
        return produto;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idProduto}")
    public Produto deleteProduto(@PathParam("idProduto") String id) {
        System.out.println("DELETE produto..." + id);
        Dao d = new Dao();
        Produto produto = (Produto) d.deleteId(Produto.class, Long.parseLong(id));
        return produto;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Produto addProduto(Produto produto) {
        System.out.println("POST Produto: " + produto.toString());
        Dao d = new Dao();
        d.salvar(produto);
        return produto;
    }
}