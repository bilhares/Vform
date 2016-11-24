package br.com.psg.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.psg.function.RecuperaDados;
import br.com.psg.model.Agenfa;

public class AgenfaDao extends RecuperaDados {	
	
	/**
	 * Busca Agenfa na base de dados de produção
	 * @param numAgenfa
	 * @return
	 */
	public Agenfa obterDadosAgenfa(Long numAgenfa){
		
		try {
			String sql = "select * from Agenfas where NumAgenfa = ?";
			PreparedStatement stmt = super.connectProd(sql);
			stmt.setLong(1, numAgenfa);
			ResultSet rs = super.dao(stmt);		
			return super.getAgenfa(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}	
	
	public static void main(String[] args) {
		AgenfaDao a  = new AgenfaDao();
		System.out.println("Nome:"+a.obterDadosAgenfa(90607805L).getAgenfaDescricao());
	}
}
