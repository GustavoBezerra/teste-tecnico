package br.com.projeto.controllers;

import br.com.projeto.dao.ProjetoDAO;
import br.com.projeto.modelo.Projeto;
import br.com.projeto.validador.ProjetoValidador;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date 01/08/2017
 * Controller responsável pelo tratamento das requisições referentes aos projetos
 */
@Path("/projeto")
public class ProjetoController {

    private JSONObject json = new JSONObject();
    private ProjetoValidador projetoValidador = new ProjetoValidador();

    /**
     * Método responsável por recuperar todos os projetos cadastrados
     * @return 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjetos() {
        ProjetoDAO projetoDAO = new ProjetoDAO();
        List<Projeto> projetos = projetoDAO.consultar();
        json.put("projetos", new Gson().toJson(projetos));
        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }

    /**
     * Método responsável por recuperar um projeto específico
     * @param id ID do projeto a ser pesquisado
     * @return Projeto referente ao ID passado
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjeto(@PathParam("id") int id) {
        ProjetoDAO projetoDAO = new ProjetoDAO();

        Projeto projeto = projetoDAO.consultar(id);
        json.put("projeto", new Gson().toJson(projeto));
        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response novoProjeto(String conteudo) {
        Gson gson = new Gson();
        Projeto projeto = gson.fromJson(conteudo, Projeto.class);
        List<String> violacoes = projetoValidador.validar(projeto);
        Response.Status status;
        if (violacoes.isEmpty()) {
            ProjetoDAO projetoDAO = new ProjetoDAO();
            projetoDAO.salvar(projeto);
            json.put("projeto", new Gson().toJson(projeto));
            status = Response.Status.OK;
        } else{
            json.put("erros", new Gson().toJson(violacoes));
            status = Response.Status.BAD_REQUEST;
        }
        return Response.status(status).entity(json.toString()).build();
    }
}
