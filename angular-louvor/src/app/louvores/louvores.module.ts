import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LouvoresRoutingModule } from './louvores-routing.module';
import { CadastrarLouvoresComponent } from './cadastrar-louvores/cadastrar-louvores.component';
import { ConsultarLouvoresComponent } from './consultar-louvores/consultar-louvores.component';


@NgModule({
  declarations: [
    CadastrarLouvoresComponent,
    ConsultarLouvoresComponent
  ],
  imports: [
    CommonModule,
    LouvoresRoutingModule
  ]
})
export class LouvoresModule { }
