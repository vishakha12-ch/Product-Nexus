import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovereviewComponent } from './approvereview.component';

describe('ApprovereviewComponent', () => {
  let component: ApprovereviewComponent;
  let fixture: ComponentFixture<ApprovereviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApprovereviewComponent]
    });
    fixture = TestBed.createComponent(ApprovereviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
