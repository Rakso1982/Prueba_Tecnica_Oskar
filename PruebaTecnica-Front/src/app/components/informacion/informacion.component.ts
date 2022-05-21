import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { InformacionService } from '../../services/informacion.service';
import { InformacionModel } from '../../models/informacion.model';

@Component({
  selector: 'app-productos',
  templateUrl: './informacion.component.html',
  styleUrls: ['./informacion.component.css']
})
export class InformacionComponent implements OnInit {

  formInformacion: FormGroup;
  crearClienteModelo: InformacionModel = new InformacionModel();
  listaTipoDocumento:Array<any> = [];
  existeCliente:boolean;

  constructor(private fb: FormBuilder,
              private router:Router,
              private informacionService:InformacionService) { 
    this.crearFormulario();
    this.formInformacion.reset();
  }

  ngOnInit(): void {
    this.tipoDocumentos();
  }

  crearFormulario(){
    this.formInformacion = this.fb.group({
      tipoDocumento:        ['', [ Validators.required]],
      numeroIdentificacion: ['', [ Validators.required, Validators.maxLength(10)]],
      email:                ['', [ Validators.required, Validators.pattern('([a-z0-9._%+-]*)+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      celular:              ['', [ Validators.required, Validators.minLength(10), Validators.pattern('([3])([0-9]*)')]],
    }
    );
  }

  tipoDocumentos(){
    this.informacionService.consultarTiposDocumentos()
        .subscribe( (tipos:any) => {
                                      this.listaTipoDocumento = tipos;
                                   }
                  )
  }

  getExisteCliente(){
    this.informacionService.getExisteCliente(this.crearClienteModelo["numeroIdentificacion"])
        .subscribe( (existe:boolean) => {
                                      this.crearClienteModelo = this.formInformacion.value;
                                      if(existe["Existe"]){
                                        this.informacionService.actualizarCliente(this.crearClienteModelo)
                                                               .subscribe( resp => {   
                                                                  console.log(resp);                                
                                                                  alert("Proceso finalizado correctamente.");
                                                                  this.crearFormulario();
                                                                  this.formInformacion.reset();
                                                                });
                                      }
                                      else{
                                        this.informacionService.agregarCliente(this.crearClienteModelo)
                                                               .subscribe( resp => {   
                                                                  console.log(resp);                                
                                                                  alert("Proceso finalizado correctamente.");
                                                                  this.crearFormulario();
                                                                  this.formInformacion.reset();
                                                                });
                                      }
                                    }
                  )
  }

  guardar() {
    if (this.formInformacion.invalid){
      return Object.values( this.formInformacion.controls ).forEach( control => {
        if ( control instanceof FormGroup ) {
          Object.values( control.controls ).forEach( control => control.markAsTouched() );
        } else {
          control.markAsTouched();
        }
      });
    }
    else{
      this.getExisteCliente();   
    }
  }

  get tipoDocumentoNoValido(){
    return this.formInformacion.get('tipoDocumento').invalid && this.formInformacion.get('tipoDocumento').touched
  }

  get numeroIdentificacionNoValido(){
    return this.formInformacion.get('numeroIdentificacion').invalid && this.formInformacion.get('numeroIdentificacion').touched
  }

  get emailNoValido(){
    return this.formInformacion.get('email').invalid && this.formInformacion.get('email').touched
  }

  get celularNoValido(){
    return this.formInformacion.get('celular').invalid && this.formInformacion.get('celular').touched
  }

}
