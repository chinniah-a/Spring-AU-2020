import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './components/signup/signup.component';
import { DisplayDataComponent } from './components/display-data/display-data.component';
import { NotFoundComponent } from './components/not-found/not-found.component';


const routes: Routes = [
  {path: 'not-found', component : NotFoundComponent},
  {path: 'form', component : SignupComponent},
  {path: 'data', component: DisplayDataComponent},
  {path: '', redirectTo:'form', pathMatch:'full'},
  {path: '**', redirectTo:'not-found', pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
