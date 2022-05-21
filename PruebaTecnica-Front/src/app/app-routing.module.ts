import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InformacionComponent } from './components/informacion/informacion.component';

const routes: Routes = [
  { path: 'informacion', component: InformacionComponent },
  { path: '**', redirectTo: 'informacion' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash:true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
