import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs';
import { Ave, Busqueda } from './ave';

@Injectable({
  providedIn: 'root'
})
export class AvesService {

  private backend = 'http://localhost:8080/api';
  private baseUrl = this.backend+'/aves';
  private baseUrlZonas = this.backend+'/zonas';
  private baseUrlPaises = this.backend+'/paises';

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  getAve(cdave: String): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${cdave}`);
  }

  crearAve(ave: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/crear`, ave);
  }

  updateAve(cdave: String, ave: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${cdave}`, ave);
  }

  deleteAve(cdave: String): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${cdave}`, { responseType: 'text' });
  }

  getAvesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getAvesParams(params: Busqueda): Observable<any> {
    return this.http.post(`${this.baseUrl}/buscar/list`, params, {headers: this.headers});
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  getZonasList(): Observable<any> {
    return this.http.get(`${this.baseUrlZonas}` + `/listar`);
  }

  getZona(cdzona: string): Observable<any> {
    return this.http.get(`${this.baseUrlZonas}` + `/${cdzona}`);
  }

  crearPais(pais: Object, cdave: string): Observable<Object> {
    return this.http.post(`${this.baseUrlPaises}` + `/crear/${cdave}`, pais);
  }
}
