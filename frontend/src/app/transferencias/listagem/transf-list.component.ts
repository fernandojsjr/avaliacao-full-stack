import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { TransferenciaService } from "src/app/core/transferencia.service";
import { Transferencia } from "src/app/shared/models/transferencia";

@Component({
  selector: 'app-transf-list',
  templateUrl: './transf-list.component.html',
  styleUrls: ['./transf-list.component.css']
  
})
export class TransfListComponent implements OnInit {

  dataSource: Transferencia[] = [];
  displayedColumns: string[] = ['contaOrigem', 'contaDestino', 'dataAgendamento', 'dataTransferencia', 'valorTransferencia', 'valorTaxas', 'edit', 'delete'];


  // [
  //   'Conta Origem', 'Conta Destino', 'Data Agendamento', 'Data Transferencia','Valor Transferencia', 'Valor Taxas'
  //      "contaOrigem": "000001",
  //   "contaDestino": "000008",
  //   "dataAgendamento": "2022-05-27",
  //   "dataTransferencia": "2022-06-12",
  //   "valorTransferencia": 1145.13,
  //   "valorTaxa": 1239.04,
  //   "qtdDias": 16
  // ];

  constructor(  
    private service: TransferenciaService,
    private router: Router ){

  }
  ngOnInit(): void {
    this.service.listAll().subscribe({
      next: list => {
        this.dataSource = list;
      },
      error: err => alert('Error')
    } );
  }

  novo(){
    this.router.navigateByUrl('/transferencias/cadastro/');
  }

  edit(transf: Transferencia){
    //let route = '/transferencias/cadastro/';
    //this.router.navigate([route], { queryParams: { id: transf.id } });

    this.router.navigateByUrl('/transferencias/cadastro/' + transf.id);
  }

  excluir(transf: Transferencia){
    alert(JSON.stringify(transf));

    //this.table.renderRows();
  }  

}