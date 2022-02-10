import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Alunos } from './Models/Alunos';
import { AlunosService } from './Services/AlunosService';
import * as XLSX from 'xlsx';
import { write } from 'xlsx';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {
  title = 'TesteRodarteFront';

  order: string = "idade";

  displayedColumns: string[] = ['nome', 'idade', 'media'];
  dataSource: Alunos[] | null = null;
  
  constructor(
    private alunosService: AlunosService
  ) { }

  ngAfterViewInit(): void {
    this.query();
  }

  filterChange(filter: string): void {
    this.order = filter;
    this.query();
  }

  query(): void {
    this.alunosService.getAll(this.order, true).subscribe((res) => {
      if(res.body) {
        this.dataSource = res.body
      }
    });
  }

  download(): void {
    let timeSpan = new Date().toISOString();
    let prefix = "Alunos";
    let fileName = `${prefix}-${timeSpan}`;
    let targetTableElm = document.getElementById("table");
    let wb = XLSX.utils.table_to_book(targetTableElm, <XLSX.Table2SheetOpts>{ sheet: prefix });
    XLSX.writeFile(wb, `${fileName}.xlsx`);
  }
}
