import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { LouvoresService } from '../shared/louvores.service';

@Component({
  selector: 'app-cadastrar-louvores',
  templateUrl: './cadastrar-louvores.component.html',
  styleUrls: ['./cadastrar-louvores.component.css']
})
export class CadastrarLouvoresComponent {

  //atributos (campos)
  mensagemSucesso = '';
  mensagemErro = '';

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
  
  //inicialização por meio de injeção de dependencia
  constructor(private formBuilder: FormBuilder, private louvoresService: LouvoresService) { }

  //objeto para capturar os campos do formulário
  formCadastro = this.formBuilder.group({

    //declarando o campo 'nome' do formulário
    nome: ['', 
      [Validators.required, 
      Validators.pattern(/\b[A-Za-zÀ-ú\\s]{2,50}\b/) 
      ] 
    ],

    //declarando o campo 'artista' do formulário
    artista: ['',
      [Validators.required,
      Validators.pattern(/^\s*\S+.*/)
      ]
    ],
    
    //declarando o campo 'album' do formulário
    album: [''],

    //declarando o campo 'ano' do formulário
    anoLancamento: ['', Validators.pattern('^[0-9]{1,9}$')],

    //declarando o campo 'letra' do formulário
    letra: [''],

    //declarando o campo 'cifra' do formulário
    cifra: [''],

    //declarando o campo 'ano' do formulário
    youtube: ['']

  });

  //criando um objeto pra utilizar o formulário na página
  get form(): any {
    return this.formCadastro.controls;
  }

  //CADASTRAR
  cadastrar(): void {

    //limpar o conteúdo ds mensagens (sucesso ou erro)
    this.mensagemSucesso = '';
    this.mensagemErro = '';

    this.louvoresService.cadastrar(this.formCadastro.value)
      .subscribe(
        (data) => {
          console.log(data)
          this.louvor = data as any;
          this.mensagemSucesso = 'Ok'; //incializando a variável
          this.formCadastro.reset();
        },
        (e) => {
          console.log(e.error)
          this.mensagemErro = e.error.message;
        }
      )
  }

}
