//Módulos
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

//Rotas
const routes: Routes = [
  //(redirecionamento)
  { path: '', 
    redirectTo: 'home',  pathMatch: 'full'
  },
   //rotas filho de carregamento lento.(lazy-load)
  { path: '', 
    loadChildren: () => import('./layout/layout.module').then(m => m.LayoutModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
