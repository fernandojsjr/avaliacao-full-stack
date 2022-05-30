import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { TransferenciaService } from "src/app/core/transferencia.service";
import { Transferencia } from "src/app/shared/models/transferencia";
import { AlertaComponent } from 'src/app/shared/components/alerta.component';
import { MatDialog } from "@angular/material/dialog";
import { ActivatedRoute, Router } from "@angular/router";
import { MAT_DATE_FORMATS } from "@angular/material/core";

import * as moment from 'moment';
import { ArgumentOutOfRangeError } from "rxjs";
import { TestBed } from "@angular/core/testing";
import { NodeWithI18n } from "@angular/compiler";
import { formatDate } from "@angular/common";
import { Alerta } from "src/app/shared/models/alerta";

export const MY_DATE_FORMATS = {
  parse: {
    dateInput: 'DD/MM/YYYY',
  },
  display: {
    dateInput: 'DD/MM/YYYY',
    monthYearLabel: 'MMMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY'
  },
};

@Component({
  selector: 'app-transf-cadastro',
  templateUrl: './transf-cadastro.component.html',
  styleUrls: ['./transf-cadastro.component.css'],
  providers: [{
    provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS }
  ]
})
export class TransfCadastroComponent implements OnInit {

  transf?: Transferencia;
  cadastro?: Transferencia;
  cadastroForm: FormGroup;
  transfId?: number | null;

  constructor(
      public dialog: MatDialog,
      private activatedRoute : ActivatedRoute,
      private fb: FormBuilder, 
      private service: TransferenciaService,
      private router: Router
    ){ 

      //let agora = moment();
      //console.log('Data hoje: ' + agora);
      // console.log('Data format: ' + agora.format());
      // console.log('Add: ' + agora.add(7, 'days').format('DD/MM/YYYY'));

    this.cadastroForm = this.fb.group({
  
      contaOrigem: ['',  [Validators.required, Validators.minLength(6)]],
      contaDestino: ['', [Validators.required, Validators.minLength(6)]],
      dataAgendamento: [{ value: '', disabled:true }, []],
      dataTransferencia: ['', [Validators.required]],
      valorTransferencia: ['', [Validators.required]],
    })
  }

  ngOnInit(): void {

    const param = this.activatedRoute.snapshot.paramMap.get('id'); // pode retornar null

    this.transfId = param?+param:0;
    this.service.getById(this.transfId).subscribe({
      next: (cadastro) => {
        //alert(JSON.stringify(cadastro));
        this.criarFormulario(cadastro);
      },
      error: (err) => {
        console.log('Error', err)
        this.criarFormulario(this.criarFormularioVazio());
      }
    });    

  }

  submit(): void {
    if(this.cadastroForm.invalid){
      return;
    }

    const transf = this.cadastroForm.getRawValue() as Transferencia;
    
    this.salvar(transf);
  }

  resetForm(): void {
    this.cadastroForm.reset();
  }

  private salvar(transf: Transferencia): void{

    const config = {
      width: 'auto',
      data: {
        btnCancelar: 'Cadastrar um novo filme',
        possuirBtnFechar: true,
        corBtnCancelar: 'primary'
      } as Alerta
    };

    this.service.salvar(transf).subscribe({
      next: transf => {
        const dialogRef = this.dialog.open( AlertaComponent, config );

        console.log(dialogRef.afterClosed().subscribe((opcao: boolean) => {
          if (opcao){
            this.router.navigateByUrl('transferencias/list');
          }else{
            this.resetForm();
          }
        }))
      },
      error: err => alert('ERRO AO TENTAR GRAVAR')
    });
  }

  private criarFormulario(transf : Transferencia): void {

    console.log('TESTE: ' + new Date('2022-05-28'));
    
    let teste = new Date(transf.dataTransferencia!);
    teste.setMinutes( teste.getMinutes() + teste.getTimezoneOffset() );
    

    console.log('teste: ' + teste);

    //const d = new Date(teste);
    //d.setMinutes( d.getMinutes() + d.getTimezoneOffset() );
    
    //const dta = moment.now();
    


    this.cadastroForm = this.fb.group({
      id: [transf.id, []],
      contaOrigem: [transf.contaOrigem, [Validators.required, Validators.minLength(6)]],
      contaDestino: [transf.contaDestino, [Validators.required, Validators.minLength(6)]],
      dataAgendamento: [{value:formatDate(transf.dataAgendamento, 'dd/MM/YYYY', 'pt'), disabled:true}, []],
      dataTransferencia: [transf.dataTransferencia, [Validators.required]],
      valorTransferencia: [transf.valorTransferencia, [Validators.required]]
    });
  }

  private criarFormularioVazio(): Transferencia {
    return {
      id: undefined,
      contaOrigem: undefined,
      contaDestino: undefined,
      dataAgendamento: undefined!,
      dataTransferencia: undefined,
      valorTransferencia: undefined,
      valorTaxa: undefined,
      qtdDias: undefined
    }
  }

}