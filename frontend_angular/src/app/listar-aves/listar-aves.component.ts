import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { AvesService } from '../aves.service';
import { Ave } from '../ave';

@Component({
  selector: 'app-listar-aves',
  templateUrl: './listar-aves.component.html',
  styleUrls: ['./listar-aves.component.css']
})
export class ListarAvesComponent implements OnInit {

  aves: Observable<Ave[]>;

  constructor(private avesService: AvesService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteAves() {
    this.avesService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.aves = this.avesService.getAvesList();
  }
}
