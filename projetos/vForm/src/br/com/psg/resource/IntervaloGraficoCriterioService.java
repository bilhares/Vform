package br.com.psg.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.psg.controller.FormularioControllerCriterios;
import br.com.psg.model.Formulario;
import br.com.psg.model.RequestBody;

@Path("/intervaloGCriterio")
public class IntervaloGraficoCriterioService {
	private FormularioControllerCriterios controller;
	private List<Formulario> listRetorno;

	public IntervaloGraficoCriterioService() {
		controller = new FormularioControllerCriterios();
	}

	@Path("/byIntervaloGraficoData")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIntervaloGraficoData(RequestBody request){
		this.listRetorno = this.controller.consultaIntervaloGraficoData(request.graficoInicial,
				request.graficoFinal, request.isProducao, request.dataInicial, request.dataFinal);
		return Response.status(200).entity(listRetorno).build();
	}
	
	@Path("/byIntervaloGraficoDataAgenfa")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIntervaloGraficoDataAgenfa(RequestBody request){
		this.listRetorno = this.controller.consultaIntervaloGraficoDataAgenfa(request.graficoInicial,
				request.graficoFinal, request.isProducao, request.dataInicial, request.dataFinal, request.agenfaInicial, request.agenfaFinal);
		return Response.status(200).entity(listRetorno).build();
	}	
}
