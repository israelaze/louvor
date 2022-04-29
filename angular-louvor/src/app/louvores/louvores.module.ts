//Módulos
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CadastrarLouvoresComponent } from './cadastrar-louvores/cadastrar-louvores.component';
import { ConsultarLouvoresComponent } from './consultar-louvores/consultar-louvores.component';
import { LouvoresRoutingModule } from './louvores-routing.module';


@NgModule({
  declarations: [
    //ConsultarLouvoresComponent,
   // CadastrarLouvoresComponent
  ],
  imports: [
    CommonModule,
    LouvoresRoutingModule
  ]
})
export class LouvoresModule { }
