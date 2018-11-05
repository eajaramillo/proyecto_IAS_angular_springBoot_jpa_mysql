import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Ave, Pais, Zona } from '../ave';
import { AvesService } from '../aves.service';

@Component({
  selector: 'crear-ave',
  templateUrl: './crear-ave.component.html',
  styleUrls: ['./crear-ave.component.css']
})
export class CrearAveComponent implements OnInit {

  ave: Ave   = new Ave();
  pais: Pais = new Pais();
  zona: Zona = new Zona();
  zonas: Observable<Zona[]>;
  submitted  = false;

  constructor(private avesService: AvesService) { }

  ngOnInit() {
    this.avesService.getZonasList()
        .subscribe(data => {
            console.log(data);
            this.zonas = data;
        }, error => console.log(error));
  }

  newAve(): void {
    this.submitted = false;
    this.ave = new Ave();
    this.pais = new Pais();
    this.zona = new Zona();
  }

  save() {
    this.avesService.crearAve(this.ave)
      .subscribe(data => console.log(data), error => console.log(error));
    this.ave = new Ave();

    this.avesService.crearPais(this.pais, this.ave.cdave)
      .subscribe(data => console.log(data), error => console.log(error));
    this.pais = new Pais();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
