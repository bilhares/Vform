package br.com.psg.model;

/**
 * 
 * @author mcandi
 *
 */
public class Colecao {	
	
	long numLogico;
	String numGrafico;
	String situacao;
	String transmitido;
	String tipo;		
	long numAgenfa;
	String descricaoAgenfa;
	String data;
    long numFilme;
    long numFotograma;
    String situacaoFilme;    	 
    String tipoLote;
    String posicao;
    String situacaoLote;
    String mensagem;  
    String observacao;
    int numLote;	
    String tipoDocumento;	
    
    public int getLote() {
		return numLote;
	}
	public void setLote(int lote) {
		this.numLote = lote;
	}
    public long getAgenfa() {
		return numAgenfa;
	}
	public void setAgenfa(long agenfa) {
		this.numAgenfa = agenfa;
	}
	public String getAgenfaDescricao() {
		return descricaoAgenfa;
	}
	public void setAgenfaDescricao(String agenfaDescricao) {
		this.descricaoAgenfa = agenfaDescricao;
	}
	public long getnLogico() {
		return numLogico;
	}
	public void setnLogico(long nLogico) {
		this.numLogico = nLogico;
	}
	public String getGrafico() {
		return numGrafico;
	}
	public void setGrafico(String grafico) {
		this.numGrafico = grafico;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getTransmitido() {
		return transmitido;
	}
	public void setTransmitido(String transmitido) {
		this.transmitido = transmitido;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getFilme() {
		return numFilme;
	}
	public void setFilme(long filme) {
		this.numFilme = filme;
	}
	public long getFotograma() {
		return numFotograma;
	}
	public void setFotograma(long fotograma) {
		this.numFotograma = fotograma;
	}
	public String getSituacaoFilme() {
		return situacaoFilme;
	}
	public void setSituacaoFilme(String situacaoFilme) {
		this.situacaoFilme = situacaoFilme;
	}	
	public String getTipoLote() {
		return tipoLote;
	}
	public void setTipoLote(String tipoLote) {
		this.tipoLote = tipoLote;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getSituacaoLote() {
		return situacaoLote;
	}
	public void setSituacaoLote(String situacaoLote) {
		this.situacaoLote = situacaoLote;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}	


}
