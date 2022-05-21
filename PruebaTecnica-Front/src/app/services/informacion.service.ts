import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { InformacionModel } from '../models/informacion.model';

@Injectable({
  providedIn: 'root'
})
export class InformacionService {

  url: any = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  consultarTipoDocumento(id: number){
    return this.http.get(this.url + "/tipo/" + id);
  }

  consultarTiposDocumentos(){
    return this.http.get(this.url + "/tipo");
  }

  getExisteCliente(identificacion: string){
    return this.http.get(this.url + "/cliente/existe/" + identificacion);
  }

  agregarCliente(cliente: InformacionModel){
    const data = {
                  identificacion: cliente.numeroIdentificacion,
                  id            : Number(cliente.tipoDocumento),
                  correo        : cliente.email,
                  celular       : cliente.celular
                 }

    return this.http.post(this.url + "/cliente/guardar", data);
  }

  actualizarCliente(cliente: InformacionModel){
    const data = {
                  identificacion: cliente.numeroIdentificacion,
                  id            : Number(cliente.tipoDocumento),
                  correo        : cliente.email,
                  celular       : cliente.celular
                 }

    return this.http.put(this.url + "/cliente/actualizar", data);
  }
}
