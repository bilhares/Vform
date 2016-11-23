import { Component, OnInit, Injectable} from '@angular/core';
import { GraficoService } from './grafico.service';
import {Formulario} from '../model/formulario';

@Component({
  selector: 'app-grafico',
  templateUrl: './grafico.component.html',
  styleUrls: ['./grafico.component.css'],
  providers: [GraficoService]
})
export class GraficoComponent implements OnInit {
  childValue: Formulario; //dados de envio para classe filho(tabela)
  //service 
  serie: string;
  isProducao: number;
  formulario: Formulario[];

  constructor(private _httpService: GraficoService) {
    this.childValue = new Formulario();
    this.isProducao = 0;
  }
  ngOnInit() {
    this.getForms();
  }
  /**
   * Verificação de busca por produção
   */
  verifyCheck(event) {
    if (event.target.checked) {
      this.isProducao = 1;
      console.log("check" + this.isProducao);
    } else {
      this.isProducao = 0;
      console.log("uncheck" + this.isProducao);
    }
  }
  /**
   * Método de busca por grafico em produção ou não
   */
  buscaGrafico(grafico: string) {

    grafico = grafico.toUpperCase();
    //separa o primeiro caracter do numero grafico, correspondente a série do formulario
    if (grafico[0] == "A") {
      this.serie = "65";
    } else {
      this.serie = "66";
    }
    if (this.isProducao == 0)//remove o caracter do numero grafico (não necessario para produção)
      grafico = grafico.replace(grafico[0], "");

    if (!grafico) { return; }//caso o campo de pesquisa esteja vazio
    this._httpService.buscaGrafico(grafico, this.serie, this.isProducao).subscribe(formulario => this.formulario = formulario);
  }
  //metodo de teste para busca de formulários no webservice sem parametros
  getForms() {
    this._httpService.getForms().subscribe(formulario => this.formulario = formulario);
    console.log("frm:" + this.formulario);
  }
}
