 //Módulos
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

 //Componentes
import { CadastrarLouvoresComponent } from '../louvores/cadastrar-louvores/cadastrar-louvores.component';
import { ConsultarLouvoresComponent } from '../louvores/consultar-louvores/consultar-louvores.component';
import { CadastrarUsuariosComponent } from '../usuarios/cadastrar-usuarios/cadastrar-usuarios.component';
import { LoginComponent } from '../usuarios/login/login.component';
import { AuthGuard } from '../usuarios/shared/auth.guard';
import { AutenticacaoComponent } from './autenticacao/autenticacao.component';
import { HomeComponent } from './home/home.component';

//Rotas
const routes: Routes = [
  //rota pai (carrega o componente principal)
  { path: '', component: HomeComponent,
    //rotas filhas (carregam dentro do componente principal)
    children: [
      { path: 'consultar-louvores', component: ConsultarLouvoresComponent },
      { path: 'cadastrar-louvores', component: CadastrarLouvoresComponent }
    ],
    canActivate: [AuthGuard] 
  },
  { path: '', component: AutenticacaoComponent,
    children: [
      { path: 'login', component: LoginComponent },
      { path: 'cadastrar-usuarios', component: CadastrarUsuariosComponent }
    ]
  },
  
  { path: '**', redirectTo: ''}
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }

