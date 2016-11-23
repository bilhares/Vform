import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule }   from '@angular/router';
import { NKDatetimeModule } from 'ng2-datetime/ng2-datetime';

import { AppComponent } from './app.component';
import {HomeComponent} from './home/home.component';
import { GraficoComponent } from './grafico/grafico.component';
import { TabelaDadosComponent } from './tabela-dados/tabela-dados.component';
import { FormularioDadosComponent } from './formulario-dados/formulario-dados.component';
import { GraficoIntervaloComponent } from './grafico-intervalo/grafico-intervalo.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    GraficoComponent,
    TabelaDadosComponent,
    FormularioDadosComponent,
    GraficoIntervaloComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NKDatetimeModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'home', component: HomeComponent },
      { path: 'grafico', component: GraficoComponent },
      {path: 'intervalo-grafico', component:GraficoIntervaloComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
