import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AntiquesComponent } from './antiques.component';

describe('AntiquesComponent', () => {
  let component: AntiquesComponent;
  let fixture: ComponentFixture<AntiquesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AntiquesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AntiquesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
