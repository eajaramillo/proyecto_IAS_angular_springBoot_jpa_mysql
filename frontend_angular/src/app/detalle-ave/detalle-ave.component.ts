import { Component, OnInit, Input } from '@angular/core';
import { AvesService } from '../aves.service';
import { Ave } from '../ave';

import { ListarAvesComponent } from '../listar-aves/listar-aves.component';

@Component({
  selector: 'app-detalle-ave',
  templateUrl: './detalle-ave.component.html',
  styleUrls: ['./detalle-ave.component.css']
})
export class DetalleAveComponent implements OnInit {

  @Input() ave: Ave;

  constructor(private avesService: AvesService, private listarAvesComponent: ListarAvesComponent) {
    //console.log(this.ave);
  }

  ngOnInit() {
  }

  updateActive(cdave: string) {
    this.avesService.updateAve(cdave,
      { cdave: this.ave.cdave, dsnombre_comun: this.ave.dsnombre_comun, dsnombre_cientifico: this.ave.dsnombre_comun })
      .subscribe(
        data => {
          console.log(data);
          this.ave = data as Ave;
        },
        error => console.log(error));
  }

  deleteAve() {
    this.avesService.deleteAve(this.ave.cdave)
      .subscribe(
        data => {
          console.log(data);
          this.listarAvesComponent.reloadData();
        },
        error => console.log(error));
  }
}
