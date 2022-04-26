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
import { CadastrarLouvoresComponent } from './louvores/cadastrar-louvores/cadastrar-louvores.component';
import { ConsultarLouvoresComponent } from './louvores/consultar-louvores/consultar-louvores.component';

@NgModule({
  declarations: [
    AppComponent,
    ConsultarLouvoresComponent,
    CadastrarLouvoresComponent
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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
