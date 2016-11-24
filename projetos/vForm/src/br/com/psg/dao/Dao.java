package br.com.psg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.psg.factory.ConnectionFactory;

/**
 * 
 * @author mcandi
 *
 */
public class Dao {	
	
	private Connection connectionProd;
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet rs;
	

	/**
	 * Conexão com a base UGDM
	 * @param sql
	 * @return
	 */
	public PreparedStatement connectProd(String sql) {
		try {
			connectionProd = new ConnectionFactory().getConnectionProducao();
			return connectionProd.prepareStatement(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return stmt;	
	}
	
	/**
	 * Conexao com base UGDM_Preparacao 
	 * @param sql
	 * @return
	 */
	public PreparedStatement connect(String sql) {
		try {
			connection = new ConnectionFactory().getConnection();
			return connection.prepareStatement(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return stmt;
	}
	
	/**
	 * Executa uma query no DB
	 * @param stmt1
	 * @return
	 */
	public ResultSet dao(PreparedStatement stmt1){			
		try {
			stmt = stmt1;			
			rs = stmt.executeQuery();	
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;		
	}
	
	/**
	 * Fecha conexões abertas com o DB
	 */
 	public void closeConnect(){
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
