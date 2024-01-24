// inverted-pyramid.component.ts

import { Component } from '@angular/core';

@Component({
  selector: 'app-inverted-pyramid',
  templateUrl: './inverted-pyramid.component.html',
  styleUrls: ['./inverted-pyramid.component.css']
})
export class InvertedPyramidComponent {
  rows: number[]=[];

  getNumbers(rowNumber: number): number[] {
    return Array.from({ length: rowNumber }, (_, index) => index + 1).reverse();
  }
}
