import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PerfilComponent } from './pages/perfil/perfil.component';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' }, 
    { path: 'perfil', component: PerfilComponent },
];
