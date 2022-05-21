export class InformacionModel {
    tipoDocumento       : number;
    numeroIdentificacion: string;
    email               : string;
    celular             : number;

    constructor(){
    }

    setTipoDocumento(tipoDocumento: number){
      return this.tipoDocumento = tipoDocumento;
    }

    getTipoDocumento(){
      return this.tipoDocumento;
    }
    
    setNumeroIdentificacion(numeroIdentificacion: string){
      return this.numeroIdentificacion = numeroIdentificacion;
    }

    getNumeroIdentificacion(){
      return this.numeroIdentificacion;
    }

    setEmail(email: string){
      return this.email = email;
    }

    getEmail(){
      return this.email;
    }
      
    setCelular(celular: number){
      return this.celular = celular;
    }

    getCelular(){
      return this.celular;
    }
}