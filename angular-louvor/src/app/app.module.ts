//Módulos
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { NgxPaginationModule } from 'ngx-pagination';
import { AppRoutingModule } from './app-routing.module';

//Componentes
import { AppComponent } from './app.component';
import { AutenticacaoComponent } from './layout/autenticacao/autenticacao.component';
import { HomeComponent } from './layout/home/home.component';
import { CadastrarLouvoresComponent } from './louvores/cadastrar-louvores/cadastrar-louvores.component';
import { ConsultarLouvoresComponent } from './louvores/consultar-louvores/consultar-louvores.component';
import { CadastrarUsuariosComponent } from './usuarios/cadastrar-usuarios/cadastrar-usuarios.component';
import { LoginComponent } from './usuarios/login/login.component';

//Interceptors
import { httpInterceptorProviders } from './interceptors';

@NgModule({
  declarations: [
    AppComponent,
    CadastrarLouvoresComponent,
    ConsultarLouvoresComponent,
    HomeComponent,
    AutenticacaoComponent,
    LoginComponent,
    CadastrarUsuariosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule

  ],
  providers: [
    httpInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
