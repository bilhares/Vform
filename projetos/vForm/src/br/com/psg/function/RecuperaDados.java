package br.com.psg.function;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.psg.dao.AgenfaDao;
import br.com.psg.dao.Dao;
import br.com.psg.dao.LoteDao;
import br.com.psg.model.Agenfa;
import br.com.psg.model.Filme;
import br.com.psg.model.Formulario;
import br.com.psg.model.Lote;
import br.com.psg.model.TipoDocumento;

/**
 * 
 * @author mcandi
 *
 */
public class RecuperaDados extends Dao{

	private List<Formulario> formularios = new ArrayList<>();

	public Agenfa getAgenfa(ResultSet rs){
		Agenfa agenfa = new Agenfa();
		try {
			rs.next();
			agenfa.setAgenfa(rs.getInt("NumAgenfa"));
			agenfa.setAgenfaDescricao(rs.getString("NomeAgenfa"));
			super.closeConnect();
			return agenfa;
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			super.closeConnect();
		}
		return agenfa;		
	}

	public List<Formulario> getFormularios(ResultSet rs){
		
		try {
			while (rs.next()) {
				// Tipo Documento
				TipoDocumento tipoDoc = new TipoDocumento();
				tipoDoc.setTipo(rs.getString("TipoDocumento"));
				String descricaoTipo = tipoDoc.getDescricao(Integer.parseInt(tipoDoc.getTipo()));

				// Filme
				Filme filme = new Filme();
				filme.setFilme(rs.getInt("Filme"));
				String sitFilme = filme.getSituacao(rs.getInt("TipoFilme"));					
				
				//Agenfa
				AgenfaDao agenfaDao = new AgenfaDao();
				Agenfa agenfa = agenfaDao.obterDadosAgenfa(rs.getLong("NumAgenfa"));

				// Montagem Formulario
				Formulario form = new Formulario();
				form.setGrafico(rs.getString("NumGrafico"));
				form.setSituacao(form.obterSituacao(rs.getInt("TipoFormulario")));
				
				form.setTransmitido(form.obterTransmissao(rs.getInt("semTransmissao")));
								
				form.setTipo(tipoDoc.getTipo());
				form.setTipoDocumento(descricaoTipo);
				form.setnLogico(rs.getLong("NumLogico"));
				form.setAgenfa(rs.getLong("NumAgenfa"));
				form.setAgenfaDescricao(agenfa.getAgenfaDescricao());
				form.setData(rs.getString("Data"));
				form.setFilme(filme.getFilme());
				form.setFotograma(rs.getInt("Fotograma"));
				form.setSituacaoFilme(sitFilme);
				formularios.add(form);
				System.out.println("Formulario adicionado!");
			}			
			return formularios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formularios;

	}
	
	public List<Formulario> getFormulariosProd(ResultSet rs){			
		
		try {			
			while (rs.next()) {
				
				// Tipo Documento
				TipoDocumento tipoDoc = new TipoDocumento();
				tipoDoc.setTipo(rs.getString("TipoDocumento"));
				String descricaoTipo = tipoDoc.getDescricao(rs.getInt("TipoDocumento"));

				// Filme
				Filme filme = new Filme();
				filme.setFilme(rs.getInt("Filme"));
				String sitFilme = filme.getSituacao(rs.getInt("TipoFilme"));
				
				//Lote
				LoteDao loteDao = new LoteDao();
				Lote lote = loteDao.obterDadosLote(rs.getString("ID_Exportacao"));				
				
				//Agenfa
				AgenfaDao agenfaDao = new AgenfaDao();
				Agenfa agenfa = agenfaDao.obterDadosAgenfa(rs.getLong("NumAgenfa"));
				
				// Montagem Formulario
				Formulario form = new Formulario();

				form.setGrafico(rs.getString("NumGrafico"));
				form.setSituacao(form.obterSituacao(rs.getInt("TipoFormulario")));
				form.setTransmitido(form.obterTransmissao(rs.getInt("cancelarFisico")));
				form.setTipo(tipoDoc.getTipo());				
				form.setTipoDocumento(descricaoTipo);
				form.setnLogico(rs.getLong("NumLogico"));				
				form.setAgenfa(rs.getLong("NumAgenfa"));
				form.setAgenfaDescricao(agenfa.getAgenfaDescricao());
				form.setData(rs.getString("Data"));
				form.setFilme(filme.getFilme());
				form.setFotograma(rs.getInt("Fotograma"));
				form.setSituacaoFilme(sitFilme);
				form.setObservacao(rs.getString("Obs"));
				form.setLote(rs.getInt("ID_Exportacao"));
				form.setTipoLote(lote.obterTipoLote(Integer.parseInt(lote.getTipoLote())));
				form.setSituacaoLote(lote.obterSitLote(Integer.parseInt(lote.getSituacaoLote())));
				form.setPosicao(form.obterPosicao(rs.getInt("Posicao")));
				form.setMensagem(rs.getString("Mensagem"));
				formularios.add(form);
			}			
			return formularios;
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return formularios;
	}
	
}
