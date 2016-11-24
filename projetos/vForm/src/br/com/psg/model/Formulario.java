package br.com.psg.model;


public class Formulario extends Colecao {
		
	public String obterSituacao(int codSit){
		String situacao;
		switch (codSit) {
		case 0:
			situacao = "NORMAL";
			break;
		case 1:
			situacao = "CANCELADO";
			break;
		default:
			situacao = "INDEFINIDO";
			break;
		}	
		return situacao;
	}
	public String obterTransmissao(int codTransmissao){
		String transmissao;
		switch (codTransmissao) {
		case 0:
			transmissao = "SIM";
			break;
		case 1:
			transmissao = "N�O";
			break;
		default:
			transmissao = "INDEFINIDO";
			break;
		}
		return transmissao;
	}
	public String obterPosicao(int codPosicao){
		String posicao;
		switch (codPosicao) {
		case 0:
			posicao = "EM CONFER�NCIA";
			break;
		case 1:
			posicao = "TRANSMITIDO";
			break;
		case 2:
			posicao = "REJEITADO MAINFRAME";
			break;
		case 3:
			posicao = "AGUARDANDO DISPONIBILIZA��O";
			break;
		case 4:
			posicao = "EXCLUIDA";
			break;
		case 5:
			posicao = "REPRESADA AGUARDANDO SOLU��O";
			break;
		case 6:
			posicao = "PARA SER DISPONIBILIZADO";
			break;
		case 7:
			posicao = "ERRO DE DISP./REALOC.";
			break;
		case 8:
			posicao = "REPETIDO(ODS)";
			break;
		case 9:
			posicao = "PARA SER REALOCADO";
			break;
		case 10:
			posicao = "N�O TRANSMITIR";
			break;
		case 11:
			posicao = "ACEITO MAINFRAME. DISPON�VEL EM CONSULTA";
			break;
		default:
			posicao = "INDEFINIDO";
			break;
		}
	return posicao;
	}
}
