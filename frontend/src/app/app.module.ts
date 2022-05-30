import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app.routing.module';
import { HttpClientModule } from '@angular/common/http';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { ReactiveFormsModule } from '@angular/forms';
import { TransferenciasModule } from './transferencias/transferencias.module';

import { registerLocaleData } from '@angular/common';
import localeBr from '@angular/common/locales/pt';
registerLocaleData(localeBr, 'pt');


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    TransferenciasModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'pt-br' },
    //{ provide: LOCALE_ID, useValue: 'pt' },
  ///{ provide: MAT_DATE_LOCALE, useValue: 'pt-BR' },
  //{ provide: MAT_MOMENT_DATE_ADAPTER_OPTIONS,   useValue: { useUtc: true } }
  //{ provide: MAT_DATE_FORMATS, useValue: 'DD/MM/YYYY' },
  //{ provide: DateAdapter, useClass: MomentUtcDateAdapter },  
  ]
  ,
  bootstrap: [AppComponent]
})
export class AppModule { }
