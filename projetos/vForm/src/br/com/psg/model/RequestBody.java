package br.com.psg.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestBody {
	
	@XmlElement public int isProducao;
	@XmlElement public String serie;
	@XmlElement public String grafico;
	@XmlElement public String logico;
	@XmlElement public String graficoInicial;
	@XmlElement public String graficoFinal;
	@XmlElement public String logicoInicial;
	@XmlElement public String logicoFinal;
	//pesquisas com criterios
	@XmlElement public String dataInicial;
	@XmlElement public String dataFinal;
	@XmlElement public String agenfaInicial;
	@XmlElement public String agenfaFinal;		
	
}
