package br.com.psg.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.psg.controller.FormularioController;
import br.com.psg.model.Formulario;
import br.com.psg.model.FormularioBase;
import br.com.psg.model.RequestBody;

@Path("/formulario")
public class FormularioService {
	FormularioController controller = new FormularioController();
	
	
	@Path("/getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg() {
		List<FormularioBase> listRetorno = controller.getForms();
		return Response.status(200).entity(listRetorno).build();
	}

	@Path("/byGrafico")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByGrafico(RequestBody request) {
		String numGrafico  = request.grafico;
		String serie = request.serie;
		int prod  = request.isProducao;
		List<Formulario> listRetorno = controller.consultaNumGrafico(numGrafico, serie, prod);		
		return Response.status(200).entity(listRetorno).build();
	}
	

	@Path("/byLogico")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNumLogico(RequestBody request){
		String numLogico = request.logico;
		int prod = request.isProducao;
		List<Formulario>  formularios = controller.consultaNumLogico(numLogico, prod);
		return Response.status(200).entity(formularios).build();
	}
}
