import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PerfilComponent } from './pages/perfil/perfil.component';
import { CarrinhoComponent } from './pages/carrinho/carrinho.component';
import { PizzasComponent } from './pages/pizzas/pizzas.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' }, 
    { path: 'perfil', component: PerfilComponent },
    { path: 'carrinho', component: CarrinhoComponent },
    { path: 'pizzas', children: [
        {path: '', component: PizzasComponent},
        {path: 'cadastro', component: CadastroComponent}
    ]},
];
