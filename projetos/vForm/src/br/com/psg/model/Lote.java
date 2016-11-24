package br.com.psg.model;

public class Lote extends Colecao{	
	

	// Obtem a situação do lote a partir do camppo conferido
	// TODO: criar tabela no banco para essas situações
	public String obterSitLote(int sitLote) {
		String situacao;
		switch (sitLote) {
		case 0:
			situacao = "A CONFERIR";
			break;
		case 1:
			situacao = "CONFERIDO";
			break;
		case 2:
			situacao = "EM CONFERENCIA";
			break;
		case 3:
			situacao = "";
			break;
		case 4:
			situacao = "EXCLUIDO";
			break;
		default:
			situacao = "A CONFERIR";
			break;
		}
		return situacao;
	}

	public String obterTipoLote(int tipoLote) {
		String tipo;
		switch (tipoLote) {
		case 0:
			tipo = "NORMAL";
			break;
		case 1:
			tipo = "CANCELADO";
			break;

		default:
			tipo = "INDEFINIDO";
			break;
		}
		return tipo;
	}
}
