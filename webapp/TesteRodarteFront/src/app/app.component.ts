import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Alunos } from './Models/Alunos';
import { AlunosService } from './Services/AlunosService';
import * as XLSX from 'xlsx';
import { write } from 'xlsx';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {
  title = 'TesteRodarteFront';

  displayedColumns: string[] = ['identificacao', 'nome', 'media'];
  dataSource: Alunos[] | null = null;
  
  constructor(
    private alunosService: AlunosService
  ) { }

  ngAfterViewInit(): void {
      this.alunosService.getAll("nome", true).subscribe((res) => {
        if(res.body) {
          this.dataSource = res.body
        }
      });
  }
}
