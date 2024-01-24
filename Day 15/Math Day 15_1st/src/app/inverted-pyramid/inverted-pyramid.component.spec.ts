// inverted-pyramid.component.spec.ts

import { TestBed, ComponentFixture } from '@angular/core/testing';
import { InvertedPyramidComponent } from './inverted-pyramid.component';

describe('InvertedPyramidComponent', () => {
  let component: InvertedPyramidComponent;
  let fixture: ComponentFixture<InvertedPyramidComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InvertedPyramidComponent],
    });

    fixture = TestBed.createComponent(InvertedPyramidComponent);
    component = fixture.componentInstance;
  });

 // inverted-pyramid.component.spec.ts

 it('should generate inverted pyramid rows', () => {
  component.rows = [5, 4, 3, 2, 1];
  fixture.detectChanges();
  const rows = fixture.nativeElement.querySelectorAll('.row');
  expect(rows.length).toBe(5);
});

});
