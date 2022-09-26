import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminComponent } from './admin/admin.component';
import { DetailsComponent } from './details/details.component';
import { EditComponent } from './edit/edit.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {"path":"user",component:UserComponent},
  {"path":"admin",component:AdminComponent},
  {"path":"adminLogin",component:AdminLoginComponent},
  {"path":"details/:id",component:DetailsComponent},
  {"path":"edit/:id",component:EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
