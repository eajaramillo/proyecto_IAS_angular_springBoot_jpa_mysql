import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { CrearAveComponent } from './crear-ave/crear-ave.component';
import { ListarAvesComponent } from './listar-aves/listar-aves.component';
import { DetalleAveComponent } from './detalle-ave/detalle-ave.component';
import { BuscarAveComponent } from './buscar-ave/buscar-ave.component';

@NgModule({
  declarations: [
    AppComponent,
    CrearAveComponent,
    ListarAvesComponent,
    DetalleAveComponent,
    BuscarAveComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
