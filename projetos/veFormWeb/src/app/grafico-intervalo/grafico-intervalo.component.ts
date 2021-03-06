import { Component, OnInit } from '@angular/core';
import {Formulario} from '../model/formulario';
import {IntervaloGraficoService} from './intervalo-grafico.service';

@Component({
  selector: 'app-grafico-intervalo',
  templateUrl: './grafico-intervalo.component.html',
  styleUrls: ['../grafico/grafico.component.css'],
  providers: [IntervaloGraficoService]
})
export class GraficoIntervaloComponent implements OnInit {
  //Campos de pesquisa com criterios
  tipoCriterio: number;
  showCriterio: boolean = false;
  showData: boolean = false;
  showAgenfa: boolean = false;
  showTipo: boolean = false;
  //serviço
  childValue: Formulario;
  errorMessage: string;
  formulario: Formulario[];
  isProducao: number;

  //variaveis para soma do criterios
  data: number = 1;
  agenfa: number = 3;
  tipoDoc: number = 5;

  //datepicker

  datepickerOpts: any = {
    startDate: new Date(1900, 5, 10),
    autoclose: true,
    todayBtn: 'linked',
    todayHighlight: true,
    assumeNearbyYear: true,
    format: 'dd/mm/yyyy'
  };

  dateFrom: Date;
  dateTo: Date;
  datepickerToOpts: any = {};
  mes: number;
  dataInicial: string;
  dataFinal: string;

  handleDateFromChange(dateFrom: Date) {
    // update the model
    this.dateFrom = dateFrom;

    // do not mutate the object or angular won't detect the changes
    this.datepickerToOpts = {
      startDate: dateFrom
    };
  }

  getDate(dt: Date): number {
    return dt && dt.getTime();
  }
  montarDataInicial(dt: Date): string {
    this.mes = dt.getMonth() + 1;
    console.log(dt.getFullYear);    
    return "0"+dt.getDate() + "/"+0+ this.mes + "/" + dt.getFullYear();
  }
  montarDataFinal(dt: Date): string {
    this.mes = dt.getMonth() + 1;
    return "0"+dt.getDate() + "/" +0+ this.mes + "/" + dt.getFullYear();
  }
  //fim date piker

  constructor(private _httpService: IntervaloGraficoService) {
    this.childValue = new Formulario();
    this.isProducao = 0;
    this.tipoCriterio = 0;
  }

  ngOnInit() {
    this.getForms();
  }
  getForms() {
    this._httpService.getForms().subscribe(formulario => this.formulario = formulario, error => this.errorMessage = <any>error);
    console.log("frm:" + this.formulario);
  }

  mostraAgenfa(agenfaInicial: string,
    agenfaFinal: string){
      console.log(agenfaInicial+" "+agenfaFinal);
      
  }

  gerenciaBusca(graficoInicial: string, graficoFinal: string, dtInicial: Date, dtFinal: Date, agenfaInicial: string,
    agenfaFinal: string, tipoDoc: string) {  
      
    switch (this.tipoCriterio) {
      case 0:
        this.buscaIntervaloGrafico(graficoInicial, graficoFinal);
        break;
      case 1:
      this.buscaIntervaloGraficoData(graficoInicial, graficoFinal, dtInicial, dtFinal);
        break;
      case 3:
       console.log(agenfaInicial, agenfaFinal);
        break;
      case 4:
        this.buscaIntervaloGraficoDataAgenfa(graficoInicial, graficoFinal, dtInicial, dtFinal, agenfaInicial, agenfaFinal);
        break;
      case 5:
        break;
      case 6:
        break;
      case 8:
        break;
      default:
        break;
    }
  }
  buscaIntervaloGrafico(graficoInicial: string, graficoFinal: string) {
    //this.criterios();
    console.log(this.tipoCriterio);

    //if (!dtInicial || !dtFinal) { return; }
   /* if (dtInicial != null && dtFinal != null) {
      this.dataInicial = this.montarDataInicial(dtInicial);
      this.dataFinal = this.montarDataFinal(dtFinal);
      console.log(this.dataInicial + "--" + this.dataFinal);
    }*/
    //if (!graficoInicial || !graficoFinal) { return; }
    if (this.isProducao == 0) {//remove o caracter do numero grafico (não necessario para produção)
      graficoInicial = graficoInicial.replace(graficoInicial[0], "");
      graficoFinal = graficoFinal.replace(graficoFinal[0], "");
      console.log(graficoInicial);
      console.log(graficoFinal);
    }
    console.log("{" + graficoInicial + " " + graficoFinal + " " + this.isProducao + " " + this.tipoCriterio + "}");
      console.log("Por intervalo");
      this._httpService.buscaIntervaloGrafico(graficoInicial, graficoFinal, this.isProducao).subscribe(formulario => this.formulario = formulario);
     /*if (this.tipoCriterio == 1) {
      console.log("com data");
      this._httpService.buscaIntervaloData(graficoInicial, graficoFinal, this.isProducao, this.dataInicial, this.dataFinal).subscribe(formulario => this.formulario = formulario);
    }*/
  }

  buscaIntervaloGraficoData(graficoInicial: string, graficoFinal: string, dtInicial: Date, dtFinal: Date) {
    if (this.isProducao == 0) {//remove o caracter do numero grafico (não necessario para produção)
      graficoInicial = graficoInicial.replace(graficoInicial[0], "");
      graficoFinal = graficoFinal.replace(graficoFinal[0], "");
    }  
    this.dataInicial = this.montarDataInicial(dtInicial);
    this.dataFinal = this.montarDataFinal(dtFinal);
    console.log(this.dataInicial + "--" + this.dataFinal);
    console.log("{" + graficoInicial + " " + graficoFinal + " " + this.isProducao + " " + this.tipoCriterio +" "+this.dataInicial+" "+this.dataFinal+"}");
    this._httpService.buscaIntervaloData(graficoInicial, graficoFinal, this.isProducao, this.dataInicial, this.dataFinal).subscribe(formulario => this.formulario = formulario);
  }

  buscaIntervaloGraficoDataAgenfa(graficoInicial: string, graficoFinal: string, dtInicial: Date, dtFinal: Date, 
  agenfaInicial:string, agenfaFinal:string) {

    if (this.isProducao == 0) {//remove o caracter do numero grafico (não necessario para produção)
      graficoInicial = graficoInicial.replace(graficoInicial[0], "");
      graficoFinal = graficoFinal.replace(graficoFinal[0], "");
    }  

    this.dataInicial = this.montarDataInicial(dtInicial);
    this.dataFinal = this.montarDataFinal(dtFinal);

    console.log(this.dataInicial + "--" + this.dataFinal);
    console.log("{" + graficoInicial + " " + graficoFinal + " " + this.isProducao + " " + this.tipoCriterio +" "+this.dataInicial+" "+this.dataFinal+" "+agenfaInicial+" "+agenfaFinal+"}");
    this._httpService.buscaIntervaloDataAgenfa(graficoInicial, graficoFinal, this.isProducao, this.dataInicial, this.dataFinal, agenfaInicial, agenfaFinal).subscribe(formulario => this.formulario = formulario);
  }
  //verifica se é pesquisa em produção
  verifyCheckProd(event) {
    if (event.target.checked) {
      this.isProducao = 1;
      console.log("check" + this.isProducao);
    } else {
      this.isProducao = 0;
      console.log("uncheck" + this.isProducao);
    }
  }
  //mostra os checkbox's para criterios
  showCriterios(event) {
    if (event.target.checked) {
      this.showCriterio = true;
    }
    else {
      this.tipoCriterio = 0;
      this.showData = false;
      this.showAgenfa = false;
      this.showTipo = false;
      this.showCriterio = false;
    }
  }
  //ativa os campos de criterios
  activeData(event) {
    if (event.target.checked) {
      this.showData = true;
      this.tipoCriterio = this.tipoCriterio + this.data;
    } else {
      this.tipoCriterio = this.tipoCriterio - this.data;
      this.showData = false;
    }
  }
  activeAgenfa(event) {
    if (event.target.checked) {
      this.showAgenfa = true;
      this.tipoCriterio = this.tipoCriterio + this.agenfa;
    } else {
      this.tipoCriterio = this.tipoCriterio - this.agenfa;
      this.showAgenfa = false;
    }
  }
  activeTipo(event) {
    if (event.target.checked) {
      this.showTipo = true;
      this.tipoCriterio = this.tipoCriterio + this.tipoDoc;
    } else {
      this.tipoCriterio = this.tipoCriterio - this.tipoDoc;
      this.showTipo = false;
    }
  }
}
