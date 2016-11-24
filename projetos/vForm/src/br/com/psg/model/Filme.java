package br.com.psg.model;

public class Filme extends Colecao {
	
	public String getSituacao(int nFilme) {
		switch (nFilme) {
		case 0:
			this.setSituacao("NORMAL");
			break;
		case 1:
			this.setSituacao("CANCELADO");
			break;
		default:
			this.setSituacao("INDEFINIDO");
			break;
		}
		return situacao;
	}	
	
	
}
