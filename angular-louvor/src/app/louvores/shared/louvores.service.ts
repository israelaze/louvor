import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Louvor } from './louvor';

@Injectable({
  providedIn: 'root'
})
export class LouvoresService {

   // URL API WEB
  endpoint = environment.baseUrl + "/musicas";

  // INJEÇÃO DE DEPENDÊNCIA
  constructor(private httpClient: HttpClient) { }

  // CADASTRAR
  cadastrar(louvor: Louvor): Observable<Louvor>{
    return this.httpClient.post<Louvor>(this.endpoint, louvor);
  }

  //BUSCAR TODAS
  buscarTodas(): Observable<Louvor[]>{
    return this.httpClient.get<Louvor[]>(this.endpoint);
  }

  // BUSCAR ID
  buscarId(id: number): Observable<Louvor> {
    return this.httpClient.get<Louvor>(this.endpoint + '/' + id);
  }

  // ATUALIZAR
  atualizar(louvor: Louvor): Observable<Louvor> {
    return this.httpClient.put<Louvor>(this.endpoint, louvor);
  }

  // EXCLUIR
  excluir(id: number) {
    return this.httpClient.delete(this.endpoint + '/' + id, {responseType: 'text'})
  }
}
