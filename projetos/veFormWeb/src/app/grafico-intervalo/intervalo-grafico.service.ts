import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import { Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import {Formulario} from '../model/formulario';
import { Observable }     from 'rxjs/Observable';

@Injectable()
export class IntervaloGraficoService {

  private urlBuscaIntervalo = "http://localhost:8080/vForm/rest/formulario/byIntervaloGrafico";
  private urlBuscaIntervaloData = "http://localhost:8080/vForm/rest/intervaloGCriterio/byIntervaloGraficoData";
  private urlBuscaIntervaloDataAgenfa = "http://localhost:8080/vForm/rest/intervaloGCriterio/byIntervaloGraficoDataAgenfa";
  private urlLocal = "http://localhost:8080/vForm/rest/formulario/getAll";
  constructor(private _http: Http) { }

  private extractData(res: Response) {
    let body = res.json();
    console.log("" + body);
    return body || {};
  }

  getForms(): Observable<Formulario[]> {
    return this._http.get(this.urlLocal).map(this.extractData);
  }

  buscaIntervaloGrafico(graficoInicial: string, graficoFinal: string, isProducao: number): Observable<Formulario[]> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    return this._http.post(this.urlBuscaIntervalo, { graficoInicial, graficoFinal, isProducao }, options).map(this.extractData);
  }
  buscaIntervaloData(graficoInicial: string, graficoFinal: string, isProducao: number, dataInicial: string, dataFinal: string): Observable<Formulario[]> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    return this._http.post(this.urlBuscaIntervaloData, { graficoInicial, graficoFinal, isProducao, dataInicial, dataFinal }, options).map(this.extractData);
  }
  buscaIntervaloDataAgenfa(graficoInicial: string, graficoFinal: string, isProducao: number, dataInicial: string, dataFinal: string, agenfaInicial:string, agenfaFinal:string): Observable<Formulario[]> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    return this._http.post(this.urlBuscaIntervaloDataAgenfa, { graficoInicial, graficoFinal, isProducao, dataInicial, dataFinal, agenfaInicial, agenfaFinal }, options).map(this.extractData);
  }
}
