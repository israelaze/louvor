import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Louvor } from '../shared/louvor';
import { LouvoresService } from '../shared/louvores.service';

@Component({
  selector: 'app-consultar-louvores',
  templateUrl: './consultar-louvores.component.html',
  styleUrls: ['./consultar-louvores.component.css']
})
export class ConsultarLouvoresComponent implements OnInit {

  //atributos
  mensagemSucessoExclusao = '';
  mensagemErroExclusao = '';

  mensagemSucessoEdicao= '';
  mensagemErroEdicao = '';

  //defini o campo de pesquisa como uma string vazia
  pesquisa = "";

  //armazena a página atual do componente de paginação
  page = 1;

  //atributo para armazenar os dados de apenas 1 louvor
  louvor = {
    id: 0,
    nome: '',
    artista: '',
    album: '',
    anoLancamento: 0,
    letra: '',
    cifra: '',
    youtube: ''
  }

  //atributo para armazenar a listagem de louvores
  louvores: Louvor[] = [];

  // INJEÇÃO DE DEPENDÊNCIA
  constructor(private louvoresService: LouvoresService) { }

  //objeto para capturar os campos do formulário
  formEdicao = new FormGroup({

    //declarando o campo 'id' do formulário
    id: new FormControl([]),

    //declarando o campo 'nome' do formulário
    nome: new FormControl('', [
      Validators.required, //torna o campo obrigatório
      Validators.pattern(/\b[A-Za-zÀ-ú\\s]{2,50}\b/)

    ]),

    //declarando o campo 'artista' do formulário
    artista: new FormControl('', [
      Validators.required, //torna o campo obrigatório
      Validators.pattern(/^\s*\S+.*/)

    ]),

    //declarando o campo 'album' do formulário
    album: new FormControl('', []),

    //declarando o campo 'ano' do formulário
    anoLancamento: new FormControl('', [
      Validators.pattern('^[0-9]{1,9}$')
    ]),

    //declarando o campo 'letra' do formulário
    letra: new FormControl('', []),

    //declarando o campo 'cifra' do formulário
    cifra: new FormControl('', []),

    //declarando o campo 'youtube' do formulário
    youtube: new FormControl('', [])

  });

  //criando um objeto pra utilizar o formulário na página
  get form(): any {
    return this.formEdicao.controls;
  }

  //FUNÇÃO EXECUTADA QUANDO O COMPONENTE É CARREGADO
  ngOnInit(): void {
    this.buscarTodas();
  }

  // BUSCAR TODOS
  buscarTodas(): void {
    this.louvoresService
      .buscarTodas()
      .subscribe(louvores => (this.louvores = louvores as any, console.log(louvores)), e => (console.log(e.error)));
  }

  // BUSCAR ID
  buscarId(id: number): void {

    // limpando mensagens
    this.mensagemSucessoExclusao = '';
    this.mensagemErroExclusao = '';

    this.mensagemSucessoEdicao= ''
    this.mensagemErroEdicao = '';

    this.louvoresService
      .buscarId(id)
      .subscribe(louvor => (this.louvor = louvor as any), e => (console.log(e.error)));
  }

  // ATUALIZAR
  atualizar(): void {
    this.louvoresService
      .atualizar(this.formEdicao.value)
      .subscribe(
        (louvor) => {
          console.log(louvor);
          this.louvor = louvor as any;
          this.mensagemSucessoEdicao = 'ok'; //inicializando a variável
          this.ngOnInit();
        },
        (e) => {
          console.log(e.error)
          this.mensagemErroEdicao = e.error.message;
          this.ngOnInit();
        }
      )
  }

  // EXCLUIR
  excluir(id: number): void {
    this.louvoresService.excluir(id)
      .subscribe(
        (data) => {
          console.log(data);
          this.mensagemSucessoExclusao = data;
          this.ngOnInit();
        },
        (e) => {
          console.log(e.error)
          this.mensagemErroExclusao = 'Música não encontrada';

        }
      )
  }

  // PAGINAÇÃO
  handlePageChange(event: number) {
    this.page = event;
  }
}
