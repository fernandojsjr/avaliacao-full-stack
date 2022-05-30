
  
import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http'
import { ReactiveFormsModule, FormsModule } from '@angular/forms';



// import { CadastroFilmesComponent } from './cadastro-filmes/cadastro-filmes.component';
import { MaterialModule } from '../shared/material/material.module';
import { TransfCadastroComponent } from './cadastro/transf-cadastro.component';
import { TransfListComponent } from './listagem/transf-list.component';
import { AlertaComponent } from 'src/app/shared/components/alerta.component'



@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  declarations: [TransfCadastroComponent, TransfListComponent, AlertaComponent]
})
export class TransferenciasModule{}