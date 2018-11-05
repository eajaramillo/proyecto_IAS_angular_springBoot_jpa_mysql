import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Ave, Zona, Busqueda } from '../ave';
import { AvesService } from '../aves.service';

@Component({
  selector: 'app-buscar-ave',
  templateUrl: './buscar-ave.component.html',
  styleUrls: ['./buscar-ave.component.css']
})
export class BuscarAveComponent implements OnInit {

  params: Busqueda = new Busqueda();
  aves: Ave[];
  cdzona: string;
  zonas: Observable<Zona[]>;

  constructor(private avesService: AvesService) { }

  ngOnInit() {
    this.avesService.getZonasList()
        .subscribe(data => {
            console.log(data);
            this.zonas = data;
        }, error => console.log(error));
  }

  private buscarAves() {
    //this.params.dsnombre_ave = this.dsnombre_ave;
    //this.params.cdzona = this.cdzona;
    this.avesService.getAvesParams(this.params)
      .subscribe(aves => this.aves = aves);
  }

  onSubmit() {
    this.buscarAves();
  }
}
