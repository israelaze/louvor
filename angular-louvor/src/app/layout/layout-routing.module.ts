 //Módulos
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

 //Componentes
import { CadastrarLouvoresComponent } from '../louvores/cadastrar-louvores/cadastrar-louvores.component';
import { ConsultarLouvoresComponent } from '../louvores/consultar-louvores/consultar-louvores.component';
import { HomeComponent } from './home/home.component';

//Rotas
const routes: Routes = [
  //rota pai (carrega o componente principal)
  { path: '', component: HomeComponent,
    //rotas filhas (carregam dentro do componente principal)
    children: [
      { path: 'consultar-louvores', component: ConsultarLouvoresComponent },
      { path: 'cadastrar-louvores', component: CadastrarLouvoresComponent }
    ] 
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
