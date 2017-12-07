package br.udesc.ceavi.dsw.projetorestjpa.services;

import br.udesc.ceavi.dsw.projetorestjpa.util.SimpleKeyGenerator;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.security.Key;
import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@JWTAutenticarTokenInterface
@Priority(Priorities.AUTHENTICATION)
public class JWTAutenticarTokenFilter implements ContainerRequestFilter {

    private SimpleKeyGenerator keyGenerator;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String autorizacaoHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        System.out.println("Header de Autorizacao: " + autorizacaoHeader);

        if (autorizacaoHeader == null || !autorizacaoHeader.startsWith("Bearer ")) {
            System.out.println("Cabecalho de autenticacao incorreto: " + autorizacaoHeader);
            throw new NotAuthorizedException("Erro: Cabeçalho de autorização não encontrado!");
        }

        String token = autorizacaoHeader.substring("Bearer".length()).trim();

        try {
            Key key = keyGenerator.generateKey();
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            System.out.println("TOKEN: " + token);
        } catch (Exception e) {
            System.out.println("TOKEN INVÁLIDO: " + token);
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

}