import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Transferencia } from "../shared/models/transferencia";


@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {
  
  private url: string = 'http://localhost:3000/transferencias'

  transfList: Transferencia[] = [];

  constructor(private httpClient: HttpClient) {}

  salvar(transferencia: Transferencia): Observable<Transferencia> {
    if(!transferencia.id){
      return this.httpClient.post<Transferencia>(this.url, transferencia);
    }else{
      return this.httpClient.put<Transferencia>(`${this.url}/${transferencia.id}`, transferencia);
    }
  }

  listAll(): Observable<Transferencia[]> {
    return this.httpClient.get<Transferencia[]>(this.url);
  }

  getById(id: number): Observable<Transferencia> {
    return this.httpClient.get<Transferencia>(`${this.url}/${id}`);

  }

}