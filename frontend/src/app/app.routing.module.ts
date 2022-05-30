import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TransfCadastroComponent } from './transferencias/cadastro/transf-cadastro.component';
import { TransfListComponent } from './transferencias/listagem/transf-list.component';
import { TransferenciasModule } from './transferencias/transferencias.module';

const routes: Routes = [

  {
      path: '',
      redirectTo: 'transferencias',
      pathMatch: 'full'
  },
  {
    path: 'transferencias',
    children: [
      {
        path: 'cadastro',
        children: [
          {
            path: '',
            component: TransfListComponent
          },
          {
            path: ':id',
            component: TransfCadastroComponent
          }          
        ]
      },
      {
        path: '',
        component: TransfListComponent
      },

    ]
  },
  { path: '**', redirectTo: 'transferencia' },

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    TransferenciasModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
