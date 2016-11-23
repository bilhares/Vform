/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { IntervaloGraficoService } from './intervalo-grafico.service';

describe('Service: IntervaloGrafico', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [IntervaloGraficoService]
    });
  });

  it('should ...', inject([IntervaloGraficoService], (service: IntervaloGraficoService) => {
    expect(service).toBeTruthy();
  }));
});
