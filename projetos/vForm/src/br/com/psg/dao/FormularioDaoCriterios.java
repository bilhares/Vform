package br.com.psg.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.psg.function.RecuperaDados;
import br.com.psg.model.Formulario;

public class FormularioDaoCriterios extends RecuperaDados{

	private List<Formulario> formularios;
	private PreparedStatement stmt;	
	
	public FormularioDaoCriterios() {
		formularios = new ArrayList<Formulario>();
	}

	public List<Formulario> buscaPorIntervaloGraficoData(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal) {

		try {
			String sql = "select * from Formularios where NumGrafico"+
					 	" between ? and ? and Data between convert(date, ?, 103) "+
					 	"and convert(date, ?, 103)";		
			this.stmt = super.connect(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, dataInicial);
			this.stmt.setString(4, dataFinal);
			
			ResultSet rs = super.dao(this.stmt);
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
	
	public List<Formulario> buscaPorIntervaloGraficoDataProd(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal) {
		try {
			String sql = "select * from Formularios where " + 
						"NumGrafico between ? and ? and Data between ? and ?";		
			this.stmt = super.connectProd(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, dataInicial);
			this.stmt.setString(4, dataFinal);
			
			ResultSet rs = super.dao(this.stmt);	
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

	public List<Formulario> buscaPorIntervaloGraficoAgenfa(String graficoInicial, String graficoFinal, String agenfaInicial,
			String agenfaFinal) {

		try {
			String sql = "select * from Formularios where NumGrafico between ? and ? "+
						"and NumAgenfa between ? and ?";
			
			this.stmt = super.connect(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, agenfaInicial);
			this.stmt.setString(4, agenfaFinal);
			
			ResultSet rs = super.dao(this.stmt);
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
	
	public List<Formulario> buscaPorIntervaloGraficoAgenfaProd(String graficoInicial, String graficoFinal, String agenfaInicial,
			String agenfaFinal) {
		try {
			String sql = "select * from Formularios where " + 
						"NumGrafico between ? and ? and NumAgenfa between ? and ?";		
			this.stmt = super.connectProd(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, agenfaInicial);
			this.stmt.setString(4, agenfaFinal);
			
			ResultSet rs = super.dao(this.stmt);	
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
	
	public List<Formulario> buscaPorIntervaloGraficoTipoDoc(String graficoInicial, String graficoFinal, int tipoDoc) {

		try {
			String sql = "select * from Formularios where NumGrafico between ? and ? and TipoDocumento = ?";
			
			this.stmt = super.connect(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setInt(3, tipoDoc);
			
			ResultSet rs = super.dao(this.stmt);
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
	
	public List<Formulario> buscaPorIntervaloGraficoTipoDocProd(String graficoInicial, String graficoFinal, int tipoDoc) {
		try {
			String sql = "select * from Formularios where NumGrafico between ? and ? and TipoDocumento = ?";		
			this.stmt = super.connectProd(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setInt(3, tipoDoc);
			
			ResultSet rs = super.dao(this.stmt);	
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
	
	public List<Formulario> buscaIntervaloGraficoDataAgenfa(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal, String agenfaInicial, String agenfaFinal) {
		try {
			String sql = "  select * from Formularios where NumGrafico "+
					"between ? and ? and Data between convert(date, ?, 103) and"+
					" convert(date, ?, 103) and NumAgenfa between ? and ?";	
			this.stmt = super.connect(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, dataInicial);
			this.stmt.setString(4, dataFinal);
			this.stmt.setString(5, agenfaInicial);
			this.stmt.setString(6, agenfaFinal);
			
			ResultSet rs = super.dao(this.stmt);	
			formularios = super.getFormularios(rs);
			super.closeConnect();
			return formularios;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeConnect();
		}
		return formularios;

	}
	
	public List<Formulario> buscaPorIntervaloGraficoDataAgenfaProd(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal, String agenfaInicial, String agenfaFinal) {
		try {
			String sql = "select * from Formularios where " + 
						"NumGrafico between ? and ? and Data between ? and ? and NumAgenfa between ? and ?";
			
			this.stmt = super.connectProd(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, dataInicial);
			this.stmt.setString(4, dataFinal);
			this.stmt.setString(5, agenfaInicial);
			this.stmt.setString(6, agenfaFinal);
			
			ResultSet rs = super.dao(this.stmt);	
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
	
	public List<Formulario> buscaIntervaloGraficoDataTipoDoc(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal, int tipoDoc) {
		try {
			String sql = "select * from Formularios where NumGrafico "+
					"between ? and ? and Data between convert(date, ?, 103) and"+
					" convert(date, ?, 103) and TipoDocumento = ?";	
			this.stmt = super.connect(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, dataInicial);
			this.stmt.setString(4, dataFinal);
			this.stmt.setInt(5, tipoDoc);	
			
			ResultSet rs = super.dao(this.stmt);	
			formularios = super.getFormularios(rs);
			super.closeConnect();
			return formularios;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeConnect();
		}
		return formularios;

	}
	
	public List<Formulario> buscaIntervaloGraficoDataTipoDocProd(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal, int tipoDoc) {
		try {
			String sql = "select * from Formularios where " + 
						"NumGrafico between ? and ? and Data between ? and ? and TipoDocumento = ?";
			
			this.stmt = super.connectProd(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, dataInicial);
			this.stmt.setString(4, dataFinal);
			this.stmt.setInt(5, tipoDoc);
			
			ResultSet rs = super.dao(this.stmt);	
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
	
	public List<Formulario> buscaIntervaloGraficoAgenfaTipoDoc(String graficoInicial, String graficoFinal, String agenfaInicial,
			String agenfaFinal, int tipoDoc) {
		try {
			String sql = "select * from Formularios where NumGrafico "+
							"between ? and ? and NumAgenfa between ? and ?  and TipoDocumento = ?";	
			this.stmt = super.connect(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, agenfaInicial);
			this.stmt.setString(4, agenfaFinal);
			this.stmt.setInt(5, tipoDoc);	
			
			ResultSet rs = super.dao(this.stmt);	
			formularios = super.getFormularios(rs);
			super.closeConnect();
			return formularios;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeConnect();
		}
		return formularios;

	}
	
	public List<Formulario> buscaIntervaloGraficoAgenfaTipoDocProd(String graficoInicial, String graficoFinal, String agenfaInicial,
			String agenfaFinal, int tipoDoc) {
		try {
			String sql = "select * from Formularios where NumGrafico "+
							"between ? and ? and NumAgenfa between ? and ?  and TipoDocumento = ?";
			
			this.stmt = super.connectProd(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, agenfaInicial);
			this.stmt.setString(4, agenfaFinal);
			this.stmt.setInt(5, tipoDoc);
			
			ResultSet rs = super.dao(this.stmt);	
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
	
	public List<Formulario> buscaIntervaloGraficoDataAgenfaTipoDoc(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal, String agenfaInicial, String agenfaFinal, int tipoDoc) {
		try {
			String sql = "  select * from Formularios where NumGrafico "+
					"between ? and ? and Data between convert(date, ?, 103) and"+
					" convert(date, ?, 103) and NumAgenfa between ? and ? and TipoDocumento = ?";	
			this.stmt = super.connect(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, dataInicial);
			this.stmt.setString(4, dataFinal);
			this.stmt.setString(5, agenfaInicial);
			this.stmt.setString(6, agenfaFinal);
			this.stmt.setInt(7, tipoDoc);
			
			ResultSet rs = super.dao(this.stmt);	
			formularios = super.getFormularios(rs);
			super.closeConnect();
			return formularios;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeConnect();
		}
		return formularios;

	}
	
	public List<Formulario> buscaIntervaloGraficoDataAgenfaTipoDocProd(String graficoInicial, String graficoFinal, String dataInicial,
			String dataFinal, String agenfaInicial, String agenfaFinal, int tipoDoc) {
		try {
			String sql = "select * from Formularios where " + 
						"NumGrafico between ? and ? and Data between ? and ? and NumAgenfa between ? and ? and TipoDocumento = ?";
			
			this.stmt = super.connectProd(sql);
			this.stmt.setString(1, graficoInicial);
			this.stmt.setString(2, graficoFinal);
			this.stmt.setString(3, dataInicial);
			this.stmt.setString(4, dataFinal);
			this.stmt.setString(5, agenfaInicial);
			this.stmt.setString(6, agenfaFinal);
			this.stmt.setInt(7, tipoDoc);
			
			ResultSet rs = super.dao(this.stmt);	
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
	public static void main(String[] args) {
		FormularioDaoCriterios  d = new FormularioDaoCriterios();
		//System.out.println(d.buscaPorlogico("01270941729698", true).size());
	}	

}
