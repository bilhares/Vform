import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Formulario} from '../model/formulario';
@Component({
  selector: 'app-tabela-dados',
  templateUrl: './tabela-dados.component.html',
  styleUrls: ['./tabela-dados.component.css'],
  inputs: ['formulario'],//Campo para envio de dados de component pai (grafico) para filho (tabela-dados)
  outputs: ['childChange']//identifica mudanças no component pai e recebe valores
})
export class TabelaDadosComponent implements OnInit {

  formulario: Formulario; //Campo para envio de dados de component pai (grafico) para filho (tabela-dados)
  childChange = new EventEmitter<Formulario>();//identifica mudanças no component pai e recebe valores

  constructor() { }

  ngOnInit() {
  }
preencherCampos(form: Formulario) { 
     this.childChange.emit(form);
  }
}
