import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarLouvoresComponent } from './consultar-louvores.component';

describe('ConsultarLouvoresComponent', () => {
  let component: ConsultarLouvoresComponent;
  let fixture: ComponentFixture<ConsultarLouvoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultarLouvoresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultarLouvoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
