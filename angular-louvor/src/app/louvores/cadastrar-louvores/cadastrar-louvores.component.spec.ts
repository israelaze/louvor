import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarLouvoresComponent } from './cadastrar-louvores.component';

describe('CadastrarLouvoresComponent', () => {
  let component: CadastrarLouvoresComponent;
  let fixture: ComponentFixture<CadastrarLouvoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastrarLouvoresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastrarLouvoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
