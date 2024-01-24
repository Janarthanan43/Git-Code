import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  public studentDetails: any[];
  public newStudent = { name: '', age: null, subject: '' };
  public selectedStudent: any = null;

  constructor() {
    this.studentDetails = [
      { name: 'Jana', age: 25, subject: 'Science' }
    ];
  }

  addStudent() {
    this.studentDetails.push(this.newStudent);
    this.newStudent = { name: '', age: null, subject: '' };
  }
  ngOnInit(): void {
  }

}
