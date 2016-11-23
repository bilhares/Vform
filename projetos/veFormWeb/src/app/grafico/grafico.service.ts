import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import { Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import{Formulario} from '../model/formulario';
import { Observable }     from 'rxjs/Observable';

@Injectable()
export class GraficoService {
  private urlBuscaGrafico = "http://localhost:8080/vForm/rest/formulario/byGrafico"; 
  private urlLocal = "http://localhost:8080/vForm/rest/formulario/getAll";
  constructor(private _http: Http) { }

   private extractData(res: Response) {
    let body = res.json();
    console.log("" + body);
    return body || {};
  }

   buscaGrafico(grafico: string, serie:string, isProducao:number): Observable<Formulario[]> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
      return this._http.post(this.urlBuscaGrafico, { grafico, serie, isProducao}, options).map(this.extractData);
  }
  getForms(): Observable<Formulario[]> {
    return this._http.get(this.urlLocal).map(this.extractData);
  }
}
