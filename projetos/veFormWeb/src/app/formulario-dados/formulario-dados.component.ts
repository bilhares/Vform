import { Component, OnInit, Input } from '@angular/core';
import {Formulario} from '../model/formulario';

@Component({
  selector: 'app-formulario-dados',
  templateUrl: './formulario-dados.component.html',
  styleUrls: ['../grafico/grafico.component.css'],
  inputs: ['formulario']
})
export class FormularioDadosComponent implements OnInit {
  formulario: Formulario;
  constructor() {
    this.formulario = new Formulario();
  }

  ngOnInit() {
  }
  preencher(form: Formulario) {
    this.formulario = form;
    console.log(form.grafico);
    console.log(this.formulario.grafico);
  }

}
