package br.com.psg.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.psg.dao.FormularioDao;
import br.com.psg.dao.FormularioDaoCriterios;
import br.com.psg.model.Formulario;
import br.com.psg.model.FormularioBase;

public class FormularioControllerCriterios {
	
	private List<Formulario> listaFormularios;
	FormularioDaoCriterios dao;
	
	public FormularioControllerCriterios() {
		this.dao = new FormularioDaoCriterios();		
	}
	
	public List<Formulario> consultaIntervaloGraficoData(String graficoInicial, String graficoFinal, int prod,
			String dataInicial, String dataFinal) {
		listaFormularios = new ArrayList<>();
		if (prod == 1) {
			listaFormularios = dao.buscaPorIntervaloGraficoDataProd(graficoInicial, graficoFinal, dataInicial, dataFinal);		
		} else {
			listaFormularios = dao.buscaPorIntervaloGraficoData(graficoInicial, graficoFinal, dataInicial, dataFinal);
		}
		return listaFormularios;
	}
	
	public List<Formulario> consultaIntervaloGraficoAgenfa(String graficoInicial, String graficoFinal, int prod,
			String agenfaInicial, String agenfaFinal) {
		listaFormularios = new ArrayList<>();
		if (prod == 1) {
			listaFormularios = dao.buscaPorIntervaloGraficoAgenfaProd(graficoInicial, graficoFinal, agenfaInicial, agenfaFinal);		
		} else {
			listaFormularios = dao.buscaPorIntervaloGraficoAgenfa(graficoInicial, graficoFinal, agenfaInicial, agenfaFinal);
		}
		return listaFormularios;
	}
	
	public List<Formulario> consultaIntervaloGraficoTipoDoc(String graficoInicial, String graficoFinal, int prod,
			int tipoDoc) {
		listaFormularios = new ArrayList<>();
		if (prod == 1) {
			listaFormularios = dao.buscaPorIntervaloGraficoTipoDocProd(graficoInicial, graficoFinal, tipoDoc);				
		} else {
			listaFormularios = dao.buscaPorIntervaloGraficoTipoDoc(graficoInicial, graficoFinal, tipoDoc);	
		}
		return listaFormularios;
	}
	
	public List<Formulario> consultaIntervaloGraficoDataAgenfa(String graficoInicial, String graficoFinal, int prod,
			String dataInicial, String dataFinal,String agenfaInicial, String agenfaFinal){
		listaFormularios = new ArrayList<>();
		if (prod == 1) {
			listaFormularios = this.dao.buscaPorIntervaloGraficoDataAgenfaProd(graficoInicial, graficoFinal, dataInicial, dataFinal, agenfaInicial, agenfaFinal);
		} else {
			listaFormularios = this.dao.buscaIntervaloGraficoDataAgenfa(graficoInicial, graficoFinal, dataInicial, dataFinal, agenfaInicial, agenfaFinal);
		}
		return listaFormularios;
	}
	
	public List<Formulario> consultaIntervaloGraficoDataTipoDoc(String graficoInicial, String graficoFinal, int prod,
			String dataInicial, String dataFinal,int tipoDoc){
		listaFormularios = new ArrayList<>();
		if (prod == 1) {
			listaFormularios = this.dao.buscaIntervaloGraficoDataTipoDocProd(graficoInicial, graficoFinal, dataInicial, dataFinal, tipoDoc);
		} else {
			listaFormularios = this.dao.buscaIntervaloGraficoDataTipoDoc(graficoInicial, graficoFinal, dataInicial, dataFinal, tipoDoc);
		}
		return listaFormularios;
	}
	
	public List<Formulario> consultaIntervaloGraficoAgenfaTipoDoc(String graficoInicial, String graficoFinal, int prod,
			String agenfaInicial, String agenfaFinal,int tipoDoc){
		listaFormularios = new ArrayList<>();
		if (prod == 1) {
			listaFormularios = this.dao.buscaIntervaloGraficoAgenfaTipoDocProd(graficoInicial, graficoFinal, agenfaInicial, agenfaFinal, tipoDoc);
		} else {
			listaFormularios = this.dao.buscaIntervaloGraficoAgenfaTipoDoc(graficoInicial, graficoFinal, agenfaInicial, agenfaFinal, tipoDoc);
		}
		return listaFormularios;
	}
	public List<Formulario> consultaIntervaloGraficoDataAgenfaTipoDoc(String graficoInicial, String graficoFinal, int prod,
			String dataInicial, String dataFinal,String agenfaInicial, String agenfaFinal, int tipoDoc){
		listaFormularios = new ArrayList<>();
		if (prod == 1) {
			listaFormularios = this.dao.buscaIntervaloGraficoDataAgenfaTipoDocProd(graficoInicial, graficoFinal, dataInicial, dataFinal, agenfaInicial, agenfaFinal, tipoDoc);
		} else {
			listaFormularios = this.dao.buscaIntervaloGraficoDataTipoDoc(graficoInicial, graficoFinal, dataInicial, dataFinal, tipoDoc);
		}
		return listaFormularios;
	}
}
