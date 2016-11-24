package br.com.psg.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.psg.function.RecuperaDados;
import br.com.psg.model.Formulario;

public class FormularioDao extends RecuperaDados{

	private List<Formulario> formularios = new ArrayList<Formulario>();
	
	public List<Formulario> buscaPorGrafico(String grafico, String serie) {

		try {
			String sql = "select top 5 * from Formularios where NumGrafico = ? and serie = ?";		
			PreparedStatement stmt = super.connect(sql);
			stmt.setString(1, grafico);
			stmt.setString(2, serie);
			ResultSet rs = super.dao(stmt);
			formularios = super.getFormularios(rs);
			super.closeConnect();
			return formularios;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeConnect();
		}
		return null;

	}	

	public List<Formulario> buscaPorGraficoProd(String grafico) {
		try {
			String sql = "select top 5 * from Formularios where NumGrafico = ?";		
			PreparedStatement stmt = super.connectProd(sql);
			stmt.setString(1, grafico);			
			ResultSet rs = super.dao(stmt);	
			formularios = super.getFormulariosProd(rs);
			super.closeConnect();
			return formularios;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeConnect();
		}
		return formularios;

	}		

	public List<Formulario> buscaPorlogico(String numLogico, boolean prod){

		PreparedStatement stmt;
		try {
			String sql = "select top 5 * from Formularios where NumLogico = ?";	
			if(prod){
				stmt = super.connectProd(sql);
			}else{
				stmt = super.connect(sql);
			}				
			stmt.setString(1, numLogico);			
			ResultSet rs = super.dao(stmt);	
			if(prod){
				formularios = super.getFormulariosProd(rs);
			}else{
				formularios = super.getFormularios(rs);
			}
			super.closeConnect();
			return formularios;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeConnect();
		}
		return formularios;
	}
	
	public static void main(String[] args) {
		FormularioDao  d = new FormularioDao();
		System.out.println(d.buscaPorlogico("01270941729698", true).size());
	}	

}
