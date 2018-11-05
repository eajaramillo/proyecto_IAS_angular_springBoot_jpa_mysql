import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarAveComponent } from './buscar-ave.component';

describe('BuscarAveComponent', () => {
  let component: BuscarAveComponent;
  let fixture: ComponentFixture<BuscarAveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuscarAveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuscarAveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
