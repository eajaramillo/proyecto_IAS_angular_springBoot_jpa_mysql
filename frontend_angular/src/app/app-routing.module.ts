import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CrearAveComponent } from './crear-ave/crear-ave.component';
import { ListarAvesComponent } from './listar-aves/listar-aves.component';
import { BuscarAveComponent } from './buscar-ave/buscar-ave.component';

const routes: Routes = [
    { path: '', redirectTo: 'ave', pathMatch: 'full' },
    { path: 'ave', component: ListarAvesComponent },
    { path: 'nuevo', component: CrearAveComponent },
    { path: 'buscar', component: BuscarAveComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }