import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AskreviewComponent } from './askreview.component';

describe('AskreviewComponent', () => {
  let component: AskreviewComponent;
  let fixture: ComponentFixture<AskreviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AskreviewComponent]
    });
    fixture = TestBed.createComponent(AskreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
